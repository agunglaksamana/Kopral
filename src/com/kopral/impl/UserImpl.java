/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.impl;

import com.kopral.databases.Databases;
import com.kopral.entity.User;
import com.kopral.servise.UserServise;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author agung-pc
 */
public class UserImpl implements UserServise{

    @Override
    public void Save(User user) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Insert Into "
                    + "users values (?,?,?,?,?)");
            ps.setString(1, user.getKode());
            ps.setString(2, user.getNama());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getJabatan());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kode Kelompok udah ada di databases");
        }
    }

    @Override
    public void Edit(User user) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("UPDATE users SET nama=?, username=?, password=?, jabatan=? WHERE kode=?");
            ps.setString(5, user.getKode());
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getJabatan());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kode Kelompok udah ada di databases");
        }
    }

    @Override
    public void Delete(String Kode) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Delete from users "
                    + "where kode=?");
            ps.setString(1, Kode);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Di Delete Master Barang");
        }
    }

    @Override
    public List<User> GetAllAnggotas() throws SQLException {
        Statement st = Databases.getkoneksi().createStatement();
        ResultSet rs = st.executeQuery("Select * from users order by kode asc");
        List<User> list = new ArrayList<>();
        while (rs.next()) {            
            User user = new User();
            user.setKode(rs.getString("kode"));
            user.setNama(rs.getString("nama"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setJabatan(rs.getString("jabatan"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> GetList(String Kode) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Select * from users "
                    + "where kode ilike ?");
            ps.setString(1, "%"+Kode+"%");
            ResultSet rs = ps.executeQuery();
           List<User> list = new ArrayList<>();
        while (rs.next()) {            
            User user = new User();
            user.setKode(rs.getString("kode"));
            user.setNama(rs.getString("nama"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setJabatan(rs.getString("jabatan"));
            list.add(user);
        }
        return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Di Pencarian Master Barang");
        }
        return null;
    }

    @Override
    public User getbyuser(String users) throws SQLException {
        try {
        PreparedStatement ps  = Databases.getkoneksi().prepareStatement("select * from users where username=?");
        ps.setString(1, users);
        ResultSet rs = ps.executeQuery();
        User pn = new User();
        if(rs.next()){
                pn.setKode(rs.getString("kode"));
                pn.setNama(rs.getString("nama"));
                pn.setUsername(rs.getString("username"));
                pn.setPassword(rs.getString("password"));
                pn.setJabatan(rs.getString("jabatan"));
                
        }
        return pn;
        } catch (Exception e) {
        }
    return null;
    }
    
    
}
