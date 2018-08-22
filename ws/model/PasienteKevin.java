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
public class PasienteKevin {
    
    private int id;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private String curp;
    private  int sexo_id_fk;

    public PasienteKevin(int id, String nombre, String aPaterno, String aMaterno, String curp, int sexo_id_fk) {
        this.id = id;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.curp = curp;
        this.sexo_id_fk = sexo_id_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getSexo_id_fk() {
        return sexo_id_fk;
    }

    public void setSexo_id_fk(int sexo_id_fk) {
        this.sexo_id_fk = sexo_id_fk;
    }
    
    
    
    
    
}
