/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dto;

/**
 *
 * @author itakenami
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "cotacoes")
@XmlRootElement(name = "cotacao")
public class Cotacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String cpf;
	private String solicitante;

	private Date data_solicitacao;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "produtos_cotacoes", joinColumns = { @JoinColumn(name = "cotacao_id") }, inverseJoinColumns = { @JoinColumn(name = "produto_id") })
	private Set<Produto> produtos;

	/**
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public String getSolicitante() {
		return this.solicitante;
	}

	public void setSolicitante(final String solicitante) {
		this.solicitante = solicitante;
	}

	public Date getData_solicitacao() {
		return this.data_solicitacao;
	}

	public void setData_solicitacao(final Date data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}

	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(final Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
