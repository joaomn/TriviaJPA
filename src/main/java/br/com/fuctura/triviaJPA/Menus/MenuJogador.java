package br.com.fuctura.triviaJPA.Menus;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.triviaJPA.DAOs.JogadorDAO;
import br.com.fuctura.triviaJPA.Entitys.Jogador;

public class MenuJogador {
	 Scanner scan = new Scanner(System.in);
	 
	 JogadorDAO jDAO = new JogadorDAO();
		Jogador j = new Jogador();
		Jogador j2 = new Jogador();
		Jogador j3 = new Jogador();
		private int opcao = 100;

public void mainJogador() {
	
	do {
	System.out.println("-------------------------------------");
	System.out.println("                                     ");
	System.out.println("         MENU DE JOGADOR             ");
	System.out.println("                                     ");
	System.out.println(" 1 - Cadastrar Jogado                ");
	System.out.println(" 2 - Listar Jogadores                ");
	System.out.println(" 3 - Deletar Jogador                 ");
	System.out.println(" 4 - Alterar Jogador (pelo ID)       ");
	System.out.println(" 0 - sair do menu                    ");
	System.out.println("                                     ");
	System.out.println("-------------------------------------");
	
	opcao = scan.nextInt();
	scan.nextLine();
	
	switch(opcao) {
	case 1:
		
		 cadastarJogador();
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

public void cadastarJogador() {
	
	System.out.println("Dgite o nome do jogador");
	String nome = scan.nextLine();
	scan.nextLine();
	
	
	System.out.println("Dgite a Idade do jogador");
	int idade = scan.nextInt();
	scan.nextLine();
	
	
	j.setNome(nome);
	j.setIdade(idade);
	
	
	try {
		jDAO.store(j);
		
		
	} catch (Exception e) {
		System.out.println("Não foi possivel cadastrar este jogador");
	}
	
		
	}

public void listarTodos() {
	List<Jogador> listaJogadores =	jDAO.getAll();
	
	for(Jogador jog: listaJogadores) {
		System.out.println("----------------------------\n");
		System.out.println("                              ");
		System.out.println("Nome do Jogador: " + jog.getNome());
		System.out.println("Idade do Jogador: " + jog.getIdade());
		System.out.println("Codigo do Jogador: " + jog.getId());
		System.out.println("Score do Jogador: " + jog.getScore());
		System.out.println("                              ");

	}
}

public void deletarPorID() {
	System.out.println("Digite o id do  jogador");
	int idExcluir = scan.nextInt();
	scan.nextLine();
	
	try {
		jDAO.delete(idExcluir);
	} catch (Exception e) {
		System.out.println("exclusao falhou");
	}
}

public void atualizarJogdor() {
	System.out.println("Digite o Id do jogador que deseja alterar");
	
	int idAlterar = scan.nextInt();
	scan.nextLine();
	
	System.out.println("Digite a  idade a ser alterada (se nao quiser alterar aperte ENTER)");
	
	int idadeNova = scan.nextInt();
	scan.nextLine();
	
	System.out.println("digite o nome novo (se nao quiser alterar aperte ENTER)");
	String nomeNovo = scan.nextLine();
	
	Jogador j3 = new Jogador();
	
	j3.setIdade(idadeNova);
	j3.setNome(nomeNovo);
	
	try {
		jDAO.update(idAlterar, j3);
		
		System.out.println("Alterado com sucesso");
	} catch (Exception e) {
		System.out.println("Falou em alterar");
	}
	
}

}
