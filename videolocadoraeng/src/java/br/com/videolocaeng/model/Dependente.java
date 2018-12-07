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
 */
@Entity
public class Dependente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoDependente;
    
    private Long codigoTitular;
    

    public Long getCodigoDependente() {
        return codigoDependente;
    }

    public void setCodigoDependente(Long codigoDependente) {
        this.codigoDependente = codigoDependente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDependente != null ? codigoDependente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependente)) {
            return false;
        }
        Dependente other = (Dependente) object;
        if ((this.codigoDependente == null && other.codigoDependente != null) || (this.codigoDependente != null && !this.codigoDependente.equals(other.codigoDependente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.videolocaeng.model.Dependente[ id=" + codigoDependente + " ]";
    }

    /**
     * @return the codigoTitular
     */
    public Long getCodigoTitular() {
        return codigoTitular;
    }

    /**
     * @param codigoTitular the codigoTitular to set
     */
    public void setCodigoTitular(Cliente codigoTitular) {
        this.codigoTitular = codigoTitular.getCodigoCliente();
    }
    
}
