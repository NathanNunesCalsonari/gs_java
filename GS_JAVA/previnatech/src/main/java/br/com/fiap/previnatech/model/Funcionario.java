package br.com.fiap.previnatech.model;

import java.math.BigDecimal;

public record Funcionario (
		
	Long idFuncionario,
	String nomeFuncionario,
	String cpfFuncionario,
	String rgFuncionario,
	String dataDeNascimento,
	BigDecimal salario

) {}
