import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.FlowLayout;

public class Login extends JFrame {
	private boolean admin = false;
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

		final JButton btnLogin = new JButton("Login");
		panel_2.add(btnLogin);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 40, 432, 87);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

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
		btnMotos.addActionListener(motosAl);

		ActionListener login = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty()) {
					tipoUsuario.setText("Introduce un usuario y una contraseña.");
					panel_4.setVisible(false);
					tipoUsuario.setVisible(true);
				} else {
					if ((textField.getText().equals("jorge")) && (passwordField.getText().equals("1234"))) {
						admin = true;
						System.out.println(passwordField.getText());
						tipoUsuario.setText("Eres administrador del concesionario.");
						tipoUsuario.setVisible(true);
						panel_4.setVisible(true);

					} else {
						if ((textField.getText().equals("eguiluz")) && (passwordField.getText().equals("4321"))) {
							admin = false;
							System.out.println(passwordField.getText());
							tipoUsuario.setText("Eres cliente del concesionario.");
							tipoUsuario.setVisible(true);
							panel_4.setVisible(true);
					} else {
						tipoUsuario.setText("No eres cliente del concesionario.");
						panel_4.setVisible(false);
						tipoUsuario.setVisible(true);
					}
					}
				}
			}
		};
		btnLogin.addActionListener(login);
	}

	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
			if(admin==true) {
				vAd.setVisible(true);
			}else {
				vAd.setVisible(false);
			}
			vc.setTitle("Consultorio de coches");
			vc.setSize(700, 350);
			vc.setResizable(false);
			vc.setVisible(true);
			setVisible(false);
		}
	};
	ActionListener motosAl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			VentanaMotos vm = new VentanaMotos();
			VentAdminMotos vAdM = new VentAdminMotos();
			ImageIcon img = new ImageIcon("deusto_MOTOS.png");
			vAdM.setIconImage(img.getImage());
			vAdM.setTitle("Opción de añadir moto");
			vAdM.setResizable(false);
			vAdM.setBounds(500, 500, 230, 300);
			if(admin==true) {
				vAdM.setVisible(true);
			}else {
				vAdM.setVisible(false);
			}
			vm.setTitle("Consultorio de motos");
			vm.setSize(700, 350);
			vm.setResizable(false);
			vm.setVisible(true);
			setVisible(false);
		}
	};
}
