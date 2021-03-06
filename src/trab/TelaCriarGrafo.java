/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fred
 */
public class TelaCriarGrafo extends javax.swing.JFrame {

    /**
     * Creates new form TelaCriarGrafo
     */
    public TelaCriarGrafo() {
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

        jLabelNumeroDeVertices = new javax.swing.JLabel();
        txtVertices = new javax.swing.JTextField();
        txtCriarVertices = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtSalvarXml = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNumeroDeVertices.setText("Numero de Vertices:");

        txtCriarVertices.setText("Criar Vertices");
        txtCriarVertices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCriarVerticesMouseClicked(evt);
            }
        });
        txtCriarVertices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriarVerticesActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        txtSalvarXml.setText("Salvar em xml");
        txtSalvarXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalvarXmlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNumeroDeVertices)
                                .addGap(18, 18, 18)
                                .addComponent(txtVertices, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(txtCriarVertices))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(txtSalvarXml)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumeroDeVertices)
                    .addComponent(txtVertices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCriarVertices))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtSalvarXml)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void txtCriarVerticesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCriarVerticesMouseClicked
        // TODO add your handling code here:
        int qV;
        int c = 0;
        int l = 0;
        int n;
        qV = Integer.parseInt(txtVertices.getText());
        int m[][] = new int[qV + 1][qV + 1];

        for (int i = 0; i < (qV + 1); i++) {
            for (int j = 0; j < (qV + 1); j++) {

                if (i == 0) {
                    m[i][j] = l;
                    l++;
                }
                if (j == 0) {
                    m[i][j] = c;
                    c++;
                }
            }
        }        
    }//GEN-LAST:event_txtCriarVerticesMouseClicked

    private void txtCriarVerticesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriarVerticesActionPerformed
        // TODO add your handling code here:
        //Instancia da Classe
        tabelaGrafo e = new tabelaGrafo();

        //Pegando o valor do campo e atribuindo ao objeto
        e.setN(Integer.parseInt(txtVertices.getText()));

        //criando uma nova jTable para Substituir a anterior, que está na tela
        DefaultTableModel dfm = new DefaultTableModel() {
            @Override
            //Não permitir editar a coluna zero
            public boolean isCellEditable(int row, int col) {
                if (col == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        //Criando as Colunas
        dfm.addColumn("Vertices");
        String[] linhas = new String[e.getN() + 1];
        for (int i = 0; i < linhas.length - 1; i++) {
            dfm.addColumn((i + 1));
            linhas[i] = "0";
        }
        linhas[linhas.length - 1] = "0";
        
        //Criando as linhas
        for (int i = 0; i < linhas.length - 1; i++) {
            linhas[0] = (i + 1) + "";
            dfm.addRow(linhas);
        }

        jTable1.setModel(dfm);
        jTable1.setRowHeight(30);
    }//GEN-LAST:event_txtCriarVerticesActionPerformed

    private void txtSalvarXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalvarXmlActionPerformed
        /* XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(Grafo.class);

        Grafo g = new Grafo("G", "directed", listaNos, listaArestas);
        if (jRadioButton1.isSelected()) {
            g.setTipo("directed");
        }
        if (jRadioButton2.isSelected()) {
            g.setTipo("undirected");
        }
        System.out.println(xstream.toXML(g));
        String xml = xstream.toXML(g);

        g = null;

        g = (Grafo) xstream.fromXML(xml);

        try {

            File xmlFile = new File(jtNomeGrafo.getText() + ".xml");
            xstream.toXML(g, new FileWriter(xmlFile));
        } catch (IOException ex) {
            System.out.println("Erro ao Gravar Arquivo");
        }
        DefaultTableModel linhaN = (DefaultTableModel) jtbNos.getModel();
        while (linhaN.getRowCount() != 0) {
            listaNos.remove(0);
            linhaN.removeRow(0);
        }

        DefaultTableModel linhaA = (DefaultTableModel) jtbArestas.getModel();
        while (linhaA.getRowCount() != 0) {
            listaArestas.remove(0);
            linhaA.removeRow(0);
        }

        jtNomeGrafo.setText("");
        //numeroAresta = 0;
        JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso");
        */
    }//GEN-LAST:event_txtSalvarXmlActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCriarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCriarGrafo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelNumeroDeVertices;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton txtCriarVertices;
    private javax.swing.JButton txtSalvarXml;
    private javax.swing.JTextField txtVertices;
    // End of variables declaration//GEN-END:variables
}
