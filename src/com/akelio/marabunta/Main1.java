package com.akelio.marabunta;

import com.akelio.marabunta.strategy.AntStrategy1a;
import com.akelio.marabunta.strategy.NestStrategy1;

public class Main1 {

	public static void main(String[] args) {
		new Program(new AntStrategy1a(),new NestStrategy1());
	}
}
