
package GUI;

public class Loader extends javax.swing.JFrame {

    public Loader() {
        initComponents();
    }

    public void addValue() {
        progressBar.setValue(progressBar.getValue() + 1);
    }
    
    public void limpiarBarra() {
        progressBar.setValue(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MAIN_PANEL = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        Mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PerrosPET: Cargando");
        setBackground(new java.awt.Color(57, 50, 50));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout());

        MAIN_PANEL.setBackground(new java.awt.Color(57, 50, 50));

        progressBar.setBackground(new java.awt.Color(242, 237, 215));
        progressBar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        progressBar.setForeground(new java.awt.Color(58, 99, 81));
        progressBar.setMaximum(5);
        progressBar.setToolTipText("");
        progressBar.setStringPainted(true);

        Mensaje.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        Mensaje.setForeground(new java.awt.Color(228, 130, 87));
        Mensaje.setText("Cargando...");

        javax.swing.GroupLayout MAIN_PANELLayout = new javax.swing.GroupLayout(MAIN_PANEL);
        MAIN_PANEL.setLayout(MAIN_PANELLayout);
        MAIN_PANELLayout.setHorizontalGroup(
            MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PANELLayout.createSequentialGroup()
                .addGroup(MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MAIN_PANELLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MAIN_PANELLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(Mensaje)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        MAIN_PANELLayout.setVerticalGroup(
            MAIN_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MAIN_PANELLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(Mensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        getContentPane().add(MAIN_PANEL);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MAIN_PANEL;
    private javax.swing.JLabel Mensaje;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
