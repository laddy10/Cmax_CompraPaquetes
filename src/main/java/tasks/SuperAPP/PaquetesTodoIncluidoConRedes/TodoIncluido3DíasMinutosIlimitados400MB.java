package tasks.SuperAPP.PaquetesTodoIncluidoConRedes;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.COMPRAR;
import static utils.Constants.VER_DETALLE_DEL_PAQUETE;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class TodoIncluido3DíasMinutosIlimitados400MB extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto("Todo incluido 3 Días con Minutos Ilimitados + 400MB"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 4.500"));
    }

    public static Performable todoIncluido3DíasMinutosIlimitados400MB() {
        return instrumented(TodoIncluido3DíasMinutosIlimitados400MB.class);
    }
}