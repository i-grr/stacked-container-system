package br.com.fiap.processamento.util;

public class Util {
	
	public static boolean verificarVetorPossuiItem(int[] vetor, int valor) {
		for (int i : vetor) {
			if (i == valor)
				return true;
		}
		return false;
	}

}
