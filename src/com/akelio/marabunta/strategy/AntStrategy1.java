package com.akelio.marabunta.strategy;

import java.util.ArrayList;
import java.util.List;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;

public class AntStrategy1 extends AntStrategy {

	public void process(InputAnt input) {

		AntMemory mem = input.getMemory();
		Food bestFood = input.getBestFood();
		Nest bestNest = input.getBestNest();
		
		Pheromone myNearestPh = input.getMyNearestPheromone();
		List<Pheromone> myPheromones = getMyPheromones(input);

		int t = mem.getM0()+1;
		Debug.d("ant-t="+t);
		if(t<256) setMemory(t,0);
		
		if(input.getStock()>100) {
			// rentrer au nid
			Debug.d("Je rentre au nid");
			
			if(bestNest!=null) {
				if(bestNest.isNear()) {
					_nest(bestNest.getId());
					return;
				}
				_moveTo(bestNest.getId());
				return;
			}
			if(myPheromones.isEmpty()) {
				_explore();
				return;
			}
			if(myPheromones.size()==1) {
				_moveTo(myPheromones.get(0).getId());
				return;
			}
			if(myNearestPh!=null){
				if(myNearestPh.isNear()) {
					_changePheromone(myNearestPh.getId(), 1023 - input.getType());
					return;
				}
				_moveTo(myNearestPh.getId());
				return;
			}
			_explore();
			return;
		}
		
		// rechercher de la nourriture
		
		// on place une pheromone tous les 3 tours
		if(t%3==0) {
			_putPheromone(input.getType());
			return;
		}

		List<Food> foods = input.getFoods();

		if(foods.isEmpty()) {
			// aucune nouriture en vue : on explore
			_explore();
			
			if(t>40) {
				suicide();
				return;
			}
			return;
		}

		if(!bestFood.isNear()) {
			// nouriture en vue : on se rapproche
			_moveTo(bestFood.getId());
			return;
		}
		
		// nouriture a portee

		int amount = Math.min(bestFood.getAmount(), input.getStockLeft());
		if(amount>0) {
			// il y a de la nourriture a recolter : on collecte
			_collect(bestFood.getId(), amount);
			return;
		}
	}
	
	
	

	
	private List<Pheromone> getMyPheromones(InputAnt input) {
		int phType = input.getType();
		List<Pheromone> list = new ArrayList<>();
		for(Pheromone pheromone : input.getPheromones())  if(pheromone.getType()==phType)
			list.add(pheromone);
		return list;
	}
}
