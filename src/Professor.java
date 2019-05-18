import java.util.List;
import java.util.ArrayList;

public class Professor extends Colaboradores {
	
	private List<Object> orientacoes = new ArrayList<>();
	
	public void addOrientando(Orientacao aluno) {
		orientacoes.add(aluno);
	}
	
	public List<Object> getOrientacoes() {
		return orientacoes;
	}

}
