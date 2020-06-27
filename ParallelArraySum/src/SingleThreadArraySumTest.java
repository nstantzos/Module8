import static org.junit.Assert.*;
import org.junit.Test;

public class SingleThreadArraySumTest 
{

	@Test
	public void test() 
	{
		// Initialize test array. The sum should be 15
		int[] arr = {1,2,3,4,5};
		
		ElapsedRunTime runTime = new ElapsedRunTime();
		ArraySum arraySum = new ArraySum();
		
		// Get sample sum from method to be tested
		long sum = Main.SingleThreadArraySum(arr,runTime,arraySum);
		
		// If sum does not equal 15 (the sample array sum), then the test fails
		assertEquals(15,sum);
	}
}
