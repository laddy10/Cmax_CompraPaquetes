package tasks.Cmax;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturasPantallasWeb;
import utils.WordWeb;

public class AcumuladoresDeUso implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(2000),
                Click.on(BTN_ACUMULADORES_DE_USO), WaitFor.aTime(2000), Scroll.to(BTN_CERRAR2));

        String titulo = "Acumuladores De Uso 1";
        CapturasPantallasWeb.capturaPantalla("1", titulo);

        actor.attemptsTo(WaitFor.aTime(1000), Click.on(BTN_NEXT_CMAX), WaitFor.aTime(1000));

        String titulo1 = "Acumuladores De Uso 2";
        CapturasPantallasWeb.capturaPantalla("2", titulo1);

        actor.attemptsTo(WaitFor.aTime(1000), Click.on(BTN_NEXT2), WaitFor.aTime(1000));

        String titulo2 = "Acumuladores De Uso 3";
        CapturasPantallasWeb.capturaPantalla("3", titulo2);

        if (!Presence.of(BTN_NEXT2).viewedBy(actor).resolveAll().isEmpty()) {

            actor.attemptsTo(WaitFor.aTime(1000), Click.on(BTN_NEXT2), WaitFor.aTime(1000));

            String titulo3 = "Acumuladores De Uso 4";
            CapturasPantallasWeb.capturaPantalla("4", titulo3);
        }

        if (!Presence.of(BTN_NEXT2).viewedBy(actor).resolveAll().isEmpty()) {

            actor.attemptsTo(WaitFor.aTime(1000), Click.on(BTN_NEXT2), WaitFor.aTime(1000));

            String titulo4 = "Acumuladores De Uso 5";
            CapturasPantallasWeb.capturaPantalla("5", titulo4);
        }

        if (!Presence.of(BTN_NEXT2).viewedBy(actor).resolveAll().isEmpty()) {

            actor.attemptsTo(WaitFor.aTime(1000), Click.on(BTN_NEXT2), WaitFor.aTime(1000));

            String titulo5 = "Acumuladores De Uso 6";
            CapturasPantallasWeb.capturaPantalla("6", titulo5);
        }

        if (!Presence.of(BTN_NEXT2).viewedBy(actor).resolveAll().isEmpty()) {

            actor.attemptsTo(WaitFor.aTime(1000), Click.on(BTN_NEXT2), WaitFor.aTime(1000));

            String titulo6 = "Acumuladores De Uso 7";
            CapturasPantallasWeb.capturaPantalla("7", titulo6);
        }

    /*   actor.attemptsTo(
            WaitFor.aTime(1000),
            AdjustPageZoom.to(87),
            WaitFor.aTime(1000)
    );


    actor.attemptsTo(
            AdjustPageZoom.to(100)
    );*/

        WordWeb.main();
    }

    public static Performable acumuladoresDeUso() {
        return instrumented(AcumuladoresDeUso.class);
    }
}