/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.untarsoftdev8.rms;

import static com.untarsoftdev8.rms.DetailSupplierPembelian.id_pembelian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Venny
 */
public class InputBarangPenjualan extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();
    DefaultTableModel tb = new DefaultTableModel();
    /**
     * Creates new form InputBarangPenjualan
     */
    String id_barang;
    String nama;
    String tipe;
    String merek;
    String bos;
    int jumlahstok;
    double harga;
    int colcount;
    
    public DefaultComboBoxModel retrieve()
    {
        DefaultComboBoxModel dm=new DefaultComboBoxModel();

        //SQL
        String sql="SELECT nama_bos FROM supplier";

        try
        {
            Connection c=koneksi.getKoneksi();

            //STATEMENT
            Statement s=c.prepareStatement(sql);
            ResultSet rs=s.executeQuery(sql);

            //LOOP THRU GETTING ALL VALUES
            while(rs.next())
            {
                //GET VALUES
                String name=rs.getString(1);

                dm.addElement(name);
            }

            return dm;

        }catch (SQLException ex) {
            ex.printStackTrace();
             return null;
        }

    }
    
    private DefaultTableModel model;
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM stok";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[7];
                o [0] = r.getString("id_barang");
                o [1] = r.getString("nama_barang");
                o [2] = r.getString("tipe_barang");
                o [3] = r.getString("merek_barang");
                o [4] = r.getString("stok_barang");
                o [5] = r.getString("harga_barang");
                o [6] = r.getString("nama_supplier");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    public InputBarangPenjualan() {
        initComponents();
        model = new DefaultTableModel();
        tabelBarang.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("TIPE");
        model.addColumn("MEREK");
        model.addColumn("JUMLAH");
        model.addColumn("HARGA");
        model.addColumn("BOS");
        loadData();
    }

    public void showData(){
    
    
    tb.addColumn("ID");
    tb.addColumn("NAMA");
    tb.addColumn("TIPE");
    tb.addColumn("MEREK");
    tb.addColumn("JUMLAH");
    tb.addColumn("HARGA");
    tb.addColumn("BOS");
    
    tabelBarang.setModel(tb);
    try{
            Connection c = koneksi.getKoneksi();
            String sql="Select * from stok" ;
            Statement s=c.prepareStatement(sql);
            ResultSet rs=s.executeQuery(sql);
          
            while(rs.next()){
                tb.addRow(new Object[]{
                rs.getString("id_barang"),
                rs.getString("nama_barang"),
                rs.getString("tipe_barang"),
                rs.getString("merek_barang"),
                rs.getString("stok_barang"),
                rs.getString("harga_barang"),
                rs.getString("nama_supplier"),
            });
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
    
    private void findData(String key){
        try{
            Object[] judul_kolom = {"id_barang","nama_barang","tipe_barang","merek_barang","stok_barang","harga_barang","nama_supplier"};
            tb = new DefaultTableModel(null,judul_kolom);
            tabelBarang.setModel(tb);
            
            Connection c = koneksi.getKoneksi();
            Statement s=c.createStatement();
            tb.getDataVector().removeAllElements();
            
            ResultSet rs =s.executeQuery("Select * from stok where nama_barang LIKE '%"+key+"%'");
            while(rs.next()){
                Object[] data={
                rs.getString("id_barang"),
                rs.getString("nama_barang"),
                rs.getString("tipe_barang"),
                rs.getString("merek_barang"),
                rs.getString("stok_barang"),
                rs.getString("harga_barang"),
                rs.getString("nama_supplier"),
                };
                tb.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cariBarang = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DAFTAR BARANG");

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "TIPE", "MEREK", "JUMLAH", "HARGA", "BOS"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Cari Barang :");

        cariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBarangActionPerformed(evt);
            }
        });
        cariBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariBarangKeyReleased(evt);
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
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariBarangActionPerformed

    private void cariBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBarangKeyReleased
        // TODO add your handling code here:
        String key=cariBarang.getText();
        System.out.println(key);
        
        if(key!=""){
            findData(key);
        }else{
            showData();
        }
    }//GEN-LAST:event_cariBarangKeyReleased
        
   Object[] o = new Object[7];
    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int baris = tabelBarang.getSelectedRow();
        for (int i=0 ; i<tabelBarang.getColumnCount() ; i++){
            String data = (String) tabelBarang.getValueAt(baris, i);
            o [i] = data;
        }
        String pilihan[] = {"INPUT", "BATAL"};
             int pilih = JOptionPane.showOptionDialog(null, "INPUT ATAU BATAL?", "KONFIRMASI", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
             switch (pilih) {
                case JOptionPane.YES_OPTION://INPUT
                    Kasir kasir = new Kasir(o);
                    kasir.setVisible(true);
                break;
                
                case JOptionPane.NO_OPTION://BATAL
                    loadData();
                    
                break;
                }    
    }//GEN-LAST:event_tabelBarangMouseClicked

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
            java.util.logging.Logger.getLogger(InputBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputBarangPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputBarangPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cariBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
