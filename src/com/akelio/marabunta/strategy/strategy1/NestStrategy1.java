package com.akelio.marabunta.strategy.strategy1;

import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;
import com.akelio.marabunta.strategy.NestStrategy;

public class NestStrategy1 extends NestStrategy {

	public void process(InputNest input) {
		
		NestMemory mem = input.getMemory();
		
		int t = mem.getM0()+1;
		
		if(t==1) _newAnt(1);
		else if(t==2) _antOut(1,0,1,0);
		
		setMemory(t);
	}

}
