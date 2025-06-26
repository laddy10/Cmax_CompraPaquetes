package tasks.SuperAPP.PaquetesRelevo;

import interactions.WaitFor;
import interactions.comunes.ValidarTexto;
import interactions.scroll.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.CapturaDePantallaMovil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.SegmentoPage.BTN_COMPRAR_2;
import static userinterfaces.SegmentoPage.LBL_VER_DETALLE_2;
import static utils.AdbUtils.ejecutarAdbTap;

public class RelevoSMSIlimWTF6GB30Dias extends AndroidObject implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto("$ 30.500"),
                Click.on(LBL_VER_DETALLE_2),
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto("Este paquete incluye 6GB de Navegacion, ilimitados de SMS + WhatsApp, Facebook , Twitter y la aplicación de Centro de Relevo durante una vigencia 30 dias."),
                WaitFor.aTime(2000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(BTN_COMPRAR_2),
                WaitFor.aTime(2000),
                ValidarTexto.validarTexto("$ 30.500"));
    }

    public static Performable relevoSMSIlimWTF6GB30Dias() {
        return instrumented(RelevoSMSIlimWTF6GB30Dias.class);
    }
}