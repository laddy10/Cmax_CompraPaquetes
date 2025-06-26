package tasks.USSD;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import utils.CapturaDePantallaMovil;


public class SeleccionarConsultaSaldo implements Task {

    private final String option;

    public SeleccionarConsultaSaldo(String option) {
        this.option = option;
    }

    public static SeleccionarConsultaSaldo selectOption(String option) {
        return new SeleccionarConsultaSaldo(option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
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

        actor.attemptsTo(
                WaitFor.aTime(4000));

    }

    private int obtenerNumeroOpcion(String textoMenu, String opcion) {
        // Dividir el texto del menú por saltos de línea
        String[] lineasMenu = textoMenu.split("\n");

        // Buscar la línea que contiene la opción deseada
        for (String linea : lineasMenu) {
            if (linea.contains(opcion)) {
                // Extraer el número de la opción
                String numeroOpcionStr = linea.split("\\.")[0].trim();
                // Convertir el número de la opción a entero y retornarlo
                return Integer.parseInt(numeroOpcionStr);
            }
        }

        // Si no se encontró la opción, lanzar una excepción
        throw new IllegalArgumentException("La opción '" + opcion + "' no se encontró en el texto del menú.");
    }



}
