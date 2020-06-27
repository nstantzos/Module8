
public class ThreadCompletionStatus 
{

	private boolean firstThreadDone;
	private boolean secondThreadDone;
	
	public boolean isFirstThreadDone() 
	{
		return firstThreadDone;
	}
	public void setFirstThreadDone(boolean firstThreadDone) 
	{
		this.firstThreadDone = firstThreadDone;
	}
	public boolean isSecondThreadDone() 
	{
		return secondThreadDone;
	}
	public void setSecondThreadDone(boolean secondThreadDone) 
	{
		this.secondThreadDone = secondThreadDone;
	}
}
