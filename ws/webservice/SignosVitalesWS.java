/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.SignosVitales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author kevin
 */
@WebService(serviceName = "SignosVitalesWS")
@Stateless()
public class SignosVitalesWS {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @WebMethod(operationName = "insertSignosVitales")
    public String insertSignosVitales( 
            @WebParam(name = "fc") float fc,
            @WebParam(name = "fr") float fr,
            @WebParam(name = "temperatura") float temperatura,
            @WebParam(name = "ta_sistolica") float ta_sistolica,
            @WebParam(name = "ta_diastolica") float ta_diastolica,
            @WebParam(name = "g_apertura_ocular") int g_apertura_ocular,
            @WebParam(name = "g_respuesta_verval") int g_respuesta_verval,
            @WebParam(name = "g_respuesta_motora") int g_respuesta_motora,
            @WebParam(name = "g_total") int g_total){
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertSignosVitales= 0;
        String result = "";
        SignosVitales signosVitales = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("INSERT INTO signos_paciente (fc, fr, temperatura, ta_sistolica, ta_diastolica, g_apertura_ocular, g_respuesta_verval, g_respuesta_motora, g_total) VALUES(?,?,?,?,?,?,?,?,?);");
                ps.setFloat(1, fc);
                ps.setFloat(2, fr);
                ps.setFloat(3, temperatura);
                ps.setFloat(4, ta_sistolica);
                ps.setFloat(5, ta_diastolica);
                ps.setInt(6, g_apertura_ocular);
                ps.setInt(7, g_respuesta_verval);
                ps.setInt(8, g_respuesta_motora);
                ps.setInt(9, g_total);
                resultInsertSignosVitales = ps.executeUpdate();
                
                System.out.println("Resultado de inserccion de enfermedad "+ resultInsertSignosVitales);
                if (resultInsertSignosVitales == 1) {
                    result = "inserto Signos  ";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
