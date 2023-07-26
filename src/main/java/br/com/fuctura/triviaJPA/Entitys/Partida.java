package br.com.fuctura.triviaJPA.Entitys;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Partida {
	
	private int pontos;
	

	private List<Questao> questoes;
	
	private Jogador jogador;

}
