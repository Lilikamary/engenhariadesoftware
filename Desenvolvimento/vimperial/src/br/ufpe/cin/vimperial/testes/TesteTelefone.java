package br.ufpe.cin.vimperial.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.ufpe.cin.vimperial.entidades.Telefone;


public class TesteTelefone {
	String telefonePassado = "3666-1712";
	String telefoneEquivocado = "kk2-3jj3";
	

	@SuppressWarnings("deprecation")
	@Test
	public void testSetTelefone() {
		Telefone telefone = new Telefone();
		telefone.setTelefone(telefonePassado);
		telefone.setTelefone(telefoneEquivocado);
		
		Assert.assertEquals("3666-1712", telefonePassado);
		Assert.assertEquals("3666-1712", telefoneEquivocado);
	}

}
