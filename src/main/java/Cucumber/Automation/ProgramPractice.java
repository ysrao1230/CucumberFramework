package Cucumber.Automation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgramPractice {

	public static void main(String[] args) {
		// shiftArrayindexposition();
		int a[] = { 2, 3, 4, 2, 3, 4, 4, 4, 45, 4, 4, 4, 4, 4, 22 };
		// gettingUniqueValuesFromArray(a);
		// findnumberofoccurancesinaString("yamalapalli srinivasa rao");
		// twoArraysAreEqual();
		// largestNumberOfInputs(12, 1, 9);
//numberOfEvenAndOdd();
		// duplicateValuesInaArray();
//		sumofDigits(567656);// 5+6+7+6+5+6=35
//		leapYear();
//		sumoftwoMatrices();
//		reversingtheEachWord();
		// separatenumberchardigit("CMP717!@#");
//
//		System.out.println("Majority of elements= " + majorityElementsinArray(a, a.length));
//
//		Integer m[] = { 9, 1, 3, 6, 8, 0 };
//		missingnumberintheArray(m);
//		reverseAString();
//		swappingvaluewithoutthirdvariable();
		System.out.println("/nFibonic series given input is: " + fibinocseries(8));

	}

	public static void gettingUniqueValuesFromArray(int[] arra) {
		int length = arra.length;
		System.out.println("Array Length is: " + length);
		for (int a : arra) {
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println("\nUnique value is: ");
		for (int i = 0; i < length; i++) {
			int count = 0;
			for (int j = 0; j < length; j++) {
				if (arra[i] == arra[j]) {
					count++;
				}
			}
			if (count == 1)
				System.out.println(arra[i]);
		}

	}

	private static void twoArraysAreEqual() {
		int a[] = { 1, 2, 3, 4, 5, 5, 4 };
		int b[] = { 1, 2, 3, 4, 5 };

		boolean result = true;
		if (a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					result = false;
				}
			}

		} else {
			result = false;
		}
		if (result == true) {
			System.out.println("two arrays are equal");
		} else {
			System.out.println("\nTwo arrays are not equal");
		}

		// Maximum and Minimum of array
		System.out.println("Maximum and Minimum of the Array in the given array");
		int max = a[0];
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("Max value in the array is: " + max);
		System.out.println("Min value in the array is: " + min);

		// Duplicate Elements
		HashSet<Integer> num = new HashSet<Integer>();
//		System.out.println(num.add(1));
//		System.out.println(num.add(2));
//		System.out.println(num.add(3));
//		System.out.println(num.add(1));
		boolean duplicate = false;
		for (int i : a) {
			if (num.add(i) == false) {
				System.out.println("Found the duplicate element is: " + i);
				duplicate = true;
			}
		}
		if (duplicate == false) {
			System.out.println("Duplicate element not found");
		}

	}

	public static void largestNumberOfInputs(int a, int b, int c) {
		// Using the ternary operator
		int largest = a > b ? a : b;
		int laregst2 = c > largest ? c : largest;
		System.out.println("Largest number is: " + laregst2);
		// Random string generation
		System.out.println("RandomString with length 12");
		System.out.println(RandomStringUtils.randomAlphabetic(6, 12));
		System.out.println(RandomStringUtils.randomAlphanumeric(8));
	}

	public static void numberOfEvenAndOdd() {
		System.out.println("Enter the Number  ");
		Scanner n = new Scanner(System.in);
		int n1 = n.nextInt();

		int evenNum = 0;
		int odNum = 0;

		while (n1 != 0) {
			int rem = n1 % 10;
			if (rem % 2 == 0) {
				evenNum++;
			} else {
				odNum++;
			}
			n1 = n1 / 10;
		}
		System.out.println("Number of Even digits: " + evenNum);
		System.out.println("Number of Odd digits: " + odNum);
	}

	public static void duplicateValuesInaArray() {
		int[] a = new int[] { 1, 2, 4, 4, 5, 6, 1, 3, 3, 3, 3, 9, 9, 9, 9, 9, 9, 9, 9 };

		// Sum of the given Array values

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];

			if (a[i] % 2 == 0) {
				System.out.print(a[i] + " ");
			} else {
				System.out.print(a[i] + " ");
			}
		}
		System.out.println("Sum of the givenvalues is: " + sum);

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
			if (frequency == 1) {

				// printing the output
				System.out.print(a[i] + " --> " + frequency);

			}
			System.out.println();
			// System.out.println("Unique values in the given Array");
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
		if (ifPresent == false) {
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
		System.out.println("Before Splitting: " + data);
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
		int n = Integer.parseInt(number) + 1;
		System.out.println(String.valueOf(n));
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
			System.out.print(b + " ");
		}
		return b;
	}

	public static void sumoftwoMatrices() {
		int a[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
		int b[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };

		int c[][] = new int[a.length][a.length];
		System.out.println("************Sum Of Two Matrices is********");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
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

	public static void findnumberofoccurancesinaString(String str) {
		System.out.println("\nGiven input string is: " + str);
		str = str.replaceAll("\\s", "");

		char ch[] = str.toCharArray();
		Arrays.sort(ch);

		HashMap<Character, Integer> chardata = new HashMap<Character, Integer>();

		for (char c : ch) {
			if (chardata.containsKey(c)) {
				chardata.put(c, chardata.get(c) + 1);
			} else {
				chardata.put(c, 1);
			}
		}
		System.out.println("characters-wise count: ");
		for (Map.Entry<Character, Integer> chs : chardata.entrySet()) {
			if (chs.getValue() >= 1) {
				System.out.println(chs.getKey() + " " + chs.getValue());
			}
		}
		System.out.println("Only duplicate characters");
		for (Map.Entry<Character, Integer> chs : chardata.entrySet()) {
			if (chs.getValue() > 1) {
				System.out.print(chs.getKey() + " ");
			}
		}
		System.out.println();

	}

	public static void shiftArrayindexposition() {

		// input a={1,2,3,4,5}
		// output b={5,1,2,3,4}
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = new int[a.length];

		b[0] = a[a.length - 1];
		for (int i = 0; i < a.length - 1; i++) {
			b[i + 1] = a[i];
		}

		for (int j = 0; j < b.length; j++) {
			System.out.print(b[j] + " ");
		}
		System.out.println();
	}

}
