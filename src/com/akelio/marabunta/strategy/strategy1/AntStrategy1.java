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
		 
		 if(foods.isEmpty())
			 _explore();
		 else {
			 if(bestFood.isNear()) {
				 _collect(bestFood.getId(), bestFood.getAmount());
			 }
			 else {
				 _moveTo(bestFood.getId());
			 }
		 }
	}

}
