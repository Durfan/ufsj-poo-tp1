import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Projeto {
	
	private String titulo;
	private String datainicio;
	private String datafim;
	private String financiadora; // Agencia Financiadora
	private int capital;		 // Valor Financiado
	private String objetivo;
	private String descricao;
	private int status = 0;		 // 0 para elaboração, 1 pra andamento, 2 para concluido
	
	//private Colaboradores colaboradores = new Colaboradores();
	private Professor professor = new Professor();
	private List<Object> colaboradores = new ArrayList<>();
	private List<Object> orientacoes = new ArrayList<>();
	private List<Object> publicacoes = new ArrayList<>();
	
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDatainicio() {
		return datainicio;
	}
	
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	
	public String getDatafim() {
		return datafim;
	}
	
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}
	
	public String getFinanciadora() {
		return financiadora;
	}
	
	public void setFinanciadora(String financiadora) {
		this.financiadora = financiadora;
	}
	
	public int getCapital() {
		return capital;
	}
	
	public void setCapital(int capital) {
		this.capital = capital;
	}
	
	public String getObjetivo() {
		return objetivo;
	}
	
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getStatusStr() {
		if (status == 0) {
			return "Em elaboração";
		} else if(status == 1) {
			return "Em Andamento";
		} else {
			return "Concluido";
		}
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public List<Object> getColaboradores() {
		return colaboradores;
	}
	
	public void addColaboradores(Colaboradores colaboradores) {
		this.colaboradores.add(colaboradores);
	}
	
	public Professor getProfessores() {
		return professor;
	}
	
	public void setProfessores(Professor professores) {
		this.professor = professores;
	}
	
	public void addOrietacao(Orientacao orientacao) {
		orientacoes.add(orientacao);	
	}
	
	public List<Object> getOrientacoes() {
		return orientacoes;
	}
	
	public List<Object> getPublicacoes() {
		return publicacoes;
	}
	
	public void addPublicacao(Publicacao publicacao) {
		publicacoes.add(publicacao);
	}
	
	public String imprimir() {
		String conteudo = "Titulo: " + titulo + "\n"
						+ "Data de Inicio: " + datainicio + "\n"
						+ "Financiadora: " + financiadora + "\n"
						+ "Capital: " + capital + "\n"
						+ "Objetivo: " + objetivo + "\n"
						+ "Descricao: " + descricao + "\n"
						+ "Status: " + status + "\n"
						+ "Professor: " + professor.getNome() + "\n"
						+ "Colaboradores: " + colaboradoresImprimir() + "\n"
						+  publicacoesImprimir();
		
		return conteudo;
	}
	
	public String colaboradoresImprimir(){
		String conteudo = "";
		for ( int x = 0; x < colaboradores.size(); x++ ) {
			Colaboradores col = (Colaboradores)colaboradores.get(x);
			conteudo = conteudo + col.getNome() + ", ";
		}
		return conteudo + "\n";
	}
	
	public String publicacoesImprimir(){
		String conteudo = "Orientações: ";
		for ( int x = 0; x < orientacoes.size(); x++ ) {
			Orientacao col = (Orientacao)orientacoes.get(x);
			conteudo = conteudo + col.imprimir() + "\n";
		}
		conteudo = conteudo + "Publicações: ";
		for ( int x = 0; x < publicacoes.size(); x++ ) {
			Publicacao col = (Publicacao)publicacoes.get(x);
			conteudo = conteudo + col.imprimir() + "\n";
		}
		return conteudo;
		
	}
	
	public void addColaborador(Colaboradores colaborador) {
		this.colaboradores.add(colaborador);
	}
	
	public void modificaStatus(Professor profGerente) {
		if (profGerente == this.professor) {
			System.out.println("Digite 1 para Em andamento, 2 Para concluído ou 0 para sair.");
			Scanner sc = new Scanner(System.in);
			int op = sc.nextInt();
			
			if (op == 1) {
				this.setStatus(op);
				sc.close();
				System.out.println("Status: Em andamento.");
			} else if (op == 2) {
				if (publicacoes.size() > 0) {
					this.setStatus(op);
					sc.close();
					System.out.println("Status: Concluído.");
				}
				else {
					System.out.println("Não existe publicação associado, portanto status em Andamento.");
					sc.close();
				}
			}
		}
	}
}
