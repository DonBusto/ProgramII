import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class VentanaAdmin extends JFrame {
	private JTextField tfPotencia;

	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblMarca = new JLabel("Marca: ");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 0;
		gbc_lblMarca.gridy = 0;
		getContentPane().add(lblMarca, gbc_lblMarca);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "BMW", "Audi" }));
		comboBox.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);

		JLabel lblModelo = new JLabel("Modelo: ");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 1;
		getContentPane().add(lblModelo, gbc_lblModelo);

		final JComboBox comboBox_1 = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		comboBox_1.setEnabled(true);
		final ActionListener cbActionListener1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = (String) comboBox.getSelectedItem();// get the selected item
				switch (s) {// check for a match
				case "BMW":
					comboBox_1.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Serie3", "Serie5", "Serie7" }));
					break;
				case "Audi":
					comboBox_1.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "A1", "A4", "A8" }));
				}
			};
		};
		comboBox.addActionListener(cbActionListener1);
		getContentPane().add(comboBox_1, gbc_comboBox_1);

		JLabel lblPotencia = new JLabel("Potencia: ");
		GridBagConstraints gbc_lblPotencia = new GridBagConstraints();
		gbc_lblPotencia.anchor = GridBagConstraints.EAST;
		gbc_lblPotencia.insets = new Insets(0, 0, 5, 5);
		gbc_lblPotencia.gridx = 0;
		gbc_lblPotencia.gridy = 2;
		getContentPane().add(lblPotencia, gbc_lblPotencia);

		tfPotencia = new JTextField();
		GridBagConstraints gbc_tfPotencia = new GridBagConstraints();
		gbc_tfPotencia.insets = new Insets(0, 0, 5, 0);
		gbc_tfPotencia.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPotencia.gridx = 1;
		gbc_tfPotencia.gridy = 2;
		getContentPane().add(tfPotencia, gbc_tfPotencia);
		tfPotencia.setColumns(10);

		JLabel lblPuertas = new JLabel("Puertas: ");
		GridBagConstraints gbc_lblPuertas = new GridBagConstraints();
		gbc_lblPuertas.anchor = GridBagConstraints.EAST;
		gbc_lblPuertas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuertas.gridx = 0;
		gbc_lblPuertas.gridy = 3;
		getContentPane().add(lblPuertas, gbc_lblPuertas);

		final JComboBox cbPuertas = new JComboBox();
		cbPuertas.setModel(new DefaultComboBoxModel(new String[] { "3", "5" }));
		GridBagConstraints gbc_cbPuertas = new GridBagConstraints();
		gbc_cbPuertas.insets = new Insets(0, 0, 5, 0);
		gbc_cbPuertas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPuertas.gridx = 1;
		gbc_cbPuertas.gridy = 3;
		getContentPane().add(cbPuertas, gbc_cbPuertas);

		JLabel lblPlazas = new JLabel("Plazas: ");
		GridBagConstraints gbc_lblPlazas = new GridBagConstraints();
		gbc_lblPlazas.anchor = GridBagConstraints.EAST;
		gbc_lblPlazas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlazas.gridx = 0;
		gbc_lblPlazas.gridy = 4;
		getContentPane().add(lblPlazas, gbc_lblPlazas);

		final JComboBox cbPlazas = new JComboBox();
		cbPlazas.setModel(new DefaultComboBoxModel(new String[] { "2", "5", "7" }));
		GridBagConstraints gbc_cbPlazas = new GridBagConstraints();
		gbc_cbPlazas.insets = new Insets(0, 0, 5, 0);
		gbc_cbPlazas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPlazas.gridx = 1;
		gbc_cbPlazas.gridy = 4;
		getContentPane().add(cbPlazas, gbc_cbPlazas);

		final JCheckBox chckbxGps = new JCheckBox("GPS");
		GridBagConstraints gbc_chckbxGps = new GridBagConstraints();
		gbc_chckbxGps.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGps.gridx = 0;
		gbc_chckbxGps.gridy = 5;
		getContentPane().add(chckbxGps, gbc_chckbxGps);

		final JCheckBox chckbxLneaDeportiva = new JCheckBox("L\u00EDnea deportiva");
		GridBagConstraints gbc_chckbxLneaDeportiva = new GridBagConstraints();
		gbc_chckbxLneaDeportiva.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxLneaDeportiva.gridx = 1;
		gbc_chckbxLneaDeportiva.gridy = 5;
		getContentPane().add(chckbxLneaDeportiva, gbc_chckbxLneaDeportiva);

		final JLabel lblNoPuedesAadir = new JLabel("No puedes a\u00F1adir coches.");
		GridBagConstraints gbc_lblNoPuedesAadir = new GridBagConstraints();
		gbc_lblNoPuedesAadir.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoPuedesAadir.anchor = GridBagConstraints.SOUTH;
		gbc_lblNoPuedesAadir.gridx = 1;
		gbc_lblNoPuedesAadir.gridy = 7;
		getContentPane().add(lblNoPuedesAadir, gbc_lblNoPuedesAadir);
		lblNoPuedesAadir.setVisible(false);

		final JLabel lblNoEresAdministrador = new JLabel("No eres administrador.");
		GridBagConstraints gbc_lblNoEresAdministrador = new GridBagConstraints();
		gbc_lblNoEresAdministrador.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoEresAdministrador.gridx = 1;
		gbc_lblNoEresAdministrador.gridy = 8;
		getContentPane().add(lblNoEresAdministrador, gbc_lblNoEresAdministrador);
		lblNoEresAdministrador.setVisible(false);

		final JLabel lblCierraLaVentana = new JLabel("Cierra la ventana.");
		GridBagConstraints gbc_lblCierraLaVentana = new GridBagConstraints();
		gbc_lblCierraLaVentana.gridx = 1;
		gbc_lblCierraLaVentana.gridy = 9;
		getContentPane().add(lblCierraLaVentana, gbc_lblCierraLaVentana);
		lblCierraLaVentana.setVisible(false);

		JButton btnAadirCoche = new JButton("A\u00F1adir coche");
		GridBagConstraints gbc_btnAadirCoche = new GridBagConstraints();
		gbc_btnAadirCoche.insets = new Insets(0, 0, 5, 0);
		gbc_btnAadirCoche.gridx = 1;
		gbc_btnAadirCoche.gridy = 6;
		ActionListener anadirCoche = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Login.isAdmin() == true) {
					try {
						File file = new File("coches.csv");
						FileWriter writer = new FileWriter(file.getAbsoluteFile(), true); // este true del final nos
																							// permitirá escribir sobre
																							// el fichero a medida que
																							// vamos añadiendo coches
																							// nuevos.
						BufferedWriter bw = new BufferedWriter(writer);
						bw.write(String.valueOf(comboBox.getSelectedItem().toString()));
						bw.write(';');
						bw.write(String.valueOf(comboBox_1.getSelectedItem().toString()));
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
						bw.write('\n');
						bw.close();
						Coche.cargarCoches(); // Volvemos a cargar los elementos del Arraylist
					} catch (Exception e) {

					}
				} else {
					setSize(337, 310);
					lblCierraLaVentana.setVisible(true);
					lblNoEresAdministrador.setVisible(true);
					lblNoPuedesAadir.setVisible(true);
				}

			}

		};
		btnAadirCoche.addActionListener(anadirCoche);
		getContentPane().add(btnAadirCoche, gbc_btnAadirCoche);

	}

}
