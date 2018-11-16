package biblioteca.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Emprestimo;
import biblioteca.models.Livro;

public class EmprestimoDAO {
	private Connection connection;

	public EmprestimoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Emprestimo emprestimo) {

		String query = "insert into emprestimos (aluno, livro, dataEmprestimo) values (?, ?, ?);";

		try {
			PreparedStatement p = connection.prepareStatement(query);

			Calendar calendario = Calendar.getInstance();
			Long calendarioEF = calendario.getTimeInMillis();

			p.setLong(1, emprestimo.getAluno().getId());
			p.setLong(2, emprestimo.getLivro().getId());
			p.setDate(3, new java.sql.Date(calendarioEF));

			p.execute();
			p.close();
			System.out.println("Salvo com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return false;
	}

	public boolean qtdEmprestimos(Emprestimo emprestimo) throws SQLException {

		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where aluno = ? and dataDevolucao IS NULL;");
			stmt.setLong(1, emprestimo.getAluno().getId());
			ResultSet rs = stmt.executeQuery();
			int cont = 0;
			while (rs.next()) {
				cont++;
			}
			stmt.close();
			if (cont > 2) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}
	
	

	public List<Emprestimo> getListaAbertos() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where dataDevolucao is null;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				emprestimos.add(montarEmprestimo(rs));
			}

			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Emprestimo> getListaAtraso() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection
					.prepareStatement("select * from emprestimos where dataDevolucao is null and dataEmprestimo < ?;");
			Calendar date = Calendar.getInstance();
			stmt.setDate(1, new Date(date.getTimeInMillis() - 14 * 24 * 60 * 60 * 1000));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				emprestimos.add(montarEmprestimo(rs));
			}
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Emprestimo> getLista() {
		try {

			List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
			PreparedStatement stmt = connection.prepareStatement("select * from emprestimos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				emprestimos.add(montarEmprestimo(rs));
			}
			rs.close();
			stmt.close();
			return emprestimos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private Emprestimo montarEmprestimo(ResultSet rs) throws SQLException {
		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setId(rs.getLong("id"));
		Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno"));
		emprestimo.setAluno(aluno);
		Livro livro = new LivroDAO().getLivroByID(rs.getLong("livro"));
		emprestimo.setLivro(livro);

		Calendar data = Calendar.getInstance();
		data.setTime(rs.getDate("dataEmprestimo"));
		emprestimo.setDataEmprestimo(data);

		if (rs.getDate("dataDevolucao") != null) {
			Calendar data2 = Calendar.getInstance();
			data2.setTime(rs.getDate("dataDevolucao"));
			emprestimo.setDataDevolucao(data2);
		}

		return emprestimo;
	}

	public boolean devolucao(Emprestimo emprestimo) {
		String sql = "update emprestimos set dataDevolucao=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(2, emprestimo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Emprestimo getEmprestimoByID(Long id) {
		try {

			Emprestimo emprestimo = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				emprestimo = montarEmprestimo(rs);
			}
			rs.close();
			stmt.close();
			return emprestimo;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}
