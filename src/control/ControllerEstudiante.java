/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.HashMap;
import java.util.LinkedList;
import modelo.Estudiante;
import modelo.Imagen;

/**
 *
 * @author dacastro
 */
public class ControllerEstudiante {

    public static boolean modificarEstudiante(Estudiante Obje) {
        Boolean t= false;
        Estudiante obje = new Estudiante();
        String sql = "update estudiantes set identificacione=?,"+ "nombre1e=?, apellido1e=?, direccione=?,correoe=?,"+ "jornada=?, Fotoestudiante=? where codigoe=?;";
        t= Obje.modificarEstudiante(sql,Obje);
        
        
        
        return t;
    }

    public ControllerEstudiante() {
    }

    public static boolean insertEstudiante(LinkedList<Estudiante> le) {
        boolean ins = false;
        for (int i = 0; i < le.size(); i++) {
            System.out.println("xxxx " + le.get(i).toString());
            String sql = "INSERT INTO estudiantes (identificacione,codigoe,nombre1e,apellido1e,direccione,correoe,jornada) VALUES "
                    + "('" + le.get(i).getIdentificacione() + "', '" + le.get(i).getCodigoe() + "', '" + le.get(i).getNombre1e() + "', '"
                    + le.get(i).getApellido1e() + "', '" + le.get(i).getDireccione() + "', '" + le.get(i).getCorreoe() + "', '" + le.get(i).getJornada() + "');";
            Estudiante obje = new Estudiante();
            ins = obje.insertEstudiante(sql);

        }
        return ins;

    }

    public static boolean insertEstudianteFoto(LinkedList<Estudiante> le) {
        String sql = "";
        boolean t = false;
        //BaseDatos objBases=new BaseDatos();
        // boolean conexion=false;
        //boolean insertar=false;

        sql = "INSERT INTO estudiantes (identificacione,"
                + "codigoe,nombre1e,apellido1e,direccione,"
                + "correoe,jornada,Fotoestudiante)"
                + " VALUES(?,?,?,?,?,?,?,?)";

        Estudiante obje = new Estudiante();
        t = obje.insertEstudianteImg(sql, le);

        return t;
    }

    public HashMap<Estudiante, Imagen> buscarECodigo(String buscarpor) {

        String sql = "Select * from estudiantes where codigoe='" + buscarpor + "';";
        Estudiante e = new Estudiante();

        HashMap<Estudiante, Imagen> le = e.buscarEst(sql);

        return le;
    }
}
