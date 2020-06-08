/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlthuvien.dao;
import com.qlthuvien.model.PhieuNhap;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author son30
 */
public class PhieuNhapDao extends Dao {
    public List<PhieuNhap> GetPhieuNhap(){
        conn = JDBCConnection.getJDBCConnection();
        List<PhieuNhap> list = new ArrayList<PhieuNhap>();
        try {
            state = conn.createStatement();
            String sql = "Select * from PHIEUNHAP";
            rs = state.executeQuery(sql);
            while(rs.next()){
                String maPN = rs.getString("maPN");
                String ngaynhap = rs.getString("ngaynhap");
                String maNCC =rs.getString("maNCC");
                PhieuNhap pn = new PhieuNhap(maPN, ngaynhap, maNCC);
                list.add(pn);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            CloseAll();
        }
        return null;
    }
   
}
