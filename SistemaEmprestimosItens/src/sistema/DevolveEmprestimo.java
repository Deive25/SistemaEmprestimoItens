/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import dao.EmprestimoDAO;
import dao.ItemDAO;
import dao.UsuarioDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Item;
import model.Usuario;

/**
 *
 * @author gabriel
 */
public class DevolveEmprestimo extends javax.swing.JFrame {

    /**
     * Creates new form RegistraEmprestimoEditar
     */
    public DevolveEmprestimo() {
        initComponents();
        preencherComboItens();
    }

    public void atualizar(){
        preencherComboItens();
    }

    public void preencherComboItens(){
        ItemDAO iDAO = new ItemDAO();
        List<Item> ListaItens = iDAO.getEmprestados(); // Obtem os itens emprestados atualizados
        comboBoxItem.removeAllItems(); // Limpa a comboBox para evitar duplicação

        for(Item i : ListaItens){
            comboBoxItem.addItem(i.getNome()); // Adiciona os itens à comboBox
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDevolver = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        txtIdEmprestimo = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JToggleButton();
        btnConsultar = new javax.swing.JToggleButton();
        comboBoxItem = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("Devolver Emprestimo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Itens Emprestados:");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btnDevolver.setText("Devolver Emprestimo");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(102, 255, 51));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));

        btnExcluir.setText("Excluir Emprestimo");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar Emprestimo");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(190, 190, 190))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultar)
                    .addComponent(txtIdEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDevolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Id Emprestimo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBoxItem, 0, 264, Short.MAX_VALUE)
                        .addComponent(txtUser))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a pessoa do banco?","Exclusão",JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION){
            EmprestimoDAO edao = new EmprestimoDAO();
                       
            edao.excluir(Integer.parseInt(txtIdEmprestimo.getText()));
            atualizar();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            EmprestimoDAO eDao = new EmprestimoDAO();
            ItemDAO iDAO = new ItemDAO();
            UsuarioDAO uDAO = new UsuarioDAO();

            String nomeItem = (String) comboBoxItem.getSelectedItem();

            int idItem = iDAO.buscarIdItemPorNome(nomeItem);

            Emprestimo e = eDao.buscarEmprestimoInfo(idItem);

            if (e == null) {
                JOptionPane.showMessageDialog(this, "Empréstimo não encontrado para o item selecionado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nomeUsuario = uDAO.buscarNomeUsuarioPorId(e.getIdUsuario());

            if (nomeUsuario == null) {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado para o empréstimo!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            txtUser.setText(nomeUsuario);
            String idd = String.valueOf(e.getId());
            txtIdEmprestimo.setText(idd);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            System.out.println("Iniciando a ação de editar empréstimo...");

            // Instancia os DAOs necessários
            EmprestimoDAO eDAO = new EmprestimoDAO();
            UsuarioDAO uDAO = new UsuarioDAO();
            ItemDAO iDAO = new ItemDAO();
            System.out.println("DAOs instanciados.");

            // Obtém o nome do usuário do campo de texto
            String nomeUsuario = txtUser.getText().trim();
            String nomeItem = (String) comboBoxItem.getSelectedItem();
            System.out.println("Nome do usuário: " + nomeUsuario);
            System.out.println("Nome do item: " + nomeItem);

            // Valida o campo de texto do usuário
            if (nomeUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, insira o nome do usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro: Nome do usuário não foi inserido.");
                return;
            }   

            // Busca o usuário pelo nome
            Usuario u = uDAO.buscarUsuarioPorNome(nomeUsuario);
            if (u == null) {
                JOptionPane.showMessageDialog(null, "Usuário '" + nomeUsuario + "' não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro: Usuário '" + nomeUsuario + "' não encontrado.");
                return;
            }
            
            System.out.println("Usuário encontrado: ID = " + u.getId());

            // Busca o item pelo nome
            Item i = iDAO.buscarItemPorNome(nomeItem);
            if (i == null) {
                JOptionPane.showMessageDialog(null, "Item '" + nomeItem + "' não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro: Item '" + nomeItem + "' não encontrado.");
                return;
            }
            
            System.out.println("Item encontrado: ID = " + i.getId());

            // Busca o empréstimo existente com base no ID do usuário e do item
            Emprestimo emprestimoExistente = eDAO.buscarEmprestimo(u.getId(), i.getId());
            
            if (emprestimoExistente == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar o empréstimo para:\nUsuário: " + nomeUsuario + "\nItem: " + nomeItem, "Erro", JOptionPane.ERROR_MESSAGE);
                System.out.println("Erro: Empréstimo não encontrado para Usuário = " + nomeUsuario + ", Item = " + nomeItem);
                return;
            }
            
            System.out.println("Empréstimo encontrado: ID = " + emprestimoExistente.getId());

            // Atualiza a data de devolução do empréstimo existente
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            emprestimoExistente.setDataDevolucao(agora.format(formatador));
            System.out.println("Nova data de devolução: " + emprestimoExistente.getDataDevolucao());

            // Salva as alterações do empréstimo no banco de dados
            eDAO.editarEmprestimo(emprestimoExistente);
            System.out.println("Empréstimo atualizado no banco de dados.");

            eDAO.excluir(emprestimoExistente.getId());
    
            // Exibe mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Empréstimo devolvido com sucesso!", "Operação Concluída", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Operação concluída com sucesso.");
            txtUser.setText("");
            txtIdEmprestimo.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao devolver o empréstimo: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro ao devolver o empréstimo: " + ex.getMessage());
            ex.printStackTrace(); // Mostra detalhes do erro no console
        }
        atualizar();
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DevolveEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevolveEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevolveEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevolveEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevolveEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnConsultar;
    private javax.swing.JToggleButton btnDevolver;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JComboBox comboBoxItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtIdEmprestimo;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
