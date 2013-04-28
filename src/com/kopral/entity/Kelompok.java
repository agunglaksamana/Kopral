/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.entity;

import java.util.Date;

/**
 *
 * @author agung-pc
 */
public class Kelompok {
    private String kodekelompok;
    private String namakelompok;
    private String namadesa;
    private Date tangalberdiri;
    private Long jumlahpinjaman;
    private Date tanggalcairpinjaman;

    
    public String getNamadesa() {
        return namadesa;
    }

    public void setNamadesa(String namadesa) {
        this.namadesa = namadesa;
    }

    public String getKodekelompok() {
        return kodekelompok;
    }

    public void setKodekelompok(String kodekelompok) {
        this.kodekelompok = kodekelompok;
    }

    public String getNamakelompok() {
        return namakelompok;
    }

    public void setNamakelompok(String namakelompok) {
        this.namakelompok = namakelompok;
    }

    public Date getTangalberdiri() {
        return tangalberdiri;
    }

    public void setTangalberdiri(Date tangalberdiri) {
        this.tangalberdiri = tangalberdiri;
    }

    public Long getJumlahpinjaman() {
        return jumlahpinjaman;
    }

    public void setJumlahpinjaman(Long jumlahpinjaman) {
        this.jumlahpinjaman = jumlahpinjaman;
    }

    

    public Date getTanggalcairpinjaman() {
        return tanggalcairpinjaman;
    }

    public void setTanggalcairpinjaman(Date tanggalcairpinjaman) {
        this.tanggalcairpinjaman = tanggalcairpinjaman;
    }

    

    
    
    
}
