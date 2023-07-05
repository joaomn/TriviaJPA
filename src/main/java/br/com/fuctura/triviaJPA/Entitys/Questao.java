package br.com.fuctura.triviaJPA.Entitys;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String enunciado;
	private double valor;
	
	
	@OneToMany
	private List<Alternativa> alternativas;

}
