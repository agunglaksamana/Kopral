/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.servise;

import com.kopral.entity.Anggota;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author agung-pc
 */
public interface AnggotaServise {
    public void Save(Anggota anggota) throws SQLException;
    public void Edit(Anggota anggota)throws SQLException;
    public void Delete(String Kode)throws SQLException;
    public List<Anggota> GetAllAnggotas()throws SQLException;
    public List<Anggota> GetList(String Nama,String NoKtp)throws SQLException;
    
}
