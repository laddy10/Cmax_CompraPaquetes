package tasks.SuperAPP;

import static userinterfaces.USSDPage.TXT_CLARO;
import static userinterfaces.WhatsAppPage.LBL_PAQUETE_INSTALADO;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;
import utils.WordAppium;

import java.util.List;

public class ValidarNotificacion extends AndroidObject implements Task {

    public static ValidarNotificacion deCompra() {
        return new ValidarNotificacion();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto("Operación exitosa."),
                WaitFor.aTime(3000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText("Cerrar"));

        WordAppium.main();

        actor.attemptsTo(
                WaitFor.aTime(20000));

        LeerMensaje(actor);

        if (!Presence.of(TXT_CLARO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    WaitFor.aTime(1000),
                    ClickElementByText.clickElementByText("CLARO"),
                    WaitFor.aTime(1000));

         //   CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            List<WebElementFacade> lblpaqueteinstalado = LBL_PAQUETE_INSTALADO.resolveAllFor(actor);

            if (!lblpaqueteinstalado.isEmpty()) {
                actor.attemptsTo(
                        ValidarTextoQueContengaX.elTextoContiene(INSTALACION),
                        ValidarTextoQueContengaX.elTextoContiene("www.claro.com.co"));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                UtilidadesAndroid.abrirLinkEnNavegador("https://www.claro.com.co");

                actor.attemptsTo(
                        WaitFor.aTime(6000),
                        ValidarTexto.validarTexto("Personas"),
                        ValidarTexto.validarTexto("Más de Claro"),
                        ValidarTexto.validarTexto("Pagos y Recargas"));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                actor.attemptsTo(
                        Atras.irAtras());

            } else {
                actor.attemptsTo(
                        ValidarTextoQueContengaX.elTextoContiene(COMPRASTE_PAQUETE));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
            }

        } else {
            actor.attemptsTo(WaitFor.aTime(1000));
        }

        actor.attemptsTo(
                Atras.irAtras(),
                Atras.irAtras());

        WordAppium.main();
    }
}