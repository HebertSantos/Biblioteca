package dw2.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dw2.biblioteca.modelo.Livro;
import dw2.biblioteca.modelo.User;
import dw2.biblioteca.util.ConnectionBibliotecaFactory;

public class UserDAO {	
	
	public static User recuperaUser(String email, String password){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		
		try {
			String sql =
					"select * from usuario " +
							"where email=? and password=?";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			User user = null;
			while (rs.next()) {
				user = new User();				
				user.setEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setNome(rs.getString("NOME"));
				user.setUserType(rs.getInt("TYPE_USER"));				
			}			
			
			conn.close();
			return user;			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean isEmailValid(String email){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		boolean isEmailRegistred = false;
		
		try {
			String sql =
					"select * from usuario " +
							"where email=?";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();			
			
			if(rs.next()){
				isEmailRegistred = false;
			}else{
				isEmailRegistred = true;
			}
			
			conn.close();
			return isEmailRegistred;			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void NewUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		if (user == null)
			throw new RuntimeException("É Obrigatório preencher o Usuário Desejado");
		try {
			String sql = "Insert into usuario (EMAIL, PASSWORD, NOME, TYPE_USER) " +
							"values (?, ?, ?, ?)";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNome());
			ps.setInt(4, user.getUserType());
			ps.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void registredBook(String email, int idLivro){
		Connection conn = null;
		PreparedStatement ps = null;
				
		try {
			String sql = "Insert into USER_BOOKS (EMAIL_USUARIO, ID_PRODUTO) " +
							"values (?, ?)";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, idLivro);
			ps.executeUpdate();
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Livro> getListUserBooks(String email){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT L.* FROM LIVRO L " +
						 "INNER JOIN USER_BOOKS U ON U.ID_LIVRO = L.ID " +
						 "WHERE L.EMAIL_USUARIO = ?";
			conn = ConnectionBibliotecaFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			ArrayList<Livro> listaLivros =
					new ArrayList<Livro>();
			while(rs.next()) {
				Livro livro = new Livro(rs.getString("NOME_LIVRO"), 
											  rs.getInt("EDICAO"),
											  rs.getString("GENERO"));
				livro.setId(rs.getInt("ID"));
				listaLivros.add(livro);
			}
			
			conn.close();
			
			return listaLivros;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

