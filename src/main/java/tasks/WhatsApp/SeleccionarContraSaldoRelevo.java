package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

public class SeleccionarContraSaldoRelevo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene(SALDO2));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(USAR_TU_SALDO),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene(ACTIVACION_PAQUETE));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        actor.attemptsTo(
                WaitFor.aTime(5000));

        WordAppium.main();
    }


    public static Performable seleccionarContraSaldoRelevo() {
        return instrumented(SeleccionarContraSaldoRelevo.class);
    }
}