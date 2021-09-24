/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import vo.Veiculo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.VeiculoDAO;

/**
 *
 * @author JP
 */
public class TelaLocalizaVeiculo extends javax.swing.JFrame {

    VeiculoDAO pv = new VeiculoDAO();

    /**
     * Creates new form TelaLocalizaVeiculo
     */
    public TelaLocalizaVeiculo() {
        initComponents();
    }

    private void preencheTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tLocaliza.getModel();
        int i = modelo.getRowCount();
        while (i-- > 0) {
            modelo.removeRow(i);
        }
        List<Veiculo> lista;

        if (tFiltro.getText().equals("")) {
            lista = pv.pesquisa();
        } else {
            lista = pv.pesquisa(tFiltro.getText());
        }
        for (Veiculo v : lista) {
            modelo.addRow(new Object[]{v.getId(), v.getPlaca(), v.getMarca(), v.getModelo(), v.getAno(), v.getChassi(), v.getIdCliente()});
        }
    }
    private void preencheTabelaEmprestados() {
        DefaultTableModel modelo = (DefaultTableModel) tLocaliza.getModel();
        int i = modelo.getRowCount();
        while (i-- > 0) {
            modelo.removeRow(i);
        }
        List<Veiculo> lista;

        lista = pv.pesquisaEmprestados();
        for (Veiculo v : lista) {
            modelo.addRow(new Object[]{v.getId(), v.getPlaca(), v.getMarca(), v.getModelo(), v.getAno(), v.getChassi(), v.getIdCliente()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tLocaliza = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tFiltro = new javax.swing.JTextField();
        bOk = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArquivo = new javax.swing.JMenu();
        mNovo = new javax.swing.JMenuItem();
        mAlterar = new javax.swing.JMenuItem();
        mExcluir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        tLocaliza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Placa", "Marca", "Modelo", "Ano", "Chassi", "Id Cliente"
            }
        ));
        jScrollPane1.setViewportView(tLocaliza);

        jLabel1.setText("Filtro");

        bOk.setText("OK");
        bOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkActionPerformed(evt);
            }
        });

        jButton1.setText("Emprestar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Devolver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ver veículos emprestados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        mArquivo.setText("Arquivo");

        mNovo.setText("Novo");
        mNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNovoActionPerformed(evt);
            }
        });
        mArquivo.add(mNovo);

        mAlterar.setText("Alterar");
        mAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAlterarActionPerformed(evt);
            }
        });
        mArquivo.add(mAlterar);

        mExcluir.setText("Excluir");
        mExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mExcluirActionPerformed(evt);
            }
        });
        mArquivo.add(mExcluir);

        jMenuBar1.add(mArquivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jButton1)
                .addGap(60, 60, 60)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOk)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNovoActionPerformed
        TelaVeiculo t = new TelaVeiculo();
        t.setVisible(true);
    }//GEN-LAST:event_mNovoActionPerformed

    private void mAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAlterarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tLocaliza.getModel();
        if (tLocaliza.getSelectedRow() != -1) {
            int codigo = (Integer) modelo.getValueAt(tLocaliza.getSelectedRow(), 0);
            TelaVeiculo t = new TelaVeiculo();
            t.setVeiculo(pv.localiza(codigo));
            t.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Nada selecionado!");
        }
    }//GEN-LAST:event_mAlterarActionPerformed

    private void mExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mExcluirActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tLocaliza.getModel();
        if (tLocaliza.getSelectedRow() != -1) {
            int codigo = (Integer) modelo.getValueAt(tLocaliza.getSelectedRow(), 0);
            Veiculo v = pv.localiza(codigo);
            if (JOptionPane.showConfirmDialog(this, "Confirma exclusão de " + v.getPlaca() + "?") == JOptionPane.YES_OPTION) {
                pv.exclui(v);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há nada selecionado!");
        }
    }//GEN-LAST:event_mExcluirActionPerformed

    private void bOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkActionPerformed
        preencheTabela();
    }//GEN-LAST:event_bOkActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        preencheTabela();
    }//GEN-LAST:event_formWindowGainedFocus

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        preencheTabelaEmprestados();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tLocaliza.getModel();
        if (tLocaliza.getSelectedRow() != -1) {
            int codigo = (Integer) modelo.getValueAt(tLocaliza.getSelectedRow(), 0);
            TelaEmprestar te = new TelaEmprestar();
            te.setVeiculo(pv.localiza(codigo));
            te.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não há nada selecionado!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        DefaultTableModel modelo = (DefaultTableModel) tLocaliza.getModel();
        if (tLocaliza.getSelectedRow() != -1) {
            int codigo = (Integer) modelo.getValueAt(tLocaliza.getSelectedRow(), 0);
            Veiculo v = pv.localiza(codigo);
            if (JOptionPane.showConfirmDialog(this, "Confirma a devolução de " + v.getPlaca() + "?") == JOptionPane.YES_OPTION) {
                v.setIdCliente(0);
                pv.salva(v);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há nada selecionado!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLocalizaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLocalizaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLocalizaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLocalizaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLocalizaVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mAlterar;
    private javax.swing.JMenu mArquivo;
    private javax.swing.JMenuItem mExcluir;
    private javax.swing.JMenuItem mNovo;
    private javax.swing.JTextField tFiltro;
    private javax.swing.JTable tLocaliza;
    // End of variables declaration//GEN-END:variables
}
