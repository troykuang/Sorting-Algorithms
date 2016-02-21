package sort;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.princeton.cs.algs4.Stopwatch;
/**
 * JUnit testing for all sorting algorithms.
 * @author Chaoyi Kuang
 *
 */
public class SortTest {
	public ArrayList<Job[]> jobsLists;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Set up the testing environment. Construct the testing job lists
	 * @throws IOException
	 */
	@Before
	public void setUp() throws IOException {
		// An ArrayList that contains all the Job lists
		ArrayList<Job[]> jobsLists = new ArrayList<Job[]>();
		this.jobsLists = jobsLists;
		String folder = "data";
		File f = new File(folder + "/a2_in.txt");
		Scanner input = new Scanner(f);
		while (input.hasNextLine()) {
			String currentLine = input.nextLine();
			// Split the whole line by "," and get jobID and jobTime by trimming the substrings 
			String[] currentList = currentLine.split(",");
			int currentLength = currentList.length/2;
			Job[] currentJobs = new Job[currentLength];
			// Construct the current job and add it to the list
			for (int i=0;i<currentList.length;i++){
				String jobID = currentList[i].substring(1);
				int len= currentList[i+1].length();
				String jobTime = currentList[i+1].substring(0, len-1);
				currentJobs[i/2] = new Job(jobID,Integer.parseInt(jobTime));
				i++;
			}
			// Add this line of Job list to ArrayList
			jobsLists.add(currentJobs);
		}
		input.close();
		System.out.println("Job Lists Constructed");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test Regular Insertion Sort and measure its running time using the StopWatch library.
	 */
	@Test
	public void testInsertSort() {
		System.out.println("InsertSort Testing Begins:");
		for (int i=0;i<7;i++){
			Stopwatch sw = new Stopwatch();			
			Job[] current = this.jobsLists.get(i);
			double startTime = sw.elapsedTime();
			Insertion.sortInsert(current);
			double endTime = sw.elapsedTime();
			if (Insertion.isSorted(current)){
				int N = i+1;
				System.out.println("Execution time for Test Case "+ Integer.toString(N)+" is :"+(endTime - startTime));
			}
			assertTrue(Insertion.isSorted(current));
		}
		System.out.println("InsertSort Testing Ends.");
		System.out.println();
	}

	/**
	 * Test Comparable Insertion Sort and measure its running time using the StopWatch library.
	 */
  @Test
	public void testInsertComparable() {
	  System.out.println("InsertComparable Testing Begins:");
		for (int i=0;i<7;i++){
			Stopwatch sw = new Stopwatch();			
			Job[] current = this.jobsLists.get(i);
			int n = current.length;
			double startTime = sw.elapsedTime();
			Insertion.sortComparable(current, n);
			double endTime = sw.elapsedTime();
			if (Insertion.isSorted(current)){
				int N = i+1;
				System.out.println("Execution time for Test Case "+ Integer.toString(N)+" is :"+(endTime - startTime));
			}
			assertTrue(Insertion.isSorted(current));
		}
		System.out.println("InsertComparable Testing Ends.");
		System.out.println();
	}
	
  /**
   * Test Binary Insertion Sort and measure its running time using the StopWatch library.
   */
  @Test
	public void testInsertBinary() {
		System.out.println("InsertBinary Testing Begins:");
		for (int i=0;i<7;i++){
			Stopwatch sw = new Stopwatch();			
			Job[] current = this.jobsLists.get(i);
			int n = current.length;
			double startTime = sw.elapsedTime();

			Insertion.sortBinary(current, n);
		
			double endTime = sw.elapsedTime();
			if (Insertion.isSorted(current)){
				int N = i+1;
				System.out.println("Execution time for Test Case "+ Integer.toString(N)+" is :"+(endTime - startTime));
			}
			assertTrue(Insertion.isSorted(current));
		}
		System.out.println("InsertBinary Testing Ends.");
		System.out.println();
	}

  /**
   * Test Merge Sort and measure its running time using the StopWatch library.
   */
    @Test
	public void testMergeSort() {
		System.out.println("MergeSort Testing Begins:");
		for (int i=0;i<7;i++){
			Stopwatch sw = new Stopwatch();			
			Job[] current = this.jobsLists.get(i);
			int n = current.length;
			double startTime = sw.elapsedTime();

			Merge.sortMerge(current, n);
		
			double endTime = sw.elapsedTime();
			if (Merge.isSorted(current)){
				int N = i+1;
				System.out.println("Execution time for Test Case "+ Integer.toString(N)+" is :"+(endTime - startTime));
			}
			assertTrue(Merge.isSorted(current));
		}
		System.out.println("MergeSort Testing Ends.");
		System.out.println();
	}
	
    /**
	 * Test Heap Sort and measure its running time using the StopWatch library.
	 */
    @Test
	public void testHeapSort() {
		System.out.println("HeapSort Testing Begins:");
		for (int i=0;i<7;i++){
			Stopwatch sw = new Stopwatch();			
			Job[] current = this.jobsLists.get(i);
			int n = current.length;
			double startTime = sw.elapsedTime();
			
			Heap.sortHeap(current, n);
			
			double endTime = sw.elapsedTime();
			if (Heap.isSorted(current)){
				int N = i+1;
				System.out.println("Execution time for Test Case "+ Integer.toString(N)+" is :"+(endTime - startTime));
			}
			assertTrue(Heap.isSorted(current));
		}
		System.out.println("HeapSort Testing Ends.");
		System.out.println();
	}
	

}
