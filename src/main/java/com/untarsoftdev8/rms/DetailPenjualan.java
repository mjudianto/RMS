/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.untarsoftdev8.rms;

import static com.untarsoftdev8.rms.DetailSupplierPembelian.id_pembelian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Venny
 */
public class DetailPenjualan extends javax.swing.JFrame {
     Koneksi koneksi = new Koneksi();
     public static int idpenjualan;
     private DefaultTableModel model;
     public double totalkeuntungan=0.0;
     public double totalpemasukan=0.0;
    /**
     * Creates new form DetailPenjualan
     */
    public DetailPenjualan(int tempId) {
        initComponents();
        idpenjualan = tempId;
        model = new DefaultTableModel();
        tabelDetailPenjualan.setModel(model);
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

    DetailPenjualan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = "SELECT id_pharian,id_detail,nama_barang,tipe_barang,merek_barang,jumlah_barang,modal_barang,harga_jual_barang,id_penjualan FROM penjualanharian where id_penjualan=? ";
            ps=c.prepareStatement(sql);
            ps.setInt(1, idpenjualan);
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
        getKeuntungan();
        getPemasukan();
    }
      double keuntungan;
      public void getKeuntungan(){
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = " SELECT sum((harga_jual_barang - modal_barang) * jumlah_barang) FROM penjualanharian where id_penjualan=? ";
            ps=c.prepareStatement(sql);
            ps.setInt(1,idpenjualan);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                totalkeuntungan=r.getDouble("sum((harga_jual_barang - modal_barang) * jumlah_barang)");
                Keuntungan.setText(Double.toString(totalkeuntungan));
            }
            else{
                totalkeuntungan=0.0;
            }
            r.close();
        } catch (Exception e) {
            System.out.println("kesalahan getkeuntungan: "+e);
        }
        
    }
      double pemasukan;
      public void getPemasukan(){
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = " SELECT sum(harga_jual_barang * jumlah_barang) FROM penjualanharian where id_penjualan=? ";
            ps=c.prepareStatement(sql);
            ps.setInt(1,idpenjualan);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                totalpemasukan=r.getDouble("sum(harga_jual_barang * jumlah_barang)");
                Pemasukan.setText(Double.toString(totalpemasukan));
            }
            else{
                totalpemasukan=0.0;
            }
            r.close();
        } catch (Exception e) {
            System.out.println("kesalahan getpemasukan: "+e);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tanggal = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Pemasukan = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        Keuntungan = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelDetailPenjualan = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 11, 105));

        tanggal.setEditable(false);
        jScrollPane2.setViewportView(tanggal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jTextPane1);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel2.setText("Pemasukan :");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setText("Keuntungan :");

        Pemasukan.setEditable(false);
        Pemasukan.setBackground(new java.awt.Color(0, 11, 105));
        Pemasukan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Pemasukan.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(Pemasukan);

        Keuntungan.setEditable(false);
        Keuntungan.setBackground(new java.awt.Color(0, 11, 105));
        Keuntungan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Keuntungan.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(Keuntungan);

        tabelDetailPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Barang", "Tipe", "Merek", "Jumlah", "Modal", "Harga Jual"
            }
        ));
        tabelDetailPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDetailPenjualanMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelDetailPenjualan);

        jButton2.setBackground(new java.awt.Color(0, 11, 105));
        jButton2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelDetailPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDetailPenjualanMouseClicked
        // TODO add your handling code here:
       int i = tabelDetailPenjualan.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        String id = model.getValueAt(i, 0).toString();
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus","Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pernyataan== JOptionPane.OK_OPTION) {
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM penjualanharian WHERE id_pharian = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                getKeuntungan();
                getPemasukan();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan"+e);
            }finally{
                loadData();
            }
        }
        if (pernyataan == JOptionPane.CANCEL_OPTION) {
            
        }
    }//GEN-LAST:event_tabelDetailPenjualanMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        getKeuntungan();
        getPemasukan();
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE penjualan SET keuntungan=?,pemasukan=? WHERE id_penjualan = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p=c.prepareStatement(sql);
            System.out.println("total keuntungan: "+ totalkeuntungan);
            p.setDouble(1, totalkeuntungan);
            p.setDouble(2,totalpemasukan);
            p.setInt(3, idpenjualan);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            System.out.println("btn kembali "+e);
        }finally{
            new Penjualan().setVisible(true);
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
            java.util.logging.Logger.getLogger(DetailPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailPenjualan(idpenjualan).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextPane Keuntungan;
    public static javax.swing.JTextPane Pemasukan;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private static javax.swing.JTable tabelDetailPenjualan;
    public static javax.swing.JTextPane tanggal;
    // End of variables declaration//GEN-END:variables
}
