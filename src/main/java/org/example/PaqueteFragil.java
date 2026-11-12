package org.example;

public class PaqueteFragil extends Paquete implements ManejoEspecial {

    private final String contenido;

    public PaqueteFragil(String guia, double peso, Zona zona, String contenido) throws GuiaInvalidaException, PesoInvalidoException, ContenidoInvalidoException {
        super(guia, peso, zona);
        if (contenido == null || contenido.isEmpty()) {
            throw new ContenidoInvalidoException("El paquete fragil " + guia + " no tiene contenido, hay que decir que lleva para poder registrarlo");
        }
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public double calcularCosto() {
        return getCostoBase() + 5000;
    }

    @Override
    public String getServicio() {
        return "Frágil (" + contenido + ")";
    }

    @Override
    public String getAjuste() {
        return "+5.000";
    }

    @Override
    public String getAdvertencia() {
        return "FRAGIL (" + contenido + ")";
    }
}
