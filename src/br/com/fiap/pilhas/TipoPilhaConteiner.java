package br.com.fiap.pilhas;

import br.com.fiap.entidades.Conteiner;

public class TipoPilhaConteiner implements TipoPilhaSequencial<Conteiner> {
	
	private final int N = 4;
	private Conteiner dados[] = new Conteiner[N];
	private int topo;

	@Override
	public void init() {
		topo = 0;		
	}

	@Override
	public boolean isEmpty() {
		return (topo == 0);
	}

	@Override
	public boolean isFull() {
		return (topo == N);
	}

	@Override
	public void push(Conteiner valor) {
		if (!isFull()) {
            dados[topo] = valor;
            topo++;
        } 
			else {
				System.out.println("Stack Overflow: Conteiner ID = " + valor.getId());
			}
	}

	@Override
	public Conteiner pop() {
		topo--;
		return dados[topo];
	}

	@Override
	public Conteiner top() {
		return dados[topo - 1];
	}

	@Override
	public void clear() {
		while (!isEmpty())
			System.out.println("Valor retirado da pilha: " + pop());
	}

	public Conteiner[] getDados() {
		return dados;
	}

	public void setDados(Conteiner[] dados) {
		this.dados = dados;
	}

	public int getTopo() {
		return topo;
	}

	public int getN() {
		return N;
	}

}
