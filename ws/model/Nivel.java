/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

/**
 *
 * @author LUIS-SOMA
 */
public class Nivel {
    
    private int  nivel_id;
    private int nivel;
    private String descripcion;

    public Nivel(int nivel_id, int nivel, String descripcion) {
        this.nivel_id = nivel_id;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

    public Nivel() {
    }

    public int getNivel_id() {
        return nivel_id;
    }

    public void setNivel_id(int nivel_id) {
        this.nivel_id = nivel_id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    
}
