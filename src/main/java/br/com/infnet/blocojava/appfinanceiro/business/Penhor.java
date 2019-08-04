package br.com.infnet.blocojava.appfinanceiro.business;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.infnet.blocojava.appfinanceiro.utils.ColumnHeader;

@Entity
@Table(name = "penhor")
@PrimaryKeyJoinColumn(name = "id_penhor")
@Access(AccessType.PROPERTY)
public class Penhor extends Emprestimo {
	
	@ColumnHeader(name = "Bem penhorado", position = 1)
	private String bemPenhorado;
	
	@ColumnHeader(name = "Bem é tradicional?", position = 1)
	private Boolean tradicional;
	

	@Column(name = "bem_penhorado")
	public String getBemPenhorado() {
		return bemPenhorado;
	}
	public void setBemPenhorado(String bemPenhorado) {
		this.bemPenhorado = bemPenhorado;
	}
	
	@Column(name = "is_tradicional")
	public Boolean isTradicional() {
		return tradicional;
	}
	public void setTradicional(Boolean tradicional) {
		this.tradicional = tradicional;
	}
	

	
}
