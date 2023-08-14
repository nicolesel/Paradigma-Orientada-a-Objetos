package exceptions;

public class ReservaException extends Exception {

	private static final long serialVersionUID = -3870893899885011696L;
	
	public ReservaException(String mensaje) {
		super(mensaje);
	}
}
