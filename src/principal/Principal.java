package principal;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		ManejoDeArchivo lec = new ManejoDeArchivo();

		double[] datos = lec.leerArchivo();
		double[] resultado = null;

		if (datos.length > 0) {
			Arrays.sort(datos);

			double aux = datos[0];
			int cantidad = 1;

			for (int i = 1; i < datos.length; i++) {
				if (Double.doubleToLongBits(datos[i]) != Double.doubleToLongBits(aux)) {
					cantidad++;
					aux = datos[i];
				}
			}

			resultado = new double[cantidad];

			aux = datos[0];
			resultado[0] = aux;
			int y = 1;

			for (int i = 1; i < datos.length; i++) {
				if (Double.doubleToLongBits(datos[i]) != Double.doubleToLongBits(aux)) {
					resultado[y] = datos[i];
					aux = datos[i];
					y++;
				}
			}
		}

		lec.guardarArchivo(resultado);

	}

}
