/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.impl;

import com.kopral.databases.Databases;
import com.kopral.entity.Kelompok;
import com.kopral.servise.KelompokServise;
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
public class KelompokImpl implements KelompokServise{

    @Override
    public void Save(Kelompok kelompok) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Insert Into "
                    + "kelompok values (?,?,?,?,?,?)");
            ps.setString(1, kelompok.getKodekelompok());
            ps.setString(2, kelompok.getNamakelompok());
            ps.setString(3, kelompok.getNamadesa());
            ps.setDate(4, new java.sql.Date(kelompok.getTangalberdiri().getTime()));
            ps.setLong(5, kelompok.getJumlahpinjaman());
            ps.setDate(6, new java.sql.Date(kelompok.getTanggalcairpinjaman().getTime()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Simpan Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kode Kelompok udah ada di databases");
        }
    }

    @Override
    public void Edit(Kelompok kelompok) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("UPDATE kelompok SET namakelompok=?, namadesa=?, tangalberdiri=?, jumlahpinjaman=?, tanggalcairpinjaman=? WHERE kodekelompok=?");
            ps.setString(6, kelompok.getKodekelompok());
            ps.setString(1, kelompok.getNamakelompok());
            ps.setString(2, kelompok.getNamadesa());
            ps.setDate(3, new java.sql.Date(kelompok.getTangalberdiri().getTime()));
            ps.setLong(4, kelompok.getJumlahpinjaman());
            ps.setDate(5, new java.sql.Date(kelompok.getTanggalcairpinjaman().getTime()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Di Insert Kelompok");
        }
        
    }

    @Override
    public void Delete(String Kode) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Delete from kelompok "
                    + "where kodekelompok=?");
            ps.setString(1, Kode);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Di Delete Master Barang");
        }
    }

    @Override
    public List<Kelompok> GetAllKelompoks() throws SQLException {
        Statement st = Databases.getkoneksi().createStatement();
        ResultSet rs = st.executeQuery("Select * from kelompok order by namakelompok asc");
        List<Kelompok> list = new ArrayList<>();
        while (rs.next()) {            
            Kelompok kelompok = new Kelompok();
            kelompok.setKodekelompok(rs.getString("kodekelompok"));
            kelompok.setNamakelompok(rs.getString("namakelompok"));
            kelompok.setNamadesa(rs.getString("namadesa"));
            kelompok.setTangalberdiri(rs.getDate("tangalberdiri"));
            kelompok.setJumlahpinjaman(rs.getLong("jumlahpinjaman"));
            kelompok.setTanggalcairpinjaman(rs.getDate("tanggalcairpinjaman"));
            list.add(kelompok);
        }
        return list;
    }

    @Override
    public List<Kelompok> GetList(String Nama, String Desa) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Select * from kelompok "
                    + "where namakelompok ilike ? or namadesa ilike ? ");
            ps.setString(1, "%"+Desa+"%");
            ps.setString(2, "%"+Nama+"%");
            ResultSet rs = ps.executeQuery();
            List<Kelompok> list = new ArrayList<>();
            while (rs.next()) {                
            Kelompok m = new Kelompok();
            m.setNamadesa(rs.getString("namadesa"));
            m.setKodekelompok(rs.getString("kodekelompok"));
            m.setNamakelompok(rs.getString("namakelompok"));
            m.setTangalberdiri(rs.getDate("tangalberdiri"));
            m.setJumlahpinjaman(rs.getLong("jumlahpinjaman"));
            m.setTanggalcairpinjaman(rs.getDate("tanggalcairpinjaman"));
            list.add(m);
        }
        return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Di Pencarian Master Barang");
        }
        return null;
    }
    
}
