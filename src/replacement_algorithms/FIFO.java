/*** FIFO - First In, First Out ***/
package replacement_algorithms;
public class FIFO extends ReplacementAlgorithm
{
	public FIFO(int FrameBufferSize, int referenceString[])
	{
		super(FrameBufferSize, referenceString);
		iteratorFrameBuffer = 0;
	}

	private void iterator_proximo()
	{
		//Se iterator estiver na ultima posicao...
		if (iteratorFrameBuffer == (FrameBufferSize-1))
			iteratorFrameBuffer = 0; //...ele volta para a 1a posicao.
		else
			iteratorFrameBuffer++; //Incrementa normalmente.
	}

	@Override
	public void insert(int pageIndex)
	{
		// Checando se "pageIndex" esta dentro dos limites do vetor "referenceString":
		if ((pageIndex < 0) || (pageIndex >= referenceStringSize))
			throw new IllegalArgumentException();

		// Checar se a pagina esta no Frame Buffer:
		for (int i=0 ; i<this.getPageFrameCount() ; i++)
		{
			// Achou uma posicao vazia no Frame Buffer.
			if (FrameBuffer[i] == -1)
				break;
			// Se achar a pagina:
			if (FrameBuffer[i] == referenceString[pageIndex])
				return;
		}

		// Se chegar aqui, a pagina nao esta no Frame Buffer.
		// Carrega-la e contar um pagefault.
		FrameBuffer[iteratorFrameBuffer] = referenceString[pageIndex];
		iterator_proximo();
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
}
