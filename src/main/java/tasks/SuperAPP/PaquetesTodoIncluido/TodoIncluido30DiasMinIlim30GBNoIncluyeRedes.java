package tasks.SuperAPP.PaquetesTodoIncluido;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido30DiasMinIlim30GBNoIncluyeRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, "$ 32.000");

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto("Este paquete Todo Incluido incluye 30GB, ilimitados en Minutos y SMS , Vigencia 30 dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 32.000"));
    }

    public static Performable todoIncluido30DiasMinIlim30GBNoIncluyeRedes() {
        return instrumented(TodoIncluido30DiasMinIlim30GBNoIncluyeRedes.class);
    }
}