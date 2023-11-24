package br.com.fiap.previnatech.model;

public class EnderecoHospital {
	
	public Long idEnderecoHospitalar;
	public int numeroLogradouro;
	public String complemento;
	
	public Long getIdEnderecoHospitalar() {
		return idEnderecoHospitalar;
	}
	public void setIdEnderecoHospitalar(Long idEnderecoHospitalar) {
		this.idEnderecoHospitalar = idEnderecoHospitalar;
	}
	public int getNumeroLogradouro() {
		return numeroLogradouro;
	}
	public void setNumeroLogradouro(int numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
}
