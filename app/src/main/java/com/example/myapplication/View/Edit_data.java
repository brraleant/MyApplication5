package com.example.myapplication.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Entity.AppDatabase;
import com.example.myapplication.Entity.DataSekolah;
import com.example.myapplication.Presenter.Presenter;
import com.example.myapplication.R;

public abstract class Edit_data extends AppCompatActivity implements MainContact.view{
    private AppDatabase appDatabase;
    private Presenter presenter;
    private Adapter adapter;
    private EditText et1, et2, et3, et4;
    private Button btn1;
    private String set1, set2, set3, set4;
    private boolean edit = false;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        et1 = findViewById(R.id.et_namsek);
        et2 = findViewById(R.id.et_alamsek);
        et3 = findViewById(R.id.et_jumsis);
        et4 = findViewById(R.id.et_jumgur);
        btn1 = findViewById(R.id.btn_submit);
        presenter = new Presenter(this);
        appDatabase = AppDatabase.iniDb(getApplicationContext());
        set1 = getIntent().getStringExtra("nama");
        set2 = getIntent().getStringExtra("alamat");
        set3 = getIntent().getStringExtra("jml_siswa");
        set4 = getIntent().getStringExtra("jml_guru");
        id = getIntent().getIntExtra("id", 10);
        et1.setText(set1);
        et2.setText(set2);
        et3.setText(set3);
        et4.setText(set4);
        btn1.setOnClickListener(this);

    }

    @Override
    public void resetForm(){
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        btn1.setText("Submit");
    }

    @Override
    public void succeed(){
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), RecylerVieww.class));
    }

    @Override
    public void editData(DataSekolah item){
        et1.setText(item.getNama_sekolah());
        et2.setText(item.getAlamat());
        et3.setText(item.getJml_siswa());
        et4.setText(item.getJml_guru());
        edit = true;
        btn1.setText("Update");
    }

    @Override
    public void onClick(View v){
        String namsek,alamsek,jumsis,jumgur;
        namsek = et1.getText().toString();
        alamsek = et2.getText().toString();
        jumsis = et3.getText().toString();
        jumgur = et4.getText().toString();

        if (v == btn1){
            if (namsek.equals("") || alamsek.equals("") || jumsis.equals("") || jumgur.equals("")){
                Toast.makeText(this, "Isi semua data terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                presenter.editData(namsek,alamsek,jumsis,jumgur, id, appDatabase);
                edit = false;
            }
            resetForm();
        }
    }
}
