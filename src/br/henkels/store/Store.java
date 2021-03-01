package br.henkels.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.henkels.organizaturma.Aluno;
import br.henkels.organizaturma.Escala;
import br.henkels.organizaturma.Sala;

public class Store {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=master;user=godev;password=godev";
	private final Connection conn;

	public Store() {
		try {
			conn = DriverManager.getConnection(URL);
			checkTables();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void checkTables() {
		if (!existetabelas()) {
			criaTabelas();
		}

	}

	private static final String[] COMANDOS = new String[] { //
			"create table alunos (id_aluno int identity(1,1) primary key,nome varchar(25), sobrenome varchar(25))  ", //
			"create table salaaula (id_sala int identity(1,1) primary key,nome varchar(25), lotacao int)  ", //
			"create table salacafe (id_sala int identity(1,1) primary key,nome varchar(25), lotacao int)  ", //
			"create table escala (id_aluno int, id_salaaulaturno1 int, id_salacafe int, id_salaaulaturno2 int, constraint pk_escala primary key(id_aluno, id_salaaulaturno1, id_salacafe, id_salaaulaturno2))  ", //

	};

	private void criaTabelas() {
		for (String comando : COMANDOS) {
			criaTabela(comando);
		}

	}

	private void criaTabela(String comando) {
		try (Statement stmt = conn.createStatement()) {
			stmt.execute(comando);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private boolean existetabelas() {
		try (Statement stmt = conn.createStatement()) {
			stmt.executeQuery("select 1 from Alunos where 1=0");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public void saveAluno(String nome, String sobrenome) {

		try (PreparedStatement stmt = conn.prepareStatement("insert into alunos(nome, sobrenome) values (?, ?)");) {
			stmt.setString(1, nome);
			stmt.setString(2, sobrenome);
			stmt.execute();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	public void saveSalaAula(String nome, int lotacao) {
		try (PreparedStatement stmt = conn.prepareStatement("insert into salaAula(nome, lotacao) values (?, ?)");) {
			stmt.setString(1, nome);
			stmt.setInt(2, lotacao);
			stmt.execute();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void saveSalaCafe(String nome, int lotacao) {
		try (PreparedStatement stmt = conn.prepareStatement("insert into salaCafe(nome, lotacao) values (?, ?)");) {
			stmt.setString(1, nome);
			stmt.setInt(2, lotacao);
			stmt.execute();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Aluno> lerAlunos() {
		List<Aluno> ret = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement("select id_aluno, nome, sobrenome from alunos");) {

			for (ResultSet rs = stmt.executeQuery(); rs.next();) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String sobreNome = rs.getString(3);
				Aluno aluno = new Aluno(codigo, nome, sobreNome);
				ret.add(aluno);
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;

	}

	private List<Sala> lerSala(String tableName) {
		List<Sala> ret = new ArrayList<>();
		try (PreparedStatement stmt = conn
				.prepareStatement(String.format("select id_sala, nome, lotacao from %s", tableName))) {

			for (ResultSet rs = stmt.executeQuery(); rs.next();) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				int lotacao = rs.getInt(3);
				Sala sala = new Sala(codigo, nome, lotacao);
				ret.add(sala);
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;
	}

	public List<Sala> lerSalaAula() {
		return lerSala("salaaula");
	}

	public List<Sala> LerSalaCafe() {
		return lerSala("salacafe");
	}

	public void gravarEscalas(List<Escala> escalas) {
		try (PreparedStatement stmt = conn.prepareStatement("delete from escala");) {
			stmt.execute();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		try (PreparedStatement stmt = conn.prepareStatement(
				"insert into escala(id_aluno, id_salaaulaturno1, id_salacafe, id_salaaulaturno2) values (?, ?, ?, ?)");) {
			for (Escala escala : escalas) {
				stmt.setInt(1, escala.codigoAluno);
				stmt.setInt(2, escala.salaturno1);
				stmt.setInt(3, escala.salacafe);
				stmt.setInt(4, escala.salaturno2);
				stmt.execute();

			}

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
