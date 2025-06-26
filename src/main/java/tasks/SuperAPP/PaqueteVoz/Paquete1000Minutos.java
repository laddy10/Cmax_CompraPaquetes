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
import static userinterfaces.SegmentoPage.*;

public class Paquete1000Minutos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 16.500"),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto("Paquete 1000 Minutos Vig 20 dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 16.500"));
    }

    public static Performable paquete1000Minutos() {
        return instrumented(Paquete1000Minutos.class);

    }
}