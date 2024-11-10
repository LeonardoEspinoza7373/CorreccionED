package com.proyecto.modelo;

public class ValidacionHTML {
    private String codigoHTML;
    private boolean esValido;

    public ValidacionHTML(String codigoHTML, boolean esValido) {
        this.codigoHTML = codigoHTML;
        this.esValido = esValido;
    }

    public String getCodigoHTML() {
        return codigoHTML;
    }

    public boolean isEsValido() {
        return esValido;
    }

    public void setCodigoHTML(String codigoHTML) {
        this.codigoHTML = codigoHTML;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }
}
