package cl.moveapps.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.moveapps.model.Usuarios;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Serializable> {

	public Usuarios findByEmail(String email);
	
	public List<Usuarios> findByIsActive(boolean active);

}

