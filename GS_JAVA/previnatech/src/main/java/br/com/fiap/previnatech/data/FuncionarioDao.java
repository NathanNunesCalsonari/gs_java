package br.com.fiap.previnatech.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.previnatech.model.Funcionario;

public class FuncionarioDao {
    public ArrayList<Funcionario> listaDeFuncionarios() {
        ArrayList<Funcionario> funcionario = new ArrayList<>();
        
        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "SELECT * FROM T_PVTC_FUNCIONARIO";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    funcionario.add(new Funcionario(
                        rs.getLong("id"),
                        rs.getString("nomeFuncionario"),
                        rs.getString("cpfFuncionario"),
                        rs.getString("rgFuncionario"),
                        rs.getString("dataDeNascimento"),
                        rs.getBigDecimal("salario")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
    
    public Funcionario obterFuncionarioPorId(long funcionarioId) {
        Funcionario funcionario = null;

        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "T_PVTC_FUNCIONARIO WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setLong(1, funcionarioId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    funcionario = new Funcionario(
                    		rs.getLong("id"),
                            rs.getString("nomeFuncionario"),
                            rs.getString("cpfFuncionario"),
                            rs.getString("rgFuncionario"),
                            rs.getString("dataDeNascimento"),
                            rs.getBigDecimal("salario")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
    
        public boolean deletarFuncionario(long funcionarioId) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "DELETE FROM T_PVTC_FUNCIONARIO WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, funcionarioId);
                    int rowsDeleted = pstmt.executeUpdate();

                    return rowsDeleted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean novoFuncionario(Funcionario novoFuncionario) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "INSERT INTO T_PVTC_FUNCIONARIO (ID_FUNC, NM_FUNC, NR_CPF, NR_RG, DT_NASCIMENTO, VL_SALARIO) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, novoFuncionario.idFuncionario());
                    pstmt.setString(2, novoFuncionario.nomeFuncionario());
                    pstmt.setString(3, novoFuncionario.cpfFuncionario());
		    pstmt.setString(4, novoFuncionario.rgFuncionario());
                    pstmt.setString(5, novoFuncionario.dataDeNascimento());
                    pstmt.setBigDecimal(6, novoFuncionario.salario());

                    int rowsInserted = pstmt.executeUpdate();

                    return rowsInserted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean atualizarFuncionario(long funcionarioId, Funcionario funcionario) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "UPDATE INTO T_PVTC_FUNCIONARIO SET NM_FUNC = ?, NR_CPF = ?, NR_RG = ?, DT_NASCIMENTO = ?, VL_SALARIO = ? WHERE ID_FUNC = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, funcionario.nomeFuncionario());
                    pstmt.setString(2, funcionario.cpfFuncionario());
		    pstmt.setString(3, funcionario.rgFuncionario());
                    pstmt.setString(4, funcionario.dataDeNascimento());
                    pstmt.setBigDecimal(5, funcionario.salario());
                    pstmt.setLong(6, funcionarioId);

                    int rowsUpdated = pstmt.executeUpdate();

                    return rowsUpdated > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
}