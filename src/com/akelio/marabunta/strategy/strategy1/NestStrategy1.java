package com.akelio.marabunta.strategy.strategy1;

import com.akelio.marabunta.Debug;
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
		
		switch(t) {
			case 1:_newAnt(1);break;
			case 2:_antOut(1,0,1,0);break;

			case 3:_newAnt(2);break;
			case 4:_antOut(2,0,1,0);break;

			case 5:_newAnt(3);break;
			case 6:_antOut(3,0,1,0);break;

			case 7:_newAnt(4);break;
			case 8:_antOut(4,0,1,0);break;

			case 9:_newAnt(5);break;
			case 10:_antOut(5,0,1,0);break;

			case 11:_newAnt(6);break;
			case 12:_antOut(6,0,1,0);break;

			case 13:_newAnt(7);break;
			case 14:_antOut(7,0,1,0);break;

			case 15:_newAnt(8);break;
			case 16:_antOut(8,0,1,0);break;

			case 17:_newAnt(9);break;
			case 18:_antOut(9,0,1,0);break;
		}
	}

}
