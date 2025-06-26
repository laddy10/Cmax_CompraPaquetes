package tasks.WhatsApp.Internacional;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

public class SeleccionarUsarSaldo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (!Presence.of(BTN_COMPRAR_PAQ_PREPAGO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_COMPRAR_PAQ_PREPAGO),
                    WaitFor.aTime(2000));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        }

        if (!Presence.of(BTN_SI_COMPRAR_PAQUETE_ROAMING).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_SI_COMPRAR_PAQUETE_ROAMING),
                    ValidarTextoQueContengaX.elTextoContiene(PAQUETE_ROAMING),
                    ValidarTextoQueContengaX.elTextoContiene(ACTIVAR_ROAMING));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        } else {
            actor.attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene(CONTINUAR_COMPRA),
                    WaitFor.aTime(3000),
                    ValidarTextoQueContengaX.elTextoContiene(SALDO2));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        }


        if (!Presence.of(BTN_USAR_TU_SALDO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_USAR_TU_SALDO),
                    WaitFor.aTime(2000),
                    ValidarTextoQueContengaX.elTextoContiene(ACTIVACION_PAQUETE));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        }

        actor.attemptsTo(
                WaitFor.aTime(5000));


        WordAppium.main();
    }


    public static Performable seleccionarUsarSaldo() {
        return instrumented(SeleccionarUsarSaldo.class);
    }
}