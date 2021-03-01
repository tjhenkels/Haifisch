package br.henkels.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			"create table salaaula (id_salaaula int identity(1,1) primary key,nome varchar(25), lotacao int)  ", //
			"create table salacafe (id_salacafe int identity(1,1) primary key,nome varchar(25), lotacao int)  ", //
			
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
			e.printStackTrace();

		}

	}

	public void saveSalaAula(String nome, int lotacao) {
		try (PreparedStatement stmt = conn.prepareStatement("insert into salaAula(nome, lotacao) values (?, ?)");) {
			stmt.setString(1, nome);
			stmt.setInt(2,lotacao);
			stmt.execute();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

	public void saveSalaCafe(String nome, int lotacao) {
		try (PreparedStatement stmt = conn.prepareStatement("insert into salaCafe(nome, lotacao) values (?, ?)");) {
			stmt.setString(1, nome);
			stmt.setInt(2,lotacao);
			stmt.execute();
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();

		}
		
	}
}
