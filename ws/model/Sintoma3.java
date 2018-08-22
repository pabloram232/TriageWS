/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

/**
 *
 * @author chiva
 */
public class Sintoma2 {
    
     private int sintoma_id;
    private String descripcion;
    private int prioridad_id;
    
    
       public Sintoma2(int sintoma_id, String descripcion, int prioridad_id) {
        this.sintoma_id = sintoma_id;
        this.descripcion = descripcion;
        this.prioridad_id = prioridad_id;
    }

    public Sintoma2() {
    }
       
       
       

    public int getSintoma_id() {
        return sintoma_id;
    }

    public void setSintoma_id(int sintoma_id) {
        this.sintoma_id = sintoma_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad_id() {
        return prioridad_id;
    }

    public void setPrioridad_id(int prioridad_id) {
        this.prioridad_id = prioridad_id;
    }
       
       
    
}
