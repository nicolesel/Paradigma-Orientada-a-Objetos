package views;

public class AlumnoView {

	private int numero;
	private String nombre;
	
	public AlumnoView() {}

	public AlumnoView(int numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return numero + " : " + nombre;
	}
	
}
