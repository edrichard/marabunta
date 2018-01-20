package com.akelio.marabunta.strategy;

import com.akelio.marabunta.Const;
import com.akelio.marabunta.input.ant.InputAnt;

public abstract class AntStrategy {

	public abstract void process(InputAnt input);
	
	
	private void p(String line) {
		System.out.println(line);
	}
	
	
	protected void explore() {
		p(Const.AA_EXPLORE);
	}
	
	protected void putPheromone(int type) {
		p(Const.AA_PUT_PHEROMONE+" "+type);
	}
	
	protected void changePheromone(int id, int type) {
		p(Const.AA_CHANGE_PHEROMONE+" "+id+" "+type);
	}

	protected void rechargePheromone(int id) {
		p(Const.AA_RECHARGE_PHEROMONE+" "+id);
	}

	protected void doTrophallaxis(int id, int quantity) {
		p(Const.AA_DO_TROPHALLAXIS+" "+id+" "+quantity);
	}

	protected void eat(int quantity) {
		p(Const.AA_EAT+" "+quantity);
	}
	
	protected void moveTo(int id) {
		p(Const.AA_MOVE_TO+" "+id);
	}

	protected void turn(int angle) {
		p(Const.AA_TURN+" "+angle);
	}

	protected void nest(int id) {
		p(Const.AA_NEST+" "+id);
	}

	protected void attack(int id, int force) {
		p(Const.AA_ATTACK+" "+id+" "+force);
	}
	
	protected void suicide(int id, int forc) {
		p(Const.AA_SUICIDE);
	}
	
	protected void collect(int id, int quantity) {
		p(Const.AA_COLLECT+" "+id+" "+quantity);
	}
	
	protected void setMemory(int m0, int m1) {
		p(Const.AA_SET_MEMORY+" "+m0+" "+m1);
	}
	
	public void end() {
		p(Const.END);
	}
}
