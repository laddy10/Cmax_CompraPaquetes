package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.SegmentoPage.*;
import static utils.Constants.*;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import freemarker.log.Logger;
import interactions.WaitFor;
import interactions.comunes.*;

import java.io.File;
import java.util.List;

import models.User;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.SuperAPP.*;
import tasks.SuperAPP.PaqueteVoz.PaqueteDeVoz;
import tasks.SuperAPP.PaquetesRelevo.PaqueteRelevo;
import tasks.SuperAPP.PaquetesRelevo.RelevoSMSIlimWTF25GB15Dias;
import tasks.SuperAPP.PaquetesRelevo.RelevoSMSIlimWTF6GB30Dias;
import tasks.SuperAPP.PaquetesRelevo.RelevoSMSIlimWTF800MB7Dias;
import tasks.SuperAPP.PaquetesTodoIncluido.*;
import utils.CapturaDePantallaMovil;
import utils.WordAppium;

import tasks.MiClaroApp.*;
import tasks.SuperAPP.PaqueteVoz.Paquete1000Minutos;
import tasks.SuperAPP.PaqueteVoz.Paquete300Minutos1Dia;
import tasks.SuperAPP.PaqueteVoz.Paquete300Minutos2Dias;
import tasks.SuperAPP.PaquetesApps.*;
import tasks.SuperAPP.PaquetesDeDatos.*;
import tasks.SuperAPP.PaquetesTodoIncluidoConRedes.*;

public class CompraPaqueteMiClaroAppDefinitions {

    User addCredentials;
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

    @Given("ABRIR LA SUPER APP")
    public void abrirSuperApp() {
        theActorCalled("actor")
                .attemptsTo(
                        WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                        WaitFor.aTime(2000));
    }


    @When("^EL USUARIO REALIZA EL INGRESO A LA SUPER APP$")
    public void elUsuarioRealizaIngreso(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(IngresoSuperApp.ingresoSuperApp(credentials.get(0)));
    }


    @Then("^INGRESAR AL MENU DE RECARGAS Y PAQUETES$")
    public void ingresarMenuRecargasYPaquetes() {
        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");
        theActorInTheSpotlight()
                .attemptsTo(
                        ClickElementByText.clickElementByText(RECARGA_COMPRA_PAQUETE), WaitFor.aTime(2000));
    }

    @Then("^SELECCIONAR LINEA DE COMPRA$")
    public void seleccionarLineaDeCompra(List<User> credentials) {
        theActorInTheSpotlight()
                .attemptsTo(SeleccionarLineaDeCompra.seleccionarLineaDeCompra(credentials.get(0)));
    }

    @Then("^SELECCIONAR EL PAQUETE A COMPRAR$")
    public void seleccionarPaqueteComprar(List<User> credentials) {
        theActorInTheSpotlight()
                .attemptsTo(SeleccionarPaqueteAComprar.seleccionarPaqueteAComprar(credentials.get(0)));
    }

    @Then("^SELECCIONAR EL PAQUETE TODO INCLUIDO CON REDES$")
    public void seleccionarPaqueteTodoIncluidoConRedes() {
        theActorInTheSpotlight()
                .attemptsTo(PaqueteTodoIncluidoConRedes.PaqueteTodoIncluidoConRedes());
    }

    @Then("^SELECCIONAR EL PAQUETE TODO INCLUIDO$")
    public void seleccionarPaqueteTodoIncluido() {
        theActorInTheSpotlight()
                .attemptsTo(PaqueteTodoIncluido.paqueteTodoIncluido());
    }

    @Then("^SELECCIONAR EL PAQUETE DE DATOS$")
    public void seleccionarPaqueteDeDatos() {
        theActorInTheSpotlight()
                .attemptsTo(PaqueteDeDatos.paqueteDeDatos());
    }

    @Then("^SELECCIONAR EL PAQUETE DE APPS$")
    public void seleccionarPaqueteDeApps() {
        theActorInTheSpotlight()
                .attemptsTo(PaqueteDeApps.paqueteDeApps());
    }

    @Then("^SELECCIONAR EL PAQUETE DE VOZ$")
    public void seleccionarPaqueteDeVoz() {
        theActorInTheSpotlight()
                .attemptsTo(PaqueteDeVoz.paqueteDeVoz());
    }

    @Then("^SELECCIONAR EL PAQUETE RELEVO COMUNIDAD SORDA$")
    public void seleccionarPaqueteRelevoComunidadSorda() {
        theActorInTheSpotlight()
                .attemptsTo(PaqueteRelevo.paqueteRelevo());
    }

    @Then("^VALIDAR EL PAQUETE SELECCIONADO$")
    public void validarPaqueteSeleccionado(List<User> credentials) {
        theActorInTheSpotlight()
                .attemptsTo(ValidarPaqueteSeleccionado.seleccionarLineaDeCompra(credentials.get(0)));
    }


    @Then("SALDO Y CONSUMOS DE PAQUETES")
    public void ingresoSaldoConsumoPaquetes(List<User> credentials) {
        theActorInTheSpotlight()
                .attemptsTo(SaldoYConsumoPaquetes.saldoYConsumopaquetes(credentials.get(0)));
    }


    @Then("VERIFICAR SALDOS Y CONSUMOS CORRECTOS")
    public void verificarSaldoConsumoPaquetesCorrectos() {
        theActorInTheSpotlight()
                .attemptsTo(SaldosYConsumosPaquetes.verificarSaldoConsumoPaquetesCorrectos());
    }


    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 3 DÍAS CON MINUTOS ILIMITADOS  400MB$")
    public void compraPaqueteTodoIncluido3DiasMinutosIlimitados400MB() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluido3DíasMinutosIlimitados400MB.todoIncluido3DíasMinutosIlimitados400MB());
    }


    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 50 MINUTOS SMS ILIMITADOS  W  50 MB 1 DIA$")
    public void compraPaqueteTodoIncluido350MinutosSMSIlimitadosW50MB1Dia() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluido50MinutosSMSIlimitadosW50MB1Dia
                                .todoIncluido50MinutosSMSIlimitadosW50MB1Dia());
    }

    @Then(
            "^COMPRA DEL PAQUETE TODO INCLUIDO WTF 400MB SALUD EN LINEA CON 4 BENEFICIARIOS VIG 3 DIAS$")
    public void compraPaqueteTodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias
                                .todoIncluidoWTF400MBSaludLinea4BeneficiariosVig3Dias());
    }

    @Then(
            "^COMPRA DEL PAQUETE TODO INCLUIDO 1.4GB WHATSAPP FACEBOOK Y TWITTER SALUD EN LINEA 4 BENEFICIARIOS POR 6 DIAS$")
    public void
    compraPaqueteTodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias
                                .todoIncluido14GBWhatsappFacebookTwitterSaludLinea4BeneficiariosVig6Dias());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 6 DIAS CON MINUTOS ILIMITADOS 1.4GB$")
    public void compraPaqueteTodoIncluido6DiasMinutosIlim14GB() {
        theActorInTheSpotlight()
                .attemptsTo(TodoIncluido6DiasMinutosIlim14GB.todoIncluido6DiasMinutosIlim14GB());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 7 DIAS CON MINUTOS ILIMITADOS 2GB$")
    public void compraPaqueteTodoIncluido7DiasMinutosIlim2GB() {
        theActorInTheSpotlight()
                .attemptsTo(TodoIncluido7DiasMinutosIlim2GB.todoIncluido7DiasMinutosIlim2GB());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 10 DIAS CON MINUTOS ILIMITADOS 3.5GB$")
    public void compraPaqueteTodoIncluido10DiasMinutosIlim35GB() {
        theActorInTheSpotlight()
                .attemptsTo(TodoIncluido10DiasMinutosIlim35GB.todoIncluido10DiasMinutosIlim35GB());
    }

    @Then(
            "^COMPRA DEL PAQUETE TODO INCLUIDO VOZ ILIMITADO 80GB WHATSAPP FACEBOOK TWITTER VIG 30 DIAS$")
    public void compraPaqueteTodoIncluido80GB() {
        theActorInTheSpotlight().attemptsTo(TodoIncluido80GB.todoIncluido80GB());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 20 DIAS CON MINUTOS ILIMITADOS 7.5GB$")
    public void compraPaqueteTodoIncluido20DiasMinIlim75GB() {
        theActorInTheSpotlight()
                .attemptsTo(TodoIncluido20DiasMinIlim75GB.todoIncluido20DiasMinIlim75GB());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 12GB$")
    public void compraPaqueteTodoIncluido30DiasMinIlim12GB() {
        theActorInTheSpotlight()
                .attemptsTo(TodoIncluido30DiasMinIlim12GB.todoIncluido30DiasMinIlim12GB());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 18GB$")
    public void compraPaqueteTodoIncluido30DiasMinIlim18GB() {
        theActorInTheSpotlight()
                .attemptsTo(TodoIncluido30DiasMinIlim18GB.todoIncluido30DiasMinIlim18GB());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 7 DIAS CON MINUTOS ILIMITADOS 10GB NO INCLUYE REDES$")
    public void compraPaqueteTodoIncluido7DiasMinIlim10GBNoIncluyeRedes() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluido7DiasMinIlim10GBNoIncluyeRedes
                                .todoIncluido7DiasMinIlim10GBNoIncluyeRedes());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 15 DIAS CON MINUTOS ILIMITADOS 20GB NO INCLUYE REDES$")
    public void compraPaqueteTodoIncluido15DiasMinIlim20GBNoIncluyeRedes() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluido15DiasMinIlim20GBNoIncluyeRedes
                                .todoIncluido15DiasMinIlim20GBNoIncluyeRedes());
    }

    @Then("^COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 30GB NO INCLUYE REDES$")
    public void compraPaqueteTodoIncluido30DiasMinIlim30GBNoIncluyeRedes() {
        theActorInTheSpotlight()
                .attemptsTo(
                        TodoIncluido30DiasMinIlim30GBNoIncluyeRedes
                                .todoIncluido30DiasMinIlim30GBNoIncluyeRedes());
    }

    @Then("^COMPRA DEL PAQUETE NAVEGACION ILIMITADA 2 HORAS$")
    public void compraPaqueteNavegacionIlim2Horas() {
        theActorInTheSpotlight().attemptsTo(NavegacionIlim2Horas.navegacionIlim2Horas());
    }

    @Then("^COMPRA DEL PAQUETE NAVEGACION 200MB WHATSAPP 1 DIA$")
    public void compraPaqueteNavegacion200MBWhatsapp1Dia() {
        theActorInTheSpotlight().attemptsTo(Navegacion200MBWhatsapp1Dia.navegacion200MBWhatsapp1Dia());
    }

    @Then("^COMPRA DEL PAQUETE NAVEGACIÓN 400MB WHATSAPP FACEBOOK TWITTER 1 DIA$")
    public void compraPaqueteNavegacion400MBWhatsappFacebookTwitter1Dia() {
        theActorInTheSpotlight()
                .attemptsTo(
                        Navegacion400MBWhatsappFacebookTwitter1Dia
                                .navegacion400MBWhatsappFacebookTwitter1Dia());
    }

    @Then("^COMPRA DEL PAQUETE NAVEGACIÓN 800MB WHATSAPP FACEBOOK TWITTER 3 DIAS$")
    public void compraPaqueteNavegacion800MBWhatsappFacebookTwitter3Dias() {
        theActorInTheSpotlight()
                .attemptsTo(
                        Navegacion800MBWhatsappFacebookTwitter3Dia
                                .navegacion800MBWhatsappFacebookTwitter3Dia());
    }

    @Then("^COMPRA DEL PAQUETE NAVEGACIÓN 2GB WHATSAPP FACEBOOK TWITTER 7 DIAS$")
    public void compraPaqueteNavegacion2GBWhatsappFacebookTwitter7Dias() {
        theActorInTheSpotlight()
                .attemptsTo(
                        Navegacion2GBWhatsappFacebookTwitter7Dias.navegacion2GBWhatsappFacebookTwitter7Dias());
    }

    @Then("^COMPRA DEL PAQUETE SALUD EN LINEA 1 BENEFICIARIO VIG 30 DIAS$")
    public void compraPaqueteSaludLinea1BeneficiarioVig30Dias() {
        theActorInTheSpotlight()
                .attemptsTo(SaludLinea1BeneficiarioVig30Dias.saludLinea1BeneficiarioVig30Dias());
    }

    @Then("^COMPRA DEL PAQUETE SALUD EN LINEA 2 BENEFICIARIO VIG 30 DIAS$")
    public void compraPaqueteSaludLinea2BeneficiarioVig30Dias() {
        theActorInTheSpotlight()
                .attemptsTo(SaludLinea2BeneficiarioVig30Dias.saludLinea2BeneficiarioVig30Dias());
    }

    @Then("^COMPRA DEL PAQUETE SALUD EN LINEA 4 BENEFICIARIOS VIG 30 DIAS$")
    public void compraPaqueteSaludLinea4BeneficiariosVig30Dias() {
        theActorInTheSpotlight()
                .attemptsTo(SaludLinea4BeneficiariosVig30Dias.saludLinea4BeneficiariosVig30Dias());
    }

    @Then("^COMPRA DEL PAQUETE DE WAZE POR 1 DIA$")
    public void compraPaqueteWaze1Dia() {
        theActorInTheSpotlight().attemptsTo(Waze1Dia.waze1Dia());
    }

    @Then("^COMPRA DEL PAQUETE DE INSTAGRAM 1 DIA$")
    public void compraPaqueteInstagram1Dia() {
        theActorInTheSpotlight().attemptsTo(Instagram1Dia.instagram1Dia());

    }

    @Then("^COMPRA DEL PAQUETE DE YOUTUBE POR 1 HORA$")
    public void compraPaqueteYoutube1Hora() {
        theActorInTheSpotlight().attemptsTo(Youtube1Hora.youtube1Hora());
    }

    @Then("^COMPRA DEL PAQUETE DE WAZE 7 DIAS$")
    public void compraPaqueteWaze7Dias() {
        theActorInTheSpotlight().attemptsTo(Waze7Dias.waze7Dias());
    }

    @Then("^COMPRA DEL SERVICIO CHAT WHATSAPP POR 15 DIAS$")
    public void compraServicioChatWhatsApp15Dias() {
        theActorInTheSpotlight().attemptsTo(ServicioChatWhatsApp15Dias.servicioChatWhatsApp15Dias());
    }

    @Then("^COMPRA DEL PAQUETE DE INSTAGRAM 7 DIAS$")
    public void compraPaqueteInstagram7Dias() {
        theActorInTheSpotlight().attemptsTo(Instagram7Dias.instagram7Dias());
    }

    @Then("^COMPRA DEL SERVICIO CHAT WHATSAPP POR 30 DIAS$")
    public void compraServicioChatWhatsApp30Dias() {
        theActorInTheSpotlight().attemptsTo(ServicioChatWhatsApp30Dias.servicioChatWhatsApp30Dias());
    }


    @Then("^COMPRA DEL PAQUETE 300 MINUTOS 1 DIA$")
    public void compraPaquete300Minutos1Dia() {
        theActorInTheSpotlight().attemptsTo(Paquete300Minutos1Dia.paquete300Minutos1Dia());
    }

    @Then("^COMPRA DEL PAQUETE 1000 MINUTOS$")
    public void compraPaquete1000Minutos() {
        theActorInTheSpotlight().attemptsTo(Paquete1000Minutos.paquete1000Minutos());
    }

    @Then("^COMPRA DEL PAQUETE 300 MINUTOS 2 DIAS$")
    public void compraPaquete300Minutos2Dias() {
        theActorInTheSpotlight().attemptsTo(Paquete300Minutos2Dias.paquete300Minutos2Dias());
    }

    @Then("^COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 800MB 7 DIAS$")
    public void compraPqRelevoSMSIlimWtf800MB7Dias() {
        theActorInTheSpotlight().attemptsTo(RelevoSMSIlimWTF800MB7Dias.relevoSMSIlimWTF800MB7Dias());
    }

    @Then("^COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 2.5GB 15 DIAS$")
    public void paqueteRelevoSMSIlimWtf25GB15Dias() {
        theActorInTheSpotlight().attemptsTo(RelevoSMSIlimWTF25GB15Dias.relevoSMSIlimWTF25GB15Dias());
    }

    @Then("^COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 6GB 30 DIAS$")
    public void paqueteRelevoSMSIlimWtf6GB30Dias() {
        theActorInTheSpotlight().attemptsTo(RelevoSMSIlimWTF6GB30Dias.relevoSMSIlimWTF6GB30Dias());
    }

    @Then("CLIC EN BOTON CONTRA SALDO")
    public void clicBotonContraSaldo() {
        theActorInTheSpotlight().attemptsTo(ValidarTexto.validarTexto(PAGAR_CON_MI_SALDO));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

        theActorInTheSpotlight()
                .attemptsTo(
                        ClickTextoQueContengaX.elTextoContiene(PAGAR_CON_MI_SALDO),
                        WaitFor.aTime(1000));

        CapturaDePantallaMovil.tomarCapturaPantalla("captura_pantalla");

    }

    @Then("TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES")
    public void termYCondPQTodoIncluidoRedes() {
        theActorInTheSpotlight().attemptsTo(
                TermiYCondPaquetesTodoIncluidoConRedes.termiYCondPaquetesTodoIncluidoConRedes());
    }

    @Then("SELECCIONAR TERMINOS Y CONDICIONES")
    public void seleccionarTerminosYCondiciones() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarTerminosYCondiciones.seleccionarTerminosYCondiciones());
    }

    @Then("TERMINOS Y CONDICIONES RYP")
    public void terminosYCondicionesRYP() {
        theActorInTheSpotlight().attemptsTo(TerminosYCondicionesDos.terminosYCondicionesDos());
    }

    @Then("TERMINOS Y CONDICIONES PAQUETE APPS")
    public void terminosYCondicionesPQDeApps() {
        theActorInTheSpotlight().attemptsTo(TermiYCondPaquetesDeApps.termiYCondPaquetesDeApps());
    }

    @Then("CLIC PAGAR CON MI SALDO")
    public void clicPagarConMiSaldo() {
        theActorInTheSpotlight().attemptsTo(PagarConMiSaldo.pagarConMiSaldo());
    }

    @Then("VALIDAR NOTIFICACIONES DE COMPRA")
    public void validarNotificacionCompra() {
        theActorInTheSpotlight().attemptsTo(ValidarNotificacion.deCompra());
    }
}