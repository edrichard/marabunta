package com.akelio.marabunta.input.nest;

import com.akelio.marabunta.input.ant.AntMemory;

public class AntIn {

	private int			type;
	private AntMemory	memory;

	public AntIn() {
		super();
	}

	public AntIn(int type, int m0, int m1) {
		super();
		this.type = type;
		this.memory = new AntMemory(m0, m1);
	}

	public AntIn(int type, AntMemory memory) {
		super();
		this.type = type;
		this.memory = memory;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public AntMemory getMemory() {
		return memory;
	}

	public void setMemory(AntMemory memory) {
		this.memory = memory;
	}

}
