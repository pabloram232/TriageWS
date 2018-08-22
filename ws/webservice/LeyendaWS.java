
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Leyenda;
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
 * @author LUIS-SOMA
 */
@WebService
@Stateless
@LocalBean
public class LeyendaWS {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertLeyenda")
    public String insertLeyenda(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        con = new ConexionDB();
        connection = con.conectar();
        int insertLeyenda = 0;
        String result = "error";
        if (connection != null) {
            try {
                ps = connection.prepareStatement("INSERT INTO leyenda (nombre, descripcion) VALUES(?,?);");
                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                insertLeyenda = ps.executeUpdate();
                if (insertLeyenda == 1) {
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateLeyenda")
    public String updateLeyenda(@WebParam(name = "leyenda_id") int leyenda_id,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "descripcion") String descripcion) {
        con = new ConexionDB();
        connection = con.conectar();
        String result = "error";
        int updateLeyenda = 0;
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE leyenda SET nombre = ?, descripcion = ? WHERE leyenda_id = ? ;");
                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                ps.setInt(3, leyenda_id);
                updateLeyenda = ps.executeUpdate();
                if (updateLeyenda == 1) {
                    result = "exito";
                } else {
                    result = "error";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteLeyenda")
    public String deleteLeyenda(@WebParam(name = "leyenda_id") int leyenda_id) {
        con = new ConexionDB();
        connection = con.conectar();
        int deleteLeyenda = 0;
        String result = "error";
        if (connection != null) {
            try {
                ps = connection.prepareStatement("DELETE FROM leyenda WHERE leyenda_id = ?;");
                ps.setInt(1, leyenda_id);
                deleteLeyenda = ps.executeUpdate();
                if (deleteLeyenda == 1) {
                    result = "exito";
                } else {
                    result = "error";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllLeyendas")
    public Leyenda[] getAllLeyendas() {
        Leyenda[] result = null;
        List<Leyenda> leyendas = new ArrayList<Leyenda>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT leyenda_id, nombre, descripcion FROM leyenda;");
                while (resultSet.next()) {
                    Leyenda leyenda = new Leyenda(
                                resultSet.getInt("leyenda_id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("descripcion"));
                    leyendas.add(leyenda);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
         result = leyendas.toArray(new Leyenda[leyendas.size()]);
        return result;
    }

}
