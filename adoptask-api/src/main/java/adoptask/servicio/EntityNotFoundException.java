package adoptask.servicio;

@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(String message) {
		super(message);
	}
}
