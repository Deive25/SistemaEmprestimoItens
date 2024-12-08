/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Desktop
 */
public class Item {
    private int id;
    private String nome;
    private String categoria;
    private String estado;
    private String totalEmprestimos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotalEmprestimos() {
        return totalEmprestimos;
    }

    public void setTotalEmprestimos(String totalEmprestimos) {
        this.totalEmprestimos = totalEmprestimos;
    }
}
