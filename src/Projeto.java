import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Projeto extends Laboratorio {
	
	private String titulo;
	private String datainicio;
	private String datafim;
	private String financiadora; // Agencia Financiadora
	private int capital;		 // Valor Financiado
	private String objetivo;
	private String descricao;
	private int status;
	
	private Set colaboradores = new TreeSet();
	private Set professores = new TreeSet();
	
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
	public void setStatus(int status) {
		this.status = status;
	}
	public Set getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(Set colaboradores) {
		this.colaboradores = colaboradores;
	}
	public Set getProfessores() {
		return professores;
	}
	public void setProfessores(Set professores) {
		this.professores = professores;
	}
	
	public String imprimir() {
		String conteudo = "        Titulo: " + titulo + "\n"
						+ "Data de Inicio: " + datainicio + "\n"
						+ "  Financiadora: " + financiadora + "\n"
						+ "       Capital: " + capital + "\n"
						+ "      Objetivo: " + objetivo + "\n"
						+ "     Descricao: " + descricao + "\n"
						+ "        Status: " + status + "\n";
		
		return conteudo;
	}
	
}
