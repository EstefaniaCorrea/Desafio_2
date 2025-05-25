package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // Ampliar la ventana del navegador
    }

    // Constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Navegar y abrir una URL
    public void abrirUrl(String url) {
        driver.get(url);
    }

    // Cerrar el navegador
    public static void cerrarNavegador() {
        driver.close();
    }

    // Localiza Xpath de un elemento
    private WebElement localizarXpath(String localizador) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(localizador)));
    }

    // Localiza elemento por su Id
    private WebElement localizarElementoId(String localizador) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(localizador)));
    }

    // Localiza un elemento por su Nombre
    private WebElement LocalizaElementoNombre(String localizador) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(localizador)));
    }

    // Localiza un elemento por su Selector Css
    private WebElement localizarElementoCss(String localizador) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(localizador)));
    }

    // Seleccionar un elemento por su Xpath
    public void seleccionarElementoXpath(String localizador) {
        localizarXpath(localizador);
    }

    // Seleccionar un elemento por su Id
    public void seleccionarElementoId(String localizador) {
        localizarElementoId(localizador);
    }

    // Seleccionar un elemento por su Nombre
    public void seleccionarElementoNombre(String localizador) {
        LocalizaElementoNombre(localizador);
    }

    // Seleccionar un elemento por su Selector Css
    public void seleccionarElementoCss(String localizador) {
        localizarElementoCss(localizador);
    }

    // Metodo para llenar un campo de texto
    public void escribir(String localizador, String texto) {
        seleccionarElementoNombre(localizador);
        LocalizaElementoNombre(localizador).clear();
        LocalizaElementoNombre(localizador).sendKeys(texto);
    }

    // Validar visibilidad de un elemento
    public void validarVisuvilidad(String localizador, String mensaje) {
        String mensajeEsperado = mensaje;
        String mensajeEncontrado = localizarElementoCss(localizador).getText();
        
        Assert.assertTrue(mensajeEncontrado.contains(mensajeEsperado));
    }

    // Validar invisibilidad de un elemento
    public void validadInvisibilidad(String localizador, String mensaje) {
        String mensajeEsperado = mensaje;
        String mensajeEncontrado = localizarElementoCss(localizador).getText();

        Assert.assertFalse(mensajeEncontrado.contains(mensajeEsperado));
    }
    // Validar que un elemento web esta presente
    public void elementoPresente(String localizador) {
        WebElement elemento = localizarElementoCss(localizador);

        Assert.assertTrue(elemento.isDisplayed());
    }
    
    // Validar que un elemento web no esta presente
    public void elementoNoPresente(String localizador) {
        WebElement elemento = localizarElementoCss(localizador);

        Assert.assertFalse(elemento.isDisplayed());
    }

    // Validar que coincide un texto con el que se espera
    public void identificarTexto(String localizador, String texto){
        String mensajeEsperado = texto;
        String mensajeEncontrado = localizarXpath(localizador).getText();

        Assert.assertEquals(mensajeEsperado, mensajeEncontrado);
    }

    // Metodo para hacer click en un boton
    public void hacerClicBoton(String localizador){
        localizarXpath(localizador).click();
    }

    // Metodo para aceptar la alerta
    public void aceptarAlerta(String mensajeEsperado){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String mensajeAlerta = alert.getText();
        
        if(mensajeAlerta.contains(mensajeEsperado)){
            Assert.assertTrue(mensajeAlerta.contains(mensajeAlerta));
        }

        alert.accept();
    }

    
}