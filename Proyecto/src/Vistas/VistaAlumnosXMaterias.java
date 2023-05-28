package Vistas;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Model.Alumno;
import Model.Inscripcion;
import Model.Materia;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VistaAlumnosXMaterias extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla; // a este modelo le agregamos las columnas, filas necesarias, como asi tambien eliminamos filas
      private InscripcionData inscData = new InscripcionData();
    private MateriaData matData = new MateriaData();
    private ArrayList<Inscripcion> alumnosXMaterias = new ArrayList();
    private ArrayList<Materia> listaMateria = new ArrayList();

    private void llenarComboBox() {
        for (Materia a : listaMateria) {
            jcbMateria.addItem(a);
        }
    }

    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("LEGAJO");
        columnas.add("NOMBRE");
        columnas.add("NOTA");
        for (Object c : columnas) { //se recorre el arrays para ir llenando los nombres de las columnas
            modeloTabla.addColumn(c);
        }
        jTable1.setModel(modeloTabla);
    }

    private void llenarTabla() {
        borrarFilas();
        Materia elegido = (Materia) jcbMateria.getSelectedItem();
        alumnosXMaterias = inscData.obtenerAlumnosXMateria(elegido.getId_Materia());
        for (Inscripcion i : alumnosXMaterias) {
            modeloTabla.addRow(new Object[]{i.getAlumno().getId_Alumno(), i.getAlumno().getNombre() + " " + i.getAlumno().getApellido(), i.getNota()});
        }
    }

    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public VistaAlumnosXMaterias() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        listaMateria = matData.listarMaterias(true);
        armarCabecera();
        borrarFilas();
        llenarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(null);
        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LISTADO DE ALUMNOS POR MATERIA ");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("MATERIA");

        jcbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMateriaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Nota"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_jcbMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<Materia> jcbMateria;
    // End of variables declaration//GEN-END:variables
}
