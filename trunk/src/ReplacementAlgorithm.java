public abstract class ReplacementAlgorithm
{
	protected int pageFaultCount; //Contador de pagefaults.
	protected int FrameBufferSize; //Tamanho do FrameBuffer.
	protected int FrameBuffer[];  //Vetor do FrameBuffer.

	// Construtor:
	public ReplacementAlgorithm(int FrameBufferSize)
	{
		if (FrameBufferSize < 0)
			throw new IllegalArgumentException();
		// Inicializando o contador de pagefaults:
		pageFaultCount = 0;

		// Instanciando vetor do FrameBuffer:
		this.FrameBufferSize = FrameBufferSize;
		FrameBuffer = new int[FrameBufferSize];
		for (int i=0 ; i<FrameBufferSize ; i++)
			FrameBuffer[i] = -1; //"-1" significa que a página está vazia.
	}

	protected void imprimirFrameBuffer()
	{
		for (int i=0 ; i<FrameBufferSize ; i++)
		return pageFaultCount;
	}

	public int getPageFaultCount()
	{
		return pageFaultCount;
	}

	public int getPageFrameCount()
	{
		return FrameBufferSize;
	}

	public abstract void insert (int pageNumber);
}
