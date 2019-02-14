package br.ufpe.cin.vimperial.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


import br.ufpe.cin.vimperial.entidades.TipoMidia;


public class TesteTipoMidia {
	String tipoMidiaPassado = "CD-ROM";
	String tipoMidiaEquivocado1 = "kk2-3jj3";
	String tipoMidiaEquivocado2 = "   ";
	

	@SuppressWarnings("deprecation")
	@Test
	public void testSetTelefone() {
		TipoMidia tipoMidia = new TipoMidia();
		tipoMidia.setTipoMidia(tipoMidiaPassado);
		tipoMidia.setTipoMidia(tipoMidiaEquivocado1);
		tipoMidia.setTipoMidia(tipoMidiaEquivocado1);
		
		Assert.assertEquals("CD-ROM", tipoMidiaPassado);
		Assert.assertEquals("CD-ROM", tipoMidiaEquivocado1);
		Assert.assertEquals("CD-ROM", tipoMidiaEquivocado2);
	}

}
