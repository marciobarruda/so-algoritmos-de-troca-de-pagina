package replacement_algorithms;
public class OPTIMAL extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;
	
	public OPTIMAL(int FrameBufferSize, int referenceString[])
	{
		super(FrameBufferSize, referenceString);
		iteratorFrameBuffer = 0;
	}

	private int selecionarMaiorPosicao(int posicao[])
	{
		// Supomos que o maior contador esta na 1a posicao: 
		int maior = 0;
		for (int i=1 ; i<this.getPageFrameCount() ; i++)
		{
			if (posicao[i] > posicao[maior])
				maior = i;
		}
		return maior;
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

		// Se chegar aqui, a página não está no Frame Buffer.
		// Checar se ainda existe espaço vazio no Frame Buffer...
		if (iteratorFrameBuffer < this.getPageFrameCount())
		{
			FrameBuffer[iteratorFrameBuffer] = referenceString[pageIndex];
			iteratorFrameBuffer++;
		}
		else // Se o Frame Buffer estiver cheio...
		{
			// EXPLICAR PRA QUE SERVE O VETOR "posicao[]"
			int posicao[] = new int[FrameBufferSize];

			// Inicializando o vetor "posicao[]":
			for (int i=0 ; i<this.getPageFrameCount() ; i++)
				posicao[i] = 0;

			for (int i=0 ; i<this.getPageFrameCount() ; i++)
			{
				int j;
				for (j=0 ; j<this.getPageFrameCount() ; j++){}
				{
					if (FrameBuffer[i] == referenceString[j])
					{
						posicao[i] = j;
						break;
					}
				}
			}
			// EXPLICAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			int indice = selecionarMaiorPosicao(posicao);
			FrameBuffer[indice] = referenceString[pageIndex];
		}
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
}
