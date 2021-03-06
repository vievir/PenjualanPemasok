/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Form;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author STMIK-VI-01
 */
public class Penjualan extends javax.swing.JFrame {
    
    DefaultTableModel tabModel;
    Statement stat;
    ResultSet res;
    PreparedStatement prestat;
    private JasperDesign jasDes;
    
    Map<String,Object> param = new HashMap<String,Object>();
    private JasperReport jasRep;
    private JasperPrint jasPri;
    /**
     * Creates new form Penjualan
     */
    public Penjualan() {
        initComponents();
        new fungsi.koneksi().koneksiDatabase();
        String[]row={"Kode Barang","Nama Barang","Harga","Jumlah","Bayar"};
        tabModel=new DefaultTableModel(null,row);
        tbDetail.setModel(tabModel);
        dcTanggal.setDate(new java.util.Date()); 
        kodeOtomatis();
        tfKodeBarang.requestFocus();
    }
    public void hitungBayar(){
        int harga = Integer.parseInt(tfHarga.getText());
        int jumlah = Integer.parseInt(tfJumlah.getText());
        int hasil = harga * jumlah;
        tfBayar.setText(""+hasil);
    }
    public void hitungTotalBayar(){
        int jmlBaris = tabModel.getRowCount();
        int totalBayar = 0;
        for(int a=0; a<jmlBaris; a++){
            int bayar = Integer.parseInt(tbDetail.getValueAt(a, 4).toString());
            totalBayar += bayar;            
        }
        tfTotal.setText(""+totalBayar);
    }
    public void hapusDataForm(){
        int row = tabModel.getRowCount();
        for(int i=0;i<row;i++){
            tabModel.removeRow(0);            
        }
    }
    public void kodeOtomatis(){
        try {
            String sql = "select * from penjualan order by kode_penjualan desc";
            stat = new fungsi.koneksi().konek.createStatement();
            res = stat.executeQuery(sql);
            if (res.next()) {
                String kode = res.getString("kode_penjualan").substring(1);
                String angka = "" + (Integer.parseInt(kode) + 1);
                String nol = "";

                if(angka.length()==1){
                    nol = "00";
                }else if(angka.length()==2){
                    nol = "0";
                }else if(angka.length()==3){
                    nol = "";
                }
                tfKodePenjualan.setText("P" + nol + angka);
            }else {
               tfKodePenjualan.setText("P001");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDetail = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfKodeBarang = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        tfJumlah = new javax.swing.JTextField();
        tfBayar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfKodePenjualan = new javax.swing.JTextField();
        dcTanggal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDetail);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel4.setText("Kode Barang");

        jLabel5.setText("Nama");

        jLabel6.setText("Harga");

        jLabel7.setText("Jumlah");

        jLabel8.setText("Bayar");

        tfKodeBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKodeBarangKeyReleased(evt);
            }
        });

        tfJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfJumlahKeyReleased(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Masukkan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ubah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(tfKodeBarang)
                    .addComponent(tfNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton1)
                    .addComponent(jLabel7)
                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        jLabel2.setText("Kode Penjualan");

        jLabel3.setText("Tanggal");

        tfKodePenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKodePenjualanActionPerformed(evt);
            }
        });

        dcTanggal.setDateFormatString("dd MMM yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfKodePenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfKodePenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Transaksi Penjualan");

        jButton5.setText("Simpan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Total Bayar");

        jButton6.setText("Cetak Struk");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton6)
                        .addGap(45, 45, 45)
                        .addComponent(jButton5)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 508, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CariBarang cari = new CariBarang(null, true);
        cari.setVisible(true);
        tfKodeBarang.setText(cari.getKodeBarang());
        tfNama.setText(cari.getNama());
        tfHarga.setText(cari.getHarga());
        tfJumlah.requestFocus();
        tfJumlah.setText("1");
        hitungBayar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfKodeBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKodeBarangKeyReleased
        // TODO add your handling code here:
        if(tfKodeBarang.getText().length()==4){
            try{
                String sql = "select * from barang where kode_barang = '"
                        + tfKodeBarang.getText() + "'";
                stat = new fungsi.koneksi().konek.createStatement();
                res = stat.executeQuery(sql);
                if(res.next()){
                    String nama         = res.getString("nama");
                    String jual         = res.getString("hargajual");
                    tfNama.setText(nama);
                    tfHarga.setText(jual);
                }
            }catch(Exception e){
                System.out.println(""+e);
            }
            tfJumlah.requestFocus();
            tfJumlah.setText("1");
            hitungBayar();
        }else{
            tfNama.setText("");
            tfHarga.setText("");
            tfJumlah.setText("");
            tfBayar.setText("");
        }
    }//GEN-LAST:event_tfKodeBarangKeyReleased

    private void tfJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfJumlahKeyReleased
        // TODO add your handling code here:
        if(!(tfJumlah.getText().length()==0)){
            hitungBayar();
        }else{
            tfBayar.setText("");
        }
    }//GEN-LAST:event_tfJumlahKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String kode = tfKodeBarang.getText();
        String nama = tfNama.getText();
        String harga = tfHarga.getText();
        String jumlah = tfJumlah.getText();
        String bayar = tfBayar.getText();
        String data[] = {kode,nama,harga,jumlah,bayar};
        tabModel.addRow(data); 
        tfKodeBarang.setText("");
        tfNama.setText("");
        tfHarga.setText("");
        tfJumlah.setText("");
        tfBayar.setText("");
        tfKodeBarang.requestFocus();
        hitungTotalBayar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "insert into penjualan values (?,?,?)";
            prestat = new fungsi.koneksi().konek.prepareStatement(sql);
            prestat.setString(1, tfKodePenjualan.getText());
            prestat.setDate(2, new java.sql.Date(dcTanggal.getDate().getTime()));
            prestat.setInt(3, Integer.parseInt(tfTotal.getText()));
            prestat.executeUpdate();
            
            int baris = tabModel.getRowCount();
            for(int a=0; a<baris; a++){
                String sql2 = "insert into detailpenjualan "
                        + "(kode_penjualan,kode_barang,jumlah,bayar) values (?,?,?,?)";
                prestat = new fungsi.koneksi().konek.prepareStatement(sql2);
                prestat.setString(1, tfKodePenjualan.getText());
                prestat.setString(2, tbDetail.getValueAt(a, 0).toString());
                prestat.setInt(3, Integer.parseInt(tbDetail.getValueAt(a, 3).toString()));
                prestat.setInt(4, Integer.parseInt(tbDetail.getValueAt(a, 4).toString()));                
                prestat.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(""+e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDetailMouseClicked
        // TODO add your handling code here:
        int baris = tbDetail.getSelectedRow();
        String kodebarang   = tabModel.getValueAt(baris, 0).toString();
        String nama         = tabModel.getValueAt(baris, 1).toString();
        String harga        = tabModel.getValueAt(baris, 2).toString();
        String jumlah       = tabModel.getValueAt(baris, 3).toString();
        String bayar        = tabModel.getValueAt(baris, 4).toString();
        tfKodeBarang.setText(kodebarang);
        tfNama.setText(nama);
        tfHarga.setText(harga);
        tfJumlah.setText(jumlah);
        tfBayar.setText(bayar);
    }//GEN-LAST:event_tbDetailMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String kode = tfKodeBarang.getText();
        String nama = tfNama.getText();
        String harga = tfHarga.getText();
        String jumlah = tfJumlah.getText();
        String bayar = tfBayar.getText();
        int baris = tbDetail.getSelectedRow();
        tabModel.setValueAt(kode, baris, 0);
        tabModel.setValueAt(nama, baris, 1);
        tabModel.setValueAt(harga, baris, 2);
        tabModel.setValueAt(jumlah, baris, 3);
        tabModel.setValueAt(bayar, baris, 4);
        tfKodeBarang.setText("");
        tfNama.setText("");
        tfHarga.setText("");
        tfJumlah.setText("");
        tfBayar.setText("");
        tfKodeBarang.requestFocus();
        hitungTotalBayar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        tabModel.removeRow(tbDetail.getSelectedRow()); 
        tfKodeBarang.setText("");
        tfNama.setText("");
        tfHarga.setText("");
        tfJumlah.setText("");
        tfBayar.setText("");
        tfKodeBarang.requestFocus();
        hitungTotalBayar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File("src/Laporan/Struk.jrxml");
            jasDes = JRXmlLoader.load(file);
            param.put("kodepenjualan", tfKodePenjualan.getText());
            jasRep = JasperCompileManager.compileReport(jasDes);
            jasPri = JasperFillManager.fillReport(jasRep,param,new fungsi.koneksi().konek);
            JasperViewer.viewReport(jasPri,false);
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tfKodePenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKodePenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKodePenjualanActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dcTanggal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDetail;
    private javax.swing.JTextField tfBayar;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfKodeBarang;
    private javax.swing.JTextField tfKodePenjualan;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
