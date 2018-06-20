package dw2.biblioteca.modelo;

public class Livro {
		
		private int id;
		private String nomeLivro;
		private int edicao;
		private String genero;	

		public Livro(String nomeLivro, int edicao, String genero) {		
			this.nomeLivro = nomeLivro;
			this.genero = genero;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getNomeLivro() {
			return nomeLivro;
		}
		public void setNomeLivro(String nome) {
			this.nomeLivro = nome;
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
