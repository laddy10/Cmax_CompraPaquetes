package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.WaitForResponse;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_VER_MENU_PREPAGO;
import static utils.Constants.*;


public class SeleccionarLineaConsulta implements Task {

    User addCredentials;

    public SeleccionarLineaConsulta(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarNumero.porUltimos4(addCredentials.getNumero()),
                WaitForResponse.withAnyText(
                        POLITICA_TRATAMIENTO,MENU_PRINCIPAL, VER_MENU_PREPAGO));

        List<WebElementFacade> btnvermenuprepago = BTN_VER_MENU_PREPAGO.resolveAllFor(actor);
        if (!btnvermenuprepago.isEmpty()) {

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    ClickElementByText.clickElementByText(VER_MENU_PREPAGO),
                    WaitFor.aTime(3000));
        }
    }

    public static Performable seleccionarLineaConsulta(User addCredentials) {
        return instrumented(SeleccionarLineaConsulta.class, addCredentials);
    }
}