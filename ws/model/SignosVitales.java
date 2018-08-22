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
public class SignosVitales {
    private int id_signos;
    private int id_paciente;
    private float fc;
    private float fr;
    private float temperatura;
    private float ta_sistolica;
    private float ta_diastolica;
    private int g_apertura_ocular;
    private int g_respuesta_verval;
    private int g_respuesta_motora;
    private int g_total;

    public SignosVitales(int id_signos, int id_paciente, float fc, float fr, float temperatura, float ta_sistolica, float ta_diastolica, int g_apertura_ocular, int g_respuesta_verval, int g_respuesta_motora, int g_total) {
        this.id_signos = id_signos;
        this.id_paciente = id_paciente;
        this.fc = fc;
        this.fr = fr;
        this.temperatura = temperatura;
        this.ta_sistolica = ta_sistolica;
        this.ta_diastolica = ta_diastolica;
        this.g_apertura_ocular = g_apertura_ocular;
        this.g_respuesta_verval = g_respuesta_verval;
        this.g_respuesta_motora = g_respuesta_motora;
        this.g_total = g_total;
    }

    public SignosVitales() {
    }

    public int getId_signos() {
        return id_signos;
    }

    public void setId_signos(int id_signos) {
        this.id_signos = id_signos;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public float getFc() {
        return fc;
    }

    public void setFc(float fc) {
        this.fc = fc;
    }

    public float getFr() {
        return fr;
    }

    public void setFr(float fr) {
        this.fr = fr;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getTa_sistolica() {
        return ta_sistolica;
    }

    public void setTa_sistolica(float ta_sistolica) {
        this.ta_sistolica = ta_sistolica;
    }

    public float getTa_diastolica() {
        return ta_diastolica;
    }

    public void setTa_diastolica(float ta_diastolica) {
        this.ta_diastolica = ta_diastolica;
    }

    public int getG_apertura_ocular() {
        return g_apertura_ocular;
    }

    public void setG_apertura_ocular(int g_apertura_ocular) {
        this.g_apertura_ocular = g_apertura_ocular;
    }

    public int getG_respuesta_verval() {
        return g_respuesta_verval;
    }

    public void setG_respuesta_verval(int g_respuesta_verval) {
        this.g_respuesta_verval = g_respuesta_verval;
    }

    public int getG_respuesta_motora() {
        return g_respuesta_motora;
    }

    public void setG_respuesta_motora(int g_respuesta_motora) {
        this.g_respuesta_motora = g_respuesta_motora;
    }

    public int getG_total() {
        return g_total;
    }

    public void setG_total(int g_total) {
        this.g_total = g_total;
    }
    
    
    
    
}
