package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.COMPRAR;
import static utils.Constants.VER_DETALLE_DEL_PAQUETE;

import interactions.WaitFor;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.CapturaDePantallaMovil;

public class SaludLinea1BeneficiarioVig30Dias implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 3.000"),
                ClickElementByText.clickElementByText(VER_DETALLE_DEL_PAQUETE),
                ValidarTexto.validarTexto(
                        "Salud en línea te conecta con grupo Mok tu médico virtual, disfruta de consultas médicas y más beneficios, agenda tu cita telefónica al 5800838 vigencia 30 días."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                ClickElementByText.clickElementByText(COMPRAR),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 3.000"));
    }

    public static Performable saludLinea1BeneficiarioVig30Dias() {
        return instrumented(SaludLinea1BeneficiarioVig30Dias.class);

    }
}