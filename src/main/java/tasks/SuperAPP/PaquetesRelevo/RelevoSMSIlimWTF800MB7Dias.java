package tasks.SuperAPP.PaquetesRelevo;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.COMPRAR;
import static utils.Constants.VER_DETALLE_DEL_PAQUETE;

public class RelevoSMSIlimWTF800MB7Dias extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 7.500"),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto("Este paquete incluye 800MB de Navegacion, ilimitados de SMS + WhatsApp, Facebook , Twitter y la aplicación de Centro de Relevo durante una vigencia 7 dias."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                ValidarTexto.validarTexto("$ 7.500"),
                WaitFor.aTime(2000));
    }

    public static Performable relevoSMSIlimWTF800MB7Dias() {
        return instrumented(RelevoSMSIlimWTF800MB7Dias.class);
    }

}