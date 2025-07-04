/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.BibliotecaFISI;

import com.BibliotecaFISI.lib.ArbolBinario;
import com.BibliotecaFISI.lib.Ejemplar;
import com.BibliotecaFISI.lib.Nodo;
import com.BibliotecaFISI.lib.Usuario;
import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * @author Juan Aguilar
 */
public class PaginaInicio extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BibliotecaFISI.class.getName());
    private static ArbolBinario ejemplaresAB = new ArbolBinario();
    private static Usuario usuario;

    /**
     * Creates new form BibliotecaFISI
     */
    public PaginaInicio(Usuario usuarioAutenticado) {
        this.usuario =usuarioAutenticado;
        initComponents();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejemplaresAB.Insertar(new Ejemplar(12345, "Java para Principiantes"));
        ejemplaresAB.Insertar(new Ejemplar(67890, "Algoritmos y Estructuras de Datos"));
        ejemplaresAB.Insertar(new Ejemplar(11223, "Patrones de Diseño en Java"));
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println("Look and Feel not set: " + e.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> new BibliotecaFISI(usuario).setVisible(true));
    }

    private JPanel generarPanelResultado(Ejemplar ejemplar) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        panel.setBackground(new Color(253, 253, 253));
        panel.setPreferredSize(new Dimension(700, 60));

        JLabel titulo = new JLabel(ejemplar.titulo);
        titulo.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 14));
        titulo.setForeground(java.awt.SystemColor.activeCaptionText);

        JLabel isbn = new JLabel(String.valueOf(ejemplar.ISBN));
        isbn.setFont(new java.awt.Font("Segoe UI", 1, 14));
        isbn.setForeground(java.awt.SystemColor.activeCaptionText);

        JButton detalles = new JButton("Más detalles");
        detalles.setFont(new java.awt.Font("Segoe UI", 1, 14));
        detalles.setForeground(new java.awt.Color(253, 253, 253));
        detalles.setBackground(new java.awt.Color(98, 21, 24));
        detalles.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        detalles.setBorderPainted(false);
        detalles.setFocusPainted(false);
        BtnInicioSesion.setMargin(new java.awt.Insets(5, 20, 5, 20));
        detalles.addActionListener(e -> {
            new EjemplarDetalles(ejemplar);
        });

        panel.add(titulo);
        panel.add(Box.createHorizontalStrut(75));
        panel.add(isbn);
        panel.add(Box.createHorizontalStrut(75));
        panel.add(detalles);

        return panel;
    }

    private void buscarEjemplares() {
        String txt = barraBusqueda.getText().trim();
        int modo = tipoBusqueda.getSelectedIndex();
        if (!txt.isEmpty()) {
            panelResultados.removeAll();
            if (modo == 0) {
                try {
                    int isbn = Integer.parseInt(txt);
                    Nodo<Ejemplar> resultado = ejemplaresAB.BuscarPorISBN(ejemplaresAB.getR(), isbn);
                    if (resultado != null) {
                        JPanel subpanel = generarPanelResultado(resultado.val);
                        panelResultados.add(subpanel);
                    } else {
                        panelResultados.add(new JLabel("No se encontro el ISBN"));
                    }
                } catch (NumberFormatException ex) {
                    panelResultados.add(new JLabel("ISBN inválido"));
                }
            } else if (modo == 1) {
                List<Ejemplar> res = ejemplaresAB.buscarPorTitulo(txt);
                if (res != null) {
                    for (Ejemplar e : res) {
                        panelResultados.add(generarPanelResultado(e));
                    }
                } else {
                    panelResultados.add(new JLabel("No se encontro libros con el título deseado"));
                }

            }
            panelResultados.revalidate();
            panelResultados.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraNav = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        BtnInicioSesion = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        barraBusqueda = new javax.swing.JTextField();
        tipoBusqueda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buscar = new javax.swing.JButton();
        panelResultados = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BibliotecaFISI");
        setBackground(new java.awt.Color(245, 245, 245));
        setPreferredSize(new java.awt.Dimension(1200, 800));

        BarraNav.setBackground(new java.awt.Color(98, 21, 24));
        BarraNav.setPreferredSize(new java.awt.Dimension(1200, 60));

        Titulo.setBackground(new java.awt.Color(245, 245, 245));
        Titulo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        Titulo.setForeground(new java.awt.Color(245, 245, 245));
        Titulo.setText("BibliotecaFISI");

        BtnInicioSesion.setBackground(new java.awt.Color(98, 21, 24));
        BtnInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnInicioSesion.setForeground(new java.awt.Color(245, 245, 245));
        BtnInicioSesion.setText("Iniciar sesión");
        BtnInicioSesion.setBorder(null);
        BtnInicioSesion.setBorderPainted(false);
        BtnInicioSesion.setFocusPainted(false);
        BtnInicioSesion.setMargin(new java.awt.Insets(5, 20, 5, 20));
        BtnInicioSesion.setOpaque(true);
        BtnInicioSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnInicioSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnInicioSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnInicioSesionMouseExited(evt);
            }
        });
        BtnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInicioSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraNavLayout = new javax.swing.GroupLayout(BarraNav);
        BarraNav.setLayout(BarraNavLayout);
        BarraNavLayout.setHorizontalGroup(
            BarraNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraNavLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        BarraNavLayout.setVerticalGroup(
            BarraNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraNavLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(BarraNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        barraBusqueda.setBackground(new java.awt.Color(253, 253, 253));
        barraBusqueda.setPreferredSize(new java.awt.Dimension(500, 30));
        barraBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraBusquedaActionPerformed(evt);
            }
        });

        tipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Título", "Palabra Clave" }));
        tipoBusqueda.setMinimumSize(new java.awt.Dimension(80, 50));
        tipoBusqueda.setPreferredSize(new java.awt.Dimension(80, 30));
        tipoBusqueda.setRequestFocusEnabled(false);
        tipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBusquedaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Búsqueda de libros");

        buscar.setText("Buscar");
        buscar.setPreferredSize(new java.awt.Dimension(80, 30));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        panelResultados.setBackground(new java.awt.Color(253, 253, 253));
        panelResultados.setPreferredSize(new java.awt.Dimension(700, 450));
        panelResultados.setLayout(new javax.swing.BoxLayout(panelResultados, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(barraBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barraBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(panelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraNav, javax.swing.GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BarraNav, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Listeners">
    private void BtnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInicioSesionActionPerformed
        BtnInicioSesion.setBackground(new java.awt.Color(174, 37, 42));
        InicioSesion login = new InicioSesion();
        login.setVisible(true);
    }//GEN-LAST:event_BtnInicioSesionActionPerformed

    private void BtnInicioSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInicioSesionMouseEntered
        BtnInicioSesion.setBackground(new java.awt.Color(136, 29, 33));
    }//GEN-LAST:event_BtnInicioSesionMouseEntered

    private void BtnInicioSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInicioSesionMouseExited
        BtnInicioSesion.setBackground(new java.awt.Color(98, 21, 24));
    }//GEN-LAST:event_BtnInicioSesionMouseExited

    private void BtnInicioSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnInicioSesionMouseClicked

    }//GEN-LAST:event_BtnInicioSesionMouseClicked

    private void barraBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barraBusquedaActionPerformed

    private void tipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoBusquedaActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        buscarEjemplares();

    }//GEN-LAST:event_buscarActionPerformed
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Componentes">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraNav;
    private javax.swing.JButton BtnInicioSesion;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField barraBusqueda;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JComboBox<String> tipoBusqueda;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

}
