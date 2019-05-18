import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Console;

public class Programa {
		
	static List<Object> listAlunos = new ArrayList<>();
	static List<Object> listProjetos = new ArrayList<>();
	static List<Object> listProfessores = new ArrayList<>();
	static List<Object> listLaboratorios = new ArrayList<>();
	static List<Object> listProducao = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int opcao = 0;
		
	    do {

	    	System.out.println(" Gerenciamento de Producao Academica\n\n");
	    	System.out.println(" === Consultas ==============");
	        System.out.println(" 1 - Listar Alunos");
	        System.out.println(" 2 - Listar Projetos");
	        System.out.println(" 3 - Listar Laboratorios");
	        System.out.println(" 4 - Por Projetos");
	        System.out.println(" 5 - Por Colaborador");
	        System.out.println(" 6 - Relatorio de Producao Academica");
	        System.out.println(" === Cadastrar ==============");
	        System.out.println(" 7 - Cadastrar Colaborador");
	        System.out.println(" 8 - Cadastrar Professor");
	        System.out.println(" 9 - Cadastrar Laboratório");
	        System.out.println(" ============================");
	        System.out.println(" 10 - Selecionar Laboratorio");
	        System.out.println(" 0 - Sair");

	        System.out.println("\n\n Escolha uma opcao: ");
			opcao = Integer.parseInt(Console.readLine());

	        switch ( opcao ) {
 	            case 1 :
	            	System.out.println(" 1 - Listar todos  Alunos");
	                listarColaboradores();
	            	break;
	            case 2 :
	            	System.out.println(" 2 - Listar todos Projetos");
	            	listarProjetos();
	                break;
	            case 3 :
	            	System.out.println(" 3 - Listar todos Laboratorios");
	            	listarLaboratorios();
	                break;
	            case 4 :
	            	System.out.println("4 - Consulta por projeto, informe o nome: ");
	            	String word = Console.readLine();
	            	consultaProjeto(word);
	                break;
	            case 5 :
	            	// AGUARDE
	                break;
	            case 6 :
	            	relatorioProducao();
	                break;
	            case 7 :
	               	System.out.println(" 7 - Cadastrar Colaborador");	
	            	cadastrarAluno(); 
	                break;	          
	            case 8 :
	            	System.out.println(" 8 - Cadastrar Professor");	
	            	cadastrarProfessor(); 
	                break;
	            case 9 :
	            	System.out.println(" 9 - Cadastrar Laboratorio");	
	            	cadastrarLaboratorio();
	                break;	
	            case 10 :
	            	System.out.println(" 10 - Selecionar Laboratorio, informe o nome: ");	
	    	    	String nome = Console.readLine(); 
	            	Laboratorio lab = selecionaLab(nome);

	            	if (lab != null) {
	            		int op = 0;
	            		do {
		            		System.out.println("Laboratorio: " +  nome);
		            		System.out.println(" 1 - Listar Projetos: ");
		            		System.out.println(" 2 - Listar Colaboradores: ");
		            		System.out.println(" 3 - Cadastrar Projeto ");
		            		System.out.println(" 4 - Adicionar Colaborador no laboratio: ");
		              		System.out.println(" 5 - Adicionar Colaborador em projeto: ");
		            		System.out.println(" 6 - Modificar status de projeto: ");
		              		System.out.println(" 7 - Adicionar Orientação em projeto: ");
		            		System.out.println(" 8 - Adicionar Publicacao em projeto: ");
		            		System.out.println(" 0 - Sair: ");
		        	        System.out.println("\n\n Escolha uma opcao: ");
		        			op = Integer.parseInt(Console.readLine());
		        			switch(op) {
		        			
				 	            case 1 :
					            	System.out.println(" 1 - Listar Projetos: ");
					            	
					            	if (lab.getSizeProjetos() > 0) {
					            		System.out.println(lab.listarProjetos());
					            	}
					            	else {
					            		System.out.println("Não existem projetos no laboratorio.");
					            	}
					            	break;
					            	
					            case 2 :
					            	System.out.println(" 2 - Listar Colaboradores");
					            	
					            	if (lab.getSizeColaboradores() > 0) {
					            		System.out.println(lab.listarColaboradores());
					            	}
					            	else {
					            		System.out.println("Não existem colaboradores");
					            	}
					                break;
					                
					            case 3 :
					            	System.out.println(" 3 - Cadastrar Projeto");
					            	cadastrarProjeto(lab);
					                break;
					                
					            case 4 :
					            	System.out.println(" 4 - Adicionar Colaborador no lab, informe o nome: ");
					            	String nomeA = Console.readLine(); 
					            	Colaboradores aluno = new Colaboradores();
					            	aluno = selecionaColaborador(nomeA);
					            	if (aluno != null) {
					            		lab.addColaborador(aluno);
					            	}
					            	break;
					            	
					            case 5 :
					            	System.out.println(" 5 - Adicionar Colaborador em projeto, informe o nome: ");
					            	String nome5 = Console.readLine(); 
					            	Colaboradores colaborador = new Colaboradores();
					            	colaborador = lab.selecionaColaborador(nome5);
					            	if (colaborador != null) {
					            		System.out.println("Informe o titulo do projeto: ");
					            		String titulo = Console.readLine();
					            		Projeto proj = lab.selecionaProjeto(titulo);
					            		if (proj != null && colaborador.addProjeto(proj)) {
					            			proj.addColaborador(colaborador);
					            		} 
					            		else {
					            			System.out.println("Projeto não encontrado ou aluno possui 2 projetos");
					            		}
					            		
					            	}
					            	break;
					            	
					            case 6: 
					            	System.out.println("6 - Mudança de status, informe o nome do professor gerente:" );
					            	String profGerente = Console.readLine();
					            	System.out.println("Informe o nome do projeto: ");
					            	String nomeProj = Console.readLine();
					            	Projeto projet = new Projeto();
					            	projet = lab.selecionaProjeto(nomeProj);
					            	if(projet == null) {
					            		System.out.println("Projeto nao encontrado.");
					            	}
					            	else {
					            		if (projet.getProfessores().getNome().intern() == profGerente.intern()) {
					            			System.out.println("Informe 1 para em andamento ou 2 para concluido");
					            			int z = Integer.parseInt(Console.readLine());
					            			if (z ==  1) {
					            				projet.setStatus(1);
					            				System.out.println("Status: Em andamento");
					            			}
					            			else if (z == 2) {
					            				if(projet.getPublicacoes().size()>1) {
					            					projet.setStatus(2);
					            					System.out.println("Status: Concluido");
					            					
					            				}
					            				else {
					            					System.out.println("Não existem publicações associadas.");
					            				}
					            			}
					            		}
					            		else {
					            			System.out.println("Não é o professor responsavel.");
					            		}
					            	}
					            	break;

					            case 7:
					            	System.out.println("7 - Orientacao, informe o nome do professor: ");
					            	String profname = Console.readLine();
					            	Colaboradores prof = new Colaboradores();
					            	prof = lab.selecionaColaborador(profname);
					            	
					            	if (prof == null) {
					            		System.out.println("Professor nao encontrado.");
					            	}
					            	else {
					            		if (prof instanceof Professor) {
					            			System.out.println("Informe o nome do projeto: ");
					            			String projname = Console.readLine();
					            			Projeto pro = new Projeto();
					            			pro = lab.selecionaProjeto(projname);
					            			
					            			if (pro != null) {
					            				System.out.println("Informe o nome do orientando");
					            				String orientandoname = Console.readLine();
					            				Colaboradores orientando = new Colaboradores();
					            				orientando =lab.selecionaColaborador(orientandoname);
					            				
					            				if(orientando == null) {
					            					System.out.println("Aluno não encontrado.");
					            				}
					            				else {
						            				System.out.println("Imforme o titulo da orientacao: ");
									            	String tit = Console.readLine();
									            	System.out.println("Informe o ano de orientacao: ");
									            	int an = Integer.parseInt(Console.readLine());
									            	Orientacao orientacao = new Orientacao();
									            	orientacao.setAluno(orientando);
									            	orientacao.setAno(an);
									            	orientacao.setTitulo(tit);
									            	((Professor) prof).addOrientando(orientacao);
									            	pro.addOrietacao(orientacao);
									            	listProducao.add(orientacao);
									       		}
					            			}
					            			else {
					            				System.out.println("Projeto não existe");
					            			}
					            		}
					            		else {
					            			System.out.println("Colaborador informado não é professor.");
					            		}
					            	}
					            	break;

					            case 8:
					            	System.out.println("8 - Publicação, informe o titulo do projeto: ");
					            	String title = Console.readLine();
					            	Projeto proj = lab.selecionaProjeto(title);
					            	if(proj == null || proj.getStatus() != 1) {
					            		System.out.println("Projeto não existe ou status invalido.");
					            	
					            	}
					            	else {
						            	System.out.println("Imforme o titulo da publicacao: ");
						            	title = Console.readLine();
						            	System.out.println("Informe o ano de publicacao: ");
						            	int ano = Integer.parseInt(Console.readLine());
						            	System.out.println("Informe a conferencia: ");
						            	String conferencia = Console.readLine();
						            	
						            	Publicacao publicacao = new Publicacao();
						            	publicacao.setConferencia(conferencia);
						            	publicacao.setAno(ano);
						            	publicacao.setTitulo(title);
						            	System.out.println("Informe o número de autores: ");
						            	int quantidade = Integer.parseInt(Console.readLine());
						            	String autor;
						            	Colaboradores cola = new Colaboradores();
						            	for(int i =0; i<quantidade; i++) {
						            		System.out.println("Informe o nome de um autor: ");
						            		autor = Console.readLine(); 
						            		cola = lab.selecionaColaborador(autor);
						            		if(cola == null) {
						            			System.out.println("Autor não está cadastrado no lab, informe outro.");
						            		}else {
						            			publicacao.addAutor(cola);
						            		}
						            	}
						            	proj.addPublicacao(publicacao);
						            	listProducao.add(publicacao);
					            	}
					            	break;
			        		}
		        		} while(op != 0);
		            		
	            	}
	            	
	            	break;
	            
	        }
	    } while(opcao != 0);	
		
	}

	public static void cadastrarProjeto(Laboratorio lab) {
		
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
	    
	    Professor prof = new Professor();
	    
	    int op = 0;
	    while(op == 0) {
	    	System.out.println("Nome do Professor gerente: ");
	    	String nomeProf = Console.readLine(); 
	    	if (listProfessores.size() == 0 ) {
	    		System.out.println("Não existe professores cadastrados, por favor cadestre.");
	    		return ;
	    	}
	    	
	    	for ( int x = 0; x < listProfessores.size(); x++ ) {
				prof = (Professor)listProfessores.get(x);
				if(prof.getNome().intern() == nomeProf.intern()) {
					op = 1;
					break;
				}
			}
	    	
	    	if (op == 0) {
	    		System.out.println("Professor não encontrado, segue a lista de professores cadastrados.\n");
	    		listarProfessores();
	    	}
	    	
	    }
	    
	    
	    Projeto projeto = new Projeto();
	    
	    projeto.setTitulo(titulo);
	    projeto.setDatainicio(Dinicio);
	    projeto.setFinanciadora(financiadora);
	    projeto.setCapital(Integer.parseInt(capital));
	    projeto.setObjetivo(objetivo);
	    projeto.setDescricao(descricao);
	    projeto.setProfessores(prof);

	    listProjetos.add(projeto);
	    lab.addProjeto(projeto);	   
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
	
	
	public static void cadastrarProfessor() {
		
		System.out.println("Nome: ");
	    String nome = Console.readLine();
	     
	    
	    Professor prof = new Professor();
	    prof.setNome(nome);
	    
	    listProfessores.add(prof);	   
	}
	
	public static void listarAlunos() {
		
		for ( int x = 0; x < listAlunos.size(); x++ ) {
			Aluno aluno = (Aluno)listAlunos.get(x);
			System.out.println(aluno.imprimir());
		}
	}
	
	public static void listarProfessores() {
		System.out.println("Lista de Professores: \n");
		for ( int x = 0; x < listProfessores.size(); x++ ) {
			Professor prof = (Professor)listProfessores.get(x);
			System.out.println(prof.imprimir());
		}
	}
	
	public static void addColaboradorProjeto() {
		Projeto pro = new Projeto();
	    int op = 0;
	    while (op == 0) {
	    	System.out.println("Titulo do projeto: ");
	    	String nomePro = Console.readLine(); 
	    	if (listProjetos.size() == 0 ) {
	    		System.out.println("Não existe projetos cadastrados, por favor cadestre.");
	    		return ;
	    	}
	    	for ( int x = 0; x < listProjetos.size(); x++ ) {
				pro = (Projeto)listProjetos.get(x);
				if(pro.getTitulo().intern() == nomePro.intern()) {
					op = 1;
					break;
				}
			}
	    	if (op == 0) {
	    		System.out.println("Projeto não encontrado, segue a lista de projetos cadastrados.\n");
	    		listarProfessores();
	    	}
	    }
	    op = 0;
	    
	    int status = pro.getStatus();
	    if(status != 1) {
	    	System.out.println("Projeto não se encontra em andamento, portanto não é permitido adicioanr aluno.");
	    	return;
	    }
	    
	    Aluno aluno = new Aluno();
	    //SELECIONA ALUNO
	    while(op == 0) {
	    	System.out.println("Nome do Aluno: ");
	    	String nomeAl = Console.readLine(); 
	    	if (listAlunos.size() == 0 ) {
	    		System.out.println("Não existe alunos cadastrados, por favor cadestre.");
	    		return ;
	    	}
	    	for ( int x = 0; x < listAlunos.size(); x++ ) {
				aluno = (Aluno)listAlunos.get(x);
				if(aluno.getNome().intern() == nomeAl.intern()) {
					op = 1;
					break;
				}
			}
	    	if (op == 0) {
	    		System.out.println("Aluno não encontrado, segue a lista de alunos cadastrados.\n");
	    		listarAlunos();
	    	}
	    }
	    pro.addColaborador(aluno);
	}

	
	public static void listarColaboradores() {
		List<Object> colaboradores = new ArrayList<>();
		colaboradores.addAll(listAlunos);
		colaboradores.addAll(listProfessores);
		
		for ( int x = 0; x < colaboradores.size(); x++ ) {
			Colaboradores colaborador = (Colaboradores)colaboradores.get(x);
			System.out.println(colaborador.imprimir());
		}
	}
	
	public static void cadastrarLaboratorio() {
		Laboratorio laboratorio = new Laboratorio();
		
		System.out.println("Infome o nome do Laboratorio:");
		String nome = Console.readLine(); 
		laboratorio.setNome(nome);
		
		listLaboratorios.add(laboratorio);
	}
	
	public static void listarLaboratorios() {
		System.out.println("Lista de Laboratorios");
		for ( int x = 0; x < listLaboratorios.size(); x++ ) {
			Laboratorio lab = (Laboratorio)listLaboratorios.get(x);
			System.out.println(lab.imprimir());
		}
	}
	
	
	public static Laboratorio selecionaLab(String nome) {
		Laboratorio lab = new Laboratorio();
    	for ( int x = 0; x < listLaboratorios.size(); x++ ) {
			lab = (Laboratorio)listLaboratorios.get(x);
			if(lab.getNome().intern() == nome.intern()) {
				return lab;
			}
		}

   		System.out.println("Aluno não encontrado, segue a lista de alunos cadastrados.\n");
		return null;
	}
	
	public static Colaboradores selecionaColaborador(String nome) {
		List<Object> cols = new ArrayList<>();
		cols.addAll(listAlunos);
		cols.addAll(listProfessores);
		
		Colaboradores aluno = new Colaboradores();
    	for ( int x = 0; x < cols.size(); x++ ) {
			aluno = (Colaboradores)cols.get(x);
			if(aluno.getNome().intern() == nome.intern()) {
				return aluno;
			}
		}

   		System.out.println("Aluno não encontrado.");
		return null;
	
	}
	
	public static void consultaProjeto(String nome) {
		Projeto proj= new Projeto();
		proj = null;
    	for ( int x = 0; x < listProjetos.size(); x++ ) {
			proj = (Projeto)listProjetos.get(x);
			if(proj.getTitulo().intern() == nome.intern()) {
				break;
			}
		}
    	if(proj == null ) {
    		System.out.println("Projeto não existe.");
    	}else {
    		System.out.println(proj.imprimir());
    	}
	}
	
	public static void relatorioProducao() {
		int numColaboradores = listAlunos.size() + listProfessores.size();
		int numProjetos = listProjetos.size();
		
		int numProEla=0, numProAnd =0, numProCon = 0, numPub = 0, numOri = 0;
		Projeto proj = new Projeto();
		for(int i = 0; i<numProjetos; i++) {
			proj = (Projeto)listProjetos.get(i);
			if(proj.getStatus() == 0 ) {
				numProEla++;
			}else if(proj.getStatus() == 1) {
				numProAnd++;
			}else {
				numProCon++;
			}
		}
		for(int i = 0; i<listProducao.size(); i ++) {
			if(listProducao.get(i) instanceof Orientacao) {
				numOri++;
			}else {
				numPub++;
			}
		}
		String conteudo = "Número de colaboradores: " + numColaboradores + "\n"+
				"Número de projetos em elaboração: "+ numProEla + "\n" +
				"Número de projetos em andamento: "+numProAnd+"\n"+
				"Número de projetos concluídos: "+numProCon+"\n"+
				"Número total de projetos: "+numProjetos+"\n"+
				"Número de publicações: "+numPub+"\n" +
				"Número de orientações: "+numOri+"\n";
		System.out.println(conteudo);
	}
	/*
	public static void consultaColaborador(String nome) {
		Colaboradores colaborador = new Colaboradores();
		colaborador = selecionaColaborador(nome);
		List listAux = new ArrayList();
		if(colaborador == null) {
			System.out.println("Colaborador nao existe.");
		}else {
			String conteudo = colaborador.imprimirProjetos();
			ProducaoAcademica producao = new ProducaoAcademica();
			for(int i = 0; i < listProducao.size(); i++) {
				producao = (ProducaoAcademica)listProducao.get(i);
			}
		}
	}
	*/
}
