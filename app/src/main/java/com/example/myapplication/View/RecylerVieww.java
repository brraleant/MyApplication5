package com.example.myapplication.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Adapter.Adapter;
import com.example.myapplication.Entity.AppDatabase;
import com.example.myapplication.Entity.DataSekolah;
import com.example.myapplication.Presenter.Presenter;
import com.example.myapplication.R;

import java.util.List;

public class RecylerVieww extends AppCompatActivity implements MainContact{
    private AppDatabase appDatabase;
    private Adapter adapter;
    private Presenter presenter;
    View view;
    RecyclerView recylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        presenter = new Presenter(this);
        recylerView = findViewById(R.id.rc);
        recylerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        appDatabase = AppDatabase.iniDb(getApplicationContext());
        readData(appDatabase);
    }

    public void readData(AppDatabase database) {
        List list;
        list = database.dao().getData();
        adapter = new Adapter(getApplicationContext(), list, this);
        recylerView.setAdapter(adapter);
    }
    
    @Override
    public void succeed(){
        Toast.makeText(getApplicationContext(), "Data Berhasil di hapus", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), RecylerVieww.class));
    }
    @Override
    public void deleteData(final DataSekolah item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Anda yakin ingin menghapus data ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // resetForm();
                        presenter.deleteData(item, appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

