package tasks.SuperAPP.PaquetesTodoIncluido;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido15DiasMinIlim20GBNoIncluyeRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, "Este paquete Todo Incluido incluye 20GB, ilimitados en Minutos y SMS , Vigencia 15 dias");

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(
                        "Este paquete Todo Incluido incluye 20GB, ilimitados en Minutos y SMS , Vigencia 15 dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 22.000"));
    }

    public static Performable todoIncluido15DiasMinIlim20GBNoIncluyeRedes() {
        return instrumented(TodoIncluido15DiasMinIlim20GBNoIncluyeRedes.class);

    }
}