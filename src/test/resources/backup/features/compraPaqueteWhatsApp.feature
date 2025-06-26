Feature: El usuario realiza compra de paquetes por WhatsApp

 @Whatsapp_Compra_Paquete_Todo_Incluido
  Scenario Outline: Realizar la compra de paquetes todo incluido
    Given Ingresar a WhatsAPP
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
      | numero   |
      | <numero> |
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
      | numero   |
      | <numero> |
    And Seleccionar el tipo de paquete
      | tipoPaquete |
      | <tipoPaquete> |
    And Realizar la compra del paquete todo incluido
      | paqueteComprar | nombrePaquete |
      | <paqueteComprar> | <nombrePaquete> |
    And Selecciona opcion usa tu saldo
    Then Validar la notificacion de la compra
    And Vaciar chat

    Examples:
      | numero | tipoPaquete | paqueteComprar | nombrePaquete | paquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja3@
   |8056   |Paq. de datos   |$1.500 x 1 Día 200MB   |Paquete de datos de 200MB + WhatsApp   ||



  @Whatsapp_Compra_Paquete_Voz
  Scenario Outline: Realizar la compra de paquetes de voz
    Given Ingresar a WhatsAPP
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
      | numero   |
      | <numero> |
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
      | numero   |
      | <numero> |
    And Seleccionar el tipo de paquete
      | tipoPaquete |
      | <tipoPaquete> |
    And Realizar la compra del paquete de voz
      | paqueteComprar | nombrePaquete |
      | <paqueteComprar> | <nombrePaquete> |
    And Selecciona opcion usa tu saldo
    Then Validar la notificacion de la compra

    Examples:
      | numero | tipoPaquete |  paqueteComprar | nombrePaquete | paquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja3@
   |8056   |Paq. de datos   |$1.500 x 1 Día 200MB   |Paquete de datos de 200MB + WhatsApp   ||



  @Whatsapp_Compra_Paquete_Datos
  Scenario Outline: Realizar la compra de paquetes de datos
    Given Ingresar a WhatsAPP
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
      | numero   |
      | <numero> |
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
      | numero   |
      | <numero> |
    And Seleccionar el tipo de paquete
      | tipoPaquete |
      | <tipoPaquete> |
    And Realizar la compra de paquetes datos
      | paqueteComprar | nombrePaquete |
      | <paqueteComprar> | <nombrePaquete> |
    And Selecciona opcion usa tu saldo
   Then Validar la notificacion de la compra

    Examples:
      | numero | tipoPaquete |  paqueteComprar | nombrePaquete | paquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja3@
   |8056   |Paq. de datos   |$1.500 x 1 Día 200MB   |Paquete de datos de 200MB + WhatsApp   ||



  @Whatsapp_Compra_Paquete_Apps
  Scenario Outline: Realizar la compra de paquetes de Apps
    Given Ingresar a WhatsAPP
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
      | numero   |
      | <numero> |
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
      | numero   |
      | <numero> |
    And Seleccionar el tipo de paquete
      | tipoPaquete |
      | <tipoPaquete> |
    And Seleccionar el paquete de Apps
      | paquete |
      | <paquete> |
    And Seleccionar el paquete de compra
      | paqueteComprar | nombrePaquete |
      | <paqueteComprar> | <nombrePaquete> |
    And Selecciona opcion usa tu saldo
    Then Validar la notificacion de la compra

    Examples:
      | numero | tipoPaquete |  paqueteComprar | nombrePaquete | paquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja3@
   |8056   |Paq. de datos   |$1.500 x 1 Día 200MB   |Paquete de datos de 200MB + WhatsApp   ||



  @Whatsapp_Compra_Paquete_Internacional
  Scenario Outline: Realizar la compra de paquetes internacionales
    Given Ingresar a WhatsAPP
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
      | numero   |
      | <numero> |
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
      | numero   |
      | <numero> |
    And Seleccionar el tipo de paquete
      | tipoPaquete |
      | <tipoPaquete> |
    And Seleccionar el paquete internacional
      | paquete |
      | <paquete> |
    And Seleccionar el paquete de compra
      | paqueteComprar | nombrePaquete |
      | <paqueteComprar> | <nombrePaquete> |
    And Seleccionar opcion usar saldo
    Then Validar la notificacion de la compra

    Examples:
      | numero | tipoPaquete |  paqueteComprar | nombrePaquete | paquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja3@
   |8056   |Paq. de datos   |$1.500 x 1 Día 200MB   |Paquete de datos de 200MB + WhatsApp   ||



  @Whatsapp_Compra_Paquete_Relevo
  Scenario Outline: Realizar la compra de paquetes comunidad sorda
    Given Ingresar a WhatsAPP
    When Validar Version de la App
    And Buscar el chat de Claro Colombia
    And Iniciar el chat con Claro Colombia
    And Seleccionar linea de consulta
      | numero   |
      | <numero> |
    And Validar politica de tratamientos de datos
    And Consultar saldo de la linea
      | numero   |
      | <numero> |
    And Seleccionar el tipo de paquete
      | tipoPaquete |
      | <tipoPaquete> |
    And Ingresar al boton Selecciona paquete Relevo
    And Seleccionar el paquete de compra
      | paqueteComprar | nombrePaquete |
      | <paqueteComprar> | <nombrePaquete> |
    And Seleccionar opcion contra saldo pq relevo
    Then Validar la notificacion de la compra

    Examples:
      | numero | tipoPaquete |  paqueteComprar | nombrePaquete | paquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja3@
   |8056   |Paq. de datos   |$1.500 x 1 Día 200MB   |Paquete de datos de 200MB + WhatsApp   ||
