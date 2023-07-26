package br.com.fuctura.triviaJPA.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fuctura.triviaJPA.Entitys.Jogador;
import br.com.fuctura.triviaJPA.Entitys.Questao;

public class QuestaoDAO {
	
	EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("TRIVIA");
	EntityManager entityManager = entityFactory.createEntityManager();
	
	
	
	public void store(Questao questao) {
		
try {
			
			entityManager.getTransaction().begin();
		
		entityManager.persist(questao);
		
		entityManager.getTransaction().commit();
		
		System.out.println("Salvo com Sucesso!");
			
		} catch (Exception e) {
			
			System.out.println("Não foi possivel salvar este jogador");
			
		}
		
	}
	
	
	public Questao getByID(int questao) {
		try {
			Questao  q = entityManager.find(Questao.class, questao);
			
		
		
		
		return q;
		} catch (Exception e) {
			
			System.out.println("nao foi possivel achar esta questao");
		
			return null;
		}
		
	}
	
	
	public List<Questao> getAll(){
		
		TypedQuery<Questao> listQuestao = entityManager.createQuery("Selec a from Questao a", Questao.class);
		
		List<Questao> listaQuestoes = listQuestao.getResultList();
		
		return listaQuestoes;
	}




public void delete(int id) {
	
	Questao questao =	entityManager.find(Questao.class, id);
			
	if(questao != null)		{
		
		entityManager.getTransaction().begin();
	entityManager.remove(questao);
	entityManager.getTransaction().commit();
	
	System.out.println("Excluido com sucesso!");

		
	}else {
		System.out.println("Esta questao não existe no banco de dados");
	}
			
	
	
	

}


public void update(int id, Questao questaoNovo) {
	
	Questao questao = entityManager.find(Questao.class, id);
	
	if(questaoNovo.getValor() != 0) {
		
		questao.setValor(questaoNovo.getValor());;
	}
	
	if(questaoNovo.getEnunciado() != null || questaoNovo.getEnunciado() == "") {
		
		questao.setEnunciado(questaoNovo.getEnunciado());;
	}
	
	
	entityManager.getTransaction().begin();
	
	entityManager.persist(questao);
	
	
	entityManager.getTransaction().commit();
	
}
	
}

