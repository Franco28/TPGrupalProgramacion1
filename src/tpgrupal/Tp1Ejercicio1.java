package tpgrupal;

import java.util.Scanner;

public class Tp1Ejercicio1 {

	public static void main(String[] args) {

		/* Integrantes:
		 * - Lara Belgorodsky
		 * - Romina Solis
		 * - Franco Mato
		 * 
		 * El gobierno de la Ciudad de Buenos Aires realiza una encuesta en casas de familia. 
		 * De cada familia conoce: domicilio, tipo de vivienda (‘C’:casa, ‘D’:departamento), 
		 * y cantidad de integrantes. 
		 * De cada integrante de la familia se conoce: nombre y apellido, edad, sexo (‘F’, ‘M’), 
		 * nivel de estudios alcanzados (‘N’: no posee, ‘P’: primario, ‘S’: secundario, ‘T’: terciario, ‘U’: universitario), 
		 * y un indicador (‘I’:incompleto, ‘C’: completo) que se refiere al ítem anterior.
		 * Los datos finalizan cuando la cantidad de integrantes sea igual a cero.
		 * Aclaraciones:
		 * 1. Todos los valores ingresados deben ser validados, por lo cual no 
		 * se permiten valores incorrectos. Mostrar al usuario cuales son los valores permitidos
		 * 2. Pueden escoger la estructura repetitiva que les convenga o con la que se sientan cómodo.
		 */

		Scanner lector = new Scanner(System.in);
		
		String domicilio, nombre, apellido;		
		int edad, cantidadIntegrantes = 0;		
		char tipoVivienda, sexo, nivelEstudios, indicador;
		boolean datosErroneos = false;
				
		// INGRESO DE DATOS DEL DOMICILIO
		do {
			System.out.println("Ingrese el domicilio");
			domicilio = lector.nextLine();
			
			// validamos que el domicilio no este vacio
			if (domicilio.isBlank() || domicilio.isEmpty()) {
				System.out.println("\nEl domicilio es requerido.\n");
				datosErroneos = true;
			} else {
				datosErroneos = false;
			}
		} while (datosErroneos); 
		
		// INGRESO DE DATOS DE TIPO DE VIVIENDA
		String tipoViviendaIngresada;
		do {
			System.out.println("\nIngrese el tipo de vivienda: \n" 
					+ "C: Casa \n"
					+ "D: Departamento");
			
			tipoViviendaIngresada = lector.nextLine();
			
			// validamos que el lector no este vacio para que no rompa
			// cuando haga el charAt(0)
			if (!tipoViviendaIngresada.isBlank() || !tipoViviendaIngresada.isEmpty()) {
				tipoVivienda = tipoViviendaIngresada.toUpperCase().charAt(0);
				
				// validamos tipo de vivienda
				if ((tipoVivienda != 'C' && tipoVivienda != 'D')) {
					System.out.println("\nOpcion " + tipoVivienda + " de tipo de vivienda incorrecta\n");
					datosErroneos = true;
				} else {
					datosErroneos = false;
				}
			}
		} while (datosErroneos); 
		
		// INGRESO CANTIDAD DE INTEGRANTES
		do {
			System.out.println("\nIngrese la cantidad de integrantes");			
			if (lector.hasNextInt()) {				
				cantidadIntegrantes = lector.nextInt();
				datosErroneos = false;
			} else {
				System.out.println("\nDebe ingresar una cantidad valida\n");
				datosErroneos = true;
			}
		} while (datosErroneos); 
		
		// INGRESE NOMBRE
		do {
			System.out.println("\nIngrese nombre");
			nombre = lector.nextLine();
			
			if (nombre.isBlank() || nombre.isEmpty()) {
				System.out.println("\nEl nombre es requerido.\n");
				datosErroneos = true;
			} else {
				datosErroneos = false;
				
			}
			
		} while (datosErroneos); 
		
		// INGRESE APELLIDO
		do {
			System.out.println("\nIngrese apellido");
			apellido = lector.nextLine();
			
			if (apellido.isBlank() || apellido.isEmpty()) {
				System.out.println("\nEl apellido es requerido.\n");
				datosErroneos = true;
			} else {
				datosErroneos = false;
			}
			
			
		} while (datosErroneos); 
		
		// INGRESE EDAD
		do {
			System.out.println("\nIngrese la edad");

			if (lector.hasNextInt()) {
				edad = lector.nextInt();
			} else {
				System.out.println("\nLa edad no es valida\n");
				datosErroneos = true;
			}		
		} while (datosErroneos); 
					
		lector.close();		
	}
}