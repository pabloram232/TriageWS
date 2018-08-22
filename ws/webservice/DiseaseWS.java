/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Disease;
import com.utng.ws.model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author kevin
 */
@WebService
@Stateless
@LocalBean
public class DiseaseWS {    
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    
     // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @WebMethod(operationName = "insertDisease")
    public String insertDisease(
            @WebParam(name = "descripcion") String descripcion) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertEnfernedad = 0;
        String result = "";
        Persona persona = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("INSERT INTO enfermedad (descripcion) VALUES(?);");
                ps.setString(1, descripcion);
                resultInsertEnfernedad = ps.executeUpdate();
                
                System.out.println("Resultado de inserccion de enfermedad "+ resultInsertEnfernedad);
                if (resultInsertEnfernedad == 1) {
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
    
    /**
     * Web service operation
     */

    @WebMethod(operationName = "deleteDisease")
    public String deleteDisease(@WebParam(name = "idDisease") int idDisease) {
        //TODO write your implementation code here:
        con = new ConexionDB();
        connection = con.conectar();
        Disease disease = null;
        int result = 0;
         String retorna = "";
        if (connection != null) {
            try {
                ps = connection.prepareStatement("SELECT enfermedad_id, descripcion "
                                                + "FROM enfermedad "
                                                + "WHERE enfermedad_id = ? ;");
                ps.setInt(1, idDisease);
                resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    disease = new Disease(
                            resultSet.getInt("enfermedad_id"),
                            resultSet.getString("descripcion"));
                }
                //int id_persona = user.getPersona_id();
                ps = connection.prepareStatement(
                        "DELETE FROM enfermedad WHERE enfermedad_id =?;");
                ps.setInt(1, idDisease);
                result = ps.executeUpdate();
                if(result == 1){
                    retorna = "exito";
                }else{
                    retorna= "error";
                }                
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return retorna;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateDisease")
    public String updateDisease(
            @WebParam(name = "descripcion") String decripcion, 
            @WebParam(name = "enfermedadId") int enfermedadId){
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertDisease = 0;
        String result = "";
        Disease disease = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE enfermedad " 
                        + " SET descripcion=?" + " WHERE enfermedad_id=?;");
                ps.setString(1, decripcion);
                ps.setInt(2, enfermedadId);
                resultInsertDisease = ps.executeUpdate();
                if (resultInsertDisease == 1) {
                    result = "exito";
                } else {
                    result = "error";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    
        @WebMethod(operationName = "getAllDisease")
    public Disease[] getAllDisease() {
        Disease[] result = null;
            List<Disease> diseases = new ArrayList<Disease>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT enfermedad_id, descripcion FROM enfermedad;");
                while (resultSet.next()) {
                    Disease disease= new Disease(
                            resultSet.getInt("enfermedad_id"),
                            resultSet.getString("descripcion"));
                    diseases.add(disease);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = diseases.toArray(new Disease[diseases.size()]);
        return result;
    }
    

}