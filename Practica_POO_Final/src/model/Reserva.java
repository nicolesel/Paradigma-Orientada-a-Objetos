package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import views.ReservaView;

public class Reserva {
    private static int numerador;
    private int id, dias;
    private Date fecha_in;
    private float seña, importeFinal;
    private String estado;
    private Huesped huesped;
    private List<ItemReserva> items;


    public Reserva(int dias, String fecha_in, Huesped huesped) throws ParseException {
    	
        numerador++;
        this.id = numerador;
        this.dias = dias;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = formato.parse(fecha_in);
        this.fecha_in = fecha;
        this.seña = 0;
        this.importeFinal = 0;//calcularPrecioFinal();
        this.estado = "activa";
        this.huesped = huesped;
        this.items = new ArrayList<ItemReserva>();
    }

    public float getSeña() {
        return seña;
    }

    public int getId() {
        return id;
    }

    public int getDias() {
        return dias;
    }

    public Date getFecha_in() {
        return fecha_in;
    }

    public float getImporteFinal() {
        return importeFinal;
    }

    public String getEstado() {
        return estado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void estadoATomada() {
        this.estado = "tomada";
        for (ItemReserva i : items) {
            i.habitacionOcupada();
        }
    }

    public void estadoACumplida() {
        this.estado = "cumplida";
        for (ItemReserva i : items) {
            i.habitacionLibre();
        }
    }

    public void estadoASeñada() {
        this.estado = "señada";
    }

    public void estadoAVencida() {
        this.estado = "vencida";
    }

    public void estadoACancelada() {
        this.estado = "cancelada";
    }

    public boolean soyDeHaceUnAño() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaHaceUnAño = fechaActual.minusYears(1);
        LocalDate fechaReserva = fecha_in.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return !fechaReserva.isBefore(fechaHaceUnAño);
    }

    public float calcularPrecioFinal() {
        float suma = 0;
        for (ItemReserva i : items) {
            suma += i.calcularSubtotal();
        }
        this.importeFinal = suma;
        return suma;
    }

    public float obtenerTreintaPorcientoImporte() {
        float seña = (float) (calcularPrecioFinal() * 0.3);
        setSeña(seña);
        return seña;
    }

    public void setSeña(float seña) {
        this.seña = seña;
    }

    public boolean soyEsaReserva(int id) {
        return this.id == id;
    }

    public ReservaView toView() {
        return new ReservaView(id, dias, fecha_in, seña, importeFinal, estado);
    }

    public boolean estoyEntreEsasFechas(Date fecha_in, Date fecha_out) {
    	Date reservaFechaIn = getFecha_in();
	    int reservaDias = getDias();
	    Date reservaFechaOut = new Date(reservaFechaIn.getTime() + reservaDias * 24 * 60 * 60 * 1000);

	    // Verificar si la reserva se superpone al rango de fechas dado
	    return !(fecha_out.before(reservaFechaIn) || fecha_in.after(reservaFechaOut));
    }

    public void agregarItem(ItemReserva item) {
        this.items.add(item);
    }
}
