package br.com.infnet.blocojava.appfinanceiro.business;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
@AttributeOverride(name = "id", column = @Column(name = "id_usuario"))
@Access(AccessType.PROPERTY)
public class Usuario extends AbstractBusiness {
	
	private String name;
	private String email;
	private String password;
	
	@Column(name = "nome")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "senha")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() 
	{
		return String.format("%s - %s", this.name, this.email);
	}
	
	
	
}
