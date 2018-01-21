package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;

public class AntStrategy3 extends AntStrategy {
	
	public static int STEP = 5;

	public void process(InputAnt input) {

		AntMemory mem = input.getMemory();
		Food bestFood = input.getBestFood();
		Nest bestNest = input.getBestNest();
		
		Pheromone pathHighestPh = getHighestPathPheromone(input);

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
			
			Pheromone unflagged = getUnflaggedPheromone(input);
			if(unflagged!=null) {
				if(unflagged.getPersistance()<25) {
					setMemory(t,r);
					_rechargePheromone(unflagged.getId());
					return;
				}
				
				setMemory(t,r);
				_changePheromone(unflagged.getId(), unflagged.getType()+100);
				return;
			}
			
			Pheromone targetRetour = getLowestPheromone(input);
			if(targetRetour!=null) {
				setMemory(t,r);
				_moveTo(targetRetour.getId());
				return;
			}
			
			suicide();
			return;
		}
		
		// rechercher de la nourriture
		
		t++;
		if(t==256) t=0;
		
		// on place une pheromone tous les 3 tours
		if(t%STEP==0) {
			setMemory(t,r);
			_putPheromone((int) (t/STEP));
			return;
		}
		
		if(bestFood!=null && bestFood.isNear()) {
			// nouriture a portee
			int amount = Math.min(bestFood.getAmount(), input.getStockLeft())-1;
			if(amount>0) {
				// il y a de la nourriture a recolter : on collecte
				r = (int) (t/STEP);
				Debug.d("r="+r);
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
	
	
	
	
	private Pheromone getLowestPheromone(InputAnt input) {
		if (input.getPheromones().isEmpty()) return null;

		Pheromone best = null;
		int id = Integer.MAX_VALUE;

		for (Pheromone pheromone : input.getPheromones()) {
			if (pheromone.getType()%100<id) {
				best = pheromone;
				id = pheromone.getType()%100;
			}
		}
		return best;
	}
	
	
	
	private Pheromone getUnflaggedPheromone(InputAnt input) {
		if (input.getPheromones().isEmpty()) return null;

		for (Pheromone pheromone : input.getPheromones()) {
			if (pheromone.getType()<100 && pheromone.isNear()) return pheromone;
		}
		return null;
	}
	
	
	
}
