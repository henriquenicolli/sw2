/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gui;

import br.com.DAO.UsuarioDAO;
import br.com.modelo.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fabi
 */
public class GerenciarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form GerenciarUsuario
     */
    public GerenciarUsuario() {
        initComponents();
        this.bloquearForm();
        this.editarBt.setEnabled(false);
        this.excluirBt.setEnabled(false);
        this.atualizaTabela();
    }

    public void limpaForm() {
        this.idText.setText("");
        this.nomeText.setText("");
        this.usuarioText.setText("");
        this.senhaText.setText("");
    }

    public void bloquearForm() {
        this.idLabel.setEnabled(false);
        this.idText.setEnabled(false);

        this.nomeLabel.setEnabled(false);
        this.nomeText.setEnabled(false);

        this.usuarioLabel.setEnabled(false);
        this.usuarioText.setEnabled(false);

        this.senhaLabel.setEnabled(false);
        this.senhaText.setEnabled(false);

        this.salvarBt.setEnabled(false);
        this.cancelarBt.setEnabled(false);
    }

    public void desbloquearForm() {
        this.nomeLabel.setEnabled(true);
        this.nomeText.setEnabled(true);

        this.usuarioLabel.setEnabled(true);
        this.usuarioText.setEnabled(true);

        this.senhaLabel.setEnabled(true);
        this.senhaText.setEnabled(true);

        this.salvarBt.setEnabled(true);
        this.cancelarBt.setEnabled(true);
    }

    public void editar() {
        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario = dao.get(Integer.parseInt(this.listaTabela.getModel().getValueAt(this.listaTabela.getSelectedRow(), 0).toString()));

        this.idText.setText(Integer.toString(usuario.getId()));
        this.nomeText.setText(usuario.getNome());
        this.usuarioText.setText(usuario.getUsuario());
        this.senhaText.setText(usuario.getSenha());

        this.desbloquearForm();
    }

    public void excluir() {
        new UsuarioDAO().deletar(Integer.parseInt(this.listaTabela.getModel().getValueAt(this.listaTabela.getSelectedRow(), 0).toString()));
        JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
        this.atualizaTabela();
    }

    public void salvar() {
        Usuario usuario = new Usuario();

        if (!this.idText.getText().isEmpty()) {
            usuario.setId(Integer.parseInt(this.idText.getText()));
        }

        if (!this.validaCampo(this.nomeText.getText(), "Insira o nome do usuário")) {
            return;
        }
        if (!this.validaCampo(this.usuarioText.getText(), "Insira um nome de usuário")) {
            return;
        }
        if (!this.validaCampo(this.senhaText.getText(), "Insira uma senha para o usuário")) {
            return;
        }

        usuario.setNome(this.nomeText.getText());
        usuario.setUsuario(this.usuarioText.getText());
        usuario.setSenha(this.senhaText.getText());

        new UsuarioDAO().salvar(usuario);

        JOptionPane.showMessageDialog(null, "Feito com sucesso!");

        this.bloquearForm();
        this.limpaForm();
        this.atualizaTabela();
    }

    public boolean validaCampo(String campo, String msg) {
        if (campo.isEmpty()) {
            JOptionPane.showMessageDialog(null, msg);
            return false;
        }
        return true;
    }

    public void cancelar() {

    }

    public void selecionaItem() {
        if (this.listaTabela.getSelectedRow() == -1) {
            this.editarBt.setEnabled(false);
            this.excluirBt.setEnabled(false);
        } else {
            this.editarBt.setEnabled(true);
            this.excluirBt.setEnabled(true);
        }
    }

    public void atualizaTabela() {

        DefaultTableModel val = (DefaultTableModel) this.listaTabela.getModel();
        val.setRowCount(0);

        for (Usuario u : new UsuarioDAO().listar()) {
            val.addRow(new String[]{
                Integer.toString(u.getId()),
                u.getNome(),
                u.getUsuario(),
                u.getSenha()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaTabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        senhaLabel = new javax.swing.JLabel();
        nomeText = new javax.swing.JTextField();
        usuarioText = new javax.swing.JTextField();
        senhaText = new javax.swing.JTextField();
        idText = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        salvarBt = new javax.swing.JButton();
        cancelarBt = new javax.swing.JButton();
        novoBt = new javax.swing.JButton();
        editarBt = new javax.swing.JButton();
        excluirBt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Usuário", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaTabela);
        if (listaTabela.getColumnModel().getColumnCount() > 0) {
            listaTabela.getColumnModel().getColumn(0).setResizable(false);
            listaTabela.getColumnModel().getColumn(1).setResizable(false);
            listaTabela.getColumnModel().getColumn(2).setResizable(false);
            listaTabela.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Lista de usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do usuário"));

        nomeLabel.setText("Nome:");

        usuarioLabel.setText("Usuário:");

        senhaLabel.setText("Senha: ");

        idLabel.setText("ID:");

        salvarBt.setText("Salvar");
        salvarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtActionPerformed(evt);
            }
        });

        cancelarBt.setText("Cancelar");
        cancelarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salvarBt)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(senhaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(senhaText, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(usuarioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nomeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(idLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaLabel))
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        novoBt.setText("Novo");
        novoBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoBtActionPerformed(evt);
            }
        });

        editarBt.setText("Editar");
        editarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtActionPerformed(evt);
            }
        });

        excluirBt.setText("Excluir");
        excluirBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBtActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(novoBt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(editarBt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(excluirBt))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(novoBt, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(editarBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(excluirBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtActionPerformed
        this.bloquearForm();
        this.limpaForm();
    }//GEN-LAST:event_cancelarBtActionPerformed

    private void novoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoBtActionPerformed
        this.desbloquearForm();
    }//GEN-LAST:event_novoBtActionPerformed

    private void listaTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaTabelaMouseClicked
        this.selecionaItem();
    }//GEN-LAST:event_listaTabelaMouseClicked

    private void salvarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtActionPerformed
        this.salvar();
    }//GEN-LAST:event_salvarBtActionPerformed

    private void editarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtActionPerformed
        this.editar();
    }//GEN-LAST:event_editarBtActionPerformed

    private void excluirBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBtActionPerformed
        this.excluir();
        this.editarBt.setEnabled(false);
        this.excluirBt.setEnabled(false);
    }//GEN-LAST:event_excluirBtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Principal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBt;
    private javax.swing.JButton editarBt;
    private javax.swing.JButton excluirBt;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaTabela;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeText;
    private javax.swing.JButton novoBt;
    private javax.swing.JButton salvarBt;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JTextField senhaText;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioText;
    // End of variables declaration//GEN-END:variables
}
