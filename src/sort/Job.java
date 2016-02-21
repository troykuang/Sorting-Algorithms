package sort;

/**
 * an abstract data type called Job that implements the Comparable interface.
 * @author Chaoyi Kuang
 *
 */
public class Job implements Comparable<Job>{
	private String jobID;
	private int time;
	
	/**
	 * Job constructor
	 * @param w - String for Job ID
	 * @param s - String for Job time
	 */
	public Job(String w, int s)
	{
		if (s<0)
			throw new IllegalArgumentException();
		this.jobID = w;
		this.time = s;
	}
	
	/**
	 * A method that returns the execution time of a job
	 * @return execution time as an int
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * A method that set the execution time of a job to t
	 * @param t - time of a job
	 */
	public void setTime(int t)
	{
		this.time = t;
	}
	
	/**
	 * A method that returns the name of a job
	 * @return a String contains the name of a job
	 */
	public String getJobID()
	{
		return jobID;
	}
	
	/**
	 * A method that set the name of a job to id
	 * @param id - the name of a job
	 */
	public void setJobID(String id)
	{
		this.jobID = id;
	}
	
	/**
	 * Compares this job with the specified job for order. Returns a negative 
	 * integer, or a positive integer as the execution time if this job is 
	 * less than, or greater or equal to that of the specified job.
	 * @param other - the other specified job
	 * @return a negative integer, or a positive integer as the execution time of this job is 
	 * less than, or greater or equal to that of the specified job.
	 */
	@Override
	public int compareTo(Job other)
	{
		if (this.time < other.time) return -1;
		else return 1; 
		
	}

	/**
	 * Returns a string representation of the job including the jobID and execution time
	 * @return a string representation of the job including the jobID and execution time
	 */
	public String toString()
	{
		return String.format("%s,%.1f",jobID,time);
	}
}
