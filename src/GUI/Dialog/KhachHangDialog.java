/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import BUS.KhachHangBUS;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import GUI.Panel.KhachHang;
import helper.Formatter;
import helper.Validator;
//import java.security.Timestamp;
import javax.swing.JOptionPane;
/**
 *
 * @author dduc1
 */
public class KhachHangDialog extends javax.swing.JDialog {
    
    private KhachHangDAO khDAO = new KhachHangDAO();
    private KhachHangBUS khBUS = new KhachHangBUS();
    private KhachHangDTO khachhang;
    private KhachHangDTO newKhachHang;
    private String mode;
    private KhachHang khPanel;

    /**
     * Creates new form KhachHangDialog
     */
    public KhachHangDialog(java.awt.Frame parent, boolean modal,KhachHang khPanel, KhachHangDTO khachhang, String mode) {
        super(parent, modal);
        this.khPanel = khPanel;
        this.khachhang = khachhang;
        this.mode=mode;
        initComponents();
        initComponentsCustom();
    }
    
    public void initComponentsCustom(){
        this.setLocationRelativeTo(null);
        if(mode.equals("detail"))
            initDetailMode();
        if(mode.equals("add"))
            initAddMode();
        if(mode.equals("edit"))
            initEditMode();
    }
    
    public void initDetailMode(){
        header.setText("Thông tin khách hàng");
        addBtn.setVisible(false);
        txtHo.setText(this.khachhang.getHo());
        txtHo.setFocusable(false);
        txtTen.setText(this.khachhang.getTen());
        txtTen.setFocusable(false);
        txtSDT.setText(this.khachhang.getSoDienThoai());
        txtSDT.setFocusable(false);
        txtNTG.setText(Formatter.FormatDateTime(this.khachhang.getNgayThamGia()));
        txtNTG.setFocusable(false);
    }
    
    public void initAddMode(){
        header.setText("Thêm khách hàng mới");
        addBtn.setText("Thêm khách hàng");
    }
    
    public void initEditMode(){
        header.setText("Sửa thông tin khách hàng");
        addBtn.setText("Lưu thông tin");
        txtHo.setText(this.khachhang.getHo());
        txtTen.setText(this.khachhang.getTen());
        txtSDT.setText(this.khachhang.getSoDienThoai());
        txtNTG.setText(Formatter.FormatDateTime(this.khachhang.getNgayThamGia()));
    }
    
    public boolean ValidateInput(){
        if(Validator.isEmpty(txtHo.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập họ của khách hàng");
            return false;
        }
        if(Validator.isEmpty(txtTen.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên của khách hàng");
            return false;
        }
        if(!Validator.isPhoneNumber(txtSDT.getText())) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số điện thoại");
            return false;
        }
        return true;
    }
    
    public boolean ValidateDuplication(){
        for(KhachHangDTO i : khBUS.getAll()){
            if(i.getHo().equals(txtHo.getText()) && i.getTen().equals(txtTen.getText()) && (i.getSoDienThoai().equals(txtSDT.getText()))) {
                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại!");
                return false;
            } 
        }
        return true;
    }
    
    public KhachHangDTO getNewKH(){
        String ho = txtHo.getText();
        String ten = txtTen.getText();
        String sdt = txtSDT.getText();
        Timestamp ntg = new Timestamp(System.currentTimeMillis());
        
        return new KhachHangDTO(khDAO.getAutoIncrement(),ho,ten,sdt,ntg,1);
    }
    
    public void setEditedKH(){
        khachhang.setHo(txtHo.getText());
        khachhang.setTen(txtTen.getText());
        khachhang.setSoDienThoai(txtSDT.getText());
        Timestamp ntg = new Timestamp(System.currentTimeMillis());
        khachhang.setNgayThamGia(ntg);
    }
    
    public void addEvent() {
        if(!ValidateInput())
            return;
        if(!ValidateDuplication())
            return;
        newKhachHang = getNewKH();
        if(khPanel.khBUS.add(newKhachHang)) {
            JOptionPane.showMessageDialog(this, "Thêm khách hàng mới thành công!");
            khPanel.loadDataToTable(khPanel.khachHangList);
            dispose();
        }
    }
    
    public void editEvent() {
        if(!ValidateInput())
            return;
//        if(!ValidateDuplication())
//            return;
        setEditedKH();
        if(khPanel.khBUS.update(khachhang)) {
            JOptionPane.showMessageDialog(this, "Sửa thông tin nhân viên thành công!");
            khPanel.loadDataToTable(khPanel.khachHangList);
            dispose();
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
        header = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        txtNTG = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(88, 175, 232));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 50));

        header.setBackground(new java.awt.Color(102, 51, 255));
        header.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Khách Hàng Dialog");
        header.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        header.setMaximumSize(new java.awt.Dimension(149, 25));
        header.setMinimumSize(new java.awt.Dimension(149, 25));
        header.setPreferredSize(new java.awt.Dimension(149, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Họ");

        txtHo.setToolTipText("");
        txtHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên");
        jLabel3.setMaximumSize(new java.awt.Dimension(70, 16));
        jLabel3.setMinimumSize(new java.awt.Dimension(70, 16));
        jLabel3.setPreferredSize(new java.awt.Dimension(70, 16));

        jLabel4.setText("Số điện thoại");
        jLabel4.setMaximumSize(new java.awt.Dimension(16, 16));
        jLabel4.setMinimumSize(new java.awt.Dimension(16, 16));
        jLabel4.setPreferredSize(new java.awt.Dimension(16, 16));

        jLabel5.setText("Ngày tham gia");

        addBtn.setBackground(new java.awt.Color(78, 205, 196));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Thêm khách hàng");
        addBtn.setMaximumSize(new java.awt.Dimension(110, 20));
        addBtn.setMinimumSize(new java.awt.Dimension(110, 20));
        addBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addBtnMousePressed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(255, 107, 107));
        cancelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Hủy");
        cancelBtn.setMaximumSize(new java.awt.Dimension(110, 20));
        cancelBtn.setMinimumSize(new java.awt.Dimension(110, 20));
        cancelBtn.setPreferredSize(new java.awt.Dimension(120, 40));
        cancelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelBtnMousePressed(evt);
            }
        });

        txtNTG.setToolTipText("");

        txtTen.setToolTipText("");

        txtSDT.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSDT)
                        .addComponent(txtNTG)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(167, 167, 167)
                                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtHo))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtTen)))
                .addGap(91, 91, 91))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNTG, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMousePressed
        // TODO add your handling code here:
        if(mode.equals("add"))
            addEvent();
        if(mode.equals("edit"))
            editEvent();
    }//GEN-LAST:event_addBtnMousePressed

    private void cancelBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelBtnMousePressed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelBtnMousePressed

    private void txtHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoActionPerformed
       
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
            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                KhachHangDialog dialog = new KhachHangDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtNTG;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
