package replacement_algorithms;

public abstract class FU extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;
	protected int contador[];

	public FU(int FrameBufferSize, int referenceString[])
	{
		super(FrameBufferSize, referenceString);
		iteratorFrameBuffer = 0;
		// Inicializando o vetor contador[]:
		contador = new int[this.getPageFrameCount()];
		for (int i=0 ; i<this.getPageFrameCount() ; i++)
			contador[i] = 0;
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
			{
				contador[i]++;
				return;
			}
		}

		// Se chegar aqui, a página não está no Frame Buffer.
		// Checar se ainda existe espaço vazio no Frame Buffer...
		if (iteratorFrameBuffer < this.getPageFrameCount())
		{
			FrameBuffer[iteratorFrameBuffer] = referenceString[pageIndex];
			contador[iteratorFrameBuffer]++;
			iteratorFrameBuffer++;
		}
		else // Se o Frame Buffer estiver cheio...
		{
			// Selecionamos uma posicao do Frame Buffer baseado no seu contador:
			int indice = selecionarContador();
			FrameBuffer[indice] = referenceString[pageIndex];
			contador[indice] = 1;
		}
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
	
	protected abstract int selecionarContador();
}
