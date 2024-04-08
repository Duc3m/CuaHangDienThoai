/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import GUI.Component.ToolBarButton;
import GUI.Main;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KhachHang extends javax.swing.JPanel implements ActionListener{
    
    private final KhachHangBUS khBUS = new KhachHangBUS();
    private ArrayList<KhachHangDTO> khachHangList = khBUS.getAll();
    private Main main;
    
    private DefaultTableModel tableModel;
    ToolBarButton chiTietBtn = new ToolBarButton("Chi tiết", "toolBar_detail.svg", "detail");
    ToolBarButton themBtn = new ToolBarButton("Thêm", "toolBar_add.svg", "add");
    ToolBarButton suaBtn = new ToolBarButton("Sửa", "toolBar_edit.svg", "edit");
    ToolBarButton xoaBtn = new ToolBarButton("Xóa", "toolBar_delete.svg", "delete");
    /**
     * Creates new form KhachHang
     */
    public KhachHang(Main main) {
        initComponents();
        initComponentsCustom();
        this.main = main;
        loadDataToTable(khachHangList);
    }
    
    public void initComponentsCustom() {
        lamMoiBtn.setIcon(new FlatSVGIcon("./image/icon/toolBar_refresh.svg"));
        txtSearch.putClientProperty("JTextField.placeholderText", "Nhập nội dung muốn tìm kiếm...");
        txtSearch.putClientProperty("JTextField.showClearButton", true);
        toolBar.add(chiTietBtn);
        toolBar.add(themBtn);
        toolBar.add(suaBtn);
        toolBar.add(xoaBtn);
        chiTietBtn.addActionListener(this);
        themBtn.addActionListener(this);
        suaBtn.addActionListener(this);
        xoaBtn.addActionListener(this);
        khTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableModel = (DefaultTableModel) khTable.getModel();
    }
    
    public void loadDataToTable(ArrayList<KhachHangDTO> khList) {
        tableModel.setRowCount(0);
        for(KhachHangDTO i : khList) {
            tableModel.addRow(new Object[] {i.getId(), i.getHo(), i.getTen(), i.getSoDienThoai()});
        }
    }
    
    public int getSelectedRow() {
        int index = khTable.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(main, "Bạn chưa chọn sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return index;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lamMoiBtn = new javax.swing.JButton();
        toolBar = new javax.swing.JToolBar();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        khTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.BorderLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(1030, 100));
        topPanel.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(221, 221, 221)));

        txtSearch.setPreferredSize(new java.awt.Dimension(250, 44));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lamMoiBtn.setBackground(new java.awt.Color(255, 255, 255));
        lamMoiBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lamMoiBtn.setText("Làm mới");
        lamMoiBtn.setAlignmentY(0.0F);
        lamMoiBtn.setFocusPainted(false);
        lamMoiBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lamMoiBtn.setPreferredSize(new java.awt.Dimension(115, 44));
        lamMoiBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lamMoiBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lamMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lamMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        topPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        toolBar.setBackground(new java.awt.Color(238, 238, 238));
        toolBar.setRollover(true);
        toolBar.setPreferredSize(new java.awt.Dimension(400, 100));
        topPanel.add(toolBar, java.awt.BorderLayout.LINE_END);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        khTable.setAutoCreateRowSorter(true);
        khTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ", "Tên", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        khTable.setToolTipText("");
        khTable.setPreferredSize(new java.awt.Dimension(1030, 64));
        khTable.setRowHeight(32);
        khTable.setSelectionBackground(new java.awt.Color(190, 215, 220));
        khTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        khTable.setShowGrid(true);
        khTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(khTable);
        if (khTable.getColumnModel().getColumnCount() > 0) {
            khTable.getColumnModel().getColumn(0).setResizable(false);
            khTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            khTable.getColumnModel().getColumn(1).setResizable(false);
            khTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            khTable.getColumnModel().getColumn(2).setResizable(false);
            khTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            khTable.getColumnModel().getColumn(3).setResizable(false);
            khTable.getColumnModel().getColumn(3).setPreferredWidth(530);
        }

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchText = txtSearch.getText();
        loadDataToTable(khBUS.search(searchText));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void lamMoiBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lamMoiBtnMousePressed
        txtSearch.setText("");
        loadDataToTable(khachHangList);
    }//GEN-LAST:event_lamMoiBtnMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable khTable;
    private javax.swing.JButton lamMoiBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chiTietBtn) {            
//            int index = getSelectedRow();
//            if (index != -1) {
//                SanPhamDialog spDialog = new SanPhamDialog(main, true, "Chi tiết sản phẩm", sanPhamList.get(index));
//                spDialog.setVisible(true);
//            }
        }  
    }
    
}
