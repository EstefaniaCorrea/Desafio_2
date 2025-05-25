package pages;

public class FormularioPage extends BasePage {

    private String tituloNombre = "//*[@id=\"grupo__nombre\"]/label"; // Localizador por Xpath
    private String campoNombre = "nombre"; // Localizador por nombre
    private String alertaNombre = "#grupo__nombre .formulario__input-error"; // Localizador por Selector Css

    private String tituloEmail = "//*[@id=\"grupo__email\"]/label"; // Localizador por Xpath
    private String campoEmail = "email"; // Localizador por nombre
    private String alertaEmail = "#grupo__email .formulario__input-error"; // Localizador por Selector Css

    private String tituloBarrio = "//*[@id=\"grupo__barrio\"]/label"; // Localizador por Xpath
    private String campoBarrio = "barrio"; // Localizador por nombre
    private String alertaBarrio = "#grupo__barrio .formulario__input-error"; // Localizador por Selector Css

    private String tituloAsunto = "//*[@id=\"grupo__asunto\"]/label"; // Localizador por Xpath
    private String campoAsunto = "asunto"; // Localizador por nombre
    private String alertaAsunto = "#grupo__asunto .formulario__input-error"; // Localizador por Selector Css

    private String tituloMensaje = "//*[@id=\"formulario\"]/div[5]/label"; // Localizador por Xpath
    private String campoMensaje = "Mensaje"; // Localizador por nombre

    private String btnEnviar = "//button[@type='submit']";

    private String txtNombre = "Camila Torres";
    private String txtBarrio = "El Pinar";
    private String txtEmail = "camila.torres.ejemplo@gmail.com";
    private String txtAsunto = "Solicitud de información";
    private String txtMensaje = "Buenas tardes, me gustaría recibir más información sobre los servicios que ofrecen y los horarios de atención. Agradezco su pronta respuesta.";

    private String mensaje[] = {
        "El nombre debe ser mayor a 4 letras y no debe incluir caracteres especiales", // el indice para este mensaje es el 0
        "El Email debe ser mayor a 4 caracteres y debe llevar @ y . no debe incluir caracteres especiales", //el indice para este mensaje es el 1
        "El barrio debe ser mayor a 4 letras", // el indice para este mensaje es el 2
        "El asunto debe ser mayor a 4 letras" // el indice para este mensaje es el 3
    };

    private String titulos[] = { "Tu Nombre:", "Tu Email:", "Barrio:", "Asunto:", "Mensaje:" };
    private String mensajesPopUp[] = {"UPPPPS ALGO HA FALLADO :(", "El Formulario se ha enviado correctamente"};

    // Constructor
    public FormularioPage() {
        super(driver);
    }

    // Metodo para navegar a la URL indicada
    public void navegarA() {
        abrirUrl("http://64.227.54.255/Softesting/Frontend/Caso1.html");
    }

    // Metodo para llenar los campos de texto del formulario
    public void textoCamposCompleta() {
        escribir(campoNombre, txtNombre);
        escribir(campoBarrio, txtBarrio);
        escribir(campoEmail, txtEmail);
        escribir(campoAsunto, txtAsunto);
        escribir(campoMensaje, txtMensaje);
    }

    // Metodo para hacer que salten las alertas por no ingresar datos al formulario
    public void sinTextoCampos() {
        escribir(campoNombre, "");
        escribir(campoBarrio, "");
        escribir(campoEmail, "");
        escribir(campoAsunto, "");
        escribir(campoMensaje, "");
    }

    // Metodo para ingresar datos y el nombre con 3 letras
    public void textoNombre(String nombre) {
        escribir(campoNombre, nombre);
        escribir(campoBarrio, txtBarrio);
        escribir(campoEmail, txtEmail);
        escribir(campoAsunto, txtAsunto);
        escribir(campoMensaje, txtMensaje);
    }

    // Metodo para ingresar el Correo con datos faltantes
    public void datosFaltanteEmail(String correo) {
        escribir(campoNombre, txtNombre);
        escribir(campoBarrio, txtBarrio);
        escribir(campoEmail, correo);
        escribir(campoAsunto, txtAsunto);
        escribir(campoMensaje, txtMensaje);
    }

    // Metodo para validar que aparece una alerta en nombre
    public void visibiMensaNombre() {
        validarVisuvilidad(alertaNombre, mensaje[0]);
    }

    // Metodo para validar que aparece una alerta en email
    public void visibiMensaEmail() {
        validarVisuvilidad(alertaEmail, mensaje[1]);
    }

    // Metodo para validar que aparece una alerta en cada campo
    public void alertaTodosCampos(){
        elementoPresente(alertaNombre);
        elementoPresente(alertaEmail);
        elementoPresente(alertaBarrio);
        elementoPresente(alertaAsunto);
    }

    // Metodo para validar que No aparece una alerta en nombre
    public void noVisibiMensaNombre() {
        validadInvisibilidad(alertaNombre, mensaje[0]);
    }

    // Metodo para validar que No aparece una alerta en email
    public void noVisibiMensaEmail() {
        validadInvisibilidad(alertaEmail, mensaje[1]);
    }

    // Metodo para validar que No aparece una alerta en barrio
    public void noVisibiMensaBarrio() {
        validadInvisibilidad(alertaBarrio, mensaje[2]);

    }

    // Metodo para validar que No aparece una alerta en asunto
    public void noVisibiMensaAsunto() {
        validadInvisibilidad(alertaAsunto, mensaje[3]);
    }

    // Metodo para validar que no aparece ninguna alerta
    public void noAlertas() {
        elementoNoPresente(alertaNombre);
        elementoNoPresente(alertaEmail);
        elementoNoPresente(alertaBarrio);
        elementoNoPresente(alertaAsunto);
    }

    // Metodo paa validar que la ortografia de los titulos esta bien
    public void validarTexto() {
        identificarTexto(tituloNombre, titulos[0]);
        identificarTexto(tituloEmail, titulos[1]);
        identificarTexto(tituloBarrio, titulos[2]);
        identificarTexto(tituloAsunto, titulos[3]);
        identificarTexto(tituloMensaje, titulos[4]);
    }

    // Metodo para validar que se envio bien un formulario
    public void envioCorrectoFormulario(){
        hacerClicBoton(btnEnviar);
        aceptarAlerta(mensajesPopUp[1]);
    }

    // Metodo para validar que se envio bien un formulario
    public void envioErradoFormulario(){
        hacerClicBoton(btnEnviar);
        aceptarAlerta(mensajesPopUp[0]);
    }
}