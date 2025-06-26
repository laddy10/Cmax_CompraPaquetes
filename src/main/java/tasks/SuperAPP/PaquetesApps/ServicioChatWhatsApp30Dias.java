package tasks.SuperAPP.PaquetesApps;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.ULTIMO;

import interactions.WaitFor;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AdbUtils;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

public class ServicioChatWhatsApp30Dias implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene(ULTIMO),
                WaitFor.aTime(2000));

        //Dar clic Ver detalle del paquete
        AdbUtils.ejecutarAdbTap(363, 946);

        actor.attemptsTo(
               // ValidarTexto.validarTexto("Servicio Chat WhatsApp por 30 días."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        //Dar clic boton Comprar
        AdbUtils.ejecutarAdbTap(361, 1142);


        actor.attemptsTo(
                ValidarTexto.validarTexto("$ 18.500"),
                WaitFor.aTime(2000));
    }

    public static Performable servicioChatWhatsApp30Dias() {
        return instrumented(ServicioChatWhatsApp30Dias.class);

    }
}