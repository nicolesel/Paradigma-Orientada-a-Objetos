package model;

import java.util.Date;

import views.ItemReservaView;

public class ItemReserva {
	private float precio;
	private Reserva reserva;
	private Habitacion habitacion;
	
	public ItemReserva( Reserva reserva, Habitacion habitacion) {
		this.reserva = reserva;
		this.habitacion = habitacion;
		this.precio = calcularSubtotal();
	}

	public float calcularSubtotal() {
		return habitacion.getPrecio();
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public ItemReservaView toView() {
		return new ItemReservaView(precio,reserva.toView(),habitacion.toView());
	}

	public boolean estoyEnEsaFecha(Date fecha_in, Date fecha_out) {
		
		if(reserva.estoyEntreEsasFechas( fecha_in, fecha_out)) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public void habitacionOcupada() {
		habitacion.estadoAOcupado();
	}
	
	public void habitacionLibre() {
		habitacion.estadoALibre();;
	}
	

}
