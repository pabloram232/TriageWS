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
public class ResultTriage {

    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String sexo;
    private String fecha_nacimiento;
    private String descripcion_alergia;
    private String curp;
    private String numero_seguro;
    private String calle;
    private int numero;
    private String colonia;
    private String municipio;
    private String numero_telefono;
    private String enfermedad;
    private String sintoma;
    private String desc_dolor;
    private int fc;
    private int fr;
    private int temperatura;
    private int ta_sistolica;
    private int ta_diastolica;
    private int g_apertura_ocular;
    private int g_respuesta_motora;
    private int g_respuesta_verbal;
    private int g_total;
    private String estado;
    private String tipo_sangre;
    private int nivel_dolor;

    public ResultTriage(String nombre, String apellido_paterno, String apellido_materno, String sexo, String fecha_nacimiento, String descripcion_alergia, String curp, String numero_seguro, String calle, int numero, String colonia, String municipio, String numero_telefono, String enfermedad, String sintoma, String desc_dolor, int fc, int fr, int temperatura, int ta_sistolica, int ta_diastolica, int g_apertura_ocular, int g_respuesta_motora, int g_respuesta_verbal, int g_total, String estado, String tipo_sangre, int nivel_dolor) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.descripcion_alergia = descripcion_alergia;
        this.curp = curp;
        this.numero_seguro = numero_seguro;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.numero_telefono = numero_telefono;
        this.enfermedad = enfermedad;
        this.sintoma = sintoma;
        this.desc_dolor = desc_dolor;
        this.fc = fc;
        this.fr = fr;
        this.temperatura = temperatura;
        this.ta_sistolica = ta_sistolica;
        this.ta_diastolica = ta_diastolica;
        this.g_apertura_ocular = g_apertura_ocular;
        this.g_respuesta_motora = g_respuesta_motora;
        this.g_respuesta_verbal = g_respuesta_verbal;
        this.g_total = g_total;
        this.estado = estado;
        this.tipo_sangre = tipo_sangre;
        this.nivel_dolor = nivel_dolor;
    }

   

    public ResultTriage() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }

    public int getNivel_dolor() {
        return nivel_dolor;
    }

    public void setNivel_dolor(int nivel_dolor) {
        this.nivel_dolor = nivel_dolor;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDescripcion_alergia() {
        return descripcion_alergia;
    }

    public void setDescripcion_alergia(String descripcion_alergia) {
        this.descripcion_alergia = descripcion_alergia;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNumero_seguro() {
        return numero_seguro;
    }

    public void setNumero_seguro(String numero_seguro) {
        this.numero_seguro = numero_seguro;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
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

    public String getDesc_dolor() {
        return desc_dolor;
    }

    public void setDesc_dolor(String desc_dolor) {
        this.desc_dolor = desc_dolor;
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

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
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
    
    
    

}
