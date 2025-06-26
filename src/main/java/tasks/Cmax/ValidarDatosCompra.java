package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;

import java.text.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.*;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import interactions.comunes.ValidateInformationText;
import utils.AdjustPageZoom;
import utils.CapturasPantallasWeb;
import utils.DataDrivenExcel;

public class ValidarDatosCompra implements Task {

    static DataDrivenExcel dataDriverExcel = new DataDrivenExcel();

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss", new Locale("sp", "SP"));
    Map<String, String> data = new HashMap<String, String>();

    public ValidarDatosCompra(Map<String, String> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(TBL_DATOS, WebElementStateMatchers.isVisible()));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TBL_DATOS)));

        List<WebElementFacade> filas = TBL_DATOS.resolveAllFor(actor);
        System.out.println("Se encontraron " + filas.size() + " filas");

        System.out.println("El valor de la compra Buscado es de: " + data.get("valorBuscado"));

        Map<String, String> valoresYFechas = new HashMap<>();
        WebElementFacade ultimaFila = null;
        boolean encontrada = false;

    /*    for (WebElementFacade fila : filas) {
        String valorCompra = fila.then(By.xpath(".//td[6]")).getText();
        System.out.println("Valor compra encontrado: " + valorCompra);
        if (valorCompra.contains(data.get("valorBuscado"))) {
            System.out.println("Se encontro el valor " + valorCompra + " en la fila " + (filas.indexOf(fila) + 1));
            String fechaHora = fila.then(By.xpath(".//td[2]")).getText();
            System.out.println("Con Fecha y hora de: " + fechaHora);
            valoresYFechas.put(fechaHora, valorCompra);
        }
    } */

        for (WebElementFacade fila : filas) {
            String valorCompraTexto = fila.then(By.xpath(".//td[6]")).getText();
            System.out.println("Valor compra encontrado: " + valorCompraTexto);

            // Verificar que el valor no esté vacío
            if (!valorCompraTexto.isEmpty()) {
                // Eliminar caracteres no numéricos ni coma
                String valorCompra = valorCompraTexto.replaceAll("[^\\d,]", "");

                // Asegurarse de que el formato sea "X,XXX.XX"
                DecimalFormat decimalFormat =
                        (DecimalFormat) NumberFormat.getNumberInstance(Locale.getDefault());
                decimalFormat.applyPattern("#,###.##");

                try {
                    Number number = decimalFormat.parse(valorCompra);
                    double parsedValue = number.doubleValue();
                    String formattedValue = decimalFormat.format(parsedValue);

                    if (formattedValue.equals(data.get("valorBuscado"))) {
                        System.out.println(
                                "Se encontro el valor "
                                        + formattedValue
                                        + " en la fila "
                                        + (filas.indexOf(fila) + 1));
                        String fechaHora = fila.then(By.xpath(".//td[2]")).getText();
                        System.out.println("Con Fecha y hora de: " + fechaHora);
                        valoresYFechas.put(fechaHora, formattedValue);
                    }
                } catch (ParseException e) {
                    System.out.println("No se pudo parsear el valor: " + valorCompra);
                    e.printStackTrace();
                }
            } else {
                System.out.println("El valor de compra está vacío en la fila " + (filas.indexOf(fila) + 1));
            }
        }

        actor.attemptsTo(WaitFor.aTime(4000));

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd-MMM-yyyy H:mm:ss", new Locale("es", "CO"));
        List<WebElementFacade> FechaHora = new ArrayList<>();
        Date fechaMasReciente = null;

        DateTimeFormatter formatter =
                new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern("dd-MMM-yyyy H:mm:ss")
                        .toFormatter(new Locale("es", "CO"))
                        .withResolverStyle(ResolverStyle.STRICT);

        String[] spanishMonths = {
                "ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic"
        };

        for (WebElementFacade fila : filas) {
            String valorCompra = fila.then(By.xpath(".//td[6]")).getText();
            System.out.println(
                    "Con Fecha y hora de: " + valorCompra + " en la fila " + (filas.indexOf(fila) + 1));

            if (valorCompra.equals(data.get("valorBuscado"))) {
                String fechaHora = fila.then(By.xpath(".//td[2]")).getText();
                System.out.println("Fecha y hora antes de parsear: " + fechaHora);

                // Reemplazar las abreviaturas de los meses
                for (int i = 0; i < spanishMonths.length; i++) {
                    fechaHora =
                            fechaHora.replace(
                                    spanishMonths[i],
                                    new DateFormatSymbols(new Locale("es", "CO")).getShortMonths()[i]);
                }

                System.out.println("Fecha y hora después de convertir: " + fechaHora);

                try {
                    Date fecha = dateFormat.parse(fechaHora);
                    System.out.println("Fecha y hora después de parsear: " + fecha);

                    if (fechaMasReciente == null || fecha.after(fechaMasReciente)) {
                        fechaMasReciente = fecha;
                        FechaHora.clear();
                        FechaHora.add(fila);
                    } else if (fecha.equals(fechaMasReciente)) {
                        FechaHora.add(fila);
                    }
                } catch (ParseException e) {
                    System.out.println("No se pudo parsear la fecha y hora: " + fechaHora);
                }
            }
        }

        if (!FechaHora.isEmpty()) {
            WebElementFacade ultimaCompra = FechaHora.get(FechaHora.size() - 1);
            actor.attemptsTo(WaitFor.aTime(1000));
            ultimaCompra.then(By.xpath(".//td[1]")).click();

            actor.attemptsTo(
                    WaitFor.aTime(2000), Scroll.to(LGO_CLARO), WaitFor.aTime(1000), AdjustPageZoom.to(80));
        } else {
            throw new AssertionError(
                    "ERROR: No se encontró ninguna compra con el valor: " + data.get("valorBuscado"));
        }

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FECHA_HORA)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_ESTADO_CUENTA)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_IMPORTE_AJUSTE)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_CUENTA_PRINCIPAL)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_DATOS_EXTERNOS1)));

        actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_DATOS_EXTERNOS2)));

        String titulo = "\nValidar descuento del valor del paquete ";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        actor.attemptsTo(AdjustPageZoom.to(100));

        System.out.println(
                "Se encontraron "
                        + valoresYFechas.size()
                        + " compras con el valor "
                        + data.get("valorBuscado"));
        System.out.println(
                "Se hace clic en la lupa correspondiente a la ultima compra con el valor: "
                        + data.get("valorBuscado"));
    }

    public static Performable validardatosCompra(Map<String, String> data) {
        return Instrumented.instanceOf(ValidarDatosCompra.class).withProperties(data);
    }
}
