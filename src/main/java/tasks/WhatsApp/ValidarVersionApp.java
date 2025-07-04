package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.*;
import interactions.scroll.ScrollAndClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_MENU_ITEM;
import static utils.Constants.*;

public class ValidarVersionApp implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_MENU_ITEM),
                ClickElementByText.clickElementByText(AJUSTES),
                ScrollAndClick.scrollAndClick(AYUDA),
                ClickTextoQueContengaX.elTextoContiene(INFO_APP),
                WaitForResponse.withText(WHATSAPP));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(WHATSAPP),
                ValidarTextoQueContengaX.elTextoContiene(VERSION_WHATSAPP),
                ValidarTextoQueContengaX.elTextoContiene(LICENCIAS),
                Atras.irAtras(),
                Atras.irAtras(),
                Atras.irAtras()
        );
    }

    public static Performable validarVersionApp() {
        return instrumented(ValidarVersionApp.class);
    }
}