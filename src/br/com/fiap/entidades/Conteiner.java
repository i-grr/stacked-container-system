package br.com.fiap.entidades;

public class Conteiner {
	
	private int id;
	
	private int contMove;

	public Conteiner() {}
	
	public Conteiner(int id) {
		this.id = id;
		this.contMove = 0;
	}

	public int getId() {
		return id;
	}

	public int getContMove() {
		return contMove;
	}

	public void setContMove(int contMove) {
		this.contMove = contMove;
	}

	@Override
	public String toString() {
		return "Conteiner [contMove = " + contMove + ", idConteiner = " + id + "]";
	}

}
