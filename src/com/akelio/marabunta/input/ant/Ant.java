package com.akelio.marabunta.input.ant;

public class Ant {

	private int		id;
	private String	zone;
	private int		dist;
	private String	friend;
	private int		stamina;

	public Ant() {
		super();
	}

	public Ant(int id, String zone, int dist, String friend, int stamina) {
		super();
		this.id = id;
		this.zone = zone;
		this.dist = dist;
		this.friend = friend;
		this.stamina = stamina;
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

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

}
