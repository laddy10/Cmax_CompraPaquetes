package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.CapturasPantallasWeb;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;

public class ResumenDeCuenta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_RESUMEN_CUENTA), WaitFor.aTime(1000));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_PLAN_TARIFA)));

        actor.attemptsTo(AdjustPageZoom.to(90), WaitFor.aTime(1000));

        String titulo = " Validar SC";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        actor.attemptsTo(AdjustPageZoom.to(100));
    }

    public static Performable resumenDeCuenta() {
        return instrumented(ResumenDeCuenta.class);
    }
}
