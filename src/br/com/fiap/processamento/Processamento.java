package br.com.fiap.processamento;

import br.com.fiap.pilhas.TipoPilhaConteiner;

public class Processamento {
	
	public TipoPilhaConteiner pilhaConteiner1 = new TipoPilhaConteiner();
	public int planilhaPilha1[] = new int[pilhaConteiner1.getN()];
	
	public TipoPilhaConteiner pilhaConteiner2 = new TipoPilhaConteiner();
	public int planilhaPilha2[] = new int[pilhaConteiner2.getN()];

	public void inicia() {
		pilhaConteiner1.init();
		pilhaConteiner2.init();
	}
	
}
