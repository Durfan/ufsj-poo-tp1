import java.util.List;

public class Aluno extends Colaboradores {
	
	private int count_andamento;

	public int getCount_andamento() {
		return count_andamento;
	}

	public void setCount_andamento(int count_andamento) {
		this.count_andamento = count_andamento;
	}

	@Override
	public boolean addProjeto(Projeto projeto) {
		List<Object> projetos = this.getProjetos();
		if (projetos.size() < 2) {
			super.addProjeto(projeto);
			return true;
		}
		else {
			System.out.println("Aluno já possui 2 projetos.");
		}
		return false;
	}

}
