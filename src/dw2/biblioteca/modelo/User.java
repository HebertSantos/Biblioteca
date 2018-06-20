package dw2.biblioteca.modelo;

import java.util.ArrayList;

public class User {
	
	private String email;
	private String password;
	private String nome;
	private int userType;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	
	public static boolean isUserHaveBook(int idLivro, ArrayList<Livro> listaLivros){
		for(int i = 0; i < listaLivros.size(); i++){
			if(listaLivros.get(i).getId() == idLivro){
				return true;				
			}
		}
		return false;
	}

}