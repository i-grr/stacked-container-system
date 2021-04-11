package br.com.fiap.processamento;

import br.com.fiap.entidades.Conteiner;
import br.com.fiap.pilhas.TipoPilhaConteiner;
import br.com.fiap.processamento.util.Util;

public class Processamento {
	
	public int movimentacoesConteineres = 0;
	public int idConteiner;
	public final int numPilhas = 2;
	
	public TipoPilhaConteiner pilhaConteiner1 = new TipoPilhaConteiner();
	public int planilhaConteiner1[] = new int[pilhaConteiner1.getN()];
	
	public TipoPilhaConteiner pilhaConteiner2 = new TipoPilhaConteiner();
	public int planilhaConteiner2[] = new int[pilhaConteiner2.getN()];
	
	public TipoPilhaConteiner pilhaAuxiliar = new TipoPilhaConteiner();

	public void inicia() {
		pilhaConteiner1.init();
		pilhaConteiner2.init();
		System.out.println("O número de pilhas de conteineres existentes no pátio é " + numPilhas + "\n");
	}
	
	public void gerarMenu() {
		System.out.println("0 - Encerrar o programa\n"
			 + "1 - Insere o conteiner\n"
			 + "2 - Retira o conteiner do pátio\n"
			 + "3 - Cálculo do custo da movimentação dos conteineres\n"
			 + "4 - Apresenta os conteineres em cada pilha do pátio\n"
			 + "5 - Apresenta planilhas de conteineres de cada pilha do pátio\n");
	}
	
	public void encerrarPrograma() {
		System.out.println("\nPrograma encerrado.");
	}
	
	public void opcaoInvalidaMenu() {
		System.out.println("\nOpção inválida. Insira uma opção válida para continuar!");
	}
	
	public void insereConteiner(int idConteiner) {
		if (idConteiner == 0)
			System.out.println("Não é possível adicionar um conteiner com o ID 0.");
		else
			if (verificarConteinerPorId(idConteiner))
				System.out.println("Não foi possível adicionar o conteiner com o ID inserido. "
						+ "O ID " + idConteiner + " já está sendo utilizado por outro conteiner!");
			else
				inserirConteiner(idConteiner);			
	}
	
	public boolean verificarConteinerPorId(int idConteiner) {
		atualizarPlanilhas();
		return (Util.verificarVetorPossuiItem(planilhaConteiner1, idConteiner) || 
				Util.verificarVetorPossuiItem(planilhaConteiner2, idConteiner));
	}
	
	public void atualizarPlanilhas() {
		
		for (int i = 0; i < pilhaConteiner1.getN(); i++)
			planilhaConteiner1[i] = 0;
		
		for (int i = 0; i < pilhaConteiner2.getN(); i++)
			planilhaConteiner2[i] = 0;
		
		for (int i = 0; i < pilhaConteiner1.getTopo(); i++)
			if (i != pilhaConteiner1.getTopo())
				planilhaConteiner1[i] = pilhaConteiner1.getDados()[i].getId();		
			else
				planilhaConteiner1[i] = 0;

		for (int i = 0; i < pilhaConteiner2.getTopo(); i++)
			planilhaConteiner2[i] = pilhaConteiner2.getDados()[i].getId();
	}
	
	public void inserirConteiner(int idConteiner) {
		Conteiner conteiner = new Conteiner(idConteiner);
		
		if (pilhaConteiner1.getTopo() <= pilhaConteiner2.getTopo())
			pilhaConteiner1.push(conteiner);
		else
			pilhaConteiner2.push(conteiner);	
		
		atualizarPlanilhas();
	}
	
	public void apresentarPilhasConteineres() {
		System.out.print("\n************* Ocupação das pilhas de conteineres ******************\n");
		exibirPilha("PILHA 1", pilhaConteiner1);
		exibirPilha("PILHA 2", pilhaConteiner2);
	}
	
	public void exibirPilha(String nomePilha, TipoPilhaConteiner pilha) {
		System.out.println("\n\t" + nomePilha);
		for (int i = pilha.getTopo(); i >= 0; i--) {
			if (i == pilha.getTopo())
				System.out.println("topo -> " + i + "]:");
			else
				System.out.println("\t" + i + "]: " + pilha.getDados()[i]);
		}
	}
	
	public void apresentarPlanilhasConteineres() {
		exibirPlanilha("planilha 1", planilhaConteiner1);
		exibirPlanilha("planilha 2", planilhaConteiner2);
	}
	
	public void exibirPlanilha(String nomePlanilha, int[] planilhaConteiner) {
		System.out.println("\n********** Planilha de conteiners (" + nomePlanilha + ") **************\n");
		for (int i : planilhaConteiner) {
			if (i != 0)
				System.out.println(i);
		}
	}
	
	public TipoPilhaConteiner selecionaPilhaRetirada(int idConteiner) {
		if (Util.verificarVetorPossuiItem(planilhaConteiner1, idConteiner))
			return pilhaConteiner1;
		if (Util.verificarVetorPossuiItem(planilhaConteiner2, idConteiner))
			return pilhaConteiner2;
		return null;
	}
	
	public void retirarConteiner(int idConteiner) {
		if (verificarConteinerPorId(idConteiner)) {
			
			boolean achou = false;
			
			TipoPilhaConteiner pilhaSelecionada = selecionaPilhaRetirada(idConteiner);
			
			while (!achou) {
				Conteiner conteiner = pilhaSelecionada.pop();
				conteiner.setContMove(conteiner.getContMove() + 1);
				movimentacoesConteineres++;
				if (conteiner.getId() != idConteiner) {
					pilhaAuxiliar.push(conteiner);
					System.out.println("Movimentado o contêiner " + conteiner.getId());
				}
					else {
						System.out.println("Movimentado o contêiner " + conteiner.getId());
						System.out.println("\tConteiner " + conteiner.getId() + " saindo para seu destino final.");
						achou = true;
					}	
			}
			
			if (!pilhaAuxiliar.isEmpty()) {
				while (!pilhaAuxiliar.isEmpty()) {
					Conteiner conteiner = pilhaAuxiliar.pop();
					conteiner.setContMove(conteiner.getContMove() + 1);
					movimentacoesConteineres++;
					pilhaSelecionada.push(conteiner);
				}
			}
			
			atualizarPlanilhas();
			
		}
			else {
				System.out.println("Não foi encontrado nenhum contêiner com o ID = " + idConteiner + " no pátio.");
			}
	}
	
	public void exibirMovimentacoes() {
		System.out.println("\nNúmero de movimentações: " + movimentacoesConteineres);
	}
	
}
