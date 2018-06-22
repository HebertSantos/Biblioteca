package dw2.biblioteca.comando;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw2.biblioteca.dao.LivroDAO;
import dw2.biblioteca.modelo.Livro;

public class CadastrarLivro implements Comando {

	@Override
	public String executaComando(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String urlDestino = "/admin.jsp";
		ArrayList<Livro> listaDeLivros;				
		
		String nomeLivro = request.getParameter("nomeLivro");
		String sEdicao = request.getParameter("edicao");
		String genero = request.getParameter("genero");
		
		
		int edicao = Integer.parseInt(sEdicao);
		
		
		
		Livro novoLivro = new Livro(nomeLivro, edicao, genero);
		LivroDAO dbLivro = new LivroDAO();
		
		dbLivro.salvarLivro(novoLivro); 
		listaDeLivros = dbLivro.getListaDeLivrosDisponiveis();
		
		request.getServletContext().setAttribute("listaLivros", listaDeLivros);			
		
		return urlDestino;
	}

}
