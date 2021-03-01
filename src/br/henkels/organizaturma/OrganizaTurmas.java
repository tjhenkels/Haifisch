package br.henkels.organizaturma;

import br.henkels.store.Store;

public class OrganizaTurmas {
	public OrganizaTurmas() {
		super();
		this.store = new Store();
	}

	private final Store store;

	public void saveAluno(String nome, String sobrenome) {
		
		store.saveAluno(nome,sobrenome);
		
	}

	public void saveSalaAula(String nome, int lotacao) {
		store.saveSalaAula(nome,lotacao);
		
	}

	public void saveSalaCafe(String nome, int lotacao) {
		store.saveSalaCafe(nome, lotacao);
		
	}

}
