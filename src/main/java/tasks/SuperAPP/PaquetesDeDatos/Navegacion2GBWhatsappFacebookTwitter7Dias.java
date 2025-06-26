package tasks.SuperAPP.PaquetesDeDatos;

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

public class Navegacion2GBWhatsappFacebookTwitter7Dias extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO));

        scrollCorto2(actor, "$ 7.500");

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 7.500"),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        "Navegación 2GB+WhatsApp, Facebook y Twitter sin descontar de la capacidad incluida, Vigencia 7 Dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 7.500"));
    }

    public static Performable navegacion2GBWhatsappFacebookTwitter7Dias() {
        return instrumented(Navegacion2GBWhatsappFacebookTwitter7Dias.class);

    }
}