package tasks.PortalCautivo;

import interactions.WaitFor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;

import static userinterfaces.PortalCautivoPage.BTN_PAQUETES2;
import static userinterfaces.PortalCautivoPage.LBL_PAQUETES;


public class SeleccionarOpcionPaquetes extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        //  CapturaDePantallaUtils.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                WaitFor.aTime(3000));

        if (!Presence.of(BTN_PAQUETES2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_PAQUETES2));
        } else {
            actor.attemptsTo(
                    Click.on(LBL_PAQUETES));
        }
    }

    public static Performable SeleccionarOpcionPaquetes() {
        return Instrumented.instanceOf(SeleccionarOpcionPaquetes.class).withProperties();
    }
}