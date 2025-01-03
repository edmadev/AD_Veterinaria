/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.Model;

import java.sql.Date;

/**
 * Clase que contiene todos los datos de la vacuna que le corresponde al
 * paciente según su id.
 *
 * @author dam
 */
public class Vacuna {

    private int idMascota;
    private int idVacuna;
    private java.sql.Date fecha;
    private String enfermedad;
    private java.sql.Date fechaProxima;

    public Vacuna(int idMascota, Date fecha, String enfermedad, Date fechaProxima) {
        this.idMascota = idMascota;
        this.fecha = fecha;
        this.enfermedad = enfermedad;
        this.fechaProxima = fechaProxima;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public java.sql.Date getFechaProxima() {
        return fechaProxima;
    }

    public void setFechaProxima(java.sql.Date fechaProxima) {
        this.fechaProxima = fechaProxima;
    }

    @Override
    public String toString() {
        return "Vacuna{" + "idMascota=" + idMascota + ", idVacuna=" + idVacuna + ", fecha=" + fecha + ", enfermedad=" + enfermedad + ", fechaProxima=" + fechaProxima + '}';
    }

}
