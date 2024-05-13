package com.railway.ticket.booking.system.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@Column(name = "EMAIL",length = 100)
	private String email;
	@Column(name = "F_NAME",length = 50, nullable = false)
	private String fname;
	@Column(name = "L_NAME",length = 50)
	private String lname;
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Passenger [email=" + email + ", fname=" + fname + ", lname=" + lname + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, fname, lname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(lname, other.lname);
	}
	

}
