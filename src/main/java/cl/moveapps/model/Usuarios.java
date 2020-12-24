package cl.moveapps.model;

import java.time.LocalDate;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;


import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Usuarios {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	private UUID idUsuario;

	@Email(message = "Email incorrecto")
	private String email;

	@Pattern(regexp = "[A-Z][a-z]*[0-9]{2}", message = "Contraseña incorrecta")
	private String password;

	@OneToMany(mappedBy="usuario")
	private List<Phones> phones;
	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate created;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate modified;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate lastLogin;

	private String token;

	private boolean isActive;

	public Usuarios() {

		this.created = LocalDate.now();
		this.modified = LocalDate.now();
		this.lastLogin = LocalDate.now();

		this.isActive = true;
		
	}

	public Usuarios(String email, String password, List<Phones> phones, String token) {
		super();

		this.email = email;
		this.password = password;
		this.token = token;
		this.phones = phones;

	}


	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}

	public UUID getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UUID idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getModified() {
		return modified;
	}

	public void setModified(LocalDate modified) {
		this.modified = modified;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", email=" + email + ", password=" + password + ", created="
				+ created + ", modified=" + modified + ", lastLogin=" + lastLogin + ", token=" + token + ", phones="
				+ phones + "]";
	}

	
}
