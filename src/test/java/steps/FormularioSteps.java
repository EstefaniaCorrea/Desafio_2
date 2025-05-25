package steps;

import io.cucumber.java.en.*;
import pages.FormularioPage;

public class FormularioSteps {
    
    private FormularioPage formulario = new FormularioPage();

    @Given("^el usuario navega a la pagina del formulario$")
    public void navegarFormulario(){
        formulario.navegarA();
    }

    @When("^ingresa datos válidos en todos los campos$")
    public void ingresarDatosCompletos(){
        formulario.textoCamposCompleta();
    }

    @When("^no ingresa datos en los campos$")
    public void noIngresaDatos(){
        formulario.sinTextoCampos();
    }

    @When("^ingresa el nombre (.*)$")
    public void datoFaltanteNombre(String nombre){
        formulario.textoNombre(nombre);
    }

    @When("^ingresa el email (.*)$")
    public void datoFaltanteEmail(String email){
        formulario.datosFaltanteEmail(email);
    }

    @Then("^no debería aparecer ninguna alerta$")
    public void validacionNoAlertas(){
        formulario.noAlertas();
    }

    @Then("^debería aparecer una alerta en los campos principales$")
    public void validarAlertas(){
        formulario.alertaTodosCampos();
    }
    
    @Then("^debería aparecer una alerta en el campo de nombre$")
    public void validarAlertaNombre(){
        formulario.visibiMensaNombre();
    }

    @Then("^debería aparecer una alerta en el campo de email$")
    public void validarAlertaEmail(){
        formulario.visibiMensaEmail();
    }

    @Then("^todos los textos del formulario deberian tener la ortografía correcta$")
    public void validarOrtografia(){
        formulario.validarTexto();
    }

    @Then("^el formulario se debe enviar de forma correcta$")
    public void enviarFormulario(){
        formulario.envioCorrectoFormulario();
    }

    @Then("^el formulario debe mostrar una alerta$")
    public void enviarFormularioVacio(){
        formulario.envioErradoFormulario();
    }
}