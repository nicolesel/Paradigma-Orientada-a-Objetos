package model;

import java.util.ArrayList;
import java.util.List;

import views.HuespedView;

public class Huesped {
	
	private String nombre, apellido;
	private int documento;
	private List<Reserva> reservas;
	
	public Huesped(String nombre, String apellido, int documento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.reservas= new ArrayList<Reserva>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getDocumento() {
		return documento;
	}
	
	public boolean soyEseHuesped(int documento) {
		if(getDocumento()==documento) {  //return this.matricula.equals(matricula);
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean soyHabitual() {
		int contador=0;
		for(Reserva r:reservas) {
			if(r.soyDeHaceUnAño()) {
				contador++;
			}
		}
		if(contador>=6) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public HuespedView toView() {
		return new HuespedView(nombre,apellido,documento);
	}
}
