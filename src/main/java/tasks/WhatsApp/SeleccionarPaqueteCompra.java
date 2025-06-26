package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

public class SeleccionarPaqueteCompra implements Task {

    User addCredentials;

    public SeleccionarPaqueteCompra(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // BUSCA EL PAQUETE A COMPRAR
        List<WebElementFacade> paquetes = OPCIONES_PAQUETES.resolveAllFor(actor);

        for (WebElementFacade paquete : paquetes) {
            String textoPaquete = paquete.getText().toLowerCase().replaceAll("\\s+", " ").trim();
            String paqueteBuscado = addCredentials.getPaqueteComprar().toLowerCase().replaceAll("\\s+", " ").trim();

            System.out.println("Evaluando: " + textoPaquete);

            if (textoPaquete.contains(paqueteBuscado)) {
                paquete.click();

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                actor.attemptsTo(
                        WaitFor.aTime(2000),
                        ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                        WaitFor.aTime(2000),
                        ValidarTextoQueContengaX.elTextoContiene(addCredentials.getPaqueteComprar()),
                        ValidarTextoQueContengaX.elTextoContiene(addCredentials.getNombrePaquete()));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                break; // salimos del for
            }
        }
    }


    public static Performable comprarPaqueteVoz(User addCredentials) {
        return instrumented(SeleccionarPaqueteCompra.class, addCredentials);
    }
}