/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.servise;

import com.kopral.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author agung-pc
 */
public interface UserServise {
    public void Save(User user) throws SQLException;
    public void Edit(User user)throws SQLException;
    public void Delete(String Kode)throws SQLException;
    public List<User> GetAllAnggotas()throws SQLException;
    public List<User> GetList(String Kode)throws SQLException;
    public User getbyuser(String users) throws SQLException;
}
