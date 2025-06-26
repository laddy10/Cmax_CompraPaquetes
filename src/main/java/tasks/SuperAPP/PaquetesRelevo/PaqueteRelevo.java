package tasks.SuperAPP.PaquetesRelevo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;

public class PaqueteRelevo extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        scrollPorCoordenadas(androidDriver(actor), 500, 1500, 500, 500); // De abajo hacia arriba (scroll up)

        ejecutarAdbTap(380, 1450);  // Simula un toque en las coordenadas

    }

    public static Performable paqueteRelevo() {
        return instrumented(PaqueteRelevo.class);
    }
}