package tasks.USSD;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.USSDPage.BTN_ENVIAR;
import static userinterfaces.USSDPage.CJA_INGRESAR_OPCION;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.CapturaDePantallaMovil;

public class PagoCompra implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        WaitFor.aTime(4000), Enter.theValue("1").into(CJA_INGRESAR_OPCION), WaitFor.aTime(2000));
    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla_5");
    //  WordAppium.main();
    actor.attemptsTo(WaitFor.aTime(3000), Click.on(BTN_ENVIAR), WaitFor.aTime(5000));
  }

  public static Performable pagocompra() {
    return instrumented(PagoCompra.class);
  }
}
