/*
 * En el modulo de citas aparecen todas las citas asociadas a a una persona
 * En el caso de los administradores seran todas las citas
 */

package GUI;

import java.util.Date;
import javax.swing.JTable;

import Veterinaria.Cita;
import Veterinaria.Persona;
import perros.pet.PerrosPET;

import javax.swing.table.DefaultTableModel;

public class ModuloCitas extends javax.swing.JPanel {
        public Persona persona;

        public ModuloCitas(Persona persona) {
                initComponents();
                this.persona = persona;
                this.setDataTable();
        }

        public void setDataTable() {
                String servicios, fecha, mascota;
                DefaultTableModel model = (DefaultTableModel) tablaCitas.getModel();
                for (Cita cita : persona.misCitas) {
                        servicios = PerrosPET.join(",", cita.servicios);
                        fecha = (cita.fecha).toString();
                        mascota = (cita.perro).nombre;
                        Object[] row = { servicios, fecha, mascota };
                        model.addRow(row);
                }
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                FrameDatosCita = new javax.swing.JFrame();
                PANEL_MASCOTA = new javax.swing.JPanel();
                LabelMascota = new javax.swing.JLabel();
                inputMascota = new javax.swing.JComboBox();
                PANEL_FECHA = new javax.swing.JPanel();
                LabelCalendario = new javax.swing.JLabel();
                inputFecha = new com.toedter.calendar.JCalendar();
                PANEL_SERVICIOS = new javax.swing.JPanel();
                inputServicio_Consulta = new javax.swing.JCheckBox();
                inputServicio_Control = new javax.swing.JCheckBox();
                inputServicio_Desparasitación = new javax.swing.JCheckBox();
                inputServicio_vacunación = new javax.swing.JCheckBox();
                inputServicio_Guarderia = new javax.swing.JCheckBox();
                inputServicio_Radiologia = new javax.swing.JCheckBox();
                inputServicio_Baño = new javax.swing.JCheckBox();
                PANEL_BOTTONES = new javax.swing.JPanel();
                inputBorrar = new javax.swing.JButton();
                inputGuardar = new javax.swing.JButton();
                inputServiciosGroup = new javax.swing.ButtonGroup();
                PANEL_TABLA = new javax.swing.JScrollPane();
                tablaCitas = new javax.swing.JTable();
                buttonAñadirCita = new javax.swing.JToggleButton();

                FrameDatosCita.setTitle("Perros-Pet: cita");
                FrameDatosCita.setIconImage(
                                new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
                FrameDatosCita.setMinimumSize(new java.awt.Dimension(500, 470));
                FrameDatosCita.setResizable(false);
                FrameDatosCita.getContentPane().setLayout(new java.awt.GridBagLayout());
                FrameDatosCita.setLocationRelativeTo(null);

                PANEL_MASCOTA.setBackground(new java.awt.Color(242, 237, 215));
                PANEL_MASCOTA.setMinimumSize(new java.awt.Dimension(300, 100));
                PANEL_MASCOTA.setPreferredSize(new java.awt.Dimension(300, 100));

                LabelMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                LabelMascota.setForeground(new java.awt.Color(57, 50, 50));
                LabelMascota.setText("Mascota");

                inputMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputMascota.setModel(new javax.swing.DefaultComboBoxModel(
                                new String[] { "Mascota 1", "Mascota 2", "Mascota 3", "Mascota 4" }));
                inputMascota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
                inputMascota.setFocusable(false);
                inputMascota.setLightWeightPopupEnabled(false);
                inputMascota.setOpaque(false);
                inputMascota.setRequestFocusEnabled(false);
                inputMascota.setVerifyInputWhenFocusTarget(false);

                javax.swing.GroupLayout PANEL_MASCOTALayout = new javax.swing.GroupLayout(PANEL_MASCOTA);
                PANEL_MASCOTA.setLayout(PANEL_MASCOTALayout);
                PANEL_MASCOTALayout.setHorizontalGroup(PANEL_MASCOTALayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PANEL_MASCOTALayout.createSequentialGroup().addGap(39, 39, 39)
                                                .addGroup(PANEL_MASCOTALayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(LabelMascota,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                220,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputMascota,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                240,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(21, Short.MAX_VALUE)));
                PANEL_MASCOTALayout.setVerticalGroup(PANEL_MASCOTALayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_MASCOTALayout
                                                .createSequentialGroup().addGap(22, 22, 22)
                                                .addComponent(LabelMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 25,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(inputMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
                gridBagConstraints.gridheight = 2;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
                FrameDatosCita.getContentPane().add(PANEL_MASCOTA, gridBagConstraints);

                PANEL_FECHA.setBackground(new java.awt.Color(242, 237, 215));
                PANEL_FECHA.setMaximumSize(new java.awt.Dimension(300, 300));
                PANEL_FECHA.setMinimumSize(new java.awt.Dimension(300, 300));
                PANEL_FECHA.setPreferredSize(new java.awt.Dimension(300, 300));

                LabelCalendario.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                LabelCalendario.setForeground(new java.awt.Color(57, 50, 50));
                LabelCalendario.setText("Fecha");

                inputFecha.setBackground(new java.awt.Color(255, 255, 255));
                inputFecha.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
                inputFecha.setDoubleBuffered(false);
                inputFecha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
                inputFecha.setOpaque(false);
                inputFecha.setSundayForeground(new java.awt.Color(228, 130, 87));
                inputFecha.setWeekdayForeground(new java.awt.Color(228, 130, 87));

                javax.swing.GroupLayout PANEL_FECHALayout = new javax.swing.GroupLayout(PANEL_FECHA);
                PANEL_FECHA.setLayout(PANEL_FECHALayout);
                PANEL_FECHALayout.setHorizontalGroup(PANEL_FECHALayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PANEL_FECHALayout.createSequentialGroup().addGap(37, 37, 37)
                                                .addGroup(PANEL_FECHALayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(inputFecha,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                240,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                PANEL_FECHALayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(LabelCalendario,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                222,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(9, 9, 9)))
                                                .addContainerGap(23, Short.MAX_VALUE)));
                PANEL_FECHALayout.setVerticalGroup(PANEL_FECHALayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_FECHALayout
                                                .createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
                                                .addComponent(LabelCalendario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                FrameDatosCita.getContentPane().add(PANEL_FECHA, gridBagConstraints);

                PANEL_SERVICIOS.setBackground(new java.awt.Color(242, 237, 215));
                PANEL_SERVICIOS.setMinimumSize(new java.awt.Dimension(200, 400));
                PANEL_SERVICIOS.setName(""); // NOI18N
                PANEL_SERVICIOS.setPreferredSize(new java.awt.Dimension(200, 400));
                PANEL_SERVICIOS.setLayout(new java.awt.GridLayout(7, 0));

                inputServicio_Consulta.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_Consulta);
                inputServicio_Consulta.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_Consulta.setText("<html>\nConsulta veterinario <br>\n$60.000 por 1 hora.\n</html>");
                inputServicio_Consulta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_Consulta.setFocusPainted(false);
                inputServicio_Consulta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_Consulta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                PANEL_SERVICIOS.add(inputServicio_Consulta);

                inputServicio_Control.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_Control);
                inputServicio_Control.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_Control.setText("<html>\nControl <br>\n$10.000 por 1/2 hora.\n</html>");
                inputServicio_Control.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_Control.setFocusPainted(false);
                inputServicio_Control.setFocusable(false);
                inputServicio_Control.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_Control.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                inputServicio_Control.setOpaque(false);
                inputServicio_Control.setRequestFocusEnabled(false);
                inputServicio_Control.setRolloverEnabled(false);
                PANEL_SERVICIOS.add(inputServicio_Control);

                inputServicio_Desparasitación.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_Desparasitación);
                inputServicio_Desparasitación.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_Desparasitación.setText("<html>\nDesparasitación <br>\n$40.000 por 1/2 hora.\n</html>");
                inputServicio_Desparasitación.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_Desparasitación.setFocusPainted(false);
                inputServicio_Desparasitación.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_Desparasitación.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                PANEL_SERVICIOS.add(inputServicio_Desparasitación);

                inputServicio_vacunación.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_vacunación);
                inputServicio_vacunación.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_vacunación.setText("<html>\nVacunación <br>\n$35.000 por 1/2 hora.\n</html>");
                inputServicio_vacunación.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_vacunación.setFocusPainted(false);
                inputServicio_vacunación.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_vacunación.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                PANEL_SERVICIOS.add(inputServicio_vacunación);

                inputServicio_Guarderia.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_Guarderia);
                inputServicio_Guarderia.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_Guarderia.setText("<html>\nGuarderia (solo por día) <br>\n $35.000.\n</html>");
                inputServicio_Guarderia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_Guarderia.setFocusPainted(false);
                inputServicio_Guarderia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_Guarderia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                PANEL_SERVICIOS.add(inputServicio_Guarderia);

                inputServicio_Radiologia.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_Radiologia);
                inputServicio_Radiologia.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_Radiologia.setText("<html>\nRadiologia <br>\n$100.000 por 1 hora.\n</html>");
                inputServicio_Radiologia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_Radiologia.setFocusPainted(false);
                inputServicio_Radiologia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_Radiologia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                PANEL_SERVICIOS.add(inputServicio_Radiologia);

                inputServicio_Baño.setBackground(new java.awt.Color(242, 237, 215));
                inputServiciosGroup.add(inputServicio_Baño);
                inputServicio_Baño.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputServicio_Baño.setText("<html>\nBaño <br>\n$25.000 por 2 horas\n</html>");
                inputServicio_Baño.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                inputServicio_Baño.setFocusPainted(false);
                inputServicio_Baño.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                inputServicio_Baño.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                PANEL_SERVICIOS.add(inputServicio_Baño);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 27;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
                gridBagConstraints.gridheight = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
                FrameDatosCita.getContentPane().add(PANEL_SERVICIOS, gridBagConstraints);

                PANEL_BOTTONES.setBackground(new java.awt.Color(242, 237, 215));
                PANEL_BOTTONES.setMaximumSize(new java.awt.Dimension(500, 100));
                PANEL_BOTTONES.setMinimumSize(new java.awt.Dimension(500, 50));
                PANEL_BOTTONES.setPreferredSize(new java.awt.Dimension(500, 100));

                inputBorrar.setBackground(new java.awt.Color(228, 130, 87));
                inputBorrar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputBorrar.setForeground(new java.awt.Color(242, 237, 215));
                inputBorrar.setText("Borrar");
                inputBorrar.setBorder(null);
                inputBorrar.setBorderPainted(false);
                inputBorrar.setFocusPainted(false);
                inputBorrar.setFocusable(false);

                inputGuardar.setBackground(new java.awt.Color(58, 99, 81));
                inputGuardar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                inputGuardar.setForeground(new java.awt.Color(242, 237, 215));
                inputGuardar.setText("Guardar");
                inputGuardar.setBorder(null);
                inputGuardar.setBorderPainted(false);
                inputGuardar.setFocusPainted(false);
                inputGuardar.setFocusable(false);

                javax.swing.GroupLayout PANEL_BOTTONESLayout = new javax.swing.GroupLayout(PANEL_BOTTONES);
                PANEL_BOTTONES.setLayout(PANEL_BOTTONESLayout);
                PANEL_BOTTONESLayout.setHorizontalGroup(PANEL_BOTTONESLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_BOTTONESLayout
                                                .createSequentialGroup().addContainerGap(128, Short.MAX_VALUE)
                                                .addComponent(inputBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(122, 122, 122)));
                PANEL_BOTTONESLayout.setVerticalGroup(PANEL_BOTTONESLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PANEL_BOTTONESLayout.createSequentialGroup().addGap(0, 36, Short.MAX_VALUE)
                                                .addGroup(PANEL_BOTTONESLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(inputBorrar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(inputGuardar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.gridwidth = 28;
                gridBagConstraints.gridheight = 4;
                FrameDatosCita.getContentPane().add(PANEL_BOTTONES, gridBagConstraints);

                setBackground(new java.awt.Color(242, 237, 215));
                setMaximumSize(new java.awt.Dimension(704, 552));
                setMinimumSize(new java.awt.Dimension(704, 552));
                setName("Modulo de Citas"); // NOI18N
                setPreferredSize(new java.awt.Dimension(704, 552));

                PANEL_TABLA.getViewport().setBackground(new java.awt.Color(255, 255, 255));
                PANEL_TABLA.setBorder(null);
                PANEL_TABLA.setFocusable(false);

                tablaCitas.getTableHeader().setBackground(new java.awt.Color(58, 99, 81));
                tablaCitas.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
                tablaCitas.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                tablaCitas.setForeground(new java.awt.Color(57, 50, 50));
                tablaCitas.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

                }, new String[] { "Servicios", "Fecha", "Mascota" }) {
                        boolean[] canEdit = new boolean[] { false, false, false };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });
                tablaCitas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                tablaCitas.setGridColor(new java.awt.Color(242, 237, 215));
                tablaCitas.setIntercellSpacing(new java.awt.Dimension(0, 0));
                tablaCitas.setRowHeight(25);
                tablaCitas.setSelectionBackground(new java.awt.Color(228, 129, 86));
                tablaCitas.setShowVerticalLines(false);
                tablaCitas.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tablaCitasMouseClicked(evt);
                        }
                });
                PANEL_TABLA.setViewportView(tablaCitas);

                buttonAñadirCita.setBackground(new java.awt.Color(228, 130, 87));
                buttonAñadirCita.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
                buttonAñadirCita.setText("Añadir Cita");
                buttonAñadirCita.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                buttonAñadirCita.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonAñadirCitaActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(60, 60, 60).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(buttonAñadirCita).addComponent(PANEL_TABLA,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 572,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(72, Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap(46, Short.MAX_VALUE)
                                                .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(buttonAñadirCita).addGap(22, 22, 22)));
        }// </editor-fold>//GEN-END:initComponents

        // Abrir el panel
        private void abrirEditor() {
                FrameDatosCita.setVisible(true);
        }

        private void abrirEditor(boolean[] servicios, Date fecha, String mascota) {
                inputMascota.setSelectedItem(mascota);
                inputFecha.setDate(fecha);
                inputServicio_Baño.setSelected(servicios[0]);
                inputServicio_Consulta.setSelected(servicios[1]);
                inputServicio_Control.setSelected(servicios[2]);
                inputServicio_Desparasitación.setSelected(servicios[3]);
                inputServicio_Guarderia.setSelected(servicios[4]);
                inputServicio_Radiologia.setSelected(servicios[5]);
                inputServicio_vacunación.setSelected(servicios[6]);
                FrameDatosCita.setVisible(true);
        }

        private void buttonAñadirCitaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAñadirCitaActionPerformed
                abrirEditor();
        }// GEN-LAST:event_buttonAñadirCitaActionPerformed

        // Obtener datos de la tabla seleccionada
        private void tablaCitasMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablaCitasMouseClicked
                JTable source = (JTable) evt.getSource();
                int row = source.rowAtPoint(evt.getPoint());
                // int column = source.columnAtPoint(evt.getPoint());
                // String s = source.getModel().getValueAt(row, column) + "";
                // JOptionPane.showMessageDialog(null, s);
        }// GEN-LAST:event_tablaCitasMouseClicked

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JFrame FrameDatosCita;
        private javax.swing.JLabel LabelCalendario;
        private javax.swing.JLabel LabelMascota;
        private javax.swing.JPanel PANEL_BOTTONES;
        private javax.swing.JPanel PANEL_FECHA;
        private javax.swing.JPanel PANEL_MASCOTA;
        private javax.swing.JPanel PANEL_SERVICIOS;
        private javax.swing.JScrollPane PANEL_TABLA;
        private javax.swing.JToggleButton buttonAñadirCita;
        private javax.swing.JButton inputBorrar;
        private com.toedter.calendar.JCalendar inputFecha;
        private javax.swing.JButton inputGuardar;
        private javax.swing.JComboBox inputMascota;
        private javax.swing.JCheckBox inputServicio_Baño;
        private javax.swing.JCheckBox inputServicio_Consulta;
        private javax.swing.JCheckBox inputServicio_Control;
        private javax.swing.JCheckBox inputServicio_Desparasitación;
        private javax.swing.JCheckBox inputServicio_Guarderia;
        private javax.swing.JCheckBox inputServicio_Radiologia;
        private javax.swing.JCheckBox inputServicio_vacunación;
        private javax.swing.ButtonGroup inputServiciosGroup;
        private javax.swing.JTable tablaCitas;
        // End of variables declaration//GEN-END:variables
}
