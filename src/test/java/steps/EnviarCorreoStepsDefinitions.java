package steps;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import steps.userSteps.GmailUser;

public class EnviarCorreoStepsDefinitions {
    @Steps
    GmailUser user;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Dado("Estoy en la bandeja de entrada de Gmail con mi (.*) y (.*)")
    public void estoyEnLaBandejaDeEntradaDeGmailConMiUsernameYPass(String username, String pass) {
        user.abrirBandejaDeEntrada(username, pass);
    }

    @Cuando("Redacto un correo con (.*) (.*) y (.*)")
    public void redactoUnCorreoConDestinatarioAsuntoYContenido(String destinatario, String asunto, String contenido) {
        user.redactarCorreo(destinatario, asunto, contenido);
    }

    @Entonces("Deberia poder enviar mi correo")
    public void deberiaPoderEnviarMiCorreo() {
        user.enviarCorreo();
    }

    @Entonces("Deberia ver el mensaje de correo enviado")
    public void deberiaVerElMensajeDeCorreoEnviado() {
        user.deberiaVerMensaje();
    }
}
