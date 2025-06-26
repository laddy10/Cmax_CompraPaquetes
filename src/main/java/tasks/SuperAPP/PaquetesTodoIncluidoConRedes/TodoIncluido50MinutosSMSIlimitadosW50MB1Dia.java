package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido50MinutosSMSIlimitadosW50MB1Dia extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, "$ 2.500");

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto("Todo Incluido 50 minutos + SMS Ilimitados + W + 50 MB 1 Dia"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 2.500"));
    }

    public static Performable todoIncluido50MinutosSMSIlimitadosW50MB1Dia() {
        return instrumented(TodoIncluido50MinutosSMSIlimitadosW50MB1Dia.class);
    }
}