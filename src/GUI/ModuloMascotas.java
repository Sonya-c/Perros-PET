
package GUI;

public class ModuloMascotas extends javax.swing.JPanel {

    public ModuloMascotas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameDatosMascota = new javax.swing.JFrame();
        PANEL_MAIN = new javax.swing.JPanel();
        VACIO_01 = new javax.swing.JLabel();
        LABEL_TITULO = new javax.swing.JLabel();
        LABEL_NOMBRE = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        LABEL_RAZA = new javax.swing.JLabel();
        inputRaza = new javax.swing.JTextField();
        LABEL_COLOR = new javax.swing.JLabel();
        inputRojo = new javax.swing.JTextField();
        PANEL_FECHA_NACIMIENTO = new javax.swing.JPanel();
        LABEL_FECHA_NACIMIENTO = new javax.swing.JLabel();
        inputDate = new com.toedter.calendar.JDateChooser();
        VACIO_02 = new javax.swing.JLabel();
        bottonGuardarCambios = new javax.swing.JButton();
        PANEL_TABLA = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        buttonAñadirMascota = new javax.swing.JToggleButton();

        FrameDatosMascota.setTitle("Perros-Pet: cita");
        FrameDatosMascota.setTitle("Perros-PET: Información mascotas");
        FrameDatosMascota.setBackground(new java.awt.Color(242, 237, 215));
        FrameDatosMascota.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
        FrameDatosMascota.setMaximumSize(new java.awt.Dimension(500, 550));
        FrameDatosMascota.setMinimumSize(new java.awt.Dimension(500, 470));
        FrameDatosMascota.setPreferredSize(new java.awt.Dimension(500, 550));
        FrameDatosMascota.setResizable(false);
        FrameDatosMascota.getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        FrameDatosMascota.setLocationRelativeTo(null);

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
        LABEL_TITULO.setText("Información de Mascota");
        LABEL_TITULO.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        PANEL_MAIN.add(LABEL_TITULO);

        LABEL_NOMBRE.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_NOMBRE.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_NOMBRE.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_NOMBRE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_NOMBRE.setText("Nombre de la mascota");
        LABEL_NOMBRE.setAlignmentX(5.0F);
        LABEL_NOMBRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_NOMBRE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_NOMBRE.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_MAIN.add(LABEL_NOMBRE);

        inputNombre.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNombre.setText("Firulais");
        inputNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_MAIN.add(inputNombre);

        LABEL_RAZA.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_RAZA.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_RAZA.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_RAZA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_RAZA.setText("Raza");
        LABEL_RAZA.setAlignmentX(5.0F);
        LABEL_RAZA.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_RAZA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_RAZA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_MAIN.add(LABEL_RAZA);

        inputRaza.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputRaza.setText("Chigüagüa");
        inputRaza.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_MAIN.add(inputRaza);

        LABEL_COLOR.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_COLOR.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_COLOR.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_COLOR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_COLOR.setText("Color");
        LABEL_COLOR.setAlignmentX(5.0F);
        LABEL_COLOR.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_COLOR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_COLOR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_MAIN.add(LABEL_COLOR);

        inputRojo.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputRojo.setText("Rojo");
        inputRojo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_MAIN.add(inputRojo);

        PANEL_FECHA_NACIMIENTO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_FECHA_NACIMIENTO.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_FECHA_NACIMIENTO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_FECHA_NACIMIENTO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_FECHA_NACIMIENTO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_FECHA_NACIMIENTO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_FECHA_NACIMIENTO.setText("Fecha Nacimiento");
        LABEL_FECHA_NACIMIENTO.setAlignmentX(5.0F);
        LABEL_FECHA_NACIMIENTO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_FECHA_NACIMIENTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_FECHA_NACIMIENTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_FECHA_NACIMIENTO.add(LABEL_FECHA_NACIMIENTO);
        PANEL_FECHA_NACIMIENTO.add(inputDate);

        PANEL_MAIN.add(PANEL_FECHA_NACIMIENTO);

        VACIO_02.setBackground(new java.awt.Color(242, 237, 215));
        VACIO_02.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        VACIO_02.setForeground(new java.awt.Color(57, 50, 50));
        VACIO_02.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VACIO_02.setAlignmentX(5.0F);
        VACIO_02.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        VACIO_02.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        VACIO_02.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_MAIN.add(VACIO_02);

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

        FrameDatosMascota.getContentPane().add(PANEL_MAIN);

        setBackground(new java.awt.Color(242, 237, 215));
        setMaximumSize(new java.awt.Dimension(704, 552));
        setMinimumSize(new java.awt.Dimension(704, 552));
        setName("Mis mascotas"); // NOI18N

        PANEL_TABLA.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        PANEL_TABLA.setBorder(null);
        PANEL_TABLA.setFocusable(false);

        tablaCitas.getTableHeader().setBackground(new java.awt.Color(58,99,81));
        tablaCitas.getTableHeader().setForeground(new java.awt.Color(255,255,255));
        tablaCitas.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        tablaCitas.setForeground(new java.awt.Color(57, 50, 50));
        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Raza", "Color", "Fecha nacimieto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCitas.setGridColor(new java.awt.Color(242, 237, 215));
        tablaCitas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaCitas.setRowHeight(25);
        tablaCitas.setSelectionBackground(new java.awt.Color(228, 129, 86));
        tablaCitas.setShowVerticalLines(false);
        PANEL_TABLA.setViewportView(tablaCitas);

        buttonAñadirMascota.setBackground(new java.awt.Color(228, 130, 87));
        buttonAñadirMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        buttonAñadirMascota.setText("Añadir Mascota");
        buttonAñadirMascota.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonAñadirMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirMascotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonAñadirMascota)
                    .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAñadirMascota)
                .addGap(22, 22, 22))
        );

        getAccessibleContext().setAccessibleName("Mis mascotas");
    }// </editor-fold>//GEN-END:initComponents

    // Abrir el panel
    private void abrirEditorMacota(){
        FrameDatosMascota.setVisible(true);
    }
    private void buttonAñadirMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAñadirMascotaActionPerformed
        abrirEditorMacota();
    }//GEN-LAST:event_buttonAñadirMascotaActionPerformed

    private void bottonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonGuardarCambiosActionPerformed

    }//GEN-LAST:event_bottonGuardarCambiosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameDatosMascota;
    private javax.swing.JLabel LABEL_COLOR;
    private javax.swing.JLabel LABEL_FECHA_NACIMIENTO;
    private javax.swing.JLabel LABEL_NOMBRE;
    private javax.swing.JLabel LABEL_RAZA;
    private javax.swing.JLabel LABEL_TITULO;
    private javax.swing.JPanel PANEL_FECHA_NACIMIENTO;
    private javax.swing.JPanel PANEL_MAIN;
    private javax.swing.JScrollPane PANEL_TABLA;
    private javax.swing.JLabel VACIO_01;
    private javax.swing.JLabel VACIO_02;
    private javax.swing.JButton bottonGuardarCambios;
    private javax.swing.JToggleButton buttonAñadirMascota;
    private com.toedter.calendar.JDateChooser inputDate;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputRaza;
    private javax.swing.JTextField inputRojo;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}