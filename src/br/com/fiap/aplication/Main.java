package br.com.fiap.aplication;

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
		
		while (true) {
			// Solicitando comando do usuário
			Integer opcao = new Integer(JOptionPane.showInputDialog("" 
					+ "################# MENU ############### \n"
					+ "## 1 - Cadastrar Faculdade;         ## \n" 
					+ "## 2 - Deletar Faculdade;           ## \n"
					+ "## 3 - Atualizar Faculdade;         ## \n" 
					+ "###################################### \n"
					+ "## 4 - Add Curso na Faculdade;      ## \n" 
					+ "## 5 - Listar Cursos da Faculdade;  ## \n"
					+ "###################################### \n" 
					+ "Informe o número da operação desejada: "));
			switch (opcao) {
			case 1:
				try {
					String aux;
					// Definindo a Faculdade
					Faculdades faculdade = new Faculdades();
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;         ## \n" 
							+ "###################################### \n"
							+ "Digite o nome da Faculdade:");
					faculdade.setNome(aux);
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;         ## \n" 
							+ "###################################### \n"
							+ "Digite o CNPJ da Faculdade:");
					faculdade.setCNPJ(aux);
					// Definindo o Curso
					Cursos curso = new Cursos();
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;         ## \n" 
							+ "###################################### \n"
							+ "Para cadastrar uma Faculdade é necessário definir um Curso!!! \n\n"
							+ "Digite o Código do Curso da Faculdade:");
					curso.setCodigo(aux);
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;         ## \n" 
							+ "###################################### \n"
							+ "Digite o Nome do Curso da Faculdade:");
					curso.setDescricao(aux);
					Double valor = new Double(JOptionPane.showInputDialog(""
							+ "############### OPÇÃO 1 ############## \n" 
							+ "## 1 - Cadastrar Faculdade;         ## \n"
							+ "###################################### \n"
							+ "Digite o Valor da Mensalidade do Curso da Faculdade: \n\n" 
							+ "* Obs:Em double!!!"));
					curso.setValor(valor);
					// Definindo duas turmas
					Turmas turma1 = new Turmas();
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;         ## \n" 
							+ "###################################### \n"
							+ "Para cadastrar uma Faculdade é necessário definir também uma Turma de Curso!!! \n\n"
							+ "Digite o Código da Turma do Curso informado:");
					turma1.setCodigo(aux);
					aux = JOptionPane.showInputDialog("" 
							+ "############### OPÇÃO 1 ############## \n"
							+ "## 1 - Cadastrar Faculdade;         ## \n" 
							+ "###################################### \n"
							+ "Digite o Periodo da Turma do Curso informado: \n"
							+ "1 - para MATUTINO; 2 - para VESPERTINO; 3 - para NOTURNO;");
					switch (opcao) {
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
					// Fazendo as associacÌ§oÌƒes
					curso.getTurmas().add(turma1);
					faculdade.getCursos().add(curso);
					dao.salvar(faculdade);
					System.out.println("Faculdade incluída com sucesso!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				String aux = JOptionPane.showInputDialog("" 
						+ "############## OPÇÃO 2 ############# \n"
						+ "## 1 - Deletar Faculdade;         ## \n" 
						+ "#################################### \n"
						+ "Digite o ID da Faculdade:");
				
				break;
			case 3:
				
				break;
			default:
				
				break;
			}
		}
	}
}
