import java.util.ArrayList;
import java.util.List;

public class Publicacao extends ProducaoAcademica {

	private List<Object> autores = new ArrayList<>();
	private String conferencia;
	
	public void addAutor(Colaboradores autor) {
		autores.add(autor);
		autor.addProducaoAcademica(this);
	}
	
	public List<Object> getAutores() {
		return autores;
	}

	public String getConferencia() {
		return conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}
	
	public String imprimir() {
		String conteudo = "Publicação \n" + super.imprimir() + 
				"Conferencia: " + getConferencia() + "\n";
		return conteudo;
	}
	
}
