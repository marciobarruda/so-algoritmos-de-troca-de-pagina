package replacement_algorithms;

public class LFU extends FU
{
	public LFU(int FrameBufferSize, int referenceString[])
	{
		super(FrameBufferSize, referenceString);
	}

	@Override
	protected int selecionarContador()
	{
		// Supomos que o menor contador esta na 1a posicao: 
		int menor = 0;
		for (int i=1 ; i<this.getPageFrameCount() ; i++)
		{
			if (this.contador[i] < this.contador[menor])
				menor = i;
		}
		return menor;
	}
}
