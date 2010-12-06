package main;
import page_generator.PageGenerator;
import replacement_algorithms.MFU;
import replacement_algorithms.ReplacementAlgorithm;

/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test_MFU
{
	public static void main(String[] args) {
		//PageGenerator ref = new PageGenerator();
		//int referenceString[] = ref.getReferenceString();

		// String do livro. Pg: 196.
		int referenceString[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};

		ReplacementAlgorithm mfu = new MFU(3,referenceString);
		mfu.executar();
		// report the total number of page faults
		System.out.println("\nMFU faults = " + mfu.getPageFaultCount());
	}
}
