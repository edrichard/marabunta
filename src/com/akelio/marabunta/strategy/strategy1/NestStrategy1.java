package com.akelio.marabunta.strategy.strategy1;

import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;
import com.akelio.marabunta.strategy.NestStrategy;

public class NestStrategy1 extends NestStrategy {

	public void process(InputNest input) {
		
		NestMemory mem = input.getMemory();
		
		int t = mem.getM0()+1;
		
		switch(t) {
			case 1:_newAnt(1);
			case 2:_antOut(1,0,1,0);

			case 3:_newAnt(2);
			case 4:_antOut(2,0,1,0);

			case 5:_newAnt(3);
			case 6:_antOut(3,0,1,0);

			case 7:_newAnt(4);
			case 8:_antOut(4,0,1,0);

			case 9:_newAnt(5);
			case 10:_antOut(5,0,1,0);

			case 11:_newAnt(6);
			case 12:_antOut(6,0,1,0);

			case 13:_newAnt(7);
			case 14:_antOut(7,0,1,0);

			case 15:_newAnt(8);
			case 16:_antOut(8,0,1,0);

			case 17:_newAnt(9);
			case 18:_antOut(9,0,1,0);
		}
		
		setMemory(t);
	}

}
