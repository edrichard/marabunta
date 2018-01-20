package com.akelio.marabunta;

import com.akelio.marabunta.strategy.strategy1.NestStrategy1;
import com.akelio.marabunta.strategy.strategy2.AntStrategy2;

public class Main1 {

	public static void main(String[] args) {
		new Program(new AntStrategy2(),new NestStrategy1());
	}
}
