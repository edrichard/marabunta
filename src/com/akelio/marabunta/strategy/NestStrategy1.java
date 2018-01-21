package com.akelio.marabunta.strategy;

import com.akelio.marabunta.input.nest.AntCount;
import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;

public class NestStrategy1 extends NestStrategy {
	
	public static final int ANT_MAXNB = 1;
	public static final int STOCK_MIN = 50;
	

	public void process(InputNest input) {

		NestMemory mem = input.getMemory();
		int t = mem.getM0();
		int c = mem.getM1();
		
		
		AntCount antCount = input.getExistingAntType();
		if(antCount!=null && antCount.getQuantity()>0) {
			_antOut(antCount.getType(),0,0,0);
			return;
		}
		
		if(t<ANT_MAXNB && input.getStock()>STOCK_MIN) {
			setMemory(t+1,c);
			_newAnt(t);
			return;
		}
	}

}
