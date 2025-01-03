/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.Model;

import java.sql.Date;

/**
 * Clase que contiene todos los datos del peso del paciente según id.
 * @author dam
 */
public class Peso {
    private Paciente paciente;
    private int idMascota;
    private int idPeso;
    private java.sql.Date fecha;
    private double peso;

    public Peso(int idMascota, int idPeso, Date fecha, double peso) {
        this.idMascota = idMascota;
        this.idPeso = idPeso;
        this.fecha = fecha;
        this.peso = peso;
    }

    public Peso(int idMascota, int idPeso, double peso) {
        this.idMascota = idMascota;
        this.idPeso = idPeso;
        this.peso = peso;
    }
    
    

   
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(int idPeso) {
        this.idPeso = idPeso;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Peso{" + "idMascota=" + idMascota + ", idPeso=" + idPeso + ", fecha=" + fecha + ", peso=" + peso + '}';
    }
    
    public String toStringConPaciente(){
        return "Mascota{ "+ "idMascota= " +paciente.getIdMascota()+", aliasMascota= "+paciente.getAliasMascota()+", idPeso= "+idPeso+'}';
    }
    
}
