/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlConsulta;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EliotM
 */
public class Consulta extends javax.swing.JFrame {

//    private DefaultTableModel modelo;
//    int con = 0;
//    ArrayList<String> arrobj;
//    ArrayList arr;
//    String sql;
    ControlConsulta objc = new ControlConsulta();
    Connection conex = objc.conexion1();
    boolean conexion;

    public Consulta() {
        initComponents();
        this.setVisible(true);
        //grupo de botones
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        buttonGroup1.add(jRadioButton3);
        buttonGroup1.add(jRadioButton4);
    }

    void mostrardatos1(String date1, String date2) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Total Estudiantes matriculados");
        jTable1.setModel(modelo);

        String sql = "";
        if (date1.equals("")) {
            System.out.println("No hay una fecha seleccionada");
        } else {
            sql = "select count(idm) as total from matriculas where fecham BETWEEN '" + date1 + "' and '" + date2 + "'";
        }

        String[] datos = new String[1];
        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatos2(String valor) {

        //defino el modelo de como va ir mi tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("ID");
        jTable1.setModel(modelo);

        //hacemos el sql
        String sql = "";
        if (valor.equals("")) {
            System.out.println("No hay datos para mostrar");
        } else {
            sql = "select estudiantes.nombre1e, estudiantes.apellido1e, estudiantes.identificacione from estudiantes, inscripcion, programas where estudiantes.codigoe = inscripcion.codigoiep and inscripcion.identificaionprogramaep = programas.identificaionprograma and programas.identificaionprograma = '" + valor + "';";

        }
        //hacemos la busqueda en el Jtable
        String[] datos = new String[3];
        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatos3(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cursos");
        jTable1.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            System.out.println("No hay datos para mostrar");
        } else {
            sql = "select cursos.nombrec from cursos, profesores where cursos.idProfesorC = profesores.idProfesor and profesores.idProfesor = '" + valor + "';";
        }
        String[] datos = new String[1];
        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatos4(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Estudiantes");
        jTable1.setModel(modelo);

        String sql = "";
        if (valor.equals("")) {
            System.out.println("No hay datos para mostrar");
        } else {
            sql = "select estudiantes.nombre1e from estudiantes, matriculas, cursos, asignaturas "
                    + "where estudiantes.codigoe = matriculas.codigoeM"
                    + " and matriculas.idcM = cursos.idc"
                    + " and  cursos.idcodigoasig = asignaturas.codigoa"
                    + " and  asignaturas.codigoa = '"+valor+"'"; 
        }
        String[] datos = new String[1];
        try {
            Statement st = conex.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //pruebas que salieron mal :c
//    public void cargarinterfaz() {
//        String x[][] = {};
//        String columnas[] = {"Nombre", "Apellido", "ID"};
//        modelo = new DefaultTableModel(x, columnas);
//        jTable1.setModel(modelo);
//    }
//    public void mostrar(ArrayList arr1) {
//        modelo.insertRow(con, new Object[]{});
//        modelo.setValueAt(arr1.get(0).toString(), con, 0);
//        modelo.setValueAt(arr1.get(1).toString(), con, 1);
//        modelo.setValueAt(arr1.get(2).toString(), con, 2);
//        con++;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setText("Buscar por");

        jRadioButton1.setText("Total Estudiantes Por Fecha");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Estudiantes por Programa");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jRadioButton3.setText("Cursos del docente");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Estudiantes que Cursan una Asignatura");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial Black", 2, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Fecha de inicio");

        jLabel3.setText("Ultima fecha");

        jDateChooser1.setDateFormatString("yyyy-MM-d");

        jDateChooser2.setDateFormatString("yyyy-MM-d");

        jButton2.setText("Regresar a Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2))
                                .addGap(127, 127, 127))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3))
                        .addGap(0, 89, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addGap(46, 46, 46)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        //String sql = "select count(idm) as total from matriculas where fecham BETWEEN '2016-01-01' and '2017-03-06'";
        //no era necesario esto pero bueno :v xd
        //            try {
//                conexion = objc.crearConexion();
//                if (conexion) {
//                    arr = objc.EstudiantesPrograma(id);
//                    jTextField2.setText(arr.get(0).toString());
//                    jTextField3.setText(arr.get(1).toString());
//                    jTextField4.setText(arr.get(2).toString());
//                    jTextField5.setText(arr.get(3).toString());              
//                    for (Object persona : arr) {                        
//                        modelo.addRow((Object[]) persona);
//                    }
//                    jTable1.setModel(modelo);
//                    for (int i = 0; i < arr.size(); i++) {
//
//                        arr1 = (ArrayList) arr.get(i);
//                        //mostrar(arr1);
//                        modelo.insertRow(con, new Object[]{});
//                        modelo.setValueAt(arr1.get(0).toString(), con, 0);
//                        modelo.setValueAt(arr1.get(1).toString(), con, 1);
//                        modelo.setValueAt(arr1.get(2).toString(), con, 2);
//                        con++;
//
//                    }
//                }
//            } catch (Exception e) {
//            }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jRadioButton1.isSelected()) {
            //JOptionPane.showMessageDialog(null, "la fecha seleccionada es: "+objc.getFecha(jDateChooser1));
            String date1 = objc.getFecha(jDateChooser1);
            String date2 = objc.getFecha(jDateChooser2);
            mostrardatos1(date1, date2);
            JOptionPane.showMessageDialog(null, "Mostrando la cantidad de estudiantes matriculados en las fechas \n'" + date1 + "' hasta '" + date2 + "'");

        }

        if (jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Mostrando los estudiantes de un programa dado");
            mostrardatos2(jTextField1.getText());
        }

        if (jRadioButton3.isSelected()) {
            String id = jTextField1.getText();
            JOptionPane.showMessageDialog(null, "Mostrando los cursos del docente de la ID = " + id + " ");
            mostrardatos3(id);

        }

        if (jRadioButton4.isSelected()) {
            String id = jTextField1.getText();
            JOptionPane.showMessageDialog(null, "Mostrando los estudiantes que cursan la asignatura con ID = " + id + "");
            mostrardatos4(id);

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ingrese un ID del programa en el campo --Buscar por-- ");
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(null, "Selecione una fecha de inicio y la Ultima fecha asignada \nPulse el boton -Buscar- \nPara saber el numero total de estudiantes matriculados");
//        String f1 =fecha1.getDate().toString();
//        System.out.println(f1);
//        JOptionPane.showMessageDialog(null, f1);


    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ingrese el ID del profesor en el campo -Buscar por- \nPara ver los cursos asignados");

    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ingrese el ID de la Asignatura en el campo -Buscar por- \nPara ver los estudiantes registrados");
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Menu m = new Menu();
        this.setVisible(false);
        m.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
