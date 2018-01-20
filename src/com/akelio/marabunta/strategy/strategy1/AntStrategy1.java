package com.akelio.marabunta.strategy.strategy1;

import java.util.List;

import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.strategy.AntStrategy;

public class AntStrategy1 extends AntStrategy {

	public void process(InputAnt input) {
		
		 AntMemory mem = input.getMemory();
		 Food bestFood = input.getBestFood();
		 int state = mem.getM0();
		 
		 if(state==0) return;
		 
		 // state=1 (dehors)
		 
		 List<Food> foods = input.getFoods();
		 
		 // aucune nouriture en vue : on explore
		 if(foods.isEmpty()) {
			 _explore();
			 return;
		 }
		 
		 // nouriture en vue : on se rapproche
		 if(!bestFood.isNear()) {
			 _moveTo(bestFood.getId());
			 return;
		 }
		 
		 int amount = Math.min(bestFood.getAmount(), input.getStockLeft());
		 if(amount>0) {
			_collect(bestFood.getId(), amount);
		 	return;
		 }
	}
}
