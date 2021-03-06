package com.akelio.marabunta.input.nest;

import java.util.ArrayList;
import java.util.List;

public class InputNest {

	private int				stock;
	private List<AntCount>	antCounts;
	private List<AntIn>		antIns;
	private NestMemory		memory;

	public InputNest() {
		super();
		antCounts = new ArrayList<>();
		antIns = new ArrayList<>();
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
	
	public int getTotalAntCounts() {
		int total = 0;
		for(AntCount count : antCounts) {
			total+= count.getQuantity();
		}
		return total;
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

	public void addAntCount(AntCount ac) {
		antCounts.add(ac);
	}

	public void addAntIn(AntIn ai) {
		antIns.add(ai);
	}
	
	public AntCount getExistingAntType() {
		if(antCounts.isEmpty()) return null;
		return antCounts.get(0);
	}

}
