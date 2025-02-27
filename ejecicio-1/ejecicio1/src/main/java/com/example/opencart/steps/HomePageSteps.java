package com.example.opencart.steps;

import com.example.opencart.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomePageSteps {
    
    private HomePage homePage;
    
    @Step("Abrir la página principal de OpenCart")
    public void abrirPaginaPrincipal() {
        homePage.abrirPagina();
    }
    
    @Step("Buscar producto: {0}")
    public void buscarProducto(String nombreProducto) {
        homePage.buscarProducto(nombreProducto);
    }
}