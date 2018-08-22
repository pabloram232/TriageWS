/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

import java.util.Date;

/**
 *
 * @author chiva
 */
public class Paciente2 {
    
    
    private int id;
    private int persona_fk;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private boolean estatus;

    public Paciente2(int id, int persona_fk, String nombre, String apellido_peterno, String apellido_materno, boolean estatus) {
        this.id = id;
        this.persona_fk = persona_fk;
        this.nombre = nombre;
        this.apellido_paterno = apellido_peterno;
        this.apellido_materno = apellido_materno;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersona_fk() {
        return persona_fk;
    }

    public void setPersona_fk(int persona_fk) {
        this.persona_fk = persona_fk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

   
    
}
