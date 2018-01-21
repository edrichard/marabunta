package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.nest.AntCount;
import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;

public class NestStrategy1 extends NestStrategy {
	
	public static final int ANT_MAXNB = 20;
	public static final int ANT_MAXNB2 = 60;
	public static final int STOCK_MIN = 50;
	

	public void process(InputNest input) {

		Debug.d("NestStrategy1:process");
		NestMemory mem = input.getMemory();
		int t = mem.getM0();
		int c = mem.getM1();
		
		if(!input.getAntIns().isEmpty()) {
			c++;
			setMemory(t+1,c);
		}
		
		int maxCreation = c==0 ? ANT_MAXNB : ANT_MAXNB2;
		
		AntCount antCount = input.getExistingAntType();
		if(antCount!=null && antCount.getQuantity()>0) {
			Debug.d("performing _antOut");
			_antOut(antCount.getType(),5,0,0);
			return;
		}
		
		if(t<maxCreation && input.getStock()>STOCK_MIN) {
			Debug.d("_newAnt");
			setMemory(t+1,c);
			_newAnt(t);
			return;
		}
	}

}
