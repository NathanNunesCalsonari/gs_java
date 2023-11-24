package br.com.fiap.previnatech.model;

public record Hospital (
	Long idHospital,
	String nomeHospital,
	String dataFundacao,
	String especialidadeHospital
	
) {}