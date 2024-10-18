package adoptask.servicio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import adoptask.dto.BusquedaDto;
import adoptask.dto.PublicacionDto;
import adoptask.dto.ResumenAnimalDto;
import adoptask.dto.UsuarioDto;

public interface IServicioUsuarios {

	UsuarioDto verificarPassword(String nick, String password);

	Page<ResumenAnimalDto> getPublicaciones(BusquedaDto busquedaDto);

	PublicacionDto getPublicacion(String idAnimal);

	String altaUsuario(UsuarioDto usuarioDto);

	void altaUsuarioFoto(String idUsuario, String rutaFoto);

	UsuarioDto getUsuario(String idUsuario);

	void bajaUsuario(String idUsuario);

	void updateUsuario(UsuarioDto usuarioDto);

	Page<ResumenAnimalDto> getFavoritos(String idUsuario, Pageable pageable);

	void addFavorito(String idUsuario, String idAnimal);

	void removeFavorito(String idUsuario, String idAnimal);

}
