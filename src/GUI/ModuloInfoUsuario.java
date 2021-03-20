/*
 * En este modulo esta toda la información del usuario
 * El usuario puede cambiar su nombre usuario y su contraseña 
 */
package GUI;

import javax.swing.JOptionPane;
import Veterinaria.Persona;
import perros.pet.PerrosPET;

public class ModuloInfoUsuario extends javax.swing.JPanel {
    public Persona usuario;
    public String nombre;
    public String contraseña;

    public ModuloInfoUsuario(Persona usuario) {
        initComponents();
        this.usuario = usuario;
        inputUsuario.setText(usuario.nombreUsuario);
        inputIngresarContraseña.setText(usuario.contraseña);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PANEL_MAIN = new javax.swing.JPanel();
        VACIO_01 = new javax.swing.JLabel();
        LABEL_TITULO = new javax.swing.JLabel();
        LABEL_USUARIO = new javax.swing.JLabel();
        inputUsuario = new javax.swing.JTextField();
        LABEL_CONTRASEÑA = new javax.swing.JLabel();
        PANEL_CONTRASEÑA = new javax.swing.JPanel();
        inputIngresarContraseña = new javax.swing.JPasswordField();
        buttonIngresarVerContraseña = new javax.swing.JButton();
        VACIO_02 = new javax.swing.JLabel();
        VACIO_03 = new javax.swing.JLabel();
        bottonGuardarCambios = new javax.swing.JButton();
        MENSAJE_INGRESAR = new javax.swing.JLabel();
        VACIO_04 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 237, 215));
        setMaximumSize(new java.awt.Dimension(704, 552));
        setMinimumSize(new java.awt.Dimension(704, 552));
        setName("Perfil"); // NOI18N
        setPreferredSize(new java.awt.Dimension(704, 552));

        PANEL_MAIN.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MAIN.setMaximumSize(new java.awt.Dimension(452, 552));
        PANEL_MAIN.setMinimumSize(new java.awt.Dimension(452, 552));
        PANEL_MAIN.setPreferredSize(new java.awt.Dimension(452, 552));
        PANEL_MAIN.setLayout(new java.awt.GridLayout(12, 1));

        VACIO_01.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MAIN.add(VACIO_01);

        LABEL_TITULO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_TITULO.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        LABEL_TITULO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_TITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LABEL_TITULO.setText("Información de Usuario");
        LABEL_TITULO.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PANEL_MAIN.add(LABEL_TITULO);

        LABEL_USUARIO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_USUARIO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_USUARIO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_USUARIO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_USUARIO.setText("Nombre de Usuario");
        LABEL_USUARIO.setAlignmentX(5.0F);
        LABEL_USUARIO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_USUARIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_USUARIO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_MAIN.add(LABEL_USUARIO);

        inputUsuario.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputUsuario.setText("Juanito de Tal");
        inputUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_MAIN.add(inputUsuario);

        LABEL_CONTRASEÑA.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_CONTRASEÑA.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_CONTRASEÑA.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_CONTRASEÑA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_CONTRASEÑA.setText("Contraseña");
        LABEL_CONTRASEÑA.setAlignmentX(5.0F);
        LABEL_CONTRASEÑA.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_CONTRASEÑA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_CONTRASEÑA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_MAIN.add(LABEL_CONTRASEÑA);

        PANEL_CONTRASEÑA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_CONTRASEÑA.setForeground(new java.awt.Color(57, 50, 50));
        PANEL_CONTRASEÑA.setLayout(new javax.swing.BoxLayout(PANEL_CONTRASEÑA, javax.swing.BoxLayout.LINE_AXIS));

        inputIngresarContraseña.setEditable(false);
        inputIngresarContraseña.setBackground(new java.awt.Color(255, 255, 255));
        inputIngresarContraseña.setText("juanitodetal102");
        inputIngresarContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_CONTRASEÑA.add(inputIngresarContraseña);

        buttonIngresarVerContraseña.setBackground(new java.awt.Color(242, 237, 215));
        buttonIngresarVerContraseña.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        buttonIngresarVerContraseña.setForeground(new java.awt.Color(57, 50, 50));
        buttonIngresarVerContraseña.setText("Ver");
        buttonIngresarVerContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonIngresarVerContraseña.setBorderPainted(false);
        buttonIngresarVerContraseña.setFocusPainted(false);
        buttonIngresarVerContraseña.setPreferredSize(new java.awt.Dimension(37, 45));
        buttonIngresarVerContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngresarVerContraseñaActionPerformed(evt);
            }
        });
        PANEL_CONTRASEÑA.add(buttonIngresarVerContraseña);

        PANEL_MAIN.add(PANEL_CONTRASEÑA);
        PANEL_MAIN.add(VACIO_02);
        PANEL_MAIN.add(VACIO_03);

        bottonGuardarCambios.setBackground(new java.awt.Color(228, 130, 87));
        bottonGuardarCambios.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        bottonGuardarCambios.setForeground(new java.awt.Color(242, 237, 215));
        bottonGuardarCambios.setText("Guardar cambios");
        bottonGuardarCambios.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        bottonGuardarCambios.setBorderPainted(false);
        bottonGuardarCambios.setFocusPainted(false);
        bottonGuardarCambios.setFocusable(false);
        bottonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonGuardarCambiosActionPerformed(evt);
            }
        });
        PANEL_MAIN.add(bottonGuardarCambios);

        MENSAJE_INGRESAR.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        MENSAJE_INGRESAR.setForeground(new java.awt.Color(57, 50, 50));
        MENSAJE_INGRESAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PANEL_MAIN.add(MENSAJE_INGRESAR);
        PANEL_MAIN.add(VACIO_04);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 704, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(PANEL_MAIN, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 552, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(PANEL_MAIN, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))));

        getAccessibleContext().setAccessibleName("Perfil");
    }// </editor-fold>//GEN-END:initComponents

    private void verContraseña(javax.swing.JPasswordField campo) {
        if (campo.getEchoChar() != (char) 0)
            campo.setEchoChar((char) 0);
        else
            campo.setEchoChar('\u2022');
    }

    private void buttonIngresarVerContraseñaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonIngresarVerContraseñaActionPerformed
        verContraseña(inputIngresarContraseña);
    }// GEN-LAST:event_buttonIngresarVerContraseñaActionPerformed

    private void bottonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bottonGuardarCambiosActionPerformed
        /*
         * Para guardar los cambios, se debe validar que los campos no esten vacios o
         * que el nombre de usuario ya exita
         */

        // Obtenemos los datos desde la interfaz de usuario
        nombre = inputUsuario.getText();
        contraseña = String.valueOf(inputIngresarContraseña.getPassword());
        boolean nombreDisponible = true;

        // Si los campos estan vacios, se mostrara un mensaje
        if (nombre.length() > 0 && contraseña.length() > 0) {

            // Debemos asegrarnos que el nuevo nombre de usuario no este tomado
            for (Persona persona : PerrosPET.personas) {
                // Tenemos que "saltarnos" al usuario actual
                if (!persona.equals(this.usuario)) {
                    if ((persona.nombreUsuario).equals(this.nombre)) {
                        JOptionPane.showMessageDialog(null, "Ya exite un usuario con este nombre");
                        nombreDisponible = false;
                    }
                }
            }

            if (nombreDisponible) {
                this.usuario.nombreUsuario = nombre;
                this.usuario.contraseña = contraseña;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nombre ó contraseña vacios");
        }
    }// GEN-LAST:event_bottonGuardarCambiosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL_CONTRASEÑA;
    private javax.swing.JLabel LABEL_TITULO;
    private javax.swing.JLabel LABEL_USUARIO;
    private javax.swing.JLabel MENSAJE_INGRESAR;
    private javax.swing.JPanel PANEL_CONTRASEÑA;
    private javax.swing.JPanel PANEL_MAIN;
    private javax.swing.JLabel VACIO_01;
    private javax.swing.JLabel VACIO_02;
    private javax.swing.JLabel VACIO_03;
    private javax.swing.JLabel VACIO_04;
    private javax.swing.JButton bottonGuardarCambios;
    private javax.swing.JButton buttonIngresarVerContraseña;
    private javax.swing.JPasswordField inputIngresarContraseña;
    private javax.swing.JTextField inputUsuario;
    // End of variables declaration//GEN-END:variables
}
