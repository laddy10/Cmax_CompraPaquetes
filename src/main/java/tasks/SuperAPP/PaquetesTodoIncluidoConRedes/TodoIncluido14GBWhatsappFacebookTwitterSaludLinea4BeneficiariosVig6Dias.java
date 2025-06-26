package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

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
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias
        extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.scrollUnaVista());

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Último"),
                WaitFor.aTime(3000));

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 8.500"),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(
                        "Todo Incluido 1.4GB + WhatsApp, Facebook y Twitter + Salud en Linea 4 beneficiarios por 6 Dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 8.500"));
    }

    public static Performable
    todoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias() {
        return instrumented(
                TodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias.class);
    }
}