package dw2.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dw2.biblioteca.modelo.Livro;
import dw2.biblioteca.util.ConnectionBibliotecaFactory;

public class LivroDAO {
	
	public void salvarLivro(Livro livro) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		if(livro == null)
			throw new RuntimeException("Livro não pode se nulo");

		try {
			conn = ConnectionBibliotecaFactory.getConnection();
			String sql = "insert into LIVRO " +
							"(TITULO_LIVRO, EDICAO, GENERO)" +
								"values (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, livro.gettituloLivro());
			ps.setInt(2, livro.getEdicao());
			ps.setString(3, livro.getGenero());
			ps.executeUpdate();
			
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Livro> getListaDeLivrosDisponiveis() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from LIVRO";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<Livro> listaLivrosDisponiveis =
					new ArrayList<Livro>();
			while(rs.next()) {
				Livro livro = new Livro(rs.getString("TITULO_LIVRO"), 
						                       rs.getInt("EDICAO"),
						                       rs.getString("GENERO"));
				//livro.setId(rs.getInt("ID"));
				listaLivrosDisponiveis.add(livro);
			}
			
			conn.close();
			
			return listaLivrosDisponiveis;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public Livro getLivro(int idLivro) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from livro where id = ?";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idLivro);
			rs = ps.executeQuery();
			
			Livro livro = null;
			if(rs.next()) {
				livro = new Livro(rs.getString("TITULO_LIVRO"), 
	                                          rs.getInt("EDICAO"),
	                                        rs.getString("GENERO"));
				livro.setId(rs.getInt("ID"));
			}
			
			conn.close();
			
			return livro;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}