package br.com.fuctura.triviaJPA.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.fuctura.triviaJPA.Entitys.Jogador;

public class JogadorDAO {
	
	EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("TRIVIA");
	EntityManager entityManager = entityFactory.createEntityManager();
	
	
	public void store(Jogador jogador) {
		
		try {
			
			entityManager.getTransaction().begin();
		
		entityManager.persist(jogador);
		
		entityManager.getTransaction().commit();
		
		System.out.println("Salvo com Sucesso!");
			
		} catch (Exception e) {
			
			System.out.println("Não foi possivel salvar este jogador");
			
		}
		
		
		
	}
	
	
	public Jogador getByID(int jogador) {
		try {
			Jogador j = entityManager.find(Jogador.class, jogador);
			
		
		
		
		return j;
		} catch (Exception e) {
		
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Jogador> getAll(){
		
		Query getAll = entityManager.createQuery("SELECT a from Jogador a");
		
		List<Jogador> resultJogadores = getAll.getResultList();
		
		
		return resultJogadores;
	}
	
	public void delete(int id) {
		
		
	
}

}







