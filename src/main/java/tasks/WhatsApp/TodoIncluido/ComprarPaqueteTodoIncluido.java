package tasks.WhatsApp.TodoIncluido;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.ENVIAR2;

public class ComprarPaqueteTodoIncluido implements Task {

    User addCredentials;

    public ComprarPaqueteTodoIncluido(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean paqueteEncontrado = false;

        actor.attemptsTo(
                Click.on(BTN_SELECCIONA),
                WaitFor.aTime(2000));

        // BUSCA EL PAQUETE A COMPRAR
        while (!paqueteEncontrado) {

            List<WebElementFacade> paquetes = OPCIONES_PAQUETES.resolveAllFor(actor);

            for (WebElementFacade paquete : paquetes) {
                String textoPaquete = paquete.getText().toLowerCase().replaceAll("\\s+", " ").trim();
                String paqueteBuscado = addCredentials.getPaqueteComprar().toLowerCase().replaceAll("\\s+", " ").trim();

                System.out.println("Evaluando: " + textoPaquete);

                if (textoPaquete.contains(paqueteBuscado)) {
                    //   paquete.click();

                    actor.attemptsTo(
                            ClickElementByText.clickElementByText(addCredentials.getNombrePaquete()));

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                    actor.attemptsTo(
                            WaitFor.aTime(2000),
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            WaitFor.aTime(2000),
                            ValidarTextoQueContengaX.elTextoContiene(addCredentials.getPaqueteComprar()),
                            ValidarTextoQueContengaX.elTextoContiene(addCredentials.getNombrePaquete()));

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


                    paqueteEncontrado = true;
                    break; // salimos del for
                }
            }

            // 🔁 Si no se encontró, intentamos mostrar más paquetes
            if (!paqueteEncontrado) {
                if (!Presence.of(BTN_VER_MAS_PAQUETES).viewedBy(actor).resolveAll().isEmpty()
                        && BTN_VER_MAS_PAQUETES.resolveFor(actor).isVisible()) {

                    actor.attemptsTo(
                            Click.on(BTN_VER_MAS_PAQUETES),
                            WaitFor.aTime(2000)
                    );

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                    actor.attemptsTo(
                            ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                            WaitFor.aTime(2000));

                    CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                    actor.attemptsTo(
                            Click.on(BTN_SELECCIONA2),
                            WaitFor.aTime(2000));

                    continue;
                } else {
                    // No hay más paquetes para mostrar
                    throw new RuntimeException("Paquete no encontrado: " + addCredentials.getPaqueteComprar());
                }
            }
        }
    }


    public static Performable comprarPaqueteTodoIncluido(User addCredentials) {
        return instrumented(ComprarPaqueteTodoIncluido.class, addCredentials);
    }
}