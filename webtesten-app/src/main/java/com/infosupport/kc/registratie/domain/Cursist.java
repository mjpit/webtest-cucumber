package com.infosupport.kc.registratie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cursist {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String gebruikersnaam;
	private String email;
	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void activate() {
		this.active = true;
	}

	public Cursist() {
	}

	public Cursist(String gebruikersnaam, String email) {
		this.gebruikersnaam = gebruikersnaam;
		this.email = email;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Cursist)) {
			return false;
		}

		Cursist cursist = (Cursist) o;
		if (!gebruikersnaam.equals(cursist.gebruikersnaam)) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		return gebruikersnaam.hashCode();
	}

	public void setGebruikersnaam(String naam) {
		gebruikersnaam = naam;
	}
}
