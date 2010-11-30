/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test
{
	public static void main(String[] args) {
		PageGenerator ref = new PageGenerator(new Integer(args[0]).intValue());

		int[] referenceString = ref.getReferenceString();

		/** Use either the FIFO or LRU algorithms */
		ReplacementAlgorithm fifo = new FIFO(new Integer(args[1]).intValue());
		ReplacementAlgorithm lru = new LRU(new Integer(args[1]).intValue());
		ReplacementAlgorithm lfu = newLFU(new Integer(args[1]).intValue());
		ReplacementAlgorithm mfu = new MFU(new Integer(args[1]).intValue());
		ReplacementAlgorithm optimal = new OPTIMAL(new Integer(args[1]).intValue());

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++) {
			//System.out.println("inserting " + referenceString[i]);
			lru.insert(referenceString[i]);
		}

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++) {
			//System.out.println("inserting " + referenceString[i]);
			fifo.insert(referenceString[i]);
		}

		// report the total number of page faults
		System.out.println("LRU faults = " + lru.getPageFaultCount());
		System.out.println("FIFO faults = " + fifo.getPageFaultCount());
		System.out.println("LFU faults = " + lfu.getPageFaultCount());
		System.out.println("MFU faults = " + mfu.getPageFaultCount());
		System.out.println("OPTIMAL faults = " + optimal.getPageFaultCount());
	}
}
