package views;

import model.Habitacion;
import model.Reserva;

public class ItemReservaView {
	private float precio;
	private ReservaView reserva;
	private HabitacionView  habitacion;
	
	public ItemReservaView(float precio, ReservaView reserva, HabitacionView habitacion) {
		this.precio = precio;
		this.reserva = reserva;
		this.habitacion = habitacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ReservaView getReserva() {
		return reserva;
	}

	public void setReserva(ReservaView reserva) {
		this.reserva = reserva;
	}

	public HabitacionView getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(HabitacionView habitacion) {
		this.habitacion = habitacion;
	}
	
	public String toString() {
		return precio+" "+reserva+" "+habitacion;
	}
	
}
