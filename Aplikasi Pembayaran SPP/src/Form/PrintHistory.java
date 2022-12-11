/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Konfigurasi.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author A AAKHIF ATHALLAH
 */
public class PrintHistory extends javax.swing.JFrame {

    /**
     * Creates new form PrintHistory
     */
    private int idPembayaran;
    
    private DefaultTableModel DftTblModel_HistoryPembayaran;
    private String SQL;
    private DefaultTableModel DftTblModel_HistoryPembayaran1;
    
    private void showSortedDataAll(String Nama){
        DftTblModel_HistoryPembayaran = new DefaultTableModel();
        DftTblModel_HistoryPembayaran.addColumn("ID PEMBAYARAN");
        DftTblModel_HistoryPembayaran.addColumn("ID PETUGAS");
        DftTblModel_HistoryPembayaran.addColumn("NISN");
        DftTblModel_HistoryPembayaran.addColumn("NAMA");
        DftTblModel_HistoryPembayaran.addColumn("TGL BAYAR");
        DftTblModel_HistoryPembayaran.addColumn("BULAN DIBAYAR");
        DftTblModel_HistoryPembayaran.addColumn("TAHUN DIBAYAR");
        DftTblModel_HistoryPembayaran.addColumn("ID SPP");
        DftTblModel_HistoryPembayaran.addColumn("JUMLAH BAYAR");
        tblHistoryPembayaran.setModel(DftTblModel_HistoryPembayaran);
        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select id_pembayaran, id_petugas, pembayaran.nisn, nama, tgl_bayar, bulan_dibayar, tahun_dibayar, pembayaran.id_spp, jumlah_bayar from pembayaran inner join siswa on pembayaran.nisn = siswa.nisn WHERE nama = '"+Nama+"'";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_HistoryPembayaran.addRow(new Object[]{
                    res.getString("id_pembayaran"),
                    res.getString("id_petugas"),
                    res.getString("nisn"),
                    res.getString("nama"),
                    res.getString("tgl_bayar"),
                    res.getString("bulan_dibayar"),
                    res.getString("tahun_dibayar"),
                    res.getString("id_spp"),
                    res.getString("jumlah_bayar")});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void showSortedDataSpesific(String Nama, String Bulan){
        DftTblModel_HistoryPembayaran = new DefaultTableModel();
        DftTblModel_HistoryPembayaran.addColumn("ID PEMBAYARAN");
        DftTblModel_HistoryPembayaran.addColumn("ID PETUGAS");
        DftTblModel_HistoryPembayaran.addColumn("NISN");
        DftTblModel_HistoryPembayaran.addColumn("NAMA");
        DftTblModel_HistoryPembayaran.addColumn("TGL BAYAR");
        DftTblModel_HistoryPembayaran.addColumn("BULAN DIBAYAR");
        DftTblModel_HistoryPembayaran.addColumn("TAHUN DIBAYAR");
        DftTblModel_HistoryPembayaran.addColumn("ID SPP");
        DftTblModel_HistoryPembayaran.addColumn("JUMLAH BAYAR");
        tblHistoryPembayaran.setModel(DftTblModel_HistoryPembayaran);
        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select id_pembayaran, id_petugas, pembayaran.nisn, nama, tgl_bayar, bulan_dibayar, tahun_dibayar, pembayaran.id_spp, jumlah_bayar from pembayaran inner join siswa on pembayaran.nisn = siswa.nisn WHERE nama = '"+Nama+"' AND bulan_dibayar = '"+Bulan+"'";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_HistoryPembayaran.addRow(new Object[]{
                    res.getString("id_pembayaran"),
                    res.getString("id_petugas"),
                    res.getString("nisn"),
                    res.getString("nama"),
                    res.getString("tgl_bayar"),
                    res.getString("bulan_dibayar"),
                    res.getString("tahun_dibayar"),
                    res.getString("id_spp"),
                    res.getString("jumlah_bayar")});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void setValues(){
        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "SELECT nama FROM siswa";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            cbNama.removeAllItems();
            while (res.next()) {
                cbNama.addItem(res.getString("nama"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void TampilData() {
        DftTblModel_HistoryPembayaran = new DefaultTableModel();
        DftTblModel_HistoryPembayaran.addColumn("ID PEMBAYARAN");
        DftTblModel_HistoryPembayaran.addColumn("ID PETUGAS");
        DftTblModel_HistoryPembayaran.addColumn("NISN");
        DftTblModel_HistoryPembayaran.addColumn("NAMA");
        DftTblModel_HistoryPembayaran.addColumn("TGL BAYAR");
        DftTblModel_HistoryPembayaran.addColumn("BULAN DIBAYAR");
        DftTblModel_HistoryPembayaran.addColumn("TAHUN DIBAYAR");
        DftTblModel_HistoryPembayaran.addColumn("ID SPP");
        DftTblModel_HistoryPembayaran.addColumn("JUMLAH BAYAR");
        tblHistoryPembayaran.setModel(DftTblModel_HistoryPembayaran);
        Connection conn = Koneksi.getConnection();
        try {
            java.sql.Statement stmt = conn.createStatement();
            SQL = "select id_pembayaran, id_petugas, pembayaran.nisn, nama, tgl_bayar, bulan_dibayar, tahun_dibayar, pembayaran.id_spp, jumlah_bayar from pembayaran inner join siswa on pembayaran.nisn = siswa.nisn";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_HistoryPembayaran.addRow(new Object[]{
                    res.getString("id_pembayaran"),
                    res.getString("id_petugas"),
                    res.getString("nisn"),
                    res.getString("nama"),
                    res.getString("tgl_bayar"),
                    res.getString("bulan_dibayar"),
                    res.getString("tahun_dibayar"),
                    res.getString("id_spp"),
                    res.getString("jumlah_bayar")});
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public PrintHistory() {
        initComponents();
        setValues();
        
//        MAKE CLOSE STRUCT
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistoryPembayaran1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistoryPembayaran = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbBulan = new javax.swing.JComboBox<>();
        cbNama = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 800));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("HISTORY PEMBAYARAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(404, 404, 404))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRINT SEPARATELY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("*Select the data in the main table first");

        jScrollPane2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        tblHistoryPembayaran1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblHistoryPembayaran1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHistoryPembayaran1.setEnabled(false);
        tblHistoryPembayaran1.setRowHeight(50);
        jScrollPane2.setViewportView(tblHistoryPembayaran1);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRINT MAIN TABLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 16))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Sort by month :");

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        tblHistoryPembayaran.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblHistoryPembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHistoryPembayaran.setRowHeight(50);
        tblHistoryPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoryPembayaranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistoryPembayaran);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Sort by name :");

        cbBulan.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<All Months>", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        cbNama.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("GENERATE TABLE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbNama, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblHistoryPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoryPembayaranMouseClicked
        DftTblModel_HistoryPembayaran1 = new DefaultTableModel();
        DftTblModel_HistoryPembayaran1.addColumn("ID PEMBAYARAN");
        DftTblModel_HistoryPembayaran1.addColumn("ID PETUGAS");
        DftTblModel_HistoryPembayaran1.addColumn("NISN");
        DftTblModel_HistoryPembayaran1.addColumn("NAMA");
        DftTblModel_HistoryPembayaran1.addColumn("TGL BAYAR");
        DftTblModel_HistoryPembayaran1.addColumn("BULAN DIBAYAR");
        DftTblModel_HistoryPembayaran1.addColumn("TAHUN DIBAYAR");
        DftTblModel_HistoryPembayaran1.addColumn("ID SPP");
        DftTblModel_HistoryPembayaran1.addColumn("JUMLAH BAYAR");
        tblHistoryPembayaran1.setModel(DftTblModel_HistoryPembayaran1);
        
        int baris = tblHistoryPembayaran.getSelectedRow();
        DftTblModel_HistoryPembayaran1.addRow(new Object[]{
            DftTblModel_HistoryPembayaran.getValueAt(baris, 0).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 1).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 2).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 3).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 4).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 5).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 6).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 7).toString(),
            DftTblModel_HistoryPembayaran.getValueAt(baris, 8).toString(),
        });
        
        this.idPembayaran = Integer.parseInt(DftTblModel_HistoryPembayaran.getValueAt(baris, 0).toString());
    }//GEN-LAST:event_tblHistoryPembayaranMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\A AAKHIF ATHALLAH\\Documents\\NetBeansProjects\\Aplikasi Pembayaran SPP\\src\\Report\\SppReport.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(SQL);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, Koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
            
            System.out.println(SQL);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (cbBulan.getSelectedItem().toString() == "<All Months>") {
            System.out.println("All Months");
            showSortedDataAll(cbNama.getSelectedItem().toString());
        } else {
            System.out.println("Month tertentu");
            showSortedDataSpesific(cbNama.getSelectedItem().toString(), cbBulan.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\A AAKHIF ATHALLAH\\Documents\\NetBeansProjects\\Aplikasi Pembayaran SPP\\src\\Report\\PersonalReport.jrxml");
            JRDesignQuery newQuery = new JRDesignQuery();
            String com = "select kelas.nama_kelas, petugas.nama_petugas, pembayaran.nisn, nama, tgl_bayar, bulan_dibayar, tahun_dibayar, pembayaran.id_spp, jumlah_bayar from pembayaran inner join siswa on pembayaran.nisn = siswa.nisn inner join kelas on siswa.id_kelas = kelas.id_kelas inner join petugas on pembayaran.id_petugas = petugas.id_petugas WHERE id_pembayaran = '"+this.idPembayaran+"'";
            newQuery.setText(com);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, Koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
            
            System.out.println(com);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
            java.util.logging.Logger.getLogger(PrintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JComboBox<String> cbNama;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHistoryPembayaran;
    private javax.swing.JTable tblHistoryPembayaran1;
    // End of variables declaration//GEN-END:variables
}
