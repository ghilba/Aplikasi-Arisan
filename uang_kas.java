/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author My PC #16
 */
public final class uang_kas extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = koneksiDB.koneksi.getKoneksi();
   
    public ResultSet rsl;
    
    public DefaultTableModel tabdata;
    public DefaultTableModel tabdatal;
    /**
     * Creates new form uang_kas
     */
    public uang_kas() {
        initComponents();
        judul();
        reset();
        date();
        tampilData();
        jTextField1.setEnabled(false);
        tNIM.setEnabled(false);
        tnama.setEnabled(false);
        ckelas.setEnabled(false);
        cuang.setText("50000");
        cuang.setEnabled(false);
        ckembalian.setEnabled(false);
    }
    
    public void tampilData()    {
        try{
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("select * from tb_siswa where ket='belum'");
            while (rs.next()){
                Object[] data = {
                    rs.getString("NIM"),
                    rs.getString("nama"),
                    rs.getString("jk"),
                    rs.getString("kelas"),
                };
                tabModel.addRow(data);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void bayar(){
        int a = Integer.parseInt(cuang.getText());
        int b = Integer.parseInt(cbayar.getText());
        int c;
        c = b - a;
        
        ckembalian.setText(String.valueOf(c));
    }
    
    public void reset(){
        tNIM.setText("");
        tnama.setText("");
        ckelas.setText("");
        cbayar.setText("");
        ckembalian.setText("");
    }
    
    public void judul(){
        Object[] judul = {"NIM","Nama","J. Kelamin"," Kelas","Tanggal"};
        tabModel = new DefaultTableModel(null, judul);
        tb_sak.setModel(tabModel);
    }
    
    public class Tanggal{
        private String getTanggal(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
        
        public void main(String [] Args){
           Tanggal tgl = new Tanggal();
           System.out.println("Tanggal dan waktu sekarang : "+tgl.getTanggal());
        }
    }
    
    public String tgl(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void date(){
        Date a = new Date();
        SimpleDateFormat af = new SimpleDateFormat("dd-MM-yyyy");
        jTextField1.setText(af.format(a));
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrayon = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tNIM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cuang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbayar = new javax.swing.JTextField();
        ckembalian = new javax.swing.JTextField();
        bsimpan = new javax.swing.JButton();
        bloguss = new javax.swing.JButton();
        breport = new javax.swing.JButton();
        ckelas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_sak = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        breset = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(167, 138, 181));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(203, 154, 214));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NIM");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 24, -1, -1));

        tNIM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tNIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tNIMKeyTyped(evt);
            }
        });
        jPanel3.add(tNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 21, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nama");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("kelas");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 106, -1, -1));

        tnama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(tnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 62, 171, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Arisan");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 24, -1, -1));

        cuang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuangKeyTyped(evt);
            }
        });
        jPanel3.add(cuang, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 21, 108, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Bayar");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 66, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Kembalian");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 106, -1, -1));

        cbayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbayarKeyReleased(evt);
            }
        });
        jPanel3.add(cbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 63, 108, -1));

        ckembalian.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ckembalianKeyReleased(evt);
            }
        });
        jPanel3.add(ckembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 105, 108, -1));

        bsimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Save_24px.png"))); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel3.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 110, 30));

        bloguss.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        bloguss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Go_Back_24px.png"))); // NOI18N
        bloguss.setText("KEMBALI");
        bloguss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blogussActionPerformed(evt);
            }
        });
        jPanel3.add(bloguss, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 110, 30));

        breport.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        breport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Report_Card_24px.png"))); // NOI18N
        breport.setText("REPORT");
        breport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breportActionPerformed(evt);
            }
        });
        jPanel3.add(breport, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 110, 30));

        ckelas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ckelasKeyTyped(evt);
            }
        });
        jPanel3.add(ckelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 103, 108, -1));

        tb_sak.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_sak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sakMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_sak);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Pig_48px.png"))); // NOI18N
        jLabel9.setText("ARISAN KIYOWO ");

        breset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        breset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Sync_24px.png"))); // NOI18N
        breset.setText("Reset");
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(breset)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_sakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sakMouseClicked
        tNIM.setText(tabModel.getValueAt(tb_sak.getSelectedRow(), 0) + "");
        tnama.setText(tabModel.getValueAt(tb_sak.getSelectedRow(), 1) + "");
        ckelas.setText(tabModel.getValueAt(tb_sak.getSelectedRow(), 3) + "");
        jTextField1.setText(tabModel.getValueAt(tb_sak.getSelectedRow(),5) + "");

        breset.setEnabled(true);
        tNIM.setEnabled(false);
    }//GEN-LAST:event_tb_sakMouseClicked

    private void blogussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blogussActionPerformed
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_blogussActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
         
            try{
                st = cn.createStatement();
                st.executeUpdate("update tb_siswa set ket='belum'");
                JOptionPane.showMessageDialog(null, "Data direset!");
                reset();
                
                tampilData();
            }catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_bresetActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        if(tNIM.getText().equals("") || tnama.getText().equals("") || cbayar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data!");
        }else{
            try{
                st = cn.createStatement();
                st.executeUpdate("insert into tbl_kas set NIM='" + tNIM.getText()+ "', nama='" +tnama.getText()+ "', kelas ='" +ckelas.getText()+ "', u_bayar='" +cbayar.getText()+ "', kembalian='" +ckembalian.getText() + "'," + "tgl='"+ jTextField1.getText()+ "'");
                st.executeUpdate("update tb_siswa set ket='sudah' where NIM='"+tNIM.getText()+"'");
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                reset();
                tampilData();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void cuangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuangKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_cuangKeyTyped

    private void tNIMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnisKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_tnisKeyTyped

    private void ckelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckelasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ckelasKeyTyped

    private void ckembalianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ckembalianKeyReleased
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_ckembalianKeyReleased

    private void cbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbayarKeyReleased
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_cbayarKeyReleased

    private void breportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breportActionPerformed
         String reportSource = null;
        String reportDest = null;
        
        
        try{
            reportSource = "C:\\Users\\orions\\Downloads\\UangKasMahasiswa\\UangKasSiswa-master\\Uang Kas Siswa (UKS)\\uangkas\\src\\form\report1.jrxml";
            reportDest = "C:\\Users\\orions\\Downloads\\UangKasMahasiswa\\UangKasSiswa-master\\Uang Kas Siswa (UKS)\\uangkas\\src\\form\\report1.jasper";
            
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, cn);
            JasperViewer.viewReport(jasperPrint, false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_breportActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(uang_kas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uang_kas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uang_kas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uang_kas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uang_kas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrayon;
    private javax.swing.JButton bloguss;
    private javax.swing.JButton breport;
    private javax.swing.JButton breset;
    private javax.swing.JButton bsimpan;
    private javax.swing.JTextField cbayar;
    private javax.swing.JTextField ckembalian;
    private javax.swing.JTextField ckelas;
    private javax.swing.JTextField cuang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tb_sak;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tNIM;
    // End of variables declaration//GEN-END:variables
}
