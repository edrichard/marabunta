package com.akelio.marabunta.input.ant;

import java.util.ArrayList;
import java.util.List;

import com.akelio.marabunta.Const;

public class InputAnt {

	private boolean attacked = false;
	private int type;
	private int stamina;
	private int stock;
	private AntMemory memory;
	private List<Pheromone> pheromones;
	private List<Food> foods;
	private List<Nest> nests;
	private List<Ant> ants;

	public InputAnt() {
		super();
		pheromones = new ArrayList<>();
		foods = new ArrayList<>();
		nests = new ArrayList<>();
		ants = new ArrayList<>();
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

	public int getStockLeft() {
		return Const.ANT_STOCK_MAX - stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<Pheromone> getPheromones() {
		return pheromones;
	}
	
	public List<Pheromone> getMyPheromones() {
		List<Pheromone> list = new ArrayList<>();
		for(Pheromone pheromone : pheromones)  if(pheromone.getType()==type)
			list.add(pheromone);
		return list;
	}
	
	public List<Pheromone> getPathPheromones() {
		List<Pheromone> list = new ArrayList<>();
		for(Pheromone pheromone : pheromones)  if(pheromone.getType()>511)
			list.add(pheromone);
		return list;
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

	public Food getBestFood() {
		if (foods.isEmpty())
			return null;

		Food best = foods.get(0);
		int nb = foods.size();

		for (int i = 1; i < nb; i++) {
			Food food = foods.get(i);
			if (food.isNear()) {
				if (best.isFar())
					best = food;
				else {
					if (food.getAmount() > best.getAmount())
						best = food;
				}
			} else {
				if (best.isFar()) {
					if (food.getAmount() > best.getAmount())
						best = food;
				}
			}
		}

		return best;
	}

	public Nest getBestNest() {
		if (nests.isEmpty()) return null;

		Nest best = null;
		int dist = Integer.MAX_VALUE;

		for (Nest nest : nests) {
			if (!nest.isFriend())
				continue;

			if (nest.getDist() < dist) {
				best = nest;
				dist = nest.getDist();
			}
		}
		return best;
	}

	public Pheromone getMyNearestPheromone() {
		if (pheromones.isEmpty()) return null;

		Pheromone best = null;
		int dist = Integer.MAX_VALUE;

		for (Pheromone pheromone : pheromones) {
			if (pheromone.getType() == type && pheromone.getDist()<dist) {
				best = pheromone;
				dist = pheromone.getDist();
			}
		}
		return best;
	}

//	public Pheromone getOldestPheromone() {
//		if (pheromones.isEmpty())
//			return null;
//
//		Pheromone best = null;
//		int bestPersistance = 100;
//
//		for (Pheromone pheromone : pheromones) {
//			int persistance = pheromone.getPersistance();
//
//			if (persistance < bestPersistance) {
//				bestPersistance = persistance;
//				best = pheromone;
//			}
//		}
//		return best;
//	}

}
