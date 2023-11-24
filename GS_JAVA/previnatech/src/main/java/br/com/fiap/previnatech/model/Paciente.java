package br.com.fiap.previnatech.model;

public record Paciente (
	
	 Long idPaciente,
	 String nomePaciente,
	 String cpfPaciente,
	 String rgPaciente,
	 String dataNascimento,
	 String sexoBiologico,
	 String tipoSanguineo,
	 Double alturaPaciente,
	 Double pesoPaciente
	
) {}
