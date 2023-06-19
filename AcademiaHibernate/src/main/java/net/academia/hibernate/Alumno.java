package net.academia.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Clase POJO reflejo de nuestra tabla Alumno en MySql
@Entity
@Table(name = "alumno")
public class Alumno {
	
	private long id;
	private String nombre;
	private String apellidos;
	private String curso;
	private int asignaturasMatricula;
	private int edad;
	
	//Constructor
	public Alumno() {
	}
	
	//Getters & Setters
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAsignaturasMatricula() {
		return asignaturasMatricula;
	}

	public void setAsignaturasMatricula(int asignaturasMatricula) {
		this.asignaturasMatricula = asignaturasMatricula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + "- nombre=" + nombre + "- apellidos=" + apellidos + "- curso=" + curso
				+ "- asignaturasMatricula=" + asignaturasMatricula + "- edad=" + edad + "]";
	}
}