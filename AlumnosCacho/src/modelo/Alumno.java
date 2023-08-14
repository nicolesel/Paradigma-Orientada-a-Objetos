package modelo;

import java.util.ArrayList;
import java.util.List;

import views.AlumnoView;

public class Alumno {

	private static int numerador;
	private int numero;
	private String nombre;
	private List<Materia> materias;
	
	public Alumno(String nombre) {
		numerador++;
		numero = numerador;
		this.nombre = nombre;
		materias = new ArrayList<Materia>();
	}
	
	public void agregarMateria(Materia materia) {
		materias.add(materia);
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Materia> getMaterias() {
		return materias;
	}
	
	public boolean soyElAlumno(int numero) {
		return this.numero == numero;
	}
	
	public AlumnoView toView() {
		return new AlumnoView(numero, nombre);
	}
}
