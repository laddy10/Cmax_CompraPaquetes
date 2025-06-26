package tasks.SuperAPP.PaquetesDeDatos;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

public class Navegacion800MBWhatsappFacebookTwitter3Dia implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                ValidarTexto.validarTexto("$ 4.500"),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(
                        "Navegación 800MB+WhatsApp, Facebook y Twitter sin descontar de la capacidad incluida, Vigencia 3 Días"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 4.500"));
    }

    public static Performable navegacion800MBWhatsappFacebookTwitter3Dia() {
        return instrumented(Navegacion800MBWhatsappFacebookTwitter3Dia.class);

    }
}