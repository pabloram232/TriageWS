/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Disease;
import com.utng.ws.model.Nivel;
import com.utng.ws.model.Persona;
import com.utng.ws.model.Sintoma2;
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


@WebService
@Stateless
@LocalBean
public class SintomaWS {    
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    
     @WebMethod(operationName = "insertSintoma")
    public String insertSintoma(@WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "nivel_id_fk") Integer nivel_id_fk,
            @WebParam(name = "enfermedad_id_fk") Integer enfermedad_id_fk) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertSintoma = 0;
        String result = "";
         Sintoma2 sintoma = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("INSERT INTO sintoma (descripcion,nivel_id_fk) VALUES(?,?);");
                ps.setString(1, descripcion);
                ps.setInt(2, nivel_id_fk);

                resultInsertSintoma = ps.executeUpdate();

                System.out.println("Resultado de inserccion de sintoma " + resultInsertSintoma);
                if (resultInsertSintoma == 1) {
                    result = "inserto sintoma ";
                }
                PreparedStatement ps2 = connection.prepareStatement(
                        "SELECT * FROM sintoma WHERE descripcion = '" + descripcion
                        + "' AND nivel_id_fk = '" + nivel_id_fk + "';");
                resultSet = ps2.executeQuery();
                while (resultSet.next()) {
                    sintoma = new Sintoma2(
                            resultSet.getInt("sintoma_id"),
                            resultSet.getString("descripcion"),
                            resultSet.getInt("nivel_id_fk"));
                }

                PreparedStatement ps3 = connection.prepareStatement(
                        "INSERT INTO enfermedad_sintoma(enfermedad_id_fk,sintoma_id_fk) values(?,?)");
                ps3.setInt(1, enfermedad_id_fk);
                ps3.setInt(2, sintoma.getSintoma_id());
                System.out.println("--------" + enfermedad_id_fk);
                System.out.println("--------" + sintoma.getSintoma_id());
                int insertSintoma = ps3.executeUpdate();
                if (insertSintoma == 1) {
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
    
        @WebMethod(operationName = "updateSintoma")
    public String updateSintoma(
            @WebParam(name = "sintoma") Integer sintoma_id,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "nivel_id_fk") Integer nivel_id_fk,
            @WebParam(name = "enfermedad_id_fk") Integer enfermedad_id_fk) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertPersona = 0;
        String result = "";
        Sintoma2 sintoma = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE sintoma "
                        + " SET descripcion=?, nivel_id_fk=? " + " WHERE sintoma_id=?;");
                ps.setString(1, descripcion);
                ps.setInt(2, nivel_id_fk);
                ps.setInt(3, sintoma_id);
                resultInsertPersona = ps.executeUpdate();
                if (resultInsertPersona == 1) {
                    result = "exito";
                }
                PreparedStatement ps2 = connection.prepareStatement(
                        "SELECT * FROM sintoma WHERE sintoma_id=?;");
                ps2.setInt(1, sintoma_id);
                resultSet = ps2.executeQuery();
                while (resultSet.next()) {
                    sintoma = new Sintoma2(
                            resultSet.getInt("sintoma_id"),
                            resultSet.getString("descripcion"),
                            resultSet.getInt("nivel_id_fk"));
                }

                PreparedStatement ps3 = connection.prepareStatement(
                        "UPDATE enfermedad_sintoma SET enfermedad_id_fk =?  "
                        + " WHERE sintoma_id_fk = " + sintoma_id);
                ps3.setInt(1, enfermedad_id_fk);
                ps3.setInt(2, sintoma.getSintoma_id());

                int insertUsuario = ps3.executeUpdate();
                if (insertUsuario == 1) {
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
    @WebMethod(operationName = "getAllSintomas")
    public Sintoma2[] getAllSintomas() {
        Sintoma2[] result = null;
        List<Sintoma2> sintomas = new ArrayList<Sintoma2>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT sintoma_id, descripcion, nivel_id_fk FROM sintoma;");
                while (resultSet.next()) {
                    Sintoma2 sintoma = new Sintoma2(
                                resultSet.getInt("sintoma_id"),
                                resultSet.getString("descripcion"),
                                resultSet.getInt("nivel_id_fk"));
                    sintomas.add(sintoma);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
         result = sintomas.toArray(new Sintoma2[sintomas.size()]);
        return result;
    }
    
    
    
      @WebMethod(operationName = "getAllNivel")
    public Nivel[] getAllNivel() {
        Nivel[] result = null;
        List<Nivel> niveles = new ArrayList<Nivel>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT nivel_id, descripcion, nivel FROM ct_prioridad;");
                while (resultSet.next()) {
                    Nivel nivel = new Nivel(
                                resultSet.getInt("sintoma_id"),
                                resultSet.getInt("nivel"),
                                resultSet.getString("descripcion"));
                    niveles.add(nivel);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
         result = niveles.toArray(new Nivel[niveles.size()]);
        return result;
    }


}