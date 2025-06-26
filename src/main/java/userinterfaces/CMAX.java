package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CMAX {

  public static final Target TXT_USUARIO =
      Target.the("Caja de texto para ingresar el nombre del usuario").located(By.id("j_username"));

  public static final Target TXT_CONTRASENA =
      Target.the("Caja de texto para ingresar la contraseña del usuario")
          .located(By.id("j_password"));

  public static final Target BTN_OK = Target.the("Boton de OK").located(By.id("submitv"));

  public static final Target BTN_BUSCAR =
      Target.the("Boton buscar").located(By.name("SearchButton"));

  public static final Target TXT_NUMERO_CONSULTA =
      Target.the("Texto de la linea consultada")
          .located(By.xpath("//*[@id=\"kibar\"]/table/tbody/tr/td/span[5]"));

  public static final Target BTN_OFERTAS =
      Target.the("Boton de ofertas")
          .located(By.xpath("//*[@id='ContractNode_sl']/td[2]/table[3]/tbody/tr/td[2]/a"));

  public static final Target BTN_HISTORIAL_CONTRATO =
      Target.the("Boton de historial de contrato")
          .located(By.xpath("//*[@id='ContractNode_sl']/td[2]/table[5]/tbody/tr/td[2]/a"));

  public static final Target TXT_FECHA =
      Target.the("Caja de texto para ingresar la fecha periodo desde")
          .located(By.id("Criteria_PeriodFrom"));

  public static final Target BTN_RESUMEN_CUENTA =
      Target.the("Boton de resumen de la cuenta")
          .located(By.xpath("//*[@id='ContractNode_sl']/td[2]/table[2]/tbody/tr/td[2]/a"));

  public static final Target TXT_AJUSTE =
      Target.the("Texto Categoria Ajuste")
          .located(
              By.xpath("//*[@id='criteriaContent']/table/tbody/tr[2]/td/div/select/option[1]"));

  public static final Target TXT_FECHA2 =
      Target.the("Caja de texto para ingresar la fecha periodo hasta")
          .located(By.xpath("//*[@id='Criteria_PeriodTo']"));

  public static final Target BTN_IMPORTE =
      Target.the("Boton de texto importe")
          .located(By.xpath("//*[@id='ContractHistoryResults']/thead/tr/th[6]/a"));
  public static final Target BTN_IMPORTE2 =
      Target.the("Boton de texto importe despues de dar un click")
          .located(By.xpath("//*[@id='ContractHistoryResults']/tbody[1]/tr/th[6]/a"));

  public static final Target TBL_DATOS =
      Target.the("Tabla de la información de compras").located(By.xpath("//tbody[2]/tr"));

  public static final Target BTN_CLIENTES =
      Target.the("Boton de clientes").located(By.xpath("//*[@id=\"CustomersNode\"]/td[2]/a"));

  public static final Target BTN_BUSCAR_CLIENTE =
      Target.the("Boton de buscar a clientes")
          .located(By.xpath("//*[@id=\"CustomersNode_sl\"]/td[2]/table/tbody/tr/td[2]/a"));

  public static final Target TXT_MSISDN =
      Target.the("Caja de texto para ingresar numero").located(By.xpath("//*[@id=\"DIRNUM\"]"));

  public static final Target TXT_MSISDN_BUSCADO =
      Target.the("Texto de la linea consultada")
          .located(By.xpath("//*[@id=\"SearchResults\"]/tbody[2]/tr/td[2]/a"));

  public static final Target BTN_FECHA_INICIO =
      Target.the("Boton fecha de inicio").located(By.xpath("//*[@id=\"Offers\"]/thead/tr/th[9]"));

  public static final Target BTN_FECHA_INICIO2 =
      Target.the("Boton fecha de inicio 2")
          .located(By.xpath("//*[@id=\"Offers\"]/tbody[1]/tr/th[9]"));

  public static final Target TXT_FECHA_EXPIRACION =
      Target.the("Texto Fecha de expiración de la tarifa del servicio")
          .located(By.xpath("//*[@id=\"lifecycleContent\"]/table/tbody/tr[1]/td[1]/div/span"));

  public static final Target TXT_PLAN_TARIFA =
      Target.the("Texto Plan de tarifas")
          .located(By.xpath("//*[@id=\"rateplanContent\"]/table/tbody/tr[4]/td[2]/div/span"));

  public static final Target TXT_FECHA_INICIO =
      Target.the("Texto Fecha de inicio")
          .located(By.xpath("//*[@id=\"Offers\"]/tbody[2]/tr[1]/td[9]/span/div/span"));

  public static final Target TXT_FECHA_EXPIRACION2 =
      Target.the("Texto Fecha de expiración cuando arroja una fecha especifica")
          .located(By.xpath("//*[@id=\"Offers\"]/tbody[2]/tr[1]/td[11]"));

  public static final Target TXT_FECHA_HORA =
      Target.the("Texto de Fecha y hora en Ajuste detalles")
          .located(
              By.xpath(
                  "//*[@id=\"general_formTag_SectionContent\"]/table[1]/tbody/tr[1]/td[2]/div/span"));

  public static final Target TXT_ESTADO_CUENTA =
      Target.the("Texto de Estado de la cuenta en Ajuste detalles ")
          .located(
              By.xpath(
                  "//*[@id=\"general_formTag_SectionContent\"]/table[1]/tbody/tr[2]/td[2]/div"));

  public static final Target TXT_IMPORTE_AJUSTE =
      Target.the("Texto de Importe de ajuste en Ajuste detalles ")
          .located(
              By.xpath(
                  "//*[@id=\"general_formTag_SectionContent\"]/table[1]/tbody/tr[3]/td[2]/div"));

  public static final Target TXT_CUENTA_PRINCIPAL =
      Target.the("Texto de Cuenta principal en Ajuste detalles ")
          .located(
              By.xpath(
                  "//*[@id=\"general_formTag_SectionContent\"]/table[1]/tbody/tr[2]/td[5]/div"));

  public static final Target TXT_DATOS_EXTERNOS1 =
      Target.the("Texto de Datos externos 1 en Ajuste detalles ")
          .located(
              By.xpath(
                  "//*[@id=\"general_formTag_SectionContent\"]/table[1]/tbody/tr[19]/td[2]/div"));

  public static final Target TXT_DATOS_EXTERNOS2 =
      Target.the("Texto de Datos externos 2 en Ajuste detalles ")
          .located(
              By.xpath(
                  "//*[@id=\"general_formTag_SectionContent\"]/table[1]/tbody/tr[19]/td[5]/div"));

  public static final Target LGO_CLARO =
      Target.the("Logo de Claro ").located(By.xpath("//*[@id=\"hNavBar\"]"));

  public static final Target TBL_OFERTAS =
      Target.the("Tabla de la información de Ofertas").located(By.xpath("//tbody[2]/tr"));

  public static final Target BTN_CERRAR2 =
      Target.the("Boton cerra de Ofertas").located(By.id("close_formTag_CloseButton"));

  public static final Target CJA_PRODUCT_ATTRIBUTES =
      Target.the("Boton de Product attributes").located(By.xpath("//tbody//td[7]/a"));

  public static final Target TXT_FIRMAS =
      Target.the("Texto de firmas")
          .located(By.xpath("//*[@id=\"OfferAttributes\"]/tbody/tr[2]/td[5]"));

  public static final Target TXT_FACTOR_MULTIPLICADOR =
      Target.the("Texto de factor multiplicador")
          .located(By.xpath("//*[@id=\"OfferAttributes\"]/tbody/tr[1]/td[5]"));

  public static final Target TXT_FIRMAS2 =
      Target.the("Texto de firmas cuando no hay factor multiplicador")
          .located(By.xpath("//*[@id=\"OfferAttributes\"]/tbody/tr/td[5]"));

  public static final Target TBL_DETALLE_PRODUCTOS =
      Target.the("Tabla de Detalles del producto")
          .located(By.xpath("//*[@id=\"Products\"]/tbody/tr"));

  public static final Target BTN_CONTADORES_USO =
      Target.the("Boton de contadores de uso y umbrales")
          .located(By.xpath("//*[@id=\"ContractNode_sl\"]/td[2]/table[4]/tbody/tr/td[2]"));

  public static final Target TXT_CONTADORES_USO =
      Target.the("Texto Contadores de uso y umbrales")
          .located(By.xpath("//*[@id=\"content\"]/div[2]/h1/span"));

  public static final Target TBL_CONTADORES_USO =
      Target.the("Tabla Contadores de uso ")
          .located(By.xpath("//*[@id=\"UsageCounters\"]/tbody/tr"));

  public static final Target TXT_FECHA_INICIO_CONTADORES =
      Target.the("Texto Fecha de inicio de contadores de uso")
          .located(By.xpath("//*[@id=\"UsageCounterProducts\"]/tbody/tr/td[4]/span/div/span"));

  public static final Target TXT_FECHA_EXPIRACION_CONTADORES =
      Target.the("Texto Fecha de expiración de contadores de uso")
          .located(By.xpath("//*[@id=\"UsageCounterProducts\"]/tbody/tr/td[5]/span/div/span"));

  public static final Target TXT_VALOR_CONTADOR =
      Target.the("Texto Valor actual contador de uso")
          .located(By.xpath("//*[@id=\"UsageCounterProducts\"]/tbody/tr/td[6]/div"));

  public static final Target TBL_VALORES_CONTADORES =
      Target.the("Tabla Valores del contador de uso privado")
          .located(By.xpath("//*[@id=\"UsageCounterProducts\"]/tbody/tr"));

  public static final Target LBL_SALDO_TOTAL =
      Target.the("Texto Saldo total (segunda moneda)")
          .located(By.xpath("//*[@id=\"DedicatedAccounts\"]/thead/tr/th[17]/a"));

  public static final Target BTN_CUENTAS_DEDICADAS =
      Target.the("Boton Cuentas dedicadas")
          .located(By.id("accountsTabContainer_tablist_accountsTabContainer.dedicatedAccountsTab"));

  public static final Target BTN_ACUMULADORES_DE_USO =
      Target.the("Boton Acumuladores de uso")
          .located(By.id("accountsTabContainer_tablist_accountsTabContainer.accumulatorsTab"));

  public static final Target BTN_NEXT_CMAX =
      Target.the("Boton Siguente triangulo")
          .located(By.xpath("//*[@id=\"accumulatorAccountsTable\"]/div/div[2]/a/img"));

  public static final Target BTN_NEXT2 =
      Target.the("Boton Siguiente segunda pagina")
          .located(By.xpath("//*[@id=\"accumulatorAccountsTable\"]/div/div[2]/a[3]/img"));

}