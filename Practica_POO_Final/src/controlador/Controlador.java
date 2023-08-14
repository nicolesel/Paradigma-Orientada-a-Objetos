package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.HabitacionException;
import exceptions.HuespedException;
import exceptions.ReservaException;
import model.Habitacion;
import model.Huesped;
import model.ItemReserva;
import model.Reserva;
import views.HabitacionView;
import views.HuespedView;

public class Controlador {
	
	private static Controlador instancia;
	private List<Habitacion> habitaciones;
	private List<Huesped> huespedes;
	private List<ItemReserva> items;
	private List<Reserva> reservas;
	
	public static Controlador getInstancia() throws ParseException{
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	private Controlador() throws ParseException {
		habitaciones= new ArrayList<Habitacion>();
		huespedes= new ArrayList<Huesped>();
		items= new ArrayList<ItemReserva>();
		reservas= new ArrayList<Reserva>();
		
		cargarDatosFalsos(); 
	}
	
	

	
	// METODOS PUBLICOS
	
	

	public String verificarHuesped(int documento) throws HuespedException {
		Huesped huesped= buscarHuesped(documento);
		if(huesped!=null) {
			String tipo=verificarTipoHuesped(documento);
			return "El Huesped existe! es de tipo "+tipo;
		}
		return "No existe"; //en el caso de que no exista
	}
	
	public void registrarHuesped(String nombre, String apellido,int documento) {
		Huesped huesped=new Huesped(nombre,apellido,documento);
		huespedes.add(huesped);
	}
	
	public int reservar(int documento, String fecha_in,int dias) throws HuespedException, ParseException {
		Reserva reserva= new Reserva(dias,fecha_in,buscarHuesped(documento));
		reservas.add(reserva);
		return reserva.getId();
	}
	
	public List<HabitacionView> verificarHabitacionesDisponibles(String tipo, String fecha_in,String fecha_out) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechain = dateFormat.parse(fecha_in);
		Date fechaout =  dateFormat.parse(fecha_out);
		List<HabitacionView> habitacionesDisponibles= new ArrayList<HabitacionView>();
		for(Habitacion h:habitaciones) {
			if(h.noEstoyOcupada(fechain,fechaout,tipo)) {
				habitacionesDisponibles.add(h.toView());
			}
		}  
		return habitacionesDisponibles;
	}
	
	public void agregarHabitacionAReserva(int numero,int id) throws ReservaException, HabitacionException {
		Reserva reserva = buscarReserva (id);
		Habitacion habitacion= buscarHabitacion(numero);
		ItemReserva item= new ItemReserva(reserva,habitacion);
		items.add(item);
		habitacion.agregarItem(item);
		reserva.agregarItem(item);
	}
	
	public float cobrarSeña(int id) throws ReservaException {
		Reserva reserva = buscarReserva(id);
		reserva.estadoASeñada();
		return reserva.obtenerTreintaPorcientoImporte();
	}
	
	public void tomarReserva(int id) throws ReservaException {
		Reserva reserva = buscarReserva(id);
		reserva.estadoATomada();
	}
	
	public void cancelarReserva(int id) throws ReservaException {
		Reserva reserva = buscarReserva(id);
		reserva.estadoACancelada();
	}
	
	public void cumplidaReserva(int id) throws ReservaException {
		Reserva reserva = buscarReserva(id);
		reserva.estadoACumplida();
	}
	
	public void vencidaReserva(int id) throws ReservaException {
		Reserva reserva = buscarReserva(id);
		reserva.estadoAVencida();
	}
	
	// METODOS PRIVADOS
	
	private String verificarTipoHuesped(int documento) throws HuespedException {
		Huesped huesped= buscarHuesped(documento);
		boolean soyH=huesped.soyHabitual();
		if(soyH) {
			return "Habitual";
		}
		else {
			return "Esporádico";
		}
	}

	private Huesped buscarHuesped(int documento) throws HuespedException {
		for(Huesped h:huespedes) {
			if(h.soyEseHuesped(documento))
				return h;
		}
		throw new HuespedException("El Huesped no esta registrado");
	}
	
	private Reserva buscarReserva(int id) throws ReservaException {
		for(Reserva r:reservas) {
			if(r.soyEsaReserva(id))
				return r;
		}
		throw new ReservaException("La Reserva no existe");
	}
	
	private Habitacion buscarHabitacion(int numero) throws HabitacionException {
		for(Habitacion h:habitaciones) {
			if(h.soyEsaHabitacion(numero))
				return h;
		}
		throw new HabitacionException("La Habitacion no existe");
	}
	
	
	
	
	public List<HuespedView> getHuespedes() {
		List<HuespedView> hues= new ArrayList<HuespedView>();
		for(Huesped h:huespedes) {
			hues.add(h.toView());
		}
		return hues;
	}
	
	
	
	
	
	private void cargarDatosFalsos() throws ParseException {
		huespedes.add(new Huesped("juli","ballestrero",1));
		huespedes.add(new Huesped("nicole","selem",2));
		huespedes.add(new Huesped("rena","calabrese",3));

		habitaciones.add(new Habitacion(1,1,"simple",100));
		habitaciones.add(new Habitacion(2,2,"doble",200));
		habitaciones.add(new Habitacion(3,3,"matrimonial",300));
		
		reservas.add(new Reserva(11,"2023-10-01",huespedes.get(0)));
		reservas.add(new Reserva(12,"2023-11-01",huespedes.get(1)));
		reservas.add(new Reserva(13,"2023-12-01",huespedes.get(2)));
		
		items.add(new ItemReserva(reservas.get(0),habitaciones.get(0)));
		reservas.get(0).agregarItem(items.get(0));
		habitaciones.get(0).agregarItem(items.get(0));
		items.add(new ItemReserva(reservas.get(0),habitaciones.get(1)));
		reservas.get(0).agregarItem(items.get(1));
		habitaciones.get(1).agregarItem(items.get(1));
		items.add(new ItemReserva(reservas.get(1),habitaciones.get(1)));
		reservas.get(1).agregarItem(items.get(2));
		habitaciones.get(1).agregarItem(items.get(2));
		items.add(new ItemReserva(reservas.get(2),habitaciones.get(2)));
		reservas.get(2).agregarItem(items.get(3));
		habitaciones.get(2).agregarItem(items.get(3));
		items.add(new ItemReserva(reservas.get(2),habitaciones.get(0)));
		reservas.get(2).agregarItem(items.get(4));
		habitaciones.get(0).agregarItem(items.get(4));
		
		
		
	}

	
	
}
