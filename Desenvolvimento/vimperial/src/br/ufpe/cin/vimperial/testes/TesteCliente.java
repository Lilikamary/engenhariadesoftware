package br.ufpe.cin.vimperial.testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", tags = "@ClienteTeste", 
glue = "cucumber.teste.passos", monochrome = true, dryRun = false)

public class TesteCliente {

}
