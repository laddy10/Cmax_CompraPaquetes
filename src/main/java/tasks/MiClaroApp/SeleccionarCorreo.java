package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_CORREO;

import interactions.WaitElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarCorreo implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(WaitElement.isClickable(BTN_CORREO), Click.on(BTN_CORREO));
  }

  public static Performable seleccionarCorreo() {
    return instrumented(SeleccionarCorreo.class);
  }
}
