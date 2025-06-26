package tasks.SuperAPP.PaquetesDeDatos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;

public class PaqueteDeDatos extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        ejecutarAdbTap(387, 1365);  // Simula un toque en las coordenadas

    }

    public static Performable paqueteDeDatos() {
        return instrumented(PaqueteDeDatos.class);
    }
}