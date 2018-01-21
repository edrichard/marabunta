package com.akelio.marabunta.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.akelio.marabunta.Debug;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;

public class AntStrategy1a extends AntStrategy {

	public void process(InputAnt input) {

		AntMemory mem = input.getMemory();
		Food bestFood = input.getBestFood();
		Nest bestNest = input.getBestNest();
		
		Pheromone myNearestPh = getMyNearestPheromone(input);
		List<Pheromone> myPheromones = getMyPheromones(input);
		List<Pheromone> pathPheromones = getSortedPathPheromones(input);

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
				_exploreD(1);
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
			_exploreD(2);
			return;
		}
		
		// rechercher de la nourriture
		Debug.d("DEBUG1");
		
		// on place une pheromone tous les 3 tours
		if(t%3==0) {
			setMemory(t,r);
			_putPheromone(input.getType()*10);
			return;
		}	
		Debug.d("DEBUG2");
				
		if(bestFood!=null && bestFood.isNear()) {
			// nouriture a portee

			int amount = Math.min(bestFood.getAmount(), input.getStockLeft());
			if(amount>0) {
				// il y a de la nourriture a recolter : on collecte
				setMemory(t,r);
				_collect(bestFood.getId(), amount);
				return;
			}
		}
		Debug.d("DEBUG3");
		
		if(bestFood!=null && bestFood.isFar()) {
			// nouriture en vue : on se rapproche
			setMemory(t,r);
			_moveTo(bestFood.getId());
			return;
		}
		Debug.d("DEBUG4");
		
		if(pathPheromones!=null && !pathPheromones.isEmpty()) {
			if(pathPheromones.size()==1) {
				setMemory(t,r);
				_moveTo(pathPheromones.get(0).getId());
				return;
			}
			
			Pheromone ph1 = pathPheromones.get(0);
			Pheromone ph2 = pathPheromones.get(1);
			
			if((ph1.getId()%10==9 && ph2.getId()%10==1)) {
				setMemory(t,r);
				_moveTo(ph2.getId());
				return;
			}
			
			if(ph1.getId()%10==1 && ph2.getId()%10==9) {
				setMemory(t,r);
				_moveTo(ph1.getId());
				return;
			}
			
			if((ph1.getId()%10 > ph2.getId()%10)) {
				setMemory(t,r);
				_moveTo(ph1.getId());
				return;
			}
			
			if((ph1.getId()%10 < ph2.getId()%10)) {
				setMemory(t,r);
				_moveTo(ph2.getId());
				return;
			}

			setMemory(t,r);
			_explore();
			return;
		}
		
		setMemory(t,r);
		_explore();
	}
	
	
	
	public Pheromone getMyNearestPheromone(InputAnt input) {
		if (input.getPheromones().isEmpty()) return null;

		Pheromone best = null;
		int dist = Integer.MAX_VALUE;

		for (Pheromone pheromone : input.getPheromones()) {
			if (pheromone.getType() == getPheromoneType(input) && pheromone.getDist()<dist) {
				best = pheromone;
				dist = pheromone.getDist();
			}
		}
		return best;
	}
	
	
	private List<Pheromone> getMyPheromones(InputAnt input) {
		int phType = getPheromoneType(input);
		List<Pheromone> list = new ArrayList<>();
		for(Pheromone pheromone : input.getPheromones())  if(pheromone.getType()==phType)
			list.add(pheromone);
		return list;
	}
	
	private int getPheromoneType(InputAnt input) {
		return input.getType()*10;
	}
	
	
	public List<Pheromone> getSortedPathPheromones(InputAnt input) {
		if (input.getPheromones().isEmpty()) return null;
		
		List<Pheromone> list = new ArrayList<>();
		for(Pheromone pheromone : input.getPheromones())  {
			if(pheromone.getType()%10>0) list.add(pheromone);
		}
		Collections.sort(list,new Comparator<Pheromone>() {
			public int compare(Pheromone o1, Pheromone o2) {
				int d1 = o1.getDist();
				int d2 = o2.getDist();
				if(d1<d2) return 1;
				if(d1>d2) return -1;
				return 0;
			}
		});
		
		return list;
	}
	
	
}
