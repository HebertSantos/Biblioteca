package dw2.biblioteca.modelo;

public class Livro {
		
		private int id;
		private String tituloLivro;
		private int edicao;
		private String genero;	

		public Livro(String tituloLivro, int edicao, String genero) {		
			this.tituloLivro = tituloLivro;
			this.edicao = edicao;
			this.genero = genero;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String gettituloLivro() {
			return tituloLivro;
		}
		public void settituloLivro(String tituloLivro) {
			this.tituloLivro = tituloLivro;
		}	
		public int getEdicao() {
			return edicao;
		}

		public void setEdicao(int edicao) {
			this.edicao = edicao;
		}

		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		//Metodos TO-DO
		
		

	}
