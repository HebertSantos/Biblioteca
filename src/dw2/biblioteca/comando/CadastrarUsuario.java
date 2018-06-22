package dw2.biblioteca.comando;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw2.biblioteca.dao.LivroDAO;
import dw2.biblioteca.dao.UserDAO;
import dw2.biblioteca.modelo.Livro;
import dw2.biblioteca.modelo.User;

public class CadastrarUsuario implements Comando {

	@Override
	public String executaComando(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String urlDestino = "/cadastro.jsp";
		boolean isError = false;
		String mensagemErro = null;
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");		
		
		UserDAO userDAO = new UserDAO();
		
		if(userDAO.isEmailValid(email)){
			if(isValidPassword(password, password2)){
				User newUser = new User();
				newUser.setEmail(email);
				newUser.setNome(nome);
				newUser.setPassword(password);
				newUser.setUserType(2);
				
				userDAO.NewUser(newUser);
				urlDestino = "/login.jsp";
				
			}
			else{
				isError = true;
				mensagemErro = "Senha incorreta!";
				
				request.setAttribute("mensagemErro", mensagemErro);
				request.setAttribute("isError", isError);
			}
		}
		else{
			isError = true;
			mensagemErro = "E-mail já cadastrado!";
			
			request.setAttribute("mensagemErro", mensagemErro);
			request.setAttribute("isError", isError);
		}
		
		return urlDestino;
	}
	
	public boolean isValidPassword(String password, String password2){
		
		if(password.equals(password2)){
			return true;
		}
		else{
			return false;
		}
		
	}

}
