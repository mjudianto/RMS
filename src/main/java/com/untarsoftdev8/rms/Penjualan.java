/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.untarsoftdev8.rms;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import static javax.management.Query.gt;
import javax.swing.table.TableModel;

/**
 *
 * @author Jmslord
 */
public class Penjualan extends javax.swing.JFrame {
    Login login = new Login();
    DefaultTableModel model = new DefaultTableModel() ;
    String Tanggal;
    Koneksi koneksi = new Koneksi();

    /**
     * Creates new form Supplier
     */
    public Penjualan() {
        initComponents();
        model.addColumn("ID");
        model.addColumn("Tanggal");
        model.addColumn("Pemasukan");
        model.addColumn("Keuntungan");
        
        DataPenjualan.setModel(model);
        getData();
        getTotalUtang();
    }

public void getData(){

     model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM penjualan";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[7];
                o [0] = r.getInt("id_penjualan");
                o [1] = r.getString("tanggal");
                o [2] = r.getString("pemasukan");
                o [3] = r.getString("keuntungan");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
}
 
   public void getDate(int idJual){
       DetailPenjualan detail = new DetailPenjualan(idJual);
       int baris = DataPenjualan.getSelectedRow();
       String Tanggal = DataPenjualan.getValueAt(baris,1).toString();
       detail.tanggal.setText(" ~ Tanggal Penjualan : " + Tanggal + " ~ ");
       detail.idpenjualan=idJual;
       detail.setVisible(true);
       detail.pack();
       dispose();
   }
  
   public void getTotalUtang(){
        try {
            Connection c = koneksi.getKoneksi();
            PreparedStatement ps;
            String sql = " SELECT sum(keuntungan) FROM penjualan";
            ps=c.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            if(r.next()){
                double sum=r.getDouble("sum(keuntungan)");
                String tempsum = String.valueOf(sum);
                TotalKeuntungan.setText(tempsum);
                System.out.println("Total Keuntungan: "+tempsum);
            }
        } catch (Exception e) {
            System.out.println("kesalahan Keuntungan: "+e);
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

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataPenjualan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TotalKeuntungan = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonHome = new javax.swing.JButton();
        buttonKasir = new javax.swing.JButton();
        buttonPenjualan = new javax.swing.JButton();
        buttonStok = new javax.swing.JButton();
        buttonSupplier = new javax.swing.JButton();
        buttonCariBarang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        jScrollPane4.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 550));

        jLabel9.setFont(new java.awt.Font("Poppins ExtraBold", 1, 24)); // NOI18N
        jLabel9.setText("Daftar Penjualan Setiap Hari");

        DataPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tanggal", "Penjualan", "Keuntungan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DataPenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataPenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataPenjualan);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Total Keuntungan :");

        TotalKeuntungan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(TotalKeuntungan);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 162, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12))
        );

        jPanel1.setBackground(new java.awt.Color(0, 11, 105));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 550));

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

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\RMS\\src\\main\\java\\com\\untarsoftdev8\\rms\\RMS (2).png")); // NOI18N
        jLabel1.setText("RMS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonKasir, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(buttonHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonPenjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonStok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonCariBarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(buttonKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)
                    .addComponent(buttonPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(buttonStok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(buttonCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(112, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DataPenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataPenjualanMouseClicked
        // TODO add your handling code here:
        int baris = DataPenjualan.getSelectedRow();
        String pilihan[] = {"HAPUS", "DETAIL"};
        if (baris != -1){
             int pilih = JOptionPane.showOptionDialog(null, "PILIH HAPUS ATAU DETAIL?", "KONFIRMASI", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
             switch (pilih) {
                case JOptionPane.YES_OPTION://Hapus
                String pilihan1[] = {"HAPUS", "BATAL"};
                int pilih1 = JOptionPane.showOptionDialog(null, "HAPUS INI?", "KONFIRMASI", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan1, pilihan1[0]);
                if (pilih1 == JOptionPane.YES_OPTION) {
                   int idJual = (int) DataPenjualan.getValueAt(baris, 0);
                    try {
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM penjualan WHERE id_penjualan = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, idJual);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
                
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            }finally{
                getData();
            }
            break;
            }
                
                case JOptionPane.NO_OPTION://detail
                    int idJual = (int) DataPenjualan.getValueAt(baris, 0);
                    getDate(idJual);
                break;
            }
        }else{
            JOptionPane.showMessageDialog(null,"ERROR");
        }
        
               
    }//GEN-LAST:event_DataPenjualanMouseClicked

    private void buttonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHomeActionPerformed
        if ("owner".equals(login.userstatus)){
            this.setVisible(false);
            new Home().setVisible(true);
        }
    }//GEN-LAST:event_buttonHomeActionPerformed

    private void buttonKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKasirActionPerformed
        if (!"admin".equals(login.userstatus)){
            this.setVisible(false);
            new Kasir().setVisible(true);
        }
    }//GEN-LAST:event_buttonKasirActionPerformed

    private void buttonPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenjualanActionPerformed
        if("owner".equals(login.userstatus)){
            this.setVisible(false);
            new Penjualan().setVisible(true);
        }
    }//GEN-LAST:event_buttonPenjualanActionPerformed

    private void buttonStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStokActionPerformed
        if (!"kasir".equals(login.userstatus)){
            this.setVisible(false);
            new Stok().setVisible(true);
        }
    }//GEN-LAST:event_buttonStokActionPerformed

    private void buttonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierActionPerformed
       if (!"kasir".equals(login.userstatus)){
            this.setVisible(false);
            new Supplier().setVisible(true);
        }
    }//GEN-LAST:event_buttonSupplierActionPerformed

    private void buttonCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariBarangActionPerformed
       if (!"admin".equals(login.userstatus)){
            this.setVisible(false);
            new CariBarangPenjualan().setVisible(true);
        }
    }//GEN-LAST:event_buttonCariBarangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable DataPenjualan;
    private javax.swing.JTextPane TotalKeuntungan;
    private javax.swing.JButton buttonCariBarang;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonKasir;
    private javax.swing.JButton buttonPenjualan;
    private javax.swing.JButton buttonStok;
    private javax.swing.JButton buttonSupplier;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
