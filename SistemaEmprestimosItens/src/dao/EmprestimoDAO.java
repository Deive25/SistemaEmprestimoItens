/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
/**
 *
 * @author Desktop
 */
public class EmprestimoDAO {
    private Conexao conexao;
    private Connection conn;

    public EmprestimoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo (id_usuario, id_item, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getUsuario().getId());
            stmt.setInt(2, emprestimo.getItem().getId());
            stmt.setString(3, emprestimo.getDataEmprestimo());
            stmt.setString(4, emprestimo.getDataDevolucao());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir empréstimo: " + ex.getMessage());
        }
    }

    public Emprestimo getEmprestimo(int id) {
        String sql = "SELECT * FROM emprestimo WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairEmprestimoDoResultSet(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar empréstimo: " + ex.getMessage());
            return null;
        }
    }

    public void editarEmprestimo(Emprestimo emprestimo) {
        try {
            String sql = "UPDATE emprestimo SET id_usuario=?, id_item=?, data_emprestimo=?, data_devolucao=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getUsuario().getId());
            stmt.setInt(2, emprestimo.getItem().getId());
            stmt.setString(3, emprestimo.getDataEmprestimo());
            stmt.setString(4, emprestimo.getDataDevolucao());
            stmt.setInt(5, emprestimo.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar empréstimo: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM emprestimo WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir empréstimo: " + ex.getMessage());
        }
    }
    
    public List<Emprestimo> getTodosEmprestimos() {
        String sql = "SELECT * FROM emprestimo";
        List<Emprestimo> listaEmprestimos = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                listaEmprestimos.add(extrairEmprestimoDoResultSet(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar empréstimos: " + ex.getMessage());
        }
        return listaEmprestimos;
    }

    private Emprestimo extrairEmprestimoDoResultSet(ResultSet rs) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ItemDAO itemDAO = new ItemDAO();
        
        return new Emprestimo(
                rs.getInt("id"),
                usuarioDAO.getUsuario(rs.getInt("id_usuario")),
                itemDAO.getItem(rs.getInt("id_item")),
                rs.getString("data_emprestimo"),
                rs.getString("data_devolucao")
        );
    }
}
