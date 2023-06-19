package net.academia.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Acceso {

	// único sessionFactory
	protected SessionFactory sessionFactory;

	// setup
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	// cerrando sessionFactory
	protected void exit() {
		sessionFactory.close();
	}

	// inserta un alumno con los datos introducidos por consola
	public void insertarAlumno() {
		// abre sessionFactory
		Session session = sessionFactory.openSession();
		
		try {
		//Introducimos datos por consola
		System.out.println("Rellene los campos para introducir un alumno en la Base de Datos de la Academia.");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Alumno alumno = new Alumno();
		
		System.out.println("Introduzca el nombre: ");
		alumno.setNombre(sc.nextLine());
		
		System.out.println("Introduzca los apellidos: ");
		alumno.setApellidos(sc.nextLine());
		
		System.out.println("Introduzca el curso al que pertenece: ");
		alumno.setCurso(sc.nextLine());
		
		System.out.println("Introduzca el número de asignaturas matriculadas: ");
		alumno.setAsignaturasMatricula(sc.nextInt());
		
		System.out.println("Introduzca la edad del alumno: ");
		alumno.setEdad(sc.nextInt());
		
		
		// Guarda alumno
		session.beginTransaction();
		session.save(alumno);
		// alumno persistente
		session.getTransaction().commit();
		// cierra session
		session.close();
		}finally {
			System.out.println("Alumno Agregado");
		}
	}

	// lista todos los alumnos de la BBDD
	public void listarAlumnos() {
		//abre sessionFactory
		Session session = sessionFactory.openSession();
		try {
			//createQuery para sacar todos los registros de la tabla alumno
			@SuppressWarnings("unchecked")
			List<Alumno> listaAlumnos = session.createQuery("from Alumno").getResultList();
			//for que recorre la tabla imprimiendo los registros por consola
			for (Alumno alumno : listaAlumnos) {
				System.out.println(alumno);
			}
		} finally {
			//cerramos session
			session.close();
		}
	}
}
