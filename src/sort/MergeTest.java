package sort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeTest {
	Job[] a = new Job[16];
	String jobs = "{2cae5996-cca5-4818-a45a-4d53cdb7f992,117},{3a9e169b-8a15-4cee-9ca7-70c157fa6495,855},{5be88fff-0a2e-4fba-b7a4-f2dc71a609dd,257},{7d78228d-42cb-4385-b673-3973f87ccfcb,327},{ade0d902-ec64-405c-b111-2ac2e91599a4,638},{9ef43343-cdc6-499e-98cb-7accb236441d,515},{d92cc4c8-8338-4d23-b145-5e2fe81bcc69,847},{469ed15f-7ea5-4992-a22f-9b2f19b9f277,890},{f9a9fc30-9d98-4c1c-8072-e09bb47abfb6,364},{f6892806-ca4c-4183-b6ed-669b7ab85db5,947},{c43a4e70-3a07-4dd4-94f2-98609f342801,1004},{7bdf4b3b-31fa-4583-a212-76f81374fc79,638},{dd2d5bc6-d718-48c7-90f0-21d230488f4b,185},{cfa36f8e-8a3b-4bdd-bae6-fed08d5ea577,326},{d736949a-c05c-49a9-9f4a-91664c9a2199,586},{3100626d-ecc5-4781-9c76-dbd09a1b7fc1,899}";
	String[] b = jobs.split(",");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Start Texting");
		for (int i =0;i<b.length;i++){
			String c = b[i].substring(1);
			int len= b[i+1].length();
			String d = b[i+1].substring(0, len-1);
			a[i/2]= new Job(c,Integer.parseInt(d));
			i++;
		}
		System.out.println("Job array created");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSortMerge() {
		Merge.sortMerge(a, 16);
		assertTrue(Insertion.isSorted(a));
		System.out.println("SortMerge test passed.");
		
	}

}
