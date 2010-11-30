public class FIFO extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;

	public FIFO(int FrameBufferSize)
	{
		super(FrameBufferSize);
		iteratorFrameBuffer = 0;
	}

	private void iterator_proximo()
	{
		//Se iterator estiver na �ltima posi��o...
		if (iteratorFrameBuffer == (FrameBufferSize-1))
			iteratorFrameBuffer = 0; //...ele volta para a 1� posi��o.
		else
			iteratorFrameBuffer++; //Incrementa normalmente.
	}

	@Override
	public void insert(int pageNumber)
	{
		// Checar se a p�gina esta no Frame Buffer:
		for (int i=0 ; i<FrameBufferSize ; i++)
		{
			// Achou uma posi��o vazia no Frame Buffer.
			if (FrameBuffer[i] == -1)
				break;
			// Se achar a p�gina:
			if (FrameBuffer[i] == pageNumber)
				return;
		}
		// Se chegar aqui, a p�gina n�o est� no Frame Buffer.
		// Carreg�-la e contar um pagefault.
		FrameBuffer[iteratorFrameBuffer] = pageNumber;
		iterator_proximo();
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
}
