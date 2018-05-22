import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyStore.Entry;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;

public class Ventana extends JFrame {
	public String marcaCB;
	public String modeloCB;
	private JTextField tfPotencia;
	private Coche c;
	float precioB;

	public float getPrecioB() {
		return precioB;
	}

	public void setPrecioB(float precioB) {
		this.precioB = precioB;
	}

	final JComboBox<ObjetoCombobox> comboBox = new JComboBox<ObjetoCombobox>();
	final JComboBox cbPuertas = new JComboBox();
	final JComboBox cbPlazas = new JComboBox();

	public Timer timer = new Timer();

	public String getMarcaCB() {
		return marcaCB;
	}

	public void setMarcaCB(String marcaCB) {
		this.marcaCB = marcaCB;
	}

	public String getModeloCB() {
		return modeloCB;
	}

	public void setModeloCB(String modeloCB) {
		this.modeloCB = modeloCB;
	}

	public JTextField getTfPotencia() {
		return tfPotencia;
	}

	public void setTfPotencia(JTextField tfPotencia) {
		this.tfPotencia = tfPotencia;
	}

	public Coche getC() {
		return c;
	}

	public void setC(Coche c) {
		this.c = c;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public JComboBox<ObjetoCombobox> getComboBox() {
		return comboBox;
	}

	public JComboBox getCbPuertas() {
		return cbPuertas;
	}

	public JComboBox getCbPlazas() {
		return cbPlazas;
	}

	public Ventana() {

		ImageIcon img = new ImageIcon("deusto.png");

		setIconImage(img.getImage());
		JPanel panel = new JPanel();

		getContentPane().add(panel, BorderLayout.NORTH);

		JButton btnLogout = new JButton("Cerrar sesi\u00F3n");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login l = new Login();
				ImageIcon img = new ImageIcon("deusto_LOGIN.png");
				l.setIconImage(img.getImage());
				l.setResizable(false);
				l.setSize(550, 80);
				l.setAdmin(false);
				l.setVisible(true);

			}
		});
		btnLogout.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnLogout);
		final JLabel labelBanner = new JLabel();
		final ImageIcon[] icons = { new ImageIcon("BANNER LQ.jpg"), new ImageIcon("DEUSTO2LQ.jpg") };
		labelBanner.setIcon(icons[0]);

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				labelBanner.setIcon(icons[1]);
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				labelBanner.setIcon(icons[0]);
			}
		}, 10 * 1000, 10 * 1000);
		labelBanner.setSize(700, 300);
		panel.add(labelBanner);

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
		
		Set<java.util.Map.Entry<String, Coche>> hashSet = Coche.mapaCoches.entrySet();
		for (java.util.Map.Entry<String, Coche> entry : hashSet) {
			comboBox.addItem(new ObjetoCombobox(0, entry.getValue().getMarca().toString()));

		}

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
				Coche.cargarCoches();
				Set<java.util.Map.Entry<String, Coche>> hashSet2 = Coche.mapaCoches.entrySet();

				comboBox_1.removeAllItems();
				for (java.util.Map.Entry<String, Coche> entry : hashSet2) {
					Vehiculo v = new Vehiculo(entry.getValue().getMarca(), entry.getValue().getModelo());
					
					if (v.getMarca().equals(comboBox.getSelectedItem().toString())) {
						for(int i = 0; i<Vehiculo.marcasModelos.size(); i++) {
							if (Vehiculo.marcasModelos.get(i).getMarca().equals(comboBox.getSelectedItem().toString())) {
								comboBox_1.addItem(new ObjetoCombobox(0, Vehiculo.marcasModelos.get(i).getModelo()));
							}
							
						}
					}
				}
				String s = (String) comboBox.getSelectedItem().toString();
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
				String s = comboBox_1.getSelectedItem().toString();
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
		tfPotencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setSize(429, 33);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8);

		JLabel lblNewLabel = new JLabel("Puertas: ");
		panel_8.add(lblNewLabel);

		cbPuertas.setModel(new DefaultComboBoxModel(new String[] { "3", "5" }));
		panel_8.add(cbPuertas);

		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10);

		JLabel lblPlazas = new JLabel("Plazas: ");
		panel_10.add(lblPlazas);

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
				if ((comboBox_1.getSelectedItem().toString()).equals("Serie3")) {
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
						Desktop.getDesktop()
								.browse(new URL("http://www.audi.es/es/web/es/modelos/a1/a1/exterior.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("A4")) {
					try {
						Desktop.getDesktop()
								.browse(new URL("https://www.audi.es/es/web/es/modelos/a4/a4.html").toURI());
					} catch (IOException | URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if ((comboBox_1.getSelectedItem().toString()).equals("A8")) {
					try {
						Desktop.getDesktop()
								.browse(new URL("http://www.audi.es/es/web/es/modelos/a8/nuevo-audi-a8.html").toURI());
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

		ActionListener comprobar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					c = new Coche((comboBox.getSelectedItem().toString()), (comboBox_1.getSelectedItem().toString()),
							Integer.parseInt(tfPotencia.getText()),
							Integer.parseInt(cbPuertas.getSelectedItem().toString()),
							Integer.parseInt(cbPlazas.getSelectedItem().toString()), chckbxGps.isSelected(),
							chckbxLneaDeportiva.isSelected());
				} catch (Exception e) {

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
				try {
					Scanner inputStream = new Scanner(new File("coches.csv"));
					while (inputStream.hasNext()) {
						String data = inputStream.next();
						String[] dataSplit = data.split(";");
						Coche c = new Coche(comboBox.getSelectedItem().toString(),
								comboBox_1.getSelectedItem().toString(), Integer.parseInt(tfPotencia.getText()),
								Integer.parseInt(cbPuertas.getSelectedItem().toString()),
								Integer.parseInt(cbPlazas.getSelectedItem().toString()), chckbxGps.isSelected(),
								(chckbxGps.isSelected()));
						if (Coche.check(c)) {
							precioB = Float.parseFloat(dataSplit[7]);
							if (chckbxGps.isSelected()) {
								precioB *= 1.1;
							}
							if (chckbxLneaDeportiva.isSelected()) {
								precioB *= 1.75;
							}

						}
						if (comboBox.getSelectedItem().toString().equals("BMW")
								|| comboBox.getSelectedItem().toString().equals("Audi")) {
							lblElCocheNo.setText("El precio final es de " + (c.precioFinal() + precioB) + " euros.");
							btnWeb.setVisible(true);
						} else {
							lblElCocheNo.setText("El precio final es de " + (c.precioFinal() + precioB) + " euros.");
							btnWeb.setVisible(false);
						}
					}

					inputStream.close();

				} catch (Exception e2) {

				}

			}

		};
		btnCalcularPrecioFinal.addActionListener(precioFinal);

	}

}
