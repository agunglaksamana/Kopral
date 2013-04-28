/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.impl;

import com.kopral.databases.Databases;
import com.kopral.entity.Anggota;
import com.kopral.servise.AnggotaServise;
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
public class AnggotaImpl implements AnggotaServise{

    @Override
    public void Save(Anggota anggota) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("INSERT INTO anggota VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, anggota.getNoktp());
            ps.setString(2, anggota.getKelompokdesa());
            ps.setString(3, anggota.getNamalengkap());
            ps.setLong(4, anggota.getPinjaman());
            ps.setDate(5, new java.sql.Date(anggota.getTglpencarian().getTime()));
            ps.setString(6, anggota.getRt());
            ps.setString(7, anggota.getRw());
            ps.setString(8, anggota.getDusun());
            ps.setString(9, anggota.getJabatan());
            ps.setLong(10, anggota.getNohp());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Simpan Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"");
        }
    }
 
    @Override
    public void Edit(Anggota anggota) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("INSERT INTO anggota VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(10, anggota.getNoktp());
            ps.setString(1, anggota.getKelompokdesa());
            ps.setString(2, anggota.getNamalengkap());
            ps.setLong(3, anggota.getPinjaman());
            ps.setDate(4, new java.sql.Date(anggota.getTglpencarian().getTime()));
            ps.setString(5, anggota.getRt());
            ps.setString(6, anggota.getRw());
            ps.setString(7, anggota.getDusun());
            ps.setString(8, anggota.getJabatan());
            ps.setLong(9, anggota.getNohp());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Edit Data Berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kode Anggota udah ada di databases");
        }
    }

    @Override
    public void Delete(String Kode) throws SQLException {
        try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Delete from anggota "
                    + "where noktp=?");
            ps.setString(1, Kode);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Di Delete");
        }
    }

    @Override
    public List<Anggota> GetAllAnggotas() throws SQLException {
        Statement st = Databases.getkoneksi().createStatement();
        ResultSet rs = st.executeQuery("Select * from anggota order by namalengkap asc");
        List<Anggota> list = new ArrayList<>();
        while (rs.next()) {            
            Anggota anggota = new Anggota();
            anggota.setNoktp(rs.getString("noktp"));
            anggota.setKelompokdesa(rs.getString("kelompokdesa"));
            anggota.setNamalengkap(rs.getString("namalengkap"));
            anggota.setPinjaman(rs.getLong("pinjaman"));
            anggota.setTglpencarian(rs.getDate("tglpinjaman"));
            anggota.setRt(rs.getString("rt"));
            anggota.setRw(rs.getString("rw"));
            anggota.setDusun(rs.getString("dusun"));
            anggota.setJabatan(rs.getString("jabatan"));
            anggota.setNohp(rs.getLong("nohp"));
            list.add(anggota);
        }
        return list;
    }

    @Override
    public List<Anggota> GetList(String Nama, String NoKtp) throws SQLException {
   try {
            PreparedStatement ps = Databases.getkoneksi().prepareStatement("Select * from anggota "
                    + "where namalengkap ilike ? or noktp ilike ? ");
            ps.setString(1, "%"+Nama+"%");
            ps.setString(2, "%"+NoKtp+"%");
            ResultSet rs = ps.executeQuery();
         List<Anggota> list = new ArrayList<>();
        while (rs.next()) {            
            Anggota anggota = new Anggota();
            anggota.setNoktp(rs.getString("noktp"));
            anggota.setKelompokdesa(rs.getString("kelompokdesa"));
            anggota.setNamalengkap(rs.getString("namalengkap"));
            anggota.setPinjaman(rs.getLong("pinjaman"));
            anggota.setTglpencarian(rs.getDate("tglpinjaman"));
            anggota.setRt(rs.getString("rt"));
            anggota.setRw(rs.getString("rw"));
            anggota.setDusun(rs.getString("dusun"));
            anggota.setJabatan(rs.getString("jabatan"));
            anggota.setNohp(rs.getLong("nohp"));
            list.add(anggota);
        }
        return list;
        } catch (SQLException e) {
           // JOptionPane.showMessageDialog(null, "Error Di Pencarian Master Barang");
        }
        return null;
    }
    
}
