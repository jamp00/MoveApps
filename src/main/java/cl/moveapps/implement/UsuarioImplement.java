package cl.moveapps.implement;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.moveapps.model.Usuarios;
import cl.moveapps.repository.UsuariosRepository;

@Service
public class UsuarioImplement {

	private static final Logger logger = LogManager.getLogger(UsuarioImplement.class);
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public Usuarios registraUsuario(Usuarios usuario ) {

		logger.debug("cl.moveapps.implement.UsuarioImplement::registraUsuario: " + usuario.toString());

		return usuariosRepository.save(usuario);
	}

	public boolean existEmail(String email) {

		logger.debug("cl.moveapps.implement.UsuarioImplement::existEmail: " + email);

		Usuarios usuario = usuariosRepository.findByEmail(email);
		if (usuario == null)
			return false;

		return true;

	}

	public List<Usuarios> getUsuariosActivos(boolean active) {
		
		return usuariosRepository.findByIsActive(active);
		
	}
	
}
