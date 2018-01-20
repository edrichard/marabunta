package com.akelio.marabunta.input.nest;

public class AntIn {

	private int	type;
	private int	m0;
	private int	m1;

	public AntIn() {
		super();
	}

	public AntIn(int type, int m0, int m1) {
		super();
		this.type = type;
		this.m0 = m0;
		this.m1 = m1;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getM0() {
		return m0;
	}

	public void setM0(int m0) {
		this.m0 = m0;
	}

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
	}

}
