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
public class User {
    private int usuario_id;
    private String user;
    private String pass;
    private boolean status;
    private int persona_id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String curp;
    private int persona_id_fk;
    private String rol;

    public User(int usuario_id, String user, String pass, boolean status, int persona_id, String nombre, String apellido_paterno, String apellido_materno, String curp) {
        this.usuario_id = usuario_id;
        this.user = user;
        this.pass = pass;
        this.status = status;
        this.persona_id = persona_id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.curp = curp;
    }

    
    
    public User(int usuario_id, String user, String pass, int persona_id_fk) {
        this.usuario_id = usuario_id;
        this.user = user;
        this.pass = pass;
        this.persona_id_fk = persona_id_fk;
    }

    public User(String rol) {
        this.rol = rol;
    }
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    

    public int getPersona_id_fk() {
        return persona_id_fk;
    }

    public void setPersona_id_fk(int persona_id_fk) {
        this.persona_id_fk = persona_id_fk;
    }

  
    
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
        
    

    
    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
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

    
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + user + ", pass=" + pass + '}';
    }
}
