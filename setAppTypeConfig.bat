<<<<<<< HEAD
@echo off
SET APP_TYPE=%1
SET PROP_FILE=src\test\resources\serenity.properties

:: Eliminar la configuración anterior
echo. > %PROP_FILE%

:: Configurar según el tipo de prueba
IF "%APP_TYPE%"=="superapp" (
    echo appium.app=${user.dir}/src/test/resources/app/mi-claro.apk > %PROP_FILE%
    echo appium.appPackage=com.clarocolombia.miclaro >> %PROP_FILE%
    echo appium.appActivity=com.claro.superapp.SplashActivity >> %PROP_FILE%
) ELSE IF "%APP_TYPE%"=="ussd" (
    echo appium.app=${user.dir}/src/test/resources/app/phone.apk > %PROP_FILE%
    echo appium.appPackage=com.google.android.dialer >> %PROP_FILE%
    echo appium.appActivity=.activities.CallLogActivity >> %PROP_FILE%
) ELSE IF "%APP_TYPE%"=="web" (
    echo webdriver.driver=chrome > %PROP_FILE%
    echo webdriver.chrome.driver=src/test/resources/WebDriver/chromedriver.exe >> %PROP_FILE%
    echo serenity.restart.browser.for.each=NEVER >> %PROP_FILE%
    echo serenity.maintain.session=true >> %PROP_FILE%
    echo serenity.use.unique.browser=true >> %PROP_FILE%
    echo chrome.switches=--start-maximized, --disable-popup-blocking, --ignore-certificate-errors, --disable-download-notification, --user-data-dir=C:/Users/TuUsuario/AppData/Local/Google/Chrome/User Data, --profile-directory=Default >> %PROP_FILE%
) ELSE IF "%APP_TYPE%"=="whatsapp" (
    echo appium.app=${user.dir}/src/test/resources/app/whatsapp.apk > %PROP_FILE%
    echo appium.appPackage=com.whatsapp >> %PROP_FILE%
    echo appium.appActivity=.Main >> %PROP_FILE%
) ELSE (
    echo ❌ ERROR: Tipo de aplicación no válido. Usa "superapp", "ussd", "web" o "whatsapp".
    exit /b 1
)

:: Esperar 2 segundos para asegurar la actualización antes de ejecutar pruebas
timeout /t 2 > nul

echo ✅ serenity.properties configurado para: %APP_TYPE%
=======
@echo off
SET APP_TYPE=%1
SET PROP_FILE=src\test\resources\serenity.properties

:: Eliminar la configuración anterior
echo. > %PROP_FILE%

:: Configurar según el tipo de prueba
IF "%APP_TYPE%"=="superapp" (
    echo appium.app=${user.dir}/src/test/resources/app/mi-claro.apk > %PROP_FILE%
    echo appium.appPackage=com.clarocolombia.miclaro >> %PROP_FILE%
    echo appium.appActivity=com.claro.superapp.SplashActivity >> %PROP_FILE%
) ELSE IF "%APP_TYPE%"=="ussd" (
    echo appium.app=${user.dir}/src/test/resources/app/phone.apk > %PROP_FILE%
    echo appium.appPackage=com.google.android.dialer >> %PROP_FILE%
    echo appium.appActivity=.activities.CallLogActivity >> %PROP_FILE%
) ELSE IF "%APP_TYPE%"=="web" (
    echo webdriver.driver=chrome > %PROP_FILE%
    echo webdriver.chrome.driver=src/test/resources/WebDriver/chromedriver.exe >> %PROP_FILE%
    echo serenity.restart.browser.for.each=NEVER >> %PROP_FILE%
    echo serenity.maintain.session=true >> %PROP_FILE%
    echo serenity.use.unique.browser=true >> %PROP_FILE%
    echo chrome.switches=--start-maximized, --disable-popup-blocking, --ignore-certificate-errors, --disable-download-notification, --user-data-dir=C:/Users/TuUsuario/AppData/Local/Google/Chrome/User Data, --profile-directory=Default >> %PROP_FILE%
) ELSE IF "%APP_TYPE%"=="whatsapp" (
    echo appium.app=${user.dir}/src/test/resources/app/whatsapp.apk > %PROP_FILE%
    echo appium.appPackage=com.whatsapp >> %PROP_FILE%
    echo appium.appActivity=.Main >> %PROP_FILE%
) ELSE (
    echo ❌ ERROR: Tipo de aplicación no válido. Usa "superapp", "ussd", "web" o "whatsapp".
    exit /b 1
)

:: Esperar 2 segundos para asegurar la actualización antes de ejecutar pruebas
timeout /t 2 > nul

echo ✅ serenity.properties configurado para: %APP_TYPE%
>>>>>>> 65477f2b70e47f854437031f986c6d88c7db04dc
