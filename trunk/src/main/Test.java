package main;
import page_generator.PageGenerator;
import replacement_algorithms.ReplacementAlgorithm;
import replacement_algorithms.OPTIMAL;
import replacement_algorithms.FIFO;
import replacement_algorithms.LRU;
import replacement_algorithms.MFU;
import replacement_algorithms.LFU;

/**
 * Test harness for LRU and FIFO page replacement algorithms
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test
{
	public static void vetorImprimir(int vetor[])
	{
		System.out.print("{");		
		for (int i=0 ; i<vetor.length ; i++)
		{
			System.out.print(vetor[i]);
			//Nao exibir a virgula depois do ultimo numero:
			if (i != (vetor.length-1))
				System.out.print(",");
		}
		System.out.print("}\n");
	}

	public static void main(String[] args)
	{
		// Passar argumentos por parametro:
		//int argumento_0 = new Integer(args[0]).intValue();
		//int argumento_1 = new Integer(args[1]).intValue();
		int argumento_0 = 1000;
		int argumento_1 = 900;

		// Gerando o vetor de paginas aleatorias:
		PageGenerator ref = new PageGenerator(argumento_0);
		int referenceString[] = ref.getReferenceString();

		// Instanciando os cinco algoritmos de Troca de Pagina:
		ReplacementAlgorithm optimal = new OPTIMAL(argumento_1, referenceString);
		ReplacementAlgorithm fifo    = new FIFO(argumento_1, referenceString);
		ReplacementAlgorithm lru     = new LRU(argumento_1, referenceString);
		ReplacementAlgorithm mfu     = new MFU(argumento_1, referenceString);
		ReplacementAlgorithm lfu     = new LFU(argumento_1, referenceString);

		System.out.println("String de Referencia:");
		vetorImprimir(referenceString);

		System.out.println("\n* OPTIMAL:");
		optimal.executar();

		System.out.println("\n* FIFO:");
		fifo.executar();

		System.out.println("\n* LRU:");
		lru.executar();

		System.out.println("\n* MFU:");
		mfu.executar();		

		System.out.println("\n* LFU:");
		lfu.executar();

		// report the total number of page faults
		System.out.println("\nOPTIMAL faults = " + optimal.getPageFaultCount());
		System.out.println("FIFO faults = " + fifo.getPageFaultCount());		
		System.out.println("LRU faults = " + lru.getPageFaultCount());
		System.out.println("MFU faults = " + mfu.getPageFaultCount());
		System.out.println("LFU faults = " + lfu.getPageFaultCount());
	}
}
