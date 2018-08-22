/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.model;

import java.sql.Date;

/**
 *
 * @author kevin
 */
public class Paciente {
    private int paciente_id;
    private String numero_seguro;
    private String fecha_nacimiento;
    private int tipo_sangre_id_fk;
    private int persona_id;
    private int edad;
    private Boolean alergico;
    private String descripcion_alergia;
    private String numero_telefono;
    private int domicilio_id;
    private int nivel_dolor;
    private String desc_dolor;
    private int enfermedad_id;
    private int sintoma_id;

    public Paciente(int paciente_id, String numero_seguro, String fecha_nacimiento, int tipo_sangre_id_fk, int persona_id, int edad, Boolean alergico, String descripcion_alergia, String numero_telefono, int domicilio_id, int nivel_dolor, String desc_dolor, int enfermedad_id, int sintoma_id) {
        this.paciente_id = paciente_id;
        this.numero_seguro = numero_seguro;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tipo_sangre_id_fk = tipo_sangre_id_fk;
        this.persona_id = persona_id;
        this.edad = edad;
        this.alergico = alergico;
        this.descripcion_alergia = descripcion_alergia;
        this.numero_telefono = numero_telefono;
        this.domicilio_id = domicilio_id;
        this.nivel_dolor = nivel_dolor;
        this.desc_dolor = desc_dolor;
        this.enfermedad_id = enfermedad_id;
        this.sintoma_id = sintoma_id;
    }

   
    

    

    public Paciente() {
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public String getNumero_seguro() {
        return numero_seguro;
    }

    public void setNumero_seguro(String numero_seguro) {
        this.numero_seguro = numero_seguro;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getTipo_sangre() {
        return tipo_sangre_id_fk;
    }

    public void setTipo_sangre(int tipo_sangre_id_fk) {
        this.tipo_sangre_id_fk = tipo_sangre_id_fk;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Boolean getAlergico() {
        return alergico;
    }

    public void setAlergico(Boolean alergico) {
        this.alergico = alergico;
    }

    public String getDescripcion_alergia() {
        return descripcion_alergia;
    }

    public void setDescripcion_alergia(String descripcion_alergia) {
        this.descripcion_alergia = descripcion_alergia;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public int getDomicilio_id() {
        return domicilio_id;
    }

    public void setDomicilio_id(int domicilio_id) {
        this.domicilio_id = domicilio_id;
    }

    public int getNivel_dolor() {
        return nivel_dolor;
    }

    public void setNivel_dolor(int nivel_dolor) {
        this.nivel_dolor = nivel_dolor;
    }

    public String getDesc_dolor() {
        return desc_dolor;
    }

    public void setDesc_dolor(String desc_dolor) {
        this.desc_dolor = desc_dolor;
    }

    public int getEnfermedad_id() {
        return enfermedad_id;
    }

    public void setEnfermedad_id(int enfermedad_id) {
        this.enfermedad_id = enfermedad_id;
    }

    public int getSintoma_id() {
        return sintoma_id;
    }

    public void setSintoma_id(int sintoma_id) {
        this.sintoma_id = sintoma_id;
    }
    
   
    
}
