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


public class RealizarCompraPaquete implements Task {

    private final String option;

    public RealizarCompraPaquete(String option) {
        this.option = option;
    }

    public static RealizarCompraPaquete comprapaquete(String option) {
        return new RealizarCompraPaquete(option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                WaitFor.aTime(3000));

        String textoMenuPrincipal = Text.of(Target.the("menu principal").located(By.id("android:id/message")))
                .viewedBy(actor)
                .asString();
     //    System.out.println("Texto del menú: " + textoMenuPrincipal);

        int opcionCompraPaquetes = obtenerNumeroOpcion(textoMenuPrincipal, option);

     //     System.out.println("Se encontró en la opción: " + opcionCompraPaquetes);

        actor.attemptsTo(
                WaitFor.aTime(4000));

        actor.attemptsTo(
                Enter.theValue(Integer.toString(opcionCompraPaquetes))
                        .into(Target.the("dialer").located(By.id("com.android.phone:id/input_field"))));
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        actor.attemptsTo(
                Click.on(Target.the("enviar").located(By.id("android:id/button1")))
        );

        while (opcionCompraPaquetes == 9) {
            String textoMenuCompra = Text.of(Target.the("menu compra").located(By.id("android:id/message")))
                    .viewedBy(actor)
                    .asString();
           //     System.out.println("Texto del menú de compra: " + textoMenuCompra);

            opcionCompraPaquetes = obtenerNumeroOpcion(textoMenuCompra, option);

          //      System.out.println("Se encontró en la opción: " + opcionCompraPaquetes);

            actor.attemptsTo(
                    Enter.theValue(Integer.toString(opcionCompraPaquetes))
                            .into(Target.the("dialer").located(By.id("com.android.phone:id/input_field"))));
            CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

            actor.attemptsTo(
                    Click.on(Target.the("enviar").located(By.id("android:id/button1")))
            );
        }


        // Si se encontró el paquete deseado, realizar las acciones correspondientes
        realizarCompraPaquete(actor);
    }

    private void realizarCompraPaquete(Actor actor) {
        // Aquí puedes agregar la lógica para realizar la compra del paquete deseado
        //   System.out.println("Realizando compra del paquete: " + option);
    }

    private int obtenerNumeroOpcion(String textoMenu, String opcion) {
        String[] opciones = textoMenu.split("\\d+\\. ");
        for (int i = 1; i < opciones.length; i++) {
            if (opciones[i].startsWith(opcion)) {
                return i;
            }
        }
        return 9;
    }

}
