
package visao;


import dao.FuncionarioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Funcionario;


public class FuncionarioLista extends javax.swing.JFrame {

    
    public FuncionarioLista() {
        initComponents();
        atualizaFunc();
    }
    DefaultTableModel tab;
public void atualizaFunc(){
        
        
        FuncionarioDAO dao = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = dao.listar();
        tab = (DefaultTableModel) tabela.getModel();
        
        while(tab.getRowCount() > 0){
            tab.removeRow(0);
        }
        int i = 0;
        for(Funcionario c : funcionarios){
            tab.addRow(new String[i]);
            tab.setValueAt(c.getCpf(),i,0);
            tab.setValueAt(c.getNome(),i,1);
            tab.setValueAt(c.getTelefone(),i,2);
            tab.setValueAt(c.getEndereco(),i,3);
            tab.setValueAt(c.getSexo(),i,4);
            tab.setValueAt(c.getSalario(),i,5);
            i++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        painel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        Cadastro_lista = new javax.swing.JButton();
        Atualiza_lista = new javax.swing.JButton();
        Excluir_lista = new javax.swing.JButton();
        fechar_lista = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel.setBackground(new java.awt.Color(78, 145, 211));

        jPanel2.setBackground(new java.awt.Color(2, 47, 92));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("SisVestuário-SV");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "NOME", "TELEFONE", "ENDEREÇO", "SEXO", "SALÁRIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        Cadastro_lista.setText("Cadastrar");
        Cadastro_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cadastro_listaMouseClicked(evt);
            }
        });

        Atualiza_lista.setText("Atualizar");
        Atualiza_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atualiza_listaActionPerformed(evt);
            }
        });

        Excluir_lista.setText("Excluir");
        Excluir_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Excluir_listaMouseClicked(evt);
            }
        });

        fechar_lista.setForeground(new java.awt.Color(255, 0, 0));
        fechar_lista.setText("Fechar");
        fechar_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechar_listaMouseClicked(evt);
            }
        });
        fechar_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar_listaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cadastro_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Atualiza_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Excluir_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechar_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(Cadastro_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Atualiza_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Excluir_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechar_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cadastro_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cadastro_listaMouseClicked
        FuncionarioCadastro fc = new FuncionarioCadastro();
        fc.setFuncionarioLista(this);
        fc.setVisible(true);
    }//GEN-LAST:event_Cadastro_listaMouseClicked
    
    private void Atualiza_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atualiza_listaActionPerformed
        int linha = tabela.getSelectedRow();
        String cpf = (String)tab.getValueAt(linha, 0);
        String nome = (String)tab.getValueAt(linha,1);
        String telefone = (String) tab.getValueAt(linha,2);
        String endereco = (String) tab.getValueAt(linha, 3);
        String sexo = (String) tab.getValueAt(linha, 4);
        Double salario = (Double) tab.getValueAt(linha, 5);

        Funcionario f = new Funcionario();
        f.setCpf(cpf);
        f.setNome(nome);
        f.setTelefone(telefone);
        f.setEndereco(endereco);
        f.setSexo(sexo);
        f.setSalario(salario);

        FuncionarioAtualiza fa = new FuncionarioAtualiza();
        fa.preencherCampos(f);
        fa.setFuncionarioLista(this);
        fa.setVisible(true);
    }//GEN-LAST:event_Atualiza_listaActionPerformed

    private void Excluir_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Excluir_listaMouseClicked
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Funcionario?");
        if(resposta == 0){
            int linha = tabela.getSelectedRow();
            String cpf = (String)tab.getValueAt(linha, 0);

            Funcionario c = new Funcionario();
            c.setCpf(cpf);

            FuncionarioDAO dao = new FuncionarioDAO();
            JOptionPane.showMessageDialog(null, dao.excluir(c));
            atualizaFunc();
        }
    }//GEN-LAST:event_Excluir_listaMouseClicked
   
    private void fechar_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechar_listaMouseClicked
        dispose();
    }//GEN-LAST:event_fechar_listaMouseClicked

    private void fechar_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechar_listaActionPerformed
        dispose();
    }//GEN-LAST:event_fechar_listaActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualiza_lista;
    private javax.swing.JButton Cadastro_lista;
    private javax.swing.JButton Excluir_lista;
    private javax.swing.JButton fechar_lista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
