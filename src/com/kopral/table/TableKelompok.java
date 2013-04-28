/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.table;

import com.kopral.entity.Kelompok;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung-pc
 */
public class TableKelompok extends AbstractTableModel{

    List<Kelompok> list;

    public TableKelompok() {
    }

    public TableKelompok(List<Kelompok> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
    switch(column){
            case 0:
                return "Kode Kelompok";
            case 1:
                return "Nama Kelompok";
            case 2:
                return "Nama Desa";
            case 3:
                return "Tanggal Berdiri";
            case 4:
                return "Jumlah Pinjaman";
            case 5:
                return "Tanggal Cair Pinjaman";
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
        return  6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getKodekelompok();
            case 1:
                return list.get(rowIndex).getNamakelompok();
            case 2:
                return list.get(rowIndex).getNamadesa();
            case 3:
                return list.get(rowIndex).getTangalberdiri();
            case 4:
                return list.get(rowIndex).getJumlahpinjaman();
            case 5:
                return list.get(rowIndex).getTanggalcairpinjaman();
            default:
                return null;
        }
    }
    
     public void addkelompok(ArrayList<Kelompok> kelompoks) {
        this.list = kelompoks;
        fireTableRowsInserted(0, getRowCount() - 1);
    }
}
