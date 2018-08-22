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
public class Domicilio {
    private  int domicilio_id;
    private String colonia;
    private String calle;
    private int numero;
    private int municipio_id_fk;

    public Domicilio(int domicilio_id, String colonia, String calle, int numero, int municipio_id_fk) {
        this.domicilio_id = domicilio_id;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
        this.municipio_id_fk = municipio_id_fk;
    }

    public Domicilio() {
    }

    public int getDomicilio_id() {
        return domicilio_id;
    }

    public void setDomicilio_id(int domicilio_id) {
        this.domicilio_id = domicilio_id;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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

    public int getMunicipio_id_fk() {
        return municipio_id_fk;
    }

    public void setMunicipio_id_fk(int municipio_id_fk) {
        this.municipio_id_fk = municipio_id_fk;
    }
    
    
    
    
}
