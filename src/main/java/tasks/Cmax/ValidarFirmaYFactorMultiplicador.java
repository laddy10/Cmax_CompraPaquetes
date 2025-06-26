package tasks.Cmax;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.CMAX.*;

import interactions.WaitFor;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import utils.CapturasPantallasWeb;
import utils.WordWeb;
import interactions.comunes.ValidateInformationText;

public class ValidarFirmaYFactorMultiplicador implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(2000),
                Scroll.to(BTN_CERRAR2),
                WaitUntil.the(CJA_PRODUCT_ATTRIBUTES, WebElementStateMatchers.isVisible()));

        List<WebElementFacade> filas = TBL_DETALLE_PRODUCTOS.resolveAllFor(actor);
        System.out.println("Se encontraron " + filas.size() + " filas");

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
            String fechaHora = fila.then(By.xpath("./td[3]")).getText();
            System.out.println(
                    "Con Fecha y hora de: " + fechaHora + " en la fila " + (filas.indexOf(fila) + 1));
            //   actor.attemptsTo(WaitFor.aTime(4000));

            for (int i = 0; i < spanishMonths.length; i++) {
                fechaHora =
                        fechaHora.replace(
                                spanishMonths[i],
                                new DateFormatSymbols(new Locale("es", "CO")).getShortMonths()[i]);
            }

            System.out.println("Fecha y hora después de convertir: " + fechaHora);

            try {
                Date fecha = dateFormat.parse(fechaHora);
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

        if (!FechaHora.isEmpty()) {
            WebElementFacade ultimaCompra = FechaHora.get(FechaHora.size() - 1);
            // actor.attemptsTo(WaitFor.aTime(4000));
            ultimaCompra.then(By.xpath("./td[7]/a")).click();
            //  actor.attemptsTo(WaitFor.aTime(4000));
        }

        actor.attemptsTo(WaitFor.aTime(2000), Scroll.to(BTN_CERRAR2));

        if (!Presence.of(TXT_FIRMAS).viewedBy(actor).resolveAll().isEmpty()) {
            actor.should(
                    seeThat(ValidateInformationText.validateInformationText(TXT_FACTOR_MULTIPLICADOR)));
            actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FIRMAS)));
        } else {
            actor.should(seeThat(ValidateInformationText.validateInformationText(TXT_FIRMAS2)));
        }

        String titulo = " \nVigencias -- " + " \nFirmas  -- " + "\n Factor Multiplicador";
        CapturasPantallasWeb.capturaPantalla(" ", titulo);

        WordWeb.main();
    }

    public static Performable validarfirmaYFactorMultiplicador() {
        return instrumented(ValidarFirmaYFactorMultiplicador.class);
    }
}
