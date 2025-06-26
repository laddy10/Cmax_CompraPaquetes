package tasks.PortalCautivo;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Presence;

import static userinterfaces.PortalCautivoPage.*;

public class IngresoPortalCautivo implements Task {


    public static Performable ingresoPortalCautivo() {
        return Instrumented.instanceOf(IngresoPortalCautivo.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!Presence.of(BARRA_NAVEGACION).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BARRA_NAVEGACION),
                    Enter.theValue("https://ecarrier.claro.com.co/MiClaro/login/sendsms").into(BARRA_NAVEGACION),
                    ClickTextoQueContengaX.elTextoContiene("https://ecarrier.claro.com.co/MiClaro/login/sendsms"),
                    WaitFor.aTime(5000)
            );
        } else {

            actor.attemptsTo(
                    Click.on(BARRA_BUSQUEDA),
                    Enter.theValue("https://ecarrier.claro.com.co/MiClaro/login/sendsms").into(BARRA_NAVEGACION),
                    ClickTextoQueContengaX.elTextoContiene("https://ecarrier.claro.com.co/MiClaro/login/sendsms"),
                    WaitFor.aTime(5000)
            );

        }
    }
}