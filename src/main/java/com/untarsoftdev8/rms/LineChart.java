 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.untarsoftdev8.rms;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;  
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class LineChart extends JFrame {  
  Koneksi koneksi = new Koneksi();
  //private static final long serialVersionUID = 1L;  
  
  public LineChart(String title) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Grafik Keuntungan", // Chart title  
        "Date", // X-Axis Label  
        "Keuntungan(Rp)", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset() {  
  
    String series1 = "Keuntungan";  
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();
            
            String sql = "SELECT tanggal,keuntungan FROM penjualan";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                String temptanggal = r.getString("tanggal");
                Double tempkeuntungan = r.getDouble("keuntungan");
                dataset.addValue(tempkeuntungan, series1, temptanggal);  
            }
            r.close();
            s.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    return dataset;  
  }  
  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(() -> {  
      LineChart example = new LineChart("Line Chart Example");  
      example.setAlwaysOnTop(true);  
      example.pack();  
      example.setSize(400, 350);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  