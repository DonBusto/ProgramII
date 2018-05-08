import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Coche extends Vehiculo {
	private int puertas;
	private int plazas;
	private boolean gps;
	private boolean lineaDeportiva;
	public static ArrayList<Coche> coches = new ArrayList<Coche>();

	Coche(String marca, String modelo, int potencia, int puertas, int plazas, boolean gps, boolean lineaDeportiva) {
		super(marca, modelo, potencia);
		this.setPuertas(puertas);
		this.plazas = plazas;
		this.gps = gps;
		this.lineaDeportiva = lineaDeportiva;
	}

	private int comprobarPuertas(int puertas) {
		if (puertas == 3 || puertas == 5) {
			return puertas;

		} else {
			return 5;
		}
	}

	private int comprobarPlazas(int plazas) {
		if (plazas == 2 || plazas == 5 || plazas == 7) {
			return plazas;

		} else {
			return 5;
		}
	}

	public float precioFinal() {
		float precioFinal = super.precioFinal();
		if (plazas == 2) {
			return precioFinal;
		}
		if (plazas == 5) {
			precioFinal += 1000;
		}
		if (plazas == 7) {
			precioFinal += 3000;
		}
		if (gps == true) {
			precioFinal = (float) (precioFinal * 1.1);
		}
		if (lineaDeportiva == true) {
			precioFinal = (float) (precioFinal * 1.75);
		}
		return precioFinal;
	}

	public static void cargarCoches() {
		File file = new File("coches.csv");
		{

			try {
				Scanner inputStream = new Scanner(file);
				while (inputStream.hasNext()) {
					String data = inputStream.next();
					String[] dataSplit = data.split(";");
					int potenciaArray = Integer.parseInt(dataSplit[2]);
					int puertasArray = Integer.parseInt(dataSplit[3]);
					int plazasArray = Integer.parseInt(dataSplit[4]);
					boolean gpsArray = Boolean.parseBoolean(dataSplit[5]);
					boolean lineaDeporArray = Boolean.parseBoolean(dataSplit[6]);
					Coche c = new Coche(dataSplit[0], dataSplit[1], potenciaArray, puertasArray, plazasArray, gpsArray,
							lineaDeporArray);
					System.out.println("Catálogo: ");
					System.out.println(" Marca: " + dataSplit[0] + " Modelo: " + dataSplit[1] + " Potencia: "
							+ potenciaArray + " Puertas: " + puertasArray + " Plazas: " + plazasArray + " GPS: "
							+ gpsArray + " Línea deportiva: " + lineaDeporArray);
					coches.add(c);
				}
				inputStream.close();

			} catch (FileNotFoundException e) {

			}
		}
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public boolean isLineaDeportiva() {
		return lineaDeportiva;
	}

	public void setLineaDeportiva(boolean lineaDeportiva) {
		this.lineaDeportiva = lineaDeportiva;
	}

	public static ArrayList<Coche> getCoches() {
		return coches;
	}

	public static void setCoches(ArrayList<Coche> coches) {
		Coche.coches = coches;
	}

	/**
	 * Ahora, para no hacer un for encima de otro continuamente para ir verificando
	 * si el coche cumple todas las características para venderse en el
	 * concesionario, hacemos un "Generate hashCode and equals" y posteriormente un
	 * boolean "check" para ver si cada elemento del array de coches cumple todo.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (gps ? 1231 : 1237);
		result = prime * result + (lineaDeportiva ? 1231 : 1237);
		result = prime * result + plazas;
		result = prime * result + puertas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (gps != other.gps)
			return false;
		if (lineaDeportiva != other.lineaDeportiva)
			return false;
		if (plazas != other.plazas)
			return false;
		if (puertas != other.puertas)
			return false;
		return true;
	}

	/**
	 * Comprueba si un coche dado existe en la lista c es el Coche a comprobar
	 * Devuelve true si existe, false si no
	 */
	public static boolean check(Coche c) {
		for (int i = 0; i < Coche.coches.size(); i++) {
			if (c.equals(Coche.coches.get(i))) {
				return true;
			}
		}
		return false;
	}

}