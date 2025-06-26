package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import interactions.WaitFor;

import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.PortalCautivo.IngresarNumeroConsulta;
import tasks.PortalCautivo.IngresoPortalCautivo;
import tasks.PortalCautivo.PaquetesTodoIncluido.Paquete30DiasMinIlim18GB;
import tasks.PortalCautivo.SeleccionarOpcionPaquetes;
import utils.DataDrivenExcel;
import utils.EnviaromentProperties;
import utils.Excel;
import utils.WordAppium;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CompraPaquetePortalCDefinitions {

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();

    Map<String, String> data = new HashMap<String, String>();
    private String URL;

    private static final Logger LOGGER = Logger.getLogger(WordAppium.class.getName());


    @Before
    public void initScenario(Scenario scenario) {
        OnStage.setTheStage(new OnlineCast());
        LOGGER.info("Limpiando carpeta de capturas...");
        URL = EnviaromentProperties.getProperty("url_prueba_PortalC");
        File folder = new File("Capturas");

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".jpg")) {
                    file.delete();
                }
            }
        }
    }


    @Given("^Se ingresa al navegador Chrome$")
    public void seIngresaAlNavegadorChrome() {
        theActorCalled(" ").attemptsTo(WaitFor.aTime(5000));
    }

    @When("^Se ingresa a la URL de portal cautivo$")
    public void seIngresaAURLPortalCautivo() {
        theActorInTheSpotlight().attemptsTo(IngresoPortalCautivo.ingresoPortalCautivo());

    }

    @And("^Ingresar el numero de consulta (\\d+)$")
    public void ingresarNumeroConsulta(int row, DataTable dataExcel) throws Exception {
        List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
        Excel excel = new Excel(dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
        data = dataDriverExcel.leerExcel(excel);

        theActorInTheSpotlight().attemptsTo(IngresarNumeroConsulta.ingresarNumeroConsulta(data));
    }

    @And("^Se ingresa correctamente a portal cautivo$")
    public void seIngresaCorrectamentePortalCautivo() {
        theActorInTheSpotlight().attemptsTo(
                WaitFor.aTime(5000),
                ValidarTextoQueContengaX.elTextoContiene("Saldo:"),
                ValidarTextoQueContengaX.elTextoContiene("Conoce la nueva forma de pago"));
    }

    @And("^Seleccionar la opcion Paquetes$")
    public void seleccionarOpcionPaquetes() {
        theActorInTheSpotlight().attemptsTo(SeleccionarOpcionPaquetes.SeleccionarOpcionPaquetes());
    }

    @And("^Seleccionar el paquete de PortalC$")
    public void seleccionarPaquetePortalC() {
        theActorInTheSpotlight().attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(data.get("tipoPaquete")),
                WaitFor.aTime(3000));
    }

    @And("^Se realiza la compra del paquete 30 dias con Minutos Ilimitados y 18 GB$")
    public void seRealizaCompraPaquete30DiasMinutosIlimitados18GB() {
        theActorInTheSpotlight().attemptsTo(Paquete30DiasMinIlim18GB.paquete30DiasMinIlim18GB());

    }

}