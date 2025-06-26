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

public class Navegacion400MBWhatsappFacebookTwitter1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, "$ 2.500");

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 2.500"),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        "Navegación 400MB+WhatsApp, Facebook y Twitter sin descontar de la capacidad incluida, Vigencia 1 dia"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 2.500"));
    }

    public static Performable navegacion400MBWhatsappFacebookTwitter1Dia() {
        return instrumented(Navegacion400MBWhatsappFacebookTwitter1Dia.class);

    }
}