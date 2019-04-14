package com.example.myapplication.View;

import android.view.View;

import com.example.myapplication.Entity.AppDatabase;
import com.example.myapplication.Entity.DataSekolah;

import java.util.List;

public interface MainContact {
    void succeed();

    void deleteData(DataSekolah item);

    interface view extends View.OnClickListener{
        void resetForm();
        void succeed();
        void editData(DataSekolah item);
    }
    interface datapresenter{
        void editData(String nama_sekolah, String alamat, String jml_siswa, String jml_guru, int id, AppDatabase database);
        void deleteData(DataSekolah dataDiri, AppDatabase database);
    }
    interface Cetak extends View.OnClickListener{
        void getData(List<DataSekolah> list);
    }
    interface hapus{
        // void resetForm();
        void succeed();
        void deleteData(DataSekolah item);
    }
}
