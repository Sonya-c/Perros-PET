/*
 * FUNCIÓN: Maneja el ingreso/registro al programa.
 * INGRESO: busca en un arreglo de personas un objeto cuyo usuario-contraseña sea el que ingresa el usuario
 * REGISTRO: Verifica el input del usuario.
 * El nombre de usuario y documento no se pueden repetir, la contraseña no puede estar vacia.
 * La clave secreta del usuario debe ser valida
 * Si el registro es valido, crear un nuevo objeto usuario
 * Si el ingreso o registro es exitoso, se cerrara y mostrara la pantalla pincipal del usuario.
 */
package GUI;

import Veterinaria.Admi;
import Veterinaria.Persona;
import Veterinaria.TipoDocumento;
import Veterinaria.Usuario;
import Veterinaria.Veterinario;
import perros.pet.PerrosPET;
import javax.swing.JOptionPane;

public class Ingreso extends javax.swing.JFrame {

        public Veterinaria.Persona user;

        // Datos obtenidos desde la Interfaz de usuario
        public String nombreUsuario;
        public String contraseñaUsuario;
        public String tipoDocumento;
        public String documento;
        public String tipoUsuario;
        public String claveSecreta;

        public Ingreso() {
                initComponents();
                // Añadir el formulario
                this.remove(Form);
                this.add(Ingreso);
                validate();
                repaint();
        }

        private void ingresoLeerDatos() {
                // Lee todos los datos de ingreso
                nombreUsuario = inputIngresarUsuario.getText();
                contraseñaUsuario = String.valueOf(inputIngresarContraseña.getPassword());
        }

        private void registroLeerDatos() {
                // Lee todos los datos del registro
                nombreUsuario = inputRegistrarseUsuario.getText();
                tipoDocumento = (inputRegistroTipoDoc.getSelectedItem()).toString();
                documento = inputRegistroDocumento.getText();
                contraseñaUsuario = String.valueOf(inputRegistraseContraseña.getPassword());
                tipoUsuario = (inputRegistroTipoUsuario.getSelectedItem()).toString();
                claveSecreta = inputRegistroUsuarioClave.getText();
        }

        private void abrirPrograma() {
                this.setVisible(false);
                user.showUserInterface();
        }

        private Persona buscarPersona(String nombreUsuario) {
                // Esta función busca a un usuario por el nombre, si lo encuentra, regresará la
                // persona, sino, regresará null
                if (PerrosPET.personas != null) {
                        for (Persona persona : PerrosPET.personas) {
                                if ((persona.nombreUsuario).equals(nombreUsuario)) {
                                        return persona;
                                }
                        }
                }
                return null;
        }

        private int buscarPersona(String nombreUsuario, String documento) {
                /*
                 * Esta función busca a un usuario por nombre y documento. Si el nombre y
                 * documento están disponibles, regresará 0 Si el nombre no está disponible,
                 * regresará 1 Si el documento no está disponibles, regresará 2 Si el nombre y
                 * documento no están disbonibles, regresará 3
                 */
                int disponibilidad = 0; // Inicialmente el 0, si no hay usuarios
                                        // entonces el nombre y documento están disponibles

                if (PerrosPET.personas != null) {
                        for (Persona persona : PerrosPET.personas) {
                                if ((persona.nombreUsuario).equals(nombreUsuario)) {
                                        disponibilidad += 1;
                                }

                                if ((persona.documento).equals(documento)) {
                                        disponibilidad += 2;
                                }
                        }
                }
                return disponibilidad;
        }

        private boolean validarIngreso() {
                /*
                 * Esta función se encarga de buscar el usuario por medio del nombre que se
                 * ingresó. Si la contraseña ingresada coincide con la de la del usuario
                 * encontrado, se regresará true Si la contraseña ingresada NO coincide con la
                 * de la del usuario encontrado, se regresará false Si el usuario ingresado no
                 * exite se regresara false
                 */
                ingresoLeerDatos();
                Persona personaEncontrada = buscarPersona(nombreUsuario);
                if (personaEncontrada == null) {
                        return false;
                } else {
                        if ((personaEncontrada.contraseña).equals(contraseñaUsuario)) {
                                return true;
                        } else {
                                return false;
                        }
                }
        }

        private boolean validarRegistro() {
                /*
                 * Esta función se encarga de buscar el usuario por medio del nombre y por
                 * documento Si este usuario existe, se regresará false. Si el usuario no
                 * existe, se creará una nueva persona y regresará true
                 */

                registroLeerDatos();
                String mensaje = "";

                if (!(tipoUsuario).equals("Usuario")) {
                        switch (tipoUsuario) {
                        case "Veterinario":
                                if (!(claveSecreta).equals("eheh9s")) {
                                        JOptionPane.showMessageDialog(null, "Clave de veterinario incorrecta.");
                                        return false;
                                }
                                break;
                        case "Administrador":
                                if (!(claveSecreta).equals("gi0wnt")) {
                                        JOptionPane.showMessageDialog(null, "Clave de adeministrador incorrecta.");
                                        return false;
                                }
                                break;
                        default:
                                break;
                        }
                }

                if (nombreUsuario.length() <= 0 || contraseñaUsuario.length() <= 0 || documento.length() <= 0) {
                        mensaje += "Algunos campos estan vacios";
                } else {
                        // Si los campos estan vacios, la validación del registro es false
                        switch (buscarPersona(nombreUsuario, documento)) {
                        case 0:
                                return true; // PONERLO VERDADERO
                        case 1:
                                mensaje += "Nombre de usuario no disponible";
                                break;
                        case 2:
                                mensaje += "Usuario con este docuemento ya existe";
                                break;
                        case 3:
                                mensaje += "Este usuario ya existe";
                                break;
                        default:
                                mensaje += "Error en la creación del usuario";
                        }
                }

                JOptionPane.showMessageDialog(null, mensaje);
                return false;
        }

        private Persona crearPersona() {
                /*
                 * Dependiendo del tipo de usuario, la variable user tipo perona sera
                 * inicializada Los datos de la pantalla deben ser leídos para
                 */
                registroLeerDatos();

                // Por la interfaz de usuario los datos son recibidos como String, asi que
                // debemos pasar el tipo de documento a tipo Doc
                TipoDocumento tipoDoc = null;

                switch (tipoDocumento) {
                case "Cedula":
                        tipoDoc = TipoDocumento.CEDULA;
                        break;
                case "TI":
                        tipoDoc = TipoDocumento.TARJETA_IDENTIDAD;
                        break;
                case "Pasaporte":
                        tipoDoc = TipoDocumento.PASAPORTE;
                        break;
                case "Cedula E":
                        tipoDoc = TipoDocumento.CEDULA_EXTRANJERIA;
                        break;
                default:
                        break;
                }

                switch (tipoUsuario) {
                // String nombreUsuario, TipoDocumento tipoDocumento, String documento, String
                // contraseña
                case "Usuario":
                        this.user = (Usuario) new Veterinaria.Usuario(nombreUsuario, tipoDoc, documento,
                                        contraseñaUsuario);
                        (PerrosPET.usuarios).add((Usuario) this.user);
                        break;
                case "Veterinario":
                        this.user = (Veterinario) new Veterinaria.Veterinario(nombreUsuario, tipoDoc, documento,
                                        contraseñaUsuario);
                        (PerrosPET.veterinarios).add((Veterinario) this.user);
                        break;
                case "Administrador":
                        this.user = (Admi) new Veterinaria.Admi(nombreUsuario, tipoDoc, documento, contraseñaUsuario);
                        (PerrosPET.administradores).add((Admi) this.user);
                        break;
                default:
                        break;
                }

                (PerrosPET.personas).add(this.user);
                return null;
        }

        private void verContraseña(javax.swing.JPasswordField campo) {
                // Opción para ver las contraseñas
                if (campo.getEchoChar() != (char) 0)
                        campo.setEchoChar((char) 0);
                else
                        campo.setEchoChar('\u2022');
        }

        // ACCIONES
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                String fontName = "Candara";

                bindingGroup = new org.jdesktop.beansbinding.BindingGroup();
                Ingreso = new javax.swing.JPanel();
                LABEL_INGRESAR_TITULO = new javax.swing.JLabel();
                VACIO_01 = new javax.swing.JLabel();
                LABEL_INGRESAR_USUARIO = new javax.swing.JLabel();
                inputIngresarUsuario = new javax.swing.JTextField();
                VACIO_02 = new javax.swing.JLabel();
                LABEL_INGRESAR_CONTRASEÑA = new javax.swing.JLabel();
                PANEL_INGRESAR_CONTRASEÑA = new javax.swing.JPanel();
                inputIngresarContraseña = new javax.swing.JPasswordField();
                buttonIngresarVerContraseña = new javax.swing.JButton();
                VACIO_03 = new javax.swing.JLabel();
                MENSAJE_INGRESAR = new javax.swing.JLabel();
                VACIO_04 = new javax.swing.JLabel();
                PANEL_INGRESAR_BOTONES = new javax.swing.JPanel();
                bottonIngresarIngresar = new javax.swing.JButton();
                bottonIngresarRegistrarse = new javax.swing.JButton();
                Registro = new javax.swing.JPanel();
                LABEL_REGISTRASE_TITULO = new javax.swing.JLabel();
                LABEL_REGISTRASE_USUARIO = new javax.swing.JLabel();
                inputRegistrarseUsuario = new javax.swing.JTextField();
                LABEL_REGISTRARSE_CONTRASEÑA = new javax.swing.JLabel();
                PANEL_REGISTRARSE_CONTRASEÑA = new javax.swing.JPanel();
                inputRegistraseContraseña = new javax.swing.JPasswordField();
                bottonRegistraseVerContraseña = new javax.swing.JButton();
                LABEL_REGISTRASE_DOCUMENTO = new javax.swing.JLabel();
                PANEL_REGISTRASE_DOCUMENTO = new javax.swing.JPanel();
                inputRegistroTipoDoc = new javax.swing.JComboBox();
                inputRegistroDocumento = new javax.swing.JTextField();
                LABEL_REGISTRASE_TIPO_USUARIO = new javax.swing.JLabel();
                PANEL_REGISTRASE_TIPO_USUARIO = new javax.swing.JPanel();
                inputRegistroTipoUsuario = new javax.swing.JComboBox();
                inputRegistroUsuarioClave = new javax.swing.JTextField();
                VACIO_06 = new javax.swing.JLabel();
                PANEL_REGITRASE_BOTTONES = new javax.swing.JPanel();
                buttonRegistroIngresar = new javax.swing.JButton();
                buttonRegistroRegistro = new javax.swing.JButton();
                Imagen = new javax.swing.JPanel();
                toby_png = new javax.swing.JLabel();
                Form = new javax.swing.JPanel();

                Ingreso.setBackground(new java.awt.Color(57, 50, 50));
                Ingreso.setMaximumSize(new java.awt.Dimension(452, 552));
                Ingreso.setMinimumSize(new java.awt.Dimension(452, 552));
                Ingreso.setPreferredSize(new java.awt.Dimension(452, 552));
                Ingreso.setLayout(new java.awt.GridLayout(12, 1));

                LABEL_INGRESAR_TITULO.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_INGRESAR_TITULO.setFont(new java.awt.Font(fontName, 1, 24)); // NOI18N
                LABEL_INGRESAR_TITULO.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_INGRESAR_TITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                LABEL_INGRESAR_TITULO.setText("Tengo cuenta");
                LABEL_INGRESAR_TITULO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
                Ingreso.add(LABEL_INGRESAR_TITULO);
                Ingreso.add(VACIO_01);

                LABEL_INGRESAR_USUARIO.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_INGRESAR_USUARIO.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                LABEL_INGRESAR_USUARIO.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_INGRESAR_USUARIO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                LABEL_INGRESAR_USUARIO.setText("Nombre de Usuario");
                LABEL_INGRESAR_USUARIO.setAlignmentX(5.0F);
                LABEL_INGRESAR_USUARIO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                LABEL_INGRESAR_USUARIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LABEL_INGRESAR_USUARIO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                Ingreso.add(LABEL_INGRESAR_USUARIO);

                inputIngresarUsuario.setBackground(new java.awt.Color(242, 237, 215));
                inputIngresarUsuario.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                inputIngresarUsuario.setText("Juanito de Tal");
                inputIngresarUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                Ingreso.add(inputIngresarUsuario);
                Ingreso.add(VACIO_02);

                LABEL_INGRESAR_CONTRASEÑA.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_INGRESAR_CONTRASEÑA.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                LABEL_INGRESAR_CONTRASEÑA.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_INGRESAR_CONTRASEÑA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                LABEL_INGRESAR_CONTRASEÑA.setText("Contraseña");
                LABEL_INGRESAR_CONTRASEÑA.setAlignmentX(5.0F);
                LABEL_INGRESAR_CONTRASEÑA.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                LABEL_INGRESAR_CONTRASEÑA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LABEL_INGRESAR_CONTRASEÑA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                Ingreso.add(LABEL_INGRESAR_CONTRASEÑA);

                PANEL_INGRESAR_CONTRASEÑA.setBackground(new java.awt.Color(242, 237, 215));
                PANEL_INGRESAR_CONTRASEÑA.setForeground(new java.awt.Color(57, 50, 50));
                PANEL_INGRESAR_CONTRASEÑA.setLayout(
                                new javax.swing.BoxLayout(PANEL_INGRESAR_CONTRASEÑA, javax.swing.BoxLayout.LINE_AXIS));

                inputIngresarContraseña.setBackground(new java.awt.Color(242, 237, 215));
                inputIngresarContraseña.setText("juanitodetal102");
                inputIngresarContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                PANEL_INGRESAR_CONTRASEÑA.add(inputIngresarContraseña);

                buttonIngresarVerContraseña.setBackground(new java.awt.Color(242, 237, 215));
                buttonIngresarVerContraseña.setFont(new java.awt.Font(fontName, 0, 12)); // NOI18N
                buttonIngresarVerContraseña.setForeground(new java.awt.Color(57, 50, 50));
                buttonIngresarVerContraseña.setText("Ver");
                buttonIngresarVerContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                buttonIngresarVerContraseña.setBorderPainted(false);
                buttonIngresarVerContraseña.setFocusPainted(false);
                buttonIngresarVerContraseña.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonIngresarVerContraseñaActionPerformed(evt);
                        }
                });
                PANEL_INGRESAR_CONTRASEÑA.add(buttonIngresarVerContraseña);

                Ingreso.add(PANEL_INGRESAR_CONTRASEÑA);
                Ingreso.add(VACIO_03);

                MENSAJE_INGRESAR.setFont(new java.awt.Font(fontName, 0, 12)); // NOI18N
                MENSAJE_INGRESAR.setForeground(new java.awt.Color(242, 237, 215));
                MENSAJE_INGRESAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                MENSAJE_INGRESAR.setText(
                                "Si no posse una cuenta, puede crearla con clicleando el boton \"registrase\"");
                Ingreso.add(MENSAJE_INGRESAR);
                Ingreso.add(VACIO_04);

                PANEL_INGRESAR_BOTONES.setBackground(new java.awt.Color(57, 50, 50));

                bottonIngresarIngresar.setBackground(new java.awt.Color(228, 130, 87));
                bottonIngresarIngresar.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                bottonIngresarIngresar.setForeground(new java.awt.Color(242, 237, 215));
                bottonIngresarIngresar.setText("Ingresar");
                bottonIngresarIngresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                bottonIngresarIngresar.setBorderPainted(false);
                bottonIngresarIngresar.setFocusPainted(false);
                bottonIngresarIngresar.setFocusable(false);
                bottonIngresarIngresar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bottonIngresarIngresarActionPerformed(evt);
                        }
                });

                bottonIngresarRegistrarse.setBackground(new java.awt.Color(58, 99, 81));
                bottonIngresarRegistrarse.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                bottonIngresarRegistrarse.setForeground(new java.awt.Color(242, 237, 215));
                bottonIngresarRegistrarse.setText("Registrarse");
                bottonIngresarRegistrarse.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                bottonIngresarRegistrarse.setBorderPainted(false);
                bottonIngresarRegistrarse.setFocusPainted(false);
                bottonIngresarRegistrarse.setFocusable(false);
                bottonIngresarRegistrarse.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bottonIngresarRegistrarseActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout PANEL_INGRESAR_BOTONESLayout = new javax.swing.GroupLayout(
                                PANEL_INGRESAR_BOTONES);
                PANEL_INGRESAR_BOTONES.setLayout(PANEL_INGRESAR_BOTONESLayout);
                PANEL_INGRESAR_BOTONESLayout.setHorizontalGroup(PANEL_INGRESAR_BOTONESLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PANEL_INGRESAR_BOTONESLayout.createSequentialGroup().addGap(25, 25, 25)
                                                .addComponent(bottonIngresarIngresar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 175,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(bottonIngresarRegistrarse,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 194,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(32, Short.MAX_VALUE)));
                PANEL_INGRESAR_BOTONESLayout.setVerticalGroup(PANEL_INGRESAR_BOTONESLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_INGRESAR_BOTONESLayout
                                                .createSequentialGroup()
                                                .addGroup(PANEL_INGRESAR_BOTONESLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(bottonIngresarIngresar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(bottonIngresarRegistrarse,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)));

                Ingreso.add(PANEL_INGRESAR_BOTONES);

                Registro.setBackground(new java.awt.Color(57, 50, 50));
                Registro.setMaximumSize(new java.awt.Dimension(452, 552));
                Registro.setMinimumSize(new java.awt.Dimension(452, 552));
                Registro.setPreferredSize(new java.awt.Dimension(452, 552));
                Registro.setLayout(new java.awt.GridLayout(12, 1));

                LABEL_REGISTRASE_TITULO.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_TITULO.setFont(new java.awt.Font(fontName, 1, 24)); // NOI18N
                LABEL_REGISTRASE_TITULO.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_TITULO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                LABEL_REGISTRASE_TITULO.setText("Registarse");
                LABEL_REGISTRASE_TITULO.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
                Registro.add(LABEL_REGISTRASE_TITULO);

                LABEL_REGISTRASE_USUARIO.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_USUARIO.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                LABEL_REGISTRASE_USUARIO.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_USUARIO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                LABEL_REGISTRASE_USUARIO.setText("Nombre de Usuario");
                LABEL_REGISTRASE_USUARIO.setAlignmentX(5.0F);
                LABEL_REGISTRASE_USUARIO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                LABEL_REGISTRASE_USUARIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LABEL_REGISTRASE_USUARIO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                Registro.add(LABEL_REGISTRASE_USUARIO);

                inputRegistrarseUsuario.setBackground(new java.awt.Color(242, 237, 215));
                inputRegistrarseUsuario.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                inputRegistrarseUsuario.setText("Fulanito de Tal");
                inputRegistrarseUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                Registro.add(inputRegistrarseUsuario);

                LABEL_REGISTRARSE_CONTRASEÑA.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRARSE_CONTRASEÑA.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                LABEL_REGISTRARSE_CONTRASEÑA.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRARSE_CONTRASEÑA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                LABEL_REGISTRARSE_CONTRASEÑA.setText("Contraseña");
                LABEL_REGISTRARSE_CONTRASEÑA.setAlignmentX(5.0F);
                LABEL_REGISTRARSE_CONTRASEÑA.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                LABEL_REGISTRARSE_CONTRASEÑA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LABEL_REGISTRARSE_CONTRASEÑA.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                Registro.add(LABEL_REGISTRARSE_CONTRASEÑA);

                PANEL_REGISTRARSE_CONTRASEÑA.setBackground(new java.awt.Color(242, 237, 215));
                PANEL_REGISTRARSE_CONTRASEÑA.setForeground(new java.awt.Color(57, 50, 50));
                PANEL_REGISTRARSE_CONTRASEÑA.setLayout(new javax.swing.BoxLayout(PANEL_REGISTRARSE_CONTRASEÑA,
                                javax.swing.BoxLayout.LINE_AXIS));

                inputRegistraseContraseña.setBackground(new java.awt.Color(242, 237, 215));
                inputRegistraseContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                inputRegistraseContraseña.setText("fulanitodeltal123");
                inputRegistraseContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                PANEL_REGISTRARSE_CONTRASEÑA.add(inputRegistraseContraseña);

                bottonRegistraseVerContraseña.setBackground(new java.awt.Color(242, 237, 215));
                bottonRegistraseVerContraseña.setFont(new java.awt.Font(fontName, 0, 12)); // NOI18N
                bottonRegistraseVerContraseña.setForeground(new java.awt.Color(57, 50, 50));
                bottonRegistraseVerContraseña.setText("Ver");
                bottonRegistraseVerContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                bottonRegistraseVerContraseña.setBorderPainted(false);
                bottonRegistraseVerContraseña.setFocusPainted(false);
                bottonRegistraseVerContraseña.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bottonRegistraseVerContraseñaActionPerformed(evt);
                        }
                });
                PANEL_REGISTRARSE_CONTRASEÑA.add(bottonRegistraseVerContraseña);

                Registro.add(PANEL_REGISTRARSE_CONTRASEÑA);

                LABEL_REGISTRASE_DOCUMENTO.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_DOCUMENTO.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                LABEL_REGISTRASE_DOCUMENTO.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_DOCUMENTO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                LABEL_REGISTRASE_DOCUMENTO.setText("Documento");
                LABEL_REGISTRASE_DOCUMENTO.setAlignmentX(5.0F);
                LABEL_REGISTRASE_DOCUMENTO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                LABEL_REGISTRASE_DOCUMENTO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LABEL_REGISTRASE_DOCUMENTO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                Registro.add(LABEL_REGISTRASE_DOCUMENTO);

                PANEL_REGISTRASE_DOCUMENTO.setLayout(
                                new javax.swing.BoxLayout(PANEL_REGISTRASE_DOCUMENTO, javax.swing.BoxLayout.X_AXIS));

                inputRegistroTipoDoc.setBackground(new java.awt.Color(242, 237, 215));
                inputRegistroTipoDoc.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                inputRegistroTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(
                                new String[] { "Cedula", "TI", "Pasaporte", "Cedula E" }));
                inputRegistroTipoDoc.setBorder(
                                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 237, 215)));
                inputRegistroTipoDoc.setEditor(null);
                inputRegistroTipoDoc.setFocusCycleRoot(true);
                inputRegistroTipoDoc.setLightWeightPopupEnabled(false);
                inputRegistroTipoDoc.setOpaque(false);
                inputRegistroTipoDoc.setPreferredSize(new java.awt.Dimension(113, 22));
                inputRegistroTipoDoc.setRequestFocusEnabled(false);
                PANEL_REGISTRASE_DOCUMENTO.add(inputRegistroTipoDoc);

                inputRegistroDocumento.setBackground(new java.awt.Color(242, 237, 215));
                inputRegistroDocumento.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                inputRegistroDocumento.setText("100010001001");
                inputRegistroDocumento.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                PANEL_REGISTRASE_DOCUMENTO.add(inputRegistroDocumento);

                Registro.add(PANEL_REGISTRASE_DOCUMENTO);

                LABEL_REGISTRASE_TIPO_USUARIO.setBackground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_TIPO_USUARIO.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                LABEL_REGISTRASE_TIPO_USUARIO.setForeground(new java.awt.Color(242, 237, 215));
                LABEL_REGISTRASE_TIPO_USUARIO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                LABEL_REGISTRASE_TIPO_USUARIO.setText("Tipo usuario");
                LABEL_REGISTRASE_TIPO_USUARIO.setAlignmentX(5.0F);
                LABEL_REGISTRASE_TIPO_USUARIO.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                LABEL_REGISTRASE_TIPO_USUARIO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                LABEL_REGISTRASE_TIPO_USUARIO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
                Registro.add(LABEL_REGISTRASE_TIPO_USUARIO);

                PANEL_REGISTRASE_TIPO_USUARIO.setLayout(
                                new javax.swing.BoxLayout(PANEL_REGISTRASE_TIPO_USUARIO, javax.swing.BoxLayout.X_AXIS));

                inputRegistroTipoUsuario.setBackground(new java.awt.Color(242, 237, 215));
                inputRegistroTipoUsuario.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                inputRegistroTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(
                                new String[] { "Usuario", "Veterinario", "Administrador" }));
                inputRegistroTipoUsuario.setBorder(
                                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 237, 215)));
                inputRegistroTipoUsuario.setFocusable(false);
                inputRegistroTipoUsuario.setLightWeightPopupEnabled(false);
                inputRegistroTipoUsuario.setOpaque(false);
                inputRegistroTipoUsuario.setRequestFocusEnabled(false);
                inputRegistroTipoUsuario.setVerifyInputWhenFocusTarget(false);
                PANEL_REGISTRASE_TIPO_USUARIO.add(inputRegistroTipoUsuario);

                inputRegistroUsuarioClave.setBackground(new java.awt.Color(242, 237, 215));
                inputRegistroUsuarioClave.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                inputRegistroUsuarioClave.setText("Clave secreta");
                inputRegistroUsuarioClave.setToolTipText(
                                "Cada usuario tiene una clave secreta. Para poder identificarse como veterinario o administrador debe ingresar una clave secreta. Su usted es usurio, puede dejar este campo vacio");
                inputRegistroUsuarioClave.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                PANEL_REGISTRASE_TIPO_USUARIO.add(inputRegistroUsuarioClave);

                Registro.add(PANEL_REGISTRASE_TIPO_USUARIO);
                Registro.add(VACIO_06);

                PANEL_REGITRASE_BOTTONES.setBackground(new java.awt.Color(57, 50, 50));

                buttonRegistroIngresar.setBackground(new java.awt.Color(228, 130, 87));
                buttonRegistroIngresar.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                buttonRegistroIngresar.setForeground(new java.awt.Color(242, 237, 215));
                buttonRegistroIngresar.setText("Ingresar");
                buttonRegistroIngresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
                buttonRegistroIngresar.setBorderPainted(false);
                buttonRegistroIngresar.setFocusPainted(false);
                buttonRegistroIngresar.setFocusable(false);
                buttonRegistroIngresar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonRegistroIngresarActionPerformed(evt);
                        }
                });

                buttonRegistroRegistro.setBackground(new java.awt.Color(58, 99, 81));
                buttonRegistroRegistro.setFont(new java.awt.Font(fontName, 0, 14)); // NOI18N
                buttonRegistroRegistro.setForeground(new java.awt.Color(242, 237, 215));
                buttonRegistroRegistro.setText("Registrarse");
                buttonRegistroRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));
                buttonRegistroRegistro.setBorderPainted(false);
                buttonRegistroRegistro.setFocusPainted(false);
                buttonRegistroRegistro.setFocusable(false);
                buttonRegistroRegistro.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonRegistroRegistroActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout PANEL_REGITRASE_BOTTONESLayout = new javax.swing.GroupLayout(
                                PANEL_REGITRASE_BOTTONES);
                PANEL_REGITRASE_BOTTONES.setLayout(PANEL_REGITRASE_BOTTONESLayout);
                PANEL_REGITRASE_BOTTONESLayout.setHorizontalGroup(PANEL_REGITRASE_BOTTONESLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PANEL_REGITRASE_BOTTONESLayout.createSequentialGroup().addGap(25, 25, 25)
                                                .addComponent(buttonRegistroIngresar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 175,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(buttonRegistroRegistro,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 194,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                PANEL_REGITRASE_BOTTONESLayout.setVerticalGroup(PANEL_REGITRASE_BOTTONESLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PANEL_REGITRASE_BOTTONESLayout
                                                .createSequentialGroup()
                                                .addGroup(PANEL_REGITRASE_BOTTONESLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(buttonRegistroRegistro,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                0, Short.MAX_VALUE)
                                                                .addComponent(buttonRegistroIngresar,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                44, Short.MAX_VALUE))
                                                .addGap(37, 37, 37)));

                Registro.add(PANEL_REGITRASE_BOTTONES);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Perros-pet: ¡Bienvenido!");
                setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Resources/logo.png")).getImage());
                setResizable(false);
                getContentPane().setLayout(new java.awt.GridLayout(1, 2));

                org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
                                org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, toby_png,
                                org.jdesktop.beansbinding.ELProperty.create("${background}"), Imagen,
                                org.jdesktop.beansbinding.BeanProperty.create("background"));
                bindingGroup.addBinding(binding);

                toby_png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Toby.jpg"))); // NOI18N

                javax.swing.GroupLayout ImagenLayout = new javax.swing.GroupLayout(Imagen);
                Imagen.setLayout(ImagenLayout);
                ImagenLayout.setHorizontalGroup(
                                ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(toby_png, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                ImagenLayout.setVerticalGroup(
                                ImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(toby_png, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                getContentPane().add(Imagen);

                Form.setBackground(new java.awt.Color(57, 50, 50));

                javax.swing.GroupLayout FormLayout = new javax.swing.GroupLayout(Form);
                Form.setLayout(FormLayout);
                FormLayout.setHorizontalGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 452, Short.MAX_VALUE));
                FormLayout.setVerticalGroup(FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 552, Short.MAX_VALUE));

                getContentPane().add(Form);

                bindingGroup.bind();

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        // ABRIR PROGRAMA: Validar registro
        private void buttonRegistroRegistroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonRegistroRegistroActionPerformed
                if (validarRegistro()) {
                        crearPersona();
                        abrirPrograma();
                }
        }// GEN-LAST:event_buttonRegistroRegistroActionPerformed

        // ABRIR PROGRAMA: Validar ingreso
        private void bottonIngresarIngresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bottonIngresarIngresarActionPerformed
                if (validarIngreso()) {
                        this.user = buscarPersona(nombreUsuario);
                        abrirPrograma();
                } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
        }// GEN-LAST:event_bottonIngresarIngresarActionPerformed

        // VER CONTRASEÑA
        private void buttonIngresarVerContraseñaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonIngresarVerContraseñaActionPerformed
                verContraseña(inputIngresarContraseña);
        }// GEN-LAST:event_buttonIngresarVerContraseñaActionPerformed

        // MOVERSE DE INGRESO A REGISTRO
        private void bottonIngresarRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bottonIngresarRegistrarseActionPerformed
                this.remove(Ingreso);
                this.add(Registro);
                validate();
                repaint();
        }// GEN-LAST:event_bottonIngresarRegistrarseActionPerformed

        // VER CONTRASEÑA
        private void bottonRegistraseVerContraseñaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bottonRegistraseVerContraseñaActionPerformed
                verContraseña(inputRegistraseContraseña);
        }// GEN-LAST:event_bottonRegistraseVerContraseñaActionPerformed

        // MOVERSE DE REGISTRO A INGRESO
        private void buttonRegistroIngresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonRegistroIngresarActionPerformed
                this.remove(Registro);
                this.add(Ingreso);
                validate();
                repaint();
        }// GEN-LAST:event_buttonRegistroIngresarActionPerformed

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
        private javax.swing.JLabel LABEL_INGRESAR_CONTRASEÑA;
        private javax.swing.JLabel LABEL_INGRESAR_TITULO;
        private javax.swing.JLabel LABEL_INGRESAR_USUARIO;
        private javax.swing.JLabel LABEL_REGISTRARSE_CONTRASEÑA;
        private javax.swing.JLabel LABEL_REGISTRASE_DOCUMENTO;
        private javax.swing.JLabel LABEL_REGISTRASE_TIPO_USUARIO;
        private javax.swing.JLabel LABEL_REGISTRASE_TITULO;
        private javax.swing.JLabel LABEL_REGISTRASE_USUARIO;
        private javax.swing.JLabel MENSAJE_INGRESAR;
        private javax.swing.JPanel PANEL_INGRESAR_BOTONES;
        private javax.swing.JPanel PANEL_INGRESAR_CONTRASEÑA;
        private javax.swing.JPanel PANEL_REGISTRARSE_CONTRASEÑA;
        private javax.swing.JPanel PANEL_REGISTRASE_DOCUMENTO;
        private javax.swing.JPanel PANEL_REGISTRASE_TIPO_USUARIO;
        private javax.swing.JPanel PANEL_REGITRASE_BOTTONES;
        private javax.swing.JPanel Registro;
        private javax.swing.JLabel VACIO_01;
        private javax.swing.JLabel VACIO_02;
        private javax.swing.JLabel VACIO_03;
        private javax.swing.JLabel VACIO_04;
        private javax.swing.JLabel VACIO_06;
        private javax.swing.JButton bottonIngresarIngresar;
        private javax.swing.JButton bottonIngresarRegistrarse;
        private javax.swing.JButton bottonRegistraseVerContraseña;
        private javax.swing.JButton buttonIngresarVerContraseña;
        private javax.swing.JButton buttonRegistroIngresar;
        private javax.swing.JButton buttonRegistroRegistro;
        private javax.swing.JPasswordField inputIngresarContraseña;
        private javax.swing.JTextField inputIngresarUsuario;
        private javax.swing.JTextField inputRegistrarseUsuario;
        private javax.swing.JPasswordField inputRegistraseContraseña;
        private javax.swing.JTextField inputRegistroDocumento;
        private javax.swing.JComboBox inputRegistroTipoDoc;
        private javax.swing.JComboBox inputRegistroTipoUsuario;
        private javax.swing.JTextField inputRegistroUsuarioClave;
        private javax.swing.JLabel toby_png;
        private org.jdesktop.beansbinding.BindingGroup bindingGroup;
        // End of variables declaration//GEN-END:variables
}
