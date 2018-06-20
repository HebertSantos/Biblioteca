package dw2.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBibliotecaFactory {
	
	public static Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/bibliotecadb",
					"sa",
					"");
					
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}