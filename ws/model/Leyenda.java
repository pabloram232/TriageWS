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
public class Leyenda {
    private int leyenda_id;
    private String nombre;
    private String descripcion;

    public Leyenda(int leyenda_id, String nombre, String descripcion) {
        this.leyenda_id = leyenda_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getLeyenda_id() {
        return leyenda_id;
    }

    public void setLeyenda_id(int leyenda_id) {
        this.leyenda_id = leyenda_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
