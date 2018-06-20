package dw2.biblioteca.modelo;

import java.util.Date;

public class Emprestimo {
	
	private int idEmprestimo;
	private Date dataEmprestimo;
	private int idLivro;
	private String emailUser;
	
	
	public Emprestimo(Date dataEmprestimo, int idLivro, String emailUser) {			
		this.dataEmprestimo = dataEmprestimo;
		this.idLivro = idLivro;
		this.emailUser = emailUser;
		
	}
	
	public Emprestimo(){
		
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

}
