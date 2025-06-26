package tasks.PortalCautivo.PaquetesTodoIncluido;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;

import static userinterfaces.PortalCautivoPage.PQT_30_DIAS_MINUTOS_ILIMITADOS_18GB;


public class Paquete30DiasMinIlim18GB extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(3000));

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("30 dias con Minutos Ilimitados y 18 GB"));

     //   CapturaDePantallaUtils.tomarCapturaPantalla("captura_pantalla");


        actor.attemptsTo(
                Click.on(PQT_30_DIAS_MINUTOS_ILIMITADOS_18GB),
                WaitFor.aTime(2000));

    //    CapturaDePantallaUtils.tomarCapturaPantalla("captura_pantalla");


        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("30 DIAS CON MINUTOS ILIMITADOS Y 18 GB"),
                ValidarTexto.validarTexto("Costo: $42.000"),
                ClickTextoQueContengaX.elTextoContiene("con saldo"),
                WaitFor.aTime(2000));


    //    CapturaDePantallaUtils.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
              //  ClickTextoQueContengaX.elTextoContiene("Aceptar"),
                WaitFor.aTime(3000));

    }


    public static Performable paquete30DiasMinIlim18GB() {
        return Instrumented.instanceOf(Paquete30DiasMinIlim18GB.class).withProperties();
    }
}