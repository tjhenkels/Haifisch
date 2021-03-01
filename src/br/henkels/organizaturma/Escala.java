package br.henkels.organizaturma;

public class Escala {

	public Escala(int codigoAluno, int salaturno1, int salacafe, int salaturno2) {
		super();
		this.codigoAluno = codigoAluno;
		this.salaturno1 = salaturno1;
		this.salacafe = salacafe;
		this.salaturno2 = salaturno2;
	}

	public final int codigoAluno;
	public final int salaturno1;
	public final int salacafe;
	public final int salaturno2;

	@Override
	public String toString() {
		return "Escala [codigoAluno=" + codigoAluno + ", salaturno1=" + salaturno1 + ", salacafe=" + salacafe
				+ ", salaturno2=" + salaturno2 + "]";
	}
}
