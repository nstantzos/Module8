import java.util.Random;


public class Main 
{


	public static void main(String[] args)
	{
		// Create random object
	    Random rand = new Random();

	    // Initialize array of size 100 million
	    int[] arr = new int[100000000];

	    // Randomize numbers between 1 and 10
	    for (int i = 0; i < arr.length; i++) 
	    {
	        arr[i] = rand.nextInt(10) + 1; // 1..100
	    }

	    // Initialize timer variable for single threaded run
	    long start = System.currentTimeMillis();

	    // Start single thread run
	    int total = Summation.sum(arr);
	    System.out.println("The single array total is: " + total);

	    System.out.println("Single: " + (System.currentTimeMillis() - start)); // Single: 44
	    
	    // Initialize timer variable for multi threaded run
	    start = System.currentTimeMillis();

	    Summation.parallelSum(arr);

	    System.out.println("Parallel: " + (System.currentTimeMillis() - start)); // Parallel: 25
	}
}
