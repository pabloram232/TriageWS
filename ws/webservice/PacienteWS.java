/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Paciente2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author chiva
 */
@WebService
@Stateless
@LocalBean
public class PacienteWS {
    
        
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;

         @WebMethod(operationName = "getAllPacienteAtendidos")
    public Paciente2[] getAllPacientesAtendidos() {
        Paciente2[] result = null;
        List<Paciente2> pacientes = new ArrayList<Paciente2>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(
                        "SELECT paciente_id, persona_id_fk, pe.nombre, pe.apellido_paterno, pe.apellido_materno, estatus "
                      + "FROM paciente pa "
                      + "INNER JOIN persona pe on pa.persona_id_fk = pe.persona_id "
                      + "WHERE estatus = false ORDER BY paciente_id;");
                while (resultSet.next()) {
                    Paciente2 paciente = new Paciente2(
                            resultSet.getInt("paciente_id"),
                            resultSet.getInt("persona_id_fk"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"),
                            resultSet.getBoolean("estatus"));
                    pacientes.add(paciente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = pacientes.toArray(new Paciente2[pacientes.size()]);
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizaEstatus")
    public String actualizaEstatus(@WebParam(name = "paciente_id") int paciente_id) {
         con = new ConexionDB();
        connection = con.conectar();
        int resultPS = 0;
        String result = "";
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement(
                        "UPDATE public.paciente SET estatus = true WHERE paciente_id=?;");
                ps.setInt(1, paciente_id);
                resultPS = ps.executeUpdate();
                if(resultPS == 1){
                    result = "exito";
                }else{
                    result = "error";
                } 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    
    

}
