package com.akelio.marabunta;

import com.akelio.marabunta.strategy.AntStrategy3;
import com.akelio.marabunta.strategy.NestStrategy1;

public class Main1 {

	public static void main(String[] args) {
		new Program(new AntStrategy3(),new NestStrategy1());
	}
}
