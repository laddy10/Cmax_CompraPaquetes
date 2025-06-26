package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ValidarTextoQueContengaX;
import interactions.comunes.WaitForResponse;
import interactions.scroll.Scroll;
import interactions.scroll.ScrollInicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_ENVIAR;
import static userinterfaces.WhatsAppPage.TXT_ENVIAR_MENSAJE;
import static utils.Constants.HOLA;
import static utils.Constants.SALUDO;

public class IniciarChatClaro implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(HOLA).into(TXT_ENVIAR_MENSAJE),
                Click.on(BTN_ENVIAR),
                WaitForResponse.withText(SALUDO),
                ScrollInicio.scrollUnaVista(),
                ValidarTextoQueContengaX.elTextoContiene(SALUDO));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Scroll.scrollUnaVista());

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

    }

    public static Performable iniciarChatClaro() {
        return instrumented(IniciarChatClaro.class);
    }
}