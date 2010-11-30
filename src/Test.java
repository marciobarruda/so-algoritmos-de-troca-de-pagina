/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test
{
	public static void main(String[] args) {
		PageGenerator ref = new PageGenerator();
		int[] referenceString = ref.getReferenceString();

		ReplacementAlgorithm fifo = new FIFO(3);

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++)
		{
			//System.out.println("inserting " + referenceString[i]);
			fifo.insert(referenceString[i]);
		}


		// report the total number of page faults
		System.out.println("\nFIFO faults = " + fifo.getPageFaultCount());
	}
}
