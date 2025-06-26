package tasks.SuperAPP.PaquetesRelevo;

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

public class RelevoSMSIlimWTF25GB15Dias extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, "$ 15.500");

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        "Este paquete incluye 2,5GB de Navegacion, ilimitados de SMS + WhatsApp, Facebook , Twitter y la aplicación de Centro de Relevo durante una vigencia 15 dias."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 15.500"));
    }

    public static Performable relevoSMSIlimWTF25GB15Dias() {
        return instrumented(RelevoSMSIlimWTF25GB15Dias.class);

    }
}