/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.untarsoftdev8.rms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Statement;


/**
 *
 * @author Jmslord
 */
public class Koneksi {
    
   private static Connection koneksi;
    
    public static Connection getKoneksi(){
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/penjualan";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Berhasil");
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        return koneksi;
    }
    private static void createTableSupplier() {
            
            String sqlCreate = "CREATE TABLE IF NOT EXISTS supplier "
                    + "  (id_bos           INT PRIMARY KEY AUTO_INCREMENT,"
                    + "   nama_bos         VARCHAR(20) NOT NULL,"
                    + "   no_telp          VARCHAR(12) NOT NULL) AUTO_INCREMENT=300000";
            
            Statement stmt;
        try {
            stmt = koneksi.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("tabel supplier Berhasil atau sudah ada");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private static void createTableStok() {
        
            String sqlCreate = "CREATE TABLE IF NOT EXISTS stok "
                    + "  (id_barang           VARCHAR(6) PRIMARY KEY,"
                    + "   nama_barang         VARCHAR(20) NOT NULL,"
                    + "   tipe_barang         VARCHAR(20) NOT NULL,"
                    + "   merek_barang        VARCHAR(20) NOT NULL,"
                    + "   stok_barang         INT NOT NULL,"
                    + "   harga_barang        DOUBLE NOT NULL,"
                    + "   nama_supplier       VARCHAR(20) NOT NULL)";
            
            Statement stmt;
        try {
            stmt = koneksi.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("tabel stok Berhasil atau sudah ada");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private static void createTableDetailPembelian() {
        
            String sqlCreate = "CREATE TABLE IF NOT EXISTS detailpembelian "
                    + "  (id_barang           INT PRIMARY KEY ,"
                    + "   nama_barang         VARCHAR(20) NOT NULL,"
                    + "   tipe_barang         VARCHAR(20) NOT NULL,"
                    + "   merek_barang        VARCHAR(20) NOT NULL,"
                    + "   stok_barang         INT NOT NULL,"
                    + "   harga_barang        DOUBLE NOT NULL,"
                    + "   id_pembelian        INT NOT NULL,"
                    + "   FOREIGN KEY (id_pembelian) REFERENCES pembelian(id_pembelian))";
                    
            
            Statement stmt;
        try {
            stmt = koneksi.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("tabel detail pembelian Berhasil atau sudah ada");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private static void createTablePenjualan() {
        
            String sqlCreate = "CREATE TABLE IF NOT EXISTS penjualan "
                    + "  (id_penjualan    VARCHAR(10) PRIMARY KEY,"
                    + "   tanggal         DATE NOT NULL,"
                    + "   pemasukan       DOUBLE NOT NULL,"
                    + "   keuntungan      DOUBLE NOT NULL)";
                    
            
            Statement stmt;
        try {
            stmt = koneksi.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("tabel penjualan Berhasil atau sudah ada");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private static void createTablePembelian() {
            
            String sqlCreate = "CREATE TABLE IF NOT EXISTS pembelian "
                    + "  (id_pembelian     INT PRIMARY KEY AUTO_INCREMENT,"
                    + "   tanggal          DATE NOT NULL,"
                    + "   total            DOUBLE NOT NULL,"
                    + "   lunas            VARCHAR(1) NOT NULL,"
                    + "   nama_supplier    VARCHAR(20) NOT NULL) AUTO_INCREMENT=100000";
            
            Statement stmt;
        try {
            stmt = koneksi.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("tabel pembelian Berhasil atau sudah ada");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private static void deleteTable(String table) {     
        try {
            String sql = "DROP TABLE ?";
            Connection c = koneksi;
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, table);
            p.executeUpdate();
            p.close();
            System.out.println("delete "+table);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private static void alterSupplier() {
            
            String sqlCreate = "ALTER TABLE supplier AUTO_INCREMENT = 300000";
            
            Statement stmt;
        try {
            stmt = koneksi.createStatement();
            stmt.execute(sqlCreate);
            System.out.println("auto_increment supllier sudah reset");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        getKoneksi();
        createTableSupplier();
        createTableStok();
        createTablePenjualan();
        createTablePembelian();
        createTableDetailPembelian();
        //alterSupplier();
        //deleteTable("detailpembelian");
    }
    
}
