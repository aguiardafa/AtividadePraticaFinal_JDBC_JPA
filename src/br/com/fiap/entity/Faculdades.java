package br.com.fiap.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculdades")
public class Faculdades implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDFACULDADE")
	private int id;

	@Column(name = "NOME", length = 45)
	private String nome;

	@Column(name = "CNPJ", length = 14)
	private String cnpj;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "faculdade")
	private Set<Cursos> cursos = new HashSet<Cursos>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	public Set<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Cursos> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + " - " + getNome() + " - " + getCNPJ();
	}
}