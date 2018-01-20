package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Const;
import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.nest.InputNest;

public abstract class NestStrategy {
	
	public static final boolean PRINT = false;
	

	public abstract void process(InputNest input);

	private void p(String line) {
		System.out.println(line);
		if(PRINT) Debug.d(line);
	}

	protected void _newAnt(int type) {
		p(Const.NA_ANT_NEW + " " + type);
	}

	protected void _antOut(int type, int food, int m0, int m1) {
		p(Const.NA_ANT_OUT + " " + type + " " + food + " " + m0 + " " + m1);
	}

	protected void setMemory(int... memory) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			sb.append(memory.length > i ? memory[i] : 0);
			sb.append(" ");
		}
		p(Const.NA_SET_MEMORY + " " + sb.toString().trim());
	}
	
	public void end() {
		p(Const.END);
	}
}
