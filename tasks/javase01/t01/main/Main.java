package javase01.t01.main;

import javase01.t01.logic.Logic;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World From Main!");
		Logic logic = new Logic();
		System.out.println(logic.method());
	}
}
