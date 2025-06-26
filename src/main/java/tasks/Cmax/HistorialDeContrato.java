package tasks.Cmax;

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
import utils.DataDrivenExcel;

public class HistorialDeContrato implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();

    Map<String, String> data = new HashMap<String, String>();

    public HistorialDeContrato(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(3000),
                Click.on(BTN_HISTORIAL_CONTRATO),
                Enter.theValue(data.get("Fecha")).into(TXT_FECHA),
                Enter.theValue(data.get("Fecha")).into(TXT_FECHA2),
                Click.on(TXT_AJUSTE),
                Click.on(BTN_BUSCAR),
                Click.on(BTN_IMPORTE),
                Click.on(BTN_IMPORTE2));
    }

    public static Performable historialDeContrato(Map<String, String> data) {
        return Instrumented.instanceOf(HistorialDeContrato.class).withProperties(data);
    }
}
