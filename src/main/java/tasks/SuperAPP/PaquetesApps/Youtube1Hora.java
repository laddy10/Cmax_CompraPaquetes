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

public class Youtube1Hora extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO));

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 3.500"),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto("Paquete de YouTube por 1 hora"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_3),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 3.500"));
    }

    public static Performable youtube1Hora() {
        return instrumented(Youtube1Hora.class);

    }
}