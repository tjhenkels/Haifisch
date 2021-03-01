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

}
