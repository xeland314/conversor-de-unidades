package com.xeland314.app;

public enum Alertas {
    
    ENTRADA_INVALIDA(
        "Entrada inválida", 
        "Ingrese una expresión válida."
    ),
    TEMPERATURA_INVALIDA(
        "Temperatura Inválida",
        "Ingrese un valor válido de temperatura."
    ),
    DIVISA_INVALIDA(
        "Divisa Inválida",
        "Ingrese un valor válido para esta divisa."
    ),
    TIEMPO_INVALIDO(
        "Tiempo Invalido",
        "Ingrese un valor válido de tiempo."
    ),
    LONGITUD_INVALIDA(
        "Longitud Inválida",
        "Ingrese un valor válido de longitud"
    );

    private Alerta alerta;

    private Alertas(String titulo, String mensaje) {
        this.alerta = new Alerta(titulo, mensaje);
    }

    public void lanzarAlerta() {
        this.alerta.lanzar();
    }

}
