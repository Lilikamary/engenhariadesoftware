package br.ufpe.cin.videolocadora.bean;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import br.ufpe.cin.videolocadora.dominios.DominioTipoUsuario;
import br.ufpe.cin.videolocadora.jpa.Usuario;
import br.ufpe.cin.videolocadora.util.JPAUtil;

@Named
@RequestScoped
@URLMappings( 
		mappings = {
		@URLMapping(id="manterUsuario" , pattern="/cadastrar" 
				,viewId = "/resources/pages/usuario/manterUsuario.xhtml")
		}
		)
public class UsuarioBean {

	private Usuario usuario;
	private List<DominioTipoUsuario> tipoUsuarios;
	
	
	public void salvar() {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public UsuarioBean() {
		tipoUsuarios = Arrays.asList(DominioTipoUsuario.values());
		usuario = new Usuario();
	}

	
	public List<DominioTipoUsuario> getTipoUsuarios(){
		return tipoUsuarios;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
