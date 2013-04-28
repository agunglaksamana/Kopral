/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.table;

import com.kopral.entity.Anggota;
import com.kopral.entity.Kelompok;
import com.kopral.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung-pc
 */
public class TableUsers extends AbstractTableModel{

    List<User> list;

    public TableUsers() {
    }

    public TableUsers(List<User> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
    switch(column){
            case 0:
                return "Kode";
            case 1:
                return "Nama Users";
            case 2:
                return "User Name";
            case 3:
                return "Password";
            case 4:
                return "Jabatan";
            default:
                return null;
        }
    }
   
    @Override
    public int getRowCount() {
        if(list == null){
            return 0;
        }else{
            return list.size();
        }
    }

    @Override
    public int getColumnCount() {
        return  5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getKode();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getUsername();
            case 3:
                return list.get(rowIndex).getPassword();
            case 4:
                return list.get(rowIndex).getJabatan();
            default:
                return null;
        }
    }
    
     public void addkelompok(ArrayList<User> users) {
        this.list = users;
        fireTableRowsInserted(0, getRowCount() - 1);
    }
    
}
