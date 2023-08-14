package modelo;

import views.MateriaView;

public class Materia {

	private String codigo;
	private String nombre;
	private String descripcion;
	
	public Materia(String codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean soyLaMateria(String codigo) {
		return this.codigo.equalsIgnoreCase(codigo);
	}
	
	public MateriaView toView() {
		return new MateriaView(codigo, nombre);
	}
}
