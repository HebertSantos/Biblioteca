package dw2.biblioteca.comando;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw2.biblioteca.dao.LivroDAO;
import dw2.biblioteca.dao.UserDAO;
import dw2.biblioteca.modelo.Livro;
import dw2.biblioteca.modelo.User;

public class Logar implements Comando {

	@Override
	public String executaComando(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String urlDestino = "/login.jsp";
		String msg = null;
		
		User user;		
		user = UserDAO.recuperaUser(email, password);
		
		if(user != null) {
			HttpSession	sessao = request.getSession(true);		
			switch (user.getUserType()) {			
				case 1:	//ADMINISRADOR		
					urlDestino = "/admin.jsp";						
					break;
				case 2:	//USER COMUM	
					urlDestino = "/livrosdisponiveis.jsp";					
					break;
				default: //CASO NENHUM DOS ANTERIORES FUNCIONE			
					urlDestino = "/login.jsp";
					msg = "Erro Interno";
					request.setAttribute("msg", msg);
			}
			
			LivroDAO dbLivro = new LivroDAO();			
			ArrayList<Livro> listaDeLivrosDisponiveis = dbLivro.getListaDeLivrosDisponiveis();
			request.getServletContext().setAttribute("listaLivrosDisponiveis", listaDeLivrosDisponiveis);			
			
			if(user.getUserType() == 2){
				UserDAO dbUser = new UserDAO();
				ArrayList<Livro> ListUserBooks = dbUser.getListUserBooks(user.getEmail());
				request.getServletContext().setAttribute("listUserBooks", ListUserBooks);
			}
			
			sessao.setAttribute("user", user);
		} else {
			msg = "Senha e/ou e-mail inválido(s)";
			request.setAttribute("msg", msg);
		}
	
		return urlDestino;		
	}

}