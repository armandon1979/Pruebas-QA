package com.example.opencart.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.opencart.utils.WaitUtils;

public class CheckoutPage extends PageObject {
    
    private static final By GUEST_CHECKOUT_RADIO = By.xpath("//input[@value='guest']");
    private static final By CONTINUE_BUTTON = By.id("button-account");
    private static final By FIRST_NAME = By.id("input-payment-firstname");
    private static final By LAST_NAME = By.id("input-payment-lastname");
    private static final By EMAIL = By.id("input-payment-email");
    private static final By TELEPHONE = By.id("input-payment-telephone");
    private static final By ADDRESS_1 = By.id("input-payment-address-1");
    private static final By CITY = By.id("input-payment-city");
    private static final By POSTCODE = By.id("input-payment-postcode");
    private static final By COUNTRY = By.id("input-payment-country");
    private static final By REGION = By.id("input-payment-zone");
    private static final By GUEST_CONTINUE_BUTTON = By.id("button-guest");
    private static final By SHIPPING_METHOD_CONTINUE = By.id("button-shipping-method");
    private static final By PAYMENT_METHOD_CONTINUE = By.id("button-payment-method");
    private static final By TERMS_CHECKBOX = By.name("agree");
    private static final By CONFIRM_ORDER_BUTTON = By.id("button-confirm");
    private static final By SUCCESS_HEADING = By.tagName("h1");
    
    public void seleccionarCheckoutComoInvitado() {
        $(GUEST_CHECKOUT_RADIO).click();
        $(CONTINUE_BUTTON).click();
    }
    
    public void completarDatosPersonales(String firstName, String lastName, String email, 
                                         String telephone, String address, String city,
                                         String postcode, String country) {
        $(FIRST_NAME).type(firstName);
        $(LAST_NAME).type(lastName);
        $(EMAIL).type(email);
        $(TELEPHONE).type(telephone);
        $(ADDRESS_1).type(address);
        $(CITY).type(city);
        $(POSTCODE).type(postcode);
        
        // Seleccionar país
        Select countrySelect = new Select($(COUNTRY));
        countrySelect.selectByVisibleText(country);
        
        // Seleccionar región/estado (esperar que se cargue)
        WaitUtils.waitUntilElementEnabled(this, REGION);
        Select regionSelect = new Select($(REGION));
        regionSelect.selectByIndex(1);
        
        $(GUEST_CONTINUE_BUTTON).click();
    }
    
    public void continuarAMetodoEnvio() {
        $(SHIPPING_METHOD_CONTINUE).click();
    }
    
    public void continuarAMetodoPago() {
        $(PAYMENT_METHOD_CONTINUE).click();
    }
    
    public void aceptarTerminosYCondiciones() {
        $(TERMS_CHECKBOX).click();
    }
    
    public void confirmarPedido() {
        $(CONFIRM_ORDER_BUTTON).click();
    }
    
    public String obtenerMensajeConfirmacion() {
        return $(SUCCESS_HEADING).getText();
    }
}
