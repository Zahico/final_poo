package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Despacho {

    private static int contador = 0;

    private final String codigo;
    private final String mensajero;
    private List<Paquete> paquetes;

    public Despacho(String mensajero) {
        contador++;
        this.codigo = "D-" + contador;
        this.mensajero = mensajero;
        this.paquetes = new ArrayList<>();
    }

    public void agregarPaquete(Paquete p) throws GuiaDuplicadaException, PesoExcedidoException {
        if (paquetes.contains(p)) {
            throw new GuiaDuplicadaException("No se pudo subir el paquete " + p.getGuia() + " al despacho " + codigo + ": ya hay otro paquete con esa misma guia");
        }
        if (getPesoTotal() + p.getPeso() > Utilidades.PesoMaxMoto) {
            throw new PesoExcedidoException("No se pudo subir el paquete " + p.getGuia() + " (" + p.getPeso() + " kg) al despacho " + codigo + ": la moto ya lleva " + getPesoTotal() + " kg y se pasaria de 30 kg");
        }
        paquetes.add(p);
    }

    public double getPesoTotal() {
        double total = 0;
        for (Paquete p : paquetes) {
            total += p.getPeso();
        }
        return total;
    }

    public double getCostoTotal() {
        double total = 0;
        for (Paquete p : paquetes) {
            total = total + p.calcularCosto();
        }
        return total;
    }

    public List<String> getAdvertencias() {
        List<String> advertencias = new ArrayList<>();
        List<Paquete> ordenados = new ArrayList<>(paquetes);
        Collections.sort(ordenados);
        for (Paquete p : ordenados) {
            if (p instanceof ManejoEspecial) {
                ManejoEspecial especial = (ManejoEspecial) p;
                advertencias.add(p.getGuia() + " - " + especial.getAdvertencia());
            }
        }
        return advertencias;
    }

    public void imprimirManifiesto() {
     //nose que poner :,(
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensajero() {
        return mensajero;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    @Override
    public String toString() {
        return "Despacho{" + "codigo='" + codigo + ", mensajero='" + mensajero + '\'' + ", paquetes=" + paquetes.size() + '}';
    }
}
