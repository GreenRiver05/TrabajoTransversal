
package Vistas;

public class VistaUniversidad extends javax.swing.JFrame {

    
    public VistaUniversidad() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmFormularioMateria = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmFormularioAlumno = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmFormularioInscripcion = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmManipulacionNotas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmAlumnosXMaterias = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdEscritorioLayout = new javax.swing.GroupLayout(jdEscritorio);
        jdEscritorio.setLayout(jdEscritorioLayout);
        jdEscritorioLayout.setHorizontalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        jdEscritorioLayout.setVerticalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );

        jMenu1.setText("Materias");

        jmFormularioMateria.setText("Formulario de Materias");
        jmFormularioMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFormularioMateriaActionPerformed(evt);
            }
        });
        jMenu1.add(jmFormularioMateria);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Alumnos");

        jmFormularioAlumno.setText("Formularios de Alumnos");
        jmFormularioAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFormularioAlumnoActionPerformed(evt);
            }
        });
        jMenu2.add(jmFormularioAlumno);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Inscripciones");

        jmFormularioInscripcion.setText("Formularios de Inscripciones");
        jmFormularioInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFormularioInscripcionActionPerformed(evt);
            }
        });
        jMenu3.add(jmFormularioInscripcion);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Carga de Notas");

        jmManipulacionNotas.setText("Manipulacion de Notas");
        jmManipulacionNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmManipulacionNotasActionPerformed(evt);
            }
        });
        jMenu4.add(jmManipulacionNotas);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Consultas");

        jmAlumnosXMaterias.setText("Listar Alumnos por Materias");
        jmAlumnosXMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlumnosXMateriasActionPerformed(evt);
            }
        });
        jMenu5.add(jmAlumnosXMaterias);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Salir");

        jmSalir.setText("Salir del Programa");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jMenu6.add(jmSalir);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmFormularioAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFormularioAlumnoActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        VistaFormularioAlumnos fAlumno = new VistaFormularioAlumnos();
        jdEscritorio.add(fAlumno);
        fAlumno.setVisible(true);
    }//GEN-LAST:event_jmFormularioAlumnoActionPerformed

    private void jmFormularioMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFormularioMateriaActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        VistaFormularioMaterias fMateria = new VistaFormularioMaterias();
        jdEscritorio.add(fMateria);
        fMateria.setVisible(true);
    }//GEN-LAST:event_jmFormularioMateriaActionPerformed

    private void jmFormularioInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFormularioInscripcionActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        VistaFormularioInscripciones fInscripciones = new VistaFormularioInscripciones();
        jdEscritorio.add(fInscripciones);
        fInscripciones.setVisible(true); 
    }//GEN-LAST:event_jmFormularioInscripcionActionPerformed

    private void jmManipulacionNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmManipulacionNotasActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        VistaManipulacionDeNotas notas = new VistaManipulacionDeNotas();
        jdEscritorio.add(notas);
        notas.setVisible(true);
    }//GEN-LAST:event_jmManipulacionNotasActionPerformed

    private void jmAlumnosXMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlumnosXMateriasActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        VistaAlumnosXMaterias listaAlumnos = new VistaAlumnosXMaterias();
        jdEscritorio.add(listaAlumnos);
        listaAlumnos.setVisible(true);
    }//GEN-LAST:event_jmAlumnosXMateriasActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
       dispose();
    }//GEN-LAST:event_jmSalirActionPerformed

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
            java.util.logging.Logger.getLogger(VistaUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUniversidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUniversidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane jdEscritorio;
    private javax.swing.JMenuItem jmAlumnosXMaterias;
    private javax.swing.JMenuItem jmFormularioAlumno;
    private javax.swing.JMenuItem jmFormularioInscripcion;
    private javax.swing.JMenuItem jmFormularioMateria;
    private javax.swing.JMenuItem jmManipulacionNotas;
    private javax.swing.JMenuItem jmSalir;
    // End of variables declaration//GEN-END:variables
}
