package models.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "produtos")
@XmlRootElement(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;
	private String descricao;
	private int quantidade;
	private double valor;

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(final int quantidade) {
		System.out.println("Produto.setQuantidade() " + quantidade);
		this.quantidade = quantidade;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(final double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ", quantidade=" + this.quantidade + ", valor=" + this.valor
				+ "]";
	}

}
