package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//@DefaultUrl("https://www.gmail.com")
@DefaultUrl("https://www.google.com/intl/es-419/gmail/about")
public class GmailPage extends PageObject {

    //Botones
    public static String btnIniciarSesion = ".gmail-nav__nav-links-wrap>.gmail-nav__nav-link.gmail-nav__nav-link__sign-in";
    public static String btnSiguienteUserName = "#identifierNext";
    public static String BtnSiguientePass = "div#passwordNext";//".qhFLie [id='passwordNext'] .CwaK9";
    public static String btnRedactar = "div.z0>[role = button]";
    public static String btnEnviar = "div.J-J5-Ji.btA>[role=button]";

    //Usuario y contrasena
    public static String formUserName = "#identifierId";
    public static String formPass = ".Xb9hP input[name = 'password']";

    //Contenido del correo electronico
    public static String destinatarioBox = "div.wO.nr.l1>[name = to]";
    public static String asuntoBox = "div.aoD.az6>[name=subjectbox]";
    public static String contenidoText = "div.Ar.Au>[role=textbox]";

    //Links Cerrar Sesión
    public static String linkCuenta = ".gb_b.gb_hb.gb_R";
    public static String linkCerrarSesion = ".gb_Aa.gb_qg.gb_xg.gb_9e.gb_Mb";
    public static String linkCambiarCuenta = "div.aCayab>[role=link]";
    public static String linkUsarOtraCuenta = ".TnvOCe.k6Zj8d.XraQ3b.bLzI3e>.vdE7Oc.f3GIQ";

    //Mensaje de Envio satisfactorio de correo
    public static String linkVerMensaje = ".vh [id='link_vsm']";

    //Bandeja de Recibidos
    public static String correosBandejaEntrada = "table[class='F cf zt'] tr";
    public static String etiquetaRemitente = ".yX.xY>.yW>.bA4>span";
    public static String etiquetaAsunto = ".y6>.bog";
    public static String mostrarAntiguos = ".adx";

    //Dentro del cuerpo de un correo
    public static String correosAntiguos = ".nH[role='list'] [role='listitem']";
    public static String btnMas = ".T-I.J-J5-Ji.T-I-Js-Gs.aap.T-I-awG.T-I-ax7.L3";
    public static String mostrarOriginal = "[id='so'] .cj";

    //En la pestaña Mostrar Original
    public static String idMensaje = ".message_id";

    //Id de Mensaje Enviado
    public static String idCorreoEnviado;


    public void iniciarSesion(String username){
        if($(btnIniciarSesion).isCurrentlyVisible()){
            $(btnIniciarSesion).click();
        }
        if($(formUserName).isCurrentlyVisible()){
            entrarUsuario(username);
        }else {
            $(linkUsarOtraCuenta).click();
            entrarUsuario(username);
        }
    }

    public void entrarUsuario(String username) {
        $(formUserName).sendKeys(username);
        $(btnSiguienteUserName).click();
    }

    public void entrarContrasena(String pass) {
        $(formPass).sendKeys(pass);
        $(formPass).sendKeys(Keys.ENTER);
        /*withTimeoutOf(3,SECONDS);
        $(BtnSiguientePass).click();*/
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

    public void cerrarSesion(){
        $(linkCuenta).click();
        $(linkCerrarSesion).click();
    }


    public void verMensajeEnviado() {
        waitForPresenceOf(linkVerMensaje);
        $(linkVerMensaje).click();
        $(btnMas).click();
        $(mostrarOriginal).click();
        //Para el manejo de la nueva pestaña
        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        idCorreoEnviado = $(idMensaje).getText();
        getDriver().close(); //Cierra la pestaña
        getDriver().switchTo().window(tabs.get(0)); // Vuelve a la pestaña anterior
    }

    //Verificar correo Recibido
    public void deberiaVerCorreoRecibido(String remitente, String asunto, String contenido) {
        List<WebElementFacade> arrayTablaCorreos = new ArrayList<WebElementFacade>();
        String idCorreo;
        boolean recibido = false;
        arrayTablaCorreos.addAll(withTimeoutOf(15, SECONDS).findAll(correosBandejaEntrada));

        int size = arrayTablaCorreos.size();
        String[][] arrayRecibidos = new String[size][2];
        for(int i=0; i<size; i++){
            withTimeoutOf(3, SECONDS);
            String auxCorreo = arrayTablaCorreos.get(i).find(By.cssSelector(etiquetaRemitente)).getAttribute("email");
            if(remitente.equals(auxCorreo)){
                String auxAsunto = arrayTablaCorreos.get(i).find(By.cssSelector(etiquetaAsunto)).getText();
                if(asunto.equals(auxAsunto)){
                    arrayTablaCorreos.get(i).click();
                    if($(mostrarAntiguos).isCurrentlyVisible()){
                        $(mostrarAntiguos).click();
                    }
                    List<WebElementFacade> listaAntiguos = new ArrayList<WebElementFacade>();
                    listaAntiguos.addAll(findAll(correosAntiguos));
                    int j = listaAntiguos.size() - 1;
                    do {
                        if(!(listaAntiguos.get(j).containsElements(btnMas))){
                            listaAntiguos.get(j).click();
                        }
                        listaAntiguos.get(j).findBy(btnMas).click();
                        $(mostrarOriginal).click();
                        //Para el manejo de la nueva pestaña
                        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
                        getDriver().switchTo().window(tabs.get(1));
                        idCorreo = $(idMensaje).getText();
                        getDriver().close(); //Cierra la pestaña
                        getDriver().switchTo().window(tabs.get(0)); // Vuelve al manejador de la Bandeja de entrada
                        if(idCorreoEnviado.equals(idCorreo)){
                            recibido = true;
                            break;
                        }
                     j--;
                    }while(j>=0);
                }
            }
            if(recibido == true){ break; }
        }
        assertThat(recibido, is(true));
    }
}