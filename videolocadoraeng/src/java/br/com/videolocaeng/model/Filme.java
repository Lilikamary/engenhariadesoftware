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
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoFilme;

    public Long getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(Long codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFilme != null ? codigoFilme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filme)) {
            return false;
        }
        Filme other = (Filme) object;
        if ((this.codigoFilme == null && other.codigoFilme != null) || (this.codigoFilme != null && !this.codigoFilme.equals(other.codigoFilme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.videolocaeng.model.Filme[ id=" + codigoFilme + " ]";
    }
    
}
