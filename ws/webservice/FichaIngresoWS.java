/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.webservice;

import com.utng.ws.conexion.ConexionDB;
import com.utng.ws.model.CtSexo;
import com.utng.ws.model.Domicilio;
import com.utng.ws.model.Estado;
import com.utng.ws.model.Municipio;
import com.utng.ws.model.Persona;
import com.utng.ws.model.Paciente;
import com.utng.ws.model.PasienteKevin;
import com.utng.ws.model.SignosVitales;
import com.utng.ws.model.Sintoma;
import com.utng.ws.model.TipoSangre;
import java.sql.Connection;
import java.sql.Date;
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
 * @author kevin
 */
@WebService(serviceName = "FichaIngresoWS")
@Stateless()
public class FichaIngresoWS {
private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement ps;
    ConexionDB con = null;
    String selectSQL;
    
    
    @WebMethod(operationName = "insertFichaIngreso")
    public String insertFichaIngreso(
            @WebParam(name = "nombrePersona") String nombrePersona,
            @WebParam(name = "aPaterno") String aPaterno,
            @WebParam(name = "aMaterno") String aMaterno,
            @WebParam(name = "curp") String curp,
            @WebParam(name = "numero_seguro") String numero_seguro,
            @WebParam(name = "fecha_nacimiento") String fecha_nacimiento,
            @WebParam(name = "tipo_sangre_id_fk") int tipo_sangre_id_fk,
            @WebParam(name = "edad") int edad,
            @WebParam(name = "alergico") Boolean alergico,//solo falta que guarde este we lo que 
            @WebParam(name = "descripcion_alergia") String descripcion_alergia,
            @WebParam(name = "numero_telefono") String numero_telefono,
            @WebParam(name = "colonia") String colonia,
            @WebParam(name = "calle") String calle,
            @WebParam(name = "nemero") int numero,
            @WebParam(name = "municipio_id_fk") int municipio_id_fk,
            @WebParam(name = "sexo_id_fk") int sexo_id_fk
    ){
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
                
                System.out.println("Resultado de inserccion de persona "+ resultInsertPersona);
                if (resultInsertPersona == 1) {
                    result = "inserto persona y ";
                }
                
               PreparedStatement ps8 = connection.prepareStatement("UPDATE persona SET sexo_id_fk=? WHERE persona_id= (SELECT MAX(persona_id) FROM persona);");
                ps8.setInt(1, sexo_id_fk);
                //ps.setInt(3, paciente_id);
                int insertFichaIngresoSexo = ps8.executeUpdate();
                if (insertFichaIngresoSexo == 1) {
                    result = "exito Sexo";
                    System.out.println("Resultado Sexo" + sexo_id_fk);
                } else {
                    result = "error";
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
                
                PreparedStatement ps4 = connection.prepareStatement(
                        "INSERT INTO domicilio(colonia, calle, numero, municipio_id_fk) VALUES (?, ?, ?, ?)");
                ps4.setString(1, colonia);
                ps4.setString(2, calle);
                ps4.setInt(3, numero);
                ps4.setInt(4, municipio_id_fk); //ya regreseichon, q paso??
                
                int insertFichaIngresoDomicilio = ps4.executeUpdate();
                if (insertFichaIngresoDomicilio == 1) {
                    result = "exito Domicilio";
                    System.out.println("Resultado Colonia" + colonia);
                    System.out.println("Resultado Calle" + calle);
                    System.out.println("Resultado Numero" + numero);
                } else {
                    result = "error";
                }  
                //correla men porfis tamnien la de android
                //Inserto algo ya lo corri
                
                statement = connection.createStatement();
                resultSet = statement.executeQuery(
                        "Select domicilio_id From domicilio Where colonia ='"+colonia+
                                "' and calle ='"+ calle+"' and numero="+ numero+";");                
                Domicilio doo= new Domicilio();
                while (resultSet.next()) {
                    doo.setDomicilio_id(resultSet.getInt("domicilio_id"));
                    System.out.println("KKKKKKK***********s"+doo.getDomicilio_id());
                }
                //ya trae el id, ahora veamos cual el el siguiente problema simon
                
                PreparedStatement ps3 = connection.prepareStatement(
                        "INSERT INTO paciente "
                                + "(numero_seguro, fecha_nacimiento, tipo_sangre_id_fk, "
                                + "persona_id_fk, edad, alergico, descripcion_alergia, numero_telefono, domicilio_id_fk) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ;");
                ps3.setString(1, numero_seguro);
                ps3.setString(2, fecha_nacimiento);
                ps3.setInt(3, tipo_sangre_id_fk);
                ps3.setInt(4, persona.getId());
                ps3.setInt(5, edad);
                ps3.setBoolean(6, alergico);
                ps3.setString(7, descripcion_alergia);
                ps3.setString(8,numero_telefono);
                ps3.setInt(9,doo.getDomicilio_id());
             //a ya, hay q calar va
                int insertFichaIngreso = ps3.executeUpdate();
                if (insertFichaIngreso == 1) {
                    result = "exito Paciente";
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
    @WebMethod(operationName = "updateFichaIngre")
    public String updateFichaIngre(
            @WebParam(name = "nivel_dolor") int nivel_dolor,
            @WebParam(name = "desc_dolor") String desc_dolor){
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertDisease = 0;
        String result = "";
        Paciente paciente = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE paciente SET nivel_dolor=?, "
                        + "desc_dolor=? WHERE paciente_id = (SELECT MAX(paciente_id) FROM paciente);");
                ps.setInt(1, nivel_dolor);
                ps.setString(2, desc_dolor);
                //ps.setInt(3, paciente_id);
                resultInsertDisease = ps.executeUpdate();
                if (resultInsertDisease == 1) {
                    result = "Actualizo Paciente Nivel";
                } else {
                    result = "error";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    @WebMethod(operationName = "updateFichaIngreEn")
    public String updateFichaIngreEn(
            @WebParam(name = "enfermedad_id") int enfermedad_id){
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertDisease = 0;
        String result = "";
        Paciente paciente = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE paciente SET enfermedad_id=? WHERE paciente_id= (SELECT MAX(paciente_id) FROM paciente);");
                ps.setInt(1, enfermedad_id);
                //ps.setInt(3, paciente_id);
                resultInsertDisease = ps.executeUpdate();
                if (resultInsertDisease == 1) {
                    result = "Actualizo Paciente Enfermedad";
                } else {
                    result = "error";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    @WebMethod(operationName = "updateFichaIngreSin")
    public String updateFichaIngreSin(
            @WebParam(name = "sintoma_id") int sintoma_id){
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertDisease = 0;
        String result = "";
        Paciente paciente = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE paciente SET sintoma_id=? WHERE paciente_id= (SELECT MAX(paciente_id) FROM paciente);");
                ps.setInt(1, sintoma_id);
                //ps.setInt(3, paciente_id);
                resultInsertDisease = ps.executeUpdate();
                if (resultInsertDisease == 1) {
                    result = "Actualizo Paciente Sintoma";
                } else {
                    result = "error";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
   
    
    
    @WebMethod(operationName = "searchCurp")
    public String searchCurp(@WebParam(name = "curp") String curp) {
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertPersona = 0;
        String result = "";
        Persona persona = null;
        System.out.println(connection);
        if (connection != null) {
            try {//ffff
                PreparedStatement ps2 = connection.prepareStatement(
                        "SELECT * FROM persona WHERE curp = '" + curp+ "';");
                resultSet = ps2.executeQuery();
                while (resultSet.next()) {
                    System.err.println("eddd "+resultSet.getInt("persona_id"));
                    result=resultSet.getString("persona_id");
                }   
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
      
    
    @WebMethod(operationName = "loadState")
    public Estado[] loadState() {
        con = new ConexionDB();
        connection = con.conectar();
        Estado[] result = null;
        List<Estado> estados = new ArrayList<Estado>();
        if (connection != null) {
            try {//ffff
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT  estado_id, descripcion FROM ct_estado ORDER BY estado_id;");
                while (resultSet.next()) {
                    Estado est= new Estado(
                            resultSet.getInt("estado_id"),
                            resultSet.getString("descripcion")
                    );
                    estados.add(est);
                }   
                System.err.println("el datote"+estados.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = estados.toArray(new Estado[estados.size()]);
        return result;
    }
    
    
    @WebMethod(operationName = "loadMunicipio")
    public Municipio[] loadMunicipio(
    @WebParam(name = "estado_id") int estado_id) {
        
        con = new ConexionDB();
        connection = con.conectar();
        Municipio[] result = null;
        List<Municipio> municipios = new ArrayList<Municipio>();
        if (connection != null) {
            try {//ffff
                System.out.println("Estado id ssss==="+estado_id);
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT municipio_id, descripcion FROM ct_municipio WHERE estado_id_fk = " +estado_id+ " ORDER BY municipio_id;");
                while (resultSet.next()) {
                    Municipio muni= new Municipio(
                            resultSet.getInt("municipio_id"),
                            resultSet.getString("descripcion"));
                    municipios.add(muni);
                }   
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = municipios.toArray(new Municipio[municipios.size()]);
        return result;
    }
    
    @WebMethod(operationName = "loadTipoSangre")
    public TipoSangre[] loadTipoSangre() {
        con = new ConexionDB();
        connection = con.conectar();
        TipoSangre[] result = null;
        List<TipoSangre> tipoSangres = new ArrayList<TipoSangre>();
        if (connection != null) {
            try {//ffff
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT tipo_sangre_id, descripcion FROM ct_tipo_sangre ORDER BY tipo_sangre_id;");
                while (resultSet.next()) {
                    TipoSangre ts= new TipoSangre(
                            resultSet.getInt("tipo_sangre_id"),
                            resultSet.getString("descripcion"));
                    tipoSangres.add(ts);
                }   
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = tipoSangres.toArray(new TipoSangre[tipoSangres.size()]);
        return result;
    }
    
    ////////*****************************************************************
    ///********************************************************************
    //*********************Carga Datos SExo *******************************
    @WebMethod(operationName = "loadSexo")
    public CtSexo[] loadSexo() {
        con = new ConexionDB();
        connection = con.conectar();
        CtSexo[] result = null;
        List<CtSexo> ctSexos = new ArrayList<CtSexo>();
        if (connection != null) {
            try {//ffff
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT sexo_id, descripcion FROM ct_sexo ORDER BY sexo_id;");
                while (resultSet.next()) {
                    CtSexo cs= new CtSexo(
                            resultSet.getInt("sexo_id"),
                            resultSet.getString("descripcion"));
                    ctSexos.add(cs);
                }   
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = ctSexos.toArray(new CtSexo[ctSexos.size()]);
        return result;
    }
    
    
    
    @WebMethod(operationName = "updateFichaIngreSexo")
    public String updateFichaIngreSexo(
            @WebParam(name = "sexo_id") int sexo_id){
        con = new ConexionDB();
        connection = con.conectar();
        int resultInsertDisease = 0;
        String result = "";
        CtSexo ctSexo = null;
        System.out.println(connection);
        if (connection != null) {
            try {
                ps = connection.prepareStatement("UPDATE persona SET sexo_id_fk=? WHERE persona_id= (SELECT MAX(persona_id) FROM persona);");
                ps.setInt(1, sexo_id);
                //ps.setInt(3, paciente_id);
                resultInsertDisease = ps.executeUpdate();
                if (resultInsertDisease == 1) {
                    result = "Actualizo Paciente Sintoma";
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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllSintoma")
    public Sintoma[] getAllSintoma(@WebParam(name = "enfermedad_id") int enfermedad_id) {
        Sintoma[] result = null;
        List<Sintoma> sintomas = new ArrayList<Sintoma>();
        con = new ConexionDB();
        connection = con.conectar();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select sintoma_id, descripcion "
                                                    + "from sintoma as ss "
                                                    + "inner join enfermedad_sintoma as es "
                                                    + "on es.sintoma_id_fk=ss.sintoma_id "
                                                    + "and es.enfermedad_id_fk = "+enfermedad_id+";");
                while (resultSet.next()) {
                    Sintoma sintoma= new Sintoma(
                            resultSet.getInt("sintoma_id"),
                            resultSet.getString("descripcion"));
                    sintomas.add(sintoma);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        result = sintomas.toArray(new Sintoma[sintomas.size()]);
        return result;
    }
    
}
