package br.com.fuctura.triviaJPA;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.triviaJPA.DAOs.JogadorDAO;
import br.com.fuctura.triviaJPA.Entitys.Jogador;

public class Aplicacao {

	public static void main(String[] args) {
		
		//EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("TRIVIA");
		
		Scanner scan = new Scanner(System.in);
		
		JogadorDAO jDAO = new JogadorDAO();
//		Jogador j = new Jogador();
//		
//		System.out.println("Dgite o nome do jogador");
//		String nome = scan.nextLine();
//		
//		j.setNome(nome);
//		try {
//			jDAO.store(j);
//			
//			
//		} catch (Exception e) {
//			System.out.println("deu ruim");
//		}
//		
//		
//
//		Jogador j2 = new Jogador();
//		System.out.println("Dgite o nome do jogador");
//		int nome2 = scan.nextInt();
//		
//	
//		
//		j2 =   jDAO.getByID(nome2);
//		
//		
//		
//		System.out.println(j2.getNome());
		
		
	List<Jogador> listaJogadores =	jDAO.getAll();
		
		for(Jogador jog: listaJogadores) {
			System.out.println("----------------------------\n");
			System.out.println("                              ");
			System.out.println("Nome do Jogador: " + jog.getNome());
			System.out.println("Idade do Jogador: " + jog.getIdade());
			System.out.println("Codigo do Jogador: " + jog.getId());
			System.out.println("                              ");
			System.out.println("----------------------------\n");
		}
		
		
		
		
		
		
		

	}

}
