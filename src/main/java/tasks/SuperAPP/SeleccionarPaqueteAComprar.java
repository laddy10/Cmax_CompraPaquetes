package tasks.SuperAPP;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.*;
import interactions.scroll.Scroll;
import interactions.scroll.ScrollAndClick;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;


public class SeleccionarPaqueteAComprar extends AndroidObject implements Task {

    User addCredentials;

    private AppiumDriver<AndroidElement> driver;

    public SeleccionarPaqueteAComprar(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollAndClick.scrollAndClick(addCredentials.getTipoPaquete()),
                WaitFor.aTime(3000),
                ValidarTexto.validarTexto(addCredentials.getTipoPaquete()));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
    }

    public static Performable seleccionarPaqueteAComprar(User addCredentials) {
        return instrumented(SeleccionarPaqueteAComprar.class, addCredentials);
    }
}