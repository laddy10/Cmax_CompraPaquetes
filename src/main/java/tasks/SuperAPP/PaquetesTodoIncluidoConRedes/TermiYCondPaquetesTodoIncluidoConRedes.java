package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import interactions.WaitFor;
import interactions.comunes.Atras;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;
import static utils.Constants.COMPRA_DE_PAQUETES_Y_RECARGAS;
import static utils.Constants.TERMINOS_CONDICIONES_MI_CLARO;

public class TermiYCondPaquetesTodoIncluidoConRedes extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(2000));

        //Seleccionar texto de terminos y condiciones
        ejecutarAdbTap(401, 872);  // Simula un toque en las coordenadas

        actor.attemptsTo(
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene(TERMINOS_CONDICIONES_MI_CLARO),
                ValidarTextoQueContengaX.elTextoContiene(COMPRA_DE_PAQUETES_Y_RECARGAS));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Atras.irAtras(),
                WaitFor.aTime(2000));

        //Seleccionar check de terminos y condiciones y boton pagar
        ejecutarAdbTap(208, 875);  // Simula un toque en las coordenadas

        actor.attemptsTo(
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        //Dar click boton pagar
        ejecutarAdbTap(367, 977);  // Simula un toque en las coordenadas

        actor.attemptsTo(
                WaitFor.aTime(13000));
    }

    public static Performable termiYCondPaquetesTodoIncluidoConRedes() {
        return instrumented(TermiYCondPaquetesTodoIncluidoConRedes.class);
    }
}