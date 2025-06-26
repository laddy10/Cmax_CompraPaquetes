package tasks.USSD;

import interactions.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelaccionarTipoPaquete implements Task {

  private final String option;

  public SelaccionarTipoPaquete(String option) {

    this.option = option;
  }

  public static SelaccionarTipoPaquete selectOptionTipo(String option) {
    return new SelaccionarTipoPaquete(option);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(WaitFor.aTime(10000));

    String textoMenuPrincipal =
        Text.of(Target.the("menu principal").located(By.id("android:id/message")))
            .viewedBy(actor)
            .asString();
    System.out.println("Texto del menú: " + textoMenuPrincipal);

    int opcionCompraPaquetes = obtenerNumeroOpcion(textoMenuPrincipal, option);

    System.out.println("Se encontró en la opción: " + opcionCompraPaquetes);

    actor.attemptsTo(
        Enter.theValue(Integer.toString(opcionCompraPaquetes))
            .into(Target.the("dialer").located(By.id("com.android.phone:id/input_field"))),
        Click.on(Target.the("enviar").located(By.id("android:id/button1"))));
  }

  private int obtenerNumeroOpcion(String textoMenu, String opcion) {
    String menuSinNumeros = textoMenu.replaceAll("[0-9.]", "");
    String[] opciones = menuSinNumeros.split("\n");

    for (int i = 0; i < opciones.length; i++) {
      if (opciones[i].trim().equals(opcion)) {
        return i + 1;
      }
    }

    throw new IllegalArgumentException(
        "La opción '" + opcion + "' no se encontró en el texto del menú.");
  }
}
