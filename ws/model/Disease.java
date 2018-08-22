/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

/**
 *
 * @author kevin
 */
public class Disease {

    private int enfermedad_id;
    private String descripcion;
    
    public Disease(int enfermedad_id, String descripcion){
        this.enfermedad_id = enfermedad_id;
        this.descripcion = descripcion;
    }
    
    public int getEnfermedad_id() {
        return enfermedad_id;
    }

    public void setEnfermedad_id(int enfermedad_id) {
        this.enfermedad_id = enfermedad_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
