package br.com.fiap;

import java.util.Scanner;

import br.com.fiap.processamento.Processamento;

public class App {

	public static void main(String[] args) {
				
		Scanner input = new Scanner(System.in);
		Processamento processamento = new Processamento();
		int opcao;
				
		// Iniciando o processamento
		processamento.inicia();
		
		do {
			
			processamento.gerarMenu();
			System.out.print("\tOpção: ");
			opcao = input.nextInt();
			
			switch (opcao) {
			case 0:
				processamento.encerrarPrograma();
				break;
			
			case 1:
				System.out.print("\nInforme o código de identificação do conteiner: ");
				processamento.idConteiner = input.nextInt();
				processamento.insereConteiner(processamento.idConteiner);
				break;
			
			case 2:
				System.out.print("\nInforme o código de identificação do conteiner: ");
				processamento.idConteiner = input.nextInt();
				processamento.retirarConteiner(processamento.idConteiner);
				break;
				
			case 3:
				processamento.exibirMovimentacoes();
				break;
				
			case 4:
				processamento.apresentarPilhasConteineres();
				break;
				
			case 5:
				processamento.apresentarPlanilhasConteineres();
				break;

			default:
				processamento.opcaoInvalidaMenu();
				break;
			}
			
			System.out.println();
			
			
		} while (opcao != 0);
		
		input.close();
	}
	
}
