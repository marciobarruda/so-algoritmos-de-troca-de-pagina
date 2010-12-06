package replacement_algorithms;

public class MFU extends FU
{
	public MFU(int FrameBufferSize, int referenceString[])
	{
		super(FrameBufferSize, referenceString);
	}

	@Override
	protected int selecionarContador()
	{
		// Supomos que o maior contador esta na 1a posicao: 
		int maior = 0;
		for (int i=1 ; i<this.getPageFrameCount() ; i++)
		{
			if (this.contador[i] > this.contador[maior])
				maior = i;
		}
		return maior;
	}
}
