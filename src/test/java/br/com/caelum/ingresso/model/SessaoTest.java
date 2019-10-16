package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPRecoDaSalaMaisOPrecoDoFilme() {

		Sala sala = new Sala("Eldorado - Imax", new BigDecimal("22."));
		Filme filme = new Filme("Joker", Duration.ofMinutes(90), "Comédia", new BigDecimal("12"));

		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());

		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);

		Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
	}
}
