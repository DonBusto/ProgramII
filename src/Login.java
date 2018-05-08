import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Component;
import java.awt.FlowLayout;

public class Login extends JFrame {
	public static boolean admin = false;
	private JTextField textField;
	private JPasswordField passwordField;
	private final JPanel panel_2 = new JPanel();

	@SuppressWarnings("deprecation")
	public Login() {
		setTitle("Inicio de sesión");
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 47);
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblUsuario = new JLabel("Usuario:");
		panel_2.add(lblUsuario);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(8);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		panel_2.add(lblContrasea);

		passwordField = new JPasswordField();
		panel_2.add(passwordField);
		passwordField.setColumns(4);

		final JCheckBox chckbxAdmin = new JCheckBox("Admin");
		panel_2.add(chckbxAdmin);

		final JButton btnLogin = new JButton("Login");
		panel_2.add(btnLogin);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 40, 497, 112);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		final JPanel panel_7 = new JPanel();
		panel_7.setVisible(true);
		panel_3.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		final JPanel panel_6 = new JPanel();
		panel_7.add(panel_6);
		panel_6.setVisible(false);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		JLabel lblContraseaDeAdministradores = new JLabel("Contrase\u00F1a de administradores: ");
		panel_6.add(lblContraseaDeAdministradores);

		final JLabel lblContraseaIncorrectaNo = new JLabel(
				"Contrase\u00F1a incorrecta. No se puede a\u00F1adir al administrador.");
		panel_3.add(lblContraseaIncorrectaNo);
		lblContraseaIncorrectaNo.setVisible(false);

		tfPassAdmin = new JPasswordField();
		panel_6.add(tfPassAdmin);
		tfPassAdmin.setColumns(8);

		JButton btnAadirAdministrador = new JButton("A\u00F1adir administrador");
		btnAadirAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfPassAdmin.getText().equals("program2")) {
					try {
						File file = new File("usuarios.csv");
						FileWriter writer = new FileWriter(file.getAbsoluteFile(), true); // este true del final nos
																							// permitirá escribir sobre
																							// el fichero a medida que
																							// vamos añadiendo coches
																							// nuevos.
						BufferedWriter bw = new BufferedWriter(writer);
						bw.write(String.valueOf(textField.getText()));
						bw.write(';');
						bw.write(String.valueOf(passwordField.getText()));
						bw.write(';');
						bw.write(String.valueOf(chckbxAdmin.isSelected()));
						bw.write(';');
						bw.write('\n');
						bw.close();
						Usuario.cargarUsuario(); // Volvemos a cargar los elementos del Arraylist
						panel_6.setVisible(false);
						lblContraseaIncorrectaNo.setText("Administrador del concesionario añadido con éxito.");
						lblContraseaIncorrectaNo.setVisible(true);
					} catch (Exception e2) {

					}
				} else {
					panel_6.setVisible(false);
					lblContraseaIncorrectaNo.setVisible(true);
				}
			}
		});
		panel_6.add(btnAadirAdministrador);

		final JLabel tipoUsuario = new JLabel("");
		panel_3.add(tipoUsuario);
		tipoUsuario.setVisible(false);

		final JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_1.add(panel_4);

		JButton btnCoches = new JButton("Coches");
		panel_4.add(btnCoches);
		btnCoches.addActionListener(cochesAl);
		JButton btnMotos = new JButton("Motos");
		panel_4.add(btnMotos);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(433, 0, 99, 47);
		getContentPane().add(panel_5);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblContraseaIncorrectaNo.setVisible(false);
				if (textField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
					setSize(550, 130);
					tipoUsuario.setText("Introduce un usuario y una contraseña.");
					panel_4.setVisible(false);
					tipoUsuario.setVisible(true);
				}
				if (chckbxAdmin.isSelected()) {
					setSize(550, 150);
					panel_7.setVisible(true);
					panel_6.setVisible(true);
				} else {
					if (!((passwordField.getText().trim().isEmpty()) || (textField.getText().trim().isEmpty()))) {
						try {
							setSize(550, 130);
							File file = new File("usuarios.csv");
							FileWriter writer = new FileWriter(file.getAbsoluteFile(), true); // este true del final nos
																								// permitirá escribir
																								// sobre el fichero a
																								// medida que vamos
																								// añadiendo coches
																								// nuevos.
							BufferedWriter bw = new BufferedWriter(writer);
							bw.write(String.valueOf(textField.getText()));
							bw.write(';');
							bw.write(String.valueOf(passwordField.getText()));
							bw.write(';');
							bw.write(String.valueOf(chckbxAdmin.isSelected()));
							bw.write(';');
							bw.write('\n');
							bw.close();
							Usuario.cargarUsuario(); // Volvemos a cargar los elementos del Arraylist
							tipoUsuario.setText("Usuario registrado. Vuelva a introducir sus credenciales.");
							textField.setText("");
							passwordField.setText("");
							panel_4.setVisible(false);
							tipoUsuario.setVisible(true);
						} catch (Exception e) {

						}
					}
				}
			}
		});
		panel_5.add(btnRegistrarse);
		btnMotos.addActionListener(motosAl);

		ActionListener login = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_6.setVisible(false);
				lblContraseaIncorrectaNo.setVisible(false);
				Usuario.cargarUsuario();
				try {
					Usuario u = new Usuario(textField.getText(), passwordField.getText(), chckbxAdmin.isSelected());
					if (textField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
						setSize(550, 130);
						tipoUsuario.setText("Introduce un usuario y una contraseña.");
						panel_4.setVisible(false);
						tipoUsuario.setVisible(true);
					} else {
						if (Usuario.check(u)) {
							setSize(550, 180);
							if (u.admin == true) {
								admin = true;
								tipoUsuario.setText("Eres administrador del concesionario.");
								tipoUsuario.setVisible(true);
								panel_4.setVisible(true);
							} else {
								admin = false;
								tipoUsuario.setText("Eres cliente del concesionario.");
								tipoUsuario.setVisible(true);
								panel_4.setVisible(true);
							}
						} else {
							setSize(550, 130);
							tipoUsuario.setText("Usuario o contraseña incorrectos (sino, mira bien si eres admin).");
							tipoUsuario.setVisible(true);
						}
					}
				} catch (Exception e) {

				}
			}
		};
		btnLogin.addActionListener(login);
	}

	public static boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		Login.admin = admin;
	}

	ActionListener cochesAl = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Ventana vc = new Ventana();
			VentanaAdmin vAd = new VentanaAdmin();
			ImageIcon img = new ImageIcon("deusto_COCHES.png");
			vAd.setIconImage(img.getImage());
			vAd.setTitle("Opción de añadir coche");
			vAd.setBounds(500, 500, 230, 300);
			if (admin == true) {
				vAd.setVisible(true);
			} else {
				vAd.dispose();
			}
			vc.setTitle("Consultorio de coches");
			vc.setSize(700, 350);
			vc.setResizable(false);
			vc.setVisible(true);

			dispose();
		}
	};
	ActionListener motosAl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			VentanaMotos vm = new VentanaMotos();
			VentAdminMotos vAdM = new VentAdminMotos();
			vm.setSize(700, 350);
			ImageIcon img = new ImageIcon("deusto_MOTOS.png");
			vAdM.setIconImage(img.getImage());
			vAdM.setTitle("Opción de añadir moto");
			vAdM.setResizable(false);
			vAdM.setBounds(500, 500, 230, 300);
			if (admin == true) {
				vAdM.setVisible(true);
				vm.setSize(700, 400);
			} else {
				// System.out.println("no eres admin");
				// vAdM.setVisible(false);
				vAdM.dispose();
			}
			vm.setTitle("Consultorio de motos");
			vm.setResizable(false);
			vm.setVisible(true);
			dispose();
		}
	};
	private JTextField tfPassAdmin;
}
