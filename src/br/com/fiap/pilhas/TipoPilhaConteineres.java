package br.com.fiap.pilhas;

import br.com.fiap.entidades.Conteiner;

public class TipoPilhaConteineres implements TipoPilhaSequencial<Conteiner> {
	
	private final int N = 4;
	private Conteiner dados[] = new Conteiner[N];
	private int topo = 0;

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
				System.out.println("Stack Overflow: " + valor);
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

}
