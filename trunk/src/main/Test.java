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

		// Tamanho da String de Referencia:
		int argumento_0 = 1000;
		// Tamanho do Frame Buffer:
		int argumento_1 = 9;

		// Gerando o vetor de paginas aleatorias:
		//PageGenerator ref = new PageGenerator(argumento_0);
		//int referenceString[] = ref.getReferenceString();
		int referenceString[] = {3,1,1,6,5,2,2,7,5,6,8,9,0,2,0,9,7,8,0,9,0,3,5,2,1,4,5,4,2,5,0,4,4,6,8,3,0,5,0,8,3,2,7,0,5,9,4,1,5,1,8,0,5,6,6,4,9,5,1,6,8,8,6,4,9,7,8,7,4,1,8,5,9,1,3,2,8,9,0,4,6,4,7,2,1,1,8,5,8,6,6,1,0,9,9,5,8,9,1,0,9,7,3,9,8,6,0,7,2,1,0,5,7,0,7,9,4,8,1,3,9,0,0,4,2,1,0,1,1,2,2,0,3,9,1,5,5,5,9,5,4,9,3,5,8,8,5,0,7,9,1,3,1,2,9,3,9,7,2,9,6,1,1,2,3,2,3,1,2,2,5,0,9,1,9,4,0,1,1,6,6,1,9,5,3,9,3,3,9,9,8,1,1,2,6,9,3,8,6,5,7,8,1,4,4,9,2,4,2,0,7,7,9,2,9,8,3,1,7,9,0,1,8,2,3,6,3,7,9,8,9,5,5,1,9,5,8,9,8,0,7,3,8,1,1,3,6,3,8,1,3,0,2,9,1,5,2,2,2,2,6,3,9,1,6,7,2,7,2,5,9,3,7,9,2,4,4,6,2,8,5,5,8,3,3,7,2,0,2,5,4,5,8,5,6,5,8,3,4,0,6,5,4,8,5,2,4,5,8,5,0,8,0,4,8,9,4,4,8,7,2,6,7,5,1,0,9,8,5,4,9,9,1,9,3,9,2,9,4,3,1,2,5,7,6,6,7,7,4,1,4,9,9,8,5,6,8,0,1,7,9,7,1,6,4,5,7,4,6,0,5,2,0,7,3,6,2,6,2,8,5,6,4,7,1,0,8,2,3,7,3,8,4,1,9,5,9,0,9,8,9,6,8,0,9,2,1,3,4,4,2,1,0,8,3,1,7,3,2,1,4,5,8,3,2,4,7,1,6,4,3,6,0,3,9,8,0,1,2,2,5,7,5,0,6,4,4,0,4,8,9,6,6,4,2,8,3,2,6,7,5,4,0,6,5,1,3,7,8,6,5,3,6,9,2,2,8,0,2,5,9,5,6,4,1,9,0,3,7,2,6,9,7,6,4,2,2,1,9,6,5,2,1,5,7,9,7,3,0,9,0,4,5,3,1,9,3,7,1,6,4,2,7,3,4,9,1,5,5,3,1,0,9,7,0,2,7,6,7,7,4,7,1,9,4,4,8,7,8,4,6,6,6,0,4,6,0,5,2,6,0,3,9,4,5,2,7,2,3,9,0,9,8,0,9,1,4,9,2,2,9,9,8,9,9,5,7,0,0,4,2,1,3,7,0,2,1,7,6,1,5,3,7,6,7,7,9,5,2,2,6,1,8,2,2,0,8,7,3,1,2,4,7,5,8,1,5,7,7,9,3,8,4,7,1,0,5,4,4,3,9,6,6,3,5,4,5,4,0,3,7,6,0,8,1,9,3,8,8,3,4,0,0,4,3,4,4,7,0,2,4,6,6,7,9,0,3,3,3,7,9,8,8,4,8,6,8,9,4,0,8,0,8,7,5,7,6,8,4,0,1,7,3,0,4,1,9,5,6,4,1,4,2,1,1,7,7,3,5,2,2,3,7,8,9,7,9,4,4,4,0,5,6,3,0,7,9,5,6,8,5,1,8,5,7,2,4,7,2,9,7,6,6,8,6,0,3,4,0,8,6,2,0,4,8,2,3,5,2,9,5,9,6,6,0,6,1,9,6,5,8,5,4,7,4,2,1,3,9,7,1,7,5,9,6,2,7,8,5,2,8,7,4,1,9,5,2,7,9,1,1,9,3,7,8,9,9,6,5,9,8,3,1,0,4,9,8,2,1,2,1,0,7,6,0,6,4,2,0,6,8,5,9,6,7,6,1,2,1,8,7,2,5,0,9,4,1,1,2,4,0,0,7,7,5,1,4,7,7,5,2,5,0,7,6,8,4,6,0,6,5,7,5,1,4,6,9,9,2,7,2,8,8,1,0,1,1,4,7,1,9,2,4,4,8,7,4,5,5,7,6,4,8,2,3,9,0,2,4,5,8,8,0,5,0,1,4,2,3,3,8,3,6,3,8,1,9,4,8,0,5,3,9,5,1,6,6,2,8,1,6,2,4,4,7,3,0,8,5,1,1,5,1,6,1,8,3,4,7,3,6,8,7,1,7,3,6,3,4,6,6,3,5,7,7,4,3,0,7,7,6,0,9,2,5,5,2,7,7,6};

		// Instanciando os cinco algoritmos de Troca de Pagina:
		ReplacementAlgorithm optimal = new OPTIMAL(argumento_1, referenceString);
		ReplacementAlgorithm fifo    = new FIFO(argumento_1, referenceString);
		ReplacementAlgorithm lru     = new LRU(argumento_1, referenceString);
		ReplacementAlgorithm mfu     = new MFU(argumento_1, referenceString);
		ReplacementAlgorithm lfu     = new LFU(argumento_1, referenceString);

		System.out.println("* String de Referencia:");
		vetorImprimir(referenceString);

		System.out.println("\n* Tamanho do Frame Buffer: "+argumento_1);

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
