/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.table;

import com.kopral.entity.Anggota;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung
 */
public class TableAnggota extends AbstractTableModel{
List<Anggota> list;

    public TableAnggota() {
    }

    public TableAnggota(List<Anggota> list) {
        this.list = list;
    }

@Override
    public String getColumnName(int column) {
    switch(column){
            case 0:
                return "No KTP";
            case 1:
                return "Kelompok/Desa";
            case 2:
                return "Nama Lengkap";
            case 3:
                return "Jumlah Pinjaman";
            case 4:
                return "Tanggal Cair Pinjaman";
            case 5:
                return "RT";
            case 6:
                return "RW";
            case 7:
                return "Dusun";
            case 8:
                return "Jabatan";
            case 9:
                return "No Hp";
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
        return  10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getNoktp();
            case 1:
                return list.get(rowIndex).getKelompokdesa();
            case 2:
                return list.get(rowIndex).getNamalengkap();
            case 3:
                return list.get(rowIndex).getPinjaman();
            case 4:
                return list.get(rowIndex).getTglpencarian();
                case 5:
                return list.get(rowIndex).getRt();
                case 6:
                return list.get(rowIndex).getRw();
            case 7:
                return list.get(rowIndex).getDusun();
            case 8:
                return list.get(rowIndex).getJabatan();
            case 9:
                return list.get(rowIndex).getNohp();
            default:
                return null;
        }
    }
    
     public void addkelompok(ArrayList<Anggota> anggotas) {
        this.list = anggotas;
        fireTableRowsInserted(0, getRowCount() - 1);
    }
}
