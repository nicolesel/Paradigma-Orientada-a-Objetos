package controlador;

import java.util.ArrayList;
import java.util.List;

import exceptions.AlumnoException;
import exceptions.MateriaException;
import modelo.Alumno;
import modelo.Materia;
import views.AlumnoView;
import views.MateriaView;

public class Controlador {

	private List<Alumno> alumnos;
	private List<Materia> materias;
	private static Controlador instancia;
		
	private Controlador() {
		alumnos = new ArrayList<Alumno>();
		materias = new ArrayList<Materia>();
		cargarDatosFalsos();
	}

	public static Controlador getInstancia() {
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	public void agregarMateriaAlumno(int numero, String codigo) throws AlumnoException, MateriaException {
		Alumno a = buscarAlumno(numero);
		Materia m = buscarMateria(codigo);
		if(a != null && m != null)
			a.agregarMateria(m);
	}
	
	public List<AlumnoView> getAlumno(){
		List<AlumnoView> resultado = new ArrayList<AlumnoView>();
		for(Alumno a : alumnos)
			resultado.add(a.toView());
		return resultado;
	}
	
	public List<MateriaView> getMaterias(){
		List<MateriaView> resultado = new  ArrayList<MateriaView>();
		for(Materia m : materias)
			resultado.add(m.toView());
		return resultado;
	}
	
	private Materia buscarMateria(String codigo) throws MateriaException {
		for(Materia m : materias)
			if(m.soyLaMateria(codigo))
				return m;
		throw new MateriaException("La materia de codigo " + codigo + " no existe");
	}
	
	private Alumno buscarAlumno(int numero) throws AlumnoException {
		for(Alumno a : alumnos)
			if(a.soyElAlumno(numero))
				return a;
		throw new AlumnoException("El numero de alumno " + numero + " no existe");
	}
	
	private void cargarDatosFalsos() {
		
		for(int i=10; i<20; i++) {
			alumnos.add(new Alumno("Alumno_" + i));
			materias.add(new Materia("M_" + i, "Materia_" + i, "Esta es la descripcion de la materia " + i));
		}
		
	}
}
