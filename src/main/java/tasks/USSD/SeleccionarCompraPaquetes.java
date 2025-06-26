package tasks.USSD;

import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import utils.CapturaDePantallaMovil;

;import static utils.Constants.*;


public class SeleccionarCompraPaquetes implements Task {

    private final String option;

    public SeleccionarCompraPaquetes(String option) {
        this.option = option;
    }

    public static SeleccionarCompraPaquetes selectOption(String option) {
        return new SeleccionarCompraPaquetes(option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(LINEA),
                ValidarTextoQueContengaX.elTextoContiene(SALDO),
                ValidarTextoQueContengaX.elTextoContiene(VIGENCIA)
        );

        String textoMenuPrincipal = Text.of(Target.the("menu principal").located(By.id("android:id/message")))
                .viewedBy(actor)
                .asString();
        //  System.out.println("Texto del menú: " + textoMenuPrincipal);

        int opcionCompraPaquetes = obtenerNumeroOpcion(textoMenuPrincipal, option);

        //   System.out.println("Se encontró en la opción: " + opcionCompraPaquetes);

        actor.attemptsTo(
                Enter.theValue(Integer.toString(opcionCompraPaquetes))
                        .into(Target.the("dialer").located(By.id("com.android.phone:id/input_field"))));
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(Target.the("enviar").located(By.id("android:id/button1"))));

    }


    private int obtenerNumeroOpcion(String textoMenu, String textoOpcion) {
        String[] lineas = textoMenu.split("\n");
        for (String linea : lineas) {
            if (linea.contains(textoOpcion)) {
                return Integer.parseInt(linea.split("\\.")[0].trim());
            }
        }
        throw new IllegalArgumentException("La opción '" + textoOpcion + "' no se encontró en el texto del menú.");
    }


}
