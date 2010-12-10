package replacement_algorithms;
public abstract class ReplacementAlgorithm
{
	protected int pageFaultCount;      //Contador de pagefaults.
	protected int iteratorFrameBuffer; //Iterator usado para colocar p�ginas no Frame Buffer quando este ainda nao esta cheio ainda.
	protected int FrameBufferSize;     //Tamanho do Frame Buffer.
	protected int FrameBuffer[];       //Vetor do Frame Buffer.
	protected int referenceString[];   //Vetor para a String de Referencia.
	protected int referenceStringSize; //Tamanho da String de Referencia.

	// Construtor:
	public ReplacementAlgorithm(int FrameBufferSize, int referenceString[])
	{
		if (FrameBufferSize < 0)
			throw new IllegalArgumentException();
		// Inicializando o contador de pagefaults:
		this.pageFaultCount = 0;

		// Vetor para a String de Referencia:
		this.referenceStringSize = referenceString.length;
		this.referenceString = referenceString;

		// Instanciando o vetor do FrameBuffer:
		this.FrameBufferSize = FrameBufferSize;
		this.FrameBuffer = new int[FrameBufferSize];
		for (int i=0 ; i<FrameBufferSize ; i++)
			this.FrameBuffer[i] = -1; //"-1" significa que a pagina est� vazia.
	}

	protected void imprimirFrameBuffer()
	{}/*
		System.out.print("[");		
		for (int i=0 ; i<this.FrameBufferSize ; i++)
		{
			if (this.FrameBuffer[i] == -1)
				System.out.print("_");
			else
				System.out.print(this.FrameBuffer[i]);
			//Nao exibir a virgula depois do ultimo numero:
			if (i != (this.FrameBufferSize-1))
				System.out.print(",");
		}
		System.out.print("]\n");
	}*/

	public int getPageFaultCount()
	{
		return this.pageFaultCount;
	}

	public int getPageFrameCount()
	{
		return this.FrameBufferSize;
	}

	public void executar()
	{
		for (int i = 0; i < referenceStringSize; i++)
		{
			//System.out.println("> Inserindo pagina: " + referenceString[i]);
			this.insert(i);
		}
	}

	public abstract void insert(int pageIndex);
}
