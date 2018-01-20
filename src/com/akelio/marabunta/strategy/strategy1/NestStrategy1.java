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
		
		setMemory(t);
		
		AntCount antCount = input.getExistingAntType();
		if(antCount!=null) {
			_antOut(antCount.getType(),0,1,0);
			return;
		}
		
		if(input.getStock()>50) {
			_newAnt(t%255);
			return;
		}
	}

}
