
public class Aluno extends Colaboradores {
	
	private String nome;
	private Boolean mestrado;
	
	private int count_andamento;
	
	private Projeto projetos = new Projeto();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getMestrado() {
		return mestrado;
	}

	public void setMestrado(Boolean mestrado) {
		this.mestrado = mestrado;
	}

	public int getCount_andamento() {
		return count_andamento;
	}

	public void setCount_andamento(int count_andamento) {
		this.count_andamento = count_andamento;
	}

	public Projeto getProjetos() {
		return projetos;
	}

	public void setProjetos(Projeto projetos) {
		this.projetos = projetos;
	}
	
	public String imprimir() {
		String conteudo = "Nome: " + nome + "\n";
		conteudo = conteudo + "Graduacao: " + mestrado + "\n";		
		
		return conteudo;
	}
	
}
