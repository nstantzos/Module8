
/*
Program written by Nick Stantzos on 06/27/2020. This program will prompt the user for an input to determine
the size of an array to be created and populated with random integers between 1 and 10 inclusive. The program
will then sum the array in two fashions: once with a single thread, and again with two threads. The run time
of each process will be printed out to the console. The double thread run splits the array into two halves, 
then each thread will sum one half and combine the sum after the summing has finished. 

There are multiple unit tests for this program. One test for each method in both processes (one for the single 
thread run, two for the double thread run), and one for the combination of threads in the double thread run.
*/
import java.util.Random;
import java.util.Scanner;

public class Main 
{	
	public static void main(String[] args) 
	{
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
	    }
	    
	    // Verify the input of the user by printing it back to the console.
	    System.out.println("The array contains " + arr.length + " elements.");
	    
	    // Initialize class objects for threads
	    // The ElapsedRunTime object stores the time results of each thread's runtime
	    ElapsedRunTime runTime = new ElapsedRunTime();
	    
	    // The ArraySum object stores the sum of the arrays for each run
	    ArraySum arraySum = new ArraySum();
	    
	    // The ThreadCompletionStatus object contains bools that indicate whether or not the two
	    // threads have finished running
	    ThreadCompletionStatus threadCompleted = new ThreadCompletionStatus();
	    
	    // Thread definition for the array sum using only a single thread
	    Thread singleThread = new Thread (new Runnable()
	    {
			@Override
			public void run() 
			{
				// Call the single thread sum method
				SingleThreadArraySum(arr, runTime, arraySum);
			}
	    });
	    
	    // Thread definition for the first thread in the multithreaded run
	    Thread firstThread = new Thread (new Runnable()
		{
			@Override
			public void run() 
			{
				// Call the first method of the double threaded sum
				FirstThreadArraySum(arr, runTime, arraySum, threadCompleted);
			}
		});
	    
	    // Thread definition for the second thread in the multithreaded run
	    Thread secondThread = new Thread (new Runnable()
		{
			@Override
			public void run() 
			{
				// Call the second method of the double threaded sum
				SecondThreadArraySum(arr, runTime, arraySum, threadCompleted);
			}
		});
	    
	    // Start single thread run
	    singleThread.start();
	    
    	// Wait for the single sum thread to finish
	    try
	    {
	    	singleThread.join();
	    }
	    catch (InterruptedException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    // Start double thread run
	    firstThread.start();
	    secondThread.start();
	    
    	// Wait for the threads to finish
	    try
	    {
	    	firstThread.join();
	    	secondThread.join();
	    }
	    catch (InterruptedException e)
	    {
	    	e.printStackTrace();
	    }
	    
	    // Make sure that the double thread run has finished before calculating runtime and sum
	    if (threadCompleted.isFirstThreadDone() && threadCompleted.isSecondThreadDone())
	    {
	    	// Get the smaller of the two start times. This will be the beginning time for the double threaded run
	    	long doubleThreadStartTime = Math.min(runTime.getFirstThreadStartTime(), runTime.getSecondThreadStartTime());
	    	
	    	// Get the larger of the two end times. This will be the end time of the run
	    	long doubleThreadEndTime = Math.max(runTime.getFirstThreadEndTime(),runTime.getSecondThreadEndTime());
	    	
	    	// Calculate elapsed run time of the double threads
	    	long doubleThreadElapsedTime = doubleThreadEndTime - doubleThreadStartTime;
	    	
	    	// Calculate the sum of the two threads and print to console
	    	long doubleThreadSum = arraySum.getFirstThreadArraySum() + arraySum.getSecondThreadArraySum();
	    	System.out.println("The dobule threaded array sum is: " + doubleThreadSum);
	    	System.out.println("The double threaded sum ran for " + doubleThreadElapsedTime + " milliseconds");
	    }	    
	}

	// Single thread method
	public static long SingleThreadArraySum(int[] arr, ElapsedRunTime runTime, ArraySum arraySum) 
	{
		long singleThreadArraySum = 0;
	    System.out.println("Run only one thread");
	    
		// Set timer
	    runTime.setSingleThreadStartTime(System.currentTimeMillis());
		// Sum the array
	    for(int i : arr) 
	    {
	    	singleThreadArraySum += i;
	    }
	    runTime.setSingleThreadEndTime(System.currentTimeMillis());
	    long elapsed = runTime.getSingleThreadEndTime() - runTime.getSingleThreadStartTime();
	    arraySum.setSingleThreadArraySum(singleThreadArraySum);
	    System.out.println("The array sum is: " + arraySum.getSingleThreadArraySum());
	    System.out.println("The elapsed run time for the single thread is " + elapsed + " milliseconds.");
	    
	    // Return the array sum for unit checking
	    return singleThreadArraySum;
	}

	// Method for running the first thread in the double thread run
	public static long FirstThreadArraySum(int[] arr, ElapsedRunTime runTime, ArraySum arraySum, ThreadCompletionStatus threadCompleted) 
	{
		// Initialize sum variable
		long firstThreadArraySum = 0;
		
	    System.out.println("Now run two threads");
		// Set timer
	    runTime.setFirstThreadStartTime(System.currentTimeMillis());
		// Sum the array
	    for(int i = 0; i < (arr.length)/2; i++) 
	    {
	    	firstThreadArraySum += arr[i];
	    }
	    // Get end time
	    runTime.setFirstThreadEndTime(System.currentTimeMillis());
	    
	    // Set completed flag
	    threadCompleted.setFirstThreadDone(true);
	    
	    // Get sum
	    arraySum.setFirstThreadArraySum(firstThreadArraySum);
	    
	    // Return first thread sum for unit checking
	    return firstThreadArraySum;
	}
	
	// Method for running the second thread in the double thread run
	public static long SecondThreadArraySum(int[] arr, ElapsedRunTime runTime, ArraySum arraySum, ThreadCompletionStatus threadCompleted) 
	{
		// Initialize sum variable
		long secondThreadArraySum = 0;
		
		// Set timer
		runTime.setSecondThreadStartTime(System.currentTimeMillis());
		// Sum the array
	    for(int i = (arr.length)/2; i < arr.length; i++) 
	    {
	    	secondThreadArraySum += arr[i];
	    }
	    
	    // Get end time of second thread
	    runTime.setSecondThreadEndTime(System.currentTimeMillis());
	    
	    // Set completed flag
	    threadCompleted.setSecondThreadDone(true);
	    
	    // Get sum
	    arraySum.setSecondThreadArraySum(secondThreadArraySum);
	    
	    // Return second thread sum for unit checking
	    return secondThreadArraySum;
	}
	
	// Method for gathering input from the user. Returns int value of array length
	private static int GetUserInput() 
	{
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
	    	// Exit program if no valid input is detected
	    	System.out.println("Error. Please enter a valid integer");
	    	System.exit(0);
	    }

	    userLengthInput.close();
		return arrayLengthInt;
	}

}
