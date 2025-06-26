package tasks.SuperAPP.PaquetesTodoIncluido;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.AdbUtils.ejecutarAdbTap;

public class PaqueteTodoIncluido extends AndroidObject implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        ejecutarAdbTap(376, 1292);  // Simula un toque en las coordenadas

    }

    public static Performable paqueteTodoIncluido() {
        return instrumented(PaqueteTodoIncluido.class);
    }
}