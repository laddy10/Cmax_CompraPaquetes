package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import utils.CapturasPantallasWeb;
import utils.WordWeb;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.DataDrivenExcel;

public class ContadorDeUsoConsumoDeDatos implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();

    public ContadorDeUsoConsumoDeDatos(Map<String, String> data) {

        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_CONTADORES_USO), WaitFor.aTime(1000));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CONTADORES_USO)));

        List<WebElementFacade> rows = TBL_CONTADORES_USO.resolveAllFor(actor);
        System.out.println("Se encontraron " + rows.size() + " filas");

        System.out.println("Paquete buscado: " + data.get("paqueteDatos"));

        boolean paqueteEncontrado = false;

        try {
            for (WebElementFacade row : rows) {
                WebElementFacade packageNameCell = row.then(By.xpath(".//td[2]"));
                String actualPackageName = packageNameCell.getText();

                //    System.out.println("Paquete encontrado en la página web: " + actualPackageName);

                if (actualPackageName.equals(data.get("paqueteDatos"))) {
                    WebElementFacade yesLink = row.then(By.xpath(".//td[5]/a"));
                    actor.attemptsTo(Scroll.to(yesLink), Click.on(yesLink), WaitFor.aTime(1000));

                    paqueteEncontrado = true;
                    break; // Si se encuentra el paquete, se realiza el clic y se sale del bucle
                }
            }

            // Si no se encontró el paquete en ninguna fila, se lanza la excepción
            if (!paqueteEncontrado) {
                throw new AssertionError(
                        "ERROR: No se encontro el paquete en la pagina web. " + data.get("paqueteDatos"));
            }

            List<WebElementFacade> filas = TBL_VALORES_CONTADORES.resolveAllFor(actor);
            System.out.println("Se encontraron " + filas.size() + " filas");

            for (WebElementFacade fila : filas) {
                WebElementFacade packageNameCell = fila.then(By.xpath(".//td[2]"));
                String actualPackageName = packageNameCell.getText();
                System.out.println("Se encontro el paquete: " + actualPackageName);

                if (actualPackageName.equals(data.get("paqueteDatos"))) {
                    actor.should(
                            seeThat(
                                    ValidateInformationText.validateInformationText(TXT_FECHA_INICIO_CONTADORES)));

                    actor.should(
                            seeThat(
                                    ValidateInformationText.validateInformationText(
                                            TXT_FECHA_EXPIRACION_CONTADORES)));

                    actor.should(
                            seeThat(ValidateInformationText.validateInformationText(TXT_VALOR_CONTADOR)));

                    actor.attemptsTo(WaitFor.aTime(3000), AdjustPageZoom.to(85), Scroll.to(LGO_CLARO));

                    String titulo = " Consumos del paquete de datos ";
                    CapturasPantallasWeb.capturaPantalla(" ", titulo);

                    WordWeb.main();

                } else {
                    actor.should(
                            seeThat(
                                    ValidateInformationText.validateInformationText(TXT_FECHA_INICIO_CONTADORES)));

                    actor.should(
                            seeThat(
                                    ValidateInformationText.validateInformationText(
                                            TXT_FECHA_EXPIRACION_CONTADORES)));

                    actor.should(
                            seeThat(ValidateInformationText.validateInformationText(TXT_VALOR_CONTADOR)));

                    actor.attemptsTo(WaitFor.aTime(3000), AdjustPageZoom.to(85), Scroll.to(LGO_CLARO));

                    String titulo = " Consumos de Datos ";
                    CapturasPantallasWeb.capturaPantalla(" ", titulo);

                    WordWeb.main();
                }
            }

        } catch (Exception e) {
            // Manejo de excepciones
            System.out.println("Error: Ocurrió una excepción al buscar el paquete.");
            e.printStackTrace();
        }
        BrowseTheWeb.as(actor).getDriver().close();
    }

    public static Performable contadordeUsoConsumoDeDatos(Map<String, String> data) {
        return Instrumented.instanceOf(ContadorDeUsoConsumoDeDatos.class).withProperties(data);
    }
}