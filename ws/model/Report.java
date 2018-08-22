/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

/**
 *
 * @author PabloRam
 */
public class Report {
    private String nombre;
    private String enfermedad;
    private String sintoma;

    public Report(String nombre, String enfermedad, String sintoma) {
        this.nombre = nombre;
        this.enfermedad = enfermedad;
        this.sintoma = sintoma;
    }

    public Report() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
    
    
    
    
}
