package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.ULTIMO;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class Instagram1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO));

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 3.000"),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto("Paquete de Instagram 1 Día"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 3.000"));
    }

    public static Performable instagram1Dia() {
        return instrumented(Instagram1Dia.class);

    }
}