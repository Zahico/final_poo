package org.example;

public class PaqueteEstandar extends Paquete {

    public PaqueteEstandar(String guia, double peso, Zona zona) throws GuiaInvalidaException, PesoInvalidoException {
        super(guia, peso, zona);
    }

    @Override
    public double calcularCosto() {
        return getCostoBase();
    }

    @Override
    public String getServicio() {
        return "Estándar";
    }

    @Override
    public String getAjuste() {
        return "-";
    }
}
