package br.ufpe.cin.videolocadora.bean;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ufpe.cin.videolocadora.jpa.Usuario;
import br.ufpe.cin.videolocadora.util.JPAUtil;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

@Named
@RequestScoped
@URLMappings(
		mappings = {
				@URLMapping(id="logout" , pattern="/logout" 
											,viewId = "/resources/pages/autenticacao/autenticacao.xhtml"),
				@URLMapping(id="autenticador" , pattern="/autenticador" 
										,viewId = "/resources/pages/autenticacao/autenticacao.xhtml")
		}
)
public class AutenticadorBean {

			protected static final String USUARIO_AUTENTICADO = "USER_KEY";
					

			private String login;
			
			private String senha;
			
			private Usuario usuario = new Usuario();
	
			private static final String URL = "home.xhtml";
			
			private HttpServletRequest getRequest(){
				return (HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest();
			}
			
			protected HttpSession getSession(boolean force) {
				return (HttpSession) FacesContext.getCurrentInstance()
						.getExternalContext().getSession(force);
			}
			
			protected HttpSession getSession() {
				return getSession(true);
			}
			
			public String autenticar() {
				HttpServletRequest request = getRequest(); //obtenho a requisicao
				try {
					request.login(login, senha); //efetuar o login
					
					//obtenho dados do usuario associado ao login
					Usuario usuarioVerificado = obterUsuarioPorLogin(login); 
					
					//armazeno as informacoes do usuario na sessao
					getSession().setAttribute(USUARIO_AUTENTICADO, usuarioVerificado);

					//redireciono ele para pagina principal
					FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
				} catch (Exception e) {
						FacesMessage errorMessage = 
									new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao efetuar o login","");
						FacesContext.getCurrentInstance().addMessage(null,errorMessage);
				}
				return null;
			}
			
			@URLAction(mappingId = "logout", onPostback = false)
			public void invalidarSessao() {
				System.out.println("Efetuando o logout do usuario");

				if (getSession() != null) {
					getSession().invalidate();
				}
				
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(URL);
				} catch (IOException e) {
					e.printStackTrace();
				}



			}
		
			public Usuario getUsuarioAutenticado() {
				return (Usuario) getSession().getAttribute(USUARIO_AUTENTICADO);
			}
			
			public boolean isAutenticado(){
				return getUsuarioAutenticado()!=null;
			}

			public Usuario obterUsuarioPorLogin(String login){
				Usuario usuarioBase = new Usuario();
				EntityManager manager = JPAUtil.getEntityManager();
				manager.getTransaction().begin();
				Query query = manager.createQuery("select * from usuario where login like ':login'",Usuario.class).setParameter("login", login);
				List<Usuario> resultado = query.getResultList();
				
				for (Usuario usuarioBase1:resultado) {
					usuarioBase.setCodUsuario(usuarioBase1.getCodUsuario());
					usuarioBase.setLogin(usuarioBase1.getLogin());
					usuarioBase.setNome(usuarioBase1.getNome());
					usuarioBase.setSenha(usuarioBase1.getSenha());
					usuarioBase.setTipoUsuario(usuarioBase1.getTipoUsuario());
				}
				return usuarioBase;
			}
			
}
