package com.example.myapplication.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
@Entity(tableName = "sekolah_db")
public class DataSekolah {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama_sekolah")
    private String nama_sekolah;

    @ColumnInfo(name = "alamat")
    private String alamat;

    @ColumnInfo(name = "jml_siswa")
    private String jml_siswa;

    @ColumnInfo(name = "jml_guru")
    private String jml_guru;

    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getNama_sekolah() {
        return nama_sekolah;
    }

    public void setNama_sekolah(String nama_sekolah) {
        this.nama_sekolah = nama_sekolah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJml_siswa() {
        return jml_siswa;
    }

    public void setJml_siswa(String jml_siswa) {
        this.jml_siswa = jml_siswa;
    }

    public String getJml_guru() {
        return jml_guru;
    }

    public void setJml_guru(String jml_guru) {
        this.jml_guru = jml_guru;
    }


}
