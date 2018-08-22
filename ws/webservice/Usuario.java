/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author chiva
 */
@WebService
@Stateless
@LocalBean
public class Usuario {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuario")
    public String getUsuario(@WebParam(name = "nombre_usuario") String nombre_usuario, @WebParam(name = "contrasenia") String contrasenia) {
        //TODO write your implementation code here:
        String saludo = "";
        if(nombre_usuario.equals("luis") && contrasenia.equals("123")){
            saludo = "Hola "+nombre_usuario;
        } 
        return saludo;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
