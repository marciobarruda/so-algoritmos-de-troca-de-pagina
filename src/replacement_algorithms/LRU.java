/*** LRU - Least Recently Used ***/
package replacement_algorithms;
public class LRU extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;
	private int tempo;          //Variavel para guardar o tempo global.
	private int tempoDeUso[];   //Vetor com a "data" de acesso para cada posicao do Frame Buffer.

	public LRU(int FrameBufferSize, int referenceString[])
	{
		super(FrameBufferSize, referenceString);
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
				incrementarTempoDeUso(i);
				return;
			}
		}

		// Se chegar aqui, a página não está no Frame Buffer.
		// Checar se ainda existe espaço vazio no Frame Buffer...
		if (iteratorFrameBuffer < this.getPageFrameCount())
		{
			FrameBuffer[iteratorFrameBuffer] = referenceString[pageIndex];
			incrementarTempoDeUso(iteratorFrameBuffer);
			iteratorFrameBuffer++;
		}
		else // Se o Frame Buffer estiver cheio...
		{
			// Seleciona a posição do Frame Buffer cuja a página é a mais antiga:
			int indice = this.menorTempo();
			FrameBuffer[indice] = referenceString[pageIndex];
			this.incrementarTempoDeUso(indice);
		}
		//Incrementando o contador de pagefaults:
		pageFaultCount++;
		imprimirFrameBuffer();
	}
}
