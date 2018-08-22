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
public class TipoSangre {
    
    private int tipo_sangre_id;
    private String descripcion;

    public TipoSangre(int tipo_sangre_id, String descripcion) {
        this.tipo_sangre_id = tipo_sangre_id;
        this.descripcion = descripcion;
    }

    

    public TipoSangre() {
    }

    public int getTipo_sangre_id() {
        return tipo_sangre_id;
    }

    public void setTipo_sangre_id(int tipo_sangre_id) {
        this.tipo_sangre_id = tipo_sangre_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    
}
