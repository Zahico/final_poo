package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void caso1() {
        Despacho despacho = new Despacho("Andres");
        try {
            despacho.agregarPaquete(new PaqueteEstandar("EY2001", 5, Zona.ORIENTE));
            despacho.agregarPaquete(new PaqueteExpress("EY2002", 1.5, Zona.NORTE));
            despacho.agregarPaquete(new PaqueteFragil("EY2003", 2, Zona.CENTRO, "vajilla"));
            despacho.agregarPaquete(new PaqueteEstandar("EY2004", 8, Zona.CENTRO));
            despacho.agregarPaquete(new PaqueteExpress("EY2005", 6, Zona.ORIENTE));
            despacho.agregarPaquete(new PaqueteFragil("EY2006", 3.5, Zona.SUR, "televisor"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        despacho.imprimirManifiesto();
    }

    public static void caso2() {
        try {
            Paquete p1 = new PaqueteEstandar("EY3001", -2, Zona.CENTRO);
            System.out.println("Se creo el paquete " + p1);
        } catch (GuiaInvalidaException | PesoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Paquete p2 = new PaqueteFragil("EY3002", 2, Zona.NORTE, "");
            System.out.println("Se creo el paquete " + p2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Paquete p3 = new PaqueteEstandar("EY12A4", 3, Zona.SUR);
            System.out.println("Se creo el paquete " + p3);
        } catch (GuiaInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PesoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Paquete p4 = new PaqueteExpress("EY3003", 22, Zona.NORTE);
            System.out.println("Se creo el paquete " + p4);
        } catch (GuiaInvalidaException | PesoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void caso3() {
        Despacho despacho = new Despacho("Camila");

        try {
            despacho.agregarPaquete(new PaqueteEstandar("EY4001", 12, Zona.CENTRO));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            despacho.agregarPaquete(new PaqueteExpress("EY4002", 10, Zona.SUR));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            despacho.agregarPaquete(new PaqueteFragil("EY4003", 9, Zona.NORTE, "espejo"));
        } catch (PesoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            despacho.agregarPaquete(new PaqueteEstandar("EY4004", 8, Zona.ORIENTE));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        despacho.imprimirManifiesto();
    }

    public static void caso4() {
        Despacho despacho = new Despacho("Mateo");

        try {
            despacho.agregarPaquete(new PaqueteFragil("EY5001", 3, Zona.SUR, "lámpara"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            despacho.agregarPaquete(new PaqueteEstandar("EY5001", 1, Zona.CENTRO));
        } catch (GuiaDuplicadaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            despacho.agregarPaquete(new PaqueteExpress("EY5002", 2, Zona.CENTRO));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        despacho.imprimirManifiesto();
    }
}
