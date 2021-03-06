package biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import biblioteca.dao.ConnectionFactory;
import biblioteca.models.Aluno;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Aluno aluno) {

		String sql = "insert into alunos (nome, matricula, cpf, endereco, dataNascimento) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setString(3, aluno.getCpf());
			stmt.setString(4, aluno.getEndereco());
			stmt.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Aluno> getLista() {
		try {

			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement stmt = connection.prepareStatement("select * from alunos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setId(rs.getLong("id"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);

				alunos.add(aluno);
			}
			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Aluno a) {
		String sql = "update alunos set nome=?, matricula=?, cpf=?, endereco=?, dataNascimento=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getCpf());
			stmt.setString(3, a.getMatricula());
			stmt.setString(4, a.getEndereco());
			stmt.setLong(6, a.getId());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void remover(Aluno aluno) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from alunos where id=?;");
			stmt.setLong(1, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Aluno getAlunoByID(Long id) {
		try {

			Aluno aluno = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Aluno getAlunoByMatricula(String matricula) {
		try {

			Aluno aluno = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where matricula=?;");
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setMatricula(rs.getString("matricula"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}