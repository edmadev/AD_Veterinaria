/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

/**
 *
 * @author dam
 */
public class Multa {
    private int idMulta;
    private int idPrestamo;
    private double montoMulta;

    public Multa(int idMulta, int idPrestamo, double montoMulta) {
        this.idMulta = idMulta;
        this.idPrestamo = idPrestamo;
        this.montoMulta = montoMulta;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public double getMontoMulta() {
        return montoMulta;
    }

    public void setMontoMulta(double montoMulta) {
        this.montoMulta = montoMulta;
    }

    @Override
    public String toString() {
        return "Multa{" + "idMulta=" + idMulta + ", idPrestamo=" + idPrestamo + ", montoMulta=" + montoMulta + '}';
    }
    
    
}
