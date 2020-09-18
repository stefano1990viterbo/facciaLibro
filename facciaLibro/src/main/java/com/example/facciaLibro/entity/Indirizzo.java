package com.example.facciaLibro.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {
	
	
	
	public Indirizzo() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String via;
	private String civico;
	private String comune;
	private String provincia;
	private LocalDateTime dataCreazione=LocalDateTime.now();
	private LocalDateTime dataModifica=LocalDateTime.now();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
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
		return "Indirizzo [id=" + id + ", via=" + via + ", civico=" + civico + ", comune=" + comune + ", provincia="
				+ provincia + ", dataCreazione=" + dataCreazione + ", dataModifica=" + dataModifica + "]";
	}
	
}
