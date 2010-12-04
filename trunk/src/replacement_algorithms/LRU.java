package replacement_algorithms;
public class LRU extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;
	private int tempo;           //Variável para guardar o tempo global.
	private int tempoDeUso[];  //Vetor com a "data" de acesso para cada posição do Frame Buffer.

	public LRU(int FrameBufferSize)
	{
		super(FrameBufferSize);
		iteratorFrameBuffer = 0;
		tempo = 1;
		tempoDeUso = new int[this.getPageFrameCount()];
		for (int i=0 ; i<this.getPageFrameCount() ; i++)
			tempoDeUso[i] = 0;
	}

	private void incrementarTempoDeUso(int posicaoFrameBuffer)
	{
		this.tempo++;
		this.tempoDeUso[posicaoFrameBuffer] = tempo;
	}

	// Retorna o indice do menor tempo de uso (mais antigo) no vetor tempoDeUso[]:
	private int menorTempo()
	{
		int indice_menor = 0;
		for (int i=1 ; i<this.getPageFrameCount() ; i++)
		{
			if (this.tempoDeUso[i] < this.tempoDeUso[indice_menor])
				indice_menor = i;
		}
		return indice_menor;
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
				incrementarTempoDeUso(i);
				return;
			}
		}
		// Se chegar aqui, a p�gina n�o est� no Frame Buffer.
		// Checar se ainda existe espa�o vazio no Frame Buffer...
		if (iteratorFrameBuffer < this.getPageFrameCount())
		{
			FrameBuffer[iteratorFrameBuffer] = pageNumber;
			incrementarTempoDeUso(iteratorFrameBuffer);
			iteratorFrameBuffer++;
		}
		else // Se o Frame Buffer estiver cheio...
		{
			// Seleciona a posi��o do Frame Buffer cuja a p�gina � a mais antiga:
			int indice = this.menorTempo();
			FrameBuffer[indice] = pageNumber;
			this.incrementarTempoDeUso(indice);
		}
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
}
