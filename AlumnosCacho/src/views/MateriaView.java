package views;

public class MateriaView {

	private String codigo;
	private String nombre;
	
	public MateriaView() {}

	public MateriaView(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return codigo + " : " + nombre;
	}
}
