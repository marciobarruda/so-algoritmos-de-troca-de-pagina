package main;
import page_generator.PageGenerator;
import replacement_algorithms.FIFO;
import replacement_algorithms.ReplacementAlgorithm;

/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test_FIFO
{
	public static void main(String[] args) {
		//PageGenerator ref = new PageGenerator();
		//int referenceString[] = ref.getReferenceString();

		// String do livro. Pg: 196.
		int referenceString[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};

		ReplacementAlgorithm fifo = new FIFO(3,referenceString);
		fifo.executar();
		// report the total number of page faults
		System.out.println("\nFIFO faults = " + fifo.getPageFaultCount());
	}
}
