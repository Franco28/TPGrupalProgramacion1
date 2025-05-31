package tpgrupal_smb;

import java.util.Scanner;

public class TpGrupalSMB {

	public static void main(String[] args) {

		/*
		 * Integrantes: - Lara Belgorodsky - Romina Solis - Franco Mato
		 * 
		 * El gobierno de la Ciudad de Buenos Aires realiza una encuesta en casas de familia. 
		 * De cada familia se conoce: domicilio, tipo de vivienda (‘C’:casa,
		 * ‘D’:departamento), y cantidad de integrantes. 
		 * De cada integrante de la familia se conoce: nombre y apellido, edad, sexo (‘F’, ‘M’), 
		 * nivel de estudios alcanzados (‘N’: no posee, ‘P’: primario, ‘S’: secundario, ‘T’:
		 * terciario, ‘U’: universitario), y un indicador (‘I’:incompleto, ‘C’:
		 * completo) que se refiere al ítem anterior. 
		 * Los datos finalizan cuando la cantidad de integrantes sea igual a cero. 
		 * Aclaraciones: 
		 * 1. Todos los valores ingresados deben ser validados, por lo cual no se permiten 
		 * valores incorrectos. Mostrar al usuario cuales son los valores permitidos 2.
		 * 
		 * Se pide emitir un listado con los resultados:
		 * 1. La cantidad de los encuestados que hayan completado los estudios primarios.
		 * 2. El porcentaje de analfabetismo en la ciudad (se considera analfabetos a los mayores de 10 años que no posean estudios).
		 * 3. El domicilio de la familia con mayor cantidad de integrantes que viven en departamento.
		 * 4. Edad promedio de cada familia y de la ciudad.
		 * 5. Cantidad de encuestados en cada tipo de nivel de estudios alcanzados incompletos.
		 * 6. Porcentaje de encuestados de sexo femenino y masculino.		 
		 */

		Scanner lector = new Scanner(System.in);

		String domicilio, nombre, apellido, tipoViviendaIngresada;
		String tipoSexo, nivelEstudiosString, indicadorString;
		String domicilioFamiliaMayorDepto = "";

		char sexo, indicador, tipoVivienda = 0, nivelEstudios = 0;
		
		int edad = 0, cantidadIntegrantes = 0, integrantes = 0, vuelta = 1, integranteVuelta = 1;
		int cantidadNivelPrimario = 0, cantidadAnalfabetos = 0, cantIntegranteDptosFlia = -99999;
		int cantidadNivelAlcIncompleto = 0, cantSexoFem = 0, cantSexoMasc = 0;
		int sumaEdadesFlia = 0, sumaEdadCiudad = 0;

		double porcentajeAnalfabetos = 0, edadPromedioFlia = 0, edadPromedioCiudad = 0;
		double porcSexoFem = 0, porcSexoMasc = 0;

		boolean datosErroneos = false, continuar = false;

		do {
			// Si la vuelta ya es mayor o igual a 2, muestra mensaje de finalizado
			if (vuelta >= 2) {
				System.out.println("\n-- Finalizo la encuesta a la familia anterior -- \n");
			}

			System.out.println("-----------------------------");
			System.out.println("Encuesta familia numero: " + vuelta);
			System.out.println("-----------------------------\n");

			// INGRESO DE DATOS DEL DOMICILIO
			do {
				System.out.println("Ingrese el domicilio: ");
				domicilio = lector.nextLine();

				// validamos que el domicilio no este vacio
				if (domicilio.isBlank() || domicilio.isEmpty()) {
					System.out.println("ERROR: El domicilio es requerido, no puede estar vacio.");
					datosErroneos = true;
				} else {
					datosErroneos = false;
				}
			} while (datosErroneos);

			// INGRESO DE DATOS DE TIPO DE VIVIENDA
			do {
				System.out.println("\nIngrese el tipo de vivienda: \n" + "C: Casa \n" + "D: Departamento");

				tipoViviendaIngresada = lector.nextLine();

				// validamos que el lector no este vacio para que no rompa
				// cuando haga el charAt(0)
				if (!tipoViviendaIngresada.isBlank() || !tipoViviendaIngresada.isEmpty()) {
					tipoVivienda = tipoViviendaIngresada.toUpperCase().charAt(0);

					// validamos tipo de vivienda
					if ((tipoVivienda != 'C' && tipoVivienda != 'D')) {
						System.out.println("ERROR: el tipo de vivienda es incorrecto, deben ser C o D");
						datosErroneos = true;
					} else {
						datosErroneos = false;
					}
				} else {
					System.out.println("\nERROR: El tipo de vivienda es requerido, no puede ser vacio.\n");
					datosErroneos = true;
				}
			} while (datosErroneos);

			// INGRESO CANTIDAD DE INTEGRANTES
			do {
				System.out.print("\nIngrese la cantidad de integrantes: ");

				if (lector.hasNextInt()) {
					cantidadIntegrantes = Integer.parseInt(lector.nextLine());

					// flia mayor que vive en depto
					if ((cantidadIntegrantes > cantIntegranteDptosFlia) && tipoVivienda == 'D') {
						cantIntegranteDptosFlia = cantidadIntegrantes;
						domicilioFamiliaMayorDepto = domicilio;
					}

					datosErroneos = false;
				} else {
					System.out.println("ERROR: Debe ingresar un numero.");
					lector.nextLine(); // descarto el ingreso invalido
					datosErroneos = true;
				}
			} while (datosErroneos);

			// si es 0, frenamos todo
			if (cantidadIntegrantes == 0) {
				System.out.println("\n---------------------------------");
				System.out.println("Termino el programa.");
				System.out.println("---------------------------------\n");
				continuar = false;
				break;
			} else {
				continuar = true; // continua el programa
				System.out.println("\n---------------------------------");
				System.out.println("---------------------------------");

				// PIDO LOS DATOS DE CADA INTEGRANTE HASTA LLEGAR AL ULTIMO INTEGRANTE
				for (int i = cantidadIntegrantes; i > 0; i--) {
					System.out.println("\nIntegrante numero " + integranteVuelta + " de la encuesta " + vuelta);
					// INGESO DEL NOMBRE
					do {
						System.out.println("\nIngrese nombre: ");
						nombre = lector.nextLine();

						if (nombre.isBlank() || nombre.isEmpty()) {
							System.out.println("ERROR: El nombre es requerido, no puede ser vacio.");
							datosErroneos = true;
						} else {
							datosErroneos = false;
						}
					} while (datosErroneos);

					// INGRESO DEL APELLIDO
					do {
						System.out.println("\nIngrese apellido: ");
						apellido = lector.nextLine();

						if (apellido.isBlank() || apellido.isEmpty()) {
							System.out.println("ERROR: El apellido es requerido, no puede ser vacio.");
							datosErroneos = true;
						} else {
							datosErroneos = false;
						}
					} while (datosErroneos);

					// INGRESO LA EDAD
					do {
						System.out.println("\nIngrese la edad: ");

						if (lector.hasNextInt()) {
							edad = Integer.parseInt(lector.nextLine());
							datosErroneos = false;

							sumaEdadesFlia += edad;
						} else {
							System.out.println("ERROR: Debe ingresar un numero para la edad.");
							lector.nextLine(); // descarto el ingreso invalido
							datosErroneos = true;
						}
					} while (datosErroneos);

					// INGRESO DEL TIPO DE SEXO
					do {
						System.out.println("\nIngrese el tipo de sexo: \n" + "F: Femenino \n" + "M: Masculino");

						tipoSexo = lector.nextLine();

						// validamos que el lector no este vacio para que no rompa
						// cuando haga el charAt(0)
						if (!tipoSexo.isBlank() || !tipoSexo.isEmpty()) {
							sexo = tipoSexo.toUpperCase().charAt(0);

							// validamos tipo de sexo
							if ((sexo != 'F' && sexo != 'M')) {
								System.out.println("ERROR: tipo de sexo incorrecto, debe ser F o M");
								datosErroneos = true;
							} else {
								datosErroneos = false;
							}

							switch (sexo) {
							case 'F':
								cantSexoFem++;
								break;
							case 'M':
								cantSexoMasc++;
								break;
							default:
								break;
							}

						} else {
							System.out.println("ERROR: El tipo de sexo es requerido, no puede estar vacio.");
							datosErroneos = true;
						}
					} while (datosErroneos);

					// INGRESO NIVEL DE ESTUDIOS
					do {
						System.out.println("\nIngrese el nivel de estudios: \n" + "N: No posee \n" + "P: Primario \n"
								+ "S: Secundario \n" + "T: Terciario \n" + "U: Universitario");

						nivelEstudiosString = lector.nextLine();

						// validamos que el lector no este vacio para que no rompa
						// cuando haga el charAt(0)
						if (!nivelEstudiosString.isBlank() || !nivelEstudiosString.isEmpty()) {
							nivelEstudios = nivelEstudiosString.toUpperCase().charAt(0);

							// validamos tipo de nivel de estudio alcanzado
							if (nivelEstudios != 'N' && nivelEstudios != 'P' && nivelEstudios != 'S'
									&& nivelEstudios != 'T' && nivelEstudios != 'U') {
								System.out.println(
										"ERROR: el nivel de estudios es incorrecto, deben ser N, P, S, T o U.");
								datosErroneos = true;
							} else {
								// si es analfabeto
								if (edad > 10 && nivelEstudios == 'N') {
									cantidadAnalfabetos++;
								}

								datosErroneos = false;
							}
						} else {
							System.out.println("ERROR: El nivel de estudios es requerido, no puede ser vacio.");
							datosErroneos = true;
						}
					} while (datosErroneos);

					// INGRESO INDICADOR ESTUDIOS
					if (nivelEstudios != 'N') {
						do {
							System.out.println("\nIngrese el indicador: \n" + "I: Incompleto \n" + "C: Completo");

							indicadorString = lector.nextLine();

							// validamos que el lector no este vacio para que no rompa
							// cuando haga el charAt(0)
							if (!indicadorString.isBlank() || !indicadorString.isEmpty()) {
								indicador = indicadorString.toUpperCase().charAt(0);

								// validamos tipo de indicador
								if ((indicador != 'I' && indicador != 'C')) {
									System.out.println("ERROR: tipo de indicador incorrecto, deben ser I o C");
									datosErroneos = true;
								} else {
									datosErroneos = false;

									// si es primario acumulamos en variable
									if ((nivelEstudios == 'P' && indicador == 'C') || nivelEstudios == 'S'
											|| nivelEstudios == 'T' || nivelEstudios == 'U') {
										cantidadNivelPrimario++;
									}

									if ((nivelEstudios == 'P' || nivelEstudios == 'S' || nivelEstudios == 'T'
											|| nivelEstudios == 'U') && indicador == 'I') {
										cantidadNivelAlcIncompleto++;
									}
								}
							} else {
								System.out.println("ERROR: El tipo de indicador es requerido, no puede estar vacio.");
								datosErroneos = true;
							}
						} while (datosErroneos);
					}

					integranteVuelta++;
					integrantes++; // incrementamos el integrante (cant. personas)
				}

				integranteVuelta = 1;
			}

			sumaEdadCiudad += sumaEdadesFlia;

			vuelta++; // incrementamos la vuelta
		} while (continuar);

		lector.close();

		porcentajeAnalfabetos = ((double) cantidadAnalfabetos / integrantes) * 100;
		edadPromedioFlia = ((double) sumaEdadesFlia / integrantes);
		edadPromedioCiudad = ((double) sumaEdadCiudad / integrantes);
		porcSexoFem = ((double) cantSexoFem / integrantes) * 100;
		porcSexoMasc = ((double) cantSexoMasc / integrantes) * 100;

		System.out.println("\n-------------------------------------------------------");
		System.out.println("* Cantidad encuestados con estudios primarios completos: " + cantidadNivelPrimario);
		System.out.println("* Porcentaje de analfabetos en la ciudad: %" + porcentajeAnalfabetos);
		System.out.println("* El domicilio con la mayor cantidad de integrantes que viven en Depto. es: " + domicilioFamiliaMayorDepto + " con un total de " + cantIntegranteDptosFlia + " integrantes.");
		System.out.println("* Edad promedio familia: " + edadPromedioFlia);
		System.out.println("* Edad promedio ciudad: " + edadPromedioCiudad);
		System.out.println("* Cantidad de encuestados en cada tipo de nivel de estudios alcanzados incompletos: " + cantidadNivelAlcIncompleto);
		System.out.println("* Porcentaje de encuestados de sexo femenino: %" + porcSexoFem);
		System.out.println("* Porcentaje de encuestados de sexo masculino: %" + porcSexoMasc);
		System.out.println("-------------------------------------------------------");
	}
}