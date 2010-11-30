public class LRU extends ReplacementAlgorithm
{
	private int iteratorFrameBuffer;
	private int tempo;           //Variável para guardar o tempo global.
	private int tempo_acesso[];  //Vetor com os datas de acesso para cada posição do FrameBuffer.

	public LRU(int FrameBufferSize)
	{
		super(FrameBufferSize);
		iteratorFrameBuffer = 0;
		tempo = 1;
	}

	@Override
	public void insert(int pageNumber)
	{	
		// TODO Auto-generated method stub
		
	}
}
