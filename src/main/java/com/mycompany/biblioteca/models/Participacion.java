/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca.models;

/**
 *
 * @author dam
 */
public class Participacion {
    private int idParticipacion;
    private int idEvento;
    private int idUsuario;

    public Participacion(int idParticipacion, int idEvento, int idUsuario) {
        this.idParticipacion = idParticipacion;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    public int getIdParticipacion() {
        return idParticipacion;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Participaciones{" + "idParticipacion=" + idParticipacion + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
