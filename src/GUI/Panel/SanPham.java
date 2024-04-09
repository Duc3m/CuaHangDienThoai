/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import GUI.Component.ToolBarButton;
import GUI.Dialog.SanPhamDialog;
import GUI.Dialog.ThemSanPhamDialog;
import GUI.Main;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SanPham extends javax.swing.JPanel implements ActionListener {
    
    private final SanPhamBUS spBUS = new SanPhamBUS();
    private ArrayList<SanPhamDTO> sanPhamList = spBUS.getAll();
    private Main main;
    
    private DefaultTableModel tableModel;
    ToolBarButton chiTietBtn = new ToolBarButton("Chi tiết", "toolBar_detail.svg", "detail");
    ToolBarButton themBtn = new ToolBarButton("Thêm", "toolBar_add.svg", "add");
    ToolBarButton suaBtn = new ToolBarButton("Sửa", "toolBar_edit.svg", "edit");
    ToolBarButton xoaBtn = new ToolBarButton("Xóa", "toolBar_delete.svg", "delete");
    /**
     * Creates new form SanPham
     */
    public SanPham(Main main) {
        initComponents();
        initComponentsCustom();
        this.main = main;
        loadDataToTable(sanPhamList);
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
        spTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableModel = (DefaultTableModel) spTable.getModel(); 
    }
    
    public void loadDataToTable(ArrayList<SanPhamDTO> spList) {
        tableModel.setRowCount(0);
        for(SanPhamDTO i : spList) {
            tableModel.addRow(new Object[]{i.getId(), i.getTen(), i.getKichThuocMan()+"\"", i.getCameraSau(), i.getCameraTruoc(), i.getChipXuLy(), i.getHeDieuHanh(), i.getDungLuongPin()+" mAh"});
        }
    }
    
    public int getSelectedRow() {
        int index = spTable.getSelectedRow();
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
        jPanel3 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        lamMoiBtn = new javax.swing.JButton();
        toolBar = new javax.swing.JToolBar();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        spTable = new javax.swing.JTable();

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lamMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lamMoiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        topPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        toolBar.setBackground(new java.awt.Color(238, 238, 238));
        toolBar.setRollover(true);
        toolBar.setPreferredSize(new java.awt.Dimension(400, 100));
        topPanel.add(toolBar, java.awt.BorderLayout.LINE_END);

        add(topPanel, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 620));

        spTable.setAutoCreateRowSorter(true);
        spTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Kích thước màn", "Camera sau", "Camera trước", "Chip xử lý", "Hệ điều hành", "Dung lượng pin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setRowHeight(32);
        spTable.setSelectionBackground(new java.awt.Color(190, 215, 220));
        spTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        spTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spTable.setShowGrid(true);
        spTable.getTableHeader().setResizingAllowed(false);
        spTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(spTable);
        if (spTable.getColumnModel().getColumnCount() > 0) {
            spTable.getColumnModel().getColumn(0).setResizable(false);
            spTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            spTable.getColumnModel().getColumn(1).setResizable(false);
            spTable.getColumnModel().getColumn(1).setPreferredWidth(140);
            spTable.getColumnModel().getColumn(2).setResizable(false);
            spTable.getColumnModel().getColumn(2).setPreferredWidth(40);
            spTable.getColumnModel().getColumn(3).setResizable(false);
            spTable.getColumnModel().getColumn(4).setResizable(false);
            spTable.getColumnModel().getColumn(5).setResizable(false);
            spTable.getColumnModel().getColumn(6).setResizable(false);
            spTable.getColumnModel().getColumn(6).setPreferredWidth(40);
            spTable.getColumnModel().getColumn(7).setResizable(false);
            spTable.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchText = txtSearch.getText();
        loadDataToTable(spBUS.search(searchText));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void lamMoiBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lamMoiBtnMousePressed
        txtSearch.setText("");
        loadDataToTable(sanPhamList);
    }//GEN-LAST:event_lamMoiBtnMousePressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lamMoiBtn;
    private javax.swing.JTable spTable;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chiTietBtn) {            
            int index = getSelectedRow();
            if (index != -1) {
                SanPhamDialog spDialog = new SanPhamDialog(main, true, "Chi tiết sản phẩm", sanPhamList.get(index));
                spDialog.setVisible(true);
            }
        }
        
        if(e.getSource() == themBtn) {
            ThemSanPhamDialog addSpDialog = new ThemSanPhamDialog(main, true, "Thêm sản phẩm");
            addSpDialog.setVisible(true);
        }
        
        if(e.getSource() == xoaBtn) {
            
        }
        
        if(e.getSource() == suaBtn) {
            
        }
    }
    
}
