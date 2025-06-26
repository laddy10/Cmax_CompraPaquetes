package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.CapturaDePantallaMovil;

public class SaludLinea2BeneficiarioVig30Dias implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 4.500"),
                Click.on(LBL_VER_DETALLE_2),
                ValidarTexto.validarTexto(
                        "Salud en línea te conecta con grupo Mok tu médico virtual, disfruta de consultas médicas para ti y un beneficiario, agenda tu cita telefónica al 5800838 vigencia 30 días."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 4.500"));
    }

    public static Performable saludLinea2BeneficiarioVig30Dias() {
        return instrumented(SaludLinea2BeneficiarioVig30Dias.class);

    }
}