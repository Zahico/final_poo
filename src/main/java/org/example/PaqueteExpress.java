package org.example;

public class PaqueteExpress extends Paquete {

    public PaqueteExpress(String guia, double peso, Zona zona) throws GuiaInvalidaException, PesoInvalidoException {
        super(guia, peso, zona);
    }

    @Override
    public double calcularCosto() {
        return getCostoBase() * 1.5;
    }

    @Override
    public String getServicio() {
        return "Express";
    }

    @Override
    public String getAjuste() {
        return "+50%";
    }

    @Override
    public boolean esExpress() {
        return true;
    }
}
