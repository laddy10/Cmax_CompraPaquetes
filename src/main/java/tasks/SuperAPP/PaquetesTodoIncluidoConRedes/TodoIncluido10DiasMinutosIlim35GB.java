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

public class TodoIncluido10DiasMinutosIlim35GB extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene("Último"),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene("Último"));

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 12.000"),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(
                        "Este paquete incluye los servicios ilimitados de Minutos y SMS todo destino + 3.5GB + WhatsApp, Twitter y Facebook sin descontar de la capacidad"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 12.000"));
    }

    public static Performable todoIncluido10DiasMinutosIlim35GB() {
        return instrumented(TodoIncluido10DiasMinutosIlim35GB.class);
    }
}