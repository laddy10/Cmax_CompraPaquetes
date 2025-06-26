package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.*;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class SaludLinea4BeneficiariosVig30Dias extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        scrollCorto3(actor, "Null");

        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 6.000"),
                Click.on(LBL_VER_DETALLE_3),
                ValidarTexto.validarTexto(
                        "Salud en línea te conecta con grupo Mok tu médico virtual, disfruta de consultas médicas para ti y 3 beneficiarios, agenda tu cita telefónica al 5800838 vigencia 30 días."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_3),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 6.000"));
    }

    public static Performable saludLinea4BeneficiariosVig30Dias() {
        return instrumented(SaludLinea4BeneficiariosVig30Dias.class);

    }
}