package com.example.facciaLibro.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titolo;
	private String testo;
	private LocalDateTime dataCreazione=LocalDateTime.now();
	
//	private Long idUtente;
//	private String nomeUtente;
	
	private String dataFormattata;
	
	@ManyToOne
	private Utente utenteCreazione;
	
	public Utente getUtenteCreazione() {
		return utenteCreazione;
	}
	public void setUtenteCreazione(Utente utenteCreazione) {
		this.utenteCreazione = utenteCreazione;
	}
	
	
	public String getDataFormattata() {
		return dataFormattata;
	}
	public void setDataFormattata(String dataFormattata) {
		this.dataFormattata = dataFormattata;
	}
	

//		public String getNomeUtente() {
//		return nomeUtente;
//	}
//	public void setNomeUtente(String nomeUtente) {
//		this.nomeUtente = nomeUtente;
//	}
//	public Long getIdUtente() {
//		return idUtente;
//	}
//	public void setIdUtente(Long idUtente) {
//		this.idUtente = idUtente;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public LocalDateTime getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(LocalDateTime dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", titolo=" + titolo + ", testo=" + testo + ", dataCreazione=" + dataCreazione
				+ ", idUtente=" + "]";
	}
	
	
	

}
