Feature: El usuario realiza compra de paquetes por la super APP


  #---------- Paquetes todo incluido con redes ------------#


  @SUPER_APP_01
  Scenario Outline: Realizar la compra del paquete Todo incluido 3 Días con Minutos Ilimitados + 400MB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 3 DÍAS CON MINUTOS ILIMITADOS  400MB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero   | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_02
  Scenario Outline: Realizar la compra del paquete Todo Incluido 50 minutos + SMS Ilimitados + W + 50 MB 1 Dia
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 50 MINUTOS SMS ILIMITADOS  W  50 MB 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_03
  Scenario Outline: Realizar la compra del paquete Todo Incluido + WTF + 400MB+ Salud en Línea con 4 beneficiarios Vig 3 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO WTF 400MB SALUD EN LINEA CON 4 BENEFICIARIOS VIG 3 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_04
  Scenario Outline: Realizar la compra del paquete Todo Incluido 1.4GB + WhatsApp, Facebook y Twitter + Salud en Linea 4 beneficiarios por 6 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 1.4GB WHATSAPP FACEBOOK Y TWITTER SALUD EN LINEA 4 BENEFICIARIOS POR 6 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_05
  Scenario Outline: Realizar la compra del paquete Todo Incluido 6 Dias con Minutos Ilimitados + 1.4GB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 6 DIAS CON MINUTOS ILIMITADOS 1.4GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_06
  Scenario Outline: Realizar la compra del paquete Todo Incluido 7 Dias con Minutos Ilimitados + 2GB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 7 DIAS CON MINUTOS ILIMITADOS 2GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_07
  Scenario Outline: Realizar la compra del paquete Todo incluido 10 Dias con Minutos Ilimitados + 3.5GB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 10 DIAS CON MINUTOS ILIMITADOS 3.5GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero  | nombreUsuario  | tipoPaquete     |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_08
  Scenario Outline: Realizar la compra del paquete Todo incluido Voz Ilimitado + 80GB + WhatsApp Facebook Twitter,Vig 30 dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO VOZ ILIMITADO 80GB WHATSAPP FACEBOOK TWITTER VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_09
  Scenario Outline: Realizar la compra del paquete Todo Incluido 20 Dias con Minutos Ilimitados + 7.5GB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 20 DIAS CON MINUTOS ILIMITADOS 7.5GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email  | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_10
  Scenario Outline: Realizar la compra del paquete Todo Incluido 30 Días con Minutos Ilimitados + 12GB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 12GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete  |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_11
  Scenario Outline: Realizar la compra del paquete Todo incluido 30 Días con Minutos Ilimitados + 18GB
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 18GB
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE TODO INCLUIDO CON REDES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|



      #---------- Paquetes todo incluido ------------#


  @SUPER_APP_12
  Scenario Outline: Realizar la compra del paquete Todo Incluido 7 Dias con Minutos Ilimitados 10GB No incluye redes
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 7 DIAS CON MINUTOS ILIMITADOS 10GB NO INCLUYE REDES
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email  | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_13
  Scenario Outline: Realizar la compra del paquete Todo Incluido 15 Dias con Minutos Ilimitados 20GB No incluye redes
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 15 DIAS CON MINUTOS ILIMITADOS 20GB NO INCLUYE REDES
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_14
  Scenario Outline: Realizar la compra del paquete Todo Incluido 30 Dias con Minutos Ilimitados 30GB No incluye redes
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE TODO INCLUIDO 30 DIAS CON MINUTOS ILIMITADOS 30GB NO INCLUYE REDES
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|




     #---------- Paquetes de datos ------------#


  @SUPER_APP_15
  Scenario Outline: Realizar la compra del paquete Navegacion Ilimitada 2 horas
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
     | numero |
     |<numero>|
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE NAVEGACION ILIMITADA 2 HORAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES RYP
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_16
  Scenario Outline: Realizar la compra del paquete Navegación 200MB WhatsApp 1 dia
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE NAVEGACION 200MB WHATSAPP 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_17
  Scenario Outline: Realizar la compra del paquete Navegación 400MB+WhatsApp Facebook Twitter 1 dia
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE NAVEGACIÓN 400MB WHATSAPP FACEBOOK TWITTER 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_18
  Scenario Outline: Realizar la compra del paquete Navegación 800MB+WhatsApp Facebook Twitter 3 Días
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE NAVEGACIÓN 800MB WHATSAPP FACEBOOK TWITTER 3 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_19
  Scenario Outline: Realizar la compra del paquete Navegación 2GB+WhatsApp Facebook Twitter 7 Días
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE NAVEGACIÓN 2GB WHATSAPP FACEBOOK TWITTER 7 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|




    #---------- Paquetes apps ------------#


  @SUPER_APP_20
  Scenario Outline: Realizar la compra del paquete Salud en Linea 1 beneficiario Vig 30 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE SALUD EN LINEA 1 BENEFICIARIO VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_21
  Scenario Outline: Realizar la compra del paquete Salud en Linea 2 beneficiario Vig 30 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE SALUD EN LINEA 2 BENEFICIARIO VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_22
  Scenario Outline: Realizar la compra del paquete Salud en Linea 4 beneficiario Vig 30 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE SALUD EN LINEA 4 BENEFICIARIOS VIG 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_23
  Scenario Outline: Realizar la compra del Paquete de WAZE por 1 Día
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE DE WAZE POR 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_24
  Scenario Outline: Realizar la compra del Paquete de Instagram 1 Día
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE DE INSTAGRAM 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_25
  Scenario Outline: Realizar la compra del Paquete de YouTube por 1 hora
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE DE YOUTUBE POR 1 HORA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_26
  Scenario Outline: Realizar la compra del Paquete de Waze 7 dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE DE WAZE 7 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES RYP
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_27
  Scenario Outline: Realizar la compra del Servicio Chat WhatsApp por 15 días
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL SERVICIO CHAT WHATSAPP POR 15 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_28
  Scenario Outline: Realizar la compra del Paquete de Instagram 7 dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE DE INSTAGRAM 7 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_29
  Scenario Outline: Realizar la compra del Servicio Chat WhatsApp por 30 días
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL SERVICIO CHAT WHATSAPP POR 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES PAQUETE APPS
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


    #---------- Paquetes de voz ------------#


  @SUPER_APP_30
  Scenario Outline: Realizar la compra del Paquete 300 Minutos 1 día
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE 300 MINUTOS 1 DIA
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES RYP
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_31
  Scenario Outline: Realizar la compra del Paquete 1000 Minutos
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE 1000 MINUTOS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES RYP
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_32
  Scenario Outline: Realizar la compra del Paquete 300 Minutos 2 días
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE 300 MINUTOS 2 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then TERMINOS Y CONDICIONES RYP
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


        #---------- Paquetes Relevo comunidad sorda ------------#


  @SUPER_APP_33
  Scenario Outline: Realizar la compra del Paquete Relevo SMS Ilimitados + WTF + 800MB 7 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 800MB 7 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_34
  Scenario Outline: Realizar la compra del Paquete Relevo SMS Ilimitados + WTF + 2.5GB 15 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 2.5GB 15 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|


  @SUPER_APP_35
  Scenario Outline: Realizar la compra del Paquete Relevo SMS Ilimitados + WTF + 6GB 30 Dias
    Given ABRIR LA SUPER APP
    When EL USUARIO REALIZA EL INGRESO A LA SUPER APP
      | email   | password   | nombreUsuario   |
      | <email> | <password> | <nombreUsuario> |
    Then INGRESAR AL MENU DE RECARGAS Y PAQUETES
    Then SELECCIONAR LINEA DE COMPRA
      | numero   |
      | <numero> |
    Then SELECCIONAR EL PAQUETE A COMPRAR
      | tipoPaquete   |
      | <tipoPaquete> |
    Then COMPRA DEL PAQUETE RELEVO SMS ILIMITADOS WTF 6GB 30 DIAS
    Then CLIC EN BOTON CONTRA SALDO
    Then SELECCIONAR TERMINOS Y CONDICIONES
    Then CLIC PAGAR CON MI SALDO
    Then VALIDAR NOTIFICACIONES DE COMPRA

    Examples:
      | email | password | numero | nombreUsuario  | tipoPaquete |
    ##@externalData@./src/test/resources/data/Users.xlsx@Hoja2@
   |pruebasexperienciaclaro@gmail.com   |ExuS2o2a   |350 767 1166   |Hola, Gerencia   |Paquetes de voz|
