@Formulario
Feature: Probar la funcionalidad del formulario web.

    @FormularioCorrecto
    Scenario: Verificar que no se muestren alertas al completar correctamente el formulario
        Given el usuario navega a la pagina del formulario
        When ingresa datos válidos en todos los campos
        Then no debería aparecer ninguna alerta

    @FormularioSinDatos
    Scenario: Validar que se generen alertas cuando no se ingresan datos en el formulario
        Given el usuario navega a la pagina del formulario
        When no ingresa datos en los campos
        Then debería aparecer una alerta en los campos principales

    @FormularioNombre
    Scenario Outline: Validar la alerta mostrada al ingresar un nombre no válido
        Given el usuario navega a la pagina del formulario
        When ingresa el nombre <Nombre>
        Then debería aparecer una alerta en el campo de nombre

    Examples:
        | Nombre | 
        | BGR    | 
        | @re$   | 
        | 2708   |

    @FormularioEmail
    Scenario Outline: Validar que se muestre una alerta al ingresar un correo electrónico inválido
        Given el usuario navega a la pagina del formulario
        When ingresa el email <Correo>
        Then debería aparecer una alerta en el campo de email
        
    Examples:
        | Correo                         | 
        | correodeprueba@gmail           | 
        | correodeprueba2gmail.com       | 
        | corre##"!deprueba**@gmail.com  | 
        | correo de prueba @gmail .com   | 

    @FormularioOrtografia
    Scenario: Comprobar que los textos del formulario no contengan errores ortográficos
        Given el usuario navega a la pagina del formulario
        Then todos los textos del formulario deberian tener la ortografía correcta

    @EnviarFormulario @EnviarConDatos
    Scenario: Confirmar el envío exitoso del formulario con datos válidos
        Given el usuario navega a la pagina del formulario
        When ingresa datos válidos en todos los campos
        Then el formulario se debe enviar de forma correcta

    @EnviarFormulario @EnviarSinDatos
    Scenario: Validar que se muestre una alerta al intentar enviar el formulario vacío
        Given el usuario navega a la pagina del formulario
        When no ingresa datos en los campos
        Then el formulario debe mostrar una alerta

