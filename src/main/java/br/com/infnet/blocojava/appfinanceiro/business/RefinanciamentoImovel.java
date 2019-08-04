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
@Table(name = "refinanciamento_imovel")
@PrimaryKeyJoinColumn(name = "id_refinanciamento_imovel")
@Access(AccessType.PROPERTY)
public class RefinanciamentoImovel extends Emprestimo {
	
	@ColumnHeader(name = "Endereço da residência", position = 1)
	private String enderecoResidencia;
	
	@ColumnHeader(name = "Registro geral", position = 1)
	private int numMatriculaRegistro;
	
	@Column(name = "endereco_residencia")
	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}
	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
	}
	
	@Column(name = "num_matricula_registro")
	public int getNumMatriculaRegistro() {
		return numMatriculaRegistro;
	}
	public void setNumMatriculaRegistro(int numMatriculaRegistro) {
		this.numMatriculaRegistro = numMatriculaRegistro;
	}
	
	
}
