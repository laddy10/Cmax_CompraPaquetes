Feature: Realizar compra de paquetes por Portal Cautivo

 #*********************************** Paquetes Todo Incluido ******************************************#

  @PORTAL_CAUTIVO_01
  Scenario Outline: Compra de paquete 30 dias con Minutos Ilimitados y 18 GB
    Given Se ingresa al navegador Chrome
    When Se ingresa a la URL de portal cautivo
    And Ingresar el numero de consulta <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | PortalC   |
    And Se ingresa correctamente a portal cautivo
    And Seleccionar la opcion Paquetes
    And Seleccionar el paquete de PortalC
    Then Se realiza la compra del paquete 30 dias con Minutos Ilimitados y 18 GB



    Examples:
      | fila |
      | 1    |
