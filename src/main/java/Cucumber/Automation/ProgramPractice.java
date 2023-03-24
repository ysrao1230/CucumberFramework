package Cucumber.Automation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ProgramPractice {

	public static void main(String[] args) {
		separatenumberchardigit("yagdg#$%^6253536dFGHJ66473");
		int a[] = { 2, 3, 4, 2, 3, 4, 4, 4, 45, 4, 4, 4, 4, 4 };
		System.out.println("Majority of elements= " + majorityElementsinArray(a, a.length));

		Integer m[] = { 9, 1, 3, 6, 8, 0 };
		missingnumberintheArray(m);

	}

	static int majorityElementsinArray(int a[], int size) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : a) {
			Integer val = map.get(i);
			if (val == null) {
				map.put(i, 1);
			} else {
				map.put(i, val + 1);
			}

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				if (m.getValue() > size / 2) {
					return m.getKey();
				}
			}
		}
		return -1;
	}

	public static void missingnumberintheArray(Integer a[]) {
		HashSet<Integer> hashset = new HashSet<Integer>();

		for (int i : a) {
			hashset.add(i);
		}
		int n = a.length + 1;
		for (int i = 0; i < n; i++) {
			if (!hashset.contains(i)) {
				System.out.println(i);
			}
		}
	}

	public static void separatenumberchardigit(String data) {
		String number = "";
		String alph = "";
		String symbol = "";
		for (int i = 0; i < data.length(); i++) {
			char a = data.charAt(i);
			if (Character.isDigit(a)) {
				number = number + a;
			} else if (Character.isLetter(a)) {
				alph = alph + a;
			} else {
				symbol = symbol + a;
			}
		}
		System.out.println("Before Splitting: " + data);
		System.out.println("After Split: ");
		System.out.println("Numbers in a String: " + number);
		System.out.println("Alphabets in a string: " + alph);
		System.out.println("SPecial characters in a string: " + symbol);
	}
}
