package views;

public class HuespedView {
	private String nombre, apellido;
	private int documento;
	
	public HuespedView() {}
	
	public HuespedView(String nombre, String apellido, int documento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}
	
	public String toString() {
		return getNombre()+" "+getApellido()+" "+getDocumento();
	}
	
}
