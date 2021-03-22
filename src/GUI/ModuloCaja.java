package GUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import perros.pet.PerrosPET;

public class ModuloCaja extends javax.swing.JPanel {

    public SpinnerNumberModel modeloSpinners;
    public Veterinaria.Usuario usuario = null;
    public Veterinaria.Perro perro = null;
    public Veterinaria.Cita cita = null;
    public DateFormat dateFormat;
    public double total = 0;

    public ModuloCaja() {
        this.dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        initComponents();
        setUsuarios();
        setPerros(usuario);
        setCitas(usuario, perro);
        setServicios(cita);
    }

    /**
     * Se buscan las personas. Cuando se añade una cita hay que espicificar
     * quien es el usuario. Si el que añade una cita es un usuario normal, sera
     * si mismo. Si es un administrador, hay varios usarios.
     */
    private void setUsuarios() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) inputUsuario.getModel();
        model.removeAllElements();
        
        for (Veterinaria.Usuario unUsuario : PerrosPET.usuarios) {
            
            if (this.usuario == null) {
                // Si esta iniciando el programa, que envie al primer usuario
                this.usuario = unUsuario;
            }
            
            model.addElement(unUsuario.nombreUsuario);
        
        }
        inputUsuario.setModel(model);
        setPerros(usuario);
    }

    /**
     * Seleccionado un usuario, se envian los perros asociados a esta persona
     *
     * @param usaurio el usuario seleccionado o por default
     */
    private void setPerros(Veterinaria.Usuario usuario) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) inputMascota.getModel();
        model.removeAllElements();

        for (Veterinaria.Perro unPerro : usuario.misPerros) {
            if (unPerro.existe) {
                if (perro == null)
                    this.perro = unPerro;
                model.addElement(unPerro.nombre);
            }
        }
        inputMascota.setModel(model);
    }

    /**
     * Seleccionado un usuario, se envian los perros asociados a esta persona
     *
     * @param usaurio el usuario seleccionado o por default
     */
    private void setCitas(Veterinaria.Usuario usuario, Veterinaria.Perro perro) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) inputFecha.getModel();
        model.removeAllElements();

        for (Veterinaria.Cita unaCita : usuario.misCitas) {
            if (unaCita.existe) {
                if (unaCita.perro.equals(perro) && unaCita.factura == null) {
                    if (cita == null)
                        this.cita = unaCita;
                    model.addElement(dateFormat.format(unaCita.fecha));
                }
            }
        }
        
        inputFecha.setModel(model);
    }

    /** 
     * Dada una cita, envia los serivicios asociados a estas
     */
    private void setServicios(Veterinaria.Cita unaCita) {
        if (unaCita != null) {
            inputNumeroHoras.setEnabled(unaCita.servicios[0]);
            inputNumeroHoras1.setEnabled(unaCita.servicios[1]);
            inputNumeroHoras2.setEnabled(unaCita.servicios[2]);
            inputNumeroHoras3.setEnabled(unaCita.servicios[3]);
            inputNumeroHoras4.setEnabled(unaCita.servicios[4]);
            inputNumeroHoras5.setEnabled(unaCita.servicios[5]);
            inputNumeroHoras6.setEnabled(unaCita.servicios[6]);
            inputGuardar.setEnabled(true);
        } else {
            limpiarTotalPagar();
            inputNumeroHoras.setEnabled(false);
            inputNumeroHoras1.setEnabled(false);
            inputNumeroHoras2.setEnabled(false);
            inputNumeroHoras3.setEnabled(false);
            inputNumeroHoras4.setEnabled(false);
            inputNumeroHoras5.setEnabled(false);
            inputNumeroHoras6.setEnabled(false);
            inputGuardar.setEnabled(false);
        }
    }

    /**
     * Se sencuentra un usuario por su nombre
     *
     * @param nombre
     * @return Usuario
     */
    private Veterinaria.Usuario encontrarUsuario(String nombre) {
        for (Veterinaria.Usuario unUsuario : PerrosPET.usuarios) {
            if ((unUsuario.nombreUsuario).equals(nombre)) {
                return unUsuario;
            }
        }
        return null;
    }

    /**
     * Se enuentra un perro (que pertence a un usuario) por su nombre
     *
     * @param usuario
     * @param nombrePerro
     * @return Perro
     */
    private Veterinaria.Perro encontrarPerro(Veterinaria.Usuario usuario, String nombrePerro) {
        for (Veterinaria.Perro unPerro : usuario.misPerros) {
            if (unPerro.existe) {
                if ((unPerro.nombre).equals(nombrePerro)) {
                    return unPerro;
                }
            }
        }
        return null;
    }

    /**
     * Busca una cita por la fecha
     *
     * @param nombre de usuario de la cita y el perro
     * @param nombre del perro
     */
    private Veterinaria.Cita encontrarCitaPorFecha(String fechaCita) {
        
        if (usuario != null) {
            for (Veterinaria.Cita unaCita : usuario.misCitas) {
                if (unaCita.existe) {
                    if ((dateFormat.format(unaCita.fecha)).equals(fechaCita)) {
                        return unaCita;
                    }
                }
            }
        }
        return null;
    }

    private void calcularTotal() {
        total = 0;
        
        if (inputNumeroHoras.isEnabled())
            total += (double) inputNumeroHoras.getValue() * 60000;
        
        if (inputNumeroHoras1.isEnabled())
            total += (double) inputNumeroHoras1.getValue() * 20000;
        
        if (inputNumeroHoras2.isEnabled())
            total += (double) inputNumeroHoras2.getValue() * 80000;
        
        if (inputNumeroHoras3.isEnabled())
            total += (double) inputNumeroHoras3.getValue() * 70000;
        
        if (inputNumeroHoras4.isEnabled())
            total += (double) inputNumeroHoras4.getValue() * 35000;
        
        if (inputNumeroHoras5.isEnabled())
            total += (double) inputNumeroHoras5.getValue() * 100000;
        
        if (inputNumeroHoras6.isEnabled())
            total += (double) inputNumeroHoras6.getValue() * 12500;
        
        OUTPUT_TOTAL.setText(total + "");
    }
    
    private void limpiarTotalPagar() {
        total = 0;
        inputNumeroHoras.setValue(0.00);
        inputNumeroHoras1.setValue(0.00);
        inputNumeroHoras2.setValue(0.00);
        inputNumeroHoras3.setValue(0.00);
        inputNumeroHoras4.setValue(0.00);
        inputNumeroHoras5.setValue(0.00);
        inputNumeroHoras6.setValue(0.00);
        OUTPUT_TOTAL.setText(total + "");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        MAIN_PANEL = new javax.swing.JPanel();
        LABEL_TITULO = new javax.swing.JLabel();
        PANEL_USUARIO = new javax.swing.JPanel();
        LabelUsuario = new javax.swing.JLabel();
        inputUsuario = new javax.swing.JComboBox();
        PANEL_MASCOTA = new javax.swing.JPanel();
        LabelMascota = new javax.swing.JLabel();
        inputMascota = new javax.swing.JComboBox();
        PANEL_FECHA = new javax.swing.JPanel();
        LabelFecha = new javax.swing.JLabel();
        inputFecha = new javax.swing.JComboBox();
        PANEL_SERVICIOS = new javax.swing.JPanel();
        PANEL_SERVICIO1 = new javax.swing.JPanel();
        LABEL_SERVICIO = new javax.swing.JLabel();
        PANEL_PRECIO = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner1 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras = new javax.swing.JSpinner(modeloSpinner1);
        OUTPUT_SERVICIO1 = new javax.swing.JLabel();
        PANEL_SERVICIO2 = new javax.swing.JPanel();
        LABEL_SERVICIO1 = new javax.swing.JLabel();
        PANEL_PRECIO1 = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner2 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras1 = new javax.swing.JSpinner(modeloSpinner2);
        OUTPUT_SERVICIO2 = new javax.swing.JLabel();
        PANEL_SERVICIO3 = new javax.swing.JPanel();
        LABEL_SERVICIO2 = new javax.swing.JLabel();
        PANEL_PRECIO2 = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner3 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras2 = new javax.swing.JSpinner(modeloSpinner3);
        OUTPUT_SERVICIO3 = new javax.swing.JLabel();
        PANEL_SERVICIO4 = new javax.swing.JPanel();
        LABEL_SERVICIO3 = new javax.swing.JLabel();
        PANEL_PRECIO3 = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner4 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras3 = new javax.swing.JSpinner(modeloSpinner4);
        OUTPUT_SERVICIO4 = new javax.swing.JLabel();
        PANEL_SERVICIO5 = new javax.swing.JPanel();
        LABEL_SERVICIO4 = new javax.swing.JLabel();
        PANEL_PRECIO4 = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner5 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras4 = new javax.swing.JSpinner(modeloSpinner5);
        OUTPUT_SERVICIO5 = new javax.swing.JLabel();
        PANEL_SERVICIO6 = new javax.swing.JPanel();
        LABEL_SERVICIO5 = new javax.swing.JLabel();
        PANEL_PRECIO5 = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner6 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras5 = new javax.swing.JSpinner(modeloSpinner6);
        OUTPUT_SERVICIO6 = new javax.swing.JLabel();
        PANEL_SERVICIO7 = new javax.swing.JPanel();
        LABEL_SERVICIO6 = new javax.swing.JLabel();
        PANEL_PRECIO6 = new javax.swing.JPanel();
        SpinnerNumberModel modeloSpinner7 = new SpinnerNumberModel(0.00,0.00,24.00,0.50);
        inputNumeroHoras6 = new javax.swing.JSpinner(modeloSpinner7);
        OUTPUT_SERVICIO7 = new javax.swing.JLabel();
        PANEL_TOTAL = new javax.swing.JPanel();
        LABEL_TOTAL = new javax.swing.JLabel();
        PANEL_PRECIO7 = new javax.swing.JPanel();
        OUTPUT_TOTAL = new javax.swing.JLabel();
        PANEL_BOTTONES = new javax.swing.JPanel();
        inputGuardar = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 237, 215));
        setMaximumSize(new java.awt.Dimension(704, 552));
        setMinimumSize(new java.awt.Dimension(704, 552));
        setName("Caja"); // NOI18N
        setPreferredSize(new java.awt.Dimension(704, 552));

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

        PANEL_USUARIO.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_USUARIO.setMinimumSize(new java.awt.Dimension(400, 100));

        LabelUsuario.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(57, 50, 50));
        LabelUsuario.setText("Usuario");

        inputUsuario.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        inputUsuario.setFocusable(false);
        inputUsuario.setLightWeightPopupEnabled(false);
        inputUsuario.setOpaque(false);
        inputUsuario.setRequestFocusEnabled(false);
        inputUsuario.setVerifyInputWhenFocusTarget(false);
        inputUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_USUARIOLayout = new javax.swing.GroupLayout(PANEL_USUARIO);
        PANEL_USUARIO.setLayout(PANEL_USUARIOLayout);
        PANEL_USUARIOLayout.setHorizontalGroup(
            PANEL_USUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_USUARIOLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        PANEL_USUARIOLayout.setVerticalGroup(
            PANEL_USUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_USUARIOLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(PANEL_USUARIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        MAIN_PANEL.add(PANEL_USUARIO, gridBagConstraints);

        PANEL_MASCOTA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MASCOTA.setMinimumSize(new java.awt.Dimension(400, 100));
        PANEL_MASCOTA.setPreferredSize(new java.awt.Dimension(400, 100));

        LabelMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LabelMascota.setForeground(new java.awt.Color(57, 50, 50));
        LabelMascota.setText("Mascota");

        inputMascota.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputMascota.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        inputMascota.setFocusable(false);
        inputMascota.setLightWeightPopupEnabled(false);
        inputMascota.setOpaque(false);
        inputMascota.setRequestFocusEnabled(false);
        inputMascota.setVerifyInputWhenFocusTarget(false);
        inputMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMascotaActionPerformed(evt);
            }
        });

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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        MAIN_PANEL.add(PANEL_MASCOTA, gridBagConstraints);

        PANEL_FECHA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_FECHA.setMinimumSize(new java.awt.Dimension(400, 100));

        LabelFecha.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LabelFecha.setForeground(new java.awt.Color(57, 50, 50));
        LabelFecha.setText("Fecha Cita");

        inputFecha.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputFecha.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        inputFecha.setFocusable(false);
        inputFecha.setLightWeightPopupEnabled(false);
        inputFecha.setOpaque(false);
        inputFecha.setRequestFocusEnabled(false);
        inputFecha.setVerifyInputWhenFocusTarget(false);
        inputFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_FECHALayout = new javax.swing.GroupLayout(PANEL_FECHA);
        PANEL_FECHA.setLayout(PANEL_FECHALayout);
        PANEL_FECHALayout.setHorizontalGroup(
            PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_FECHALayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(LabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        PANEL_FECHALayout.setVerticalGroup(
            PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_FECHALayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
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
        PANEL_PRECIO.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras));
        inputNumeroHoras.setEnabled(false);
        inputNumeroHoras.setOpaque(false);
        inputNumeroHoras.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHorasStateChanged(evt);
            }
        });
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
        PANEL_PRECIO1.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras1.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras1));
        inputNumeroHoras1.setEnabled(false);
        inputNumeroHoras1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHoras1StateChanged(evt);
            }
        });
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
        PANEL_PRECIO2.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras2.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras2));
        inputNumeroHoras2.setEnabled(false);
        inputNumeroHoras2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHoras2StateChanged(evt);
            }
        });
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
        PANEL_PRECIO3.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras3.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras3));
        inputNumeroHoras3.setEnabled(false);
        inputNumeroHoras3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHoras3StateChanged(evt);
            }
        });
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
        PANEL_PRECIO4.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras4.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras4.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras4));
        inputNumeroHoras4.setEnabled(false);
        inputNumeroHoras4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHoras4StateChanged(evt);
            }
        });
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
        PANEL_PRECIO5.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras5.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras5.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras5));
        inputNumeroHoras5.setEnabled(false);
        inputNumeroHoras5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHoras5StateChanged(evt);
            }
        });
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
        PANEL_PRECIO6.setLayout(new java.awt.GridLayout(1, 0));

        inputNumeroHoras6.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputNumeroHoras6.setEditor(new javax.swing.JSpinner.NumberEditor(inputNumeroHoras6));
        inputNumeroHoras6.setEnabled(false);
        inputNumeroHoras6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputNumeroHoras6StateChanged(evt);
            }
        });
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
        PANEL_PRECIO7.setLayout(new java.awt.GridLayout(1, 0));

        OUTPUT_TOTAL.setBackground(new java.awt.Color(242, 237, 215));
        OUTPUT_TOTAL.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        OUTPUT_TOTAL.setForeground(new java.awt.Color(57, 50, 50));
        OUTPUT_TOTAL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        OUTPUT_TOTAL.setText("$ 0");
        OUTPUT_TOTAL.setToolTipText("");
        OUTPUT_TOTAL.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
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

        inputGuardar.setBackground(new java.awt.Color(58, 99, 81));
        inputGuardar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputGuardar.setForeground(new java.awt.Color(242, 237, 215));
        inputGuardar.setText("Guardar");
        inputGuardar.setBorder(null);
        inputGuardar.setBorderPainted(false);
        inputGuardar.setEnabled(false);
        inputGuardar.setFocusPainted(false);
        inputGuardar.setFocusable(false);
        inputGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_BOTTONESLayout = new javax.swing.GroupLayout(PANEL_BOTTONES);
        PANEL_BOTTONES.setLayout(PANEL_BOTTONESLayout);
        PANEL_BOTTONESLayout.setHorizontalGroup(
            PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_BOTTONESLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        PANEL_BOTTONESLayout.setVerticalGroup(
            PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_BOTTONESLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        MAIN_PANEL.add(PANEL_BOTTONES, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MAIN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(MAIN_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inputUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsuarioActionPerformed
        this.usuario = encontrarUsuario((String) inputUsuario.getSelectedItem());
        perro = null;
        cita = null;
        setPerros(this.usuario);
        setCitas(usuario, perro);
        setServicios(cita);
        
    }//GEN-LAST:event_inputUsuarioActionPerformed

    private void inputMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMascotaActionPerformed
        perro = encontrarPerro(usuario, (String) inputMascota.getSelectedItem());
        cita = null;
        setCitas(this.usuario, this.perro);
        setServicios(cita);
    }//GEN-LAST:event_inputMascotaActionPerformed

    private void inputFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFechaActionPerformed
        String fechaCita = (String) inputFecha.getSelectedItem();

        this.cita = encontrarCitaPorFecha(fechaCita);
        setServicios(cita);
    }//GEN-LAST:event_inputFechaActionPerformed

    private void inputNumeroHorasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHorasStateChanged
        double s = (double) inputNumeroHoras.getValue() * 60000;
        OUTPUT_SERVICIO1.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHorasStateChanged

    private void inputNumeroHoras1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHoras1StateChanged
        double s = (double) inputNumeroHoras1.getValue() * 20000;
        OUTPUT_SERVICIO2.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHoras1StateChanged

    private void inputNumeroHoras2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHoras2StateChanged
        double s = (double) inputNumeroHoras2.getValue() * 80000;
        OUTPUT_SERVICIO3.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHoras2StateChanged

    private void inputNumeroHoras3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHoras3StateChanged
        double s = (double) inputNumeroHoras3.getValue() * 70000;
        OUTPUT_SERVICIO4.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHoras3StateChanged

    private void inputNumeroHoras4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHoras4StateChanged
        double s = (double) inputNumeroHoras4.getValue() * 35000;
        OUTPUT_SERVICIO5.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHoras4StateChanged

    private void inputNumeroHoras5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHoras5StateChanged
        double s = (double) inputNumeroHoras5.getValue() * 100000;
        OUTPUT_SERVICIO6.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHoras5StateChanged

    private void inputNumeroHoras6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputNumeroHoras6StateChanged
        double s = (double) inputNumeroHoras6.getValue() * 12500;
        OUTPUT_SERVICIO7.setText(s + "");
        calcularTotal();
    }//GEN-LAST:event_inputNumeroHoras6StateChanged

    private void inputGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputGuardarActionPerformed
        if (this.cita != null) {
            Veterinaria.Factura factura = new Veterinaria.Factura(this.cita, total);
            setCitas(usuario, perro);
            setServicios(cita);
        }
    }//GEN-LAST:event_inputGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL_SERVICIO;
    private javax.swing.JLabel LABEL_SERVICIO1;
    private javax.swing.JLabel LABEL_SERVICIO2;
    private javax.swing.JLabel LABEL_SERVICIO3;
    private javax.swing.JLabel LABEL_SERVICIO4;
    private javax.swing.JLabel LABEL_SERVICIO5;
    private javax.swing.JLabel LABEL_SERVICIO6;
    private javax.swing.JLabel LABEL_TITULO;
    private javax.swing.JLabel LABEL_TOTAL;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelMascota;
    private javax.swing.JLabel LabelUsuario;
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
    private javax.swing.JPanel PANEL_TOTAL;
    private javax.swing.JPanel PANEL_USUARIO;
    private javax.swing.JComboBox inputFecha;
    private javax.swing.JButton inputGuardar;
    private javax.swing.JComboBox inputMascota;
    private javax.swing.JSpinner inputNumeroHoras;
    private javax.swing.JSpinner inputNumeroHoras1;
    private javax.swing.JSpinner inputNumeroHoras2;
    private javax.swing.JSpinner inputNumeroHoras3;
    private javax.swing.JSpinner inputNumeroHoras4;
    private javax.swing.JSpinner inputNumeroHoras5;
    private javax.swing.JSpinner inputNumeroHoras6;
    private javax.swing.JComboBox inputUsuario;
    // End of variables declaration//GEN-END:variables
}
