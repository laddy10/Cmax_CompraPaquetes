package tasks.Cmax;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import utils.AdjustPageZoom;
import utils.CapturasPantallasWeb;

public class CuentasDedicadas implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(
                BTN_RESUMEN_CUENTA),
                WaitFor.aTime(1000),
                Scroll.to(BTN_CERRAR2),
                Click.on(BTN_CUENTAS_DEDICADAS));

        String titulo = "Cuentas Dedicadas";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        actor.attemptsTo(
                Scroll.to(LBL_SALDO_TOTAL),
                WaitFor.aTime(2000),
                AdjustPageZoom.to(90),
                WaitFor.aTime(1000));

        String titulo1 = "Cuentas Dedicadas";
        CapturasPantallasWeb.capturaPantalla(" ", titulo1);

        actor.attemptsTo(AdjustPageZoom.to(100), WaitFor.aTime(3000));
    }

    public static Performable cuentasDedicadas() {
        return instrumented(CuentasDedicadas.class);
    }
}