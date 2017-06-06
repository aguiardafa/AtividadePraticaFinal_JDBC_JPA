package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Faculdades;
import br.com.fiap.entity.Turmas;

public class Helper {

	private EntityManager em;

	public Helper(EntityManager em) {
		this.em = em;
	}

	// CRUD Faculdades
	public Faculdades salvar(Faculdades faculdade) throws Exception {
		try {
			em.getTransaction().begin();
			// Salva os dados da faculdade
			em.persist(faculdade);
			em.getTransaction().commit();
			System.out.println("Salvando os dados de: " + faculdade.getNome());
		} catch (Exception e) {
			throw e;
		}
		return faculdade;
	}

	public Faculdades atualizar(Faculdades faculdade) throws Exception {
		try {
			em.getTransaction().begin();
			// Atualiza os dados da faculdade
			faculdade = em.merge(faculdade);
			em.getTransaction().commit();
			System.out.println("Atualizando os dados de: " + faculdade.getNome());
		} catch (Exception e) {
			throw e;
		}
		return faculdade;
	}

	public void excluir(int idFaculdade) throws Exception {
		try {
			em.getTransaction().begin();
			// Consulta a faculdade na base de dados através do seu ID.
			Faculdades faculdade = em.find(Faculdades.class, idFaculdade);
			System.out.println("Excluindo os dados de: " + faculdade.getNome());
			// Remove a faculdade da base de dados.
			em.remove(faculdade);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Faculdades buscaFaculdade(int idFaculdade) throws Exception {
		Faculdades faculdade = null;
		try {
			// Consulta uma faculdade pelo seu ID.
			faculdade = em.find(Faculdades.class, idFaculdade);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		return faculdade;
	}

	@SuppressWarnings("unchecked")
	public List<Faculdades> listarFaculdades() throws Exception {
		TypedQuery<Faculdades> typedQuery = em.createNamedQuery("Faculdades.findAll", Faculdades.class);

		return typedQuery.getResultList();
	}

	// CRUD Cursos
	public void salvar(Cursos curso) throws Exception {
		try {
			em.getTransaction().begin();
			// Salva os dados da curso
			em.persist(curso);
			System.out.println("Salvando os dados de: " + curso.getCodigo());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Cursos atualizar(Cursos curso) throws Exception {
		try {
			em.getTransaction().begin();
			// Atualiza os dados da curso
			curso = em.merge(curso);
			System.out.println("Atualizando os dados de: " + curso.getCodigo());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		return curso;
	}

	public void excluirCurso(int idCurso) throws Exception {
		try {
			em.getTransaction().begin();
			// Consulta a curso na base de dados através do seu ID.
			Cursos curso = em.find(Cursos.class, idCurso);
			System.out.println("Excluindo os dados de: " + curso.getCodigo());
			// Remove a curso da base de dados.
			em.remove(curso);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Cursos buscaCurso(int idCurso) throws Exception {
		Cursos curso = null;
		try {
			// Consulta uma curso pelo seu ID.
			curso = em.find(Cursos.class, idCurso);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		return curso;
	}

	@SuppressWarnings("unchecked")
	public List<Cursos> listarCursos() throws Exception {
		TypedQuery<Cursos> typedQuery = em.createNamedQuery("Cursos.findAll", Cursos.class);

		return typedQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cursos> listarCursos(int idFaculdade) throws Exception {
		TypedQuery<Cursos> typedQuery = em.createQuery(
				"SELECT c FROM Cursos c WHERE c.faculdade.id=:idFaculdade", Cursos.class);
		typedQuery.setParameter("idFaculdade", idFaculdade);

		return typedQuery.getResultList();
	}

	// CRUD Turmas
	public void salvar(Turmas turma) throws Exception {
		try {
			em.getTransaction().begin();
			// Salva os dados da turma
			em.persist(turma);
			System.out.println("Salvando os dados de: " + turma.getCodigo());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Turmas atualizar(Turmas turma) throws Exception {
		try {
			em.getTransaction().begin();
			// Atualiza os dados da turma
			turma = em.merge(turma);
			System.out.println("Atualizando os dados de: " + turma.getCodigo());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		return turma;
	}

	public void excluirTurma(int idTurma) throws Exception {
		try {
			em.getTransaction().begin();
			// Consulta a turma na base de dados através do seu ID.
			Turmas turma = em.find(Turmas.class, idTurma);
			System.out.println("Excluindo os dados de: " + turma.getCodigo());
			// Remove a turma da base de dados.
			em.remove(turma);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Turmas buscaTurma(int idTurma) throws Exception {
		Turmas turma = null;
		try {
			// Consulta uma turma pelo seu ID.
			turma = em.find(Turmas.class, idTurma);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
		return turma;
	}

	@SuppressWarnings("unchecked")
	public List<Turmas> listarTurmas() throws Exception {
		TypedQuery<Turmas> typedQuery = em.createNamedQuery("Turmas.findAll", Turmas.class);

		return typedQuery.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Turmas> listarTurmas(int idCurso) throws Exception {
		TypedQuery<Turmas> typedQuery = em.createQuery("SELECT t FROM Turmas t WHERE t.curso.id=:idCurso",
				Turmas.class);
		typedQuery.setParameter("idCurso", idCurso);

		return typedQuery.getResultList();
	}

}
