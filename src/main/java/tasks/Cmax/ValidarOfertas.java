package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CMAX.*;

import interactions.WaitElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.CapturasPantallasWeb;
import utils.DataDrivenExcel;

public class ValidarOfertas implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public ValidarOfertas(Map<String, String> data) {

        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitElement.isClickable(BTN_OFERTAS),
                Click.on(BTN_OFERTAS),
                Click.on(BTN_FECHA_INICIO),
                Click.on(BTN_FECHA_INICIO2),
                AdjustPageZoom.to(75));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_NUMERO_CONSULTA)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_INICIO)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_EXPIRACION2)));

        String titulo = " Validar ofertas ";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        actor.attemptsTo(AdjustPageZoom.to(100));

    /*    if (!Presence.of(ICON_SIGUIENTE_OFERTAS).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(
                Click.on(ICON_SIGUIENTE_OFERTAS),
                WaitFor.aTime(2000),
                AdjustPageZoom.to(75),
                WaitFor.aTime(2000));


    }

    if (!Presence.of(ICON_ATRAS_OFERTAS).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(
                AdjustPageZoom.to(100),
                WaitFor.aTime(2000),
                Click.on(ICON_SIGUIENTE_OFERTAS),
                WaitFor.aTime(2000));

    } */

        List<WebElementFacade> rows = TBL_OFERTAS.resolveAllFor(actor);
        System.out.println("Se encontraron " + rows.size() + " filas");

        System.out.println("Paquete buscado: " + data.get("paquete"));

        boolean paqueteEncontrado = false;

        for (WebElementFacade row : rows) {
            WebElementFacade packageNameCell = row.then(By.xpath(".//td[2]"));
            String actualPackageName = packageNameCell.getText();

            if (actualPackageName.equals(data.get("paquete"))) {
                WebElementFacade yesLink = row.then(By.xpath(".//td[6]/a"));
                actor.attemptsTo(Scroll.to(yesLink), Click.on(yesLink));

                paqueteEncontrado = true;
                break; // Si se encuentra el paquete, se realiza el clic y se sale del bucle
            }
        }

        if (!paqueteEncontrado) {
            throw new AssertionError(
                    "ERROR: No se encontro el paquete en la tabla: " + data.get("paquete"));
        }
    }

    public static Performable validarOfertas(Map<String, String> data) {
        return Instrumented.instanceOf(ValidarOfertas.class).withProperties(data);
    }
}
