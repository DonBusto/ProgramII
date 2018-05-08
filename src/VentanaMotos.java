import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

public class VentanaMotos extends JFrame {
	private JTextField tfPotencia;
	
	private Moto m;
	public VentanaMotos() {
		
		ImageIcon img = new ImageIcon("deusto.png");
		setIconImage(img.getImage());
		JPanel panel = new JPanel();

		getContentPane().add(panel, BorderLayout.NORTH);
		panel.add(new JLabel(new ImageIcon("BANNER LQ.jpg")));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JLabel lblMarca = new JLabel("Marca: ");
		panel_4.add(lblMarca);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Kawasaki", "Suzuki" }));
		panel_4.add(comboBox);

		final JLabel icMarca = new JLabel("");
		icMarca.setEnabled(false);
		panel_4.add(icMarca);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);

		JLabel lblModelo = new JLabel("Modelo: ");
		panel_5.add(lblModelo);

		final JComboBox comboBox_1 = new JComboBox();

		comboBox_1.setEnabled(true);
		ActionListener cbActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = (String) comboBox.getSelectedItem();// get the selected item
				switch (s) {// check for a match
				case "Kawasaki":
					comboBox_1.setEnabled(true);
					icMarca.setIcon(new ImageIcon("kawasaki.png"));
					icMarca.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1400GTR", "J125ABS", "KX250F" }));
					break;
				case "Suzuki":
					comboBox_1.setEnabled(true);
					icMarca.setIcon(new ImageIcon("suzuki.png"));
					icMarca.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Address", "Burgman", "IntruderC800" }));
				}
			};
		};
		final JLabel icModelo = new JLabel("");
		ActionListener modActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) comboBox_1.getSelectedItem();
				switch (s) {
				case "Address":
					icModelo.setIcon(new ImageIcon("address.png"));
					icModelo.setEnabled(true);
					break;
				case "Burgman":
					icModelo.setIcon(new ImageIcon("burgman.png"));
					icModelo.setEnabled(true);
					break;
				case "IntruderC800":
					icModelo.setIcon(new ImageIcon("intruder.png"));
					icModelo.setEnabled(true);
					break;
				case "1400GTR":
					icModelo.setIcon(new ImageIcon("1400gtr.png"));
					icModelo.setEnabled(true);
					break;
				case "J125ABS":
					icModelo.setIcon(new ImageIcon("j125.png"));
					icModelo.setEnabled(true);
					break;
				case "KX250F":
					icModelo.setIcon(new ImageIcon("kx250f.png"));
					icModelo.setEnabled(true);
					break;
				}
			}
		};
		comboBox.addActionListener(cbActionListener);
		panel_5.add(comboBox_1);

		panel_5.add(icModelo);
		comboBox_1.addActionListener(modActionListener);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);

		JLabel lblPotencia = new JLabel("Potencia: ");
		panel_6.add(lblPotencia);

		tfPotencia = new JTextField();
		panel_6.add(tfPotencia);
		tfPotencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c)||(c == KeyEvent.VK_BACK_SPACE)||(c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});
		tfPotencia.setColumns(3);

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setSize(429, 33);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);

		JLabel lblNewLabel = new JLabel("Cilindrada: ");
		panel_8.add(lblNewLabel);

		final JTextField tfCilindrada = new JTextField();
		panel_8.add(tfCilindrada);
		tfCilindrada.setColumns(4);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);

		JLabel lblPlazas = new JLabel("Peso: ");
		panel_10.add(lblPlazas);

		final JTextField tfPeso = new JTextField();
		tfPeso.setColumns(3);
		panel_10.add(tfPeso);
		tfCilindrada.setColumns(3);
		
		final JCheckBox chckbxEqMusica = new JCheckBox("Equipo de música");
		panel_7.add(chckbxEqMusica);

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);

		JPanel panel_13 = new JPanel();
		panel_9.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));

		JPanel panel_12 = new JPanel();
		panel_13.add(panel_12);

		final JButton btnComprobar = new JButton("Comprobar");

		panel_12.add(btnComprobar);

		final JButton btnCalcularPrecioFinal = new JButton("Calcular precio final");
		panel_12.add(btnCalcularPrecioFinal);
		btnCalcularPrecioFinal.setEnabled(false);

		final JLabel lblElCocheNo = new JLabel("El coche no existe.");
		lblElCocheNo.setVisible(false);
		panel_13.add(lblElCocheNo);
		
		final JButton btnWeb = new JButton("Visitar p\u00E1gina web");
		btnWeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((comboBox_1.getSelectedItem().toString()).equals("1400GTR")){
					try {
						Desktop.getDesktop().browse(new URL("https://www.kawasaki.es/es/products/Sport_Tourer/2016/1400GTR/overview?Uid=0821DQxdXFpYCl1aWl9dXFpbWwleXAlQDFBbXwkOWVlYDVo").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("J125ABS")) {
					try {
						Desktop.getDesktop().browse(new URL("https://www.kawasaki.es/es/products/Scooter/2017/J125/overview?Uid=0960DlELDVheDQ4LWVteXAlRCgpcXFxeDA0JDV5RDlsKUV0").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("KX250F")) {
					try {
						Desktop.getDesktop().browse(new URL("https://www.kawasaki.es/es/products/Motocross/2018/KX250F/overview?Uid=08F2Dg4KUApRWA1eXQxRXA5ZDApdDVlaWgpZCQpaUVxfXFw").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("Address")) {
					try {
						Desktop.getDesktop().browse(new URL("https://moto.suzuki.es/motos/scooter/2018/address/ficha-tecnica/?ib_comercializa=1").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("Burgman")) {
					try {
						Desktop.getDesktop().browse(new URL("https://moto.suzuki.es/motos/scooter/2017/burgman-400/ficha-tecnica/?ib_comercializa=1").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("IntruderC800")) {
					try {
						Desktop.getDesktop().browse(new URL("https://moto.suzuki.es/motos/cruiser/2015/intruder-c800/ficha-tecnica/?ib_comercializa=1").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnWeb.setVisible(false);
		panel_13.add(btnWeb);

		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
		JButton btnLogout = new JButton("Cerrar sesi\u00F3n");
		panel_11.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login l = new Login();
				ImageIcon img = new ImageIcon("deusto_LOGIN.png");
				l.setIconImage(img.getImage());
				l.setResizable(false);
				l.setSize(550, 80);
				l.setVisible(true);
				l.setAdmin(false);				
			}
		});
		btnLogout.setVisible(true);
		btnLogout.setHorizontalAlignment(SwingConstants.RIGHT);
			

		ActionListener comprobar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					m = new Moto((comboBox.getSelectedItem().toString()), (comboBox_1.getSelectedItem().toString()),
							Integer.parseInt(tfPotencia.getText()),
							Integer.parseInt(tfCilindrada.getText()),
							Integer.parseInt(tfPeso.getText()),
							chckbxEqMusica.isSelected());
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				if (Moto.check(m) == true) {
					btnCalcularPrecioFinal.setEnabled(true);
					lblElCocheNo.setVisible(true);
					lblElCocheNo.setText("La moto sí existe.");
					lblElCocheNo.setEnabled(true);
				} else {
					lblElCocheNo.setText("La moto no existe.");
					btnWeb.setVisible(false);
					lblElCocheNo.setVisible(true);
					btnCalcularPrecioFinal.setEnabled(false);
				}
			}

		};
		btnComprobar.addActionListener(comprobar);
		ActionListener precioFinal = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblElCocheNo.setText("El precio final es de " + m.precioFinal() + " euros.");
				btnWeb.setVisible(true);
			}
		};
		btnCalcularPrecioFinal.addActionListener(precioFinal);
		};
	

}
