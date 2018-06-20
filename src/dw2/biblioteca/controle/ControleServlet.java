package dw2.biblioteca.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw2.biblioteca.comando.Comando;


@WebServlet("/ControleServlet")
public class ControleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ControleServlet() {
        super();        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("comando");
		String nomeComando = "dw2.biblioteca.comando." + parametro;
		
		try {
			//Recupera a classe do pakage dw2.biblioteca.comando
			//com o nome equivalente ao da variavel nomeComando
			Class comandoClasse = Class.forName(nomeComando);
			
			//Cria uma instância da classe recuperada acima
			Comando comando = (Comando) comandoClasse.newInstance();
			
			//Recupera o destino da requisição
			String destino = comando.executaComando(request, response);
			
			//Envia para o destino a requisição
			request.getRequestDispatcher(destino).forward(request, response);
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}