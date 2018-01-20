package com.akelio.marabunta;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		String first = s.nextLine();
		
		if(first.equals("BEGIN NEST"))
			handleNest(s);
		else handleAnt(s);
		
		
	}

	
	
	private static void handleNest(Scanner s) {
		String info = "";
		while(!info.equals("END")) {
			info = s.nextLine();
			System.out.println(info);
			
			String[] n = info.split(" ");
			
			switch(n[0]) {
				case "BEGIN": System.out.println("");
			}
		}
		
		
		
		System.out.println("");
	}
	
	
	
	private static void handleAnt(Scanner s) {
		String info = "";
		while(!info.equals("END")) {
			info = s.nextLine();
			System.out.println(info);
			
			String[] n = info.split(" ");
			
			switch(n[0]) {
				case "BEGIN": System.out.println("");
			}
		}
		
		System.out.println("");
	}
}
