/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

/**
 *
 * @author naiyu
 */
public class Historial {

    private int paciente_id; 
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String enfermedad;
    private String sintoma;
    private int fc;
    private int fr;
    private int g_apertura_ocular;
    private int g_respuesta_motora;
    private int g_respuesta_verbal;
    private int g_total;
    private int ta_sistolica;
    private int ta_diastolica;
    private String observaciones;

    public Historial(int paciente_id, String nombre, String apellido_paterno, String apellido_materno,
            String enfermedad, String sintoma, int fc, int fr, int g_apertura_ocular, int g_respuesta_motora, 
            int g_respuesta_verbal, int g_total, int ta_sistolica, int ta_diastolica, String observaciones) {
        this.paciente_id = paciente_id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.enfermedad = enfermedad;
        this.sintoma = sintoma;
        this.fc = fc;
        this.fr = fr;
        this.g_apertura_ocular = g_apertura_ocular;
        this.g_respuesta_motora = g_respuesta_motora;
        this.g_respuesta_verbal = g_respuesta_verbal;
        this.g_total = g_total;
        this.ta_sistolica = ta_sistolica;
        this.ta_diastolica = ta_diastolica;
        this.observaciones = observaciones;
    }

    public Historial() {
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
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

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFr() {
        return fr;
    }

    public void setFr(int fr) {
        this.fr = fr;
    }

    public int getG_apertura_ocular() {
        return g_apertura_ocular;
    }

    public void setG_apertura_ocular(int g_apertura_ocular) {
        this.g_apertura_ocular = g_apertura_ocular;
    }

    public int getG_respuesta_motora() {
        return g_respuesta_motora;
    }

    public void setG_respuesta_motora(int g_respuesta_motora) {
        this.g_respuesta_motora = g_respuesta_motora;
    }

    public int getG_respuesta_verbal() {
        return g_respuesta_verbal;
    }

    public void setG_respuesta_verbal(int g_respuesta_verbal) {
        this.g_respuesta_verbal = g_respuesta_verbal;
    }

    public int getG_total() {
        return g_total;
    }

    public void setG_total(int g_total) {
        this.g_total = g_total;
    }

    public int getTa_sistolica() {
        return ta_sistolica;
    }

    public void setTa_sistolica(int ta_sistolica) {
        this.ta_sistolica = ta_sistolica;
    }

    public int getTa_diastolica() {
        return ta_diastolica;
    }

    public void setTa_diastolica(int ta_diastolica) {
        this.ta_diastolica = ta_diastolica;
    }
    
   
}
