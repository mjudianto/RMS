/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.untarsoftdev8.rms;

import static com.untarsoftdev8.rms.DetailPenjualan.idpenjualan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus ROG
 */
public class CariBarangPenjualan extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();
    private DefaultTableModel model;
    /**
     * Creates new form CariBarangPenjualan
     */
    public CariBarangPenjualan() {
        initComponents();
        model = new DefaultTableModel();
        TabelCariDataPenjualan.setModel(model);
        model.addColumn("id_harian");
        model.addColumn("id_detail");
        model.addColumn("nama_barang");
        model.addColumn("tipe_barang");
        model.addColumn("merek_barang");
        model.addColumn("jumlah_barang");
        model.addColumn("modal_barang");
        model.addColumn("harga_barang");
        model.addColumn("id_penjualan");
        loadData();
    }

    public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = "SELECT * from penjualanharian";
            ps=c.prepareStatement(sql);
            //ps.setInt(1, idpenjualan);
            ResultSet r = ps.executeQuery();
            
            while (r.next()) {
                Object[] o = new Object[10];
                o [0] = r.getString("id_pharian");
                o [1] = r.getString("id_detail");
                o [2] = r.getString("nama_barang");
                o [3] = r.getString("tipe_barang");
                o [4] = r.getString("merek_barang");
                o [5] = r.getDouble("jumlah_barang");
                o [6] = r.getDouble("modal_barang");
                o [7] = r.getDouble("harga_jual_barang");
                o [8] = r.getInt("id_penjualan");
                
                model.addRow(o);
            }
            
            r.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("load data "+e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonHome = new javax.swing.JButton();
        buttonKasir = new javax.swing.JButton();
        buttonPenjualan = new javax.swing.JButton();
        buttonStok = new javax.swing.JButton();
        buttonSupplier = new javax.swing.JButton();
        buttonCariBarang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelCariDataPenjualan = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 550));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RMS");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Retail Management System");

        buttonHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonHome.setText("Home");
        buttonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHomeActionPerformed(evt);
            }
        });

        buttonKasir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonKasir.setText("Kasir");
        buttonKasir.setVerifyInputWhenFocusTarget(false);
        buttonKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKasirActionPerformed(evt);
            }
        });

        buttonPenjualan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPenjualan.setText("Penjualan");
        buttonPenjualan.setPreferredSize(new java.awt.Dimension(72, 21));
        buttonPenjualan.setVerifyInputWhenFocusTarget(false);
        buttonPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenjualanActionPerformed(evt);
            }
        });

        buttonStok.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonStok.setText("Stok");
        buttonStok.setPreferredSize(new java.awt.Dimension(72, 21));
        buttonStok.setVerifyInputWhenFocusTarget(false);
        buttonStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStokActionPerformed(evt);
            }
        });

        buttonSupplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonSupplier.setText("Supplier");
        buttonSupplier.setPreferredSize(new java.awt.Dimension(72, 21));
        buttonSupplier.setVerifyInputWhenFocusTarget(false);
        buttonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierActionPerformed(evt);
            }
        });

        buttonCariBarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonCariBarang.setText("Cari Barang Penjualan");
        buttonCariBarang.setPreferredSize(new java.awt.Dimension(72, 21));
        buttonCariBarang.setVerifyInputWhenFocusTarget(false);
        buttonCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(22, 22, 22))
            .addComponent(buttonCariBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonKasir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(40, 40, 40)
                .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(buttonKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(buttonStok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(buttonCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cari Barang Penjualan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Cari Barang Penjualan");

        TabelCariDataPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {"10/4/22", "1", "MCB 10A", "LCD10", "Schneider", "10", "50000", "80000"},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanngal", "ID", "Nama", "Tipe", "Merek", "Jumlah", "Modal", "Harga Jual"
            }
        ));
        jScrollPane1.setViewportView(TabelCariDataPenjualan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        this.setVisible(false);
        new Home().setVisible(true);
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKasirActionPerformed
        this.setVisible(false);
        new Kasir().setVisible(true);
    }//GEN-LAST:event_buttonKasirActionPerformed

    private void buttonPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenjualanActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Penjualan().setVisible(true);
    }//GEN-LAST:event_buttonPenjualanActionPerformed

    private void buttonStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStokActionPerformed
        this.setVisible(false);
        new Stok().setVisible(true);
    }//GEN-LAST:event_buttonStokActionPerformed

    private void buttonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierActionPerformed
        this.setVisible(false);
        new Supplier().setVisible(true);
    }//GEN-LAST:event_buttonSupplierActionPerformed

    private void buttonCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariBarangActionPerformed
        this.setVisible(false);
        new CariBarangPenjualan().setVisible(true);
    }//GEN-LAST:event_buttonCariBarangActionPerformed

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
            java.util.logging.Logger.getLogger(CariBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CariBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CariBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CariBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CariBarangPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelCariDataPenjualan;
    private javax.swing.JButton buttonCariBarang;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonKasir;
    private javax.swing.JButton buttonPenjualan;
    private javax.swing.JButton buttonStok;
    private javax.swing.JButton buttonSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
