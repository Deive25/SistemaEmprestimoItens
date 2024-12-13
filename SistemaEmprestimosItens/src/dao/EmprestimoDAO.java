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
        String sql = "INSERT INTO Emprestimo (Usuario_idUsuario, Item_idItem) VALUES (?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getUsuario().getId());
            stmt.setInt(2, emprestimo.getItem().getId());
            
            //stmt.setString(3, emprestimo.getDataDevolucao());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir empréstimo: " + ex.getMessage());
        }
    }

    public Emprestimo getEmprestimo(int id) {
        String sql = "SELECT * FROM Emprestimo WHERE idEmprestimo = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
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
            String sql = "UPDATE Emprestimo SET Usuario_idUsuario = ?, Item_idItem = ?, dataDevolucao = ? WHERE idEmprestimo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emprestimo.getUsuario().getId());
            stmt.setInt(2, emprestimo.getItem().getId());
            stmt.setString(3, emprestimo.getDataDevolucao());
            stmt.setInt(4, emprestimo.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar empréstimo: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Emprestimo WHERE idEmprestimo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir empréstimo: " + ex.getMessage());
        }
    }
    
    public List<Emprestimo> getTodosEmprestimos() {
        String sql = "SELECT * FROM Emprestimo";
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

    public Emprestimo buscarEmprestimoInfo(int idItem) {
        String sql = "SELECT idEmprestimo, Usuario_idUsuario FROM Emprestimo WHERE Item_idItem = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idItem);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idEmprestimo = rs.getInt("idEmprestimo");
                int idUsuario = rs.getInt("Usuario_idUsuario");
                return new Emprestimo(idUsuario, idEmprestimo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar informações do empréstimo: " + ex.getMessage());
        }
        return null; // Retorna null se não encontrar
    }
    
    public int buscarIdEmprestimo(int idUsuario, int idItem) {
        String sql = "SELECT idEmprestimo FROM Emprestimo WHERE Usuario_idUsuario = ? AND Item_idItem = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idItem);
            ResultSet rs = stmt.executeQuery();
        
            if (rs.next()) {
                return rs.getInt("idEmprestimo");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar ID do empréstimo: " + ex.getMessage());
        }
        return -1; // Retorna -1 se não encontrar
    } 
    
    public Emprestimo buscarEmprestimo(int idUsuario, int idItem) {
        String sql = "SELECT * FROM Emprestimo WHERE Usuario_idUsuario = ? AND Item_idItem = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idItem);
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

    private Emprestimo extrairEmprestimoDoResultSet(ResultSet rs) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ItemDAO itemDAO = new ItemDAO();

        return new Emprestimo(
                rs.getInt("idEmprestimo"),
                usuarioDAO.getUsuario(rs.getInt("Usuario_idUsuario")),
                itemDAO.getItem(rs.getInt("Item_idItem")),
                rs.getString("dataEmprestimo"),
                rs.getString("dataDevolucao")
        );
    }
    
    public List<Emprestimo> getEmprestimosAtrasados() {
        String sql = "SELECT * FROM Emprestimo WHERE dataLimiteDevolucao < CURRENT_DATE";
        List<Emprestimo> listaEmprestimosAtrasados = new ArrayList<>();
        
        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                listaEmprestimosAtrasados.add(extrairEmprestimoDoResultSet(rs));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar emprestimos atrasados: " + ex.getMessage());
        }
        return listaEmprestimosAtrasados;
    }
}
