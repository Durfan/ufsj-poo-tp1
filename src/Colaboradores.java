import java.util.ArrayList;
import java.util.List;

public class Colaboradores {
	
	private String nome;
	private Boolean mestrado;
	private List<Object> producaoAcademica = new ArrayList<>();
	private List<Object> projetos = new ArrayList<>();
	
	
	public Boolean getMestrado() {
		return mestrado;
	}

	public void setMestrado(Boolean mestrado) {
		this.mestrado = mestrado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String imprimir() {
		String conteudo = "Nome: " + this.getNome() + "\n";
		conteudo = conteudo + "Graduacao: " + this.getMestrado() + "\n";		
		
		return conteudo;
	}
	
	public List<Object> getProjetos() {
		return projetos;
	}

	public String imprimirProjetos() {
		String conteudo = imprimir();
		Projeto proj = new Projeto();
		for (int i = 0; i < projetos.size(); i++) {
			proj = (Projeto)getProjetos().get(i); 
			conteudo = conteudo + proj.imprimir();
		}
		return conteudo;
	}
	
	public boolean addProjeto(Projeto projeto) {
		this.projetos.add(projeto);
		return true;
	}
	
	public void addProducaoAcademica(ProducaoAcademica prod) {
		this.producaoAcademica.add(prod);
	}

}
