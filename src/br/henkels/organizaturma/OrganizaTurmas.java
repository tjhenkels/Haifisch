package br.henkels.organizaturma;

import java.util.ArrayList;
import java.util.List;

import br.henkels.store.Store;

public class OrganizaTurmas {

	public OrganizaTurmas() {
		super();
		this.store = new Store();
	}

	private final Store store;

	public void saveAluno(String nome, String sobrenome) {
		store.saveAluno(nome, sobrenome);
		updateEscala();
	}

	public void saveSalaAula(String nome, int lotacao) {
		store.saveSalaAula(nome, lotacao);
		updateEscala();
	}

	public void saveSalaCafe(String nome, int lotacao) {
		store.saveSalaCafe(nome, lotacao);
		updateEscala();
	}

	private void updateEscala() {
		List<Aluno> alunos = store.lerAlunos();
		List<Sala> salasAula = store.lerSalaAula();
		List<Sala> salasCafe = store.LerSalaCafe();
		List<Escala> escalas = geraEscalas(alunos, salasAula, salasCafe);
		store.gravarEscalas(escalas);

	}

	public static List<Escala> geraEscalas(List<Aluno> alunos, List<Sala> salasAula, List<Sala> salasCafe) {
		List<Escala> ret = new ArrayList<>();
		if (salasAula.size() > 0 || salasCafe.size() > 0) {

			int metadeAlunos = alunos.size() / 2;
			for (int i = 0; i < alunos.size(); i++) {
				Aluno aluno = alunos.get(i);
				int codigoAluno = aluno.codigo;
				Sala sala = salasAula.get(i % salasAula.size());
				int salaturno1 = sala.codigo;

				sala = salasCafe.get(i % salasCafe.size());
				int salacafe = sala.codigo;

				int ii = i;
				if (ii > metadeAlunos) {
					ii++;
				}
				sala = salasAula.get(ii % salasAula.size());
				int salaturno2 = sala.codigo;

				Escala escala = new Escala(codigoAluno, salaturno1, salacafe, salaturno2);
				ret.add(escala);
			}

		}
		return ret;

	}

}
