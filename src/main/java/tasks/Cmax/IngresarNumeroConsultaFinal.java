package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;

import java.util.HashMap;
import java.util.Map;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.CapturasPantallasWeb;
import utils.DataDrivenExcel;

public class IngresarNumeroConsultaFinal implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public IngresarNumeroConsultaFinal(Map<String, String> data) {
        this.data = data;
    }

    public static Performable ingresarNumeroConsultaInicial(Map<String, String> data) {
        return Instrumented.instanceOf(IngresarNumeroConsultaFinal.class).withProperties(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_CLIENTES),
                Click.on(BTN_BUSCAR_CLIENTE),
                Enter.theValue(data.get("Numero")).into(TXT_MSISDN),
                Click.on(BTN_BUSCAR),
                Click.on(TXT_MSISDN_BUSCADO),
                WaitFor.aTime(1000));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));

        actor.attemptsTo(AdjustPageZoom.to(90), WaitFor.aTime(1000));

        String titulo = " Estado final de la linea";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        actor.attemptsTo(AdjustPageZoom.to(100));
    }
}
