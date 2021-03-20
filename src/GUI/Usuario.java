/*
 * Esta es la interfaz para los usuarios en general.
 * En todo caso el usario puede acceder a su información y sus citas (el administrador puede ver todas las citas)
 * Depediendo del usuario, se generará una imagen de perfil diferentes y un modulo 3 diferentes
*/
package GUI;

import java.awt.Image;
import javax.swing.ImageIcon;

import Veterinaria.Persona;
import Veterinaria.TipoUsuario;
import perros.pet.PerrosPET;

public class Usuario extends javax.swing.JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public javax.swing.JPanel modulo1; // Información de usuario
    public javax.swing.JPanel modulo2; // Modulo de citas
    public javax.swing.JPanel modulo3; // Depende del tipo de usuario
    public String fotoPerfil;

    public Usuario(Persona persona) {
        initComponents();
        modulo1 = new ModuloInfoUsuario(persona);
        modulo2 = new ModuloCitas(persona);

        /*
         * Se crearon en un archivo aparte diferentes modulo que luego seran añadidos al
         * algoritmo principal Cada modulo se escoje en función del tipo de usuario
         */
        switch (persona.tipoUsuario) {
        case VETERINARIO:
            fotoPerfil = "/Resources/doctor.png";
            modulo3 = new ModuloHistorial();
            break;
        case USUARIO:
            fotoPerfil = "/Resources/user.png";
            modulo3 = new ModuloMascotas();
            break;
        case ADMINISTRADOR:
            fotoPerfil = "/Resources/admi.png";
            modulo3 = new ModuloCaja();
            break;
        default:
            fotoPerfil = "/Resources/Toby.jpg";
        }

        // Redimensionamos la imagen y la enviamos a un JLabel
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(fotoPerfil)).getImage()
                .getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        IMG_PEFIL.setIcon(imageIcon);

        // Cada panel de modulo tiene un nombre asociado, podemos usar esos nombres para
        // asignare un valor a los botones en el navegador
        BUTTON_MODULO1.setText(modulo1.getName());
        BUTTON_MODULO2.setText(modulo2.getName());
        BUTTON_MODULO3.setText(modulo3.getName());

        // Actualizamos la pagina principal
        this.remove(PANEL_MAIN);
        this.add(modulo1);
        validate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        String fontName = "Candara";

        PANEL_NAV = new javax.swing.JPanel();
        IMG_PEFIL = new javax.swing.JLabel();
        BUTTON_MODULO1 = new javax.swing.JButton();
        BUTTON_MODULO2 = new javax.swing.JButton();
        BUTTON_MODULO3 = new javax.swing.JButton();
        BUTTON_SALIR = new javax.swing.JButton();
        PANEL_MAIN = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perros-Pet");
        setBackground(new java.awt.Color(57, 50, 50));
        setFocusable(false);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
        setMaximumSize(new java.awt.Dimension(904, 552));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        PANEL_NAV.setBackground(new java.awt.Color(57, 50, 50));
        PANEL_NAV.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        PANEL_NAV.setMinimumSize(new java.awt.Dimension(200, 552));
        PANEL_NAV.setPreferredSize(new java.awt.Dimension(200, 552));
        PANEL_NAV.setLayout(new javax.swing.BoxLayout(PANEL_NAV, javax.swing.BoxLayout.Y_AXIS));

        IMG_PEFIL.setMaximumSize(new java.awt.Dimension(200, 200));
        IMG_PEFIL.setMinimumSize(new java.awt.Dimension(200, 200));
        IMG_PEFIL.setPreferredSize(new java.awt.Dimension(200, 200));
        PANEL_NAV.add(IMG_PEFIL);

        BUTTON_MODULO1.setBackground(new java.awt.Color(57, 50, 50));
        BUTTON_MODULO1.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
        BUTTON_MODULO1.setForeground(new java.awt.Color(242, 237, 215));
        BUTTON_MODULO1.setText("Modulo 2");
        BUTTON_MODULO1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        BUTTON_MODULO1.setBorderPainted(false);
        BUTTON_MODULO1.setFocusPainted(false);
        BUTTON_MODULO1.setFocusable(false);
        BUTTON_MODULO1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BUTTON_MODULO1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BUTTON_MODULO1.setMaximumSize(new java.awt.Dimension(200, 50));
        BUTTON_MODULO1.setMinimumSize(new java.awt.Dimension(200, 23));
        BUTTON_MODULO1.setPreferredSize(new java.awt.Dimension(200, 50));
        BUTTON_MODULO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTTON_MODULO1ActionPerformed(evt);
            }
        });
        PANEL_NAV.add(BUTTON_MODULO1);

        BUTTON_MODULO2.setBackground(new java.awt.Color(57, 50, 50));
        BUTTON_MODULO2.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
        BUTTON_MODULO2.setForeground(new java.awt.Color(242, 237, 215));
        BUTTON_MODULO2.setText("Modulo 1");
        BUTTON_MODULO2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        BUTTON_MODULO2.setBorderPainted(false);
        BUTTON_MODULO2.setFocusPainted(false);
        BUTTON_MODULO2.setFocusable(false);
        BUTTON_MODULO2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BUTTON_MODULO2.setMaximumSize(new java.awt.Dimension(200, 50));
        BUTTON_MODULO2.setMinimumSize(new java.awt.Dimension(200, 23));
        BUTTON_MODULO2.setPreferredSize(new java.awt.Dimension(200, 50));
        BUTTON_MODULO2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTTON_MODULO2ActionPerformed(evt);
            }
        });
        PANEL_NAV.add(BUTTON_MODULO2);

        BUTTON_MODULO3.setBackground(new java.awt.Color(57, 50, 50));
        BUTTON_MODULO3.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
        BUTTON_MODULO3.setForeground(new java.awt.Color(242, 237, 215));
        BUTTON_MODULO3.setText("Modulo 3");
        BUTTON_MODULO3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        BUTTON_MODULO3.setBorderPainted(false);
        BUTTON_MODULO3.setFocusPainted(false);
        BUTTON_MODULO3.setFocusable(false);
        BUTTON_MODULO3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BUTTON_MODULO3.setMaximumSize(new java.awt.Dimension(200, 50));
        BUTTON_MODULO3.setMinimumSize(new java.awt.Dimension(200, 23));
        BUTTON_MODULO3.setPreferredSize(new java.awt.Dimension(200, 50));
        BUTTON_MODULO3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTTON_MODULO3ActionPerformed(evt);
            }
        });
        PANEL_NAV.add(BUTTON_MODULO3);

        BUTTON_SALIR.setBackground(new java.awt.Color(57, 50, 50));
        BUTTON_SALIR.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
        BUTTON_SALIR.setForeground(new java.awt.Color(242, 237, 215));
        BUTTON_SALIR.setText("Salir");
        BUTTON_SALIR.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        BUTTON_SALIR.setBorderPainted(false);
        BUTTON_SALIR.setFocusPainted(false);
        BUTTON_SALIR.setFocusable(false);
        BUTTON_SALIR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BUTTON_SALIR.setMaximumSize(new java.awt.Dimension(200, 50));
        BUTTON_SALIR.setMinimumSize(new java.awt.Dimension(200, 23));
        BUTTON_SALIR.setPreferredSize(new java.awt.Dimension(200, 50));
        BUTTON_SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUTTON_SALIRActionPerformed(evt);
            }
        });
        PANEL_NAV.add(BUTTON_SALIR);

        getContentPane().add(PANEL_NAV, new java.awt.GridBagConstraints());

        PANEL_MAIN.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MAIN.setMinimumSize(new java.awt.Dimension(704, 552));
        PANEL_MAIN.setPreferredSize(new java.awt.Dimension(704, 552));

        javax.swing.GroupLayout PANEL_MAINLayout = new javax.swing.GroupLayout(PANEL_MAIN);
        PANEL_MAIN.setLayout(PANEL_MAINLayout);
        PANEL_MAINLayout.setHorizontalGroup(PANEL_MAINLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 704, Short.MAX_VALUE));
        PANEL_MAINLayout.setVerticalGroup(PANEL_MAINLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 552, Short.MAX_VALUE));

        getContentPane().add(PANEL_MAIN, new java.awt.GridBagConstraints());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Moverse entre los distintos paneles
    private void BUTTON_MODULO1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BUTTON_MODULO1ActionPerformed
        this.remove(modulo2);
        this.remove(modulo3);
        this.add(modulo1);
        validate();
        repaint();
    }// GEN-LAST:event_BUTTON_MODULO1ActionPerformed

    private void BUTTON_MODULO2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BUTTON_MODULO2ActionPerformed
        this.remove(modulo1);
        this.remove(modulo3);
        this.add(modulo2);
        validate();
        repaint();
    }// GEN-LAST:event_BUTTON_MODULO2ActionPerformed

    private void BUTTON_MODULO3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BUTTON_MODULO3ActionPerformed
        this.remove(modulo1);
        this.remove(modulo2);
        this.add(modulo3);
        validate();
        repaint();
    }// GEN-LAST:event_BUTTON_MODULO3ActionPerformed

    private void BUTTON_SALIRActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BUTTON_SALIRActionPerformed
        this.setVisible(false);
        (PerrosPET.ingreso).setVisible(true);
        // TODO add your handling code here:
    }// GEN-LAST:event_BUTTON_SALIRActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuario(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUTTON_MODULO1;
    private javax.swing.JButton BUTTON_MODULO2;
    private javax.swing.JButton BUTTON_MODULO3;
    private javax.swing.JButton BUTTON_SALIR;
    private javax.swing.JLabel IMG_PEFIL;
    private javax.swing.JPanel PANEL_MAIN;
    private javax.swing.JPanel PANEL_NAV;
    // End of variables declaration//GEN-END:variables
}
