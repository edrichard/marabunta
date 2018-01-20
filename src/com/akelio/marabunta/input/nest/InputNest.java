package com.akelio.marabunta.input.nest;

import java.util.List;

public class InputNest {

	private int				stock;
	private List<AntCount>	antCounts;
	private List<AntIn>		antIns;
	private NestMemory			memory;

	public InputNest() {
		super();
	}

	public InputNest(int stock, List<AntCount> antCounts, List<AntIn> antIns, NestMemory memory) {
		super();
		this.stock = stock;
		this.antCounts = antCounts;
		this.antIns = antIns;
		this.memory = memory;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<AntCount> getAntCounts() {
		return antCounts;
	}

	public void setAntCounts(List<AntCount> antCounts) {
		this.antCounts = antCounts;
	}

	public List<AntIn> getAntIns() {
		return antIns;
	}

	public void setAntIns(List<AntIn> antIns) {
		this.antIns = antIns;
	}

	public NestMemory getMemory() {
		return memory;
	}

	public void setMemory(NestMemory memory) {
		this.memory = memory;
	}

}
