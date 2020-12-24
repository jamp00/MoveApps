package cl.moveapps.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.moveapps.implement.UsuarioImplement;
import cl.moveapps.model.Usuarios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping(value="/usuarios/", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

	private static final Logger logger = LogManager.getLogger(UsuarioController.class);

	private final String PREFIX = "Bearer ";
	private final String HEADER = "Authorization";

	@Autowired
	private UsuarioImplement usuarioImplement;

	@GetMapping("/hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}

	// Crea registro Usuario
	@PostMapping("/registro")
	public ResponseEntity<Object> registroUsuario(HttpServletRequest request, @RequestBody @Valid Usuarios usuario ) {
		
		if (usuarioImplement.existEmail(usuario.getEmail())) {
			
			logger.warn("Email ya registrado");
			
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("El correo ya registrado");
		}
		
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		usuario.setToken(jwtToken);
		
		return new ResponseEntity<Object>(usuarioImplement.registraUsuario(usuario), HttpStatus.CREATED);

	}

	@GetMapping("/usuariosActivos")
	public ResponseEntity<Object> getUsuariosAvtivos(){
		
		try {
			return new ResponseEntity<Object>( usuarioImplement.getUsuariosActivos(true), HttpStatus.OK );
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity
		            .status(HttpStatus.BAD_REQUEST)
		            .body("ERROR");
		}
	}
	
	
}
