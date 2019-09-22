package cupones;

import java.io.Serializable;

public class DatosCupon implements Serializable {
	private static final long serialVersionUID = 1L;
	private String names;
	private String surnames;
	private String dni;
	private String email;
	private String room;
	private String date;
	private String sala;
	public DatosCupon() { 
    } 
	public void setRoom(String room) { 
        this.room = room; 
    } 
	public String getRoom() { 
        return room; 
    }
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurnames() {
		return surnames;
	}
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	} 
}
