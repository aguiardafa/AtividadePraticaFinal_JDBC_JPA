package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Cursos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCURSO")
	private int id;

	@Column(name = "CODIGO", length = 10)
	private String codigo;

	@Column(name = "DESCRICAO", length = 45)
	private String descricao;

	@Column(name = "VALOR")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDFACULDADE")
	private Faculdades faculdade;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="curso") 
	private Set<Turmas> turmas = new LinkedHashSet<Turmas>();

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Faculdades getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdades faculdade) {
		this.faculdade = faculdade;
	}

	public Set<Turmas> getTurmas() {
		return turmas;
	}
	public void setTurmas(Set<Turmas> turmas) {
		this.turmas = turmas;
	}
}
