package br.com.fiap.pilhas;

public interface TipoPilhaSequencial<T> {
	
	void init();
	
	boolean isEmpty();
	
	boolean isFull();
	
	void push(T valor);
	
	T pop();
	
	T top();
	
	void clear();
	
}
