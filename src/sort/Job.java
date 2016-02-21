package sort;

public class Job implements Comparable<Job>{
	private String jobID;
	private int time;
	
	public Job(String w, int s)
	{
		if (s<0)
			throw new IllegalArgumentException();
		this.jobID = w;
		this.time = s;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public void setTime(int t)
	{
		this.time = t;
	}
	
	public String getJobID()
	{
		return jobID;
	}
	
	public void setJobID(String id)
	{
		this.jobID = id;
	}
	
	@Override
	public int compareTo(Job other)
	{
		if (this.time < other.time) return -1;
		else return 1; 
		
	}

	
	
	public String toString()
	{
		//TODO
		return String.format("%s,%.1f",jobID,time);
	}

}
