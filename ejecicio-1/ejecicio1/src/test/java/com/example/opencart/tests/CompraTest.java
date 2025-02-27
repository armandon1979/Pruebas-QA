package com.example.opencart.tests;

import com.example.opencart.pages.*;
import com.example.opencart.steps.*;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class CompraTest {

    @Managed
    WebDriver driver;

    @Steps
    HomePageSteps homePageSteps;

    @Steps
    ProductPageSteps productPageSteps;

    @Steps
    CartPageSteps cartPageSteps;

    @Steps
    CheckoutPageSteps checkoutPageSteps;

    @Test
    @DisplayName("Realizar una compra exitosa como invitado")
    public void realizarCompraExitosaComoInvitado() {
        // Abrir la página principal
        homePageSteps.abrirPaginaPrincipal();
        
        // Agregar primer producto al carrito (iPhone)
        homePageSteps.buscarProducto("iPhone");
        productPageSteps.agregarAlCarrito();
        productPageSteps.continuarComprando();
        
        // Agregar segundo producto al carrito (MacBook)
        homePageSteps.buscarProducto("MacBook");
        productPageSteps.agregarAlCarrito();
        
        // Visualizar el carrito
        productPageSteps.irAlCarrito();
        cartPageSteps.verificarProductosEnCarrito("iPhone", "MacBook");
        
        // Proceder al checkout
        cartPageSteps.procederAlCheckout();
        
        // Completar checkout como invitado
        checkoutPageSteps.seleccionarCheckoutComoInvitado();
        checkoutPageSteps.completarDatosPersonales("Juan", "Pérez", "juan.perez@example.com", 
                                                  "123456789", "Calle Principal 123", "Ciudad", 
                                                  "12345", "Argentina");
        
        // Completar datos de envío
        checkoutPageSteps.continuarAMetodoEnvio();
        checkoutPageSteps.continuarAMetodoPago();
        
        // Aceptar términos y condiciones y confirmar pedido
        checkoutPageSteps.aceptarTerminosYCondiciones();
        checkoutPageSteps.confirmarPedido();
        
        // Verificar mensaje de confirmación
        checkoutPageSteps.verificarConfirmacionPedido("Your order has been placed!");
    }
}
