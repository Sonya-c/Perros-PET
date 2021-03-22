package GUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import Veterinaria.Cita;
import Veterinaria.Persona;
import Veterinaria.TipoUsuario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import perros.pet.PerrosPET;
import javax.swing.table.DefaultTableModel;

public class ModuloCitas extends javax.swing.JPanel {

    public Veterinaria.Persona persona;
    public Veterinaria.Cita cita = null;
    public DateFormat dateFormat;

    /**
     * En el modulo de citas aparecen todas las citas asociadas a a una persona En
     * el caso de los administradores seran todas las Citas
     * 
     * @param persona
     */
    public ModuloCitas(Persona persona) {
        initComponents();
        this.persona = persona;
        this.dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        // El veterinario no añade citas
        if (persona.tipoUsuario == TipoUsuario.VETERINARIO) {
            buttonAñadirCita.setEnabled(false);
        }

        // Añadir la tabla citas y la cedula de los usuarios
        this.setDataTable();
        this.setPersonas();
    }

    /**
     * Se envia los datos a la tabla (servicio, fecha, mascota)
     */
    private void setDataTable() {
        String nombreUsuario, servicios, fecha, mascota;
        DefaultTableModel model = (DefaultTableModel) tablaCitas.getModel();

        model.setRowCount(0);

        if (persona.misCitas != null) {
            // Se buscan entodas las citas de la persona los datos de la tabla
            for (Cita cita : persona.misCitas) {
                if (cita.existe) {
                    nombreUsuario = cita.usuario.nombreUsuario;
                    servicios = PerrosPET.parseServicios(cita.servicios);
                    fecha = dateFormat.format(cita.fecha);
                    mascota = (cita.perro).nombre;

                    Object[] row = { nombreUsuario, servicios, fecha, mascota };
                    model.addRow(row);
                }
            }
        }
        tablaCitas.setModel(model);
    }

    /**
     * Se buscan las personas. Cuando se añade una cita hay que espicificar quien es
     * el usuario. Si el que añade una cita es un usuario normal, sera si mismo. Si
     * es un administrador, hay varios usarios.
     */
    private void setPersonas() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) inputPersona.getModel();
        model.removeAllElements();

        // Si es administrador, se tomaran todos los usuarios
        if (persona.tipoUsuario == TipoUsuario.ADMINISTRADOR) {
            for (Veterinaria.Usuario usuario : PerrosPET.usuarios) {
                model.addElement(usuario.nombreUsuario);
            }
        } else {
            model.addElement(persona.nombreUsuario);
        }

        inputPersona.setModel(model);
    }

    /**
     * Seleccionado un usuario, se envian los perros asociados a esta persona
     * 
     * @param usaurio el usuario seleccionado o por default
     */
    private void setPerros(Veterinaria.Usuario usuario) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) inputMascota.getModel();
        model.removeAllElements();

        for (Veterinaria.Perro perro : usuario.misPerros) {
            if (perro.existe) {
                model.addElement(perro.nombre);
            }
        }
    }

    // Abrir el panel
    private void abrirEditor() {
        FrameDatosCita.setVisible(true);
        inputMascota.setEnabled(true);
        inputPersona.setEnabled(true);
    }

    private void abrirEditor(boolean[] servicios, Date fecha, String mascota, String nombreUsuario) {
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
        inputPersona.setSelectedItem(nombreUsuario);
        inputMascota.setEnabled(false);
        inputPersona.setEnabled(false);
    }

    /**
     * Se crea/actualiza una cita. Regresara el exito de la creación/actualizacion
     * 
     * @return
     */
    private boolean crearCita() {
        // LEER DATOS DESDE LA INTEFAZ DE USUARIO
        String nombreUsuario = (String) inputPersona.getSelectedItem();
        String nombreMascota = (String) inputMascota.getSelectedItem();
        Date fechaCita = inputFecha.getDate();

        boolean servicios[] = new boolean[7];
        // CONSULTA, CONTROL, DESPARACITACIÓN, VACUNACIÓN, GUARDERIA, RADIOLOGIA, BAÑO
        servicios[0] = inputServicio_Consulta.isSelected();
        servicios[1] = inputServicio_Control.isSelected();
        servicios[2] = inputServicio_Desparasitación.isSelected();
        servicios[3] = inputServicio_vacunación.isSelected();
        servicios[4] = inputServicio_Guarderia.isSelected();
        servicios[5] = inputServicio_Radiologia.isSelected();
        servicios[6] = inputServicio_Baño.isSelected();

        Veterinaria.Usuario usuario = encontrarUsuario(nombreUsuario);
        Veterinaria.Perro perro;

        // Confirmar que se halla seleccionado al menor un servicio
        int serviciosSeleccionados = 0;
        for (boolean servicio : servicios) {
            if (servicio) {
                serviciosSeleccionados = 1;
                break;
            }
        }

        if (serviciosSeleccionados == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione al menos un servicio");
            return false;
        }

        // Confirmar que no haya mas citas en esa fecha
        if (usuario != null) {
            if (encontrarCita(usuario, fechaCita) != null) {
                if (cita != null) {
                    if (!cita.equals(encontrarCita(usuario, fechaCita))) {
                        JOptionPane.showMessageDialog(null, "Ya tiene una cita en esta fecha");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ya tiene una cita en esta fecha");
                    return false;
                }
            }
        }

        // Confirmar que haya un veterinario disponible
        int veterinarioDisponible = 0; // variable de control. Si se encuentra un veterinario disponible, sera 1
        for (Veterinaria.Veterinario veterinario : PerrosPET.veterinarios) {
            if (veterinario.disponible(fechaCita)) {
                veterinarioDisponible = 1;
                break;
            }
        }

        if (veterinarioDisponible == 0) {
            JOptionPane.showMessageDialog(null, "No hay un veterinario disponible");
            return false;
        }

        if (usuario != null) {
            perro = encontrarPerro(usuario, nombreMascota);
            if (cita == null) {
                cita = new Cita(servicios, fechaCita, perro, usuario);
            } else {
                cita.servicios = servicios;
                cita.fecha = fechaCita;
                cita.perro = perro;
                cita.usuario = usuario;
            }
            cita = null;
            return true;
        }
        return true;
    }

    /**
     * Se sencuentra un usuario por su nombre
     * 
     * @param nombre
     * @return Usuario
     */
    private Veterinaria.Usuario encontrarUsuario(String nombre) {
        for (Veterinaria.Usuario usuario : PerrosPET.usuarios) {
            if ((usuario.nombreUsuario).equals(nombre)) {
                return usuario;
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
        for (Veterinaria.Perro perro : usuario.misPerros) {
            if (perro.existe) {
                if ((perro.nombre).equals(nombrePerro)) {
                    return perro;
                }
            }
        }
        return null;
    }

    /**
     * Busca una cita por una fecha en todos los usuarios
     * 
     * @param fechaCita
     * @return
     */
    private Veterinaria.Cita encontrarCita(String nombreUsuarioCita, String fechaCita) {
        Veterinaria.Usuario unUsuario = encontrarUsuario(nombreUsuarioCita);
        for (Veterinaria.Cita unaCita : unUsuario.misCitas) {
            if (unaCita.existe) {
                if ((dateFormat.format(unaCita.fecha)).equals(fechaCita)) {
                    return unaCita;
                }
            }
        }
        return null;
    }

    /**
     * Busca una cita por la fecha en un usuario dado
     * 
     * @param unUsuario
     * @param fechaCita
     * @return
     */
    private Veterinaria.Cita encontrarCita(Veterinaria.Usuario unUsuario, Date fechaCita) {
        for (Veterinaria.Cita unaCita : unUsuario.misCitas) {
            if (unaCita.existe) {
                if ((unaCita.fecha.compareTo(fechaCita)) == 0) {
                    return unaCita;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FrameDatosCita = new javax.swing.JFrame();
        PANEL_PERSONA = new javax.swing.JPanel();
        LabelPersona = new javax.swing.JLabel();
        inputPersona = new javax.swing.JComboBox();
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
        PANEL_TABLA = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        buttonAñadirCita = new javax.swing.JToggleButton();

        FrameDatosCita.setTitle("Perros-Pet: cita");
        FrameDatosCita.setBackground(new java.awt.Color(242, 237, 215));
        FrameDatosCita
                .setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
        FrameDatosCita.setMinimumSize(new java.awt.Dimension(500, 600));
        FrameDatosCita.setResizable(false);
        FrameDatosCita.getContentPane().setLayout(new java.awt.GridBagLayout());
        FrameDatosCita.setLocationRelativeTo(null);

        PANEL_PERSONA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_PERSONA.setMinimumSize(new java.awt.Dimension(300, 100));

        LabelPersona.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        LabelPersona.setForeground(new java.awt.Color(57, 50, 50));
        LabelPersona.setText("Usuario");

        inputPersona.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputPersona.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        inputPersona.setFocusable(false);
        inputPersona.setLightWeightPopupEnabled(false);
        inputPersona.setOpaque(false);
        inputPersona.setRequestFocusEnabled(false);
        inputPersona.setVerifyInputWhenFocusTarget(false);
        inputPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_PERSONALayout = new javax.swing.GroupLayout(PANEL_PERSONA);
        PANEL_PERSONA.setLayout(PANEL_PERSONALayout);
        PANEL_PERSONALayout.setHorizontalGroup(PANEL_PERSONALayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PANEL_PERSONALayout.createSequentialGroup().addGap(39, 39, 39)
                        .addGroup(PANEL_PERSONALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE)));
        PANEL_PERSONALayout.setVerticalGroup(
                PANEL_PERSONALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        PANEL_PERSONALayout.createSequentialGroup().addGap(22, 22, 22)
                                .addComponent(LabelPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        FrameDatosCita.getContentPane().add(PANEL_PERSONA, gridBagConstraints);

        PANEL_MASCOTA.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_MASCOTA.setMinimumSize(new java.awt.Dimension(300, 100));
        PANEL_MASCOTA.setPreferredSize(new java.awt.Dimension(300, 100));

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

        javax.swing.GroupLayout PANEL_MASCOTALayout = new javax.swing.GroupLayout(PANEL_MASCOTA);
        PANEL_MASCOTA.setLayout(PANEL_MASCOTALayout);
        PANEL_MASCOTALayout.setHorizontalGroup(PANEL_MASCOTALayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PANEL_MASCOTALayout.createSequentialGroup().addGap(39, 39, 39)
                        .addGroup(PANEL_MASCOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 220,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE)));
        PANEL_MASCOTALayout.setVerticalGroup(
                PANEL_MASCOTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        PANEL_MASCOTALayout.createSequentialGroup().addGap(22, 22, 22)
                                .addComponent(LabelMascota, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
                        .addGroup(PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        PANEL_FECHALayout.createSequentialGroup()
                                                .addComponent(LabelCalendario, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)))
                        .addContainerGap(23, Short.MAX_VALUE)));
        PANEL_FECHALayout
                .setVerticalGroup(PANEL_FECHALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                PANEL_FECHALayout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
                                        .addComponent(LabelCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        FrameDatosCita.getContentPane().add(PANEL_FECHA, gridBagConstraints);

        PANEL_SERVICIOS.setBackground(new java.awt.Color(242, 237, 215));
        PANEL_SERVICIOS.setMinimumSize(new java.awt.Dimension(200, 400));
        PANEL_SERVICIOS.setName(""); // NOI18N
        PANEL_SERVICIOS.setPreferredSize(new java.awt.Dimension(200, 400));
        PANEL_SERVICIOS.setLayout(new java.awt.GridLayout(7, 0));

        inputServicio_Consulta.setBackground(new java.awt.Color(242, 237, 215));
        inputServicio_Consulta.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputServicio_Consulta.setText("<html>\nConsulta veterinario <br>\n$60.000 por 1 hora.\n</html>");
        inputServicio_Consulta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputServicio_Consulta.setFocusPainted(false);
        inputServicio_Consulta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputServicio_Consulta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PANEL_SERVICIOS.add(inputServicio_Consulta);

        inputServicio_Control.setBackground(new java.awt.Color(242, 237, 215));
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
        inputServicio_Desparasitación.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputServicio_Desparasitación.setText("<html>\nDesparasitación <br>\n$40.000 por 1/2 hora.\n</html>");
        inputServicio_Desparasitación.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputServicio_Desparasitación.setFocusPainted(false);
        inputServicio_Desparasitación.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputServicio_Desparasitación.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PANEL_SERVICIOS.add(inputServicio_Desparasitación);

        inputServicio_vacunación.setBackground(new java.awt.Color(242, 237, 215));
        inputServicio_vacunación.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputServicio_vacunación.setText("<html>\nVacunación <br>\n$35.000 por 1/2 hora.\n</html>");
        inputServicio_vacunación.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputServicio_vacunación.setFocusPainted(false);
        inputServicio_vacunación.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputServicio_vacunación.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PANEL_SERVICIOS.add(inputServicio_vacunación);

        inputServicio_Guarderia.setBackground(new java.awt.Color(242, 237, 215));
        inputServicio_Guarderia.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputServicio_Guarderia.setText("<html>\nGuarderia (solo por día) <br>\n $35.000.\n</html>");
        inputServicio_Guarderia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputServicio_Guarderia.setFocusPainted(false);
        inputServicio_Guarderia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputServicio_Guarderia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PANEL_SERVICIOS.add(inputServicio_Guarderia);

        inputServicio_Radiologia.setBackground(new java.awt.Color(242, 237, 215));
        inputServicio_Radiologia.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputServicio_Radiologia.setText("<html>\nRadiologia <br>\n$100.000 por 1 hora.\n</html>");
        inputServicio_Radiologia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inputServicio_Radiologia.setFocusPainted(false);
        inputServicio_Radiologia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inputServicio_Radiologia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PANEL_SERVICIOS.add(inputServicio_Radiologia);

        inputServicio_Baño.setBackground(new java.awt.Color(242, 237, 215));
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
        inputBorrar.setEnabled(false);
        inputBorrar.setFocusPainted(false);
        inputBorrar.setFocusable(false);
        inputBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBorrarActionPerformed(evt);
            }
        });

        inputGuardar.setBackground(new java.awt.Color(58, 99, 81));
        inputGuardar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        inputGuardar.setForeground(new java.awt.Color(242, 237, 215));
        inputGuardar.setText("Guardar");
        inputGuardar.setBorder(null);
        inputGuardar.setBorderPainted(false);
        inputGuardar.setFocusPainted(false);
        inputGuardar.setFocusable(false);
        inputGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_BOTTONESLayout = new javax.swing.GroupLayout(PANEL_BOTTONES);
        PANEL_BOTTONES.setLayout(PANEL_BOTTONESLayout);
        PANEL_BOTTONESLayout
                .setHorizontalGroup(PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                PANEL_BOTTONESLayout.createSequentialGroup().addContainerGap(128, Short.MAX_VALUE)
                                        .addComponent(inputBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(122, 122, 122)));
        PANEL_BOTTONESLayout.setVerticalGroup(PANEL_BOTTONESLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PANEL_BOTTONESLayout.createSequentialGroup().addGap(0, 36, Short.MAX_VALUE)
                        .addGroup(PANEL_BOTTONESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 28;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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

        }, new String[] { "Usuario", "Servicios", "Fecha", "Mascota" }) {
            boolean[] canEdit = new boolean[] { false, false, false, false };

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
        if (tablaCitas.getColumnModel().getColumnCount() > 0) {
            tablaCitas.getColumnModel().getColumn(0).setResizable(false);
        }

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
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonAñadirCita).addComponent(PANEL_TABLA,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(PANEL_TABLA, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18).addComponent(buttonAñadirCita).addGap(22, 22, 22)));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Elimina la cita seleccionada
     * 
     * @param evt
     */
    private void inputBorrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputBorrarActionPerformed
        this.cita.eliminar();
        setDataTable();
        this.FrameDatosCita.setVisible(false);
    }// GEN-LAST:event_inputBorrarActionPerformed

    /**
     * Se envian los perros ya seleccionado un usuario
     * 
     * @param evt
     */

    private void inputPersonaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputPersonaActionPerformed
        for (Veterinaria.Usuario usuario : PerrosPET.usuarios) {
            if ((usuario.nombreUsuario).equals(inputPersona.getSelectedItem())) {
                setPerros(usuario);
            }
        }
    }// GEN-LAST:event_inputPersonaActionPerformed

    /**
     * Se guardan los datos
     * 
     * @param evt
     */
    private void inputGuardarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inputGuardarActionPerformed
        if (crearCita()) {
            setDataTable();
            cita = null;
            FrameDatosCita.setVisible(false);
        }
    }// GEN-LAST:event_inputGuardarActionPerformed

    /**
     * Se añade una cita
     * 
     * @param evt
     */
    private void buttonAñadirCitaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAñadirCitaActionPerformed
        abrirEditor();
        inputBorrar.setEnabled(false);
    }// GEN-LAST:event_buttonAñadirCitaActionPerformed

    /**
     * Al seleccionar una fila de la tabla, abre el panel y se abren los datos
     * 
     * @param evt
     */
    private void tablaCitasMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tablaCitasMouseClicked
        int row = tablaCitas.rowAtPoint(evt.getPoint());
        String nombreTabla = tablaCitas.getModel().getValueAt(row, 0) + "";
        String fechaTabla = tablaCitas.getModel().getValueAt(row, 2) + "";

        cita = encontrarCita(nombreTabla, fechaTabla);
        if (cita != null) {
            if (cita.factura != null || cita.historial != null) {
                JOptionPane.showMessageDialog(null, "Esta cita ya se llevo a cabo, no se puede eliminar o modificar");
            } else {
                abrirEditor(cita.servicios, cita.fecha, cita.perro.nombre, nombreTabla);
                inputBorrar.setEnabled(true);
            }
        } else {
            abrirEditor();
        }
    }// GEN-LAST:event_tablaCitasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameDatosCita;
    private javax.swing.JLabel LabelCalendario;
    private javax.swing.JLabel LabelMascota;
    private javax.swing.JLabel LabelPersona;
    private javax.swing.JPanel PANEL_BOTTONES;
    private javax.swing.JPanel PANEL_FECHA;
    private javax.swing.JPanel PANEL_MASCOTA;
    private javax.swing.JPanel PANEL_PERSONA;
    private javax.swing.JPanel PANEL_SERVICIOS;
    private javax.swing.JScrollPane PANEL_TABLA;
    private javax.swing.JToggleButton buttonAñadirCita;
    private javax.swing.JButton inputBorrar;
    private com.toedter.calendar.JCalendar inputFecha;
    private javax.swing.JButton inputGuardar;
    private javax.swing.JComboBox inputMascota;
    private javax.swing.JComboBox inputPersona;
    private javax.swing.JCheckBox inputServicio_Baño;
    private javax.swing.JCheckBox inputServicio_Consulta;
    private javax.swing.JCheckBox inputServicio_Control;
    private javax.swing.JCheckBox inputServicio_Desparasitación;
    private javax.swing.JCheckBox inputServicio_Guarderia;
    private javax.swing.JCheckBox inputServicio_Radiologia;
    private javax.swing.JCheckBox inputServicio_vacunación;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables
}
