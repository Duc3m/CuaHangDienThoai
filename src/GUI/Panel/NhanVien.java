/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.NhanVienBUS;
import DTO.NhanVienDTO;
import GUI.Component.ToolBarButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanVien extends javax.swing.JPanel {

    private DefaultTableModel model;
    private final NhanVienBUS nvBUS = new NhanVienBUS();
    private ArrayList<NhanVienDTO> nhanVienList = nvBUS.getAll();
    
    ToolBarButton chiTietBtn = new ToolBarButton("Chi tiết", "toolBar_detail.svg", "detail");
    ToolBarButton themBtn = new ToolBarButton("Thêm", "toolBar_add.svg", "add");
    ToolBarButton suaBtn = new ToolBarButton("Sửa", "toolBar_edit.svg", "edit");
    ToolBarButton xoaBtn = new ToolBarButton("Xóa", "toolBar_delete.svg", "delete");
    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        
        txtSearch.putClientProperty("JTextField.placeholderText", "Nhập nội dung muốn tìm kiếm...");
        txtSearch.putClientProperty("JTextField.showClearButton", true);
        
        toolBar.add(chiTietBtn);
        toolBar.add(themBtn);
        toolBar.add(suaBtn);
        toolBar.add(xoaBtn);
        
        nvTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        model = (DefaultTableModel) nvTable.getModel();
        loadDataToTable(this.nhanVienList);
    }
    
    public void loadDataToTable(ArrayList<NhanVienDTO> nvList){
        model.setRowCount(0);
        for(NhanVienDTO i : nvList){
            model.addRow(new Object[] {i.getId(), i.getHo(), i.getTen(), i.getGioiTinh(), i.getSoDienThoai(), i.getEmail(), i.getChucVu()});
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

        topPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        toolBar = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nvTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1030, 720));
        setLayout(new java.awt.BorderLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(1030, 100));
        topPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(238, 238, 238));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(221, 221, 221)));

        txtSearch.setPreferredSize(new java.awt.Dimension(250, 44));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        topPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        toolBar.setBackground(new java.awt.Color(238, 238, 238));
        toolBar.setRollover(true);
        toolBar.setPreferredSize(new java.awt.Dimension(400, 100));
        topPanel.add(toolBar, java.awt.BorderLayout.LINE_END);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 620));

        nvTable.setAutoCreateRowSorter(true);
        nvTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ", "Tên", "Giới tính", "Số điện thoại", "Email", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nvTable.setRowHeight(32);
        nvTable.setSelectionBackground(new java.awt.Color(190, 215, 220));
        nvTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        nvTable.setShowGrid(true);
        nvTable.getTableHeader().setResizingAllowed(false);
        nvTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(nvTable);
        if (nvTable.getColumnModel().getColumnCount() > 0) {
            nvTable.getColumnModel().getColumn(0).setResizable(false);
            nvTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            nvTable.getColumnModel().getColumn(1).setResizable(false);
            nvTable.getColumnModel().getColumn(1).setPreferredWidth(160);
            nvTable.getColumnModel().getColumn(2).setResizable(false);
            nvTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            nvTable.getColumnModel().getColumn(3).setResizable(false);
            nvTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            nvTable.getColumnModel().getColumn(4).setResizable(false);
            nvTable.getColumnModel().getColumn(4).setPreferredWidth(170);
            nvTable.getColumnModel().getColumn(5).setResizable(false);
            nvTable.getColumnModel().getColumn(5).setPreferredWidth(250);
            nvTable.getColumnModel().getColumn(6).setResizable(false);
            nvTable.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchText = txtSearch.getText();
        loadDataToTable(nvBUS.search(searchText));
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable nvTable;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
