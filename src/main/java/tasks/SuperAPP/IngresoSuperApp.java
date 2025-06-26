package tasks.SuperAPP;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import interactions.comunes.ValidateInformationText;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static org.hamcrest.core.IsEqual.equalTo;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

public class IngresoSuperApp implements Task {

    private final User addCredentials;

    public IngresoSuperApp(User addCredentials) {
        this.addCredentials = addCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        //  Ya está logueado
        if (isVisible(actor, LBL_ENCABEZADO_USUARIO)) {
            actor.should(
                    seeThat(
                            ValidateInformationText.validateInformationText(LBL_ENCABEZADO_USUARIO),
                            equalTo(addCredentials.getNombreUsuario())
                    )
            );
            return;
        }

        // 🔐 Cuenta abierta en otro dispositivo
        if (isVisible(actor, LBL_SESION_CERRADA_POR_SEGURIDAD)) {
            clickAceptarSesion(actor);
            iniciarSesion(actor);
            validarLogin(actor);
            return;
        }

        // 😊 Mensaje de bienvenida
        if (isVisible(actor, LBL_NOS_ALEGRA_TENERTE_DE_VUELTA)) {
            iniciarSesion(actor);
            validarLogin(actor);
            return;
        }

        // 🟠 Pantalla de inicio de sesión
        if (isVisible(actor, LBL_INICIAR_SESION)) {
            actor.attemptsTo(
                    Click.on(LBL_INICIAR_SESION)
            );
            iniciarSesion(actor);
            validarLogin(actor);
            return;
        }

        // 🚦 Flujo desde cero (primera vez)
        aceptarPermisosIniciales(actor);
        loginDesdeCero(actor);
        validarLogin(actor);
    }

    private <T extends Actor> void iniciarSesion(T actor) {
        actor.attemptsTo(
                ClickElementByText.clickElementByText(CONTINUAR),
                Enter.theValue(addCredentials.getPassword()).into(TXT_PASSWORD),
                ClickElementByText.clickElementByText(CONTINUAR2),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );
    }

    private <T extends Actor> void clickAceptarSesion(T actor) {
        if (isVisible(actor, BTN_ACEPTAR)) {
            actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(ACEPTAR));
        } else {
            actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(ACEPTARMC2));
        }
    }

    private <T extends Actor> void aceptarPermisosIniciales(T actor) {
        clickSiExiste(actor, BTN_PERMISO_UBICACION, MIENTRAS_APP_ESTA_EN_USO);
        clickSiExiste(actor, BTN_ACEPTAR_PERMISO, ACEPTAR_PERMISO);
        clickSiExiste(actor, SMS_PERMISO_LLAMADAS, NO_PERMITIR);
        clickSiExiste(actor, SMS_PERMISO_NOTIFICACIONES, NO_PERMITIR);
        clickSiExiste(actor, BTN_OMITIR, OMITIR);
    }

    private <T extends Actor> void loginDesdeCero(T actor) {
        actor.attemptsTo(
                ClickElementByText.clickElementByText(OTROS_METODOS_DE_INGRESO),
                ClickElementByText.clickElementByText(CORREO_ELECTRONICO),
                WaitElement.isEnable(TXT_USERNAME),
                Enter.theValue(addCredentials.getEmail()).into(TXT_USERNAME),
                ClickElementByText.clickElementByText(CONTINUAR2),
                Enter.theValue(addCredentials.getPassword()).into(TXT_PASSWORD),
                ClickElementByText.clickElementByText(CONTINUAR2),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );
    }

    private <T extends Actor> void validarLogin(T actor) {
        if (isVisible(actor, LBL_TERMINOS_Y_CONDICIONES)) {
            actor.attemptsTo(
                    Click.on(CHECK_TERMINOS_Y_CONDICIONES),
                    ClickElementByText.clickElementByText(CONTINUAR)
            );
        } else {
            actor.attemptsTo(WaitFor.aTime(1000));
        }

        if (isVisible(actor, LBL_SESION_ABIERTA)) {
            actor.attemptsTo(ClickElementByText.clickElementByText(CONTINUAR2), WaitFor.aTime(6000));
        }

        if (isVisible(actor, LBL_INGRESO_BIOMETRICO)) {
            actor.attemptsTo(ClickElementByText.clickElementByText("En otro momento"));
        }

        if (isVisible(actor, TXT_AUTORIZACION_VELOCIDAD)) {
            actor.attemptsTo(WaitFor.aTime(1000), ClickElementByText.clickElementByText(ACEPTAR));
        } else {
            actor.attemptsTo(WaitFor.aTime(1000));
        }

        actor.should(
                seeThat(
                        ValidateInformationText.validateInformationText(LBL_ENCABEZADO_USUARIO),
                        equalTo(addCredentials.getNombreUsuario())
                )
        );
    }

    private <T extends Actor> boolean isVisible(T actor, net.serenitybdd.screenplay.targets.Target element) {
        return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
    }

    private <T extends Actor> void clickSiExiste(T actor, net.serenitybdd.screenplay.targets.Target elemento, String texto) {
        if (isVisible(actor, elemento)) {
            actor.attemptsTo(ClickElementByText.clickElementByText(texto));
        } else {
            actor.attemptsTo(WaitFor.aTime(1000));
        }
    }

    public static Performable ingresoSuperApp(User addCredentials) {
        return instrumented(IngresoSuperApp.class, addCredentials);
    }
}
