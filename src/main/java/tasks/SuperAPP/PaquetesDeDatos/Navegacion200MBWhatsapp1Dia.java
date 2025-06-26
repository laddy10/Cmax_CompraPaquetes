package tasks.SuperAPP.PaquetesDeDatos;

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

public class Navegacion200MBWhatsapp1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 1.500"),
                Click.on(LBL_VER_DETALLE_1),
                ValidarTexto.validarTexto(
                        "Navegación 200MB +WhatsApp sin descontar de la capacidad incluida, vigencia 1 dia."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 1.500"));
    }

    public static Performable navegacion200MBWhatsapp1Dia() {
        return instrumented(Navegacion200MBWhatsapp1Dia.class);
    }

}