package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

import java.io.IOException;

public class HomePage extends Base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String usermail, String password, String description) {
        driver.get(props.getProperty("url"));
        log.info("Navigate to Homepage");

        LandingPage landPage = new LandingPage(driver);


        LoginPage logPage = landPage.getLogin();
        logPage.getEmailField().sendKeys(usermail);
        logPage.getPasswordField().sendKeys(password);
        logPage.getLoginButton().click();
        log.info(description);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] getData() {
        // Falado em aula (errado):
        // Linhas definem quantos tipos de dados diferentes o teste deve rodar
        // Colunas definem quantos valores para cada teste

        // @ERRATA DO CURSO DO KRA FEITA POR MIM PQ ELE É UM MILHONARIO INCOMPETENTE
        // Na verdade está errado o que o curso diz, as linhas definem quantos testes
        // e as colunas definem q quantidade de dados passados por teste
        Object[][] data = new Object[2][3];

        data[0][0] = "teste1@teste.com";
        data[0][1] = "senha1";
        data[0][2] = "Primeiro Teste";

        data[1][0] = "teste1@teste.com";
        data[1][1] = "senha1";
        data[1][2] = "Segundo Teste";

        return data;
    }
}
