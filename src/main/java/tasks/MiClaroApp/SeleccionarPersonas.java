package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SeleccionarPersonas implements Task {
  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(WaitUntil.the(LOADING_SPLASH, isNotPresent()), WaitFor.aTime(4000));

    if (!Presence.of(BTN_PERMISO_UBICACION).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText(MIENTRAS_APP_ESTA_EN_USO));
    } else {
      actor.attemptsTo(WaitFor.aTime(1000));
    }

    if (!Presence.of(BTN_ACEPTAR_PERMISO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText(ACEPTAR_PERMISO));
    } else {
      actor.attemptsTo(WaitFor.aTime(1000));
    }

    if (!Presence.of(SMS_PERMISO_LLAMADAS).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText(NO_PERMITIR));
    } else {
      actor.attemptsTo(WaitFor.aTime(1000));
    }

    if (!Presence.of(SMS_PERMISO_NOTIFICACIONES).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText(NO_PERMITIR));
    } else {
      actor.attemptsTo(WaitFor.aTime(1000));
    }

    if (!Presence.of(BTN_OMITIR).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText(OMITIR));
    } else {
      actor.attemptsTo(WaitFor.aTime(1000));
    }
  }

  public static Performable seleccionarPersonas() {
    return instrumented(SeleccionarPersonas.class);
  }
}
