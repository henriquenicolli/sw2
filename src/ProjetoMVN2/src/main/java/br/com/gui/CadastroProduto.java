/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gui;

import br.com.DAO.ProdutoDAO;
import br.com.modelo.Produto;

/**
 *
 * @author Andressa
 */
public class CadastroProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProduto
     */
    public CadastroProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JLCodigoProduto = new javax.swing.JLabel();
        JLNomeProduto = new javax.swing.JLabel();
        JLDescricaoProduto = new javax.swing.JLabel();
        JTCodigoProduto = new javax.swing.JTextField();
        JTNomeProduto = new javax.swing.JTextField();
        JTDescricaoProduto = new javax.swing.JTextField();
        JTCategoria = new javax.swing.JTextField();
        JLCategoria = new javax.swing.JLabel();
        JBCadastrarProduto = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cadastro de Produtos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 14, -1, 16));

        JLCodigoProduto.setText("Código:");
        getContentPane().add(JLCodigoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, 50, -1));

        JLNomeProduto.setText("Nome:");
        getContentPane().add(JLNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 111, 50, -1));

        JLDescricaoProduto.setText("Descrição:");
        getContentPane().add(JLDescricaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 152, -1, -1));
        getContentPane().add(JTCodigoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 59, 243, -1));
        getContentPane().add(JTNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 108, 243, -1));
        getContentPane().add(JTDescricaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 149, 243, -1));
        getContentPane().add(JTCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 187, 243, -1));

        JLCategoria.setText("Categoria:");
        getContentPane().add(JLCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 68, -1));

        JBCadastrarProduto.setText("Cadastrar Produto");
        JBCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(JBCadastrarProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 250, -1, -1));

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(JBVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        setSize(new java.awt.Dimension(362, 322));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarProdutoActionPerformed
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        
        
        produto.setCodigoProduto(Integer.parseInt(JTCodigoProduto.getText()));
        produto.setNome(JTNomeProduto.getText());
        produto.setDescricao(JTDescricaoProduto.getText());
        produto.setCategoria(JTCategoria.getText());
        produtoDAO.salvar(produto);
        
        System.out.println("Produto cadastrado");
        
    }//GEN-LAST:event_JBCadastrarProdutoActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        dispose();

    }//GEN-LAST:event_JBVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrarProduto;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JLabel JLCategoria;
    private javax.swing.JLabel JLCodigoProduto;
    private javax.swing.JLabel JLDescricaoProduto;
    private javax.swing.JLabel JLNomeProduto;
    private javax.swing.JTextField JTCategoria;
    private javax.swing.JTextField JTCodigoProduto;
    private javax.swing.JTextField JTDescricaoProduto;
    private javax.swing.JTextField JTNomeProduto;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
