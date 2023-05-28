package Vistas;

import AccesoADatos.*;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class VistaFormularioInscripciones extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla; // a este modelo le agregamos las columnas, filas necesarias, como asi tambien eliminamos filas
    private Inscripcion inscripcion;
    private Materia materia;
    private InscripcionData inscData = new InscripcionData();
    private AlumnoData alumData = new AlumnoData();
    private MateriaData matData = new MateriaData();
    private ArrayList<Inscripcion> listaInscripto = new ArrayList();
    private ArrayList<Inscripcion> listaNoInscripto = new ArrayList();
    private ArrayList<Materia> listaMaterias = new ArrayList();
    private ArrayList<Alumno> listaAlumnos = new ArrayList();

    private void llenarComboBox() {
        for (Alumno a : listaAlumnos) {
            jcbAlumnos.addItem(a);
        }
    }

    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("IdINSCRIPCION"); 
        columnas.add("CODIGO");
        columnas.add("NOMBRE");
        columnas.add("AÑO");
        for (Object c : columnas) { //se recorre el arrays para ir llenando los nombres de las columnas
            modeloTabla.addColumn(c);
        }
        jTable1.setModel(modeloTabla);

                
        //ocultamos una columna para no mostrar el id, ya que al usuario no le interesa
        TableColumn columna = jTable1.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        jTable1.doLayout();

    }

    private void llenarTabla() {
        borrarFilas();
        Alumno elegido = (Alumno) jcbAlumnos.getSelectedItem();

        if (jrbInscripto.isSelected() == true) {
            listaInscripto = inscData.obtenerMateriasCursadas(elegido.getId_Alumno());
            for (Inscripcion i : listaInscripto) {
                modeloTabla.addRow(new Object[]{i.getId_Inscripcion(),i.getMateria().getId_Materia(), i.getMateria().getNombre(), i.getMateria().getAnio()});
            }
        }
        if (jrbNoInscripto.isSelected() == true) {
            listaNoInscripto = inscData.obtenerMateriasNoCursadas(elegido.getId_Alumno());
            for (Inscripcion i : listaNoInscripto) {
                modeloTabla.addRow(new Object[]{" ",i.getMateria().getId_Materia(), i.getMateria().getNombre(), i.getMateria().getAnio()});
            }
        }

    }

    private void borrarFilas() {
        int filas = modeloTabla.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public VistaFormularioInscripciones() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        inscripcion = new Inscripcion();
        materia = new Materia();
        listaMaterias = matData.listarMaterias(true);
        listaAlumnos = alumData.listarAlumnos(true);
        armarCabecera();
        borrarFilas();
        llenarComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbAlumnos = new javax.swing.JComboBox<>();
        jlNombre = new javax.swing.JLabel();
        jlEstudiante = new javax.swing.JLabel();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jrbNoInscripto = new javax.swing.JRadioButton();
        jrbInscripto = new javax.swing.JRadioButton();
        jbInscribir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 700));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 700));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Castellar", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulario de Inscripcion");

        jcbAlumnos.setBackground(new java.awt.Color(51, 51, 51));
        jcbAlumnos.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jcbAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        jcbAlumnos.setMaximumRowCount(10);
        jcbAlumnos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlumnosItemStateChanged(evt);
            }
        });
        jcbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnosActionPerformed(evt);
            }
        });

        jlNombre.setBackground(new java.awt.Color(51, 51, 51));
        jlNombre.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 102, 0));
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlEstudiante.setBackground(new java.awt.Color(51, 51, 51));
        jlEstudiante.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlEstudiante.setForeground(new java.awt.Color(255, 255, 255));
        jlEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jbAnularInscripcion.setBackground(new java.awt.Color(51, 51, 51));
        jbAnularInscripcion.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jbAnularInscripcion.setForeground(new java.awt.Color(255, 255, 255));
        jbAnularInscripcion.setText("ANULAR INSCRIPCION");
        jbAnularInscripcion.setEnabled(false);
        jbAnularInscripcion.setPreferredSize(new java.awt.Dimension(100, 32));
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(51, 51, 51));
        jbSalir.setFont(new java.awt.Font("Castellar", 1, 17)); // NOI18N
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("SALIR");
        jbSalir.setPreferredSize(new java.awt.Dimension(100, 40));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalir3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setText("LISTADO DE MATERIAS");

        jrbNoInscripto.setText("NO INSCRIPTO");
        jrbNoInscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNoInscriptoActionPerformed(evt);
            }
        });

        jrbInscripto.setText("INSCRIPTO");
        jrbInscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInscriptoActionPerformed(evt);
            }
        });

        jbInscribir.setBackground(new java.awt.Color(51, 51, 51));
        jbInscribir.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jbInscribir.setForeground(new java.awt.Color(255, 255, 255));
        jbInscribir.setText("Inscribir");
        jbInscribir.setEnabled(false);
        jbInscribir.setPreferredSize(new java.awt.Dimension(100, 32));
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
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
                "ID", "NOMBRE", "AÑO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(3);
        }

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("ALUMNO ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jbAnularInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jrbInscripto)
                                .addGap(127, 127, 127)
                                .addComponent(jrbNoInscripto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(73, 73, 73)
                        .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbInscripto)
                            .addComponent(jrbNoInscripto))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAnularInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
        int filaElegida = jTable1.getSelectedRow();
        if (filaElegida != 1) {
            int idInscripcion = (Integer) jTable1.getValueAt(filaElegida, 0);

            inscData.borrarInscripcionMateriaAlumno(idInscripcion);
            jbAnularInscripcion.setEnabled(false);
             llenarTabla();
        }

        
       
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed

    private void jSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalir3ActionPerformed
        dispose();
    }//GEN-LAST:event_jSalir3ActionPerformed

    private void jcbAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlumnosItemStateChanged

    }//GEN-LAST:event_jcbAlumnosItemStateChanged

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        int filaElegida = jTable1.getSelectedRow();
        if (filaElegida != 1) {
            int idMateria = (Integer) jTable1.getValueAt(filaElegida, 1);
            Alumno elegido = (Alumno) jcbAlumnos.getSelectedItem();
            materia.setId_Materia(idMateria);
            inscripcion.setMateria(materia);
            inscripcion.setAlumno(elegido);
            inscData.guardarInscripcion(inscripcion);
            jbInscribir.setEnabled(false);
            llenarTabla();
        }
        
        
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jrbInscripto.isSelected() == true) {
            jbAnularInscripcion.setEnabled(true);
        }
        if (jrbNoInscripto.isSelected() == true) {
            jbInscribir.setEnabled(true);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jrbInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInscriptoActionPerformed
        jrbNoInscripto.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jrbInscriptoActionPerformed

    private void jrbNoInscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNoInscriptoActionPerformed
        jrbInscripto.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_jrbNoInscriptoActionPerformed

    private void jcbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnosActionPerformed
        jrbInscripto.setSelected(false);
        jrbNoInscripto.setSelected(false);
        borrarFilas();
    }//GEN-LAST:event_jcbAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumnos;
    private javax.swing.JLabel jlEstudiante;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JRadioButton jrbInscripto;
    private javax.swing.JRadioButton jrbNoInscripto;
    // End of variables declaration//GEN-END:variables
}
