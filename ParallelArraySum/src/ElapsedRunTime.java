
public class ElapsedRunTime 
{
	
	// Fields to hold start and end times for each thread run
    private long singleThreadStartTime;
    private long singleThreadEndTime;
    private long firstThreadStartTime;
    private long firstThreadEndTime;
    private long secondThreadStartTime;
    private long secondThreadEndTime;

	public long getFirstThreadStartTime() 
	{
		return firstThreadStartTime;
	}

	public void setFirstThreadStartTime(long firstThreadStartTime) 
	{
		this.firstThreadStartTime = firstThreadStartTime;
	}

	public long getFirstThreadEndTime() 
	{
		return firstThreadEndTime;
	}

	public void setFirstThreadEndTime(long firstThreadEndTime) 
	{
		this.firstThreadEndTime = firstThreadEndTime;
	}

	public long getSecondThreadStartTime() 
	{
		return secondThreadStartTime;
	}

	public void setSecondThreadStartTime(long secondThreadStartTime) 
	{
		this.secondThreadStartTime = secondThreadStartTime;
	}

	public long getSecondThreadEndTime() 
	{
		return secondThreadEndTime;
	}

	public void setSecondThreadEndTime(long secondThreadEndTime) 
	{
		this.secondThreadEndTime = secondThreadEndTime;
	}

	public long getSingleThreadStartTime() 
	{
		return singleThreadStartTime;
	}

	public void setSingleThreadStartTime(long singleThreadStartTime) 
	{
		this.singleThreadStartTime = singleThreadStartTime;
	}

	public long getSingleThreadEndTime() 
	{
		return singleThreadEndTime;
	}

	public void setSingleThreadEndTime(long singleThreadEndTime) 
	{
		this.singleThreadEndTime = singleThreadEndTime;
	}
	
	
}
