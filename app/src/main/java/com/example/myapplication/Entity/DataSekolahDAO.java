package com.example.myapplication.Entity;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface DataSekolahDAO {
    @Insert
    long insertData(DataSekolah dataSekolah);

    @Query("Select * from sekolah_db")
    List<DataSekolah> getData();

    @Update
    int updateData(DataSekolah item);

    @Delete
    void deleteData(DataSekolah item);
}
