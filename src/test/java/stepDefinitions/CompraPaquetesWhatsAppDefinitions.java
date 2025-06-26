package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import interactions.WaitFor;
import interactions.comunes.Atras;
import interactions.comunes.ClickTextoQueContengaX;
import interactions.comunes.ValidarTexto;
import interactions.comunes.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;
import questions.ValidarElemento;
import tasks.WhatsApp.*;
import tasks.WhatsApp.Apps.SeleccionarPqApps;
import tasks.WhatsApp.Internacional.SeleccionarPqInternacional;
import tasks.WhatsApp.Internacional.SeleccionarUsarSaldo;
import tasks.WhatsApp.TodoIncluido.ComprarPaqueteTodoIncluido;
import utils.WordAppium;

import java.io.File;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.WhatsAppPage.*;
import static userinterfaces.WhatsAppPage.BTN_MAS_OPCIONES;
import static utils.Constants.*;

public class CompraPaquetesWhatsAppDefinitions {

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

    @Given("Ingresar a WhatsAPP")
    public void ingresarWhatsapp() {
        theActorCalled(" ").attemptsTo
                (WaitForResponse.withText(PREGUNTAR_META));
        theActorInTheSpotlight().attemptsTo(
                ValidarTexto.validarTexto(PREGUNTAR_META));
        theActorInTheSpotlight().should(seeThat(
                ValidarElemento.esVisible(LBL_WHATSAPP)));
    }

    @When("^Validar Version de la App$")
    public void validarVersionApp() {
        theActorInTheSpotlight().attemptsTo(ValidarVersionApp.validarVersionApp());
    }

    @And("^Buscar el chat de Claro Colombia$")
    public void buscarChatClaro() {
        theActorInTheSpotlight().attemptsTo(BuscarChatClaro.buscarChatClaro());
    }

    @And("^Iniciar el chat con Claro Colombia$")
    public void iniciarChatClaro() {
        theActorInTheSpotlight().attemptsTo(IniciarChatClaro.iniciarChatClaro());
    }

    @And("^Seleccionar linea de consulta$")
    public void seleccionarLineaConsulta(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(SeleccionarLineaConsulta.seleccionarLineaConsulta(credentials.get(0)));
    }

    @And("^Validar politica de tratamientos de datos$")
    public void validarPoliticaTratamiendoDatos() {
        theActorInTheSpotlight().attemptsTo(ValidarTratamientoDatos.validarTratamientoDatos());
    }

    @And("^Consultar saldo de la linea$")
    public void consultarSaldoLinea(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(ConsultarSaldoLinea.consultarSaldoLinea(credentials.get(0)));
    }

    @And("^Seleccionar el tipo de paquete$")
    public void seleccionarTipoPaquete(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(SeleccionarTipoPaquete.seleccionarTipoPaquete(credentials.get(0)));
    }

    @And("^Realizar la compra del paquete todo incluido$")
    public void realizarCompraPqTodoIncluido(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(ComprarPaqueteTodoIncluido.comprarPaqueteTodoIncluido(credentials.get(0)));
    }


    @And("^Ingresar al boton Selecciona paquete Relevo$")
    public void ingresarBotonSeleccionaPqRelevo() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_SELECCIONA_PQ_RELEVO),
                WaitFor.aTime(2000));
    }

    @And("^Seleccionar el paquete de Apps$")
    public void seleccionarPqApps(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(SeleccionarPqApps.seleccionarPqApps(credentials.get(0)));
    }

    @And("^Seleccionar el paquete internacional$")
    public void seleccionarPqInternacional(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(SeleccionarPqInternacional.seleccionarPqInternacional(credentials.get(0)));
    }

    @And("^Seleccionar el paquete de compra$")
    public void seleccionarPaqueteCompra(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(SeleccionarPaqueteCompra.comprarPaqueteVoz(credentials.get(0)));
    }

    @And("^Realizar la compra del paquete de voz$")
    public void realizarCompraPaqueteVoz(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_SELECCIONA_PQ_VOZ),
                WaitFor.aTime(3000),
                SeleccionarPaqueteCompra.comprarPaqueteVoz(credentials.get(0)));
    }

    @And("^Realizar la compra de paquetes datos$")
    public void realizarCompraPaqueteDtos(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_SELECCIONA_PQ_DATOS),
                WaitFor.aTime(3000),
                SeleccionarPaqueteCompra.comprarPaqueteVoz(credentials.get(0)));
    }

    @And("^Seleccionar opcion usar saldo$")
    public void seleccionarOpcionUsarSaldo() {
        theActorInTheSpotlight().attemptsTo(SeleccionarUsarSaldo.seleccionarUsarSaldo());
    }

    @And("^Selecciona opcion usa tu saldo$")
    public void seleccionarUsaTuSaldo() {
        theActorInTheSpotlight().attemptsTo(SeleccionUsaTuSaldo.seleccionUsaTuSaldo());
    }


    @And("^Seleccionar opcion contra saldo pq relevo$")
    public void seleccionarContraSaldPqRelevo() {
        theActorInTheSpotlight().attemptsTo(SeleccionarContraSaldoRelevo.seleccionarContraSaldoRelevo());
    }

    @Then("^Validar la notificacion de la compra$")
    public void validarNotificacionCompra() {
        theActorInTheSpotlight().attemptsTo(NotificacionCompra.notificacionCompra());
    }

    @And("^Vaciar chat$")
    public void vaciarChat() {
        theActorInTheSpotlight().attemptsTo(
                Atras.irAtras(),
                Enter.theValue(SALIR).into(TXT_ENVIAR_MENSAJE),
                Click.on(BTN_ENVIAR),
                Click.on(BTN_MAS_OPCIONES),
                ClickTextoQueContengaX.elTextoContiene(MAS),
                ClickTextoQueContengaX.elTextoContiene(VACIAR_CHAT),
                ClickTextoQueContengaX.elTextoContiene(VACIAR_CHAT));

    }

}