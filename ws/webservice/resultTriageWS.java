/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Leyenda;
import com.utng.ws.model.Persona;
import com.utng.ws.model.ResultTriage;
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
public class resultTriageWS {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getResultTriage")
    public ResultTriage[] getResultTriage(@WebParam(name = "id") int id) {
        ResultTriage[] result = null;
        List<ResultTriage> resultTriages = new ArrayList<ResultTriage>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();   
                resultSet = statement.executeQuery(
                        "SELECT PE.NOMBRE,PE.APELLIDO_PATERNO, PE.APELLIDO_MATERNO, "
                      + "(SELECT DESCRIPCION FROM CT_SEXO SE INNER JOIN PERSONA PE ON SE.SEXO_ID=PE.SEXO_ID_FK) AS sexo, " 
                      + "PA.FECHA_NACIMIENTO,PA.DESCRIPCION_ALERGIA,PE.CURP,PA.NUMERO_SEGURO,DOM.CALLE,DOM.NUMERO,DOM.COLONIA, " 
                      + "(SELECT MU.DESCRIPCION FROM CT_MUNICIPIO MU INNER JOIN DOMICILIO DOM ON  MU.MUNICIPIO_ID=DOM.MUNICIPIO_ID_FK ) AS municipio, "
                      + "PA.NUMERO_TELEFONO, "
                      + "(SELECT DESCRIPCION FROM ENFERMEDAD EN INNER JOIN PACIENTE PA ON EN.ENFERMEDAD_ID=PA.ENFERMEDAD_ID) AS enfermedad, "
                      + "(SELECT DESCRIPCION FROM SINTOMA SI INNER JOIN PACIENTE PA ON SI.SINTOMA_ID=PA.SINTOMA_ID)AS sintoma, "
                      + "PA.DESC_DOLOR, SP.FC,SP.FR,SP.TEMPERATURA,SP.TA_SISTOLICA,SP.TA_DIASTOLICA, " 
                      + "SP.G_APERTURA_OCULAR,SP.G_RESPUESTA_MOTORA,SP.G_RESPUESTA_VERVAL,SP.G_TOTAL, est.descripcion as estado, ts.descripcion as tipo_sangre, PA.nivel_dolor "
                      + "FROM PERSONA PE " 
                      + "INNER JOIN PACIENTE PA "
                      + "ON PE.PERSONA_ID=PA.PERSONA_ID_FK "
                      + "INNER JOIN ct_tipo_sangre ts " 
                      + "ON ts.tipo_sangre_id = PA.tipo_sangre_id_fk "
                      + "JOIN DOMICILIO DOM "
                      + "ON PA.DOMICILIO_ID_FK=DOM.DOMICILIO_ID "
                      + "INNER JOIN ct_municipio mu "
                      + "ON DOM.municipio_id_fk = mu.municipio_id "
                      + "INNER JOIN ct_estado est "
                      + "ON est.estado_id = mu.estado_id_fk "
                      + "JOIN SIGNOS_PACIENTE SP "
                      + "ON PA.PACIENTE_ID=SP.ID_PACIENTE_FK "
                      + "WHERE PACIENTE_ID= "+ id +";");
                while (resultSet.next()) {
                    ResultTriage resultTriage = new ResultTriage(
                            resultSet.getString("nombre"),
                            resultSet.getString("APELLIDO_PATERNO"),
                            resultSet.getString("APELLIDO_MATERNO"),
                            resultSet.getString("sexo"),
                            resultSet.getString("fecha_nacimiento"),
                            resultSet.getString("DESCRIPCION_ALERGIA"),
                            resultSet.getString("curp"),
                            resultSet.getString("NUMERO_SEGURO"),
                            resultSet.getString("calle"),
                            resultSet.getInt("numero"),
                            resultSet.getString("colonia"),
                            resultSet.getString("municipio"),
                            resultSet.getString("NUMERO_TELEFONO"),
                            resultSet.getString("enfermedad"),
                            resultSet.getString("sintoma"),
                            resultSet.getString("DESC_DOLOR"),
                            resultSet.getInt("fc"),
                            resultSet.getInt("fr"),
                            resultSet.getInt("temperatura"),
                            resultSet.getInt("ta_sistolica"),
                            resultSet.getInt("ta_diastolica"),
                            resultSet.getInt("G_APERTURA_OCULAR"),
                            resultSet.getInt("G_RESPUESTA_MOTORA"),
                            resultSet.getInt("G_RESPUESTA_VERVAL"),
                            resultSet.getInt("G_TOTAL"),
                            resultSet.getString("estado"),
                            resultSet.getString("tipo_sangre"),
                            resultSet.getInt("nivel_dolor"));
                    resultTriages.add(resultTriage);
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
         result = resultTriages.toArray(new ResultTriage[resultTriages.size()]);
        return result;
    }
    
    
}
