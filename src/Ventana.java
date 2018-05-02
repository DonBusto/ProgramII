import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Ventana extends JFrame {
	private JTextField tfPotencia;
	private Coche c;

	public Ventana() {
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "BMW", "Audi" }));
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

				String s = (String) comboBox.getSelectedItem();
				switch (s) {
				case "BMW":
					comboBox_1.setEnabled(true);
					icMarca.setIcon(new ImageIcon("bmw.png"));
					icMarca.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Serie3", "Serie5", "Serie7" }));
					break;
				case "Audi":
					comboBox_1.setEnabled(true);
					icMarca.setIcon(new ImageIcon("audi.png"));
					icMarca.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "A1", "A4", "A8" }));
				}
			};
		};
		final JLabel icModelo = new JLabel("");
		ActionListener modActionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) comboBox_1.getSelectedItem();
				switch (s) {
				case "A1":
					icModelo.setIcon(new ImageIcon("a1ok.png"));
					icModelo.setEnabled(true);
					break;
				case "A4":
					icModelo.setIcon(new ImageIcon("A4.png"));
					icModelo.setEnabled(true);
					break;
				case "A8":
					icModelo.setIcon(new ImageIcon("A8.png"));
					icModelo.setEnabled(true);
					break;
				case "Serie3":
					icModelo.setIcon(new ImageIcon("serie3.png"));
					icModelo.setEnabled(true);
					break;
				case "Serie5":
					icModelo.setIcon(new ImageIcon("serie5.png"));
					icModelo.setEnabled(true);
					break;
				case "Serie7":
					icModelo.setIcon(new ImageIcon("serie7.png"));
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
		tfPotencia.setColumns(3);

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setSize(429, 33);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);

		JLabel lblNewLabel = new JLabel("Puertas: ");
		panel_8.add(lblNewLabel);

		final JComboBox cbPuertas = new JComboBox();
		cbPuertas.setModel(new DefaultComboBoxModel(new String[] { "3", "5" }));
		panel_8.add(cbPuertas);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);

		JLabel lblPlazas = new JLabel("Plazas: ");
		panel_10.add(lblPlazas);

		final JComboBox cbPlazas = new JComboBox();
		cbPlazas.setModel(new DefaultComboBoxModel(new String[] { "2", "5", "7" }));
		panel_10.add(cbPlazas);

		final JCheckBox chckbxGps = new JCheckBox("GPS");
		panel_7.add(chckbxGps);

		final JCheckBox chckbxLneaDeportiva = new JCheckBox("L\u00EDnea deportiva");
		panel_7.add(chckbxLneaDeportiva);

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
				if((comboBox_1.getSelectedItem().toString()).equals("Serie3")){
					try {
						Desktop.getDesktop().browse(new URL("http://www.bmw.es/es/coches-bmw/serie-3.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("Serie5")) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.bmw.es/es/coches-bmw/serie-5.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("Serie7")) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.bmw.es/es/coches-bmw/serie-7.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("A1")) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.audi.es/es/web/es/modelos/a1/a1/exterior.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("A4")) {
					try {
						Desktop.getDesktop().browse(new URL("https://www.audi.es/es/web/es/modelos/a4/a4.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("A8")) {
					try {
						Desktop.getDesktop().browse(new URL("http://www.audi.es/es/web/es/modelos/a8/nuevo-audi-a8.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnWeb.setVisible(false);
		panel_13.add(btnWeb);

		System.out.println(comboBox.getSelectedItem().toString());
		JPanel panel_11 = new JPanel();
		panel_2.add(panel_11);
			

		ActionListener comprobar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					c = new Coche((comboBox.getSelectedItem().toString()), (comboBox_1.getSelectedItem().toString()),
							Integer.parseInt(tfPotencia.getText()),
							Integer.parseInt(cbPuertas.getSelectedItem().toString()),
							Integer.parseInt(cbPlazas.getSelectedItem().toString()), chckbxGps.isSelected(),
							chckbxLneaDeportiva.isSelected());
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
				if (Coche.check(c) == true) {
					btnCalcularPrecioFinal.setEnabled(true);
					lblElCocheNo.setVisible(true);
					lblElCocheNo.setText("El coche sí existe.");
					lblElCocheNo.setEnabled(true);
				} else {
					lblElCocheNo.setText("El coche no existe.");
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
				lblElCocheNo.setText("El precio final es de " + c.precioFinal() + " euros.");
				btnWeb.setVisible(true);
			}
		};
		btnCalcularPrecioFinal.addActionListener(precioFinal);
		};
	
}
