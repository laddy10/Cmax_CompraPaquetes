package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;

public class PaqueteTodoIncluidoConRedes extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        ejecutarAdbTap(373, 1216);  // Simula un toque en las coordenadas

    }

    public static Performable PaqueteTodoIncluidoConRedes() {
        return instrumented(PaqueteTodoIncluidoConRedes.class);
    }
}
