package GUI;

public class Ingreso extends javax.swing.JFrame {

    public Ingreso() {
        initComponents();
        this.remove(Form);
        Form = Ingreso;
        this.add(Ingreso);
    }
    
    private void verContraseña(javax.swing.JPasswordField campo) {
        if (campo.getEchoChar() != (char)0)
            campo.setEchoChar((char)0);
        else 
            campo.setEchoChar('\u2022');
    }
    
    // ACCIONES
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        Ingreso = new javax.swing.JPanel();
        jLabel_ingresar = new javax.swing.JLabel();
        jLabel_nombre = new javax.swing.JLabel();
        input_nombre = new javax.swing.JTextField();
        jLabel_contraseña = new javax.swing.JLabel();
        panel_contraseña = new javax.swing.JPanel();
        input_contraseña = new javax.swing.JPasswordField();
        button_verContraseña = new javax.swing.JButton();
        vacio = new javax.swing.JLabel();
        botton_zone = new javax.swing.JPanel();
        jButton_ingresar = new javax.swing.JButton();
        jButton_registrar = new javax.swing.JButton();
        Registro = new javax.swing.JPanel();
        jLabel_registrase = new javax.swing.JLabel();
        jLabel_nombreR = new javax.swing.JLabel();
        input_nombreR = new javax.swing.JTextField();
        jLabel_contraseñaR = new javax.swing.JLabel();
        panel_contraseñaR = new javax.swing.JPanel();
        input_contraseñaR = new javax.swing.JPasswordField();
        button_verContraseñaR = new javax.swing.JButton();
        jLabel_documento = new javax.swing.JLabel();
        Pane_documentol = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabe_tipoUsuario = new javax.swing.JLabel();
        Pane_documentol1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        vacioR = new javax.swing.JLabel();
        botton_zone1 = new javax.swing.JPanel();
        jButton_ingresar1 = new javax.swing.JButton();
        jButton_registrar1 = new javax.swing.JButton();
        Imagen = new javax.swing.JPanel();
        toby_png = new javax.swing.JLabel();
        Form = new javax.swing.JPanel();

        Ingreso.setBackground(new java.awt.Color(57, 50, 50));
        Ingreso.setMaximumSize(new java.awt.Dimension(452, 552));
        Ingreso.setMinimumSize(new java.awt.Dimension(452, 552));
        Ingreso.setPreferredSize(new java.awt.Dimension(452, 552));
        Ingreso.setLayout(new java.awt.GridLayout(7, 1));

        jLabel_ingresar.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_ingresar.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel_ingresar.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_ingresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ingresar.setText("Ingresar");
        Ingreso.add(jLabel_ingresar);

        jLabel_nombre.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_nombre.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel_nombre.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_nombre.setText("Nombre de Usuario");
        jLabel_nombre.setAlignmentX(5.0F);
        jLabel_nombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jLabel_nombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_nombre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Ingreso.add(jLabel_nombre);

        input_nombre.setBackground(new java.awt.Color(242, 237, 215));
        input_nombre.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        input_nombre.setText("Fulanito de Tal");
        input_nombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        Ingreso.add(input_nombre);

        jLabel_contraseña.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_contraseña.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel_contraseña.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_contraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_contraseña.setText("Contraseña");
        jLabel_contraseña.setAlignmentX(5.0F);
        jLabel_contraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jLabel_contraseña.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_contraseña.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Ingreso.add(jLabel_contraseña);

        panel_contraseña.setBackground(new java.awt.Color(242, 237, 215));
        panel_contraseña.setForeground(new java.awt.Color(57, 50, 50));
        panel_contraseña.setLayout(new javax.swing.BoxLayout(panel_contraseña, javax.swing.BoxLayout.LINE_AXIS));

        input_contraseña.setBackground(new java.awt.Color(242, 237, 215));
        input_contraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        input_contraseña.setText("fulanitodeltal123");
        input_contraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel_contraseña.add(input_contraseña);

        button_verContraseña.setBackground(new java.awt.Color(242, 237, 215));
        button_verContraseña.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        button_verContraseña.setForeground(new java.awt.Color(57, 50, 50));
        button_verContraseña.setText("Ver");
        button_verContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button_verContraseña.setBorderPainted(false);
        button_verContraseña.setFocusPainted(false);
        button_verContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_verContraseñaActionPerformed(evt);
            }
        });
        panel_contraseña.add(button_verContraseña);

        Ingreso.add(panel_contraseña);
        Ingreso.add(vacio);

        botton_zone.setBackground(new java.awt.Color(57, 50, 50));

        jButton_ingresar.setBackground(new java.awt.Color(228, 130, 87));
        jButton_ingresar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jButton_ingresar.setForeground(new java.awt.Color(242, 237, 215));
        jButton_ingresar.setText("Ingresar");
        jButton_ingresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jButton_ingresar.setBorderPainted(false);
        jButton_ingresar.setFocusPainted(false);
        jButton_ingresar.setFocusable(false);

        jButton_registrar.setBackground(new java.awt.Color(58, 99, 81));
        jButton_registrar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(242, 237, 215));
        jButton_registrar.setText("Registrarse");
        jButton_registrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jButton_registrar.setBorderPainted(false);
        jButton_registrar.setFocusPainted(false);
        jButton_registrar.setFocusable(false);
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botton_zoneLayout = new javax.swing.GroupLayout(botton_zone);
        botton_zone.setLayout(botton_zoneLayout);
        botton_zoneLayout.setHorizontalGroup(
            botton_zoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botton_zoneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botton_zoneLayout.setVerticalGroup(
            botton_zoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botton_zoneLayout.createSequentialGroup()
                .addGroup(botton_zoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        Ingreso.add(botton_zone);

        Registro.setBackground(new java.awt.Color(57, 50, 50));
        Registro.setMaximumSize(new java.awt.Dimension(452, 552));
        Registro.setMinimumSize(new java.awt.Dimension(452, 552));
        Registro.setPreferredSize(new java.awt.Dimension(452, 552));
        Registro.setLayout(new java.awt.GridLayout(11, 1));

        jLabel_registrase.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_registrase.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLabel_registrase.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_registrase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_registrase.setText("Registarse");
        Registro.add(jLabel_registrase);

        jLabel_nombreR.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_nombreR.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel_nombreR.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_nombreR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_nombreR.setText("Nombre de Usuario");
        jLabel_nombreR.setAlignmentX(5.0F);
        jLabel_nombreR.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jLabel_nombreR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_nombreR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Registro.add(jLabel_nombreR);

        input_nombreR.setBackground(new java.awt.Color(242, 237, 215));
        input_nombreR.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        input_nombreR.setText("Fulanito de Tal");
        input_nombreR.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        Registro.add(input_nombreR);

        jLabel_contraseñaR.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_contraseñaR.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel_contraseñaR.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_contraseñaR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_contraseñaR.setText("Contraseña");
        jLabel_contraseñaR.setAlignmentX(5.0F);
        jLabel_contraseñaR.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jLabel_contraseñaR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_contraseñaR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Registro.add(jLabel_contraseñaR);

        panel_contraseñaR.setBackground(new java.awt.Color(242, 237, 215));
        panel_contraseñaR.setForeground(new java.awt.Color(57, 50, 50));
        panel_contraseñaR.setLayout(new javax.swing.BoxLayout(panel_contraseñaR, javax.swing.BoxLayout.LINE_AXIS));

        input_contraseñaR.setBackground(new java.awt.Color(242, 237, 215));
        input_contraseñaR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        input_contraseñaR.setText("fulanitodeltal123");
        input_contraseñaR.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        panel_contraseñaR.add(input_contraseñaR);

        button_verContraseñaR.setBackground(new java.awt.Color(242, 237, 215));
        button_verContraseñaR.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        button_verContraseñaR.setForeground(new java.awt.Color(57, 50, 50));
        button_verContraseñaR.setText("Ver");
        button_verContraseñaR.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button_verContraseñaR.setBorderPainted(false);
        button_verContraseñaR.setFocusPainted(false);
        button_verContraseñaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_verContraseñaRActionPerformed(evt);
            }
        });
        panel_contraseñaR.add(button_verContraseñaR);

        Registro.add(panel_contraseñaR);

        jLabel_documento.setBackground(new java.awt.Color(242, 237, 215));
        jLabel_documento.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel_documento.setForeground(new java.awt.Color(242, 237, 215));
        jLabel_documento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_documento.setText("Documento");
        jLabel_documento.setAlignmentX(5.0F);
        jLabel_documento.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jLabel_documento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_documento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Registro.add(jLabel_documento);

        Pane_documentol.setLayout(new javax.swing.BoxLayout(Pane_documentol, javax.swing.BoxLayout.X_AXIS));

        jTextField1.setBackground(new java.awt.Color(242, 237, 215));
        jTextField1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTextField1.setText("100010001001");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        Pane_documentol.add(jTextField1);

        jComboBox1.setBackground(new java.awt.Color(242, 237, 215));
        jComboBox1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cedula", "TI", "Pasaporte", "Cedula E" }));
        jComboBox1.setFocusable(false);
        jComboBox1.setOpaque(false);
        jComboBox1.setRequestFocusEnabled(false);
        Pane_documentol.add(jComboBox1);

        Registro.add(Pane_documentol);

        jLabe_tipoUsuario.setBackground(new java.awt.Color(242, 237, 215));
        jLabe_tipoUsuario.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabe_tipoUsuario.setForeground(new java.awt.Color(242, 237, 215));
        jLabe_tipoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabe_tipoUsuario.setText("Tipo usuario");
        jLabe_tipoUsuario.setAlignmentX(5.0F);
        jLabe_tipoUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jLabe_tipoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabe_tipoUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Registro.add(jLabe_tipoUsuario);

        Pane_documentol1.setLayout(new javax.swing.BoxLayout(Pane_documentol1, javax.swing.BoxLayout.X_AXIS));

        jTextField2.setBackground(new java.awt.Color(242, 237, 215));
        jTextField2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jTextField2.setText("Clave secreta");
        jTextField2.setToolTipText("Cada usuario tiene una clave secreta. Para poder identificarse como veterinario o administrador debe ingresar una clave secreta. Su usted es usurio, puede dejar este campo vacio");
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        Pane_documentol1.add(jTextField2);

        jComboBox2.setBackground(new java.awt.Color(242, 237, 215));
        jComboBox2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario", "Veterinario", "Administrador" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jComboBox2.setFocusable(false);
        jComboBox2.setLightWeightPopupEnabled(false);
        jComboBox2.setOpaque(false);
        jComboBox2.setRequestFocusEnabled(false);
        jComboBox2.setVerifyInputWhenFocusTarget(false);
        Pane_documentol1.add(jComboBox2);

        Registro.add(Pane_documentol1);
        Registro.add(vacioR);

        botton_zone1.setBackground(new java.awt.Color(57, 50, 50));

        jButton_ingresar1.setBackground(new java.awt.Color(228, 130, 87));
        jButton_ingresar1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jButton_ingresar1.setForeground(new java.awt.Color(242, 237, 215));
        jButton_ingresar1.setText("Ingresar");
        jButton_ingresar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jButton_ingresar1.setBorderPainted(false);
        jButton_ingresar1.setFocusPainted(false);
        jButton_ingresar1.setFocusable(false);
        jButton_ingresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ingresar1ActionPerformed(evt);
            }
        });

        jButton_registrar1.setBackground(new java.awt.Color(58, 99, 81));
        jButton_registrar1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jButton_registrar1.setForeground(new java.awt.Color(242, 237, 215));
        jButton_registrar1.setText("Registrarse");
        jButton_registrar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        jButton_registrar1.setBorderPainted(false);
        jButton_registrar1.setFocusPainted(false);
        jButton_registrar1.setFocusable(false);

        javax.swing.GroupLayout botton_zone1Layout = new javax.swing.GroupLayout(botton_zone1);
        botton_zone1.setLayout(botton_zone1Layout);
        botton_zone1Layout.setHorizontalGroup(
            botton_zone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botton_zone1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton_ingresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton_registrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botton_zone1Layout.setVerticalGroup(
            botton_zone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botton_zone1Layout.createSequentialGroup()
                .addGroup(botton_zone1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_registrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton_ingresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        Registro.add(botton_zone1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perros-pet: ¡Bienvenido!");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, toby_png, org.jdesktop.beansbinding.ELProperty.create("${background}"), Imagen, org.jdesktop.beansbinding.BeanProperty.create("background"));
        bindingGroup.addBinding(binding);

        toby_png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Toby.jpg"))); // NOI18N

        javax.swing.GroupLayout ImagenLayout = new javax.swing.GroupLayout(Imagen);
        Imagen.setLayout(ImagenLayout);
        ImagenLayout.setHorizontalGroup(
            ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toby_png, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ImagenLayout.setVerticalGroup(
            ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toby_png, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(Imagen);

        Form.setBackground(new java.awt.Color(57, 50, 50));

        javax.swing.GroupLayout FormLayout = new javax.swing.GroupLayout(Form);
        Form.setLayout(FormLayout);
        FormLayout.setHorizontalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        FormLayout.setVerticalGroup(
            FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        getContentPane().add(Form);

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_verContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_verContraseñaActionPerformed
        verContraseña(input_contraseña);
    }//GEN-LAST:event_button_verContraseñaActionPerformed

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed
        this.remove(Ingreso);
        this.add(Registro);
        validate();
        repaint();
    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void button_verContraseñaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_verContraseñaRActionPerformed
        verContraseña(input_contraseñaR);
    }//GEN-LAST:event_button_verContraseñaRActionPerformed

    private void jButton_ingresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ingresar1ActionPerformed
        this.remove(Registro);
        this.add(Ingreso);
        validate();
        repaint();
    }//GEN-LAST:event_jButton_ingresar1ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Form;
    private javax.swing.JPanel Imagen;
    private javax.swing.JPanel Ingreso;
    private javax.swing.JPanel Pane_documentol;
    private javax.swing.JPanel Pane_documentol1;
    private javax.swing.JPanel Registro;
    private javax.swing.JPanel botton_zone;
    private javax.swing.JPanel botton_zone1;
    private javax.swing.JButton button_verContraseña;
    private javax.swing.JButton button_verContraseñaR;
    private javax.swing.JPasswordField input_contraseña;
    private javax.swing.JPasswordField input_contraseñaR;
    private javax.swing.JTextField input_nombre;
    private javax.swing.JTextField input_nombreR;
    private javax.swing.JButton jButton_ingresar;
    private javax.swing.JButton jButton_ingresar1;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JButton jButton_registrar1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabe_tipoUsuario;
    private javax.swing.JLabel jLabel_contraseña;
    private javax.swing.JLabel jLabel_contraseñaR;
    private javax.swing.JLabel jLabel_documento;
    private javax.swing.JLabel jLabel_ingresar;
    private javax.swing.JLabel jLabel_nombre;
    private javax.swing.JLabel jLabel_nombreR;
    private javax.swing.JLabel jLabel_registrase;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panel_contraseña;
    private javax.swing.JPanel panel_contraseñaR;
    private javax.swing.JLabel toby_png;
    private javax.swing.JLabel vacio;
    private javax.swing.JLabel vacioR;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
