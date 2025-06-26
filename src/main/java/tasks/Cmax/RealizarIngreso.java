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

public class RealizarIngreso implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public RealizarIngreso(Map<String, String> data) {
        this.data = data;
    }

    public static Performable realizarIngreso(Map<String, String> data) {
        return Instrumented.instanceOf(RealizarIngreso.class).withProperties(data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(data.get("Usuario")).into(TXT_USUARIO),
                Enter.theValue(data.get("Contrasena")).into(TXT_CONTRASENA),
                Click.on(BTN_OK),
                WaitFor.aTime(1000));
    }
}