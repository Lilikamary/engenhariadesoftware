package br.ufpe.cin.vimperial.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
@SequenceGenerator(name = "seq_telefone",
sequenceName = "telefone_seq", initialValue = 1, 
allocationSize = 1)
public class Telefone {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq_telefone")
	private Long codTelefone;
	
	@ManyToOne
	private Cliente cliente;
		
	private String telefone;
	
	
	public Long getCodTelefone() {
		return codTelefone;
	}
	public void setCodTelefone(Long codTelefone) {
		this.codTelefone = codTelefone;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
