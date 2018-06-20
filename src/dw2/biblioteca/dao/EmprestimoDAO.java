package dw2.biblioteca.dao;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dw2.biblioteca.modelo.Emprestimo;
import dw2.biblioteca.util.ConnectionBibliotecaFactory;

public class EmprestimoDAO {
	
	public void registrarEmprestimo(Emprestimo emprestimo) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		if(emprestimo == null)
			throw new RuntimeException("O Emprestimo deve possuir algum livro disponivel");

		try {
			conn = ConnectionBibliotecaFactory.getConnection();
			String sql = "insert into EMPRESTIMOS " +
							"(DATA_EMPRESTIMO, ID_LIVRO, EMAIL_USER)" +
								"values (?, ?, ?)";
			ps = conn.prepareStatement(sql);	
			
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			java.sql.Date sqlData = new java.sql.Date(year, month, day);
			ps.setDate(1, sqlData);
			ps.setInt(2, emprestimo.getIdLivro());
			ps.setString(3, emprestimo.getEmailUser());
			ps.executeUpdate();
			
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
