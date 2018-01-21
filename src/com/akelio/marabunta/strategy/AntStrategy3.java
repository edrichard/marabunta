package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;

public class AntStrategy3 extends AntStrategy {

	public void process(InputAnt input) {

		AntMemory mem = input.getMemory();
		Food bestFood = input.getBestFood();
		Nest bestNest = input.getBestNest();
		
		Pheromone pathHighestPh = getHighestPathPheromone(input);
		Pheromone pathLowestPh = getLowestPathPheromone(input);

		int t = mem.getM0();
		int r = mem.getM1();
		
		Debug.d("ant-t="+t);
		
		if(input.getStock()>100) {
			
			// rentrer au nid
			Debug.d("Je rentre au nid");
			
			if(bestNest!=null) {
				if(bestNest.isNear()) {
					
					_nest(bestNest.getId());
					return;
				}
				setMemory(t,r);
				_moveTo(bestNest.getId());
				return;
			}
			
			if(pathLowestPh!=null) {
				setMemory(t,r);
				_moveTo(pathLowestPh.getId());
				return;
			}
			
			Pheromone targetRetour = getPheromoneById(input,r);
			if(targetRetour!=null) {
				if(targetRetour.isNear()) {
					setMemory(t,r-1);
					_changePheromone(targetRetour.getId(), r+100);
					return;
				}
				setMemory(t,r);
				_moveTo(targetRetour.getId());
				return;
			}
			
			setMemory(t,r);
			suicide();
			return;
		}
		
		// rechercher de la nourriture
		
		t++;
		if(t==256) t=0;
		
		// on place une pheromone tous les 3 tours
		if(t%3==0) {
			setMemory(t,r);
			_putPheromone((int) (t/3));
			return;
		}
		
		if(bestFood!=null && bestFood.isNear()) {
			// nouriture a portee
			int amount = Math.min(bestFood.getAmount(), input.getStockLeft());
			if(amount>0) {
				// il y a de la nourriture a recolter : on collecte
				r = (int) (t/3);
				setMemory(t,r);
				_collect(bestFood.getId(), amount);
				return;
			}
		}
		
		if(bestFood!=null && bestFood.isFar()) {
			// nouriture en vue : on se rapproche
			setMemory(t,r);
			_moveTo(bestFood.getId());
			return;
		}
		
		if(pathHighestPh!=null) {
			// path best pheromonone : on suit la piste
			setMemory(t,r);
			_moveTo(pathHighestPh.getId());
			return;
		}
		
		setMemory(t,r);
		_explore();
	}
	
	
	
	
	private Pheromone getHighestPathPheromone(InputAnt input) {
		if (input.getPheromones().isEmpty()) return null;

		Pheromone best = null;
		int id = 0;

		for (Pheromone pheromone : input.getPheromones()) {
			if (pheromone.getType()>=100 && pheromone.getType()>id) {
				best = pheromone;
				id = pheromone.getType();
			}
		}
		return best;
	}
	
	private Pheromone getLowestPathPheromone(InputAnt input) {
		if (input.getPheromones().isEmpty()) return null;

		Pheromone best = null;
		int id = Integer.MAX_VALUE;

		for (Pheromone pheromone : input.getPheromones()) {
			if (pheromone.getType()>=100 && pheromone.getType()<id) {
				best = pheromone;
				id = pheromone.getType();
			}
		}
		return best;
	}
	
	
	private Pheromone getPheromoneById(InputAnt input, int id) {
		if (input.getPheromones().isEmpty()) return null;
		for (Pheromone pheromone : input.getPheromones()) {
			if (pheromone.getType()==id) return pheromone;
		}
		return null;
	}
}
