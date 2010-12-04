package main;
import replacement_algorithms.LRU;
import replacement_algorithms.ReplacementAlgorithm;

/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test_LRU
{
	public static void main(String[] args) {
		//PageGenerator ref = new PageGenerator();
		//int referenceString[] = ref.getReferenceString();

		// String do livro. Pg: 196.
		int referenceString[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};

		ReplacementAlgorithm lru = new LRU(3);

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++)
		{
			//System.out.println("inserting " + referenceString[i]);
			lru.insert(referenceString[i]);
		}

		// report the total number of page faults
		System.out.println("\nLRU faults = " + lru.getPageFaultCount());
	}
}
