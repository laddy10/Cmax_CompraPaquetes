package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;

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

public class TodoIncluido7DiasMinutosIlim2GB extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.scrollUnaVista());

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Último"),
                WaitFor.aTime(3000));

        scrollCorto2(actor, "2 GB");

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        "Este paquete incluye los servicios ilimitados de Minutos y SMS todo destino + 2GB + WhatsApp, Twitter y Facebook sin descontar de la capacidad incluida, Vigencia 7 dias."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 8.500"));
    }

    public static Performable todoIncluido7DiasMinutosIlim2GB() {
        return instrumented(TodoIncluido7DiasMinutosIlim2GB.class);
    }
}