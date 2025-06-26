package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_USUARIO;

import interactions.WaitElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarUsuarioContrasena implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(WaitElement.isClickable(BTN_USUARIO), Click.on(BTN_USUARIO));
  }

  public static Performable seleccionarUsuarioContrasena() {
    return instrumented(SeleccionarUsuarioContrasena.class);
  }
}
