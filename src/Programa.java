import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import util.Console;

public class Programa {
	
	static List listAlunos = new ArrayList();
	static List listProjetos = new ArrayList();
	
	public static void main(String[] args) {
		
		int opcao = 0;
		
	    do {

	    	System.out.println(" Gerenciamento de Producao Academica\n\n");
	    	System.out.println(" === Consultas ==============");
	        System.out.println(" 1 - Listar Alunos");
	        System.out.println(" 2 - Listar Projetos");
	        System.out.println(" 3 - Relatorio do Laboratorio");
	        System.out.println(" === Cadastrar ==============");
	        System.out.println(" 4 - Cadastrar Aluno");	
	        System.out.println(" 5 - Cadastrar Projeto");
	        System.out.println(" 6 - Cadastrar Publicacao");
	        System.out.println(" ============================");
	        System.out.println(" 0 - Sair");

	        System.out.println("\n\n Escolha uma opcao: ");
			opcao = Integer.parseInt(Console.readLine());

	        switch ( opcao ) {
	            case 1 :
	            	System.out.println(" 1 - Listar Alunos");
	                listarAlunos();
	            	break;
	            case 2 :
	            	System.out.println(" 2 - Listar Projetos");
	            	listarProjetos();
	                break;
	            case 3 :
	                break;
	            case 4 :
	            	System.out.println(" 4 - Cadastrar Colaborador");	
	            	cadastrarAluno(); 
	                break;	          
	            case 5 :
	            	System.out.println(" 5 - Cadastrar Projeto");
	            	cadastrarProjeto();
	                break;
	            case 6 :
	                break;	          
	            
	        }

	    } while( opcao != 0 );	
		
	}
	
	
	public static void cadastrarProjeto() {
		
		System.out.println("Titulo: ");
	    String titulo = Console.readLine();
	    
		System.out.println("Data Inicio: ");
	    String Dinicio = Console.readLine();
	   
	    Date dateInicio =  new Date();
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    Dinicio = formato.format(dateInicio);
	    
		System.out.println("Agencia Financiadora: ");
	    String financiadora = Console.readLine();
	    
		System.out.println("Valor Financiado: ");
	    String capital = Console.readLine();
	    
		System.out.println("Objetivo: ");
	    String objetivo = Console.readLine();
	    
		System.out.println("Descricao: ");
	    String descricao = Console.readLine();
	    
		System.out.println("Status: ");
	    String status = Console.readLine();
	    
	    Projeto projeto = new Projeto();
	    
	    projeto.setTitulo(titulo);
	    projeto.setDatainicio(Dinicio);
	    projeto.setFinanciadora(financiadora);
	    projeto.setCapital(Integer.parseInt(capital));
	    projeto.setObjetivo(objetivo);
	    projeto.setDescricao(descricao);
	    projeto.setTitulo(status);

	    
	    listProjetos.add(projeto);	   
	}
	
	
	public static void listarProjetos() {
		
		for ( int x = 0; x < listProjetos.size(); x++ ) {
			Projeto projeto = (Projeto)listProjetos.get(x);
			System.out.println(projeto.imprimir());
		}
	}
	
	
	public static void cadastrarAluno() {
		
		System.out.println("Nome: ");
	    String nome = Console.readLine();
	    
	    System.out.println("Tipo de Colaborador: ");
	    System.out.println("0- Mestrando ");
	    System.out.println("1- Graduando ");
	    
	    String tipoColaborador = Console.readLine();	   
	    
	    Aluno aluno = new Aluno();
	    aluno.setNome(nome);
	    aluno.setMestrado(Boolean.parseBoolean(tipoColaborador));
	    
	    listAlunos.add(aluno);	   
	}
	
	public static void listarAlunos() {
		
		for ( int x = 0; x < listAlunos.size(); x++ ) {
			Aluno aluno = (Aluno)listAlunos.get(x);
			System.out.println(aluno.imprimir());
		}
	}

}
