package br.henkels.organizaturma;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class OrganizaTurmasTest {

	@Test
	void test01() {
		List<Aluno> alunos = new ArrayList<>();
		List<Sala> salasCafe = new ArrayList<>();
		List<Sala> salasAula = new ArrayList<>();
		List<Escala> escalas = OrganizaTurmas.geraEscalas(alunos, salasAula, salasCafe);
		Assert.assertEquals(0, escalas.size());
	}

	@Test
	void test02() {
		List<Aluno> alunos = new ArrayList<>();
		alunos.add(new Aluno(1, "a1", "s1"));

		List<Sala> salasAula = new ArrayList<>();
		salasAula.add(new Sala(1, "s1", 100));

		List<Sala> salasCafe = new ArrayList<>();
		salasCafe.add(new Sala(1, "c1", 100));

		List<Escala> escalas = OrganizaTurmas.geraEscalas(alunos, salasAula, salasCafe);
		Assert.assertEquals(1, escalas.size());
		Assert.assertEquals("[Escala [codigoAluno=1, salaturno1=1, salacafe=1, salaturno2=1]]", escalas.toString());
	}

}
