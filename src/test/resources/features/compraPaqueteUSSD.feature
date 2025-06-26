Feature: El usuario realiza compra de paquetes por el canal USSD

  @Compra_Paquete_USSD
  Scenario Outline: Llamar al *611
    Given Se realiza la llamada al numero *611#
    When Se ingresa la opcion compra de paquetes
    When Se selecciona el tipo de paquete a comprar
    When Se realiza la compra del paquete
    When Se confirma el pago de la compra


    Examples:
      | fila |
      | 1    |
