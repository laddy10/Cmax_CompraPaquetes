package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForResponse;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.WhatsAppPage.*;
import static userinterfaces.WhatsAppPage.LBL_PAQUETE_ACTIVO;
import static utils.Constants.*;


public class ConsultarSaldoLinea implements Task {

    User addCredentials;

    public ConsultarSaldoLinea(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(2000));

        List<WebElementFacade> btnvermenuprepago = BTN_VER_MENU_PREPAGO.resolveAllFor(actor);
        if (!btnvermenuprepago.isEmpty()) {

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    ClickElementByText.clickElementByText(VER_MENU_PREPAGO),
                    WaitFor.aTime(3000));
        } else {
            actor.attemptsTo(
                    WaitFor.aTime(1000));

        }

        List<WebElementFacade> lblpaqueteactivo = LBL_PAQUETE_ACTIVO.resolveAllFor(actor);
        if (!lblpaqueteactivo.isEmpty()) {
            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene("Actualmente tienes activo"),
                    ValidarTextoQueContengaX.elTextoContiene("vigente"));
        } else {

            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene(addCredentials.getNumero()),
                    ValidarTextoQueContengaX.elTextoContiene(SALDO_NUMERO),
                    WaitFor.aTime(2000));
        }

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        theActorInTheSpotlight().attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(MENU_PRINCIPAL),
                WaitForResponse.withText(COMPRA_TUS_PAQUETES));

    }

    public static Performable consultarSaldoLinea(User addCredentials) {
        return instrumented(ConsultarSaldoLinea.class, addCredentials);
    }
}