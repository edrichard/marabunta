package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Const;
import com.akelio.marabunta.input.nest.InputNest;

public abstract class NestStrategy {

	public abstract void process(InputNest input);

	private void p(String line) {
		System.out.println(line);
	}

	protected void newAnt(int type) {
		p(Const.NA_ANT_NEW + " " + type);
	}

	protected void antOut(int type, int food, int m0, int m1) {
		p(Const.NA_ANT_OUT + " " + type + " " + food + " " + m0 + " " + m1);
	}

	protected void setMemory(int... memory) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 20; i++) {
			sb.append(memory.length < i ? memory[i] : 0);
			sb.append(" ");
		}
		p(Const.NA_SET_MEMORY + " " + sb.toString().trim());
	}
	
	public void end() {
		p(Const.END);
	}
}
