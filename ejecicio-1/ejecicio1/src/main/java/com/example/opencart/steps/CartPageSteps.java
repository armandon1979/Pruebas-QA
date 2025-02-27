package com.example.opencart.steps;

import com.example.opencart.pages.CartPage;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

public class CartPageSteps {
    
    private CartPage cartPage;
    
    @Step("Verificar que los productos estén en el carrito: {0}, {1}")
    public void verificarProductosEnCarrito(String producto1, String producto2) {
        Assertions.assertTrue(cartPage.verificarProductoEnCarrito(producto1), 
                             "El producto " + producto1 + " no está en el carrito");
        Assertions.assertTrue(cartPage.verificarProductoEnCarrito(producto2), 
                             "El producto " + producto2 + " no está en el carrito");
    }
    
    @Step("Proceder al checkout")
    public void procederAlCheckout() {
        cartPage.procederAlCheckout();
    }
}