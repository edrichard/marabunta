package com.akelio.marabunta.input.ant;

import java.util.ArrayList;
import java.util.List;

public class InputAnt {

	private boolean			attacked;
	private int				type;
	private int				stamina;
	private int				stock;
	private AntMemory		memory;
	private List<Pheromone>	pheromones;
	private List<Food>		foods;
	private List<Nest>		nests;
	private List<Ant>		ants;

	public InputAnt() {
		super();
		pheromones = new ArrayList<>();
		foods = new ArrayList<>();
		nests = new ArrayList<>();
		ants = new ArrayList<>();
		attacked = false;
	}

	public InputAnt(boolean attacked, int type, int stamina, int stock, AntMemory memory, List<Pheromone> pheromones, List<Food> foods, List<Nest> nests, List<Ant> ants) {
		super();
		this.attacked = attacked;
		this.type = type;
		this.stamina = stamina;
		this.stock = stock;
		this.memory = memory;
		this.pheromones = pheromones;
		this.foods = foods;
		this.nests = nests;
		this.ants = ants;
	}

	public boolean isAttacked() {
		return attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Pheromone> getPheromones() {
		return pheromones;
	}

	public void setPheromones(List<Pheromone> pheromones) {
		this.pheromones = pheromones;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public List<Nest> getNests() {
		return nests;
	}

	public void setNests(List<Nest> nests) {
		this.nests = nests;
	}

	public List<Ant> getAnts() {
		return ants;
	}

	public void setAnts(List<Ant> ants) {
		this.ants = ants;
	}

	public AntMemory getMemory() {
		return memory;
	}

	public void setMemory(AntMemory memory) {
		this.memory = memory;
	}

	public void addFood(Food food) {
		foods.add(food);
	}

	public void addPheromone(Pheromone p) {
		pheromones.add(p);
	}

	public void addAnt(Ant a) {
		ants.add(a);
	}

	public void addNest(Nest n) {
		nests.add(n);
	}

}
