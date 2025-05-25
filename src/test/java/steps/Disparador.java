package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;
import pages.BasePage;

public class Disparador extends BasePage{
    
    public Disparador(){
        super(driver);
    }

    @After
    public void tearDown(Scenario escenario){
        
        if (escenario.isFailed()){
            escenario.log("Revisar la imagen adjunta en este reporte del escenario fallido.");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            escenario.attach(screenshot, "image/png", "Pantallazo del error");
        }
        
    }

    @AfterStep
    public void tomarCapturaPasos(Scenario escenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            escenario.attach(screenshot, "image/png", "Pantallazo del paso");
    }
}
