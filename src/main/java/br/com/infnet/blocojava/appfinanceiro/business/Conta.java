package br.com.infnet.blocojava.appfinanceiro.business;

import java.text.MessageFormat;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.infnet.blocojava.appfinanceiro.utils.ColumnHeader;

@Entity
@Table(name = "conta")
@Access(AccessType.PROPERTY)
@AttributeOverride(name = "id", column = @Column(name = "id_conta"))
public class Conta extends AbstractBusiness {
	
	@ColumnHeader(name = "Número Conta", position = 1)
	private String numeroConta;
	
	@ColumnHeader(name = "Descrição", position = 2)
	private String descricao;
	
	@ColumnHeader(name = "Data Criação", position = 3)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataCriacao;
	
	@ColumnHeader(name = "Data Cancelamento", position = 4)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataCancelamento;
	
	@ColumnHeader(name = "Valor", position = 5)
	private float valor;
	
	private Favorecido favorecido;
	
	@Transient
	@ColumnHeader(name = "Favorecido", position = 6)
	private int favorecidoId;
	

	public Conta() {
		
	}
	
	public Conta(int id, String numeroConta, String descricao, Date dataCriacao, Date dataCancelamento, float valor,
			Favorecido favorecido) {
		super();
		this.numeroConta = numeroConta;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataCancelamento = dataCancelamento;
		this.valor = valor;
		this.favorecido = favorecido;
	}
	
	@Column(name = "numero_conta")
	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	@Column(name = "data_criacao")
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Column(name = "data_cancelamento")
	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	
	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name = "valor")
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@OneToOne
	@JoinColumn(name = "id_favorecido")
	public Favorecido getFavorecido() {
		return favorecido;
	}
	public void setFavorecido(Favorecido favorecido) {
		this.favorecido = favorecido;
	}
		

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + ", dataCancelamento=" + dataCancelamento + ", valor=" + valor + ", favorecido="
				+ favorecido + ", favorecidoId=" + favorecidoId + "]";
	}
	
	@Transient
	public String valorDescricao() {
		return MessageFormat.format("{0} - {1}", this.getFavorecido().getNome(), this.getNumeroConta());
	}

	@Transient
	public int getFavorecidoId() {
		return favorecidoId;
	}

	@Transient
	public void setFavorecidoId(int favorecidoId) {
		this.favorecidoId = favorecidoId;
	}
	
	
}