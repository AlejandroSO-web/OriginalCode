import java.util.Scanner;
/*
@author AlejandroSanchez.
*/
public class Criba {

	public static int[] generarPrimos(int max) {
		
		if (max >= 2) {
			
			int tamañoArray = max + 1; 
			boolean[] esPrimo = new boolean[tamañoArray];

			for (int i = 0; i < tamañoArray; i++) {
				esPrimo[i] = true;
			    esPrimo[0] = esPrimo[1] = false;
			}
			
			for (int i = 2; i < Math.sqrt(tamañoArray) + 1; i++) {
				if (esPrimo[i]) {
					for (int j = 2 * i; j < tamañoArray; j += i)
						esPrimo[j] = false;
				}
			}
			int cuentaPrimos = 0;
			
			for (int i = 0; i < tamañoArray; i++) {
				if (esPrimo[i])
					cuentaPrimos++;
			}
			int[] primos = new int[cuentaPrimos];
			    for (int i = 0, j = 0; i < tamañoArray; i++) {
				    if (esPrimo[i])
					   primos[j++] = i;
			}
			return primos;
		} else {
			return new int[0];

		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nÃºmero para la criba de ErastÃ³tenes: ");

		int dato = teclado.nextInt();
		teclado.close();

		int vector[] = new int[dato];
		System.out.println("\nVector inicial hasta: " + dato);

		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.println(i + 1 + "\t");

		}

		vector = generarPrimos(dato);
		System.out.println("\nVector de primos hasta: " + dato);

		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.println(vector[i] + "\t");
		}
	}
}
