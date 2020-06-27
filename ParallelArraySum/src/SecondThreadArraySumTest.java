import static org.junit.Assert.*;

import org.junit.Test;

public class SecondThreadArraySumTest 
{

	@Test
	public void test() 
	{
		// Initialize test array. The sum should be 15
		int[] arr = {1,2,3,4,5};
		
		ElapsedRunTime runTime = new ElapsedRunTime();
		ArraySum arraySum = new ArraySum();
		ThreadCompletionStatus threadCompleted = new ThreadCompletionStatus();
		
		// Get sample sum from method to be tested
		long sum = Main.SecondThreadArraySum(arr,runTime,arraySum, threadCompleted);
		System.out.println(sum);

		// If sum does not equal 12 (the second half of the sample array sum), then the test fails
		// This is only set to 12 because doing an integer division by 2 of the length, 5, gives 2
		// Therefore the first thread will only loop through the first two elements of the array
		// The second thread will loop through the last three elements, bringing the sum to 12
		assertEquals(12,sum);
	}

}
