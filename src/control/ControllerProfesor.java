/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Profesores;

/**
 *
 * @author EliotM
 */
public class ControllerProfesor {

    /*
    hola profesor david, si usted alcanza a leer esto 
    no entiendo porque no puedo llamar un objeto de tipo contollerprofesor
    en la clase profesor si no tengo el metodo crearconexion
     */
    Connection conexion;
    Statement st;

    public ControllerProfesor() {

    }

    public Connection getConexion() {
        return conexion;
    }

    public Statement getSt() {
        return st;
    }

    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ucompleta", "root", "root");
            st = conexion.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertarProfesor(String insert, String id, String nom1p, String ape1p, String direp, String correop, String vinp) {

        PreparedStatement ps = null;

        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, id);
            ps.setString(2, nom1p);
            ps.setString(3, ape1p);
            ps.setString(4, direp);
            ps.setString(5, correop);
            ps.setString(6, vinp);
            ps.executeUpdate();
            conexion.commit();
            return true;

        } catch (Exception ex) {
            Logger.getLogger(ControllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
                Logger.getLogger(ControllerProfesor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

}
