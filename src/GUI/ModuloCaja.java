package GUI;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ModuloCaja extends javax.swing.JPanel {
    
    public ModuloCaja() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FrameDatosCaja = new javax.swing.JFrame();
        MAIN_PANEL = new javax.swing.JPanel();
        LABEL_TITULO = new javax.swing.JLabel();
        PANEL_MASCOTA = new javax.swing.JPanel();
        LabelMascota = new javax.swing.JLabel();
        inputMascota = new javax.swing.JComboBox();
        PANEL_FECHA = new javax.swing.JPanel();
        LabelCalendario = new javax.swing.JLabel();
        inputFecha = new com.toedter.calendar.JCalendar();
        PANEL_SERVICIOS = new javax.swing.JPanel();
        PANEL_SERVICIO1 = new javax.swing.JPanel();
        LABEL_SERVICIO = new javax.swing.JLabel();
        PANEL_PRECIO = new javax.swing.JPanel();
        inputNumeroHoras = new javax.swing.JSpinner();
        OUTPUT_SERVICIO1 = new javax.swing.JLabel();
        PANEL_SERVICIO2 = new javax.swing.JPanel();
        LABEL_SERVICIO1 = new javax.swing.JLabel();
        PANEL_PRECIO1 = new javax.swing.JPanel();
        inputNumeroHoras1 = new javax.swing.JSpinner();
        OUTPUT_SERVICIO2 = new javax.swing.JLabel();
        PANEL_SERVICIO3 = new javax.swing.JPanel();
        LABEL_SERVICIO2 = new javax.swing.JLabel();
        PANEL_PRECIO2 = new javax.swing.JPanel();
        inputNumeroHoras2 = new javax.swing.JSpinner();
        OUTPUT_SERVICIO3 = new javax.swing.JLabel();
        PANEL_SERVICIO4 = new javax.swing.JPanel();
        LABEL_SERVICIO3 = new javax.swing.JLabel();
        PANEL_PRECIO3 = new javax.swing.JPanel();
        inputNumeroHoras3 = new javax.swing.JSpinner();
        OUTPUT_SERVICIO4 = new javax.swing.JLabel();
        PANEL_SERVICIO5 = new javax.swing.JPanel();
        LABEL_SERVICIO4 = new javax.swing.JLabel();
        PANEL_PRECIO4 = new javax.swing.JPanel();
        inputNumeroHoras4 = new javax.swing.JSpinner();
        OUTPUT_SERVICIO5 = new javax.swing.JLabel();
        PANEL_SERVICIO6 = new javax.swing.JPanel();
        LABEL_SERVICIO5 = new javax.swing.JLabel();
        PANEL_PRECIO5 = new javax.swing.JPanel();
        inputNumeroHoras5 = new javax.swing.JSpinner();
        OUTPUT_SERVICIO6 = new javax.swing.JLabel();
        PANEL_SERVICIO7 = new javax.swing.JPanel();
        LABEL_SERVICIO6 = new javax.swing.JLabel();
        PANEL_PRECIO6 = new javax.swing.JPanel();
        inputNumeroHoras6 = new javax.swing.JSpinner();
        OUTPUT_SERVICIO7 = new javax.swing.JLabel();
        PANEL_TOTAL = new javax.swing.JPanel();
        LABEL_TOTAL = new javax.swing.JLabel();
        PANEL_PRECIO7 = new javax.swing.JPanel();
        OUTPUT_TOTAL = new javax.swing.JLabel();
        PANEL_BOTTONES = new javax.swing.JPanel();
        inputBorrar = new javax.swing.JButton();
        inputGuardar = new javax.swing.JButton();
        PANEL_TABLA = new javax.swing.JScrollPane();
        tablaCaja = new javax.swing.JTable();
        buttonAñadirRecibo = new javax.swing.JToggleButton();

        FrameDatosCaja.setTitle("Perros-Pet: cita");
        FrameDatosCaja.setTitle("Perros-Pet: Caja");
        FrameDatosCaja.setBackground(new java.awt.Color(242, 237, 215));
        FrameDatosCaja.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
        FrameDatosCaja.setMinimumSize(new java.awt.Dimension(700, 520));
        FrameDatosCaja.setName("Caja"); // NOI18N
        FrameDatosCaja.setPreferredSize(new java.awt.Dimension(700, 520));
        FrameDatosCaja.setResizable(false);
        FrameDatosCaja.getContentPane().setLayout(new java.awt.GridLayout());
        FrameDatosCaja.setLocationRelativeTo(null);

        MAIN_PANEL.setBackground(new java.awt.Color(242, 237, 215));
        MAIN_PANEL.setMinimumSize(new java.awt.Dimension(700, 520));
        MAIN_PANEL.setPreferredSize(new java.awt.Dimension(700, 520));
        MAIN_PANEL.setLayout(new java.awt.GridBagLayout());

        LABEL_TITULO.setBackground(new java.awt.Color(242, 237, 215));
        LABEL_TITULO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_TITULO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_TITULO.setText("Datos Recibo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        MAIN_PANEL.add(LABEL_TITULO, gridBagConstraints);

        PANEL_MASCOTA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MASCOTA.setMinimumSize(new java.awt.Dimension(400, 100));
        PANEL_MASCOTA.setPreferredSize(new java.awt.Dimension(400, 100));

        LabelMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LabelMascota.setForeground(new java.awt.Color(57, 50, 50));
        LabelMascota.setText("Mascota");

        inputMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputMascota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mascota 1", "Mascota 2", "Mascota 3", "Mascota 4" }));
        inputMascota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        inputMascota.setFocusable(false);
        inputMascota.setLightWeightPopupEnabled(false);
        inputMascota.setOpaque(false);
        inputMascota.setRequestFocusEnabled(false);
        inputMascota.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout PANEL_MASCOTALayout = new javax.swing.GroupLayout(PANEL_MASCOTA);
        PANEL_MASCOTA.setLayout(PANEL_MASCOTALayout);
        PANEL_MASCOTALayout.setHorizontalGroup(
            PANEL_MASCOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_MASCOTALayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(LabelMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        PANEL_MASCOTALayout.setVerticalGroup(
            PANEL_MASCOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_MASCOTALayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(PANEL_MASCOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        MAIN_PANEL.add(PANEL_MASCOTA, gridBagConstraints);

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
        PANEL_FECHALayout.setHorizontalGroup(
            PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_FECHALayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_FECHALayout.createSequentialGroup()
                        .addComponent(LabelCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        PANEL_FECHALayout.setVerticalGroup(
            PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_FECHALayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(LabelCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        MAIN_PANEL.add(PANEL_FECHA, gridBagConstraints);

        PANEL_SERVICIOS.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIOS.setMinimumSize(new java.awt.Dimension(300, 400));
        PANEL_SERVICIOS.setName(""); // NOI18N
        PANEL_SERVICIOS.setPreferredSize(new java.awt.Dimension(350, 400));
        PANEL_SERVICIOS.setLayout(new java.awt.GridLayout(8, 0));

        PANEL_SERVICIO1.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO1.setName("Caja"); // NOI18N
        PANEL_SERVICIO1.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO.setText("<html> Consulta veterinario <br> $60.000 por 1 hora. </html>");
        PANEL_SERVICIO1.add(LABEL_SERVICIO);

        PANEL_PRECIO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO.setLayout(new java.awt.GridLayout());

        inputNumeroHoras.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO.add(inputNumeroHoras);

        OUTPUT_SERVICIO1.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO1.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO1.setText("$ 0");
        OUTPUT_SERVICIO1.setToolTipText("");
        PANEL_PRECIO.add(OUTPUT_SERVICIO1);

        PANEL_SERVICIO1.add(PANEL_PRECIO);

        PANEL_SERVICIOS.add(PANEL_SERVICIO1);

        PANEL_SERVICIO2.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO2.setName("Caja"); // NOI18N
        PANEL_SERVICIO2.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO1.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO1.setText("<html> Control <br> $10.000 por 1/2 hora. </html>");
        PANEL_SERVICIO2.add(LABEL_SERVICIO1);

        PANEL_PRECIO1.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO1.setLayout(new java.awt.GridLayout());

        inputNumeroHoras1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO1.add(inputNumeroHoras1);

        OUTPUT_SERVICIO2.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO2.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO2.setText("$ 0");
        PANEL_PRECIO1.add(OUTPUT_SERVICIO2);

        PANEL_SERVICIO2.add(PANEL_PRECIO1);

        PANEL_SERVICIOS.add(PANEL_SERVICIO2);

        PANEL_SERVICIO3.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO3.setName("Caja"); // NOI18N
        PANEL_SERVICIO3.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO2.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO2.setText("<html> Desparasitación <br> $40.000 por 1/2 hora. </html>");
        PANEL_SERVICIO3.add(LABEL_SERVICIO2);

        PANEL_PRECIO2.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO2.setLayout(new java.awt.GridLayout());

        inputNumeroHoras2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO2.add(inputNumeroHoras2);

        OUTPUT_SERVICIO3.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO3.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO3.setText("$ 0");
        PANEL_PRECIO2.add(OUTPUT_SERVICIO3);

        PANEL_SERVICIO3.add(PANEL_PRECIO2);

        PANEL_SERVICIOS.add(PANEL_SERVICIO3);

        PANEL_SERVICIO4.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO4.setName("Caja"); // NOI18N
        PANEL_SERVICIO4.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO3.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO3.setText("<html> Vacunación <br> $35.000 por 1/2 hora. </html>");
        PANEL_SERVICIO4.add(LABEL_SERVICIO3);

        PANEL_PRECIO3.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO3.setLayout(new java.awt.GridLayout());

        inputNumeroHoras3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO3.add(inputNumeroHoras3);

        OUTPUT_SERVICIO4.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO4.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO4.setText("$ 0");
        PANEL_PRECIO3.add(OUTPUT_SERVICIO4);

        PANEL_SERVICIO4.add(PANEL_PRECIO3);

        PANEL_SERVICIOS.add(PANEL_SERVICIO4);

        PANEL_SERVICIO5.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO5.setName("Caja"); // NOI18N
        PANEL_SERVICIO5.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO4.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO4.setText("<html> Guarderia (solo por día) <br>  $35.000. </html>");
        PANEL_SERVICIO5.add(LABEL_SERVICIO4);

        PANEL_PRECIO4.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO4.setLayout(new java.awt.GridLayout());

        inputNumeroHoras4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO4.add(inputNumeroHoras4);

        OUTPUT_SERVICIO5.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO5.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO5.setText("$ 0");
        PANEL_PRECIO4.add(OUTPUT_SERVICIO5);

        PANEL_SERVICIO5.add(PANEL_PRECIO4);

        PANEL_SERVICIOS.add(PANEL_SERVICIO5);

        PANEL_SERVICIO6.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO6.setName("Caja"); // NOI18N
        PANEL_SERVICIO6.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO5.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO5.setText("<html> Radiologia <br> $100.000 por 1 hora. </html>");
        PANEL_SERVICIO6.add(LABEL_SERVICIO5);

        PANEL_PRECIO5.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO5.setLayout(new java.awt.GridLayout());

        inputNumeroHoras5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO5.add(inputNumeroHoras5);

        OUTPUT_SERVICIO6.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO6.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO6.setText("$ 0");
        PANEL_PRECIO5.add(OUTPUT_SERVICIO6);

        PANEL_SERVICIO6.add(PANEL_PRECIO5);

        PANEL_SERVICIOS.add(PANEL_SERVICIO6);

        PANEL_SERVICIO7.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIO7.setName("Caja"); // NOI18N
        PANEL_SERVICIO7.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_SERVICIO6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_SERVICIO6.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_SERVICIO6.setText("<html> Baño <br> $25.000 por 2 horas </html>");
        PANEL_SERVICIO7.add(LABEL_SERVICIO6);

        PANEL_PRECIO6.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO6.setLayout(new java.awt.GridLayout());

        inputNumeroHoras6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        PANEL_PRECIO6.add(inputNumeroHoras6);

        OUTPUT_SERVICIO7.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_SERVICIO7.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_SERVICIO7.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_SERVICIO7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_SERVICIO7.setText("$ 0");
        PANEL_PRECIO6.add(OUTPUT_SERVICIO7);

        PANEL_SERVICIO7.add(PANEL_PRECIO6);

        PANEL_SERVICIOS.add(PANEL_SERVICIO7);

        PANEL_TOTAL.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_TOTAL.setName("Caja"); // NOI18N
        PANEL_TOTAL.setLayout(new java.awt.GridLayout(1, 3));

        LABEL_TOTAL.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LABEL_TOTAL.setForeground(new java.awt.Color(57, 50, 50));
        LABEL_TOTAL.setText("Total");
        PANEL_TOTAL.add(LABEL_TOTAL);

        PANEL_PRECIO7.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PRECIO7.setLayout(new java.awt.GridLayout());

        OUTPUT_TOTAL.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_TOTAL.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_TOTAL.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OUTPUT_TOTAL.setText("$ 0");
        OUTPUT_TOTAL.setToolTipText("");
        PANEL_PRECIO7.add(OUTPUT_TOTAL);

        PANEL_TOTAL.add(PANEL_PRECIO7);

        PANEL_SERVICIOS.add(PANEL_TOTAL);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        MAIN_PANEL.add(PANEL_SERVICIOS, gridBagConstraints);

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
        PANEL_BOTTONESLayout.setHorizontalGroup(
            PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_BOTTONESLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(inputBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        PANEL_BOTTONESLayout.setVerticalGroup(
            PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_BOTTONESLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        MAIN_PANEL.add(PANEL_BOTTONES, gridBagConstraints);

        FrameDatosCaja.getContentPane().add(MAIN_PANEL);

        setBackground(new java.awt.Color(242, 237, 215));
        setMaximumSize(new java.awt.Dimension(704, 552));
        setMinimumSize(new java.awt.Dimension(704, 552));
        setName("Caja"); // NOI18N
        setPreferredSize(new java.awt.Dimension(704, 552));

        PANEL_TABLA.getViewport().setBackground(new java.awt.Color(255, 255, 255));
        PANEL_TABLA.setBorder(null);
        PANEL_TABLA.setFocusable(false);

        tablaCaja.getTableHeader().setBackground(new java.awt.Color(58,99,81));
        tablaCaja.getTableHeader().setForeground(new java.awt.Color(255,255,255));
        tablaCaja.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        tablaCaja.setForeground(new java.awt.Color(57, 50, 50));
        tablaCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Servicios", "Fecha", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaCaja.setGridColor(new java.awt.Color(242, 237, 215));
        tablaCaja.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablaCaja.setRowHeight(25);
        tablaCaja.setSelectionBackground(new java.awt.Color(228, 129, 86));
        tablaCaja.setShowVerticalLines(false);
        tablaCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCajaMouseClicked(evt);
            }
        });
        PANEL_TABLA.setViewportView(tablaCaja);

        buttonAñadirRecibo.setBackground(new java.awt.Color(228, 130, 87));
        buttonAñadirRecibo.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        buttonAñadirRecibo.setText("Añadir Recibo");
        buttonAñadirRecibo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonAñadirRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirReciboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonAñadirRecibo)
                    .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAñadirRecibo)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Abrir el panel
    private void abrirEditor() {
        FrameDatosCaja.setVisible(true);
    }
    private void buttonAñadirReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAñadirReciboActionPerformed
        abrirEditor();
    }//GEN-LAST:event_buttonAñadirReciboActionPerformed

    // Obtener datos de la tabla seleccionada
    private void tablaCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCajaMouseClicked
         JTable source = (JTable)evt.getSource();
            int row = source.rowAtPoint( evt.getPoint() );
            int column = source.columnAtPoint( evt.getPoint() );
            String s=source.getModel().getValueAt(row, column)+"";
            JOptionPane.showMessageDialog(null, s);
    }//GEN-LAST:event_tablaCajaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameDatosCaja;
    private javax.swing.JLabel LABEL_SERVICIO;
    private javax.swing.JLabel LABEL_SERVICIO1;
    private javax.swing.JLabel LABEL_SERVICIO2;
    private javax.swing.JLabel LABEL_SERVICIO3;
    private javax.swing.JLabel LABEL_SERVICIO4;
    private javax.swing.JLabel LABEL_SERVICIO5;
    private javax.swing.JLabel LABEL_SERVICIO6;
    private javax.swing.JLabel LABEL_TITULO;
    private javax.swing.JLabel LABEL_TOTAL;
    private javax.swing.JLabel LabelCalendario;
    private javax.swing.JLabel LabelMascota;
    private javax.swing.JPanel MAIN_PANEL;
    private javax.swing.JLabel OUTPUT_SERVICIO1;
    private javax.swing.JLabel OUTPUT_SERVICIO2;
    private javax.swing.JLabel OUTPUT_SERVICIO3;
    private javax.swing.JLabel OUTPUT_SERVICIO4;
    private javax.swing.JLabel OUTPUT_SERVICIO5;
    private javax.swing.JLabel OUTPUT_SERVICIO6;
    private javax.swing.JLabel OUTPUT_SERVICIO7;
    private javax.swing.JLabel OUTPUT_TOTAL;
    private javax.swing.JPanel PANEL_BOTTONES;
    private javax.swing.JPanel PANEL_FECHA;
    private javax.swing.JPanel PANEL_MASCOTA;
    private javax.swing.JPanel PANEL_PRECIO;
    private javax.swing.JPanel PANEL_PRECIO1;
    private javax.swing.JPanel PANEL_PRECIO2;
    private javax.swing.JPanel PANEL_PRECIO3;
    private javax.swing.JPanel PANEL_PRECIO4;
    private javax.swing.JPanel PANEL_PRECIO5;
    private javax.swing.JPanel PANEL_PRECIO6;
    private javax.swing.JPanel PANEL_PRECIO7;
    private javax.swing.JPanel PANEL_SERVICIO1;
    private javax.swing.JPanel PANEL_SERVICIO2;
    private javax.swing.JPanel PANEL_SERVICIO3;
    private javax.swing.JPanel PANEL_SERVICIO4;
    private javax.swing.JPanel PANEL_SERVICIO5;
    private javax.swing.JPanel PANEL_SERVICIO6;
    private javax.swing.JPanel PANEL_SERVICIO7;
    private javax.swing.JPanel PANEL_SERVICIOS;
    private javax.swing.JScrollPane PANEL_TABLA;
    private javax.swing.JPanel PANEL_TOTAL;
    private javax.swing.JToggleButton buttonAñadirRecibo;
    private javax.swing.JButton inputBorrar;
    private com.toedter.calendar.JCalendar inputFecha;
    private javax.swing.JButton inputGuardar;
    private javax.swing.JComboBox inputMascota;
    private javax.swing.JSpinner inputNumeroHoras;
    private javax.swing.JSpinner inputNumeroHoras1;
    private javax.swing.JSpinner inputNumeroHoras2;
    private javax.swing.JSpinner inputNumeroHoras3;
    private javax.swing.JSpinner inputNumeroHoras4;
    private javax.swing.JSpinner inputNumeroHoras5;
    private javax.swing.JSpinner inputNumeroHoras6;
    private javax.swing.JTable tablaCaja;
    // End of variables declaration//GEN-END:variables
}
