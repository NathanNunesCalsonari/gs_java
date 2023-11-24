package br.com.fiap.previnatech.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.previnatech.model.Hospital;

public class HospitalDao {
    public ArrayList<Hospital> listaDeHospitais() {
        ArrayList<Hospital> hospital = new ArrayList<>();
        
        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "SELECT * FROM T_PVTC_UNID_HOSPITALAR";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    hospital.add(new Hospital(
                        rs.getLong("idHospital"),
                        rs.getString("nomeHospital"),
                        rs.getString("dataFundacao"),
                        rs.getString("especialidadeHospital")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospital;
    }
    
    public Hospital obterHospitalPorId(long hospitalId) {
        Hospital hospital = null;

        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "T_PVTC_UNID_HOSPITALAR WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setLong(1, hospitalId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    hospital = new Hospital(
                    	rs.getLong("idHospital"),
                        rs.getString("nomeHospital"),
                        rs.getString("dataFundacao"),
                        rs.getString("especialidadeHospital")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hospital;
    }
    
        public boolean deletarHospital(long hospitalId) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "DELETE FROM T_PVTC_UNID_HOSPITALAR WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, hospitalId);
                    int rowsDeleted = pstmt.executeUpdate();

                    return rowsDeleted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean novoHospital(Hospital novoHospital) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "INSERT INTO T_PVTC_UNID_HOSPITALAR (ID_HOSPITAL, NM_HOSPITAL, DT_FUNDACAO, DS_ESPECIALIDADE) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, novoHospital.idHospital());
                    pstmt.setString(2, novoHospital.nomeHospital());
                    pstmt.setString(3, novoHospital.dataFundacao());
		    pstmt.setString(4, novoHospital.especialidadeHospital());

                    int rowsInserted = pstmt.executeUpdate();

                    return rowsInserted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean atualizarHospital(long hospitalId, Hospital hospital) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "UPDATE INTO T_PVTC_UNID_HOSPITALAR SET NM_HOSPITAL = ?, DT_FUNDACAO = ?, DS_ESPECIALIDADE WHERE ID_FUNC = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, hospital.nomeHospital());
                    pstmt.setString(2, hospital.dataFundacao());
                    pstmt.setString(3, hospital.especialidadeHospital());
                    pstmt.setLong(4, hospitalId);

                    int rowsUpdated = pstmt.executeUpdate();

                    return rowsUpdated > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
}
