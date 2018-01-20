package com.akelio.marabunta.input.ant;

public class Nest {

	private int		id;
	private String	zone;
	private int		dist;
	private String	friend;

	public Nest() {
		super();
	}

	public Nest(int id, String zone, int dist, String friend) {
		super();
		this.id = id;
		this.zone = zone;
		this.dist = dist;
		this.friend = friend;
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

	public boolean isFar() {
		return zone.equals("FAR");
	}

	public boolean isNear() {
		return zone.equals("NEAR");
	}

	public boolean isFriend() {
		return friend.equals("FRIEND");
	}

	public boolean isEnnemy() {
		return friend.equals("ENNEMY");
	}

}
