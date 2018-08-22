/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Level;
import com.utng.ws.model.Persona;
import com.utng.ws.model.User;
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
 * @author PabloRam
 */
@WebService
@Stateless
@LocalBean
public class LevelWS {
    
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    
    
          @WebMethod(operationName = "getLevels")
    public Level[] getLevels() {
        Level[] result = null;
        List<Level> levels = new ArrayList<Level>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(
                        "SELECT nivel_id, nivel, descripcion FROM ct_prioridad ;");
                while (resultSet.next()) {
                    Level level = new Level(
                            resultSet.getInt("nivel_id"),
                            resultSet.getInt("nivel"),
                            resultSet.getString("descripcion"));
                    levels.add(level);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = levels.toArray(new Level[levels.size()]);
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @WebMethod(operationName = "insertLevel")
    public String insertLevel(@WebParam(name = "nivel") Integer nivel,
            @WebParam(name = "descripcion") String descripcion) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertNivel= 0;
        String result = "";
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("INSERT INTO ct_prioridad (nivel, descripcion) VALUES(?,?);");
                ps.setInt(1, nivel);
                ps.setString(2, descripcion);
                resultInsertNivel = ps.executeUpdate();
                if (resultInsertNivel == 1) {
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
   @WebMethod(operationName = "deleteLevel")
    public String deleteLevel(@WebParam(name = "idLevel") int idLevel) {
        //TODO write your implementation code here:
        con = new ConexionDB();
        connection = con.conectar();
        int result = 0;
        String resultado = "";
        if (connection != null) {
            try {               
                ps = connection.prepareStatement(
                        "DELETE FROM ct_prioridad WHERE nivel_id =?;");
                ps.setInt(1, idLevel);
                result = ps.executeUpdate();
                if(result == 1){
                    resultado = "exito";
                }else{
                resultado= "error";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }

    /**
     * Web service operation
     */
      @WebMethod(operationName = "updatelevel")
    public String updateLevel(@WebParam(name = "prioridad_id") int prioridad_id, 
            @WebParam(name = "nivel") int nivel, 
            @WebParam(name = "descripcion") String descripcion) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultUpdateNivel = 0;
        String result = "";
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE ct_prioridad " 
                        + " SET nivel=?, descripcion=? " + " WHERE nivel_id=?;");
                ps.setInt(1, nivel);
                ps.setString(2, descripcion);
                ps.setInt(3,prioridad_id);
                resultUpdateNivel = ps.executeUpdate();
                if (resultUpdateNivel == 1) {
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
