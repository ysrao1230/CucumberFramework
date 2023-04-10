package Cucumber.Automation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class ProgramPractice {

	public static void main(String[] args) {
		reversingtheEachWord("Siva rama raju");
		separatenumberchardigit("yagdg#$%^6253536dFGHJ66473");
		int a[] = { 2, 3, 4, 2, 3, 4, 4, 4, 45, 4, 4, 4, 4, 4 };
		System.out.println("Majority of elements= " + majorityElementsinArray(a, a.length));

		Integer m[] = { 9, 1, 3, 6, 8, 0 };
		missingnumberintheArray(m);
		reverseAString();
		swappingvaluewithoutthirdvariable();
		System.out.println("Fibonic series given input is: " + fibinocseries(0));

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

	public static void reversingtheEachWord(String data) {
		// Reversing each word in the given string
		/*
		 * System.out.println("Please enter the string with different words"); Scanner
		 * value = new Scanner(System.in); String data = value.next();
		 */
		String[] words = data.split(" ");
        
        String reverseString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
             
            String reverseWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
             
            reverseString = reverseString + reverseWord + " ";
        }
         
        System.out.println(data);
         
        System.out.println(reverseString);
         
        System.out.println("-------------------------");
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
}
