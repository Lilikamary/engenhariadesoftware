package br.ufpe.cin.videolocadora.login;

import java.security.acl.Group;

import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

public class CustomLoginModule extends UsernamePasswordLoginModule {
	
	@Override
	protected String getUsersPassword() throws LoginException {
		System.out.format("MyLoginModule: authenticating user '%s'\n",
				getUsername());
		// Lets pretend we got the password from somewhere and that it's, by a
		// chance, same as the username
		String password = super.getUsername();
		// Let's also pretend that we haven't got it in plain text but encrypted
		// (the encryption being very simple, namely capitalization)
		return password;
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		SimpleGroup group = new SimpleGroup("Roles");
		try {
			group.addMember(new SimplePrincipal("authenticated"));
		} catch (Exception e) {
			throw new LoginException("Failed to create group member for "
					+ group);
		}
		return new Group[] { group };
	}
	

}
