package com.example.opencart.steps;

import com.example.opencart.pages.ProductPage;
import net.thucydides.core.annotations.Step;

public class ProductPageSteps {
    
    private ProductPage productPage;
    
    @Step("Agregar producto al carrito")
    public void agregarAlCarrito() {
        productPage.agregarAlCarrito();
    }
    
    @Step("Continuar comprando")
    public void continuarComprando() {
        productPage.continuarComprando();
    }
    
    @Step("Ir al carrito de compras")
    public void irAlCarrito() {
        productPage.irAlCarrito();
    }
}