package org.example;

import java.util.Objects;

public abstract class Paquete implements Comparable<Paquete> {

    private final String guia;
    private final double peso;
    private final Zona zona;

    public Paquete(String guia, double peso, Zona zona) throws GuiaInvalidaException, PesoInvalidoException {
        if (!Utilidades.guiaValida(guia)) {
            throw new GuiaInvalidaException("La guia " + guia + " no es valida, debe ser EY seguido de exactamente 4 digitos (ej: EY0451)");
        }
        if (peso <= 0) {
            throw new PesoInvalidoException("El paquete " + guia + " tiene un peso invalido de " + peso + " kg, tiene que pesar mas de 0 kg");
        }
        if (peso > Utilidades.PESO_MAX_PAQUETE) {
            throw new PesoInvalidoException("El paquete " + guia + " pesa " + peso + " kg y no se puede llevar en moto (maximo 20 kg)");
        }
        this.guia = guia;
        this.peso = peso;
        this.zona = zona;
    }

    public double getCostoBase() {
        return zona.getTarifa() + peso * 1000;
    }

    public abstract double calcularCosto();

    public abstract String getServicio();

    public abstract String getAjuste();

    public boolean esExpress() {
        return false;
    }

    public String getGuia() {
        return guia;
    }

    public double getPeso() {
        return peso;
    }

    public Zona getZona() {
        return zona;
    }

    @Override
    public int compareTo(Paquete otro) {
        if (this.esExpress() && !otro.esExpress()) {
            return -1;
        }
        if (!this.esExpress() && otro.esExpress()) {
            return 1;
        }
        if (this.zona != otro.zona) {
            return this.zona.ordinal() - otro.zona.ordinal();
        }
        return this.guia.compareTo(otro.guia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paquete)) return false;
        Paquete paquete = (Paquete) o;
        return guia.equals(paquete.guia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guia);
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "guia='" + guia + '\'' +
                ", servicio=" + getServicio() +
                ", peso=" + peso +
                ", zona=" + zona +
                '}';
    }
}
