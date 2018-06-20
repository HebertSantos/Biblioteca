package dw2.biblioteca.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dw2.biblioteca.dao.LivroDAO;
import dw2.biblioteca.dao.UserDAO;
import dw2.biblioteca.dao.EmprestimoDAO;
import dw2.biblioteca.modelo.Livro;
import dw2.biblioteca.modelo.User;
import dw2.biblioteca.modelo.Emprestimo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmprestarLivros implements Comando {

	@Override
	public String executaComando(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String idLivro = request.getParameter("idLivro");
		String urlDestino = "/listalivros.jsp";
		String msg = null;
		
		int id = Integer.parseInt(idLivro);
		HttpSession sessao = request.getSession(true);
		
		//Recupera o usuário da sessão
		User user = (User) sessao.getAttribute("user");
		
		Livro livro;
		LivroDAO livroDAO = new LivroDAO();
		livro = livroDAO.getLivro(id);		
		
		Date date = new Date();
				
		Emprestimo emprestimo = new Emprestimo(date, 
				                livro.getId(), 
				                user.getEmail());
		
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		emprestimoDAO.registrarEmprestimo(emprestimo);
		
		UserDAO userDAO = new UserDAO();
		userDAO.registredBook (user.getEmail(), livro.getId());
		
		ArrayList<Livro> listaDeBooks = livroDAO.getListaDeLivrosDisponiveis();
		request.getServletContext().setAttribute("listaDeBooks", listaDeBooks);	
		
		ArrayList<Livro> listaUserBooks = userDAO.getListUserBooks(user.getEmail());
		request.getServletContext().setAttribute("listaUserBooks", listaUserBooks);		
		
		return urlDestino;
	}

}
