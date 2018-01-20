package com.akelio.marabunta.strategy.strategy1;

import java.util.List;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;
import com.akelio.marabunta.strategy.AntStrategy;

public class AntStrategy1 extends AntStrategy {

	public void process(InputAnt input) {
		Debug.d("AntStrategy1:process");

		AntMemory mem = input.getMemory();
		Food bestFood = input.getBestFood();
		Nest bestNest = input.getBestNest();
		Pheromone oldestPh = input.getOldestPheromone();
		
		int t = mem.getM0()+1;

		setMemory(t%256,mem.getM1());
		
		if(input.getStockLeft()==0) {
			// rentrer au nid
			if(bestNest!=null) {
				if(bestNest.isNear()) {
					_nest(bestNest.getId());
					return;
				}
				_moveTo(bestNest.getId());
				return;
			}
			if(oldestPh!=null) {
				_moveTo(oldestPh.getId());
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
}
