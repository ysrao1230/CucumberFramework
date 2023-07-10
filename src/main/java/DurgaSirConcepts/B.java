package DurgaSirConcepts;

import java.util.ArrayList;

class A {
	static String name = "name";

	public String name() {
		return "hello workld";
	}
}

public class B extends C {
	public static void main(String[] args) {
		System.out.println(name);
		System.out.println();
		ArrayList aa = new ArrayList<>();
		aa.add(22);
		System.out.println(aa);
	}
}

class C extends A {
	static String name;
}
