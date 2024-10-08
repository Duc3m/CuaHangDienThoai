/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BUS.PhienBanSanPhamBUS;
import DTO.PhienBanSanPhamDTO;
import DTO.SanPhamDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SanPhamDialog extends javax.swing.JDialog {

    public CardLayout cardLayout;
    public DefaultTableModel pbSPTableModel;
    private SanPhamDTO sp;
    private PhienBanSanPhamBUS pbspBUS = new PhienBanSanPhamBUS();
    private ArrayList<PhienBanSanPhamDTO> pbspList = new ArrayList<PhienBanSanPhamDTO>();
    
    public SanPhamDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);        
        initComponents();
        initComponetsCustom();
        initInformations();
        this.setLocationRelativeTo(null);  
    }
    
    public SanPhamDialog(java.awt.Frame parent, boolean modal, String title, SanPhamDTO sp) {
        super(parent, modal);
        this.setTitle(title);
        this.sp = sp;
        initComponents();
        initComponetsCustom();
        initInformations();
        this.setLocationRelativeTo(null);   
    }
    
    public void initComponetsCustom() {
        cardLayout = (CardLayout) jPanel2.getLayout();
        
        xemPBSPBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                xemPBSPBtn.setBackground(new Color(124, 181, 94));
            }
            public void mouseExited(MouseEvent e) {
                xemPBSPBtn.setBackground(new Color(144, 210, 109));
            }
            public void mousePressed(MouseEvent e) {
                cardLayout.show(jPanel2, "card2");
            }
        });
        quayLaiBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                xemPBSPBtn.setBackground(new Color(124, 181, 94));
            }
            public void mouseExited(MouseEvent e) {
                xemPBSPBtn.setBackground(new Color(144, 210, 109));
            }
            public void mousePressed(MouseEvent e) {
                cardLayout.show(jPanel2, "card1");
            }
        });
        
        pbSPTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
    }
    
    public void initInformations() {
        hinhAnhSP.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/image/product/"+sp.getHinhAnh())).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        txtTenSP.setText(sp.getTen());
        txtKTMH.setText(Float.toString(sp.getKichThuocMan())+"\"");
        txtCamSau.setText(sp.getCameraSau());
        txtCamTruoc.setText(sp.getCameraTruoc());
        txtChipXuLy.setText(sp.getChipXuLy());
        txtHeDieuHanh.setText(sp.getHeDieuHanh());
        txtDungLuongPin.setText(Integer.toString(sp.getDungLuongPin())+" mAh");
        
        pbspList = pbspBUS.getAllPBSPBySPId(sp.getId());        
        pbSPTableModel = (DefaultTableModel) pbSPTable.getModel();
        loadPBSPToTable(pbspList);
    }
    
    public void loadPBSPToTable(ArrayList<PhienBanSanPhamDTO> pbSPList) {
        pbSPTableModel.setRowCount(0);
        for(int i=0; i<pbSPList.size(); i++) {
            PhienBanSanPhamDTO pbspIndex = pbspList.get(i);
            pbSPTableModel.addRow(new Object[] {i+1, pbspIndex.getRam()+"GB", pbspIndex.getRom()+"GB", pbspIndex.getMau(), pbspIndex.getSoLuong()});
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
        jLabel1 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        hinhAnhSP = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKTMH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCamSau = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCamTruoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtChipXuLy = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHeDieuHanh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDungLuongPin = new javax.swing.JTextField();
        xemPBSPBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        quayLaiBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pbSPTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(88, 175, 232));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("CHI TIẾT SẢN PHẨM");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTenSP.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 380));
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        hinhAnhSP.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel3.setText("Kích thước màn hình");

        txtKTMH.setFocusable(false);

        jLabel4.setText("Camera sau");

        txtCamSau.setFocusable(false);

        jLabel5.setText("Camera trước");

        txtCamTruoc.setFocusable(false);

        jLabel6.setText("Chip xử lý");

        txtChipXuLy.setFocusable(false);

        jLabel7.setText("Hệ điều hành");

        txtHeDieuHanh.setFocusable(false);

        jLabel8.setText("Dung lượng pin");

        txtDungLuongPin.setFocusable(false);

        xemPBSPBtn.setBackground(new java.awt.Color(144, 210, 109));
        xemPBSPBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        xemPBSPBtn.setForeground(new java.awt.Color(255, 255, 255));
        xemPBSPBtn.setText("Xem phiên bản hiện có");
        xemPBSPBtn.setBorder(null);
        xemPBSPBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        xemPBSPBtn.setFocusPainted(false);
        xemPBSPBtn.setPreferredSize(new java.awt.Dimension(180, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(hinhAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtKTMH))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtCamSau, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtCamTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtChipXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(xemPBSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hinhAnhSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(47, 47, 47))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCamSau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtKTMH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCamTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtChipXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHeDieuHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(xemPBSPBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, "card1");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        quayLaiBtn.setBackground(new java.awt.Color(144, 210, 109));
        quayLaiBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quayLaiBtn.setForeground(new java.awt.Color(255, 255, 255));
        quayLaiBtn.setText("Quay lại");
        quayLaiBtn.setBorder(null);
        quayLaiBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quayLaiBtn.setFocusPainted(false);
        quayLaiBtn.setPreferredSize(new java.awt.Dimension(180, 50));

        pbSPTable.setAutoCreateRowSorter(true);
        pbSPTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pbSPTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ram", "Rom", "Màu", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pbSPTable.setRowHeight(32);
        pbSPTable.setSelectionBackground(new java.awt.Color(190, 215, 220));
        pbSPTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        pbSPTable.setShowGrid(true);
        pbSPTable.getTableHeader().setResizingAllowed(false);
        pbSPTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(pbSPTable);
        if (pbSPTable.getColumnModel().getColumnCount() > 0) {
            pbSPTable.getColumnModel().getColumn(0).setResizable(false);
            pbSPTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            pbSPTable.getColumnModel().getColumn(1).setResizable(false);
            pbSPTable.getColumnModel().getColumn(1).setPreferredWidth(25);
            pbSPTable.getColumnModel().getColumn(2).setResizable(false);
            pbSPTable.getColumnModel().getColumn(2).setPreferredWidth(25);
            pbSPTable.getColumnModel().getColumn(3).setResizable(false);
            pbSPTable.getColumnModel().getColumn(3).setPreferredWidth(40);
            pbSPTable.getColumnModel().getColumn(4).setResizable(false);
            pbSPTable.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(quayLaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410))
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quayLaiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, "card2");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                SanPhamDialog dialog = new SanPhamDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel hinhAnhSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable pbSPTable;
    private javax.swing.JButton quayLaiBtn;
    public javax.swing.JTextField txtCamSau;
    public javax.swing.JTextField txtCamTruoc;
    public javax.swing.JTextField txtChipXuLy;
    public javax.swing.JTextField txtDungLuongPin;
    public javax.swing.JTextField txtHeDieuHanh;
    public javax.swing.JTextField txtKTMH;
    public javax.swing.JLabel txtTenSP;
    private javax.swing.JButton xemPBSPBtn;
    // End of variables declaration//GEN-END:variables
}
