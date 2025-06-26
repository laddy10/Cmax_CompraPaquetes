package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.BTN_COMPRAR_PAQ_PREPAGO;
import static userinterfaces.WhatsAppPage.LBL_SIN_SALDO;
import static utils.Constants.*;

public class SeleccionUsaTuSaldo implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (!Presence.of(BTN_COMPRAR_PAQ_PREPAGO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Click.on(BTN_COMPRAR_PAQ_PREPAGO),
                    WaitFor.aTime(2000));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        }

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR_COMPRA),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene(SALDO2));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        List<WebElementFacade> lblsinsaldo = LBL_SIN_SALDO.resolveAllFor(actor);
        if (!lblsinsaldo.isEmpty()) {
            WordAppium.main();
        } else {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText(MEDIOS_PAGO),
                    WaitFor.aTime(2000),
                    ClickTextoQueContengaX.elTextoContiene(USA_TU_SALDO),
                    WaitFor.aTime(2000));


            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene(ENVIAR2),
                    WaitFor.aTime(6000),
                    ValidarTextoQueContengaX.elTextoContiene(ACTIVACION_PAQUETE));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    WaitFor.aTime(5000));
        }

        WordAppium.main();
    }


    public static Performable seleccionUsaTuSaldo() {
        return instrumented(SeleccionUsaTuSaldo.class);
    }
}