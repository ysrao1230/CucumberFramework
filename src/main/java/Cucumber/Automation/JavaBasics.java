package Cucumber.Automation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaBasics {
	public static void main(String[] args) {

		List<String> name = new ArrayList<>();
		name.add("Srinivas");
		name.add("data");
		name.add("ish");
		Collections.addAll(name, "data1", "data3", "data3");

		System.out.println(name);
		System.out.println(name.size());
		System.out.println(name.get(2));
		name.add(0, "asija");
		System.out.println(name);
		System.out.println(name.size());
		System.out.println(name.get(2));
		name.remove("ish");
		System.out.println(name);
		System.out.println(name.size());
		System.out.println(name.get(2));
		System.out.println(name.isEmpty());
		name.add("Srinivas");
		System.out.println(name);
		System.out.println(name.size());
		Collections.sort(name);
		System.out.println(name);
		Collections.shuffle(name);
		System.out.println(name);
		name.clear();
		System.out.println("After clearing the list data: " + name);
		System.out.println("*****************");

		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Ram");
		map.put(2, null);
		map.put(2, "Mukesh");
		map.put(2, null);
		map.put(null, null);
		map.put(3, "Ram");
		System.out.println(map.size());
		System.out.println(map);

		Set<Integer> set = new HashSet<>();
		set.add(2);
		set.add(22);
		set.add(22);
		System.out.println(set);
		System.out.println(set.size());
		System.out.println(set.contains(33));
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}

	}
}
