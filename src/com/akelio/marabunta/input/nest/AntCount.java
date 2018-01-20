package com.akelio.marabunta.input.nest;

public class AntCount {

	private int	type;
	private int	quantity;

	public AntCount() {
		super();
	}

	public AntCount(int type, int quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
