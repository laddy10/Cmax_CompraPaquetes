package tasks.WhatsApp;

import interactions.WaitFor;
import interactions.comunes.*;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.WhatsAppPage.*;
import static utils.Constants.*;

public class ValidarTratamientoDatos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {


        List<WebElementFacade> lbltratamientodatos = LBL_TRATAMIENTO_DATOS.resolveAllFor(actor);
        if (!lbltratamientodatos.isEmpty()) {

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene(POLITICA_TRATAMIENTO),
                    ValidarTextoQueContengaX.elTextoContiene(URL_TRATAMIENTO_INFORMACION),
                    ValidarTextoQueContengaX.elTextoContiene(URL_PORTAL_CLARO)
                    );

            UtilidadesAndroid.abrirLinkEnNavegador(URL_TRATAMIENTO_INFORMACION);

            actor.attemptsTo(
                    WaitForResponse.withText(LEY));

            List<WebElementFacade> lblvistaprevia = LBL_VISTA_PREVIA.resolveAllFor(actor);
            if (!lblvistaprevia.isEmpty()) {

                actor.attemptsTo(
                        ClickTextoQueContengaX.elTextoContiene(URL_CLARO));
            }

            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene(LEY),
                    ValidarTextoQueContengaX.elTextoContiene(CIRCULAR_SIC));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    Atras.irAtras());

            if (!lblvistaprevia.isEmpty()) {
                actor.attemptsTo(
                        Atras.irAtras(),
                        WaitFor.aTime(2000));
            }

            UtilidadesAndroid.abrirLinkEnNavegador(URL_PORTAL_CLARO);

            actor.attemptsTo(
                    WaitForResponse.withText(PERSONAS),
                    ValidarTexto.validarTexto(PERSONAS),
                    ValidarTexto.validarTexto(MAS_DE_CLARO),
                    ValidarTexto.validarTexto(AUTOGESTION_WHATSAPP));

            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    Atras.irAtras(),
                    WaitFor.aTime(2000));

            if (!Presence.of(BTN_SI2).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(
                        Click.on(BTN_SI2));
            } else {
                actor.attemptsTo(
                        Click.on(BTN_SI));
            }


            actor.attemptsTo(
                    WaitForResponse.withAnyText(
                            VER_MENU_PREPAGO, MENU_PRINCIPAL));

            //       CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");


        } else {
            actor.attemptsTo(
                    ValidarTexto.validarTexto(MENU_PRINCIPAL));
        }

    }

    public static Performable validarTratamientoDatos() {
        return instrumented(ValidarTratamientoDatos.class);
    }
}