package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turmas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTURMA")
	private int id;

	@Column(name = "CODIGO", length = 10)
	private String codigo;

	@Column(name = "PERIODO", length = 45)
	private String periodo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCURSO")
	private Cursos curso;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (" => " +getId() + " - " + getCodigo() + " - " + getPeriodo());
	}
}