/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import com.toedter.calendar.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EliotM
 */
public class ControlConsulta {
    
    Connection conectar = null;

    public ControlConsulta() {

    }

    Connection conexion;
    Statement st;

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

    public Connection conexion1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/ucompleta", "root", "root");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
    //busqueda de fechas
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    
    public String getFecha(JDateChooser jd){
        if(jd.getDate()!=null){
            return formato.format(jd.getDate());
        }
        return null;
    }
    
// no pude utilizarla desde aqui :/
//    public ArrayList EstudiantesPrograma(String id) {
//
//        ArrayList arcanesma = new ArrayList();
//        String sql = "select estudiantes.nombre1e, estudiantes.apellido1e, estudiantes.identificacione from estudiantes, inscripcion, programas where estudiantes.codigoe = inscripcion.codigoiep and inscripcion.identificaionprogramaep = programas.identificaionprograma and programas.identificaionprograma = '" + id + "';";
//
//        try {
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                String nombre1e = rs.getObject("nombre1e").toString();
//                String apellidoe = rs.getObject("apellido1e").toString();
//                String ide = rs.getObject("identificacione").toString();
//
//                arcanesma.add(nombre1e);
//                arcanesma.add(apellidoe);
//                arcanesma.add(ide);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ControlConsulta.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return arcanesma;
//
//    }

}
