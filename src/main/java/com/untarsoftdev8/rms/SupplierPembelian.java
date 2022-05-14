/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.untarsoftdev8.rms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jmslord
 */
public class SupplierPembelian extends javax.swing.JFrame {

    Koneksi koneksi = new Koneksi();
    public SupplierPembelian() {
        initComponents();
        model = new DefaultTableModel();
        
        pembelianTable.setModel(model);
        
        model.addColumn("id_pembelian");
        model.addColumn("tanggal");
        model.addColumn("total");
        model.addColumn("lunas");
        model.addColumn("nama_supplier");
        
        loadData();
    }

    private DefaultTableModel model;
    
    public void loadData(){
        model.getDataVector().removeAllElements();
        
        model.fireTableDataChanged();
        
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT * FROM pembelian";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                Object[] o = new Object[5];
                o [0] = r.getString("id_pembelian");
                o [1] = r.getDate("tanggal");
                o [2] = r.getDouble("total");
                o [3] = r.getString("lunas");
                o [4] = r.getString("nama_supplier");
                
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("terjadi kesalahan");
        }
    }
    
    public void clear(){
        txtID.setText("");
        txtTanggal.setDate(null);
        txtTotal.setText("");
        pilBos.setSelectedItem(-1);
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupLunas = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pembelianTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnInput = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnY = new javax.swing.JRadioButton();
        btnN = new javax.swing.JRadioButton();
        pilBos = new javax.swing.JComboBox<>();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        btnInput1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        buttonHome = new javax.swing.JButton();
        buttonKasir = new javax.swing.JButton();
        buttonPenjualan = new javax.swing.JButton();
        buttonStok = new javax.swing.JButton();
        buttonSupplier = new javax.swing.JButton();
        buttonCariBarang = new javax.swing.JButton();
        buttonPembelian1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 550));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 24)); // NOI18N
        jLabel3.setText("Nota Pembelian");

        pembelianTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(1), "24/04/22",  new Integer(1500000), null, "MGPS"},
                { new Integer(2), "25/04/22",  new Integer(1500000), null, "Cahaya Teknik"},
                { new Integer(3), "26/04/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(4), "27/04/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(5), "28/04/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(6), "29/04/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(7), "30/04/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(8), "01/05/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(9), "02/05/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(10), "03/05/22",  new Integer(1500000), null, "Maju Jaya"},
                { new Integer(11), "04/05/22",  new Integer(1500000), null, null}
            },
            new String [] {
                "ID", "Tanggal", "Total", "Lunas", "Nama Supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        pembelianTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pembelianTable.setRowHeight(25);
        pembelianTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pembelianTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pembelianTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cari :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Total Utang :");

        jLabel5.setText("ID");

        jLabel6.setText("Tanggal");

        btnInput.setBackground(new java.awt.Color(153, 153, 153));
        btnInput.setText("EDIT");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        jLabel8.setText("Lunas");

        jLabel9.setText("Nama Supplier");

        btnGrupLunas.add(btnY);
        btnY.setText("Y");
        btnY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYActionPerformed(evt);
            }
        });

        btnGrupLunas.add(btnN);
        btnN.setText("N");
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });

        pilBos.setModel(retrieve());
        pilBos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilBosActionPerformed(evt);
            }
        });

        txtTanggal.setDateFormatString("dd/MM/yyyy");
        txtTanggal.setName("jDateChooser"); // NOI18N

        btnInput1.setBackground(new java.awt.Color(153, 153, 153));
        btnInput1.setText("INPUT");
        btnInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInput1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(72, 72, 72)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel8))))
                            .addComponent(jLabel6))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnY, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(pilBos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInput))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(498, Short.MAX_VALUE)
                    .addComponent(btnInput1)
                    .addGap(15, 15, 15)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(btnY)
                            .addComponent(btnN))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(pilBos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(btnInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(469, Short.MAX_VALUE)))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 550));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RMS");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Retail Management System");

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

        buttonPembelian1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPembelian1.setText("Nota pembelian");
        buttonPembelian1.setPreferredSize(new java.awt.Dimension(72, 21));
        buttonPembelian1.setVerifyInputWhenFocusTarget(false);
        buttonPembelian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPembelian1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonPembelian1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(21, 21, 21))))
            .addComponent(buttonCariBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(buttonHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonKasir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonPenjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonStok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addComponent(buttonSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPembelian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(buttonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(buttonKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(buttonPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(buttonStok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void pembelianTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembelianTableMouseClicked
        int baris = pembelianTable.getSelectedRow();
        String pilihan[] = {"HAPUS", "DETAIL"};
        if (baris != -1){
             int pilih = JOptionPane.showOptionDialog(null, "PILIH HAPUS ATAU DETAIL?", "KONFIRMASI", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan, pilihan[0]);
             switch (pilih) {
                case JOptionPane.YES_OPTION://Hapus
                String pilihan1[] = {"HAPUS", "BATAL"};
                int pilih1 = JOptionPane.showOptionDialog(null, "HAPUS INI?", "KONFIRMASI", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, pilihan1, pilihan1[0]);
                if (pilih1 == JOptionPane.YES_OPTION) {
                    String idpembelian = pembelianTable.getValueAt(baris, 0).toString();
                    try {
                Connection c = koneksi.getKoneksi();
                String sql = "DELETE FROM pembelian WHERE id_pembelian = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, idpembelian);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan");
            }finally{
                loadData();
            }
                }
                case JOptionPane.NO_OPTION://detail
                    new DetailPembelian().show(true);
                    
                break;
            }
        }else{
            JOptionPane.showMessageDialog(null,"ERROR");
        }
        
                
    }//GEN-LAST:event_pembelianTableMouseClicked

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        String id = txtID.getText();
        Date tanggal = txtTanggal.getDate();
        java.sql.Date temptanggal = new java.sql.Date(tanggal.getTime());
        double total = Double.parseDouble(txtTotal.getText());
        String lunas = btnGrupLunas.getSelection().getActionCommand();
        System.out.println(lunas);
        String nama_bos = (String)pilBos.getSelectedItem();
        
        
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "INSERT INTO pembelian VALUES (?, ?, ?, ?, ?);";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setDate(2, temptanggal);
            p.setDouble(3, total);
            p.setString(4, lunas);
            p.setString(5, nama_bos);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Data Terubah");
            clear();
        } catch (Exception e) {
            System.out.println("update error");
        }finally{
            loadData();
        }
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYActionPerformed
        btnY.setActionCommand(btnY.getText());
    }//GEN-LAST:event_btnYActionPerformed

    private void pilBosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilBosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilBosActionPerformed

    private void btnNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNActionPerformed
        btnN.setActionCommand(btnN.getText());
    }//GEN-LAST:event_btnNActionPerformed

    private void buttonPembelian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPembelian1ActionPerformed
        this.setVisible(false);
        new SupplierPembelian().setVisible(true);
    }//GEN-LAST:event_buttonPembelian1ActionPerformed

    private void btnInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInput1ActionPerformed
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrupLunas;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnInput1;
    private javax.swing.JRadioButton btnN;
    private javax.swing.JRadioButton btnY;
    private javax.swing.JButton buttonCariBarang;
    private javax.swing.JButton buttonHome;
    private javax.swing.JButton buttonKasir;
    private javax.swing.JButton buttonPembelian1;
    private javax.swing.JButton buttonPenjualan;
    private javax.swing.JButton buttonStok;
    private javax.swing.JButton buttonSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable pembelianTable;
    private javax.swing.JComboBox<String> pilBos;
    private javax.swing.JTextField txtID;
    private com.toedter.calendar.JDateChooser txtTanggal;
    // End of variables declaration//GEN-END:variables
}
