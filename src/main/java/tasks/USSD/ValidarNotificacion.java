package tasks.USSD;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.CapturaDePantallaMovil;
import utils.UtilidadesAndroid;
import utils.WordAppium;
import utils.AndroidObject;

import static userinterfaces.USSDPage.*;
import static utils.AdbUtils.ejecutarAdbTap;
import static utils.Constants.*;

public class ValidarNotificacion extends AndroidObject implements Task {


    public static ValidarNotificacion deCompra() {
        return new ValidarNotificacion();
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        // Validar si la notificación es de saldo insuficiente o confirmación de la compra

        actor.attemptsTo(
                WaitFor.aTime(3000));

        if (!Presence.of(TXT_MENSAJE_SALDO_INSUFICIENTE).viewedBy(actor).resolveAll().isEmpty()) {
            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
            if (!Presence.of(TXT_ACEPTAR).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR2));

            } else {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR));
            }
        } else {
            actor.attemptsTo(
                    WaitElement.isEnable(TXT_MENSAJE_COMPRA_EXITOSA));
            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            if (!Presence.of(TXT_ACEPTAR).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR2));

            } else {
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(ACEPTAR));
            }
        }

        if (!Presence.of("CANCELAR").viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    ClickElementByText.clickElementByText("CANCELAR"));
        }

        WordAppium.main();

        actor.attemptsTo(
                WaitFor.aTime(25000));

        LeerMensaje(actor);

        // Ojo revisar la lectura de los mensajes ya que a Tatiana le salen diferente
        if (!Presence.of(TXT_MENSAJES).viewedBy(actor).resolveAll().isEmpty()) {

            if (!Presence.of(TXT_779).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(
                        ClickTextoQueContengaX.elTextoContiene("779"),
                        WaitFor.aTime(1000),
                        ClickTextoQueContengaX.elTextoContiene("779"),
                        ValidarTextoQueContengaX.elTextoContiene(COMPRA_EXITOSA),
                        ValidarTextoQueContengaX.elTextoContiene("clro.co/paquetes"));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                UtilidadesAndroid.abrirLinkEnNavegador("https://clro.co/paquetes");

                actor.attemptsTo(
                        WaitFor.aTime(5000),
                        ValidarTexto.validarTexto("Bienvenido"),
                        ValidarTexto.validarTexto("Ingresa tu número Claro de 10 dígitos y pulsa \"Continuar\""),
                        ValidarTexto.validarTexto("ecarrier.claro.com.co/MiClaro/login/sendsms"));
                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
                actor.attemptsTo(
                        Atras.irAtras(),
                        Atras.irAtras(),
                        WaitFor.aTime(2000));

                actor.attemptsTo(
                        ClickTextoQueContengaX.elTextoContiene("CLARO"),
                        ValidarTextoQueContengaX.elTextoContiene(INSTALACION),
                        ValidarTextoQueContengaX.elTextoContiene("www.claro.com.co"));

                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                UtilidadesAndroid.abrirLinkEnNavegador("https://www.claro.com.co");


                actor.attemptsTo(
                        WaitFor.aTime(5000),
                        ValidarTexto.validarTexto("Personas"),
                        ValidarTexto.validarTexto("Más de Claro"),
                        ValidarTexto.validarTexto("Pagos y Recargas"));
                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
                actor.attemptsTo(
                        Atras.irAtras(),
                        Atras.irAtras(),
                        Atras.irAtras(),
                        WaitFor.aTime(3000));

            } else {
                actor.attemptsTo(
                        ClickTextoQueContengaX.elTextoContiene("CLARO"),
                        WaitFor.aTime(1000),
                        ClickTextoQueContengaX.elTextoContiene("CLARO"),
                        ValidarTextoQueContengaX.elTextoContiene(INSTALACION),
                        ValidarTextoQueContengaX.elTextoContiene("www.claro.com.co"));


                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

                UtilidadesAndroid.abrirLinkEnNavegador("https://www.claro.com.co");

                actor.attemptsTo(
                        WaitFor.aTime(5000),
                        ValidarTexto.validarTexto("Personas"),
                        ValidarTexto.validarTexto("Más de Claro"),
                        ValidarTexto.validarTexto("Pagos y Recargas"));
                CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
                actor.attemptsTo(
                        Atras.irAtras(),
                        Atras.irAtras(),
                        Atras.irAtras(),
                        WaitFor.aTime(3000));
            }

        } else {
            actor.attemptsTo(WaitFor.aTime(1000));
        }

        actor.attemptsTo(
                Atras.irAtras());

        WordAppium.main();


    }
}