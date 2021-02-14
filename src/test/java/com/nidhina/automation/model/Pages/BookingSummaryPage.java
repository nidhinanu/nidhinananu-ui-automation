package com.nidhina.automation.model.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class BookingSummaryPage extends BasePage {

    public BookingSummaryPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void EnterFirstName(String firstName) {
        new WebDriverWait(driver, 60);
        WebElement firstNameclickableElement = driver.findElement(By.cssSelector("div[class*='form-group']"))
                .findElements(By.tagName("input")).stream().filter(el -> el.getAttribute("name").equals("firstname"))
                .findFirst().orElseThrow().findElement(By.xpath(".//following-sibling::*"));
        firstNameclickableElement.click();
        new WebDriverWait(driver, 60);
        driver.findElement(By.cssSelector("div[class*='gap-20']")).findElements(By.tagName("input")).stream()
                .filter(el -> el.getAttribute("name").equals("firstname")).findFirst().orElseThrow()
                .sendKeys(firstName);
    }

    public void EnterLastName(String lastname) {
        new WebDriverWait(driver, 60);
        WebElement lastNameclickableElement = driver.findElement(By.cssSelector("div[class*='gap-20'] "))
                .findElements(By.tagName("input")).stream().filter(el -> el.getAttribute("name").equals("lastname"))
                .findFirst().orElseThrow().findElement(By.xpath(".//following-sibling::*"));
        lastNameclickableElement.click();
        driver.findElement(By.cssSelector("div[class*='gap-20']")).findElements(By.tagName("input")).stream()
                .filter(el -> el.getAttribute("name").equals("lastname")).findFirst().orElseThrow().sendKeys(lastname);
    }

    public void EnterEmail(String email) {
        new WebDriverWait(driver, 60);
        WebElement emailclickableElement = driver
                .findElement(By.xpath("//form[@id='guestform']/div[2]/div[1]/label/span"));
        emailclickableElement.click();
        emailclickableElement.findElement(By.xpath("//form[@id='guestform']/div[2]/div[1]/label/input"))
                .sendKeys(email);
    }

    public void EnterConfirmEmail(String email) {
        new WebDriverWait(driver, 60);
        WebElement emailclickableElement = driver
                .findElement(By.xpath("//form[@id='guestform']/div[2]/div[2]/label/span"));
        emailclickableElement.click();
        emailclickableElement.findElement(By.xpath("//form[@id='guestform']/div[2]/div[2]/label/input"))
                .sendKeys(email);
    }

    public void clickConfirmBooking() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        WebElement confirmBookingButton = driver.findElement(By.xpath("//button[name='guest']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBookingButton);
        confirmBookingButton.click();

    }
}
