package tasks.WhatsApp.Internacional;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

public class SeleccionarPqInternacional implements Task {

    User addCredentials;

    public SeleccionarPqInternacional(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_SELECCIONA_PQ_INTERNACIONAL),

               // ClickTextoQueContengaX.elTextoContiene(SELECCIONA),
                ClickTextoQueContengaX.elTextoContiene(addCredentials.getPaquete()),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene(addCredentials.getPaquete()));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        if (!Presence.of(BTN_SELECCIONA_PQ).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_SELECCIONA_PQ));
        } else if (!Presence.of(BTN_COMPRAR_ROAMING).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_COMPRAR_ROAMING),
                    WaitFor.aTime(3000));
            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
            actor.attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene(VER_PAQUETES));
        } else {
            actor.attemptsTo(
                    Click.on(BTN_SELECCIONA_PQ_INTERN));
        }
    }

    public static Performable seleccionarPqInternacional(User addCredentials) {
        return instrumented(SeleccionarPqInternacional.class, addCredentials);
    }
}