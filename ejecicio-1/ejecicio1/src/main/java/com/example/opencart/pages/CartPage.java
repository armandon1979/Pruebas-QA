package com.example.opencart.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    
    private static final By CHECKOUT_BUTTON = By.xpath("//a[contains(text(), 'Checkout')]");
    
    public boolean verificarProductoEnCarrito(String nombreProducto) {
        return $(By.xpath("//div[@id='content']//td[contains(text(), '" + nombreProducto + "')]")).isVisible();
    }
    
    public void procederAlCheckout() {
        $(CHECKOUT_BUTTON).click();
    }
}