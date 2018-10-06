/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author dacastro
 */
public class Estudiante {

    private String identificacione;
    private String codigoe;
    private String nombre1e;
    private String nombre2e;
    private String apellido1e;
    private String apellido2e;
    private String direccione;
    private String correoe;
    private String jornada;
    private String Fotoestudiante;

    public Estudiante() {
    }

    public Estudiante(String identificacione, String codigoe, String nombre1e, String nombre2e, String apellido1e, String apellido2e, String direccione, String correoe, String jornada, String Fotoestudiante) {
        this.identificacione = identificacione;
        this.codigoe = codigoe;
        this.nombre1e = nombre1e;
        this.nombre2e = nombre2e;
        this.apellido1e = apellido1e;
        this.apellido2e = apellido2e;
        this.direccione = direccione;
        this.correoe = correoe;
        this.jornada = jornada;
        this.Fotoestudiante = Fotoestudiante;
    }

    public Estudiante(String identificacione, String codigoe, String nombre1e, String apellido1e, String direccione, String correoe, String jornada) {
        this.identificacione = identificacione;
        this.codigoe = codigoe;
        this.nombre1e = nombre1e;
        this.apellido1e = apellido1e;
        this.direccione = direccione;
        this.correoe = correoe;
        this.jornada = jornada;
    }

    public Estudiante(String identificacione, String codigoe, String nombre1e, String apellido1e, String direccione, String correoe, String jornada, String Fotoestudiante) {
        this.identificacione = identificacione;
        this.codigoe = codigoe;
        this.nombre1e = nombre1e;
        this.apellido1e = apellido1e;
        this.direccione = direccione;
        this.correoe = correoe;
        this.jornada = jornada;
        this.Fotoestudiante = Fotoestudiante;
    }

    /**
     * Get the value of Fotoestudiante
     *
     * @return the value of Fotoestudiante
     */
    public String getFotoestudiante() {
        return Fotoestudiante;
    }

    /**
     * Set the value of Fotoestudiante
     *
     * @param Fotoestudiante new value of Fotoestudiante
     */
    public void setFotoestudiante(String Fotoestudiante) {
        this.Fotoestudiante = Fotoestudiante;
    }

    /**
     * Get the value of jornada
     *
     * @return the value of jornada
     */
    public String getJornada() {
        return jornada;
    }

    /**
     * Set the value of jornada
     *
     * @param jornada new value of jornada
     */
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    /**
     * Get the value of correoe
     *
     * @return the value of correoe
     */
    public String getCorreoe() {
        return correoe;
    }

    /**
     * Set the value of correoe
     *
     * @param correoe new value of correoe
     */
    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    /**
     * Get the value of direccione
     *
     * @return the value of direccione
     */
    public String getDireccione() {
        return direccione;
    }

    /**
     * Set the value of direccione
     *
     * @param direccione new value of direccione
     */
    public void setDireccione(String direccione) {
        this.direccione = direccione;
    }

    /**
     * Get the value of apellido2e
     *
     * @return the value of apellido2e
     */
    public String getApellido2e() {
        return apellido2e;
    }

    /**
     * Set the value of apellido2e
     *
     * @param apellido2e new value of apellido2e
     */
    public void setApellido2e(String apellido2e) {
        this.apellido2e = apellido2e;
    }

    /**
     * Get the value of apellido1e
     *
     * @return the value of apellido1e
     */
    public String getApellido1e() {
        return apellido1e;
    }

    /**
     * Set the value of apellido1e
     *
     * @param apellido1e new value of apellido1e
     */
    public void setApellido1e(String apellido1e) {
        this.apellido1e = apellido1e;
    }

    /**
     * Get the value of nombre2e
     *
     * @return the value of nombre2e
     */
    public String getNombre2e() {
        return nombre2e;
    }

    /**
     * Set the value of nombre2e
     *
     * @param nombre2e new value of nombre2e
     */
    public void setNombre2e(String nombre2e) {
        this.nombre2e = nombre2e;
    }

    /**
     * Get the value of nombre1e
     *
     * @return the value of nombre1e
     */
    public String getNombre1e() {
        return nombre1e;
    }

    /**
     * Set the value of nombre1e
     *
     * @param nombre1e new value of nombre1e
     */
    public void setNombre1e(String nombre1e) {
        this.nombre1e = nombre1e;
    }

    /**
     * Get the value of codigoe
     *
     * @return the value of codigoe
     */
    public String getCodigoe() {
        return codigoe;
    }

    /**
     * Set the value of codigoe
     *
     * @param codigoe new value of codigoe
     */
    public void setCodigoe(String codigoe) {
        this.codigoe = codigoe;
    }

    /**
     * Get the value of identificacione
     *
     * @return the value of identificacione
     */
    public String getIdentificacione() {
        return identificacione;
    }

    /**
     * Set the value of identificacione
     *
     * @param identificacione new value of identificacione
     */
    public void setIdentificacione(String identificacione) {
        this.identificacione = identificacione;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "identificacione=" + identificacione + ", codigoe=" + codigoe + ", nombre1e=" + nombre1e + ", nombre2e=" + nombre2e + ", apellido1e=" + apellido1e + ", apellido2e=" + apellido2e + ", direccione=" + direccione + ", correoe=" + correoe + ", jornada=" + jornada + ", Fotoestudiante=" + Fotoestudiante + '}';
    }

    public boolean insertEstudiante(String sql) {
        ConnectBD objCon = new ConnectBD();

        if (objCon.crearConexion()) {
            try {
                Statement sentencia = objCon.getConexion().createStatement();
                sentencia.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean insertEstudianteImg(String sql, LinkedList<Estudiante> le) {
        FileInputStream fis = null;
        boolean t = false;
        PreparedStatement ps = null;
        ConnectBD objC = new ConnectBD();
        for (int i = 0; i < le.size(); i++) {
            try {
                if (objC.crearConexion()) {
                    objC.getConexion().setAutoCommit(false);
                    File file = new File(le.get(i).getFotoestudiante());
                    fis = new FileInputStream(file);
                    ps = objC.getConexion().prepareStatement(sql);
                    ps.setString(1, le.get(i).getIdentificacione());
                    ps.setString(2, le.get(i).getCodigoe());
                    ps.setString(3, le.get(i).getNombre1e());
                    ps.setString(4, le.get(i).getApellido1e());
                    ps.setString(5, le.get(i).getDireccione());
                    ps.setString(6, le.get(i).getCorreoe());
                    ps.setString(7, le.get(i).getJornada());
                    ps.setBinaryStream(8, fis, (int) file.length());
                    ps.executeUpdate();
                    objC.getConexion().commit();
                    t = true;
                }
            } catch (Exception ex) {
                System.out.println(" error " + ex.toString());
                //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ps.close();
                    fis.close();
                } catch (Exception ex) {
                    System.out.println(" error " + ex.toString());
                    //Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return t;
    }

    public HashMap<Estudiante, Imagen> buscarEst(String sql) {
        HashMap<Estudiante, Imagen> hs = new HashMap<>();
        ConnectBD objc = new ConnectBD();
        if (objc.crearConexion()) {
            try {
                ResultSet rs = objc.getSt().executeQuery(sql);
                while (rs.next()) {
                    Imagen imagen = new Imagen();
                    String idestudiantes = rs.getObject("identificacione").toString();
                    String codigoestudiante = rs.getObject("codigoe").toString();
                    String nombreestudiante = rs.getObject("nombre1e").toString();
                    String apellidoestudiante = rs.getObject("apellido1e").toString();
                    String direccionestudiante = rs.getObject("direccione").toString();
                    String correoestudiante = rs.getObject("correoe").toString();
                    Blob blob = rs.getBlob("Fotoestudiante");

                    Estudiante e = new Estudiante(idestudiantes, codigoestudiante, nombreestudiante, apellidoestudiante, direccionestudiante, correoestudiante, jornada);

                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        System.out.println("error" + ex.toString());

                    }
                    imagen.setImgen(img);
                    hs.put(e, imagen);
                }

            } catch (SQLException ex) {
                System.out.println("error" + ex.toString());
            }
        }
        return hs;
    }

    public Boolean modificarEstudiante(String sql, Estudiante Obje) {
        boolean t=false;
        FileInputStream fis = null;
        ConnectBD objc = new ConnectBD();
        if(objc.crearConexion())
            try{
                PreparedStatement preparedSt = objc.getConexion().prepareStatement(sql);
                preparedSt.setString(1, Obje.getIdentificacione());
                preparedSt.setString(2, Obje.getNombre1e());
                preparedSt.setString(3, Obje.getApellido1e());
                preparedSt.setString(4, Obje.getDireccione());
                preparedSt.setString(5, Obje.getCorreoe());
                preparedSt.setString(6, Obje.getJornada());
                File file = new File(Obje.getFotoestudiante());
                try{
                    fis = new FileInputStream(file);
                    preparedSt.setBinaryStream(7, fis,(int)file.length());
                }catch(FileNotFoundException ex){
                    t = false;
                    System.err.println("Error"+ ex.toString());
                    
                }
                preparedSt.setString(8,Obje.getCodigoe());
                preparedSt.executeUpdate();
                preparedSt.close();
                t=true;
            }catch(SQLException e){
                t = false;
                System.err.println("Error" + e.toString());
            }
        
        return t;
    }

}
