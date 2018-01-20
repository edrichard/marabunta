package com.akelio.marabunta;

import com.akelio.marabunta.strategy.strategy2.AntStrategy2;
import com.akelio.marabunta.strategy.strategy2.NestStrategy2;

public class Main2 {

	public static void main(String[] args) {
		new Program(new AntStrategy2(),new NestStrategy2());
	}
}
