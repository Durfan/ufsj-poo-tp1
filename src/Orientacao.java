
public class Orientacao extends ProducaoAcademica {
	
	private Colaboradores aluno = new Colaboradores();


	public Aluno getAluno() {
		return (Aluno)aluno;
	}
	
	public void setAluno(Colaboradores orientando) {
		this.aluno = orientando;
	}
	
	public String imprimir() {
		String conteudo = "Orientação: Nome do orientando " + getAluno().getNome() + "\n" + super.imprimir() + "\n";
		return conteudo;
	}

}
