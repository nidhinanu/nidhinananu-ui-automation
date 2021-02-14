package com.nidhina.automation.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTests {

    protected WebDriver driver;

    @BeforeEach
    public void setup() throws ReflectiveOperationException {
        /*
         * var browser = EnvironmentVariables.getBrowser(); var wait =
         * EnvironmentVariables.getImplicitWait(); var url =
         * EnvironmentVariables.getUrl();
         */

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.phptravels.net/login");
    }

    @AfterEach
    public void shutdown() {
        driver.close();
    }

}
