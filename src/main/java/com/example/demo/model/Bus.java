package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String mod_bus;
	@NotNull
	private String placa_bus;
	@NotNull
	private Integer cap_bus;
	

	public String getMod_bus() {
		return mod_bus;
	}
	public void setMod_bus(String mod_bus) {
		this.mod_bus = mod_bus;
	}
	public String getPlaca_bus() {
		return placa_bus;
	}
	public void setPlaca_bus(String placa_bus) {
		this.placa_bus = placa_bus;
	}
	public Integer getCap_bus() {
		return cap_bus;
	}
	public void setCap_bus(Integer cap_bus) {
		this.cap_bus = cap_bus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Bus [id=" + id + ", mod_bus=" + mod_bus + ", placa_bus=" + placa_bus + ", cap_bus=" + cap_bus + "]";
	}

	
	
}
