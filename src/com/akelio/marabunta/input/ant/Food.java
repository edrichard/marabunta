package com.akelio.marabunta.input.ant;

public class Food {

	private int		id;
	private String	zone;
	private int		dist;
	private int		amount;

	public Food() {
		super();
	}

	public Food(int id, String zone, int dist, int amount) {
		super();
		this.id = id;
		this.zone = zone;
		this.dist = dist;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isFar() {
		return zone.equals("FAR");
	}

	public boolean isNear() {
		return zone.equals("NEAR");
	}

}
