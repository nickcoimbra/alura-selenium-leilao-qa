package br.com.alura.leilao.lance;

import br.org.alura.leilao.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LancesPage extends PageObject {

    private static final String URL_LANCES = "http://localhost:8080/leilao/2";

    public LancesPage() {
        super(null);
        this.browser.navigate().to(URL_LANCES);
    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().contains(URL_LANCES);
    }

    public boolean isTituloLeilaoVisivel() {
        return browser.getPageSource().contains("Dados do Leilão");
    }


}
