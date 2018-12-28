package steps;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.userSteps.GmailUser;

public class EnviarCorreoStepsDefinitions {
    @Steps
    GmailUser user;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Dado("Estoy en la bandeja de entrada de Gmail con usuario (.*) y contrasena (.*)")
    public void estoyEnLaBandejaDeEntradaDeGmailConMiUsernameYPass(String username, String pass) throws Exception{
        user.abrirNavegador();
        user.abrirBandejaDeEntrada(username, pass);
    }

    @Cuando("^Redacto un correo para (.*) con asunto (.*) y contenido (.*)$")
    public void redactoUnCorreoParaDestinatarioConAsuntoAsuntoYContenidoContenido(String destinatario, String asunto, String contenido) {
        user.redactarCorreo(destinatario, asunto, contenido);
    }

    @Entonces("^Deberia poder enviar mi correo$")
    public void deberiaPoderEnviarMiCorreo() {
        user.enviarCorreo();
        user.verMensajeEnviado();
        user.cerrarSesion();
    }

    @Entonces("^Deberia poder ver en la cuenta (.*) con pass (.*) el correo con remitente (.*) asunto (.*) y contenido (.*)$")
    public void deberiaPoderVerEnLaCuentaDestinatarioElCorreoRecibido(String nameuser, String passDestino, String remitente,
                                                                      String asunto, String contenido) {
        driver.quit();
        user.abrirNavegador();
        //driver.switchTo().alert().accept();
        user.abrirBandejaDeEntrada(nameuser, passDestino);
        user.revisarCorreoRecibido(remitente, asunto, contenido);
    }
}
