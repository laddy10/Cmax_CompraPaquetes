package tasks.MiClaroApp;

import static exceptions.Excepciones.androidDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

import interactions.WaitFor;
import interactions.comunes.Atras;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.scroll.ScrollVertical;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;

public class SaldosYConsumosPaquetes implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitFor.aTime(6000),
        ValidarTexto.validarTexto(DETALLE_DE_CONSUMOS),
        ScrollVertical.scrollVertical(RECARGA),
        ValidarTextoQueContengaX.elTextoContiene(RECARGA),
        ValidarTextoQueContengaX.elTextoContiene(PAQUETES),
        ValidarTextoQueContengaX.elTextoContiene(CONSUMOS_DEL_MES),
        ValidarTexto.validarTexto(SALDO_DISPONIBLE));
    CapturaDePantallaMovil.tomarCapturaPantalla("");
    actor.attemptsTo(Atras.irAtras());

    if (!Presence.of(TXT_CUENTANOS_COMO_FUE_TU_EXPERIENCIA)
        .viewedBy(actor)
        .resolveAll()
        .isEmpty()) {
      actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene("Omitir"), WaitFor.aTime(1000));
    }

    if (!Presence.of(TXT_TE_GUSTARIA_CALIFICAR_MI_CLARO_APP)
        .viewedBy(actor)
        .resolveAll()
        .isEmpty()) {
      androidDriver(actor).findElementByAndroidUIAutomator("new UiSelector().text(\"No\")").click();
    }

    actor.attemptsTo(Atras.irAtras());
  }

  public static Performable verificarSaldoConsumoPaquetesCorrectos() {

    return instrumented(SaldosYConsumosPaquetes.class);
  }
}
