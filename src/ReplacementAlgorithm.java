public abstract class ReplacementAlgorithm
{
	protected int pageFaultCount;  //Contador de pagefaults.
	protected int FrameBufferSize; //Tamanho do Frame Buffer.
	protected int FrameBuffer[];   //Vetor do Frame Buffer.

	// Construtor:
	public ReplacementAlgorithm(int FrameBufferSize)
	{
		if (FrameBufferSize < 0)
			throw new IllegalArgumentException();
		// Inicializando o contador de pagefaults:
		this.pageFaultCount = 0;

		// Instanciando vetor do FrameBuffer:
		this.FrameBufferSize = FrameBufferSize;
		this.FrameBuffer = new int[FrameBufferSize];
		for (int i=0 ; i<FrameBufferSize ; i++)
			this.FrameBuffer[i] = -1; //"-1" significa que a p�gina est� vazia.
	}

	protected void imprimirFrameBuffer()
	{
		System.out.print("[");		
		for (int i=0 ; i<this.FrameBufferSize ; i++)
		{
			if (this.FrameBuffer[i] == -1)
				System.out.print("_");
			else
				System.out.print(this.FrameBuffer[i]);
			//N�o exibir a virgula depois do �ltimo n�mero:
			if (i != (this.FrameBufferSize-1))
				System.out.print(",");
		}
		System.out.print("]\n");
	}

	public int getPageFaultCount()
	{
		return this.pageFaultCount;
	}

	public int getPageFrameCount()
	{
		return this.FrameBufferSize;
	}

	public abstract void insert (int pageNumber);
}
