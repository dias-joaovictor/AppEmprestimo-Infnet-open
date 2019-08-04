package br.com.infnet.blocojava.appfinanceiro.business;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.infnet.blocojava.appfinanceiro.utils.ColumnHeader;

@Entity
@Table(name = "emprestimo")
@Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverride(name = "id", column = @Column(name = "id_emprestimo"))
@Access(AccessType.PROPERTY)
public class Emprestimo extends AbstractBusiness {
	
	@ColumnHeader(name = "Valor", position = 1)
	private float valor;
	
	@ColumnHeader(name = "Data Criação", position = 1)
	private Date dataCriacao;
	
	@ColumnHeader(name = "Total Parcelas", position = 1)
	private int quantiParcelas;
	
	@ColumnHeader(name = "Procentual de Juros", position = 1)
	private float porcentJuros ;
	
	@ColumnHeader(name = "Peridiocidade", position = 1)
	private Integer tipoPeriodo;
	
	private Conta conta;
	
	@Transient
	@ColumnHeader(name = "Conta", position = 1)
	private int contaId;
	
	@Column(name = "valor")
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_criacao")
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Column(name = "quant_parcelas")
	public int getQuantiParcelas() {
		return quantiParcelas;
	}
	public void setQuantiParcelas(int quantiParcelas) {
		this.quantiParcelas = quantiParcelas;
	}
	
	@Column(name = "porcent_juros")
	public float getPorcentJuros() {
		return porcentJuros;
	}
	public void setPorcentJuros(float porcentJuros) {
		this.porcentJuros = porcentJuros;
	}
	
	@Column(name = "tipo_periodo")
	public Integer getTipoPeriodo() {
		return tipoPeriodo;
	}
	public void setTipoPeriodo(Integer tipoPeriodo) {
		this.tipoPeriodo = tipoPeriodo;
	}
	
	@OneToOne
	@JoinColumn(name = "id_conta")
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	@Transient
	public int getContaId() {
		return contaId;
	}
	
	@Transient
	public void setContaId(int contaId) {
		this.contaId = contaId;
	}
	
}
