package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.AndroidObject;

public class SaldoYConsumoPaquetes extends AndroidObject implements Task {

  User addCredentials;

  public SaldoYConsumoPaquetes(User addCredentials) {
    this.addCredentials = addCredentials;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(LOGO_ESPERA_CLARO, isNotPresent()),
        Click.on(BTN_VER_MAS_PAGOS_CONSULTAS),
        ClickElementByText.clickElementByText(CONSULTAR_CONSUMOS),
        WaitFor.aTime(6000),
        ClickElementByText.clickElementByText(PREPAGO),
        WaitFor.aTime(2000));

    scrollCorto2(actor, "Línea " + addCredentials.getNumero() + " Ver detalle");

    actor.attemptsTo(
        WaitFor.aTime(2000), ClickTextoQueContengaX.elTextoContiene(addCredentials.getNumero()));
  }

  public static Performable saldoYConsumopaquetes(User addCredentials) {
    return instrumented(SaldoYConsumoPaquetes.class, addCredentials);
  }
}
