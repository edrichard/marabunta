package com.akelio.marabunta.strategy.strategy1;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.nest.AntCount;
import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;
import com.akelio.marabunta.strategy.NestStrategy;

public class NestStrategy1 extends NestStrategy {

	public void process(InputNest input) {

		Debug.d("NestStrategy1:process");
		NestMemory mem = input.getMemory();
		
		int t = mem.getM0()+1;
		Debug.d("t="+t);
		
		if(t<256)
		setMemory(t);
		
		if(t==1) {
			_newAnt(1);return;
		}
		if(t==2) {
			_antOut(1,0,0,0);return;
		}
		
//		AntCount antCount = input.getExistingAntType();
//		Debug.d("antCount="+antCount);
//		if(antCount!=null && antCount.getQuantity()>0) {
//			Debug.d("performing _antOut");
//			_antOut(antCount.getType(),5,0,0);
//			return;
//		}
//
//		Debug.d("nest stock: "+input.getStock());
//		if(input.getStock()>50) {
//			Debug.d("_newAnt");
//			_newAnt(t%256);
//			return;
//		}
	}

}
