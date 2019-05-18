import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
	private String nome;
	private List<Object> projetos = new ArrayList<>();
	private List<Object> colaboradores = new ArrayList<>();

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addProjeto(Projeto projeto) {
		projetos.add(projeto);
	}
	public List<Object> getProjetos() {
		return projetos;
	}
	
	public String imprimir() {
		return nome + "\n";
	}
	
	public String listarProjetos() {
		String conteudo = "Lista de projetos do Laboratorio " + nome + "\n";
		Projeto projeto = new Projeto();
		for(int x = 0; x < projetos.size(); x++) {
			projeto = (Projeto)projetos.get(x);
			conteudo = conteudo + projeto.getTitulo() + "\n"; 
		}
		return conteudo;
	}
	
	public String listarColaboradores() {
		String conteudo = "Lista de projetos do Laboratorio " + nome + "\n";
		Colaboradores colaborador = new Colaboradores();
		for(int x = 0; x < colaboradores.size(); x++) {
			colaborador = (Colaboradores)colaboradores.get(x);
			conteudo = conteudo + colaborador.getNome() + "\n"; 
		}
		return conteudo;
	}
	
	
	public int getSizeProjetos() {
		return projetos.size();
	}

	public int getSizeColaboradores() {
		return colaboradores.size();
	}
	
	public void addColaborador(Colaboradores Col) {
		colaboradores.add(Col);
		System.out.println("Colaborador adicionado");
	}
	
	public Projeto selecionaProjeto(String titulo) {
		if(projetos.size() > 0) {
			Projeto projeto = new Projeto();
			for(int x = 0; x < projetos.size(); x++) {
				projeto = (Projeto)projetos.get(x);
				if(projeto.getTitulo().intern() == titulo.intern()) {
					return projeto;
				}
			}
		}
		return null;
	}
	
	public Colaboradores selecionaColaborador(String titulo) {
		if(colaboradores.size() > 0) {
			Colaboradores Colaborador = new Colaboradores();
			for(int x = 0; x < colaboradores.size(); x++) {
				Colaborador = (Colaboradores)colaboradores.get(x);
				if(Colaborador.getNome().intern() == titulo.intern()) {
					return Colaborador;
				}
			}
		}
		return null;
	}
}
