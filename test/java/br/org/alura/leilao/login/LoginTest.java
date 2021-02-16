package br.org.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){

        this.paginaDeLogin = new LoginPage();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaDeLogin.efetuaLogin();
        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano",paginaDeLogin.getNomeUsuarioLogado());


    }
    @Test
    public void naoDeveriaEfetuarLoginComDadosInvalidos(){
        paginaDeLogin.preencheFormularioDeLogin("invalido", "123");
        paginaDeLogin.efetuaLogin();
        Assertions.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        Assertions.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        Assertions.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));

    }
    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado(){
        paginaDeLogin.navegaParaDeLances();
        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
    }

    @AfterEach
    public void afterEach(){
        this.paginaDeLogin.fechar();
    }
}
