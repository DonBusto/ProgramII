import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

import javax.swing.JFrame;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		Coche.cargarCoches();
		Moto.cargarMotos();
		// System.out.println(Coche.coches.get(0).getMarca());
		Coche c = new Coche("BMW", "Serie7", 230, 5, 5, true, true);
		if (Coche.check(c) == true) {
			System.out.println("El coche está en venta.");
			// Aquí podría poner un "¿desea calcular el precio?" pero prefiero hacerlo con
			// los botones después
			System.out.println("El precio final es de " + c.precioFinal() + " euros.");
		} else {
			System.out.println("El coche no existe.");
		}
		Login l = new Login();
		l.setSize(500, 200);
		l.setVisible(true);
	}

}
