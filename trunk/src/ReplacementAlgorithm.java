public abstract class ReplacementAlgorithm
{
	protected int pageFaultCount; //Contador de pagefaults.
	protected int pageFrameCount; //Tamanho do FrameBuffer.
	protected int FrameBuffer[];  //Vetor do FrameBuffer.

	// Construtor:
	public ReplacementAlgorithm (int pageFrameCount)
	{
		if (pageFrameCount < 0)
			throw new IllegalArgumentException();
		// Inicializando o contador de pagefaults:
		pageFaultCount = 0;

		// Instanciando vetor do FrameBuffer:
		this.pageFrameCount = pageFrameCount;
		FrameBuffer = new int[pageFrameCount];
		for (int i=0 ; i<pageFrameCount ; i++)
			FrameBuffer[i] = -1; //"-1" significa que a página está vazia.
	}

	public int getPageFaultCount()
	{
		return pageFaultCount;
	}

	public int getPageFrameCount()
	{
		return pageFrameCount;
	}

	public abstract void insert (int pageNumber);
}
