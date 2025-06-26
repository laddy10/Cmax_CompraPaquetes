package tasks.SuperAPP;

import interactions.WaitFor;
import interactions.comunes.*;
import interactions.scroll.Scroll;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Presence;
import utils.AndroidObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;


public class ValidarPaqueteSeleccionado extends AndroidObject implements Task {

    User addCredentials;

    private AppiumDriver<AndroidElement> driver;

    public ValidarPaqueteSeleccionado(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto(addCredentials.getTipoPaquete()));


    }

    public static Performable seleccionarLineaDeCompra(User addCredentials) {
        return instrumented(ValidarPaqueteSeleccionado.class, addCredentials);
    }
}