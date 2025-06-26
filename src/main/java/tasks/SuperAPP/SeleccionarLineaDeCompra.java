package tasks.SuperAPP;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;
import static utils.Constants.ELIGE_TIPO_PAQUETE;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;


public class SeleccionarLineaDeCompra extends AndroidObject implements Task {

    User addCredentials;

    private AppiumDriver<AndroidElement> driver;

    public SeleccionarLineaDeCompra(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(4000),
                ClickElementByText.clickElementByText(PREPAGO),
                WaitFor.aTime(3000));

        scrollCorto2(actor, "Línea " + addCredentials.getNumero() + " Elegir");

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                WaitFor.aTime(2000), ClickTextoQueContengaX.elTextoContiene(addCredentials.getNumero()));

        theActorInTheSpotlight()
                .should(
                        seeThat(
                                ValidateInformationText.validateInformationText(LBL_COMPRA_PAQUETES_RECARGAS2),
                                equalTo(COMPRA_PAQUETES_RECARGAS)));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        //Validar mini versión

        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(RECARGAS_Y_PAQUETES),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VERSION));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Atras.irAtras(),
                ClickElementByText.clickElementByText(PAQUETES),
                WaitFor.aTime(4000),
                ValidarTexto.validarTexto(ELIGE_TIPO_PAQUETE),
                ValidarTextoQueContengaX.elTextoContiene(addCredentials.getNumero()),
                WaitFor.aTime(1000));


        //Seleccionar el tipo de paquete a comprar

        actor.attemptsTo(
                WaitElement.isClickable(CBX_TIPO_PAQUETE),
                Click.on(CBX_TIPO_PAQUETE),
                WaitFor.aTime(1000));
    }

    public static Performable seleccionarLineaDeCompra(User addCredentials) {
        return instrumented(SeleccionarLineaDeCompra.class, addCredentials);
    }
}