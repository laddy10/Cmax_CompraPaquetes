package tasks.SuperAPP.PaquetesDeDatos;

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

public class NavegacionIlim2Horas extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 5.500"),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto("Navegación ilimitada, Vigencia 2 horas"),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 5.500"));
    }

    public static Performable navegacionIlim2Horas() {
        return instrumented(NavegacionIlim2Horas.class);
    }

}