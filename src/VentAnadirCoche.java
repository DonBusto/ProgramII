import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class VentAnadirCoche extends JFrame {
	private JTextField tfMarca;
	private JTextField tfModelo;
	private JTextField tfPotencia;
	private JTextField tfPrecioBase;
	private JTextField tfIcono;

	public VentAnadirCoche() {
		ImageIcon img = new ImageIcon("deusto_COCHES.png");
		setIconImage(img.getImage());
		setTitle("Añadir coche diferente al catálogo");
		setSize(223, 393);
		getContentPane().setLayout(null);

		JButton btnAnadirCoche = new JButton("A\u00F1adir coche");
		btnAnadirCoche.setBounds(12, 240, 170, 35);

		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setBounds(12, 13, 56, 16);
		getContentPane().add(lblNewLabel);

		tfMarca = new JTextField();
		tfMarca.setBounds(70, 10, 116, 22);
		getContentPane().add(tfMarca);
		tfMarca.setColumns(10);

		tfModelo = new JTextField();
		tfModelo.setBounds(70, 59, 116, 22);
		getContentPane().add(tfModelo);
		tfModelo.setColumns(10);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 62, 56, 16);
		getContentPane().add(lblModelo);

		JLabel lblNewLabel_2 = new JLabel("Potencia:");
		lblNewLabel_2.setBounds(12, 94, 56, 16);
		getContentPane().add(lblNewLabel_2);

		tfPotencia = new JTextField();
		tfPotencia.setBounds(70, 91, 116, 22);
		getContentPane().add(tfPotencia);
		tfPotencia.setColumns(10);

		JLabel lblPuertas = new JLabel("Puertas:");
		lblPuertas.setBounds(12, 125, 56, 16);
		getContentPane().add(lblPuertas);

		final JComboBox cbPuertas = new JComboBox();
		cbPuertas.setModel(new DefaultComboBoxModel(new String[] { "2", "3", "5" }));
		cbPuertas.setBounds(70, 122, 116, 22);
		getContentPane().add(cbPuertas);

		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setBounds(12, 156, 56, 16);
		getContentPane().add(lblPlazas);

		final JComboBox cbPlazas = new JComboBox();
		cbPlazas.setModel(new DefaultComboBoxModel(new String[] { "5", "7" }));
		cbPlazas.setBounds(70, 153, 116, 22);
		getContentPane().add(cbPlazas);

		final JLabel lblNoTienesPermiso = new JLabel("No tienes permiso.");
		lblNoTienesPermiso.setBounds(33, 276, 181, 24);
		lblNoTienesPermiso.setVisible(false);
		getContentPane().add(lblNoTienesPermiso);

		final JCheckBox chckbxGps = new JCheckBox("GPS");
		chckbxGps.setBounds(12, 174, 56, 25);
		getContentPane().add(chckbxGps);

		final JCheckBox chckbxLneaDeportiva = new JCheckBox("L\u00EDnea deportiva");
		chckbxLneaDeportiva.setBounds(70, 174, 120, 25);
		getContentPane().add(chckbxLneaDeportiva);

		tfPrecioBase = new JTextField();
		tfPrecioBase.setBounds(71, 208, 82, 22);
		getContentPane().add(tfPrecioBase);
		tfPrecioBase.setColumns(10);

		JLabel lblPrecioBase = new JLabel("Precio base:");
		lblPrecioBase.setBounds(0, 211, 94, 16);
		getContentPane().add(lblPrecioBase);

		JLabel label = new JLabel("\u20AC");
		label.setBounds(158, 211, 56, 16);
		getContentPane().add(label);
		btnAnadirCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.isAdmin() == true) {
					try {
						File file = new File("coches.csv");
						FileWriter writer = new FileWriter(file.getAbsoluteFile(), true); // este true del final nos
																							// permitirá escribir sobre
																							// el fichero a medida que
																							// vamos añadiendo coches
																							// nuevos.
						BufferedWriter bw = new BufferedWriter(writer);
						if(!(tfMarca.getText().equals("BMW")||tfMarca.getText().equals("Audi"))) {
							bw.write(String.valueOf(tfMarca.getText()));
							bw.write(';');
							bw.write(String.valueOf(tfModelo.getText()));
							bw.write(';');
							bw.write(String.valueOf(tfPotencia.getText()));
							bw.write(';');
							bw.write(String.valueOf(cbPuertas.getSelectedItem().toString()));
							bw.write(';');
							bw.write(String.valueOf(cbPlazas.getSelectedItem().toString()));
							bw.write(';');
							bw.write(String.valueOf(chckbxGps.isSelected()));
							bw.write(';');
							bw.write(String.valueOf(chckbxLneaDeportiva.isSelected()));
							bw.write(';');
							bw.write(String.valueOf(tfPrecioBase.getText()));
							Vehiculo.setPrecioBase(Integer.parseInt(tfPrecioBase.getText()));
							bw.write('\n');
							bw.close();
						} else {
							lblNoTienesPermiso.setText("Añádelo en la otra ventana.");
							lblNoTienesPermiso.setVisible(true);
						}
						
						Coche.cargarCoches(); // Volvemos a cargar los elementos del Arraylist
						Coche.anadirAHashmap(); //Cargamos el HashMap de nuevo
					} catch (Exception ee) {

					}
				} else {
					setSize(220, 360);
					lblNoTienesPermiso.setText("No tienes permiso.");
					lblNoTienesPermiso.setVisible(true);
				}
			}
		});
		getContentPane().add(btnAnadirCoche);

		JLabel lblModelo_1 = new JLabel("Icono: ");
		lblModelo_1.setBounds(12, 33, 56, 22);
		getContentPane().add(lblModelo_1);

		tfIcono = new JTextField();
		tfIcono.setBounds(70, 33, 56, 22);
		getContentPane().add(tfIcono);
		tfIcono.setColumns(10);

		JButton btnElegir = new JButton("...");
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter png = new FileNameExtensionFilter("Imágenes(.png)", ".png");
				fc.addChoosableFileFilter(png);
				FileNameExtensionFilter jpg = new FileNameExtensionFilter("Imágenes(.jpg)", ".jpg");
				fc.addChoosableFileFilter(jpg);
				FileNameExtensionFilter jpeg = new FileNameExtensionFilter("Imágenes(.jpeg)", ".jpeg");
				fc.addChoosableFileFilter(jpeg);
				fc.setFileFilter(png);
				int seleccion = fc.showOpenDialog(getContentPane());
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File fichero = fc.getSelectedFile();
					tfIcono.setText(fichero.getAbsolutePath());
				}
				
				fc.setBounds(600, 100, 600, 300);
				fc.setVisible(true);
				
			}
		});
		btnElegir.setBounds(129, 32, 57, 25);
		getContentPane().add(btnElegir);

	}
}
