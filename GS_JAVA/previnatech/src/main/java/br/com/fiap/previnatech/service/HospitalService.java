package br.com.fiap.previnatech.service;

import br.com.fiap.previnatech.data.HospitalDao;
import br.com.fiap.previnatech.model.Hospital;

import java.util.ArrayList;

public class HospitalService {
    private final HospitalDao hospitalDao;

    public HospitalService() {
        this.hospitalDao = new HospitalDao();
    }

    public ArrayList<Hospital> listaDeHospitais() {
        return hospitalDao.listaDeHospitais();
    }

    public Hospital obterHospitalPorId(long hospitalId) {
        return hospitalDao.obterHospitalPorId(hospitalId);
    }

    public boolean deletarHospital(long hospitalId) {
        return hospitalDao.deletarHospital(hospitalId);
    }

    public boolean novoHospital(Hospital novoHospital) {
        return hospitalDao.novoHospital(novoHospital);
    }

    public boolean atualizarHospital(long hospitalId, Hospital hospital) {
        return hospitalDao.atualizarHospital(hospitalId, hospital);
    }
}
