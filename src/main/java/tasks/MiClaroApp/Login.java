package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class Login implements Task {

  User addCredentials;

  public Login(User addCredentials) {
    this.addCredentials = addCredentials;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitElement.isEnable(TXT_USERNAME),
        Enter.theValue(addCredentials.getEmail()).into(TXT_USERNAME),
        ClickElementByText.clickElementByText(CONTINUAR2),
        Enter.theValue(addCredentials.getPassword()).into(TXT_PASSWORD),
        ClickElementByText.clickElementByText(CONTINUAR2),
        WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()));

    if (!Presence.of(LBL_SESION_ABIERTA).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText(CONTINUAR2), WaitFor.aTime(6000));
    }

    if (!Presence.of(LBL_INGRESO_BIOMETRICO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(ClickElementByText.clickElementByText("En otro momento"));
    }

    if (!Presence.of(TXT_AUTORIZACION_VELOCIDAD).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(WaitFor.aTime(1000), ClickElementByText.clickElementByText(ACEPTAR));
    } else {
      actor.attemptsTo(WaitFor.aTime(1000));
    }
  }

  public static Performable enterCredentials(User addCredentials) {
    return instrumented(Login.class, addCredentials);
  }
}
