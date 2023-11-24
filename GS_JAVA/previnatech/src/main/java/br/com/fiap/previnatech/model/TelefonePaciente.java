package br.com.fiap.previnatech.model;

public class TelefonePaciente {
	
	public Long idTelefonePaciente;
	public int numeroDdi;
	public int numeroDdd;
	public int numeroTelefone;
	public String tipoDeTelefone;
	public String statusTelefone;
	
	public Long getIdTelefonePaciente() {
		return idTelefonePaciente;
	}
	
	public void setIdTelefonePaciente(Long idTelefonePaciente) {
		this.idTelefonePaciente = idTelefonePaciente;
	}
	
	public int getNumeroDdi() {
		return numeroDdi;
	}
	
	public void setNumeroDdi(int numeroDdi) {
		this.numeroDdi = numeroDdi;
	}
	
	public int getNumeroDdd() {
		return numeroDdd;
	}
	
	public void setNumeroDdd(int numeroDdd) {
		this.numeroDdd = numeroDdd;
	}
	
	public int getNumeroTelefone() {
		return numeroTelefone;
	}
	
	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	public String getTipoDeTelefone() {
		return tipoDeTelefone;
	}
	public void setTipoDeTelefone(String tipoDeTelefone) {
		this.tipoDeTelefone = tipoDeTelefone;
	}
	
	public String getStatusTelefone() {
		return statusTelefone;
	}
	
	public void setStatusTelefone(String statusTelefone) {
		this.statusTelefone = statusTelefone;
	}
	
	

}
