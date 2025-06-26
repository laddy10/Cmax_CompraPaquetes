package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.USSD.*;
import utils.DataDrivenExcel;
import utils.DataReader;
import utils.WordAppium;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CompraPaquetesUSDDefinitions {

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();

    Map<String, String> data = new HashMap<String, String>();

    private static final Logger LOGGER = Logger.getLogger(WordAppium.class.getName());


    @Before
    public void initScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        LOGGER.info("Limpiando carpeta de capturas...");
        File folder = new File("Capturas");

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".jpg")) {
                    file.delete();
                }
            }
        }
    }

    String filePath = "src/test/resources/data/Usuario.xlsx";
    String sheetName = "Datos";


    @Given("^Se realiza la llamada al numero (.*)$")
    public void realizaUnaLlamadaAlNumero(String numero) {

        theActorCalled("").attemptsTo(RealizarLlamada.alNumero(numero));


    }

    @When("^Se ingresa la opcion compra de paquetes$")
    public void seIngresaOpcionCompraPaquetes() {
        theActorInTheSpotlight().attemptsTo(SeleccionarConsultaSaldo.selectOption("Consulta de saldo y consumos"));
        theActorInTheSpotlight().attemptsTo(SeleccionarConsultaSaldo.selectOption("Consulta de saldo y numero"));
        theActorInTheSpotlight().attemptsTo(SeleccionarCompraPaquetes.selectOption("Compra tu paquete"));

    }

    @When("^Se selecciona el tipo de paquete a comprar$")
    public void seSeleccionaElTipoDePaqueteAComprar() {
        int rowNumber = 1; // El número de fila que contiene el valor de la opción en el archivo de Excel
        int columnNumber = 0; // El número de columna que contiene el valor de la opción en el archivo de Excel

        String opcionCompra = DataReader.getCellValue(filePath, sheetName, rowNumber, columnNumber);
        //  System.out.println("Paquete buscado: " + opcionCompra);
        theActorInTheSpotlight().attemptsTo(CompraPaquete.comprapaquete(opcionCompra));

    }


    @When("^Se realiza la compra del paquete$")
    public void seRealizaLaCompraDelPaquete() {
        int rowNumber = 1; // El número de fila que contiene el valor de la opción en el archivo de Excel
        int columnNumber = 1; // El número de columna que contiene el valor de la opción en el archivo de Excel

        String paqueteComprar = DataReader.getCellValue(filePath, sheetName, rowNumber, columnNumber);
        //  System.out.println("Paquete a comprar: " + paqueteComprar);

        theActorInTheSpotlight().attemptsTo(RealizarCompraPaquete.comprapaquete(paqueteComprar));
    }


    @When("^Se confirma el pago de la compra$")
    public void seConfirmaElPagoDeLaCompra() {
        //   theActorInTheSpotlight().attemptsTo(PagoCompra.pagocompra());
        theActorInTheSpotlight().attemptsTo(SeleccionarOpcionPago.comprapaquete("Descuento de saldo"));
        theActorInTheSpotlight().attemptsTo(ValidarNotificacion.deCompra());


    }
}
