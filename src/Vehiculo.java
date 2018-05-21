import java.io.File;
import java.util.Scanner;

public class Vehiculo {
	private String marca;
	private String modelo;
	private int potencia;
	private static int precioBase = 4000;
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}


	public int getPotencia() {
		return potencia;
	}


	public static int getPrecioBase() {
		return precioBase;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public static void setPrecioBase(int precioBase) {
		Vehiculo.precioBase = precioBase;
	}

	Vehiculo(String marca, String modelo, int potencia){
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
	}
	
	public float precioPotencia(){
		
		float precioPotencia = getPrecioBase();
//		try {
//			Scanner inputStream = new Scanner(new File("coches.csv"));
//			while (inputStream.hasNext()) {
//				String data = inputStream.next();
//				String[] dataSplit = data.split(";");
//				precioPotencia = Float.parseFloat(dataSplit[7]);
//				
//			}
//			inputStream.close();
//
//		} catch (Exception e) {
//
//		}
		if (potencia > 0 && potencia < 40){
			precioPotencia+=250;
		}
		if(potencia>40&&potencia<80){
			precioPotencia+=500;
		}
		if(potencia>80&&potencia<120){
			precioPotencia+=1000;
		}
		if(potencia>120&&potencia<150){
			precioPotencia+=1800;
		}
		if(potencia>150&&potencia<200){
			precioPotencia+=3000;
		}
		if(potencia>200&&potencia<400){
			precioPotencia+=5000;
		}
		if(potencia>400||potencia<0){
			System.out.println("No tenemos coches o motos con esa potencia. Disculpe las molestias.");
		}
		return precioPotencia;
	}
	public float precioFinal() {
		//Ahora, en función del modelo, sumaremos un precio a cada uno.
		float precioModelo = precioPotencia();
		if(marca=="BMW"&&modelo == "Serie3") {
			precioModelo+=30000;
		}
		if(marca=="BMW"&&modelo == "Serie5") {
			precioModelo+=52000;
		}
		if(marca=="BMW"&&modelo == "Serie7") {
			precioModelo+=90000;
		}
		if(marca=="Audi"&&modelo == "A1") {
			precioModelo+=15000;
		}
		if(marca=="Audi"&&modelo == "A3") {
			precioModelo+=24000;
		}
		if(marca=="Audi"&&modelo == "A8") {
			precioModelo+=97000;
		}
		//comentamos la parte de coches porque lo hemos hecho de otra forma.
		if(marca=="Kawasaki"&&modelo == "1400GTR") {
			precioModelo+=12000;
		}
		if(marca=="Kawasaki"&&modelo == "J125ABS") {
			precioModelo+=475;
		}
		if(marca=="Kawasaki"&&modelo == "KX250F") {
			precioModelo+=4000;
		}
		if(marca=="Suzuki"&&modelo == "Address") {
			precioModelo-=2000;
		}
		if(marca=="Suzuki"&&modelo == "Burgman") {
			precioModelo+=3000;
		}
		if(marca=="Suzuki"&&modelo == "IntruderC800") {
			precioModelo+=4000;
		}
		return precioModelo;
		
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + potencia;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (potencia != other.potencia)
			return false;
		return true;
	}
	


	
}
