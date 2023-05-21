package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
	public static void main(String[] args) throws IOException {
		duplicateCharactersinAString("yamalapalli srinivasa rao");
		System.out.println();
		duplicateCharactersInAString("yamalapalli srinivasa rao");
		excelRead();
		leapYear();
		listOfEvenNumbers();
		replacemnetofArrayList();
		int a[] = { 3, 2, 1, 0, 9, 6 };
		int b[] = { 3, 2, 1, 0, 9, 6 };
		palindromNumber(232);
		comparisonOftwoArrays(a, b);

		largestElementInAnArray();
		int arra[] = { 4, 5, 2, 7, 8 };
		int index = elementPresentInArray(arra, arra.length, 8);
		if (index == -1)
			System.out.println("Element is not present in the array");
		else
			System.out.println("Element found at position " + index);

		int num = 2, pow = 5;
		System.out.println(num + " to the power of " + pow + " value is:=> " + Math.pow(num, pow));
		patternPrograms(6);
		reverseAString("a");
		factorialNumber(10);
		System.out.println(reverseANumber(6));
		fibonicSeries();

	}

	public static void reverseAString(String s) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("ENter the String");
		s = sc.nextLine();
		System.out.println("Original String is:=>" + s);
		String reverse = "";
		int length = s.length();
		for (int i = 0; i < length; i++) {
			reverse = s.charAt(i) + reverse;
		}
		System.out.println("After reversing the string=>" + reverse);
		if (s.equals(reverse)) {
			System.out.println("Given String is Palindrom");
		} else {
			System.out.println("Given string is not a palindrom");
		}

		// Removing the white spaces from the test
		System.out.println("After remving the white space=>>> " + s.replaceAll("\\s", ""));

		System.out.println("**********************************************");
		// Login for the reversing the each word
		System.out.println("Before Reversing the each word:=> " + s);
		String[] words = s.split(" ");
		String reversedString = "";
//		System.out.println(s.split(" ")[2].toUpperCase());
		String word = null;
		for (int i = 0; i < words.length; i++) {
			word = words[i];
			String reverseWord = "";
			System.out.println(word);
			for (int j = word.length() - 1; j >= 0; j--) {
				/*
				 * The charAt() function returns the character at the given position in a string
				 */
				reverseWord = reverseWord + word.charAt(j);
			}
			reversedString = reversedString + reverseWord + " ";
		}

		System.out.println("After Reversing the each word:=> " + reversedString);
	}

	public static void factorialNumber(int n) {
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println("Factorial of the " + n + " is: " + fact);

	}

	public static int reverseANumber(int num) {

		@SuppressWarnings("resource")
		Scanner number = new Scanner(System.in);
		System.out.println("Enter the Number ");
		num = number.nextInt();
		int reversenum = 0;
		while (num != 0) {
			reversenum = reversenum * 10;
			reversenum = reversenum + num % 10;
			num = num / 10;
		}

		// System.out.println("Reverse of input number is: " + reversenum);
		if (num % 2 == 0) {
			System.out.println("Given Number is Even number");
		} else {
			System.out.println("Given Number is Oddd Number");
		}
		return reversenum;
	}

	// Pattern Programs
	public static void patternPrograms(int numberOfRows) {
		int rows, colm;
		for (rows = 0; rows < numberOfRows; rows++) {
			for (colm = 0; colm <= rows; colm++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	// Fibonic series
	public static void fibonicSeries() {
		int a = 0, b = 1, c;
		@SuppressWarnings("resource")
		Scanner n = new Scanner(System.in);
		System.out.println("Enter the number for fibonic");
		int num = n.nextInt();
		for (int i = 2; i <= num; i++) {
			c = a + b;
			System.out.println(c);
			a = b;
			b = c;

		}

	}

	// Element present in the array
	// Array Programs
	public static int elementPresentInArray(int arr[], int n, int x) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		return -1;

	}

	public static void largestElementInAnArray() {
		int[] arra = { 5, 6, 12, 34, 56, 4, 3, 1 };
		int size = arra.length;
		int max = arra[0];
		for (int i = 0; i <= size - 1; i++) {
			if (arra[i] > max) {
				max = arra[i];
			}
		}
		System.out.println("maximum value is: " + max);

		// Another approach
		Arrays.sort(arra);
		System.out.println("Largest vallue in the Given Array: " + arra[size - 1]);
	}

	public static void sortingArray() {
		int array[] = { 64, 44, 54, 32, 67, 21, 88, 99, 0, 2, 4, 5 };
		System.out.println("Before sorting values are :");
		for (int i : array) {
			System.out.print(i + " ");
		}
		Arrays.sort(array);
		System.out.println("\nAfter sorting arrays values is: ");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void comparisonOftwoArrays(int[] a, int[] b) {
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
			System.out.println("Given Two Arrays are Equals");
		} else {
			System.out.println("Given Two Arrays are different");
		}

		boolean results = Arrays.equals(a, b);
		if (results == true) {
			System.out.println("Given Two Arrays are Equals");
		} else {
			System.out.println("Given Two Arrays are different");

		}
//Sum of the array Values
		int sum = 0;
		for (int i : b) {
			sum = sum + i;
		}
		System.out.println("Sum of the Array value is the=> " + sum);

	}

	public static void palindromNumber(int num) {
		int sum = 0, r;
		int temp = num;
		while (num != 0) {
			r = num % 10;
			sum = sum * 10 + r;
			num = num / 10;
		}
		if (temp == sum) {
			System.out.println("Given input number " + temp + " is palindrom");
		} else {
			System.out.println("Given input number " + temp + " is not a palindrom");
		}
	}

	public static void replacemnetofArrayList() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("A");
		data.add("B");
		data.add("C");
		data.add("D");
		data.add("E");
		data.add("F");

		System.out.println(data);

		data.set(5, "M");
		System.out.println(data);
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
	}

	public static void listOfEvenNumbers() {
		System.out.println("Please eneter the number to get the list of even numbers");
		@SuppressWarnings("resource")
		Scanner d = new Scanner(System.in);
		int n = d.nextInt();

		for (int i = 0; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.print(i + ",");
			}
		}
		System.out.println();
	}

	public static void leapYear() {
		System.out.println("Enter the year Value to the leap year or not");
		@SuppressWarnings("resource")
		Scanner d = new Scanner(System.in);
		int year = d.nextInt();
		if (year % 4 == 0 || year / 400 == 0 && year / 100 != 0) {
			System.out.println("Year " + year + " is leap Year");
		} else {
			System.out.println("Year " + year + " is not leap Year");
		}
	}

	public static void excelRead() throws IOException {
		String filepath = "C:\\Users\\srinivasy\\Downloads\\Client Management List_export_1683535708243.xlsx";
		String filepath1 = "C:\\Users\\srinivasy\\Documents\\SKypeFiles\\usernameandPassword.xlsx";
		FileInputStream fi = new FileInputStream(filepath1);
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("Total number of Rows: " + rows);
		System.out.println("Total number of Cols: " + cols);

		// this is for the only string values
		for (int r = 0; r <= rows; r++) {
			for (int c = 0; c < cols; c++) {
				String cellvalue = sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.print(cellvalue + " | ");
			}
			System.out.println();
		}

		// This is for the numeric, String, Boolean
		for (int r = 0; r <= rows; r++) {
			XSSFRow rows1 = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = rows1.getCell(c);
				switch (cell.getCellType()) {
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}

	public static void duplicateCharactersInAString(String inputString) {

		inputString = inputString.replaceAll("\\s", "");

		HashMap<Character, Integer> characts = new HashMap<Character, Integer>();
		char[] strArray = inputString.toCharArray();
		Arrays.sort(strArray);
		for (char c : strArray) {
			if (characts.containsKey(c)) {
				characts.put(c, characts.get(c) + 1);
			} else {
				characts.put(c, 1);
			}
		}

		for (Map.Entry<Character, Integer> elem : characts.entrySet()) {
			System.out.println(elem.getKey() + " " + elem.getValue());
		}
	}

	public static void duplicateCharactersinAString(String str) {
		System.out.println("The string is:" + str);
		str = str.replaceAll("\\s", "");
		char[] carray = str.toCharArray();

		System.out.print("Duplicate Characters in above string are: ");
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			if (carray[i] == '0')
				continue;
			for (int j = i + 1; j < str.length(); j++) {
				if (carray[i] == carray[j]) {
					count++;
					carray[j] = '0';
				}
			}
			if (count > 1) {
				System.out.print(carray[i] + " ");
			}
		}
		// Another Approach
		System.out.println();

		char s[] = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		System.out.print("The duplicate characters in the string are: ");
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.print(entry.getKey() + " ");
			}
		}
	}

}
