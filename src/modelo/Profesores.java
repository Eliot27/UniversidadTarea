/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import control.ConnectBD;
import control.ControllerProfesor;
import java.io.Serializable;

/**
 *
 * @author EliotM
 */
public class Profesores implements Serializable{
    
    private String idprofesores;
    private String nombre1p;
    private String apellido1p;
    private String direccionp;
    private String correop;
    private String vinculacionp;

    public Profesores() {
    }

    public Profesores(String idprofesores, String nombre1p, String apellido1p, String direccionp, String correop, String vinculacionp) {
        this.idprofesores = idprofesores;
        this.nombre1p = nombre1p;
        this.apellido1p = apellido1p;
        this.direccionp = direccionp;
        this.correop = correop;
        this.vinculacionp = vinculacionp;
    }

    public String getidProfesores() {
        return idprofesores;
    }

    public void setidProfesores(String idprofesores) {
        this.idprofesores = idprofesores;
    }

    public String getNombre1p() {
        return nombre1p;
    }

    public void setNombre1p(String nombre1p) {
        this.nombre1p = nombre1p;
    }

    public String getApellido1p() {
        return apellido1p;
    }

    public void setApellido1p(String apellido1p) {
        this.apellido1p = apellido1p;
    }

    public String getDireccionp() {
        return direccionp;
    }

    public void setDireccionp(String direccionp) {
        this.direccionp = direccionp;
    }

    public String getCorreop() {
        return correop;
    }

    public void setCorreop(String correop) {
        this.correop = correop;
    }

    public String getVinculacionp() {
        return vinculacionp;
    }

    public void setVinculacionp(String vinculacionp) {
        this.vinculacionp = vinculacionp;
    }

    @Override
    public String toString() {
        return "Profesores{" + "idprofesores=" + idprofesores + ", nombre1p=" + nombre1p + ", apellido1p=" + apellido1p + ", direccionp=" + direccionp + ", correop=" + correop + ", vinculacionp=" + vinculacionp + '}';
    }

    public boolean IngresarProfesor(ArrayList<Profesores> arrprof) {
        
        String sql = "";
        ControllerProfesor objpro = new ControllerProfesor();
        
        boolean conexion = false;
        boolean insertar = false;
        
        sql = "INSERT INTO profesores (idProfesor, nombre1p, apellido1p, direccionp, correop, tipoVinculacionp) VALUES (?,?,?,?,?,?)";
        
        for (Profesores arrprof1 : arrprof){
            
            conexion = objpro.crearConexion();
            if(conexion){                
                insertar =  objpro.insertarProfesor(sql, arrprof1.getidProfesores(), 
                        arrprof1.getNombre1p(),
                        arrprof1.getApellido1p(), 
                        arrprof1.getDireccionp(),
                        arrprof1.getCorreop(), 
                        arrprof1.getVinculacionp());
            }
        }
        return insertar;
        
        
    }
    
    
    
}
