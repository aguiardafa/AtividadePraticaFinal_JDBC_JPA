package br.com.fiap.aplication;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Faculdades;
import br.com.fiap.entity.OpcoesPeriodo;
import br.com.fiap.entity.Turmas;
import br.com.fiap.helper.Helper;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AtividadePraticaFinal_JDBC_JPA");
		EntityManager em = emf.createEntityManager();
		Helper dao = new Helper(em);
		
		do{
			Integer idFaculdade = null;
			String aux = null;
			Double valor = 0.0;
			// Solicitando comando do usuário
			Integer opcao = new Integer(JOptionPane.showInputDialog("" 
					+ "################# MENU ############### \n"
					+ "## 1 - Cadastrar Faculdade;          \n" 
					+ "## 2 - Deletar Faculdade;            \n"
					+ "## 3 - Atualizar Faculdade;          \n" 
					+ "###################################### \n"
					+ "## 4 - Add Curso na Faculdade;       \n" 
					+ "## 5 - Listar Cursos da Faculdade;   \n"
					+ "## 6 - Listar Faculdade Completa;  \n"
					+ "###################################### \n" 
					+ "Informe o número da operação desejada: "));
			switch (opcao) {
			case 1:
				try {
					// Definindo a Faculdade
					Faculdades faculdade = new Faculdades();
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;          \n" 
							+ "###################################### \n"
							+ "Digite o nome da Faculdade:");
					faculdade.setNome(aux);
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;          \n" 
							+ "###################################### \n"
							+ "Digite o CNPJ da Faculdade:");
					faculdade.setCNPJ(aux);
					// Definindo o Curso
					Cursos curso = new Cursos();
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;          \n" 
							+ "###################################### \n"
							+ "Para cadastrar uma Faculdade é necessário definir um Curso!!! \n\n"
							+ "Digite o Código do Curso da Faculdade:");
					curso.setCodigo(aux);
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;          \n" 
							+ "###################################### \n"
							+ "Digite o Nome do Curso da Faculdade:");
					curso.setDescricao(aux);
					valor = new Double(JOptionPane.showInputDialog(""
							+ "############### OPÇÃO 1 ############## \n" 
							+ "## 1 - Cadastrar Faculdade;          \n"
							+ "###################################### \n"
							+ "Digite o Valor da Mensalidade do Curso da Faculdade: \n\n" 
							+ "* Obs:Em double!!!"));
					curso.setValor(valor);
					// Definindo turma
					Turmas turma1 = new Turmas();
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;          \n" 
							+ "###################################### \n"
							+ "Para cadastrar uma Faculdade é necessário definir também uma Turma de Curso!!! \n\n"
							+ "Digite o Código da Turma do Curso informado:");
					turma1.setCodigo(aux);
					Integer opcaoPeriodo = new Integer(JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;          \n" 
							+ "###################################### \n"
							+ "Digite o Periodo da Turma do Curso informado: \n"
							+ "1 - para MATUTINO; 2 - para VESPERTINO; 3 - para NOTURNO;"));
					switch (opcaoPeriodo) {
					case 1:
						turma1.setPeriodo(OpcoesPeriodo.MATUTINO.getTurno());
						break;
					case 2:
						turma1.setPeriodo(OpcoesPeriodo.VESPERTINO.getTurno());
						break;
					case 3:
						turma1.setPeriodo(OpcoesPeriodo.NOTURNO.getTurno());
						break;
					default:
						turma1.setPeriodo(OpcoesPeriodo.MATUTINO.getTurno());
						break;
					}
					// Fazendo as associações
					turma1.setCurso(curso);
					curso.getTurmas().add(turma1);
					curso.setFaculdade(faculdade);
					faculdade.getCursos().add(curso);
					faculdade = dao.salvar(faculdade);
					System.out.println("Faculdade incluída com sucesso! \n\n");
					printRelacinamentoCompleto(faculdade, em);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				idFaculdade = new Integer(JOptionPane.showInputDialog("" 
						+ "############## OPÇÃO 2 ############# \n"
						+ "## 2 - Deletar Faculdade;          \n" 
						+ "#################################### \n"
						+ "Digite o ID da Faculdade:"));
				try {
					Faculdades facul = dao.buscaFaculdade(idFaculdade.intValue());
					if(facul!=null){
						System.out.println("Faculdade encontra: " + facul.toString());
						dao.excluir(facul.getId());
						System.out.println("Faculdade excluída com sucesso!");
					}else{
						System.out.println("Não foi encontrado Faculdade com o ID: " + idFaculdade);	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 3:
				idFaculdade = new Integer(JOptionPane.showInputDialog("" 
						+ "############## OPÇÃO 3 ############# \n"
						+ "## 3 - Atualizar Faculdade;        \n" 
						+ "#################################### \n"
						+ "Digite o ID da Faculdade:"));
				try {
					Faculdades facul = dao.buscaFaculdade(idFaculdade.intValue());
					if(facul!=null){
						System.out.println("Faculdade encontra: " + facul.toString());
						// Atualizando a Faculdade
						aux = JOptionPane.showInputDialog("" 
								+ "############## OPÇÃO 3 ############# \n"
								+ "## 3 - Atualizar Faculdade;        \n" 
								+ "#################################### \n"
								+ "Digite o nome da Faculdade:");
						if(!aux.equals(null))
							facul.setNome(aux);
						aux = JOptionPane.showInputDialog("" 
								+ "############## OPÇÃO 3 ############# \n"
								+ "## 3 - Atualizar Faculdade;        \n" 
								+ "#################################### \n"
								+ "Digite o CNPJ da Faculdade:");
						if(!aux.equals(null))
							facul.setCNPJ(aux);
						facul = dao.atualizar(facul);
						System.out.println("Faculdade atualizada com sucesso!");
						System.out.println("Faculdade: " + facul.toString());
					}else{
						System.out.println("Não foi encontrado Faculdade com o ID: " + idFaculdade);	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				idFaculdade = new Integer(JOptionPane.showInputDialog("" 
						+ "############## OPÇÃO 4 ############# \n"
						+ "## 4 - Add Curso na Faculdade;     \n" 
						+ "#################################### \n"
						+ "Digite o ID da Faculdade:"));
				try {
					Faculdades facul = dao.buscaFaculdade(idFaculdade.intValue());
					if(facul!=null){
						System.out.println("Faculdade encontra: " + facul.toString());
						// Adicionando o curso
						Cursos c = new Cursos();
						aux = JOptionPane.showInputDialog("" 
								+ "############## OPÇÃO 4 ############# \n"
								+ "## 4 - Add Curso na Faculdade;     \n" 
								+ "#################################### \n"
								+ "Digite o Código do Curso da Faculdade:");
						if(!aux.equals(null))
							c.setCodigo(aux);
						aux = JOptionPane.showInputDialog("" 
								+ "############## OPÇÃO 4 ############# \n"
								+ "## 4 - Add Curso na Faculdade;     \n" 
								+ "#################################### \n"
								+ "Digite o Nome do Curso da Faculdade:");
						if(!aux.equals(null))
							c.setDescricao(aux);
						valor = new Double(JOptionPane.showInputDialog(""
								+ "############## OPÇÃO 4 ############# \n"
								+ "## 4 - Add Curso na Faculdade;     \n" 
								+ "#################################### \n"
								+ "Digite o Valor da Mensalidade do Curso da Faculdade: \n\n" 
								+ "* Obs:Em double!!!"));
						c.setValor(valor);
						// Fazendo as associações
						//c.getTurmas().add(turma1);
						
						c.setFaculdade(facul);
						facul.getCursos().add(c);
						facul = dao.atualizar(facul);
						System.out.println("Curso incluído na Faculdade com sucesso!");
						System.out.println("Faculdade: " + facul.toString());
					}else{
						System.out.println("Não foi encontrado Faculdade com o ID: " + idFaculdade);	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 5:
				idFaculdade = new Integer(JOptionPane.showInputDialog("" 
						+ "############## OPÇÃO 5 ############## \n"
						+ "## 5 - Listar Cursos da Faculdade;  \n"
						+ "##################################### \n"
						+ "Digite o ID da Faculdade:"));
				try {
					Faculdades facul = dao.buscaFaculdade(idFaculdade.intValue());
					if(facul!=null){
						System.out.println("Faculdade encontra: " + facul.toString() +"\n");
						// listando os cursos da faculdade
						System.out.println("#################################################");
						System.out.println("### Lista Cursos da Faculdade: " + facul.getId() + " - " +facul.getNome());
						System.out.println("#################################################");
						List<Cursos> cursosFacul = dao.listarCursos(facul.getId());
						for (Cursos curso : cursosFacul) {
							System.out.println(curso.toString());
						}
					}else{
						System.out.println("Não foi encontrado Faculdade com o ID: " + idFaculdade);	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 6:
				idFaculdade = new Integer(JOptionPane.showInputDialog("" 
						+ "############## OPÇÃO 6 ############## \n"
						+ "## 6 - Listar Faculdade Completa;  \n"
						+ "##################################### \n"
						+ "Digite o ID da Faculdade:"));
				try {
					Faculdades facul = dao.buscaFaculdade(idFaculdade.intValue());
					if(facul!=null){
						System.out.println("Faculdade encontra: " + facul.toString() +"\n");
						printRelacinamentoCompleto(facul, em);
					}else{
						System.out.println("Não foi encontrado Faculdade com o ID: " + idFaculdade);	
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("ERRO: Informe um número da operação VÁLIDO!!!");
				break;
			}
		}while(true);
	}
	
	public static void printRelacinamentoCompleto(Faculdades f, EntityManager em){
		try{
			Helper dao2 = new Helper(em);
		int contC = 1;
		int contT = 1;
			System.out.println("#################################################");
			System.out.println("1. Dados da Faculdade: " + f.toString() +"");
			// listando os cursos da faculdade
			List<Cursos> cursosFacul = dao2.listarCursos(f.getId());
			for (Cursos curso : cursosFacul) {
				System.out.println("1."+contC+". Dados do Curso: " +curso.toString());
				// listando as tumas do curso da faculdade
				List<Turmas> turmasCurso = dao2.listarTurmas(curso.getId());
				for (Turmas turma : turmasCurso) {
					System.out.println("1."+ contC +"."+ contT + ". Dados da Turma: " + turma.toString());
					contT++;
				}	
				contC++;
			}
			System.out.println("################################################# \n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
