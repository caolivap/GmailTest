package steps.userSteps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import ui.GmailPage;

public class GmailUser {
    private GmailPage gmailPage;

    @Step
    public void abrirBandejaDeEntrada(String username, String pass) {
        gmailPage.open();
        gmailPage.iniciarSesion();
        gmailPage.entrarUsuario(username);
        gmailPage.entrarContrasena(pass);
    }

    @Step
    public void redactarCorreo(String destinatario, String asunto, String contenido) {
        gmailPage.redactar();
        gmailPage.destinatario(destinatario);
        gmailPage.asunto(asunto);
        gmailPage.contenido(contenido);
    }

    @Step
    public void enviarCorreo() {
        gmailPage.enviarCorreo();
    }

    @Step
    public void deberiaVerMensaje() {
        String mensaje = gmailPage.verificarMensaje();
        Assert.assertEquals(mensaje, "Mensaje enviado.");
    }
}