package br.ufpe.cin.videolocadora.bean;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.tds.model.User;
import br.com.tds.service.UserService;

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
			
			@Inject
			private UserService userService;
	
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
					User user = userService.obterUsuarioPorLogin(login); 
					
					//armazeno as informacoes do usuario na sessao
					getSession().setAttribute(USUARIO_AUTENTICADO, user);

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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}
		
			public User getUsuarioAutenticado() {
				return (User) getSession().getAttribute(USUARIO_AUTENTICADO);
			}
			
			public boolean isAutenticado(){
				return getUsuarioAutenticado()!=null;
			}

			public String getLogin() {
				return login;
			}

			public void setLogin(String login) {
				this.login = login;
			}

			public String getSenha() {
				return senha;
			}

			public void setSenha(String senha) {
				this.senha = senha;
			}

			
}
