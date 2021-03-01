package br.henkels.organizaturma;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class OrganizaTurmasTest {

	@Test
	void test01() {
		List<Aluno> alunos = new ArrayList();
		List<Sala> salasCafe = new ArrayList();
		List<Sala> salasAula = new ArrayList();
		List<Escala> escalas = OrganizaTurmas.geraEscalas(alunos, salasAula, salasCafe);
		Assert.assertEquals(0, escalas.size());
	}

}
