package br.com.fiap.previnatech.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.previnatech.model.Paciente;

public class PacienteDao {
    public ArrayList<Paciente> listaDePacientes() {
        ArrayList<Paciente> paciente = new ArrayList<>();
        
        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "SELECT * FROM T_PVTC_PACIENTE";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    paciente.add(new Paciente(
                        rs.getLong("idPaciente"),
                        rs.getString("nomePaciente"),
                        rs.getString("cpfPaciente"),
                        rs.getString("rgPaciente"),
                        rs.getString("dataNascimento"),
                        rs.getString("sexoBiologico"),
                        rs.getString("tipoSanguineo"),
                        rs.getDouble("alturaPaciente"),
                        rs.getDouble("pesoPaciente")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }
    
    public Paciente obterPacientePorId(long pacienteId) {
        Paciente paciente = null;

        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "T_PVTC_PACIENTE WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setLong(1, pacienteId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    paciente = new Paciente(
                    	rs.getLong("idPaciente"),
                        rs.getString("nomePaciente"),
                        rs.getString("cpfPaciente"),
                        rs.getString("rgPaciente"),
                        rs.getString("dataNascimento"),
                        rs.getString("sexoBiologico"),
                        rs.getString("tipoSanguineo"),
                        rs.getDouble("alturaPaciente"),
                        rs.getDouble("pesoPaciente")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }
    
        public boolean deletarPaciente(long pacienteId) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "DELETE FROM T_PVTC_PACIENTE WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, pacienteId);
                    int rowsDeleted = pstmt.executeUpdate();

                    return rowsDeleted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean novoPaciente(Paciente novoPaciente) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "INSERT INTO T_PVTC_PACIENTE (ID_PACIENTE, NM_PACIENTE, NR_CPF, NR_RG, DT_NASCIMENTO, FL_SEXO_BIOLOGICO, NM_TIPO_SANGUINEO, NR_ALTURA, NR_PESO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, novoPaciente.idPaciente());
                    pstmt.setString(2, novoPaciente.nomePaciente());
                    pstmt.setString(3, novoPaciente.cpfPaciente());
                    pstmt.setString(4, novoPaciente.rgPaciente());
                    pstmt.setString(5, novoPaciente.dataNascimento());
                    pstmt.setString(6, novoPaciente.sexoBiologico());
                    pstmt.setString(7, novoPaciente.tipoSanguineo());
                    pstmt.setDouble(8, novoPaciente.alturaPaciente());
                    pstmt.setDouble(9, novoPaciente.pesoPaciente());

                    int rowsInserted = pstmt.executeUpdate();

                    return rowsInserted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean atualizarPaciente(long pacienteId, Paciente paciente) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "UPDATE INTO T_PVTC_PACIENTE SET NM_FUNC = ?, NR_CPF = ?, NR_RG = ?, DT_NASCIMENTO = ?, FL_SEXO_BIOLOGICO = ?, NM_TIPO_SANGUINEO = ?, NR_ALTURA = ?, NR_PESO = ? WHERE ID_FUNC = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, paciente.nomePaciente());
                    pstmt.setString(2, paciente.cpfPaciente());
		    pstmt.setString(3, paciente.rgPaciente());
                    pstmt.setString(4, paciente.dataNascimento());
                    pstmt.setString(5, paciente.sexoBiologico());
                    pstmt.setString(6, paciente.tipoSanguineo());
                    pstmt.setDouble(7, paciente.alturaPaciente());
                    pstmt.setDouble(8, paciente.pesoPaciente());
                    pstmt.setLong(9, pacienteId);

                    int rowsUpdated = pstmt.executeUpdate();

                    return rowsUpdated > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
}
