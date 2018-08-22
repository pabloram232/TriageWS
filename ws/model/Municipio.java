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
public class Municipio {
    
    private int municipio_id;
    private String descripcion;
    //private int estado_id;

    public Municipio(int municipio_id, String descripcion/*, int estado_id*/) {
        this.municipio_id = municipio_id;
        this.descripcion = descripcion;
       // this.estado_id = estado_id;
    }

    public Municipio() {
    }

    public int getMunicipio_id() {
        return municipio_id;
    }

    public void setMunicipio_id(int municipio_id) {
        this.municipio_id = municipio_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public int getEstado_id() {
//        return estado_id;
//    }
//
//    public void setEstado_id(int estado_id) {
//        this.estado_id = estado_id;
//    }
    
}
