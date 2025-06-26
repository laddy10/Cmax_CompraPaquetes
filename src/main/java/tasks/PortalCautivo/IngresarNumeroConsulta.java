package tasks.PortalCautivo;

import interactions.WaitFor;
import interactions.comunes.Atras;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import utils.AndroidObject;
import utils.DataDrivenExcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.PortalCautivoPage.*;
import static utils.Constants.SMS_CODIGO_OTP;

public class IngresarNumeroConsulta extends AndroidObject implements Task {


    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public IngresarNumeroConsulta(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(6000));

        if (!Presence.of(TXT_NUMERO_CLARO2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(data.get("numero")).into(TXT_NUMERO_CLARO2));

        } else if (!Presence.of(TXT_NUMERO_CLARO3).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(
                    Enter.theValue(data.get("numero")).into(TXT_NUMERO_CLARO3));
        } else {
            actor.attemptsTo(
                    Enter.theValue(data.get("numero")).into(TXT_NUMERO_CLARO4));
        }

        actor.attemptsTo(
                Click.on(BTN_CONTINUAR2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto(SMS_CODIGO_OTP),
                ValidarTextoQueContengaX.elTextoContiene(data.get("numero")),
                Click.on(BTN_ACEPTAR2),
                WaitFor.aTime(10000)
        );


        ArrayList<Character> lista = LeerMensaje(actor);


        // Paso 1: Digitar número a número (opcional)
        for (Character digito : lista) {
            DigitarNumeros(actor, digito.toString());
            actor.attemptsTo(WaitFor.aTime(300));  // Pausa entre dígitos si se digita físicamente
        }

        // Paso 2: Construir el código como texto
        StringBuilder codigoVerificacion = new StringBuilder();
        for (Character c : lista) {
            codigoVerificacion.append(c);
        }

      //  System.out.println("✅ Código detectado: " + codigoVerificacion);


     /*   if (!Presence.of(TXT_LEIDO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(Click.on(TXT_LEIDO));
        } else if (!Presence.of(TXT_MARCAR_COMO_LEIDO_2).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(Click.on(TXT_MARCAR_COMO_LEIDO_2));
        } else if (!Presence.of(TXT_MARCAR_COMO_LEIDO).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(Click.on(TXT_MARCAR_COMO_LEIDO));

        }*/

        actor.attemptsTo(Atras.irAtras());

        if (!Presence.of(TXT_RECHAZAR).viewedBy(actor).resolveAll().isEmpty()) {
            actor.attemptsTo(Click.on(TXT_RECHAZAR)
            );
        }

        // Paso 3: Esperar el campo de texto y escribir el código completo
        By campoCodigo = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.EditText");

        actor.attemptsTo(
                WaitUntil.the(campoCodigo, isVisible()).forNoMoreThan(10).seconds()
        );

        try {
            actor.attemptsTo(
                    Enter.theValue(codigoVerificacion.toString()).into(campoCodigo),
                    ClickTextoQueContengaX.elTextoContiene("Validar"),
                    WaitFor.aTime(6000)
            );
        } catch (Exception e) {
            System.out.println("❌ Error al ingresar el código de verificación: " + e.getMessage());
        }
    }

    public static Performable ingresarNumeroConsulta(Map<String, String> data) {
        return Instrumented.instanceOf(IngresarNumeroConsulta.class).withProperties(data);
    }
}