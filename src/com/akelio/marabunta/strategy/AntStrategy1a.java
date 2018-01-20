package com.akelio.marabunta.strategy;

import java.util.List;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;

public class AntStrategy1a extends AntStrategy {

	public void process(InputAnt input) {
		Debug.d("AntStrategy1:process");

		AntMemory mem = input.getMemory();
		Food bestFood = input.getBestFood();
		Nest bestNest = input.getBestNest();
		
		Pheromone myNearestPh = input.getMyNearestPheromone();
		List<Pheromone> myPheromones = input.getMyPheromones();
		List<Pheromone> pathPheromones = input.getPathPheromones();

		int t = mem.getM0();
		int r = mem.getM1();
		
		t++;
		if(t==256) t=0;
		
		Debug.d("ant-t="+t);
		
		
		
		if(input.getStock()>100) {
			// rentrer au nid
			Debug.d("Je rentre au nid");
			
			if(bestNest!=null) {
				if(bestNest.isNear()) {
					setMemory(t,r);
					_nest(bestNest.getId());
					return;
				}
				setMemory(t,r);
				_moveTo(bestNest.getId());
				return;
			}
			if(myPheromones.isEmpty()) {
				setMemory(t,r);
				_explore();
				return;
			}
			if(myPheromones.size()==1) {
				setMemory(t,r);
				_moveTo(myPheromones.get(0).getId());
				return;
			}
			if(myNearestPh!=null){
				if(myNearestPh.isNear()) {
					if(r==10) r=1;
					else r++;
					
					setMemory(t,r);
					_changePheromone(myNearestPh.getId(), input.getType()*10 + r);
					return;
				}
				setMemory(t,r);
				_moveTo(myNearestPh.getId());
				return;
			}
			setMemory(t,r);
			_explore();
			return;
		}
		
		// rechercher de la nourriture
		
		
		
		// on place une pheromone tous les 3 tours
		if(t%3==0) {
			setMemory(t,r);
			_putPheromone(input.getType()*10);
			return;
		}

		List<Food> foods = input.getFoods();

		if(foods.isEmpty()) {
			// aucune nouriture en vue : on explore
			setMemory(t,r);
			_explore();
			
			if(t>400) {
				suicide();
				return;
			}
			return;
		}

		if(!bestFood.isNear()) {
			// nouriture en vue : on se rapproche
			setMemory(t,r);
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
}
