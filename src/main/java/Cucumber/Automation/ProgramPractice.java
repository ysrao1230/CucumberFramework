package Cucumber.Automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class ProgramPractice {

	public static void main(String[] args) {
		duplicateValuesInaArray();
		sumofDigits(567656);// 5+6+7+6+5+6=35
		leapYear();
		sumoftwoMatrices();
		reversingtheEachWord();
		separatenumberchardigit("yagdg#$%^6253536dFGHJ66473");
		int a[] = { 2, 3, 4, 2, 3, 4, 4, 4, 45, 4, 4, 4, 4, 4 };
		System.out.println("Majority of elements= " + majorityElementsinArray(a, a.length));

		Integer m[] = { 9, 1, 3, 6, 8, 0 };
		missingnumberintheArray(m);
		reverseAString();
		swappingvaluewithoutthirdvariable();
		System.out.println("Fibonic series given input is: " + fibinocseries(8));

	}

	public static void duplicateValuesInaArray() {
		int[] a = new int[] { 1, 2, 4, 4, 5, 6, 1, 3, 3, 3, 3, 9, 9, 9, 9, 9, 9, 9, 9 };

		int n = a.length;
		Arrays.sort(a);
		int i, j, frequency;
		for (i = 0; i < n; i++) {
			frequency = 1;
			for (j = i + 1; j < n; j++) {
				if (a[i] == a[j]) {
					frequency++;
				} else {
					break;
				}
			}
			i = j - 1;
			if (frequency > 1) {

				// printing the output
				System.out.println(a[i] + " --> " + frequency);

			}
		}

		// This Option only for the below 10 size of the Array
		System.out.println("This Option only for the below 10 size of the Array");
		int[] b = new int[] { 1, 2, 3, 4, 2, 7, 8, 8, 3 };
		for (int k = 0; k < b.length; k++) {
			for (int l = k + 1; l < b.length; l++) {
				if (b[k] == b[l])
					System.out.print(b[l] + " ");
			}
		}
		System.out.println("\nGetting duplicate values using collections");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean ifPresent = false;
		for (int c = 0; i < a.length - 1; c++) {
			for (int d = c + 1; d < a.length; d++) {
				if (a[c] == a[d]) {
					if (arr.contains(a[i])) {
						break;
					} else {
						arr.add(a[i]);
						ifPresent = true;
					}
				}

			}

		}
		if (ifPresent == true) {
			System.out.print(arr + " ");
		} else {
			System.out.println("No duplicate found in the given array");
		}
	}

	public static void sumofDigits(int n) {
		int sum = 0;
		int r;
		while (n > 0) {
			r = n % 10;
			sum = sum + r;
			n = n / 10;

		}
		System.out.println(" \r\n Sum of digit: " + sum);
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

	public static void reverseAString() {
		Scanner str = new Scanner(System.in);
		System.out.println("*******Please enter input string********");
		String input = str.nextLine();
		String reverse = "";
		for (int i = 0; i < input.length(); i++) {
			Character ch;
			ch = input.charAt(i);
			reverse = ch + reverse;
		}
		System.out.println("AFter reversing the string is: " + reverse);

		// Reversing the string using the string build
		StringBuilder strb = new StringBuilder();
		strb.append(input);
		strb.reverse();
		System.out.println("Reversing the String using the String builder:=> " + strb);

		// Reversing the string using the chararray
		char[] ch = input.toCharArray();
		System.out.println("Reversing the string using the character array:=> ");
		for (int i = ch.length - 1; i >= 0; i--)
			System.out.print(ch[i]);

	}

	public static void reversingtheEachWord() {
		// Reversing each word in the given string
		System.out.println("Please enter the string with different words");
		@SuppressWarnings("resource")
		Scanner value = new Scanner(System.in);
		String data = value.nextLine();
		String[] words = data.split(" ");

		String reverseString = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			String reverseWord = "";

			for (int j = word.length() - 1; j >= 0; j--) {
				reverseWord = reverseWord + word.charAt(j);
			}

			reverseString = reverseString + reverseWord + " ";
		}

		System.out.println(data);

		System.out.println(reverseString);

		System.out.println("-------------------------");

		String[] temp = reverseString.split(" ");
		String result = "";
		for (int i = 0; i < temp.length; i++) {

			result = " " + temp[i] + result;


		}
		System.out.println(result.trim());
	}

	public static void swappingvaluewithoutthirdvariable() {
		Scanner n1 = new Scanner(System.in);
		int num1 = n1.nextInt();
		Scanner n2 = new Scanner(System.in);
		int num2 = n2.nextInt();

		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		System.out.println("AFter swapping values");
		System.out.println(num1);
		System.out.println(num2);
	}

	public static int fibinocseries(int n) {
		int a = 0, b = 1, c;
		if (n == 0)
			return a;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	public static void sumoftwoMatrices() {
		int a[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		int b[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };

		int c[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				c[i][j] = a[i][j] + b[i][j];
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}

	public static void leapYear() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please eneter the year");
		int year = s.nextInt();

		if (year % 4 == 0 || year / 400 == 0 && year / 100 != 0) {
			System.out.println(year + " is a Leap year");
		} else {
			System.out.println(year + " is not a Leap year");
		}
	}
}
