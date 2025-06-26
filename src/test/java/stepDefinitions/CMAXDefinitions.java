package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.log.Logger;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.Cmax.*;
import utils.DataDrivenExcel;
import utils.EnviaromentProperties;
import utils.Excel;
import utils.WordAppium;

public class CMAXDefinitions {

    DataDrivenExcel dataDriverExcel = new DataDrivenExcel();
    Map<String, String> data = new HashMap<String, String>();
    private String URL;
    private ChromeDriver driver;
    private static final Logger LOGGER = Logger.getLogger(WordAppium.class.getName());

    @Managed
    private Actor user = Actor.named("user");

    @Before
    public void getConfiguration() {

        OnStage.setTheStage(new OnlineCast());
        URL = EnviaromentProperties.getProperty("url_prueba");
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

    @Given("^Se ingresa a la URL de CMAX (\\d+)$")
    public void seIngresaALaURLDeCMAX(int row, DataTable dataExcel) throws Exception {
        List<Map<String, String>> dataFeature = dataExcel.asMaps(String.class, String.class);
        Excel excel =
                new Excel(
                        dataFeature.get(0).get("Ruta Excel"), dataFeature.get(0).get("Pestana"), true, row);
        data = dataDriverExcel.leerExcel(excel);

        theActorCalled("cmax").attemptsTo(Open.url(URL));
    }

    @When("^Se ingresa el usuario y la contrasena$")
    public void seIngresaElUsuarioYLaContrasena() {
        theActorInTheSpotlight().attemptsTo(RealizarIngreso.realizarIngreso(data));
    }

    @When("^Se ingresa el numero de la linea en consulta inicial$")
    public void seIngresaElNumeroDeLaLineaAConsultarConsultaInicial() {
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaInicial.ingresarNumeroConsultaInicial(data));
    }

    @When("^Se ingresa el numero de la linea en consulta final$")
    public void seIngresaElNumeroDeLaLineaAConsultarConsultaFinal() {
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaFinal.ingresarNumeroConsultaInicial(data));
    }

    @When("^Se valida el resumen de la cuenta para el SC$")
    public void seValidaElResumenDeLaCuentaParaElSC() {
        theActorInTheSpotlight().attemptsTo(ResumenDeCuenta.resumenDeCuenta());
    }

    @When("^Se validan las ofertas activas en consulta inicial$")
    public void seValidanLasOfertasActivasEnConsultaInicial() {
        theActorInTheSpotlight()
                .attemptsTo(ValidarOfertaConsultaInicial.validarofertaConsultaInicial());
    }

    @When("^Se validan las ofertas activas en contadores$")
    public void seValidanLasOfertasActivasEnContadores() {
        theActorInTheSpotlight()
                .attemptsTo(ValidarOfertaConsultaContadores.validarofertaConsultaInicial());
    }

    @When("^Se ingresa el numero de la linea en consulta de compra$")
    public void seIngresaElNumeroDeLaLineaEnConsultaDeCompra() {
        theActorInTheSpotlight()
                .attemptsTo(IngresarNumeroConsultaCompra.ingresarnumeroConsultaCompra(data));
    }

    @When("^Se validan las ofertas activas$")
    public void seValidanLasOfertasActivas() {
        theActorInTheSpotlight().attemptsTo(ValidarOfertas.validarOfertas(data));
    }

    @When("^Se valida el historial de contrato$")
    public void seValidaElHistorialDeContrato() {
        theActorInTheSpotlight().attemptsTo(HistorialDeContrato.historialDeContrato(data));
    }

    @When("^Se validan los datos de compra$")
    public void seValidanLosDatosDeCompra() {
        theActorInTheSpotlight().attemptsTo(ValidarDatosCompra.validardatosCompra(data));
    }

    @Then("^Se verifican firmas y factor multiplicador$")
    public void seVerificanFirmasYFactorMultiplicador() {
        theActorInTheSpotlight()
                .attemptsTo(ValidarFirmaYFactorMultiplicador.validarfirmaYFactorMultiplicador());
    }

    @Then("^Validar contadores de uso consumo de voz$")
    public void validarContadoresDeUsoConsumoDeVoz() {
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeVoz.contadordeUsoConsumoDeVoz(data));
    }

    @Then("^Validar contadores de uso consumo iniciales$")
    public void validarContadoresDeUsoConsumoIniciales() {
        theActorInTheSpotlight().attemptsTo(ContadorUsoIniciales.contadorusoIniciales());
    }

    @Then("^Validar contadores de uso consumo de SMS$")
    public void validarContadoresDeUsoConsumoDeSMS() {
        theActorInTheSpotlight().attemptsTo(ContadorDeUsoConsumoDeSMS.contadordeUsoConsumoDeSMS(data));
    }

    @Then("^Validar contadores de uso consumo de Datos$")
    public void validarContadoresDeUsoConsumoDeDatos() {
        theActorInTheSpotlight()
                .attemptsTo(ContadorDeUsoConsumoDeDatos.contadordeUsoConsumoDeDatos(data));
    }

    @When("^Se validan las cuentas dedicadas$")
    public void seValidanLasCuentasDedicadas() {
        theActorInTheSpotlight().attemptsTo(CuentasDedicadas.cuentasDedicadas());
    }

    @When("^Se validan los acumuladores de uso$")
    public void seValidanLosAcumuladoresDeUso() {
        theActorInTheSpotlight().attemptsTo(AcumuladoresDeUso.acumuladoresDeUso());
    }
}