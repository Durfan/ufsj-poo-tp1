
public class ProducaoAcademica {
	
	private String titulo;
	private int ano;
	
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
		
	}
	
	public String imprimir() {
		String conteudo = "Titulo " + getTitulo() + "\n"+ " Ano: " + getAno() + "\n";
		return conteudo;
				
	}
	
}
