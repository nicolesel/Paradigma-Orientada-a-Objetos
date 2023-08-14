package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import views.HabitacionView;

public class Habitacion {

	private int numero, piso;
	private String tipo;
	private float precio;
	private boolean estado;
	private List<ItemReserva> items;
	
	public Habitacion(int numero, int piso, String tipo, float precio) {
		this.numero = numero;
		this.piso = piso;
		this.tipo = tipo;
		this.precio = precio;
		this.estado = true;
		this.items = new ArrayList<ItemReserva>();
	}

	public int getNumero() {
		return numero;
	}

	public int getPiso() {
		return piso;
	}

	public String getTipo() {
		return tipo;
	}

	public float getPrecio() {
		return precio;
	}

	public boolean isEstado() {
		return estado;
	}
	
	public void estadoALibre() {
		this.estado=true;
	}
	
	public void estadoAOcupado() {
		this.estado=false;
	}
	
	public boolean soyEsaHabitacion(int numero) {
		return getNumero()==numero;
	}
	
	public void agregarItem(ItemReserva item) {
		items.add(item);
	}
	
	public HabitacionView toView() {
		return new HabitacionView(numero,piso,tipo,precio,estado);
	}

	public boolean noEstoyOcupada(Date fecha_in,Date fecha_out, String tipo) {
		boolean disponible=true;
		if(!this.soyDeEseTipo(tipo)) {
			return false;
		}
		for(ItemReserva i:items) {
			if(i.estoyEnEsaFecha( fecha_in, fecha_out)) {
				disponible=false;
			}
		}
		return disponible;
		
	}

	private boolean soyDeEseTipo(String tipo) {
		if(this.tipo.equals(tipo)) {
			return true;
		}
		return false;
	}
	
	
	
}
