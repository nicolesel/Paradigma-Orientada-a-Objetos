package exceptions;

public class ItemReservaException extends Exception {

	private static final long serialVersionUID = -8386408757728523335L;
	
	public ItemReservaException (String mensaje) {
		super(mensaje);
	}
}
