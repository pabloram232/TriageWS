/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.Leyenda;
import com.utng.ws.model.Persona;
import com.utng.ws.model.Report;
import com.utng.ws.model.ResultTriage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
public class ReportWS {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;

    @WebMethod(operationName = "getReport")
    public Report[] getReport(@WebParam(name = "fechainicio") String fechainicio, @WebParam(name = "fechafin") String fechafin) {
        Report[] result = null;
        List<Report> reports = new ArrayList<Report>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                String query = "select nombre  || ' ' ||  apellido_paterno  || ' ' ||  apellido_materno as nombre, "
                      + "en.descripcion as enfermedad, "
                      + "si.descripcion as sintoma "
                      + "from persona pe inner join paciente pa "
                      + "on pe.persona_id=pa.persona_id_fk inner join sintoma si "
                      + "on pa.sintoma_id=si.sintoma_id join enfermedad en "
                      + "on pa.enfermedad_id=en.enfermedad_id "
                      + "where pa.fechaAtencion between '"+fechainicio+"' and '"+fechafin+"'"
                      + " order by nombre asc";
                System.out.println(query);
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Report report = new Report(
                            resultSet.getString("nombre"),
                            resultSet.getString("enfermedad"),
                            resultSet.getString("sintoma"));
                    reports.add(report);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        result = reports.toArray(new Report[reports.size()]);
        return result;
    }

}
