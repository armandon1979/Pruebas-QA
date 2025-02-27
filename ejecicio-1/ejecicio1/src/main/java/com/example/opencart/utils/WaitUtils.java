package com.example.opencart.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils extends PageObject {
    
    private static final int DEFAULT_TIMEOUT = 100;
    
    /**
     * Espera hasta que un elemento sea visible
     */
    public static WebElementFacade waitUntilElementVisible(PageObject page, By locator) {
        return page.$(locator).withTimeoutOf(DEFAULT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
                .waitUntilVisible();
    }
    
    /**
     * Espera hasta que un elemento sea clicable
     */
    public static WebElementFacade waitUntilElementClickable(PageObject page, By locator) {
        return page.$(locator).withTimeoutOf(DEFAULT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
                .waitUntilClickable();
    }
    
    /**
     * Espera hasta que un elemento esté habilitado
     */
    public static WebElementFacade waitUntilElementEnabled(PageObject page, By locator) {
        return page.$(locator).withTimeoutOf(DEFAULT_TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)
                .waitUntilEnabled();
    }
    
    /**
     * Espera hasta que un elemento contenga un texto específico
     */
    public static void waitUntilTextPresent(WebDriver driver, By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}