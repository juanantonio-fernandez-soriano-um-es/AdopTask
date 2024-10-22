package adoptask.rest;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import adoptask.dto.ErrorDto;
import adoptask.servicio.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ EntityNotFoundException.class, UsernameNotFoundException.class })
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDto handleEntityNotFoundException(Exception ex) {
		return new ErrorDto("Not Found", ex.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDto handleIllegalArgumentException(IllegalArgumentException ex) {
		return new ErrorDto("Bad Request", ex.getMessage());
	}

	@ExceptionHandler(BadCredentialsException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ErrorDto handleBadCredentialsException(BadCredentialsException ex) {
		return new ErrorDto("Unauthorized", ex.getMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorDto handleAccessDeniedException(AccessDeniedException ex) {
		return new ErrorDto("Forbidden", ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto handleGlobalException(Exception ex) {
		return new ErrorDto("Internal Server Error", ex.getMessage());
	}
}
