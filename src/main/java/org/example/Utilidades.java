package org.example;

import java.util.Locale;

public class Utilidades {

    public static final double PesoMaxPaquete = 20;
    public static final double PesoMaxMoto = 30;

    private Utilidades() {
    }

    }

    public static String formatoPlata(double valor) {
        return String.format(new Locale("es", "CO"), "%,.0f", valor);
    }

    public static String formatoPeso(double peso) {
        return String.format(new Locale("es", "CO"), "%.1f kg", peso);
    }
}
