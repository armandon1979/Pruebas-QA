package com.example.opencart.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    
    private static final By SEARCH_BOX = By.name("search");
    private static final By SEARCH_BUTTON = By.cssSelector(".btn.btn-default.btn-lg");
    
    public void abrirPagina() {
        open("http://opencart.abstracta.us/");
    }
    
    public void buscarProducto(String nombreProducto) {
        $(SEARCH_BOX).typeAndEnter(nombreProducto);
    }
}