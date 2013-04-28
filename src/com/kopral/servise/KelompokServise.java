/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.servise;

import com.kopral.entity.Kelompok;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author agung-pc
 */
public interface KelompokServise {
    public void Save(Kelompok kelompok) throws SQLException;
    public void Edit(Kelompok kelompok)throws SQLException;
    public void Delete(String Kode)throws SQLException;
    public List<Kelompok> GetAllKelompoks()throws SQLException;
    public List<Kelompok> GetList(String Nama,String Desa)throws SQLException;
}
