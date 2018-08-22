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
public class CtSexo {
    private int sexo_id; 
    private String descripcion;

    public CtSexo(int sexo_id, String descripcion) {
        this.sexo_id = sexo_id;
        this.descripcion = descripcion;
    }

    public CtSexo() {
    }

    public int getSexo_id() {
        return sexo_id;
    }

    public void setSexo_id(int sexo_id) {
        this.sexo_id = sexo_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
