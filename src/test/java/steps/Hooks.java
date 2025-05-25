package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;
import pages.BasePage;

public class Hooks extends BasePage{
    
    public Hooks(){
        super(driver);
    }

    @After
    public void tearDown(Scenario escenario){
        
        if (escenario.isFailed()){
            escenario.log("El escenario fallo. Por favor revisar la imagen adjunta en este reporte");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            escenario.attach(screenshot, "image/png", "Pantallazo del error");
        }
        
    }

    @AfterStep
    public void tomarCapturaCadaPaso(Scenario escenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            escenario.attach(screenshot, "image/png", "Pantallazo del paso");
    }
}
