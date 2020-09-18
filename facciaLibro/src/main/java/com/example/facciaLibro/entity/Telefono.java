package com.example.facciaLibro.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefono {
	
	
	
	
	
	public Telefono() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numero;

	private LocalDateTime dataCreazione=LocalDateTime.now();
	private LocalDateTime dataModifica=LocalDateTime.now();
	
	
	
	public Integer getnumero() {
		return numero;
	}
	public void senumero(Integer numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public LocalDateTime getDataModifica() {
		return dataModifica;
	}
	public void setDataModifica(LocalDateTime dataModifica) {
		this.dataModifica = dataModifica;
	}
	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numero=" + numero + 
				 ", dataCreazione=" + dataCreazione + ", dataModifica=" + dataModifica + "]";
	}
	
	
	
	

}
