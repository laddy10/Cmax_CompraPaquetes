package tasks.SuperAPP;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_PAGAR_CON_MI_SALDO;
import static userinterfaces.SegmentoPage.LBL_COSTO_DEL_PAQUETE;
import static utils.Constants.TEXTO_COSTO_DEL__PAQUETE;

public class PagarConMiSaldo implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(8000));

        if (!Presence.of(LBL_COSTO_DEL_PAQUETE).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    ValidarTexto.validarTexto(TEXTO_COSTO_DEL__PAQUETE));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    Click.on(BTN_PAGAR_CON_MI_SALDO),
                    WaitFor.aTime(6000));
        }
    }

    public static Performable pagarConMiSaldo() {
        return instrumented(PagarConMiSaldo.class);
    }
}