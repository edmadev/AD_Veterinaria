/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesellago.tema2.MascotasApp.Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * Clase que contiene todos los datos del paciente
 *
 * @author mauri_
 */
public class Paciente {

    private int idMascota;
    private String aliasMascota;
    private String especie;
    private String raza;
    private String colorPelo;
    private java.sql.Date fechaNacimiento;
    private int vacunaciones;
    

    public Paciente() {
    }

    /**
     * Constructor del paciente
     *
     * @param aliasMascota
     * @param especie
     * @param raza
     * @param colorPelo
     * @param fechaNacimiento
     * @param vacunaciones
     */
    public Paciente(String aliasMascota, String especie, String raza, String colorPelo, Date fechaNacimiento, int vacunaciones) {
        this.aliasMascota = aliasMascota;
        this.especie = especie;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fechaNacimiento = fechaNacimiento;
        this.vacunaciones = 0;
    }

    /**
     * Constructor del paciente con un parámetro extra
     *
     * @param idMascota Permite modificar el id de la mascota si es necesario
     * @param aliasMascota
     * @param especie
     * @param raza
     * @param colorPelo
     * @param fechaNacimiento
     * @param vacunaciones
     */
    public Paciente(int idMascota, String aliasMascota, String especie, String raza, String colorPelo, Date fechaNacimiento, int vacunaciones) {
        this.idMascota = idMascota;
        this.aliasMascota = aliasMascota;
        this.especie = especie;
        this.raza = raza;
        this.colorPelo = colorPelo;
        this.fechaNacimiento = fechaNacimiento;
        this.vacunaciones = vacunaciones;
    }

    public Paciente(int idMascota, String aliasMascota, int vacunaciones) {
        this.idMascota = idMascota;
        this.aliasMascota = aliasMascota;
        this.vacunaciones = vacunaciones;
    }

  

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getAliasMascota() {
        return aliasMascota;
    }

    public void setAliasMascota(String aliasMascota) {
        this.aliasMascota = aliasMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public java.sql.Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.sql.Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getVacunaciones() {
        return vacunaciones;
    }

    public void setVacunaciones(int vacunaciones) {
        this.vacunaciones = vacunaciones;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idMascota=" + idMascota + ", aliasMascota=" + aliasMascota + ", especie=" + especie + ", raza=" + raza + ", colorPelo=" + colorPelo + ", fechaNacimiento=" + fechaNacimiento + ", vacunaciones=" + vacunaciones + '}';
    }

    

    
}
