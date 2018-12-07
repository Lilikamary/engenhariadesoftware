/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.videolocaeng.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lilian
 *  data! de! nascimento.! Apenas!maiores! de!idade! podem! ser! titulares.!De! um! dependente,!
são necessários apenas! o! nome,! eFmail,! sexo! e! data! de nascimento.! Tanto!
titulares! quanto! dependentes!têm um!número de!inscrição," o" qual" é"único por!
cliente.
 */
@Entity
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoCliente;
    private Endereco endereco;
    private int ddd;
    private int telefoneResidencial;
    private String localTrabalho;
    private int telefoneComercial;
    private int telefoneCelular;
    private String cpf;
    
    
    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCliente != null ? codigoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codigoCliente == null && other.codigoCliente != null) || (this.codigoCliente != null && !this.codigoCliente.equals(other.codigoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.videolocaeng.model.Cliente[ id=" + codigoCliente + " ]";
    }
    
}
