package com.kurumi.util;

public class Test {
	private static Test test;
	private Test(){}
	public static Test getInsteance(){
		if(test == null){
			synchronized (Test.class) {
				if(test == null){
					test = new Test();
				}
			}
		}
		return test;
	}
	
}
