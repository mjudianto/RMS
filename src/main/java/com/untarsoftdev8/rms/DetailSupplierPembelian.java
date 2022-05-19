/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.untarsoftdev8.rms;

import static com.untarsoftdev8.rms.TambahBarangSupplierPembelian.temppembelian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Venny
 */
public class DetailSupplierPembelian extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();
    public static int id_pembelian;
    private DefaultTableModel model;
    public double totalpembelian=0.0;
    public DetailSupplierPembelian(int tempid) {
        initComponents();
        id_pembelian=tempid;
        model = new DefaultTableModel();
        detailTable.setModel(model);
        model.addColumn("id_detail");
        model.addColumn("id_barang");
        model.addColumn("nama_barang");
        model.addColumn("tipe_barang");
        model.addColumn("merek_barang");
        model.addColumn("stok_barang");
        model.addColumn("harga_barang");
        model.addColumn("id_pembelian");
        getTotal();
        loadData();
        
    }
    
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        //id_pembelian=SupplierPembelian.getTempID();
        System.out.println("id_pembelian: "+id_pembelian);
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = "SELECT * FROM detailpembelian where id_pembelian=?";
            ps=c.prepareStatement(sql);
            ps.setInt(1, id_pembelian);
            ResultSet r = ps.executeQuery();
            
            while (r.next()) {
                Object[] o = new Object[8];
                o [0] = r.getInt("id_detail");
                o [1] = r.getInt("id_barang");
                o [2] = r.getString("nama_barang");
                o [3] = r.getString("tipe_barang");
                o [4] = r.getString("merek_barang");
                o [5] = r.getInt("stok_barang");
                o [6] = r.getDouble("harga_barang");
                o [7] = r.getInt("id_pembelian");
                
                model.addRow(o);
            }
            
            r.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("load data "+e);
        }
    }
    
    public void getTotal(){
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = " SELECT sum(stok_barang * harga_barang) FROM detailpembelian where id_pembelian=? ";
            ps=c.prepareStatement(sql);
            ps.setInt(1,id_pembelian);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                double sum=r.getDouble("sum(stok_barang * harga_barang)");
                txTotal.setText(Double.toString(sum));
                totalpembelian=sum;
                System.out.println("Total pembelian: "+totalpembelian);
            }
            else{
                totalpembelian=0.0;
            }
            r.close();
        } catch (Exception e) {
            System.out.println("kesalahan gettotal: "+e);
        }
        
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDetail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtDetail.setEditable(false);
        txtDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetailActionPerformed(evt);
            }
        });

        detailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "TIPE", "MEREK", "JUMLAH", "HARGA"
            }
        ));
        detailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(detailTable);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Total :");

        txTotal.setEditable(false);

        btnTambah.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTambah))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(144, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKembali))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(txtDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(501, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        TambahBarangSupplierPembelian tambah = new TambahBarangSupplierPembelian(id_pembelian);
        tambah.temppembelian = id_pembelian;
        tambah.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed
    String tempnamasup;
    private void getNamaSupplier(){
        try{
            Connection c = koneksi.getKoneksi();
            String sql="SELECT nama_supplier FROM pembelian WHERE id_pembelian=?";
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1, id_pembelian);
            ResultSet r = p.executeQuery();
            if(r.next()){
                tempnamasup=r.getString("nama_supplier");
                System.out.println("Nama Supplier: "+tempnamasup);
            }
            r.close();
            p.close();
        }
        catch (Exception e) {
            System.out.println("get supplier"+e);
        }
    }
    private void insertStok(){
        try{
            Connection c = koneksi.getKoneksi();
            String sql="INSERT INTO stok(id_barang,nama_barang,tipe_barang,merek_barang,stok_barang,harga_barang,nama_supplier,id_pembelian) "
               +"SELECT id_barang,nama_barang,tipe_barang,merek_barang,stok_barang,harga_barang,?,? FROM detailpembelian where id_pembelian=?";
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,tempnamasup);
            p.setInt(2,id_pembelian);
            p.setInt(3,id_pembelian);
            p.executeUpdate();
            p.close();
        }
        catch (Exception e) {
            System.out.println("insert stok"+e);
        }
            
    }
    
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.setVisible(false);
        getTotal();
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE pembelian SET total=? WHERE id_pembelian = ?;";
            PreparedStatement p = c.prepareStatement(sql);
            p=c.prepareStatement(sql);
            System.out.println("total pembelian: "+ totalpembelian);
            p.setDouble(1, totalpembelian);
            p.setInt(2, id_pembelian);
            p.executeUpdate();
            p.close();
            getNamaSupplier();
            insertStok();
        } catch (Exception e) {
            System.out.println("btn kembali "+e);
        }finally{
            new SupplierPembelian().setVisible(true);
        }                  
        
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetailActionPerformed

    private void detailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailTableMouseClicked
       int i = detailTable.getSelectedRow();
        if (i == -1) {
            return;
        }
        
        int id = (int) model.getValueAt(i, 0);
        int tempbarang = (int) model.getValueAt(i,1);
        int pernyataan = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus","Konfirmasi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pernyataan== JOptionPane.OK_OPTION) {
            try {
                Connection c = koneksi.getKoneksi();
                String sql1 = "DELETE FROM stok WHERE id_barang = ?";
                String sql = "DELETE FROM detailpembelian WHERE id_detail = ?";
                PreparedStatement p = c.prepareStatement(sql1);
                p.setInt(1, tempbarang);
                p.executeUpdate();
                p = c.prepareStatement(sql);
                p.setInt(1, id);
                p.executeUpdate();
                p.close();
                getTotal();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            }finally{
                
                loadData();
            }
        }
        if (pernyataan== JOptionPane.CANCEL_OPTION) {
            
        }
    }//GEN-LAST:event_detailTableMouseClicked

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
            java.util.logging.Logger.getLogger(DetailSupplierPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailSupplierPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailSupplierPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailSupplierPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailSupplierPembelian(id_pembelian).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private javax.swing.JTable detailTable;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txTotal;
    public javax.swing.JTextField txtDetail;
    // End of variables declaration//GEN-END:variables
}
