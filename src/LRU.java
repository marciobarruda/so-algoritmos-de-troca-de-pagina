public class LRU extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;
	private int tempo;           //Variável para guardar o tempo global.
	private int tempo_acesso[];  //Vetor com a "data" de acesso para cada posição do Frame Buffer.

	public LRU(int FrameBufferSize)
	{
		super(FrameBufferSize);
		iteratorFrameBuffer = 0;
		tempo = 1;
		tempo_acesso = new int[this.getPageFrameCount()];
		for (int i=0 ; i<this.getPageFrameCount() ; i++)
			tempo_acesso[i] = 0;
	}

	private void incrementarTempo(int posicaoFrameBuffer)
	{
		this.tempo++;
		this.tempo_acesso[posicaoFrameBuffer] = tempo;
	}

	@Override
	public void insert(int pageNumber)
	{	
		// Checar se a página está no Frame Buffer:
		for (int i=0 ; i<this.getPageFrameCount() ; i++)
		{
			// Achou uma posição vazia no Frame Buffer.
			if (FrameBuffer[i] == -1)
				break;
			// Se achar a página:
			if (FrameBuffer[i] == pageNumber)
			{
				incrementarTempo(i);
				return;
			}
		}
		// Se chegar aqui, a página não está no Frame Buffer.
		// Se ainda existir espaço vazio no Frame Buffer...
		if (iteratorFrameBuffer < this.getPageFrameCount())
		{
			FrameBuffer[iteratorFrameBuffer] = pageNumber;
			incrementarTempo(iteratorFrameBuffer);
			iteratorFrameBuffer++;
			//Incrementando o contador de pagefaults:
			pageFaultCount++;
		}
		
	}
}
