/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Disease;
import com.utng.ws.model.Historial;
import com.utng.ws.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author naiyu
 */
@WebService(serviceName = "HistorialPacWS")
@Stateless()
public class HistorialPacWS {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    String selectSQL;
    
    
    @WebMethod(operationName = "getAllHistorial")
    public Historial[] getAllHistorial() {
        Historial[] result = null;
        List<Historial> historials = new ArrayList<Historial>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement(); 
                resultSet = statement.executeQuery("SELECT paciente_id, nombre, apellido_paterno, apellido_materno, "
                        + "en.descripcion as enfermedad, si.descripcion as sintoma, "
                        + "fc, fr, g_apertura_ocular, g_respuesta_motora, "
                        + "g_respuesta_verval, g_total, ta_diastolica, ta_sistolica, observaciones " 
                        + "FROM paciente pa "
                        + "INNER JOIN persona pe " 
                        + "ON pe.persona_id = pa.persona_id_fk "
                        + "INNER JOIN enfermedad en "
                        + "ON en.enfermedad_id = pa.enfermedad_id "
                        + "INNER JOIN sintoma si "
                        + "ON si.sintoma_id = pa.sintoma_id "
                        + "INNER JOIN signos_paciente sp "
                        + "ON sp.id_paciente_fk = pa.paciente_id");
                while (resultSet.next()) {
                    Historial historial = new Historial(
                            resultSet.getInt("paciente_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido_paterno"),
                            resultSet.getString("apellido_materno"),
                            resultSet.getString("enfermedad"),
                            resultSet.getString("sintoma"),
                            resultSet.getInt("fc"),
                            resultSet.getInt("fr"),
                            resultSet.getInt("g_apertura_ocular"),
                            resultSet.getInt("g_respuesta_motora"),
                            resultSet.getInt("g_respuesta_verval"),
                            resultSet.getInt("g_total"),
                            resultSet.getInt("ta_sistolica"),
                            resultSet.getInt("ta_diastolica"),
                            resultSet.getString("observaciones"));
                    historials.add(historial);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = historials.toArray(new Historial[historials.size()]);
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizaPaciente")
    public String actualizaPaciente(@WebParam(name = "paciente_id") int paciente_id, 
            @WebParam(name = "observaciones") String observaciones) {
       con = new ConexionDB();
        connection = con.conectar();
        String result = "error";
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE paciente SET observaciones = ? WHERE paciente_id = ? ;");
                 ps.setString(1, observaciones);
                 ps.setInt(2, paciente_id);               
                int insertUsuario = ps.executeUpdate();
                if (insertUsuario == 1) {
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
     * This is a sample web service operation
     */
    
    
    
    
}
