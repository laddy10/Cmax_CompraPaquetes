package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import utils.CapturasPantallasWeb;
import utils.WordWeb;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;

public class ContadorUsoIniciales implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_CONTADORES_USO), WaitFor.aTime(1000));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CONTADORES_USO)));

        actor.attemptsTo(
                WaitFor.aTime(2000), AdjustPageZoom.to(85), Scroll.to(LGO_CLARO), WaitFor.aTime(1000));

        String titulo = "Consumos Navegacion aplicaciones gratuitas";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        WordWeb.main();
    }

    public static Performable contadorusoIniciales() {
        return Instrumented.instanceOf(ContadorUsoIniciales.class).withProperties();
    }
}