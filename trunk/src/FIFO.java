public class FIFO extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;

	public FIFO(int pageFrameCount)
	{
		super(pageFrameCount);
		iteratorFrameBuffer = 0;

	}

	private void iterator_proximo()
	{
		//Se iterator estiver na última posição...
		if (iteratorFrameBuffer == (FrameBufferSize-1))
			iteratorFrameBuffer = 0; //...ele volta para a 1ª posição.
		else
			iteratorFrameBuffer++; //Incrementa normalmente.
	}

	@Override
	public void insert(int pageNumber)
	{
		// Checar se a página esta no Frame Buffer:
		for (int i=0 ; i<FrameBufferSize ; i++)
		{
			// Achou uma posição vazia no Frame Buffer.
			if (FrameBuffer[i] == -1)
				break;
			// Se achar a página:
			if (FrameBuffer[i] == pageNumber)
				return;
		}
		// Se chegar aqui, a página não está no Frame Buffer.
		// Carregá-la e contar um pagefault.
		FrameBuffer[iteratorFrameBuffer] = pageNumber;
		iterator_proximo();
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
}
