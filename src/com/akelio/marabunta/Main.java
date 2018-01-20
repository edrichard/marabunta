package com.akelio.marabunta;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		new Main();
	}
	
	
	public Main() {
		Scanner s = new Scanner(System.in);
		String first = s.nextLine();
		
		switch(first) {
			case Const.BEGIN_ANT:handleAnt(s);
			case Const.BEGIN_NEST:handleNest(s);
			default: throw new RuntimeException("Invalid begin line received: "+first);
		}
	}

	
	
	private void handleNest(Scanner s) {
		String info = "";
		while(!info.equals(Const.END)) {
			info = s.nextLine();
			String[] n = info.split(" ");
			
			switch(n[0]) {
				case Const.NI_ANT_COUNT: ;
				case Const.NI_ANT_IN: ;
				case Const.NI_MEMORY: ;
				case Const.NI_STOCK: ;
			}
		}
		
		
		
	}
	
	
	
	private void handleAnt(Scanner s) {
		String info = "";
		while(!info.equals(Const.END)) {
			info = s.nextLine();
			System.out.println(info);
			
			String[] n = info.split(" ");
			
			switch(n[0]) {
				case Const.AI_ATTACKED: ;
				case Const.AI_MEMORY: ;
				case Const.AI_SEE_ANT: ;
				case Const.AI_SEE_FOOD: ;
				case Const.AI_SEE_NEST: ;
				case Const.AI_SEE_PHEROMONE: ;
				case Const.AI_STAMINA: ;
				case Const.AI_STOCK: ;
				case Const.AI_TYPE: ;
			}
			
			
		}
	}
}
