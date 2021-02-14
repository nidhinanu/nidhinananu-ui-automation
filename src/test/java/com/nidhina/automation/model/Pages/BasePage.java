package com.nidhina.automation.model.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHomeMenu()
    {
        new WebDriverWait(driver, 60);
        driver.findElement(By.cssSelector("nav[class*='main-nav-menu']")).findElements(By.tagName("a")).stream().
        filter(a-> a.getAttribute("title").equals("home")).findFirst().orElseThrow().click();
    }

    private WebElement getBookingMenuElementByText(String menuName) {
        new WebDriverWait(driver, 60);
        WebElement rootElement = driver.findElement(By.cssSelector("div[class*='hero-form-inner']"));
        return rootElement.findElement(By.cssSelector("nav[class*='menu-horizontal-02'] > ul")).findElements(By.tagName("a")).stream()
        .filter(a->a.getText().equals(menuName)).findFirst().orElseThrow();
        }


    public void clickMenu(String menu)
    {
        getBookingMenuElementByText(menu).click();;

    }

    



    
    
}
