package tasks.MiClaroApp;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static userinterfaces.SegmentoPage.*;
import static userinterfaces.USSDPage.TXT_MENSAJE_SALDO_INSUFICIENTE;
import static utils.Constants.*;

import interactions.WaitElement;
import interactions.WaitFor;
import interactions.comunes.Atras;
import interactions.comunes.ClickElementByText;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.scroll.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import java.util.List;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import interactions.comunes.ValidateInformationText;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;
import utils.AndroidObject;

public class RecargaYCompraDePaquetes extends AndroidObject implements Task {

  User addCredentials;

  private AppiumDriver<AndroidElement> driver;

  public RecargaYCompraDePaquetes(User addCredentials) {
    this.addCredentials = addCredentials;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        WaitFor.aTime(15000), ClickElementByText.clickElementByText(PREPAGO), WaitFor.aTime(4000));

    scrollCorto2(actor, addCredentials.getNumero() + " Recargar");

    actor.attemptsTo(
        WaitFor.aTime(2000), ClickTextoQueContengaX.elTextoContiene(addCredentials.getNumero()));

    theActorInTheSpotlight()
        .should(
            seeThat(
                ValidateInformationText.validateInformationText(LBL_COMPRA_PAQUETES_RECARGAS2),
                equalTo(COMPRA_PAQUETES_RECARGAS)));

    actor.attemptsTo(
        ClickElementByText.clickElementByText(PAQUETES),
        ValidarTexto.validarTexto(ELIGE_TIPO_PAQUETE),
        WaitFor.aTime(2000),
        WaitElement.isClickable(CBX_TIPO_PAQUETE),
        Click.on(CBX_TIPO_PAQUETE),
        WaitFor.aTime(2000));
    //      ClickTextoQueContengaX.elTextoContiene("Paquetes de datos")

    actor.attemptsTo(
        ValidarTexto.validarTexto(addCredentials.getTipoPaquete()),
        Scroll.scrollUnaVista(),
        ClickElementByText.clickElementByText(VER_MAS_PAQUETES),
        WaitFor.aTime(2000));

    // scrollCorto2(actor, "$ 5.500");

    // CODIGO PRUEBA
    // ###########################################################################################

    boolean precioEncontrado = false;
    int paginaActual = 1;
    int maxPaginas = 5; // Máximo de páginas a recorrer

    while (!precioEncontrado && paginaActual <= maxPaginas) {
      System.out.println("🔍 Buscando en página " + paginaActual);

      // **Usamos scrollCorto2 para buscar el precio con scroll preciso**
      scrollCorto2(actor, addCredentials.getPrecio());

      // 🚀 IMPORTANTE: Marcar que ya encontramos el precio y salir del loop
      precioEncontrado = true;
      break;
    }

    // Si no encontramos el precio, pasamos a la siguiente página
    if (!precioEncontrado) {
      if (!Presence.of(BTN_NEXT).viewedBy(actor).resolveAll().isEmpty()) {
        System.out.println("➡️ Cambiando a la página " + (paginaActual + 1));
        actor.attemptsTo(Click.on(BTN_NEXT));
        WaitFor.aTime(3000);
        paginaActual++;
      } else {
        System.out.println("❌ No hay más páginas y el precio no se encontró.");
        throw new RuntimeException("Precio no encontrado en ninguna página.");
      }
    }

    // Obtener todos los paquetes disponibles en la página actual
    List<WebElement> paquetes =
        androidDriver(actor)
            .findElements(
                MobileBy.AndroidUIAutomator(
                    "new UiSelector().className(\"android.view.ViewGroup\")"));

    for (WebElement paquete : paquetes) {
      List<WebElement> botonesVerDetalle =
          paquete.findElements(
              MobileBy.AndroidUIAutomator("new UiSelector().text(\"Ver detalle del paquete\")"));

      WebElement elemento = botonesVerDetalle.get(0);
      centrarElementoSuavemente(actor, elemento);
    }

    actor.attemptsTo(
        ClickElementByText.clickElementByText("Ver detalle del paquete"), WaitFor.aTime(2000));

    if (!Presence.of(BTN_COMPRAR2).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(BTN_COMPRAR2));
    } else {
      actor.attemptsTo(ClickElementByText.clickElementByText("Comprar"));
    }

    //    String datosEsperados = addCredentials.getDatos();
    //    String minutosEsperados = addCredentials.getMinutos();
    String precioEsperado = addCredentials.getPrecio();

    // String xpathDatos = "//*[@text='" + datosEsperados + "' and contains(@resource-id,
    // 'datoDatosDato')]";
    //  String xpathMinutos = "//*[@text='" + minutosEsperados + "' and contains(@resource-id,
    // 'datoMinutosDato')]";
    //  String xpathPrecio = "//*[@text='" + precioEsperado + "' and contains(@resource-id,
    // 'datoTotalDato')]";
    String xpathPrecio = "//android.widget.TextView[@text='" + precioEsperado + "']";
    //  String xpathPrecio = "//android.widget.TextView[contains(normalize-space(@text), '5.500')]";
    //  String xpathPrecio = "//android.widget.TextView[contains(@text, '5.500')]";

    if (!Presence.of(xpathPrecio).viewedBy(actor).resolveAll().isEmpty()) {

      actor.attemptsTo(WaitUntil.the(xpathPrecio, isVisible()).forNoMoreThan(30).seconds());
      //   WaitUntil.the(xpathDatos, isVisible()).forNoMoreThan(30).seconds(),
      //    WaitUntil.the(xpathMinutos, isVisible()).forNoMoreThan(30).seconds(),

      CapturaDePantallaMovil.tomarCapturaPantalla("");

      actor.attemptsTo(WaitFor.aTime(3000), Click.on(CHECK_ACEPTAR_TERMINOS_CONDICIONES));

    } else {
      actor.attemptsTo(
          Atras.irAtras(),
          Scroll.scrollUnaVista(),
          Click.on(LBL_VER_DETALLE_2),
          Click.on(BTN_COMPRAR_2),
          ClickTextoQueContengaX.elTextoContiene("Contra saldo"),
          WaitFor.aTime(3000));

      if (!Presence.of(xpathPrecio).viewedBy(actor).resolveAll().isEmpty()) {

        actor.attemptsTo(WaitUntil.the(xpathPrecio, isVisible()).forNoMoreThan(30).seconds());

        System.out.println("El precio visibles es:" + xpathPrecio);

        actor.attemptsTo(WaitFor.aTime(3000), Click.on(CHECK_ACEPTAR_TERMINOS_CONDICIONES));
      }
    }

    actor.attemptsTo(
        Click.on(PRUEBA),
        WaitFor.aTime(3000),
        Atras.irAtras(),
        WaitFor.aTime(3000),
        Click.on(CHECK_ACEPTAR_TERMINOS_CONDICIONES));

    if (!Presence.of(LBL_VER_DETALLE_2).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(LBL_VER_DETALLE_2));
    } else {
      actor.attemptsTo(ClickElementByText.clickElementByText("Ver detalle del paquete"));
    }

    actor.attemptsTo(WaitFor.aTime(2000));

    scrollCorto2(actor, "Null");

    if (!Presence.of(BTN_COMPRAR2).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(BTN_COMPRAR2));
    } else {
      actor.attemptsTo(ClickElementByText.clickElementByText("Comprar"));
    }

    actor.attemptsTo(WaitFor.aTime(2000), ClickTextoQueContengaX.elTextoContiene("Contra saldo"));
    CapturaDePantallaMovil.tomarCapturaPantalla("");

    actor.attemptsTo(WaitFor.aTime(3000));

    if (!Presence.of(BTN_CONTRA_SALDO).viewedBy(actor).resolveAll().isEmpty()) {
      actor.attemptsTo(Click.on(BTN_CONTRA_SALDO));
    } else {
      actor.attemptsTo(Click.on(BTN_CONTRA_SALDO2));
    }

    // ###########################################################################################

    /*    boolean paqueteEncontrado = false;

    while (!paqueteEncontrado) {


        String paqueteText = addCredentials.getPrecio();
        String selector = "new UiSelector().text(\"" + paqueteText + "\")";

        if (!Presence.of(MobileBy.AndroidUIAutomator(selector)).viewedBy(actor).resolveAll().isEmpty()) {
            // El paquete se ha encontrado
            paqueteEncontrado = true;

            scrollCorto2(actor, "$ 4.000");

            actor.attemptsTo(
                    ScrollVertical.scrollVertical("$ 4.000"),
                    WaitFor.aTime(2000));


            actor.attemptsTo(
                    ClickElementByText.clickElementByText("Ver detalle del paquete"),
                    ValidarTexto.validarTexto(addCredentials.getPaqueteComprar()));


            String PaqueteCompraEsperado = addCredentials.getPaqueteComprar();

            String xpathPrecio = "//*[@text='" + PaqueteCompraEsperado + "' and contains(@resource-id, 'datoTotalDato')]";


            if (!Presence.of(BTN_COMPRAR).viewedBy(actor).resolveAll().isEmpty()) {
                // Realiza el clic solo si el paquete se encuentra
                CapturaDePantallaMovil.tomarCapturaPantalla("");
                actor.attemptsTo(
                        ClickElementByText.clickElementByText(COMPRAR));
            } else {
                actor.attemptsTo(
                        ScrollVertical.scrollVertical(COMPRAR));
                CapturaDePantallaMovil.tomarCapturaPantalla("");
                actor.attemptsTo(
                        ScrollAndClick.scrollAndClick(COMPRAR));
            }

        } else {
            // Si no se encuentra el paquete en la página actual, verifica si hay un botón "Next"
            if (!Presence.of(BTN_NEXT).viewedBy(actor).resolveAll().isEmpty()) {
                actor.attemptsTo(Click.on(BTN_NEXT));
                WaitFor.aTime(2000);
            } else {
                // Si no hay más páginas o botón "Next", puedes lanzar una excepción o manejar el caso según tus necesidades
                throw new RuntimeException("Paquete no encontrado en ninguna de las opciones");
            }
        }
    } */

    /*     actor.attemptsTo(WaitFor.aTime(2000),
    ClickTextoQueContengaX.elTextoContiene("Ver detalle del paquete"),
    WaitFor.aTime(5000)); */

    /*

            // Obtener todos los paquetes disponibles en la página actual
            List<WebElement> paquetes = androidDriver(actor).findElements(
                    MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\")")
            );

            boolean paqueteCorrectoEncontrado = false;

            for (WebElement paquete : paquetes) {
                // Obtener todos los textos dentro del paquete
                List<WebElement> textosPaquete = paquete.findElements(
                        MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")
                );



                        // Buscar el botón "Ver detalle del paquete" dentro de este paquete
                        List<WebElement> botonesVerDetalle = paquete.findElements(
                                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Ver detalle del paquete\")")
                        );

                    //    WebElement elemento = botonesVerDetalle.get(0);
                    //    centrarElementoSuavemente(actor, elemento);

                        if (!botonesVerDetalle.isEmpty()) {
                            System.out.println("🔍 Haciendo clic en 'Ver detalle del paquete'");
                            botonesVerDetalle.get(0).click(); // Clic en el botón del paquete correcto

                            // Esperar a que cargue la información
                            actor.attemptsTo(WaitFor.aTime(3000));

                            for (WebElement texto : textosPaquete) {
                                String textoDetalle = texto.getText();
                                System.out.println("📄 Texto del paquete encontrado: " + textoDetalle);

                                // Si el paquete contiene el dato ingresado
                                if (textoDetalle.contains(addCredentials.getDatos())) {
                                    System.out.println("✅ Paquete correcto encontrado: " + textoDetalle);
                                    paqueteCorrectoEncontrado = true;

                            // Intentar encontrar el botón "Comprar"
                            List<WebElement> botonesComprar = paquete.findElements(
                                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                            );

                            // Si no se encuentra el botón, hacer un scroll corto y reintentar
                            if (botonesComprar.isEmpty()) {
                                System.out.println("🔄 Botón 'Comprar' no visible, haciendo scroll corto...");
                            //    scrollCorto2(actor, " ");
                                botonesComprar = paquete.findElements(
                                        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                                );
                            }

                            // Si encuentra el botón, hacer clic
                            if (!botonesComprar.isEmpty()) {
                                System.out.println("🛒 Haciendo clic en 'Comprar' del paquete correcto");
                            //    scrollCorto4(actor, "nul");

                                botonesComprar.get(0).click();
                                return;
                            } else {
                                System.out.println("❌ No se encontró el botón 'Comprar' después del scroll.");
                            }
                        } else {
                            System.out.println("❌ No se encontró 'Ver detalle del paquete' en el paquete correcto.");
                        }
                    }
                }
            }

    // Si no encontró el paquete correcto
            if (!paqueteCorrectoEncontrado) {
                throw new RuntimeException("❌ No se encontró un paquete con " + addCredentials.getDatos());
            }













            //


            // Obtener todos los botones "Ver detalle del paquete" en la página actual
            List<WebElement> botonesDetalle = androidDriver(actor).findElements(
                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Ver detalle del paquete\")")
            );

         //   boolean paqueteCorrectoEncontrado = false;

            if (!botonesDetalle.isEmpty()) {
                // Obtener el último botón de la lista
                WebElement ultimoBotonDetalle = botonesDetalle.get(botonesDetalle.size() - 1);


                WebElement elemento = botonesDetalle.get(0);
                centrarElementoSuavemente(actor, elemento);

                // Hacer clic en el último botón "Ver detalle del paquete"
                System.out.println("🔍 Haciendo clic en el último 'Ver detalle del paquete'");
                ultimoBotonDetalle.click();

                // Esperar a que cargue la información del paquete
                actor.attemptsTo(WaitFor.aTime(3000));

                // Obtener todos los textos visibles en la sección del paquete
                List<WebElement> detallesPaquete = androidDriver(actor).findElements(
                        MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")
                );

                for (WebElement detalle : detallesPaquete) {
                    String textoDetalle = detalle.getText();
                    System.out.println("📄 Texto del paquete: " + textoDetalle);

                    // Validar si el paquete coincide con el dato ingresado
                    if (textoDetalle.contains(addCredentials.getDatos())) {
                        System.out.println("✅ Paquete correcto encontrado: " + textoDetalle);
                        paqueteCorrectoEncontrado = true;

                        // Intentar encontrar el botón "Comprar" después del paquete expandido
                        List<WebElement> botonesComprar = androidDriver(actor).findElements(
                                MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                        );



                        // Hacer scroll corto si el botón "Comprar" no está visible
                        if (botonesComprar.isEmpty()) {
                            System.out.println("🔄 Botón 'Comprar' no visible, haciendo scroll corto...");
                            scrollCorto2(actor, "null");
                            botonesComprar = androidDriver(actor).findElements(
                                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                            );
                        }


                        // Si se encuentra el botón, hacer clic
                        if (!botonesComprar.isEmpty()) {
                            System.out.println("🛒 Haciendo clic en 'Comprar' del último paquete");
                            scrollCorto4(actor, "null");
                            botonesComprar.get(botonesComprar.size() - 1).click();
                            return;
                        } else {
                            System.out.println("❌ No se encontró el botón 'Comprar' después del scroll.");
                        }
                    }
                }

                // Si no encontró el texto del paquete correcto, hacer un scroll y reintentar
                if (!paqueteCorrectoEncontrado) {
                    System.out.println("🔄 Texto no encontrado, haciendo scroll corto para buscar otro paquete...");
                    actor.attemptsTo(WaitFor.aTime(4000));
                    scrollCorto3(actor, "null");

                    actor.attemptsTo(WaitFor.aTime(5000),
                            ClickTextoQueContengaX.elTextoContiene("Ver detalle del paquete")
                    );

                    // Reintentar la búsqueda del paquete correcto después del scroll
                    detallesPaquete = androidDriver(actor).findElements(
                            MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")
                    );

                    for (WebElement detalle : detallesPaquete) {
                        String textoDetalle = detalle.getText();

                        if (textoDetalle.contains(addCredentials.getDatos())) {
                            System.out.println("✅ Paquete correcto encontrado: " + textoDetalle);
                            paqueteCorrectoEncontrado = true;

                            // Buscar el botón "Comprar"
                            List<WebElement> botonesComprar = androidDriver(actor).findElements(
                                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                            );

                            if (!botonesComprar.isEmpty()) {
                                System.out.println("🛒 Haciendo clic en 'Comprar'");
                                actor.attemptsTo(WaitFor.aTime(4000));
                                botonesComprar.get(0).click();
                                return;
                            } else {
                                System.out.println("❌ No se encontró el botón 'Comprar' después del segundo intento.");
                            }
                        }
                    }
                }
            }

    // Si ningún paquete con el dato ingresado fue encontrado
            if (!paqueteCorrectoEncontrado) {
                throw new RuntimeException("❌ No se encontró un paquete con " + addCredentials.getDatos());
            }


    //






            // ESTE FUNCIONA UNA PARTE

            /*

            // Obtener todos los botones "Ver detalle del paquete" en la página actual
            List<WebElement> botonesDetalle = androidDriver(actor).findElements(
                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Ver detalle del paquete\")")
            );

            boolean paqueteCorrectoEncontrado = false;

            for (WebElement botonDetalle : botonesDetalle) {

            //    WebElement elemento = botonesDetalle.get(0);
              //  centrarElementoSuavemente(actor, elemento);
               // centrarElementoSuavemente(actor, elemento);


                if (!botonesDetalle.isEmpty()) {
                    // Obtener el último botón de la lista
                    WebElement ultimoBotonDetalle = botonesDetalle.get(botonesDetalle.size() - 1);


                    // Hacer clic en el último botón "Ver detalle del paquete"
                    ultimoBotonDetalle.click();
                    System.out.println("🔍 Haciendo clic en el último 'Ver detalle del paquete'");




                    // Espera para que cargue la información del paquete
                    actor.attemptsTo(WaitFor.aTime(3000));

                    // Obtener el texto del paquete para validarlo
                    List<WebElement> detallesPaquete = androidDriver(actor).findElements(
                            MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")
                    );

                    boolean textoEncontrado = false;

                    for (WebElement detalle : detallesPaquete) {
                        String textoDetalle = detalle.getText();
                        System.out.println("📄 Texto del paquete: " + textoDetalle);

                        // Verificar si el texto contiene "50 MB"
                        if (textoDetalle.contains(addCredentials.getDatos())) {
                            System.out.println("✅ Paquete correcto encontrado: " + textoDetalle);
                            paqueteCorrectoEncontrado = true;

                            // Buscar el botón "Comprar" que está debajo del último paquete expandido
                            List<WebElement> botonesComprar = androidDriver(actor).findElements(
                                    MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                            );

                            scrollCorto2(actor, " ");

                            if (!botonesComprar.isEmpty()) {
                                // Obtener el último botón de la lista (correspondiente al paquete seleccionado)




                                WebElement ultimoBotonComprar = botonesComprar.get(botonesComprar.size() - 1);

                                // Hacer clic en "Comprar"
                                System.out.println("🛒 Haciendo clic en 'Comprar' del último paquete");
                                ultimoBotonComprar.click();
                                return;
                            } else {
                                System.out.println("❌ No se encontró el botón 'Comprar'");
                            }
                        } else {
                            System.out.println("❌ No se encontró ningún botón 'Ver detalle del paquete'");
                        }
                    }


                    if (!textoEncontrado) {
                        System.out.println("🔄 Texto no encontrado, haciendo scroll corto para encontrar el siguiente 'Ver detalle del paquete'...");
                        actor.attemptsTo(
                                WaitFor.aTime(4000));

                        scrollCorto3(actor, "null");

                        actor.attemptsTo(
                                WaitFor.aTime(5000),
                                ClickTextoQueContengaX.elTextoContiene("Ver detalle del paquete"));


                        for (WebElement detalle : detallesPaquete) {
                            String textoDetalle = detalle.getText();

                            if (textoDetalle.contains(addCredentials.getDatos())) {
                                System.out.println("✅ Paquete correcto encontrado: " + textoDetalle);
                                paqueteCorrectoEncontrado = true;

                                // Hacer clic en el botón "Comprar" que está debajo
                                List<WebElement> botonesComprar = androidDriver(actor).findElements(
                                        MobileBy.AndroidUIAutomator("new UiSelector().text(\"Comprar\")")
                                );

                                if (!botonesComprar.isEmpty()) {
                                    System.out.println("🛒 Haciendo clic en 'Comprar'");
                                    actor.attemptsTo(
                                            WaitFor.aTime(4000));
                                    botonesComprar.get(0).click();
                                    return;
                                } else {
                                    System.out.println("❌ No se encontró el botón 'Comprar'");
                                }
                            }
                        }


                    }

                    if (paqueteCorrectoEncontrado) {
                        break;
                    }
                }

    // Si ningún paquete con "50 MB" fue encontrado
                if (!paqueteCorrectoEncontrado) {
                    throw new RuntimeException("❌ No se encontró un paquete con " + addCredentials.getDatos());
                }
            }

    */

    if (!Presence.of(BTN_CONTRA_SALDO).viewedBy(actor).resolveAll().isEmpty()) {
      CapturaDePantallaMovil.tomarCapturaPantalla("");

      actor.attemptsTo(WaitFor.aTime(2000), Click.on(BTN_CONTRA_SALDO), WaitFor.aTime(2000));
    } else {
      CapturaDePantallaMovil.tomarCapturaPantalla("");
      actor.attemptsTo(Click.on(BTN_CONTRA_SALDO2), WaitFor.aTime(2000));
    }

    actor.attemptsTo(WaitFor.aTime(3000));

    /*   String datosEsperados = addCredentials.getDatos();
            String minutosEsperados = addCredentials.getMinutos();
            String precioEsperado = addCredentials.getPrecio();

            String xpathDatos = "//*[@text='" + datosEsperados + "' and contains(@resource-id, 'datoDatosDato')]";
            String xpathMinutos = "//*[@text='" + minutosEsperados + "' and contains(@resource-id, 'datoMinutosDato')]";
            String xpathPrecio = "//*[@text='" + precioEsperado + "' and contains(@resource-id, 'datoTotalDato')]";

    */
    if (!Presence.of(xpathPrecio).viewedBy(actor).resolveAll().isEmpty()) {

      actor.attemptsTo(WaitUntil.the(xpathPrecio, isVisible()).forNoMoreThan(30).seconds());
      //   WaitUntil.the(xpathDatos, isVisible()).forNoMoreThan(30).seconds(),
      //    WaitUntil.the(xpathMinutos, isVisible()).forNoMoreThan(30).seconds(),
      CapturaDePantallaMovil.tomarCapturaPantalla("");
      actor.attemptsTo(ClickElementByText.clickElementByText(CONTINUAR), WaitFor.aTime(4000));

    } else {
      actor.attemptsTo(ClickElementByText.clickElementByText(VOLVER), Scroll.scrollUnaVista());

      if (!Presence.of(BTN_COMPRAR1).viewedBy(actor).resolveAll().isEmpty()) {
        actor.attemptsTo(Click.on(BTN_COMPRAR1));
      }
      if (!Presence.of(BTN_CONTRA_SALDO).viewedBy(actor).resolveAll().isEmpty()) {
        CapturaDePantallaMovil.tomarCapturaPantalla("");
        actor.attemptsTo(WaitFor.aTime(2000), Click.on(BTN_CONTRA_SALDO), WaitFor.aTime(2000));
      } else {
        CapturaDePantallaMovil.tomarCapturaPantalla("");
        actor.attemptsTo(Click.on(BTN_CONTRA_SALDO2), WaitFor.aTime(2000));
      }

      actor.attemptsTo(WaitFor.aTime(3000));

      if (!Presence.of(xpathPrecio).viewedBy(actor).resolveAll().isEmpty()) {

        actor.attemptsTo(WaitUntil.the(xpathPrecio, isVisible()).forNoMoreThan(30).seconds());
        //   WaitUntil.the(xpathDatos, isVisible()).forNoMoreThan(30).seconds(),
        //    WaitUntil.the(xpathMinutos, isVisible()).forNoMoreThan(30).seconds(),
        CapturaDePantallaMovil.tomarCapturaPantalla("");
        actor.attemptsTo(ClickElementByText.clickElementByText(CONTINUAR), WaitFor.aTime(4000));
      } else {
        actor.attemptsTo(ClickElementByText.clickElementByText(VOLVER));
        //  Scroll.scrollUnaVista());

        if (!Presence.of(BTN_COMPRAR2).viewedBy(actor).resolveAll().isEmpty()) {
          actor.attemptsTo(Click.on(BTN_COMPRAR2));
        }
        if (!Presence.of(BTN_CONTRA_SALDO).viewedBy(actor).resolveAll().isEmpty()) {
          CapturaDePantallaMovil.tomarCapturaPantalla("");
          actor.attemptsTo(WaitFor.aTime(2000), Click.on(BTN_CONTRA_SALDO), WaitFor.aTime(2000));
        } else {
          CapturaDePantallaMovil.tomarCapturaPantalla("");
          actor.attemptsTo(Click.on(BTN_CONTRA_SALDO2), WaitFor.aTime(2000));
        }
      }
    }

    actor.attemptsTo(WaitFor.aTime(3000));

    if (!Presence.of(xpathPrecio).viewedBy(actor).resolveAll().isEmpty()) {

      actor.attemptsTo(WaitUntil.the(xpathPrecio, isVisible()).forNoMoreThan(30).seconds());
      //   WaitUntil.the(xpathDatos, isVisible()).forNoMoreThan(30).seconds(),
      //    WaitUntil.the(xpathMinutos, isVisible()).forNoMoreThan(30).seconds(),
      CapturaDePantallaMovil.tomarCapturaPantalla("");
      actor.attemptsTo(ClickElementByText.clickElementByText(CONTINUAR), WaitFor.aTime(4000));
    }

    if (!Presence.of(TXT_MENSAJE_SALDO_INSUFICIENTE).viewedBy(actor).resolveAll().isEmpty()) {
      CapturaDePantallaMovil.tomarCapturaPantalla("");
      actor.attemptsTo(
          ValidarTexto.validarTexto(SALDO_INSUFICIENTE),
          ClickElementByText.clickElementByText(CERRAR));

    } else {
      CapturaDePantallaMovil.tomarCapturaPantalla("");
      actor.attemptsTo(
          ValidarTexto.validarTexto(OPERACION_EXITOSA),
          ClickElementByText.clickElementByText(ACEPTAR));
    }
    WordAppium.main();
  }

  public static Performable recargaYCompraDePaquetes(User addCredentials) {
    return instrumented(RecargaYCompraDePaquetes.class, addCredentials);
  }

  private List<WebElementFacade> findAll(String s) {
    return null;
  }
}
