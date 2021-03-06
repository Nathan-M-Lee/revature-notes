package com.revature.abstraction;

public interface Ectothermic {
	
	// by default all methods within an interface are abstract and public
	public static final int MIN_BODY_TEMP = -40;
	public static final int MAX_BODY_TEMP = -40;

	
	// all attributes (fields) of an interface are by default PUBLIC, STATIC, and FINAL
	void heatUp();
	
	void coolDown();
	
	// there are also default methods, which we'll talk about --> JAVA 7?
	default void saySomething() {
		System.out.println("something is being said from the default methos in the inteface");
	}
}
