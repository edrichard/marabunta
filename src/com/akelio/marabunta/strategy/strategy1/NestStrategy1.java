package com.akelio.marabunta.strategy.strategy1;

import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.strategy.NestStrategy;

public class NestStrategy1 extends NestStrategy {

	public void process(InputNest input) {
		
		input.getMemory();
	}

}