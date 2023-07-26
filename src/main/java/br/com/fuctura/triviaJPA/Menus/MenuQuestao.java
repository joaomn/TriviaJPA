package br.com.fuctura.triviaJPA.Menus;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.triviaJPA.DAOs.JogadorDAO;
import br.com.fuctura.triviaJPA.DAOs.QuestaoDAO;
import br.com.fuctura.triviaJPA.Entitys.Jogador;
import br.com.fuctura.triviaJPA.Entitys.Questao;

public class MenuQuestao {
 Scanner scan = new Scanner(System.in);
	 
	 QuestaoDAO qDAO = new QuestaoDAO();
		Questao q = new Questao();
		
		private int opcao = 100;

public void mainJogador() {
	
	do {
	System.out.println("-------------------------------------");
	System.out.println("                                     ");
	System.out.println("         MENU DE QUESTÃO             ");
	System.out.println("                                     ");
	System.out.println(" 1 - Cadastrar Questão               ");
	System.out.println(" 2 - Listar Questões                 ");
	System.out.println(" 3 - Deletar Questão                 ");
	System.out.println(" 4 - Alterar Questão (pelo ID)       ");
	System.out.println(" 0 - sair do menu                    ");
	System.out.println("                                     ");
	System.out.println("-------------------------------------");
	
	opcao = scan.nextInt();
	scan.nextLine();
	
	switch(opcao) {
	case 1:
		
		 cadastarQuestao();
		break;
		
	case 2:
		
		listarTodos();
		
		break;
		
	case 3:
		
		deletarPorID();
		
		break;
		
	case 4:
		atualizarJogdor();
		break;
		
	case 0:
		
		break;
		
	
		
		default:
			
			System.out.println("Numero errado, escolha novamente");
			
			opcao = scan.nextInt();
			scan.nextLine();
			
			break;
		
		
	}
	}while(opcao != 0);
	
	
	
	
	
	
	
}

public void cadastarQuestao() {
	
	System.out.println("Digite o enunciado da questão");
	String enunciado = scan.nextLine();
	scan.nextLine();
	
	
	System.out.println("Digite o valor da questão");
	int valor = scan.nextInt();
	scan.nextLine();
	
	
	q.setEnunciado(enunciado);
	q.setValor(valor);
	
	
	
	try {
		qDAO.store(q);
		
		
	} catch (Exception e) {
		System.out.println("Não foi possivel cadastrar esta questão");
	}
	
		
	}

public void listarTodos() {
	List<Questao> listaQuestoes =	qDAO.getAll();
	
	for(Questao quest: listaQuestoes) {
		System.out.println("----------------------------\n");
		System.out.println("                              ");
		System.out.println("Enunciado: " + quest.getEnunciado() );
		System.out.println("Valor: " + quest.getValor());
		System.out.println("Codigo da Questão: " + quest.getCodigo());	
		System.out.println("                              ");

	}
}

public void deletarPorID() {
	System.out.println("Digite o id da Questão");
	int idExcluir = scan.nextInt();
	scan.nextLine();
	
	try {
		qDAO.delete(idExcluir);
	} catch (Exception e) {
		System.out.println("exclusao falhou");
	}
}

public void atualizarJogdor() {
	System.out.println("Digite o Id da questão que deseja alterar");
	
	int idAlterar = scan.nextInt();
	scan.nextLine();
	
	System.out.println("Digite o valor a ser alterado (se nao quiser alterar aperte ENTER)");
	
	int valorNovo = scan.nextInt();
	scan.nextLine();
	
	System.out.println("digite o enunciado novo (se nao quiser alterar aperte ENTER)");
	String nomeNovo = scan.nextLine();
	
	
	
	q.setEnunciado(nomeNovo);
	q.setValor(valorNovo);
	
	try {
		qDAO.update(idAlterar, q);
		
		System.out.println("Alterado com sucesso");
	} catch (Exception e) {
		System.out.println("Falou em alterar");
	}
	
}


}
