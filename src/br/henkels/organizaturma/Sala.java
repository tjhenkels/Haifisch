package br.henkels.organizaturma;

public class Sala {
	public Sala(int codigo, String nome, int lotacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.lotacao = lotacao;
	}

	public final int codigo;
	public final String nome;
	public final int lotacao;

}
