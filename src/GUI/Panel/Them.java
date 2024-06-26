/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Panel;

import GUI.Component.ThemItem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Them extends javax.swing.JPanel {

    ThemItem kmItem = new ThemItem("voucher.png", "Khuyến mãi");
    ThemItem thItem = new ThemItem("brand.png", "Thương hiệu");
    
    public Them() {
        initComponents();
        initComponentsCustom();
    }
    
    public void initComponentsCustom() {
        kmItem.setBounds(80, 44, 400, 154);
        add(kmItem);
        thItem.setBounds(548, 44, 400, 154);
        add(thItem);
    }
    
    public void mouseEnteringEvent(JPanel target) {
        target.setBackground(new Color(191, 216, 219));
        target.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public void mouseExitingEvent(JPanel target) {
        target.setBackground(new Color(238, 238, 238));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1028, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
