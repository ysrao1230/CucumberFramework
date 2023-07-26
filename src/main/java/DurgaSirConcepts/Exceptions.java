package DurgaSirConcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.management.RuntimeErrorException;

public class Exceptions {

	public static void main(String[] args) {
		System.out.println("Data1");
		try {
			Thread.sleep(3000); // Interrupted Exception==> Checked Exception which is identifed by the compiler
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		int i = 10;
		try {
			System.out.println(i / 0); // Arthemetic Exception==> Unched exception which is identifed by the run time
			// code
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage() + "is not possible in mathemetical expression");
		}

		try {
			int[] arry = new int[5]; // java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
			arry[10] = 100;
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		
		try {
			String str = "data";
			int in = Integer.parseInt(str);
			System.out.println("Afterer Parsing integer value is: " + in);
		} catch (NumberFormatException e) {
			System.out.println("Enter valid input to covert string to integer");
		}

		// Handling input and output exception
		try {
			FileInputStream fi = new FileInputStream("");
		} catch (FileNotFoundException e) {
			System.out.println("File not found to do the required operation, so please define the valid file path");
		} finally {
			System.out.println("File operation completed");
		}
		// Exception handling using throws

		//FileInputStream fn = new FileInputStream("");

		try {
			System.out.println("Data2");
			String s = null;
			System.out.println(s.toLowerCase()); // NullPointer exception-->Cannot invoke "String.toLowerCase()" because
													// "s" is null
		} catch (Exception e) {
			throw new RuntimeException("Invalid arguments");
		}
	}
}