import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentAdminMotos extends JFrame{
	private JTextField tfPotencia;
	private JTextField tfCilindrada;
	private JTextField tfPeso;

	public VentAdminMotos() {
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kawasaki", "Suzuki"}));
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
				case "Kawasaki":
					comboBox_1.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1400GTR", "J125ABS", "KX250F" }));
					break;
				case "Suzuki":
					comboBox_1.setEnabled(true);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Address", "Burgman", "IntruderC800" }));
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
		tfPotencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(!(Character.isDigit(c)||(c == KeyEvent.VK_BACK_SPACE)||(c == KeyEvent.VK_DELETE))) {
					evt.consume();
				}
			}
		});
		GridBagConstraints gbc_tfPotencia = new GridBagConstraints();
		gbc_tfPotencia.insets = new Insets(0, 0, 5, 0);
		gbc_tfPotencia.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPotencia.gridx = 1;
		gbc_tfPotencia.gridy = 2;
		getContentPane().add(tfPotencia, gbc_tfPotencia);
		tfPotencia.setColumns(10);

		JLabel lblCilindrada = new JLabel("Cilindrada:");
		GridBagConstraints gbc_lblCilindrada = new GridBagConstraints();
		gbc_lblCilindrada.anchor = GridBagConstraints.EAST;
		gbc_lblCilindrada.insets = new Insets(0, 0, 5, 5);
		gbc_lblCilindrada.gridx = 0;
		gbc_lblCilindrada.gridy = 3;
		getContentPane().add(lblCilindrada, gbc_lblCilindrada);
		
		tfCilindrada = new JTextField();
		GridBagConstraints gbc_tfCilindrada = new GridBagConstraints();
		gbc_tfCilindrada.insets = new Insets(0, 0, 5, 0);
		gbc_tfCilindrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCilindrada.gridx = 1;
		gbc_tfCilindrada.gridy = 3;
		getContentPane().add(tfCilindrada, gbc_tfCilindrada);
		tfCilindrada.setColumns(10);

		JLabel lblPeso = new JLabel("Peso: ");
		GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.anchor = GridBagConstraints.EAST;
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 0;
		gbc_lblPeso.gridy = 4;
		getContentPane().add(lblPeso, gbc_lblPeso);
		
		tfPeso = new JTextField();
		GridBagConstraints gbc_tfPeso = new GridBagConstraints();
		gbc_tfPeso.anchor = GridBagConstraints.NORTH;
		gbc_tfPeso.insets = new Insets(0, 0, 5, 0);
		gbc_tfPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPeso.gridx = 1;
		gbc_tfPeso.gridy = 4;
		getContentPane().add(tfPeso, gbc_tfPeso);
		tfPeso.setColumns(10);

		final JCheckBox chckbxEqMusica = new JCheckBox("Equipo de m\u00FAsica");
		GridBagConstraints gbc_chckbxEqMusica = new GridBagConstraints();
		gbc_chckbxEqMusica.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxEqMusica.gridx = 1;
		gbc_chckbxEqMusica.gridy = 5;
		getContentPane().add(chckbxEqMusica, gbc_chckbxEqMusica);
		
		final JLabel lblNoEresAdministrador = new JLabel("No eres administrador.");
		GridBagConstraints gbc_lblNoEresAdministrador = new GridBagConstraints();
		gbc_lblNoEresAdministrador.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoEresAdministrador.gridx = 1;
		gbc_lblNoEresAdministrador.gridy = 7;
		getContentPane().add(lblNoEresAdministrador, gbc_lblNoEresAdministrador);
		lblNoEresAdministrador.setVisible(false);
		
		JButton btnAadirMoto = new JButton("A\u00F1adir moto");
		GridBagConstraints gbc_btnAadirMoto = new GridBagConstraints();
		gbc_btnAadirMoto.insets = new Insets(0, 0, 5, 0);
		gbc_btnAadirMoto.gridx = 1;
		gbc_btnAadirMoto.gridy = 6;
		
		final JLabel lblNoPuedesAadir = new JLabel("No puedes a\u00F1adir motos.");
		GridBagConstraints gbc_lblNoPuedesAadir = new GridBagConstraints();
		gbc_lblNoPuedesAadir.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoPuedesAadir.gridx = 1;
		gbc_lblNoPuedesAadir.gridy = 8;
		lblNoPuedesAadir.setVisible(false);
		getContentPane().add(lblNoPuedesAadir, gbc_lblNoPuedesAadir);
		
		final JLabel lblCierraLaVentana = new JLabel("Cierra la ventana.");
		GridBagConstraints gbc_lblCierraLaVentana = new GridBagConstraints();
		gbc_lblCierraLaVentana.gridx = 1;
		gbc_lblCierraLaVentana.gridy = 9;
		getContentPane().add(lblCierraLaVentana, gbc_lblCierraLaVentana);
		lblCierraLaVentana.setVisible(false);
		
		ActionListener anadirMoto = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Login.isAdmin() == true) {
					try {
						File file = new File("motos.csv");
						FileWriter writer = new FileWriter(file.getAbsoluteFile(), true); //este true del final nos permitirá escribir sobre el fichero a medida que vamos añadiendo coches nuevos.
						BufferedWriter bw = new BufferedWriter(writer);
						bw.write(String.valueOf(comboBox.getSelectedItem().toString()));
						bw.write(';');
						bw.write(String.valueOf(comboBox_1.getSelectedItem().toString()));
						bw.write(';');
						bw.write(String.valueOf(tfPotencia.getText()));
						bw.write(';');
						bw.write(String.valueOf(tfCilindrada.getText()));
						bw.write(';');
						bw.write(String.valueOf(tfPeso.getText()));
						bw.write(';');
						bw.write(String.valueOf(chckbxEqMusica.isSelected()));
						bw.write(';');
						bw.write('\n');
						bw.close();
						Moto.cargarMotos(); //Volvemos a cargar los elementos del Arraylist
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					lblNoEresAdministrador.setVisible(true);
					lblCierraLaVentana.setVisible(true);
					lblNoPuedesAadir.setVisible(true);
				}
				
			}
		};
		btnAadirMoto.addActionListener(anadirMoto);
		getContentPane().add(btnAadirMoto, gbc_btnAadirMoto);
		
		
		
		

	}
}
