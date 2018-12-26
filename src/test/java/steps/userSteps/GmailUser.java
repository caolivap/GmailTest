package steps.userSteps;

import net.thucydides.core.annotations.Step;
import ui.GmailPage;

public class GmailUser {
    private GmailPage gmailPage;

    public void abrirNavegador(){
        gmailPage.open();
    }
    @Step
    public void abrirBandejaDeEntrada(String username, String pass) {
        gmailPage.iniciarSesion(username);
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
    public void verMensajeEnviado() {
        gmailPage.verMensajeEnviado();
    }

    @Step
    public void cerrarSesion() {
        gmailPage.cerrarSesion();
    }

    @Step
    public void revisarCorreoRecibido(String remitente, String asunto, String contenido) {
        gmailPage.deberiaVerCorreoRecibido(remitente, asunto, contenido);
    }


}