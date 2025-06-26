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

public class TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias extends AndroidObject
        implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto2(actor, "$ 5.500");

        actor.attemptsTo(
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        "Todo Incluido 400MB + WhatsApp, Facebook y Twitter + Salud en Linea 4 beneficiarios por 3 Dias"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 5.500"));
    }

    public static Performable todoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias() {
        return instrumented(TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias.class);
    }
}