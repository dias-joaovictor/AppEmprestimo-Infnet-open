package br.com.infnet.blocojava.appfinanceiro.business;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.infnet.blocojava.appfinanceiro.utils.ColumnHeader;

@Entity
@Table(name = "favorecido")
@Access(AccessType.PROPERTY)
@AttributeOverride(name = "id", column = @Column(name = "id_favorecido"))
public class Favorecido extends AbstractBusiness{
	
	@ColumnHeader(name = "Nome", position = 1)
	private String nome;
	
	@ColumnHeader(name = "É Empresa?", position = 2)
	private Boolean empresa;

	public Favorecido() 
	{
		
	}
	
	public Favorecido(String nome) {
		this.setNome(nome);
	}
	
	public Favorecido(int id, String nome, Boolean empresa) {
		this(nome);
		this.setId(id);
		this.setEmpresa(empresa);
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "is_empresa")
	public Boolean isEmpresa() {
		return empresa;
	}
	public void setEmpresa(Boolean empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", 
				this.isEmpresa() ? "Empresa" : "Pessoa",
				this.getNome()
			);
	}
}
