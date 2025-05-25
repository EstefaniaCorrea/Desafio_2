Desafío 2: Replica Escenario De Prueba Con Selenium Y Cucumber

🧪Sobre este Proyecto:

Este proyecto implementa pruebas automatizadas sobre un formulario web utilizando Cucumber, JUnit y Selenium WebDriver, con Gradle como sistema de construcción y gestión de dependencias.

🔧Tecnologías y Librerías Utilizadas:

Las herramientas y versiones empleadas en este proyecto son:

Herramienta / Librería	Versión
Java	17
Gradle	7.6
Cucumber	7.11.2
JUnit	5.9.3
Selenium	4.15.0

Es recomendable tener instalado Java 17 o superior para garantizar la compatibilidad del entorno.


📦 Dependencias:

- **Selenium Java**: Se utiliza la versión 4.21.0.
- **TestNG**: Se utiliza la versión 7.11.0.
- **Cucumber JVM: Java**: Se utiliza la versión 7.22.0. Esta versión de be ser la misma que la del Cucumber JVM: JUnit 4.
- **Cucumber JVM: JUnit 4**: Se utiliza la version 7.22.0. Esta versión de be ser la misma que la del Cucumber JVM:Java.
- **WebDriverManager** (Debe ser la de bonigarcia): Se utiliza la versión 5.7.0.

▶️ Cómo Ejecutar las Pruebas:

Para lanzar todas las pruebas definidas en el proyecto, simplemente ejecuta el siguiente comando desde la raíz del proyecto:

-gradle test
-Este comando funciona en cualquier terminal compatible (Bash, CMD, PowerShell, etc.).

🏷️ Ejecución por Etiquetas (Tags):

Cada prueba está asociada a un tag, lo que permite ejecutarlas de manera selectiva. A continuación se listan los comandos disponibles por etiqueta:

@FormularioCorrecto:

-gradle test -Dcucumber.filter.tags="@FormularioCorrecto"
Valida el formulario con datos válidos y comprueba que no se muestren alertas.

@FormularioSinDatos:

-gradle test -Dcucumber.filter.tags="@FormularioSinDatos"
Verifica el comportamiento del formulario al dejar todos los campos vacíos.

@FormularioNombre:

-gradle test -Dcucumber.filter.tags="@FormularioNombre"
Prueba con distintos nombres para validar si son aceptados por el formulario.

@FormularioEmail:

-gradle test -Dcucumber.filter.tags="@FormularioEmail"
Verifica múltiples formatos de correo electrónico en el campo correspondiente.

@FormularioOrtografia:

-gradle test -Dcucumber.filter.tags="@FormularioOrtografia"
Revisa que los textos del formulario estén correctamente escritos.

@EnviarConDatos:

-gradle test -Dcucumber.filter.tags="@EnviarConDatos"
Llena el formulario correctamente y simula el envío.

@EnviarSinDatos:

-gradle test -Dcucumber.filter.tags="@EnviarSinDatos"
Intenta enviar el formulario vacío para comprobar las validaciones.

@EnviarFormulario:

-gradle test -Dcucumber.filter.tags="@EnviarFormulario"
Ejecuta todos los casos que involucran el botón de enviar.


📈 Reporte de Resultados:

Los resultados de las ejecuciones pueden visualizarse a través del portal de Cucumber Reports.

Pasos para publicar un reporte:
Inicia sesión en https://reports.cucumber.io usando tu cuenta de GitHub.

Obtén tu token de publicación (CUCUMBER_PUBLISH_TOKEN) único.

Configura el token en tu terminal (reemplaza your-token por el valor real):

export CUCUMBER_PUBLISH_TOKEN=your-token
Luego, ejecuta las pruebas con gradle test y el reporte se subirá automáticamente.

✅ Requisitos Previos:

Tener Java 17 o superior instalado.

Tener configurado Gradle o usar el wrapper incluido.

Acceso a internet para publicar reportes (opcional pero recomendado).