package com.akelio.marabunta.strategy;

import com.akelio.marabunta.input.nest.AntCount;
import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;

public class NestStrategy1 extends NestStrategy {
	
	public static final int ANT_MAXNB = 30;
	public static final int STOCK_MIN = 50;
	public static final int STOCK_STEP1 = 4000;
	public static final int STOCK_STEP2 = 8000;
	

	public void process(InputNest input) {

		NestMemory mem = input.getMemory();
		int stock = input.getStock();
		
		int t = mem.getM0();
		setMemory(t+1);
		
		AntCount antCount = input.getExistingAntType();
		if(antCount!=null && antCount.getQuantity()>0) {
			_antOut(antCount.getType(),0,0,0);
			return;
		}
		
		if(stock<STOCK_MIN) return;
		
		if(t<ANT_MAXNB) {
			_newAnt(t);
			return;
		}
		
		if(stock>=STOCK_STEP1 && stock<STOCK_STEP2) {
			if(t%15==0) _newAnt(t);
			return;
		}
		
		if(stock>=STOCK_STEP2) {
			if(t%30==0) _newAnt(t);
			return;
		}
	}

}
