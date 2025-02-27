package com.example.opencart.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import com.example.opencart.utils.WaitUtils;

public class ProductPage extends PageObject {
    
    private static final By ADD_TO_CART_BUTTON = By.id("button-cart");
    private static final By SUCCESS_ALERT = By.cssSelector(".alert-success");
    private static final By CART_BUTTON = By.cssSelector("#cart button");
    private static final By CHECKOUT_LINK = By.xpath("//a[contains(text(), 'Checkout')]");
    
    public void agregarAlCarrito() {
        $(ADD_TO_CART_BUTTON).click();
        WaitUtils.waitUntilElementVisible(this, SUCCESS_ALERT);
    }
    
    public void continuarComprando() {
        getDriver().navigate().back();
    }
    
    public void irAlCarrito() {
        $(CART_BUTTON).click();
        $(CHECKOUT_LINK).click();
    }
}