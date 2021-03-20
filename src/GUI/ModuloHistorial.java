
package GUI;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Veterinaria.Historial;

public class ModuloHistorial extends javax.swing.JPanel {
    public Veterinaria.Veterinario veterinario;

    public ModuloHistorial(Veterinaria.Veterinario veterinario) {
        initComponents();
        this.veterinario = veterinario;
    }

    public void setDataTable() {
        // "ID", "Mascota", "Fecha", "Diagnostico"
        String mascota, fecha, diagnostico;
        DefaultTableModel model = (DefaultTableModel) tablaHistorial.getModel();
        for (Historial historial : veterinario.misHistoriales) {
            mascota = (historial.cita).perro.nombre;
            fecha = (historial.cita).fecha.toString();
            diagnostico = historial.diagnostico;
            Object[] row = { mascota, fecha, diagnostico };
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FrameDatosHistorial = new javax.swing.JFrame();
        PANEL_MAIN = new javax.swing.JPanel();
        LABEL_TITULO = new javax.swing.JLabel();
        PANEL_DUEÑO = new javax.swing.JPanel();
        LABEL_DUEÑO = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        PANEL_DOCUMENTO = new javax.swing.JPanel();
        LABEL_DOCUMENTO = new javax.swing.JLabel();
        inputCedula = new javax.swing.JTextField();
        PANEL_NOMBRE_PERRO = new javax.swing.JPanel();
        LABEL_MASCOTA = new javax.swing.JLabel();
        inputMascota = new javax.swing.JTextField();
        PANEL_DIAGNOSTICO = new javax.swing.JPanel();
        LABEL_DIAGNOSTICO = new javax.swing.JLabel();
        inputDiagnostico = new javax.swing.JTextField();
        PANEL_PRESCRIPCIÓN = new javax.swing.JPanel();
        LABEL_DIAGNOSTICO1 = new javax.swing.JLabel();
        PANEL_PRESECIPCIÓN_TEXTO = new javax.swing.JScrollPane();
        TEXTAREA_PRESCRIPCIÓN = new javax.swing.JTextArea();
        bottonGuardarCambios = new javax.swing.JButton();
        PANEL_TABLA = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        buttonAñadirHistorial = new javax.swing.JToggleButton();

        FrameDatosHistorial.setTitle("Perros-Pet: cita");
        FrameDatosHistorial.setTitle("Perros-PET: Información mascotas");
        FrameDatosHistorial.setBackground(new java.awt.Color(242, 237, 215));
        FrameDatosHistorial
                .setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
        FrameDatosHistorial.setMaximumSize(new java.awt.Dimension(530, 570));
        FrameDatosHistorial.setMinimumSize(new java.awt.Dimension(530, 570));
        FrameDatosHistorial.setResizable(false);
        FrameDatosHistorial.getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        FrameDatosHistorial.setLocationRelativeTo(null);

        PANEL_MAIN.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MAIN.setMaximumSize(new java.awt.Dimension(530, 570));
        PANEL_MAIN.setMinimumSize(new java.awt.Dimension(530, 570));
        PANEL_MAIN.setPreferredSize(new java.awt.Dimension(530, 570));
        PANEL_MAIN.setRequestFocusEnabled(false);
        PANEL_MAIN.setLayout(new java.awt.GridBagLayout());

        LABEL_TITULO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_TITULO.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        LABEL_TITULO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_TITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LABEL_TITULO.setText("Información de Mascota");
        LABEL_TITULO.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LABEL_TITULO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_TITULO.setMaximumSize(new java.awt.Dimension(452, 30));
        LABEL_TITULO.setMinimumSize(new java.awt.Dimension(452, 30));
        LABEL_TITULO.setPreferredSize(new java.awt.Dimension(452, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(LABEL_TITULO, gridBagConstraints);

        PANEL_DUEÑO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_DUEÑO.setPreferredSize(new java.awt.Dimension(100, 78));
        PANEL_DUEÑO.setLayout(new java.awt.GridLayout(1, 0));

        LABEL_DUEÑO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_DUEÑO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_DUEÑO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_DUEÑO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_DUEÑO.setText("Dueño");
        LABEL_DUEÑO.setAlignmentX(5.0F);
        LABEL_DUEÑO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_DUEÑO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_DUEÑO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_DUEÑO.add(LABEL_DUEÑO);

        inputNombre.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNombre.setText("Fulano de Tal");
        inputNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_DUEÑO.add(inputNombre);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_DUEÑO, gridBagConstraints);

        PANEL_DOCUMENTO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_DOCUMENTO.setPreferredSize(new java.awt.Dimension(100, 78));
        PANEL_DOCUMENTO.setLayout(new java.awt.GridLayout(1, 2));

        LABEL_DOCUMENTO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_DOCUMENTO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_DOCUMENTO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_DOCUMENTO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_DOCUMENTO.setText("Documento");
        LABEL_DOCUMENTO.setAlignmentX(5.0F);
        LABEL_DOCUMENTO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_DOCUMENTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_DOCUMENTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_DOCUMENTO.add(LABEL_DOCUMENTO);

        inputCedula.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputCedula.setText("1001822184");
        inputCedula.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_DOCUMENTO.add(inputCedula);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_DOCUMENTO, gridBagConstraints);

        PANEL_NOMBRE_PERRO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_NOMBRE_PERRO.setPreferredSize(new java.awt.Dimension(100, 78));
        PANEL_NOMBRE_PERRO.setLayout(new java.awt.GridLayout(1, 0));

        LABEL_MASCOTA.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_MASCOTA.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_MASCOTA.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_MASCOTA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_MASCOTA.setText("Nombre de la Macota");
        LABEL_MASCOTA.setAlignmentX(5.0F);
        LABEL_MASCOTA.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_MASCOTA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_MASCOTA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_NOMBRE_PERRO.add(LABEL_MASCOTA);

        inputMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputMascota.setText("Firulais");
        inputMascota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_NOMBRE_PERRO.add(inputMascota);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_NOMBRE_PERRO, gridBagConstraints);

        PANEL_DIAGNOSTICO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_DIAGNOSTICO.setPreferredSize(new java.awt.Dimension(100, 78));
        PANEL_DIAGNOSTICO.setLayout(new java.awt.GridLayout(1, 0));

        LABEL_DIAGNOSTICO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_DIAGNOSTICO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_DIAGNOSTICO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_DIAGNOSTICO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_DIAGNOSTICO.setText("Diaganostico");
        LABEL_DIAGNOSTICO.setAlignmentX(5.0F);
        LABEL_DIAGNOSTICO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_DIAGNOSTICO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_DIAGNOSTICO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_DIAGNOSTICO.add(LABEL_DIAGNOSTICO);

        inputDiagnostico.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputDiagnostico.setText("Dolor de panza");
        inputDiagnostico.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_DIAGNOSTICO.add(inputDiagnostico);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_DIAGNOSTICO, gridBagConstraints);

        PANEL_PRESCRIPCIÓN.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRESCRIPCIÓN.setLayout(new java.awt.GridLayout(1, 2));

        LABEL_DIAGNOSTICO1.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_DIAGNOSTICO1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_DIAGNOSTICO1.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_DIAGNOSTICO1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_DIAGNOSTICO1.setText("Prescripción");
        LABEL_DIAGNOSTICO1.setAlignmentX(5.0F);
        LABEL_DIAGNOSTICO1.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_DIAGNOSTICO1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_DIAGNOSTICO1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_PRESCRIPCIÓN.add(LABEL_DIAGNOSTICO1);

        TEXTAREA_PRESCRIPCIÓN.setColumns(20);
        TEXTAREA_PRESCRIPCIÓN.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        TEXTAREA_PRESCRIPCIÓN.setLineWrap(true);
        TEXTAREA_PRESCRIPCIÓN.setRows(5);
        TEXTAREA_PRESCRIPCIÓN.setWrapStyleWord(true);
        PANEL_PRESECIPCIÓN_TEXTO.setViewportView(TEXTAREA_PRESCRIPCIÓN);

        PANEL_PRESCRIPCIÓN.add(PANEL_PRESECIPCIÓN_TEXTO);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_PRESCRIPCIÓN, gridBagConstraints);

        bottonGuardarCambios.setBackground(new java.awt.Color(228, 130, 87));
        bottonGuardarCambios.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        bottonGuardarCambios.setForeground(new java.awt.Color(242, 237, 215));
        bottonGuardarCambios.setText("Guardar cambios");
        bottonGuardarCambios.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        bottonGuardarCambios.setBorderPainted(false);
        bottonGuardarCambios.setFocusPainted(false);
        bottonGuardarCambios.setFocusable(false);
        bottonGuardarCambios.setPreferredSize(new java.awt.Dimension(100, 78));
        bottonGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonGuardarCambiosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(bottonGuardarCambios, gridBagConstraints);

        FrameDatosHistorial.getContentPane().add(PANEL_MAIN);

        setBackground(new java.awt.Color(242, 237, 215));
        setMaximumSize(new java.awt.Dimension(704, 552));
        setMinimumSize(new java.awt.Dimension(704, 552));
        setName("Historial"); // NOI18N

        PANEL_TABLA.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        PANEL_TABLA.setBorder(null);
        PANEL_TABLA.setFocusable(false);

        tablaHistorial.getTableHeader().setBackground(new java.awt.Color(58, 99, 81));
        tablaHistorial.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        tablaHistorial.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        tablaHistorial.setForeground(new java.awt.Color(57, 50, 50));
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null }, { null, null, null, null } },
                new String[] { "ID", "Mascota", "Fecha", "Diagnostico" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tablaHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaHistorial.setGridColor(new java.awt.Color(242, 237, 215));
        tablaHistorial.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaHistorial.setRowHeight(25);
        tablaHistorial.setSelectionBackground(new java.awt.Color(228, 129, 86));
        tablaHistorial.setShowVerticalLines(false);
        tablaHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaHistorialMouseClicked(evt);
            }
        });
        PANEL_TABLA.setViewportView(tablaHistorial);
        if (tablaHistorial.getColumnModel().getColumnCount() > 0) {
            tablaHistorial.getColumnModel().getColumn(0).setResizable(false);
        }

        buttonAñadirHistorial.setBackground(new java.awt.Color(228, 130, 87));
        buttonAñadirHistorial.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        buttonAñadirHistorial.setText("Añadir Diagnistico");
        buttonAñadirHistorial.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonAñadirHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonAñadirHistorial).addComponent(PANEL_TABLA,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(buttonAñadirHistorial).addGap(22, 22, 22)));
    }// </editor-fold>//GEN-END:initComponents

    // Abrir editor de detallses
    private void abrirEditor() {
        FrameDatosHistorial.setVisible(true);
    }

    private void tablaHistorialMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablaHistorialMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());
        String s = source.getModel().getValueAt(row, column) + "";
        JOptionPane.showMessageDialog(null, s);
    }// GEN-LAST:event_tablaHistorialMouseClicked

    private void buttonAñadirHistorialActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAñadirHistorialActionPerformed
        abrirEditor();
    }// GEN-LAST:event_buttonAñadirHistorialActionPerformed

    private void bottonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bottonGuardarCambiosActionPerformed

    }// GEN-LAST:event_bottonGuardarCambiosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameDatosHistorial;
    private javax.swing.JLabel LABEL_DIAGNOSTICO;
    private javax.swing.JLabel LABEL_DIAGNOSTICO1;
    private javax.swing.JLabel LABEL_DOCUMENTO;
    private javax.swing.JLabel LABEL_DUEÑO;
    private javax.swing.JLabel LABEL_MASCOTA;
    private javax.swing.JLabel LABEL_TITULO;
    private javax.swing.JPanel PANEL_DIAGNOSTICO;
    private javax.swing.JPanel PANEL_DOCUMENTO;
    private javax.swing.JPanel PANEL_DUEÑO;
    private javax.swing.JPanel PANEL_MAIN;
    private javax.swing.JPanel PANEL_NOMBRE_PERRO;
    private javax.swing.JPanel PANEL_PRESCRIPCIÓN;
    private javax.swing.JScrollPane PANEL_PRESECIPCIÓN_TEXTO;
    private javax.swing.JScrollPane PANEL_TABLA;
    private javax.swing.JTextArea TEXTAREA_PRESCRIPCIÓN;
    private javax.swing.JButton bottonGuardarCambios;
    private javax.swing.JToggleButton buttonAñadirHistorial;
    private javax.swing.JTextField inputCedula;
    private javax.swing.JTextField inputDiagnostico;
    private javax.swing.JTextField inputMascota;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables

}
