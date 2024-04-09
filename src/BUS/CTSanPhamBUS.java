/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CTSanPhamDAO;
import DTO.CTSanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CTSanPhamBUS {
    
    private final CTSanPhamDAO ctspDAO = new CTSanPhamDAO();
    private ArrayList<CTSanPhamDTO> chiTietSPList = new ArrayList<CTSanPhamDTO>();
    
    public CTSanPhamBUS() {
        chiTietSPList = ctspDAO.getAll();
    }
    
    public ArrayList<CTSanPhamDTO> getAll() {
        return this.chiTietSPList;
    }
}