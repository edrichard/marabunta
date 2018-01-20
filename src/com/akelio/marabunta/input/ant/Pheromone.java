package com.akelio.marabunta.input.ant;

public class Pheromone {

	private int		id;
	private String	zone;
	private int		dist;
	private int		type;
	private int		persistance;

	public Pheromone() {
		super();
	}

	public Pheromone(int id, String zone, int dist, int type, int persistance) {
		super();
		this.id = id;
		this.zone = zone;
		this.dist = dist;
		this.type = type;
		this.persistance = persistance;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPersistance() {
		return persistance;
	}

	public void setPersistance(int persistance) {
		this.persistance = persistance;
	}

}
