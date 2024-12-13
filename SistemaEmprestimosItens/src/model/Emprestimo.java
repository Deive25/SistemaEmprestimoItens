/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.util.Objects;

/**
 *
 * @author Desktop
 */
public class Emprestimo {
    private int id;
    private int idUsuario;
    private Usuario usuario;
    private Item item;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(int idUsuario, int idEmprestimo) {
        this.idUsuario = idUsuario;
        this.id = idEmprestimo;
    }
    
    public Emprestimo(int id, int idUsuario, String dataDevolucao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataDevolucao = dataDevolucao;
    }
    
     public Emprestimo(Usuario user, Item item, int id) {
        this.item = item;
        this.usuario = user;
        this.id = id;
    }

    public Emprestimo(int id, Usuario usuario, Item item, 
                      String dataEmprestimo, String dataDevolucao) {
        this.id = id;
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
