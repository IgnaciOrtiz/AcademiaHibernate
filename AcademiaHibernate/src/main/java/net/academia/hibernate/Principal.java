package net.academia.hibernate;

import java.util.*;

//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Principal {
	public static void main(String[] args) {
		//Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		 Scanner sc = new Scanner(System.in);
		 
		 Acceso acceso = new Acceso();
		 boolean salir = false;
		 int opcion;
		 
		 System.out.println("Bienvenido a Academia-Hiberante");
		 System.out.println("Selecciona la acción que desea realizar");
		 
			while (!salir) {
				
				System.out.println("1.Visualizar todos los alumnos");
				System.out.println("2.Añadir un alumno");
				System.out.println("3.Salir");

				try {

					System.out.println("Introduce un numero: ");
					
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:
						acceso.setup();
						acceso.listarAlumnos();
						acceso.exit();
						break;
					case 2:
						acceso.setup();
						acceso.insertarAlumno();					
						acceso.exit();
						break;
					case 3:
						salir = true;
						break;
					default:
						System.out.println("Las opciones son entre 1 y 3");
					}
				} catch (InputMismatchException e) {
					System.out.println("Debe ser un numero");
					sc.next();
				}
			}
			System.out.println("Gracias por usar Hibernate");
			sc.close();
		}
}