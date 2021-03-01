package br.henkels.organizaturma;

public class Aluno {
	public Aluno(int codigo, String nome, String sobreNome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sobreNome = sobreNome;
	}

	public final int codigo;
	public final String nome;
	public final String sobreNome;
}
