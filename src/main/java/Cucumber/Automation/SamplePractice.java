package Cucumber.Automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SamplePractice {

	public static void main(String[] args) {
		String[] val = { "Srinivas", "radha", "ramesh" };

		List<String> a = new ArrayList<>(Arrays.asList(val));

		System.out.println(a);
		a.add("data");
		a.add("new data");
		System.out.println(a);
	}

}
