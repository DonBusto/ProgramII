import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		Coche.cargarCoches();
		Coche.anadirAHashmap();
		Moto.cargarMotos();
		Login l = new Login();
		ImageIcon img = new ImageIcon("deusto_LOGIN.png");
		l.setIconImage(img.getImage());
		l.setResizable(false);
		l.setSize(550, 80);
		l.setVisible(true);
	}
}
