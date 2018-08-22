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
public class Estado {
    
    private int estado_id;
    private String descripcion;
    //private int pais_id;

    public Estado(int estado_id, String descripcion /* int pais_id*/) {
        this.estado_id = estado_id;
        this.descripcion = descripcion;
        //this.pais_id = pais_id;
    }

    public Estado() {
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } 

//    public int getPais_id() {
//        return pais_id;
//    }
//
//    public void setPais_id(int pais_id) {
//        this.pais_id = pais_id;
//    }   

    @Override
    public String toString() {
        return "Estado{" + "estado_id=" + estado_id + ", descripcion=" + descripcion + '}';
    }
    
    
}
