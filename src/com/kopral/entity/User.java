/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kopral.entity;

/**
 *
 * @author agung-pc
 */
public class User {
    private String kode;
    private String nama;
    private String username;
    private String password;
    private String jabatan;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    
}
