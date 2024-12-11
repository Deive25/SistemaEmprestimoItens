/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import conexao.Conexao;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Desktop
 */
public class UsuarioDAO {
    private Conexao conexao;
    private Connection conn;

    public UsuarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, matricula, contato) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setString(3, usuario.getContato());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir usuário: " + ex.getMessage());
        }
    }

    public Usuario getUsuario(int id) {
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(id);
                u.setNome(rs.getString("nome"));
                u.setMatricula(rs.getString("matricula"));
                u.setContato(rs.getString("contato"));
                return u;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuário: " + ex.getMessage());
            return null;
        }
    }

    public void editarUsuario(Usuario usuario) {
        try {
            String sql = "UPDATE Usuario SET nome=?, matricula=?, contato=? WHERE idUsuario=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getMatricula());
            stmt.setString(3, usuario.getContato());
            stmt.setInt(4, usuario.getId());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar usuário: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM Usuario WHERE idUsuario=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuário: " + ex.getMessage());
        }
    }
    
    public List<Usuario> getTodosUsuarios() {
        String sql = "SELECT * FROM Usuario";
        List<Usuario> listaUsuarios = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setMatricula(rs.getString("matricula"));
                u.setContato(rs.getString("contato"));
                listaUsuarios.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuários: " + ex.getMessage());
        }
        return listaUsuarios;
    }
}
