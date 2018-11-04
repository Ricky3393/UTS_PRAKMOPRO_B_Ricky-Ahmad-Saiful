package com.example.rickyahmad.ligagojek.model;

public class MainModel {
    private String nama, kota, deskTim;
    private int gambarTim;

    public MainModel(String nama, String kota, String deskTim, int gambarTim){
        this.nama = nama;
        this.kota = kota;
        this.deskTim = deskTim;
        this.gambarTim = gambarTim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getDeskTim() {
        return deskTim;
    }

    public void setDeskTim(String deskTim) {
        this.deskTim = deskTim;
    }

    public int getGambarTim() {
        return gambarTim;
    }

    public void setGambarTim(int gambarTim) {
        this.gambarTim = gambarTim;
    }
}
