package pages;

public class FormularioPage extends BasePage {

    private String tituloEtiquetaNombre = "//*[@id=\"grupo__nombre\"]/label"; // Seleccionar por Xpath
    private String campoNombre = "nombre"; // Seleccionar por nombre
    private String campoAlertaNombre = "#grupo__nombre .formulario__input-error"; // Seleccionar por Css

    private String tituloEtiquetaEmail = "//*[@id=\"grupo__email\"]/label"; // Seleccionar por Xpath
    private String campoEmail = "email"; // Seleccionar por nombre
    private String campoAlertaEmail = "#grupo__email .formulario__input-error"; // Seleccionar por Css

    private String tituloEtiquetaBarrio = "//*[@id=\"grupo__barrio\"]/label"; // Seleccionar por Xpath
    private String campoBarrio = "barrio"; // Seleccionar por nombre
    private String campoAlertaBarrio = "#grupo__barrio .formulario__input-error"; // Seleccionar por Css

    private String tituloEtiquetaAsunto = "//*[@id=\"grupo__asunto\"]/label"; // Seleccionar por Xpath
    private String campoAsunto = "asunto"; // Seleccionar por nombre
    private String campoAlertaAsunto = "#grupo__asunto .formulario__input-error"; // Seleccionar por Css

    private String tituloEtiquetaMensaje = "//*[@id=\"formulario\"]/div[5]/label"; // Seleccionar por Xpath
    private String campoMensaje = "Mensaje"; // Seleccionar por nombre

    private String botonEnviar = "//button[@type='submit']";

    private String txtNombre = "Edison Alvarez"; // Nombre de ejemplo
    private String txtBarrio = "La cumbre"; // Barrio de ejemplo
    private String txtEmail = "edison_alvarez_ejem@gmail.com"; // Email de ejemplo
    private String txtAsunto = "Por favor, necesito información"; // Asunto de ejemplo
    private String txtMensaje = "Solicito información detallada sobre los servicios disponibles y los horarios de atención. Quedo atento a su pronta respuesta. Muchas gracias."; // Mensaje de ejemplo

    private String mensaje[] = {
    "El nombre debe contener al menos 5 letras y no aceptar símbolos", // el indice para este mensaje es el 0
    "El correo electrónico debe tener más de 4 caracteres, incluir '@' y un dominio válido", // el indice para este mensaje es el 1
    "El barrio debe tener un mínimo de 5 letras sin números ni caracteres especiales", // el indice para este mensaje es el 2
    "El asunto debe ser descriptivo y contener al menos 5 letras" // el indice para este mensaje es el 3
};

    private String titulos[] = { "Nombre:", "Email:", "Barrio:", "Asunto:", "Mensaje:" };
    private String mensajesPopUp[] = {"Algo salió mal :c", "El Formulario envió correctamente"};

    // Constructor
    public FormularioPage() {
        super(driver);
    }

    // URL del formulario
    public void navegarA() {
        abrirUrl("http://64.227.54.255/Softesting/Frontend/Caso1.html");
    }

    //Llenar los campos de texto del formulario
    public void textoCamposCompleta() {
        escribir(campoNombre, txtNombre);
        escribir(campoBarrio, txtBarrio);
        escribir(campoEmail, txtEmail);
        escribir(campoAsunto, txtAsunto);
        escribir(campoMensaje, txtMensaje);
    }

    // Se muestran las alertas por no ingresar datos al formulario
    public void sinTextoCampos() {
        escribir(campoNombre, "");
        escribir(campoBarrio, "");
        escribir(campoEmail, "");
        escribir(campoAsunto, "");
        escribir(campoMensaje, "");
    }

    // Ingresar datos y el nombre con 3 letras
    public void textoNombre(String nombre) {
        escribir(campoNombre, nombre);
        escribir(campoBarrio, txtBarrio);
        escribir(campoEmail, txtEmail);
        escribir(campoAsunto, txtAsunto);
        escribir(campoMensaje, txtMensaje);
    }

    // Ingresar el Correo con datos incompletos
    public void datosFaltanteEmail(String correo) {
        escribir(campoNombre, txtNombre);
        escribir(campoBarrio, txtBarrio);
        escribir(campoEmail, correo);
        escribir(campoAsunto, txtAsunto);
        escribir(campoMensaje, txtMensaje);
    }

    // Validar una alerta en nombre
    public void visibiMensaNombre() {
        validarVisuvilidad(campoAlertaNombre, mensaje[0]);
    }

    // Validar alerta en email
    public void visibiMensaEmail() {
        validarVisuvilidad(campoAlertaEmail, mensaje[1]);
    }

    // Validar alerta en cada campo
    public void alertaTodosCampos(){
        elementoPresente(campoAlertaNombre);
        elementoPresente(campoAlertaEmail);
        elementoPresente(campoAlertaBarrio);
        elementoPresente(campoAlertaAsunto);
    }

    // Validar que no aparece una alerta en nombre
    public void noVisibiMensaNombre() {
        validadInvisibilidad(campoAlertaNombre, mensaje[0]);
    }

    // Validar que no aparece una alerta en email
    public void noVisibiMensaEmail() {
        validadInvisibilidad(campoAlertaEmail, mensaje[1]);
    }

    // Validar que no aparece una alerta en barrio
    public void noVisibiMensaBarrio() {
        validadInvisibilidad(campoAlertaBarrio, mensaje[2]);

    }

    // Validar que no aparece una alerta en asunto
    public void noVisibiMensaAsunto() {
        validadInvisibilidad(campoAlertaAsunto, mensaje[3]);
    }

    // Validar que no aparece ninguna alerta
    public void noAlertas() {
        elementoNoPresente(campoAlertaNombre);
        elementoNoPresente(campoAlertaEmail);
        elementoNoPresente(campoAlertaBarrio);
        elementoNoPresente(campoAlertaAsunto);
    }

    // Validar que la ortografia de los titulos esta bien
    public void validarTexto() {
        identificarTexto(tituloEtiquetaNombre, titulos[0]);
        identificarTexto(tituloEtiquetaEmail, titulos[1]);
        identificarTexto(tituloEtiquetaBarrio, titulos[2]);
        identificarTexto(tituloEtiquetaAsunto, titulos[3]);
        identificarTexto(tituloEtiquetaMensaje, titulos[4]);
    }

    // Validar que se envio bien un formulario
    public void envioCorrectoFormulario(){
        hacerClicBoton(botonEnviar);
        aceptarAlerta(mensajesPopUp[1]);
    }

    // Validar que se envio bien un formulario
    public void envioErradoFormulario(){
        hacerClicBoton(botonEnviar);
        aceptarAlerta(mensajesPopUp[0]);
    }
}