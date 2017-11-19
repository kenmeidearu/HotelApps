package com.kenjin.hotelapp.model;

/**
 * Created by kenjin on 5/27/2016.
 */

public class Pesanan {
    private int id;
    private String nama;
    private String number;
    private String email;
    private String lamainap;

    public Pesanan() {
    }

    public Pesanan(int id, String nama,  String number, String email,String lamainap) {
        super();
        this.id = id;
        this.nama = nama;
        this.number = number;
        this.email = email;
        this.lamainap = lamainap;
    }

    public Pesanan(String nama, String number, String email, String lamainap) {
        super();
        this.nama = nama;
        this.number = number;
        this.email = email;
        this.lamainap = lamainap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getLamainap() {
        return lamainap;
    }

    public void setLamainap(String lamainap) {
        this.lamainap = lamainap;
    }

}