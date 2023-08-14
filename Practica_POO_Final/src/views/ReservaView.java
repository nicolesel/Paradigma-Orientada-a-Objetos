package views;

import java.util.Date;


import model.Huesped;

public class ReservaView {
	private int id,dias;
	private Date fecha_in;
	private float seña,importeFinal;
	private String estado;
	
	public ReservaView() {}
	
	public ReservaView(int id, int dias, Date fecha_in2, float seña, float importeFinal, String estado) {
		this.id = id;
		this.dias = dias;
		this.fecha_in = fecha_in2;
		this.seña = seña;
		this.importeFinal = importeFinal;
		this.estado = estado;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public Date getFecha_in() {
		return fecha_in;
	}

	public void setFecha_in(Date fecha_in) {
		this.fecha_in = fecha_in;
	}

	public float getSeña() {
		return seña;
	}

	public void setSeña(float seña) {
		this.seña = seña;
	}

	public float getImporteFinal() {
		return importeFinal;
	}

	public void setImporteFinal(float importeFinal) {
		this.importeFinal = importeFinal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return id+" "+dias+" "+fecha_in+" $"+seña+" $"+importeFinal+" "+estado;
	}
	
}
