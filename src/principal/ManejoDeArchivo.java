package principal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
//import java.util.Objects;
import java.util.Scanner;

public class ManejoDeArchivo {
	String nombre = ""; // = "caso01";

	public ManejoDeArchivo(String nombreArchivo) {
		this.nombre = nombreArchivo;
	}

//	double cantidad;

//	@Override
//	public int hashCode() {
//		return Objects.hash(cantidad);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ManejoDeArchivo other = (ManejoDeArchivo) obj;
//		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad);
//	}

	public double[] leerArchivo() {
		Scanner scanner = null;
		double[] datos = null;

		try {
			File file = new File("casos de prueba/in/" + this.nombre + ".in");

			if (file.exists()) {
				scanner = new Scanner(file);
				// Especifica la configuración regional que se va a utilizar
				scanner.useLocale(Locale.ENGLISH);
				// Para la configuración regional de Argentina, utilizar:
				// arch.useLocale(new Locale("es_AR"));

				int cant = scanner.nextInt();
				datos = new double[cant];
				for (int i = 0; i < cant; i++) {
					double n = scanner.nextDouble();
					datos[i] = n;
				}
			}
			else
				System.out.println("No se encontrol el archivo:"+this.nombre);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cerrar el archivo, eso es mucho muy importante
			if (scanner != null)
				scanner.close();
		}
		return datos;
	}

	public void guardarArchivo(double[] datos) {
		FileWriter file = null;
		PrintWriter printerWriter = null;

		try {
			file = new FileWriter("casos de prueba/out/" + this.nombre + ".out");
			printerWriter = new PrintWriter(file);

			if (datos == null)
				printerWriter.println(0);
			else {
				printerWriter.println(datos.length);

				for (int i = 0; i < datos.length; i++) {
					// Imprime los datos y hace un salto de linea
					printerWriter.println((int) datos[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
