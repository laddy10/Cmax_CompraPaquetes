package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CMAX.*;

import interactions.WaitElement;
import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.CapturasPantallasWeb;

public class ValidarOfertaConsultaContadores implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitElement.isClickable(BTN_OFERTAS),
                Click.on(BTN_OFERTAS),
                Click.on(BTN_FECHA_INICIO),
                Click.on(BTN_FECHA_INICIO2),
                WaitFor.aTime(1000),
                AdjustPageZoom.to(75),
                WaitFor.aTime(1000));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION2)));

        String titulo = " Validar ofertas";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        actor.attemptsTo(AdjustPageZoom.to(100));

    /*    if (!Presence.of(ICON_SIGUIENTE_OFERTAS).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(
                Click.on(ICON_SIGUIENTE_OFERTAS),
                WaitFor.aTime(2000),
                AdjustPageZoom.to(75),
                WaitFor.aTime(2000));


    } */

    }

    public static Performable validarofertaConsultaInicial() {
        return instrumented(ValidarOfertaConsultaContadores.class);
    }
}