package com.nidhina.automation.model.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvailableFlightsPage extends BasePage {

    public AvailableFlightsPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void clickBookNow() {
        driver.findElement(By.xpath("(//button[contains(text(),'Book Now')])[1]")).click();              
  }


    
}
