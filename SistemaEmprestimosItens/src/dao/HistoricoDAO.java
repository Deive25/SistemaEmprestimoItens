/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Historico;

public class HistoricoDAO {
    private Conexao conexao;
    private Connection conn;

    public HistoricoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Historico historico) {
        String sql = "INSERT INTO Historico (id_usuario, id_item, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, historico.getUsuario().getId());
            stmt.setInt(2, historico.getItem().getId());
            stmt.setString(3, historico.getDataEmprestimo());
            stmt.setString(4, historico.getDataDevolucao());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir registro de histórico: " + ex.getMessage());
        }
    }

    public Historico getHistorico(int id) {
        String sql = "SELECT * FROM Historico WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairHistoricoDoResultSet(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar registro de histórico: " + ex.getMessage());
            return null;
        }
    }

    public void editarHistorico(Historico historico) {
        try {
            String sql = "UPDATE Historico SET id_usuario=?, id_item=?, data_emprestimo=?, data_devolucao=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, historico.getUsuario().getId());
            stmt.setInt(2, historico.getItem().getId());
            stmt.setString(3, historico.getDataEmprestimo());
            stmt.setString(4, historico.getDataDevolucao());
            stmt.setInt(5, historico.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar registro de histórico: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Historico WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir registro de histórico: " + ex.getMessage());
        }
    }
    
    public List<Historico> getTodosHistoricos() {
        String sql = "SELECT * FROM Historico";
        List<Historico> listaHistoricos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                listaHistoricos.add(extrairHistoricoDoResultSet(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar históricos: " + ex.getMessage());
        }
        return listaHistoricos;
    }

    private Historico extrairHistoricoDoResultSet(ResultSet rs) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ItemDAO itemDAO = new ItemDAO();
        
        return new Historico(
                rs.getInt("id"),
                usuarioDAO.getUsuario(rs.getInt("id_usuario")),
                itemDAO.getItem(rs.getInt("id_item")),
                rs.getString("data_emprestimo"),
                rs.getString("data_devolucao")
        );
    }
}
