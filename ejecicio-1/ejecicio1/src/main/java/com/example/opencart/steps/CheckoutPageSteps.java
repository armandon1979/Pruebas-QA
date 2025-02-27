package com.example.opencart.steps;

import com.example.opencart.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

public class CheckoutPageSteps {
    
    private CheckoutPage checkoutPage;
    
    @Step("Seleccionar checkout como invitado")
    public void seleccionarCheckoutComoInvitado() {
        checkoutPage.seleccionarCheckoutComoInvitado();
    }
    
    @Step("Completar datos personales")
    public void completarDatosPersonales(String firstName, String lastName, String email, 
                                       String telephone, String address, String city,
                                       String postcode, String country) {
        checkoutPage.completarDatosPersonales(firstName, lastName, email, telephone,
                                             address, city, postcode, country);
    }
    
    @Step("Continuar a método de envío")
    public void continuarAMetodoEnvio() {
        checkoutPage.continuarAMetodoEnvio();
    }
    
    @Step("Continuar a método de pago")
    public void continuarAMetodoPago() {
        checkoutPage.continuarAMetodoPago();
    }
    
    @Step("Aceptar términos y condiciones")
    public void aceptarTerminosYCondiciones() {
        checkoutPage.aceptarTerminosYCondiciones();
    }
    
    @Step("Confirmar pedido")
    public void confirmarPedido() {
        checkoutPage.confirmarPedido();
    }
    
    @Step("Verificar confirmación del pedido: {0}")
    public void verificarConfirmacionPedido(String mensajeEsperado) {
        String mensajeActual = checkoutPage.obtenerMensajeConfirmacion();
        Assertions.assertEquals(mensajeEsperado, mensajeActual,
                              "El mensaje de confirmación no coincide");
    }
}