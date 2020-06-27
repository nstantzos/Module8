import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleThreadTest 
{

	@Test
	public void test() 
	{
		// Initialize test array. The sum should be 15
		int[] arr = {1,2,3,4,5};
		
		// Initialize class objects to pass to methods
		ElapsedRunTime runTime = new ElapsedRunTime();
		ArraySum arraySum = new ArraySum();
		ThreadCompletionStatus threadCompleted = new ThreadCompletionStatus();
		
		// Get sample sums from first and second thread methods
		long firstSum = Main.FirstThreadArraySum(arr,runTime,arraySum, threadCompleted);
		long secondSum = Main.SecondThreadArraySum(arr,runTime,arraySum, threadCompleted);
		
		// Calculate final sum of sample array
		long totalSum = firstSum + secondSum;
		
		// If the sum doesn't equal 15 then the test fails
		assertEquals(15,totalSum);
	}

}
