package br.com.fuctura.triviaJPA.Entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = true)
	private int idade;

	private String nome;
	
	@Column(nullable = true)
	private int score;

}
