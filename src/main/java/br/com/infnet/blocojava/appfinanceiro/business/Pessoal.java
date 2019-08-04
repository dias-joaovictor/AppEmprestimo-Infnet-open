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
@Table(name = "pessoal")
@PrimaryKeyJoinColumn(name = "id_pessoal")
@Access(AccessType.PROPERTY)
public class Pessoal extends Emprestimo {
	
	@ColumnHeader(name = "Status da aprovação", position = 1)
	private String statusProvacao;

	@Column(name = "status_aprovacao")
	public String getStatusProvacao() {
		return statusProvacao;
	}

	public void setStatusProvacao(String statusProvacao) {
		this.statusProvacao = statusProvacao;
	}
	
	
	
}
