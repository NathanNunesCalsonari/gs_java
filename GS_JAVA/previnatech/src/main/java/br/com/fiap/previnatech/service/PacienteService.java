package br.com.fiap.previnatech.service;

import java.util.ArrayList;

import br.com.fiap.previnatech.data.PacienteDao;
import br.com.fiap.previnatech.model.Paciente;

public class PacienteService {
    private final PacienteDao pacienteDao;

    public PacienteService() {
        this.pacienteDao = new PacienteDao();
    }

    public ArrayList<Paciente> listaDePacientes() {
        return pacienteDao.listaDePacientes();
    }

    public Paciente obterPacientePorId(long pacienteId) {
        return pacienteDao.obterPacientePorId(pacienteId);
    }

    public boolean deletarPaciente(long pacienteId) {
        return pacienteDao.deletarPaciente(pacienteId);
    }

    public boolean novoPaciente(Paciente novoPaciente) {
        return pacienteDao.novoPaciente(novoPaciente);
    }

    public boolean atualizarPaciente(long pacienteId, Paciente paciente) {
        return pacienteDao.atualizarPaciente(pacienteId, paciente);
    }
}
