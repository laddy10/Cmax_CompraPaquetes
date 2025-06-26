Feature: Se requiere tomar evidencias de las consultas realizadas en CMAX

  @Estado_Inicial_De_La_linea
  Scenario Outline: Consulta inicial del estado de la linea en CMAX
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta inicial
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    Examples:
      | fila |
      | 1    |



  @Estado_Final_De_La_linea
  Scenario Outline: Consulta final del estado de la linea en CMAX
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta final
    When Se valida el resumen de la cuenta para el SC
    When Se validan las ofertas activas en consulta inicial
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso

    Examples:
      | fila |
      | 1    |


  @Validacion_Compra_Paquete
  Scenario Outline: Consulta de la compra del paquete en CMAX
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador

    Examples:
      | fila |
      | 1    |


  @Validacion_Consumos_Navegacion_Aplicaciones_Gratuitas
  Scenario Outline: Validacion de consumos navegacion aplicaciones gratuitas en CMAX
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    Then Validar contadores de uso consumo iniciales

    Examples:
      | fila |
      | 1    |


  @Validacion_Consumos_Voz
  Scenario Outline: Validacion de consumos de voz en Cmax
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se validan las ofertas activas en contadores
    Then Validar contadores de uso consumo de voz

    Examples:
      | fila |
      | 1    |


  @Validacion_Consumos_SMS
  Scenario Outline: Validacion de consumos de SMS en Cmax
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se validan las ofertas activas en contadores
    Then Validar contadores de uso consumo de SMS

    Examples:
      | fila |
      | 1    |


  @Validacion_Consumos_Datos
  Scenario Outline: Validacion de consumos de datos en Cmax
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta de compra
    When Se validan las ofertas activas en contadores
    Then Validar contadores de uso consumo de Datos

    Examples:
      | fila |
      | 1    |


  @Validacion_Compra_Y_Estado_Final_Linea
    Scenario Outline: Validación de la compra y consulta final del estado de la linea en CMAX
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta final
    When Se valida el resumen de la cuenta para el SC
    When Se valida el historial de contrato
    When Se validan los datos de compra
    When Se validan las ofertas activas
    Then Se verifican firmas y factor multiplicador

    Examples:
      | fila |
      | 1    |


  @Validacion_Cuentas_Dedicadas_Y_Acumuladores_De_Uso
  Scenario Outline: Validación de la compra y consulta final del estado de la linea en CMAX
    Given Se ingresa a la URL de CMAX <fila>
      | Ruta Excel                            | Pestana |
      | src/test/resources/data/Usuario2.xlsx | Datos   |
    When Se ingresa el usuario y la contrasena
    When Se ingresa el numero de la linea en consulta final
    When Se valida el resumen de la cuenta para el SC
    When Se validan las cuentas dedicadas
    When Se validan los acumuladores de uso


    Examples:
      | fila |
      | 1    |
