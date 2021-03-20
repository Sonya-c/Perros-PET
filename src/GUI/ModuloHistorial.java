/*
 * Este es el moudulo del historial del veterinario
 * El puede crear un nueva historia clinica de un paciente
 */
package GUI;

import Veterinaria.Cita;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Veterinaria.Historial;
import javax.swing.DefaultComboBoxModel;
import perros.pet.PerrosPET;

public class ModuloHistorial extends javax.swing.JPanel {

    public Veterinaria.Veterinario veterinario;
    public Date fechaConsulta;
    public Veterinaria.Usuario usuario;
    public String cedulaUsuario;
    public String nombrePerro;
    public String fechaCita;
    public String diagnostico;
    public String prescripción;

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

    public void getData() {
        cedulaUsuario = inputCedula.getText();
        nombrePerro = inputMascota.getSelectedItem().toString();
        fechaCita = inputCita.getSelectedItem().toString();
        diagnostico = inputDiagnostico.getText();
        prescripción = TEXTAREA_PRESCRIPCIÓN.getText();
    }

    public Veterinaria.Usuario findUser(String cedula) {
        // Se buscara en todos los usuario uno con esta cedula
        for (Veterinaria.Usuario usuario : PerrosPET.usuarios) {
            if ((usuario.documento).equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }
    
    public boolean validarUsuario() {
        usuario = findUser(inputCedula.getText());
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Este usuario no exite");
            return false;
        } else {
            if ((usuario.misPerros).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este usuario no tiene perros");
                return false;
            } else {
                DefaultComboBoxModel model = (DefaultComboBoxModel) inputMascota.getModel();
                for (Veterinaria.Perro perro : usuario.misPerros) {
                    model.addElement(perro.nombre);
                }
                inputMascota.setModel(model);
            }
            
            if ((usuario.misCitas).isEmpty()){
                JOptionPane.showMessageDialog(null, "Este usuario no tiene citas programadas");
                return false;
            } else {
                DefaultComboBoxModel model = (DefaultComboBoxModel) inputCita.getModel();
                for (Veterinaria.Cita cita : usuario.misCitas) {
                    model.addElement((cita.fecha).toString());
                }
                inputCita.setModel(model);
            }
        }
        validate();
        repaint();
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FrameDatosHistorial = new javax.swing.JFrame();
        PANEL_MAIN = new javax.swing.JPanel();
        LABEL_TITULO = new javax.swing.JLabel();
        PANEL_DOCUMENTO = new javax.swing.JPanel();
        LABEL_DOCUMENTO = new javax.swing.JLabel();
        PANEL_DDOCUMENTO_DOCyBUSCAR = new javax.swing.JPanel();
        inputCedula = new javax.swing.JTextField();
        bottonBuscarUsuario = new javax.swing.JToggleButton();
        PANEL_CITA = new javax.swing.JPanel();
        LABEL_CITA = new javax.swing.JLabel();
        inputCita = new javax.swing.JComboBox();
        PANEL_NOMBRE_PERRO = new javax.swing.JPanel();
        LABEL_MASCOTA = new javax.swing.JLabel();
        inputMascota = new javax.swing.JComboBox();
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

        FrameDatosHistorial.setTitle("Perros-Pet: cita");
        FrameDatosHistorial.setTitle("Perros-PET: Información mascotas");
        FrameDatosHistorial.setBackground(new java.awt.Color(242, 237, 215));
        FrameDatosHistorial.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
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

        PANEL_DDOCUMENTO_DOCyBUSCAR.setBackground(new java.awt.Color(255, 255, 255));
        PANEL_DDOCUMENTO_DOCyBUSCAR.setLayout(new javax.swing.BoxLayout(PANEL_DDOCUMENTO_DOCyBUSCAR, javax.swing.BoxLayout.LINE_AXIS));

        inputCedula.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputCedula.setText("1001822184");
        inputCedula.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        PANEL_DDOCUMENTO_DOCyBUSCAR.add(inputCedula);

        bottonBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        bottonBuscarUsuario.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        bottonBuscarUsuario.setText("Buscar");
        bottonBuscarUsuario.setBorder(null);
        bottonBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonBuscarUsuarioActionPerformed(evt);
            }
        });
        PANEL_DDOCUMENTO_DOCyBUSCAR.add(bottonBuscarUsuario);

        PANEL_DOCUMENTO.add(PANEL_DDOCUMENTO_DOCyBUSCAR);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_DOCUMENTO, gridBagConstraints);

        PANEL_CITA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_CITA.setPreferredSize(new java.awt.Dimension(100, 78));
        PANEL_CITA.setLayout(new java.awt.GridLayout());

        LABEL_CITA.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_CITA.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_CITA.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_CITA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LABEL_CITA.setText("Cita programada");
        LABEL_CITA.setAlignmentX(5.0F);
        LABEL_CITA.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
        LABEL_CITA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LABEL_CITA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PANEL_CITA.add(LABEL_CITA);

        inputCita.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputCita.setBorder(null);
        PANEL_CITA.add(inputCita);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PANEL_MAIN.add(PANEL_CITA, gridBagConstraints);

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
        inputMascota.setBorder(null);
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
        bottonGuardarCambios.setEnabled(false);
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

        tablaHistorial.getTableHeader().setBackground(new java.awt.Color(58,99,81));
        tablaHistorial.getTableHeader().setForeground(new java.awt.Color(255,255,255));
        tablaHistorial.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        tablaHistorial.setForeground(new java.awt.Color(57, 50, 50));
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Mascota", "Fecha", "Diagnostico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaHistorial.setGridColor(new java.awt.Color(242, 237, 215));
        tablaHistorial.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaHistorial.setRowHeight(25);
        tablaHistorial.setSelectionBackground(new java.awt.Color(228, 129, 86));
        tablaHistorial.setShowVerticalLines(false);
        PANEL_TABLA.setViewportView(tablaHistorial);
        if (tablaHistorial.getColumnModel().getColumnCount() > 0) {
            tablaHistorial.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bottonBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonBuscarUsuarioActionPerformed
        // Se buscara a un usuario, si este no exite, se mostrara un panel de advertencia.
        // Si el usuario si exite, se enviara el nombre de los perros
        bottonGuardarCambios.setEnabled(validarUsuario());
    }//GEN-LAST:event_bottonBuscarUsuarioActionPerformed

    // Abrir editor de detallses
    private void abrirEditor() {
        FrameDatosHistorial.setVisible(true);
    }

    private void buttonAñadirHistorialActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAñadirHistorialActionPerformed
        abrirEditor();
    }// GEN-LAST:event_buttonAñadirHistorialActionPerformed

    private void bottonGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bottonGuardarCambiosActionPerformed
       this.getData();
       Veterinaria.Cita thisCita = null;
       for (Veterinaria.Cita cita : usuario.misCitas) {
           if (((cita.fecha).toString()).equals(fechaCita)) {
               thisCita = cita;
           }
       }
       if (thisCita == null) {
           JOptionPane.showMessageDialog(null, "Ocurrio un error");
       } else {
           Veterinaria.Historial historial = new Historial(thisCita, diagnostico, prescripción);
           setDataTable();
           FrameDatosHistorial.setVisible(false);
       }
    }// GEN-LAST:event_bottonGuardarCambiosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameDatosHistorial;
    private javax.swing.JLabel LABEL_CITA;
    private javax.swing.JLabel LABEL_DIAGNOSTICO;
    private javax.swing.JLabel LABEL_DIAGNOSTICO1;
    private javax.swing.JLabel LABEL_DOCUMENTO;
    private javax.swing.JLabel LABEL_MASCOTA;
    private javax.swing.JLabel LABEL_TITULO;
    private javax.swing.JPanel PANEL_CITA;
    private javax.swing.JPanel PANEL_DDOCUMENTO_DOCyBUSCAR;
    private javax.swing.JPanel PANEL_DIAGNOSTICO;
    private javax.swing.JPanel PANEL_DOCUMENTO;
    private javax.swing.JPanel PANEL_MAIN;
    private javax.swing.JPanel PANEL_NOMBRE_PERRO;
    private javax.swing.JPanel PANEL_PRESCRIPCIÓN;
    private javax.swing.JScrollPane PANEL_PRESECIPCIÓN_TEXTO;
    private javax.swing.JScrollPane PANEL_TABLA;
    private javax.swing.JTextArea TEXTAREA_PRESCRIPCIÓN;
    private javax.swing.JToggleButton bottonBuscarUsuario;
    private javax.swing.JButton bottonGuardarCambios;
    private javax.swing.JTextField inputCedula;
    private javax.swing.JComboBox inputCita;
    private javax.swing.JTextField inputDiagnostico;
    private javax.swing.JComboBox inputMascota;
    private javax.swing.JTable tablaHistorial;
    // End of variables declaration//GEN-END:variables

}
