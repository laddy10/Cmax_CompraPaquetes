package tasks.SuperAPP.PaquetesTodoIncluido;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_1;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_1;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido7DiasMinIlim10GBNoIncluyeRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 12.000"),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(
                        "Este paquete incluye 10GB+ Minutos y SMS ilimitados todo destino, No incluye redes sociales. Vig 7 dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_1),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 12.000"));
    }

    public static Performable todoIncluido7DiasMinIlim10GBNoIncluyeRedes() {
        return instrumented(TodoIncluido7DiasMinIlim10GBNoIncluyeRedes.class);

    }
}