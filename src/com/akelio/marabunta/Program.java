package com.akelio.marabunta;

import java.util.Scanner;

import com.akelio.marabunta.input.ant.Ant;
import com.akelio.marabunta.input.ant.AntMemory;
import com.akelio.marabunta.input.ant.Food;
import com.akelio.marabunta.input.ant.InputAnt;
import com.akelio.marabunta.input.ant.Nest;
import com.akelio.marabunta.input.ant.Pheromone;
import com.akelio.marabunta.input.nest.AntCount;
import com.akelio.marabunta.input.nest.AntIn;
import com.akelio.marabunta.input.nest.InputNest;
import com.akelio.marabunta.input.nest.NestMemory;
import com.akelio.marabunta.strategy.AntStrategy;
import com.akelio.marabunta.strategy.NestStrategy;

public class Program {
	
	private AntStrategy antStrategy;
	private NestStrategy nestStrategy;


	public Program(AntStrategy antStrategy, NestStrategy nestStrategy) {
		this.antStrategy = antStrategy;
		this.nestStrategy = nestStrategy;
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			String first = s.nextLine();
	
			switch (first) {
				case Const.BEGIN_ANT:
					handleAnt(s);
					s.close();
					break;
				case Const.BEGIN_NEST:
					handleNest(s);
					s.close();
					break;
				default:
					throw new RuntimeException("Invalid begin line received: " + first);
			}
		}
	}

	private void handleNest(Scanner s) {
		String info = "";
		InputNest inputNest = new InputNest();
		while (!info.equals(Const.END)) {
			info = s.nextLine();
			String[] n = info.split(" ");

			switch (n[0]) {
				case Const.NI_ANT_COUNT:
					inputNest.addAntCount(new AntCount(toInt(n[1]), toInt(n[2])));
					break;
				case Const.NI_ANT_IN:
					inputNest.addAntIn(new AntIn(toInt(n[1]), toInt(n[2]), toInt(n[3])));
					break;
				case Const.NI_MEMORY:
					inputNest.setMemory(new NestMemory(
							toInt(n[1]), toInt(n[2]), toInt(n[3]), toInt(n[4]), 
							toInt(n[5]), toInt(n[6]), toInt(n[7]), toInt(n[8]), 
							toInt(n[9]), toInt(n[10]), toInt(n[11]), toInt(n[12]), 
							toInt(n[13]), toInt(n[14]), toInt(n[15]), toInt(n[16]), 
							toInt(n[17]), toInt(n[18]), toInt(n[19]), toInt(n[20])));
					break;
				case Const.NI_STOCK:
					inputNest.setStock(toInt(n[1]));
					break;
			}
		}
		
		if(nestStrategy!=null) {
			nestStrategy.process(inputNest);
			nestStrategy.end();
		}
	}
	

	private void handleAnt(Scanner s) {
		String info = "";
		InputAnt inputAnt = new InputAnt();

		while (!info.equals(Const.END)) {
			info = s.nextLine();
			System.out.println(info);

			String[] n = info.split(" ");

			switch (n[0]) {
				case Const.AI_ATTACKED:
					inputAnt.setAttacked(true);
					break;
				case Const.AI_MEMORY:
					inputAnt.setMemory(new AntMemory(toInt(n[1]), toInt(n[2])));
					break;
				case Const.AI_SEE_ANT:
					inputAnt.addAnt(new Ant(toInt(n[1]), n[2], toInt(n[3]), n[4], toInt(n[5])));
					break;
				case Const.AI_SEE_FOOD:
					inputAnt.addFood(new Food(toInt(n[1]), n[2], toInt(n[3]), toInt(n[4])));
					break;
				case Const.AI_SEE_NEST:
					inputAnt.addNest(new Nest(toInt(n[1]), n[2], toInt(n[3]), n[4]));
					break;
				case Const.AI_SEE_PHEROMONE:
					inputAnt.addPheromone(new Pheromone(toInt(n[1]), n[2], toInt(n[3]), toInt(n[4]), toInt(n[5])));
					break;
				case Const.AI_STAMINA:
					inputAnt.setStamina(toInt(n[1]));
					break;
				case Const.AI_STOCK:
					inputAnt.setStock(toInt(n[1]));
					break;
				case Const.AI_TYPE:
					inputAnt.setType(toInt(n[1]));
					break;
			}
		}
		
		if(antStrategy!=null) {
			antStrategy.process(inputAnt);
			antStrategy.end();
		}
	}

	private int toInt(String s) {
		return Integer.parseInt(s);
	}
}
