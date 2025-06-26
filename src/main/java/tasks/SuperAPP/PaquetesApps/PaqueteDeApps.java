package tasks.SuperAPP.PaquetesApps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;

public class PaqueteDeApps extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        ejecutarAdbTap(376, 1413);  // Simula un toque en las coordenadas

    }

    public static Performable paqueteDeApps() {
        return instrumented(PaqueteDeApps.class);
    }
}