import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Moto extends Vehiculo {
	private int cilindrada;
	private int peso;
	private boolean eqMusica;
	public static ArrayList<Moto> motos = new ArrayList<Moto>();
	

	public boolean isEqMusica() {
		return eqMusica;
	}

	public void setEqMusica(boolean eqMusica) {
		this.eqMusica = eqMusica;
	}

	public Moto(String marca, String modelo, int potencia, int cilindrada, int peso, boolean eqMusica) {
		super(marca, modelo, potencia);
		this.cilindrada = cilindrada;
		this.peso = peso;
		this.setEqMusica(eqMusica);
		// TODO Auto-generated constructor stub
	}

	public float precioFinal() {
		float precioFinal = (super.precioFinal());
		if (cilindrada > 0 && cilindrada < 50) {
			precioFinal += 500;
		}
		if (cilindrada > 50 && cilindrada < 150) {
			precioFinal += 1000;
		}
		if (cilindrada > 150 && cilindrada < 250) {
			precioFinal += 1500;
		}
		if (cilindrada > 250) {
			precioFinal += 2000;
		}
		if (cilindrada < 0) {
			System.out.println("No se pudo calcular el precio final. No existen motos con esa cilindrada.");
		}
		if (peso < 100 || peso > 400) {
			System.out.println("No se pudo calcular el precio final. No existen motos con ese peso.");
		}
		if (peso > 100 && peso < 200) {
			precioFinal += 400;
		}
		if (peso > 200 && peso < 300) {
			precioFinal += 800;
		}
		if (peso > 300 && peso < 400) {
			precioFinal += 1400;
		}
		if (eqMusica == true) {
			precioFinal *= 1.25;
		}
		return precioFinal;
	}

	public static void cargarMotos() {
		File file = new File("motos.csv");
		{
			try {
				Scanner inputStream = new Scanner(file);
				while (inputStream.hasNext()) {
					String dataM = inputStream.next();
					String[] dataSplitMoto = dataM.split(";");
					int potenciaArray = Integer.parseInt(dataSplitMoto[2]);
					int cilindradaArray = Integer.parseInt(dataSplitMoto[3]);
					int pesoArray = Integer.parseInt(dataSplitMoto[4]);
					boolean eqMusicaArray = Boolean.parseBoolean(dataSplitMoto[5]);
					Moto m = new Moto(dataSplitMoto[0], dataSplitMoto[1], potenciaArray, cilindradaArray, pesoArray,
							eqMusicaArray);
					System.out.println(" Marca: " + dataSplitMoto[0] + " Modelo: " + dataSplitMoto[1] + " Potencia: "
							+ potenciaArray + " Cilindrada: " + cilindradaArray + " Peso: " + pesoArray
							+ " Equipo de música: " + eqMusicaArray);
					motos.add(m);
				}
				inputStream.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
		}
	}
/**Ahora, para no hacer un for encima de otro continuamente para ir
 * verificando si la moto cumple todas las características para venderse en
 * el concesionario, hacemos un "Generate hashCode and equals"  y un check para ver si
 * cada elemento del array de motos cumple todo. 
 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cilindrada;
		result = prime * result + (eqMusica ? 1231 : 1237);
		result = prime * result + peso;
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
		Moto other = (Moto) obj;
		if (cilindrada != other.cilindrada)
			return false;
		if (eqMusica != other.eqMusica)
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}
	public static boolean check(Moto m) {
		for(int i = 0; i< Moto.motos.size(); i++) {
			if(m.equals(Moto.motos.get(i))) {
				return true;
			}
		}
		return false;
	}

}
