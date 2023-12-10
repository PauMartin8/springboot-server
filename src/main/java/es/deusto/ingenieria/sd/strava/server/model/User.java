package es.deusto.ingenieria.sd.strava.server.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//"User" is a reserved word in many DBs. We can programmatically provide a name for the table to avoid problems.
@Table(name="userTable")
@Entity
public class User {
	
	private String contr;
	
	@Id
	@Column(unique = true)
	private String email;

	public User() {
	}

	public User(String contrasena, String email) {
		this.contr = contrasena;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContrasena() {
		return contr;
	}

	public void setContrasena(String contrasena) {
		this.contr = contrasena;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", " + contr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email);
	}
}
