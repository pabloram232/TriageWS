/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Persona;
import com.utng.ws.model.User;
import com.utng.ws.model.UsuarioEnSesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class UserWS {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        con = new ConexionDB();
        connection = con.conectar();
        User user = null;
        if (connection != null) {
            try {
                ps = connection.prepareStatement("SELECT usuario_id, nom_usuario, contrasena, estatus,"
                        + " persona_id, nombre, apellido_paterno, apellido_materno, "
                        + " curp FROM usuario u INNER JOIN persona p"
                        + " ON p.persona_id = u.persona_id_fk "
                        + " WHERE nom_usuario = ? AND contrasena = ?;");
                ps.setString(1, userName);
                ps.setString(2, password);
                resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("usuario_id"),
                            resultSet.getString("nom_usuario"),
                            resultSet.getString("contrasena"),
                            resultSet.getBoolean("estatus"),
                            resultSet.getInt("persona_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"),
                            resultSet.getString("curp"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @WebMethod(operationName = "getAllUsers")
    public User[] getAllUsers() {
        User[] result = null;
        List<User> users = new ArrayList<User>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(
                        "SELECT usuario_id, nom_usuario, contrasena, estatus,"
                        + " persona_id, nombre, apellido_paterno, apellido_materno, "
                        + " curp FROM usuario u INNER JOIN persona p"
                        + " ON p.persona_id = u.persona_id_fk;");
                while (resultSet.next()) {
                    User user = new User(
                            resultSet.getInt("usuario_id"),
                            resultSet.getString("nom_usuario"),
                            resultSet.getString("contrasena"),
                            resultSet.getBoolean("estatus"),
                            resultSet.getInt("persona_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"),
                            resultSet.getString("curp"));
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = users.toArray(new User[users.size()]);
        return result;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @WebMethod(operationName = "insertUser")
    public String insertUser(@WebParam(name = "nombrePersona") String nombrePersona,
            @WebParam(name = "aPaterno") String aPaterno,
            @WebParam(name = "aMaterno") String aMaterno,
            @WebParam(name = "curp") String curp,
            @WebParam(name = "nomUser") String nomUser,
            @WebParam(name = "contrasena") String contrasena) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertPersona = 0;
        String result = "";
        Persona persona = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("INSERT INTO persona (nombre, apellido_paterno, apellido_materno, curp) VALUES(?,?,?,?);");
                ps.setString(1, nombrePersona);
                ps.setString(2, aPaterno);
                ps.setString(3, aMaterno);
                ps.setString(4, curp);
                resultInsertPersona = ps.executeUpdate();

                System.out.println("Resultado de inserccion de persona " + resultInsertPersona);
                if (resultInsertPersona == 1) {
                    result = "inserto persona y ";
                }
                PreparedStatement ps2 = connection.prepareStatement(
                        "SELECT * FROM persona WHERE nombre = '" + nombrePersona
                        + "' AND apellido_paterno = '" + aPaterno + "' AND apellido_materno = '" + aMaterno + "';");
                resultSet = ps2.executeQuery();
                while (resultSet.next()) {
                    persona = new Persona(
                            resultSet.getInt("persona_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"));
                }

                PreparedStatement ps3 = connection.prepareStatement(
                        "INSERT INTO usuario(nom_usuario, contrasena, persona_id_fk) values(?,?,?)");
                ps3.setString(1, nomUser);
                ps3.setString(2, contrasena);
                ps3.setInt(3, persona.getId());
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
    @WebMethod(operationName = "deleteUser")
    public int deleteUser(@WebParam(name = "idUser") int idUser) {
        //TODO write your implementation code here:
        con = new ConexionDB();
        connection = con.conectar();
        User user = null;
        int result = 0;
        int result2 = 0;
        int returnn = 0;
        if (connection != null) {
            try {
                ps = connection.prepareStatement("SELECT usuario_id, nom_usuario, contrasena, estatus,"
                        + " persona_id, nombre, apellido_paterno, apellido_materno, "
                        + " curp FROM usuario u INNER JOIN persona p"
                        + " ON p.persona_id = u.persona_id_fk "
                        + "  WHERE usuario_id = ? ;");
                ps.setInt(1, idUser);
                resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("usuario_id"),
                            resultSet.getString("nom_usuario"),
                            resultSet.getString("contrasena"),
                            resultSet.getBoolean("estatus"),
                            resultSet.getInt("persona_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"),
                            resultSet.getString("curp"));
                }
                int id_persona = user.getPersona_id();

                ps = connection.prepareStatement(
                        "DELETE FROM usuario WHERE usuario_id =?;");
                ps.setInt(1, idUser);
                result = ps.executeUpdate();
                ps = connection.prepareStatement(
                        "DELETE FROM persona WHERE persona_id =?;");
                ps.setInt(1, id_persona);
                result2 = ps.executeUpdate();
                if (result == 1 && result2 == 1) {
                    returnn = 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return returnn;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateUser")
    public String updateUser(
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasena") String contrasena,
            @WebParam(name = "usuarioId") int usuarioId,
            @WebParam(name = "nombrePersona") String nombrePersona,
            @WebParam(name = "aPaterno") String aPaterno,
            @WebParam(name = "aMaterno") String aMaterno,
            @WebParam(name = "curp") String curp) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertPersona = 0;
        String result = "";
        User user = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE usuario "
                        + " SET nom_usuario=?, contrasena=? " + " WHERE usuario_id=?;");
                ps.setString(1, nombreUsuario);
                ps.setString(2, contrasena);
                ps.setInt(3, usuarioId);
                resultInsertPersona = ps.executeUpdate();
                if (resultInsertPersona == 1) {
                    result = "inserto persona y ";
                }
                PreparedStatement ps2 = connection.prepareStatement(
                        "SELECT * FROM usuario WHERE usuario_id=?;");
                ps2.setInt(1, usuarioId);
                resultSet = ps2.executeQuery();
                while (resultSet.next()) {
                    user = new User(
                            resultSet.getInt("usuario_id"),
                            resultSet.getString("nom_usuario"),
                            resultSet.getString("contrasena"),
                            resultSet.getInt("persona_id_fk"));
                }

                int persona_id_fk = user.getPersona_id_fk();
                PreparedStatement ps3 = connection.prepareStatement(
                        "UPDATE persona SET nombre=?, apellido_paterno = ?, apellido_materno = ?, curp = ? "
                        + " WHERE persona_id = " + persona_id_fk);
                ps3.setString(1, nombrePersona);
                ps3.setString(2, aPaterno);
                ps3.setString(3, aMaterno);
                ps3.setString(4, curp);
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
    @WebMethod(operationName = "consultUser")
    public String consultUser(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertPersona = 0;
        String result = "error";
        if (connection != null) {
            try {
                ps = connection.prepareStatement("SELECT * FROM usuario WHERE nom_usuario = ? AND contrasena = ?;");
                ps.setString(1, userName);
                ps.setString(2, password);
                resultSet = ps.executeQuery();
                if (resultSet.next()) {
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
    
    
     @WebMethod(operationName = "getUserOnline")
    public UsuarioEnSesion[] getUserOnline() {
        UsuarioEnSesion[] result = null;
        List<UsuarioEnSesion> users = new ArrayList<UsuarioEnSesion>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(
                        "SELECT nombre, apellido_paterno, apellido_materno "
                        + " FROM usuario u INNER JOIN persona p"
                        + " ON p.persona_id = u.persona_id_fk "
                        + " WHERE estatus = true");
                while (resultSet.next()) {
                    UsuarioEnSesion user = new UsuarioEnSesion(
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"));
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = users.toArray(new UsuarioEnSesion[users.size()]);
        return result;
    }

}
