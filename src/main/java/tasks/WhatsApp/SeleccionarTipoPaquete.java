package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;


public class SeleccionarTipoPaquete implements Task {

    User addCredentials;

    public SeleccionarTipoPaquete(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene(COMPRA_TUS_PAQUETES));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        if (!Presence.of(BTN_ENVIAR2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_ENVIAR2));
        } else {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(ENVIAR));
        }

        actor.attemptsTo(
                WaitForResponse.withText(SELECCIONA),
                ValidarTextoQueContengaX.elTextoContiene(COMPRA_TUS_PAQUETES));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SELECCIONA),
                ClickTextoQueContengaX.elTextoContiene(addCredentials.getTipoPaquete()),
                WaitFor.aTime(3000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        if (!Presence.of(BTN_ENVIAR2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_ENVIAR2));
        } else {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(ENVIAR));
        }

        actor.attemptsTo(
                WaitFor.aTime(20000),
                ValidarTextoQueContengaX.elTextoContiene(addCredentials.getTipoPaquete()));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

    }


    public static Performable seleccionarTipoPaquete(User addCredentials) {
        return instrumented(SeleccionarTipoPaquete.class, addCredentials);
    }
}