/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utng.ws.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chiva
 */
public class ConexionDB {
    public Connection conectar() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/MTS",
//                    "postgres", "luis");

             connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.1.177:5432/MTS",
                    "sistema", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
