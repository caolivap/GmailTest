package ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.gmail.com")
public class GmailPage extends PageObject {

    //Botones
    public static String btnIniciarSesion = "//nav/div/a[2]";
    public static String btnSiguienteUserName = "#identifierNext";
    public static String btnSiguientePass = "#passwordNext";
    public static String btnRedactar = "div.T-I";
    public static String btnEnviar = "[id=':oe']";

    //Usuario y contrasena
    public static String formUserName = "#identifierId";
    public static String formPass = "input[name=password]";

    //Contenido del correo electronico
    public static String destinatarioBox = "textarea[name='to']";
    public static String asuntoBox = "input[name='subjectbox']";
    public static String contenidoText = "[id=':mz']";

    //Mensaje de Envio satisfactorio de correo
    public static String mensajeEnviado = "span[class = 'bAq']";

    public void iniciarSesion() {
        if(find(By.xpath(btnIniciarSesion)) != null){
            $(btnIniciarSesion).click();
        }
    }

    public void entrarUsuario(String username) {
        $(formUserName).sendKeys(username);
        $(btnSiguienteUserName).click();
    }

    public void entrarContrasena(String pass) {
        $(formPass).sendKeys(pass);
        $(btnSiguientePass).click();
    }


    public void redactar() {
        $(btnRedactar).click();
    }

    public void destinatario(String destinatario) {
        $(destinatarioBox).sendKeys(destinatario);
    }

    public void asunto(String asunto) {
        $(asuntoBox).sendKeys(asunto);
    }

    public void contenido(String contenido) {
        $(contenidoText).sendKeys(contenido);
    }

    public void enviarCorreo() {
        $(btnEnviar).click();
    }

    public String verificarMensaje() {
        String mensaje = $(mensajeEnviado).getText();
        return mensaje;
    }
}