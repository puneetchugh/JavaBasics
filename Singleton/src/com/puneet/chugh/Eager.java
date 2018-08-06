package com.puneet.chugh;

public class Eager{

	private static final Eager eager = new Eager();

	private Eager(){}
	public static Eager getInstance(){
		return eager;
	}
}
