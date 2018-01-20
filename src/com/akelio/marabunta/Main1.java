package com.akelio.marabunta;

import com.akelio.marabunta.strategy.strategy1.AntStrategy1;
import com.akelio.marabunta.strategy.strategy1.NestStrategy1;

public class Main1 {

	public static void main(String[] args) {
		new Program(new AntStrategy1(),new NestStrategy1());
	}
}
