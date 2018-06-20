package dw2.biblioteca.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Comando {
	
	public String executaComando(HttpServletRequest request, HttpServletResponse response) throws Exception;

}