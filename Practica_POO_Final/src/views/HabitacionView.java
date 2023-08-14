package views;

public class HabitacionView {
	private int numero, piso;
	private String tipo;
	private float precio;
	private boolean estado;
	
	public HabitacionView() {}
	
	public HabitacionView(int numero, int piso, String tipo, float precio, boolean estado) {
		this.numero = numero;
		this.piso = piso;
		this.tipo = tipo;
		this.precio = precio;
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return numero+" "+piso+" "+tipo+" "+precio+" "+estado;
	}

}
