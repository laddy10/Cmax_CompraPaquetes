package tasks.SuperAPP.PaqueteVoz;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_1;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_1;

public class Paquete300Minutos1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 2.000"),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto("Paquete 300 Minutos Vig 1 dia"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_1),
                ValidarTexto.validarTexto("$ 2.000"),
                WaitFor.aTime(2000));
    }

    public static Performable paquete300Minutos1Dia() {
        return instrumented(Paquete300Minutos1Dia.class);

    }
}