package com.nidhina.automation.model.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookingPage extends BasePage {

    public FlightBookingPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void enterFromLocation() {
        new WebDriverWait(driver, 60);
        WebElement fromLocation = driver.findElement(By.cssSelector("#s2id_location_from"));
        fromLocation.click();
        driver.findElement(By.cssSelector("div[id='select2-drop'] > div > input")).sendKeys("DUBAI");
        driver.findElement(By.cssSelector("div[id='select2-drop']")).findElements(By.className("select2-result-label"))
                .stream().filter(span -> span.getText().contains("(DXB)")).findFirst().orElseThrow().click();

    }

    public void enterToLocation() {
        new WebDriverWait(driver, 60);
        WebElement fromLocation = driver.findElement(By.cssSelector("#s2id_location_to"));
        fromLocation.click();
        driver.findElement(By.cssSelector("div[id='select2-drop'] > div > input")).sendKeys("LAHORE");
        driver.findElement(By.cssSelector("div[id='select2-drop']")).findElements(By.className("select2-result-label"))
                .stream().filter(span -> span.getText().contains("(LHE)")).findFirst().orElseThrow().click();

    }

    public void setDate(String date) {
        driver.findElement(By.id("FlightsDateStart")).click();
        selectDate(date);

    }

    private void selectDate(String d) {
        String[] splittedDepartDate = d.split("-");
        String departYear = splittedDepartDate[0];
        String departMonth = splittedDepartDate[1];
        // String departDate = splittedDepartDate[2];
        driver.findElement(By.xpath(
                "//div[@class='datepicker -bottom-left- -from-bottom- active']//div[@class= 'datepicker--nav-title']"))
                .click();
        driver.findElement(By.xpath(
                "//div[@class='datepicker -bottom-left- -from-bottom- active']//div[@class= 'datepicker--nav-title']"))
                .click();
        selectYear(departYear);
        selectMonth(departMonth);
    }

    private void selectYear(String year) {
        driver.findElement(By.xpath(
                "//div[@class = 'datepicker--years datepicker--body active']//div[@class='datepicker--cells datepicker--cells-years']"))
                .findElements(By.tagName("div")).stream().filter(el -> el.getText().equals(year)).findFirst()
                .orElseThrow().click();
    }

    private void selectMonth(String month) {
        driver.findElement(By.xpath(
                "//div[@class = 'datepicker--months datepicker--body active']//div[@class='datepicker--cells datepicker--cells-months']"))
                .findElements(By.tagName("div")).stream().filter(div -> div.getText().equals(month.substring(0, 3)))
                .findFirst().orElseThrow().click();
    }

    public void clickSearch() {

        driver.findElement(By.xpath("(//button[contains(text(),'Search')])[2]")).click();
    }

}
