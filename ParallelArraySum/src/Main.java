import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		// Call the method GetUserInput to prompt the user for an array length
		// Save the returned integer value as the array length
		int arrayLengthInt = GetUserInput();
		
	    // Create random object
		Random rd = new Random();
		
		// Initialize array with user defined length
	    int[] arr = new int[arrayLengthInt];
	    
	    // Loop through the array to populate each element of the array
	    for (int i = 0; i < arr.length; i++) 
	    {
	    	// Assign a random integer value between 1 and 10 inclusive
	       arr[i] = rd.nextInt(10) + 1;
	       //System.out.println(arr[i]);
	    }
	    System.out.println("The array contains " + arr.length + " elements.");

	    
	    // Sum the array
	    int arraySum = 0;
	    for(int i : arr) 
	    {
	    	arraySum += i;
	    }
	    System.out.println("The array sum is: " + arraySum);

	}

	private static int GetUserInput() {
		System.out.println("Enter the integer amount of entries you want in the random array:");
		// Create a scanner object
	    Scanner userLengthInput = new Scanner(System.in);
	    int arrayLengthInt = 0;
	    
	    // Read in the input as a string. Try to parse it as an int
	    try
	    {
		    String arrayLengthString = userLengthInput.nextLine();
		    arrayLengthInt = Integer.parseInt(arrayLengthString);
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Error. Please enter a valid integer");
	    }

	    userLengthInput.close();
		return arrayLengthInt;
	}

}
