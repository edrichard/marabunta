package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.nest.AntCount;
import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;

public class NestStrategy1 extends NestStrategy {
	
	public static final int ANT_MAXNB = 40;
	public static final int STOCK_MIN = 50;
	public static final int STOCK_STEP1 = 4000;
	public static final int STOCK_STEP2 = 10000;
	

	public void process(InputNest input) {

		NestMemory mem = input.getMemory();
		int stock = input.getStock();
		
		int t1 = mem.getM0();
		
		setMemory(t1+1);
		
		
		AntCount antCount = input.getExistingAntType();
		if(antCount!=null && antCount.getQuantity()>0) {
			_antOut(antCount.getType(),0,0,0);
			return;
		}
		
		if(stock<STOCK_MIN) return;
		
		if(t1<ANT_MAXNB) {
			if(t1==1) Debug.d("_newAnt de 1");
			_newAnt(t1);
			return;
		}
		
//		if(stock>=STOCK_STEP1 && stock<STOCK_STEP2) {
//			if(t1%15==0) _newAnt(1);
//			return;
//		}
//		
//		if(stock>=STOCK_STEP2) {
//			if(t1%30==0) _newAnt(1);
//			return;
//		}
	}

}
