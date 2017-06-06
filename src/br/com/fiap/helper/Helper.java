package br.com.fiap.helper;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Cursos;
import br.com.fiap.entity.Faculdades;
import br.com.fiap.entity.Turmas;

public class Helper {

	private EntityManager em;

	public Helper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Faculdades faculdade) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(faculdade);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Set<Turmas> listarUsuarios(int idCurso) {
		Set<Turmas> turmas = new HashSet<Turmas>();
		try {
			Cursos curso = em.find(Cursos.class, idCurso);
			turmas = curso.getTurmas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return turmas;
	}

	public Set<Cursos> listarCursos(int idFaculdade) {
		Set<Cursos> cursos = new HashSet<Cursos>();
		try {
			Faculdades faculdade = em.find(Faculdades.class, idFaculdade);
			cursos = faculdade.getCursos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cursos;
	}
	
	public Faculdades buscaFaculdade(int idFaculdade){
		
		return 	null;
	}
}
