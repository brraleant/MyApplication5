package com.example.myapplication.View;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Entity.AppDatabase;
import com.example.myapplication.Entity.DataSekolah;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private EditText eta, etb, etc, etd;
    private Button btna, btnb;
    private String set1, set2, set3, set4;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eta = findViewById(R.id.namasekolah);
        etb = findViewById(R.id.alamatsekolah);
        etc = findViewById(R.id.jumlahsiswa);
        etd = findViewById(R.id.jumlahguru);
        btna = findViewById(R.id.submit);
        btnb = findViewById(R.id.lihatdata);
        appDatabase = AppDatabase.iniDb(getApplicationContext());

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
                Intent x = new Intent(getApplicationContext(), RecylerVieww.class);
                startActivity(x);
            }
        });

        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), RecylerVieww.class);
                startActivity(x);
            }
        });
    }

    public void input(){
        set1 = eta.getText().toString();
        set2 = etb.getText().toString();
        set3 = etc.getText().toString();
        set4 = etd.getText().toString();
        final DataSekolah dataSekolah = new DataSekolah();
        dataSekolah.setNama_sekolah(set1);
        dataSekolah.setAlamat(set2);
        dataSekolah.setJml_siswa(set3);
        dataSekolah.setJml_guru(set4);
        new InsertData(appDatabase, dataSekolah).execute();
    }

    class InsertData extends AsyncTask<Void, Void, Long>{
        private AppDatabase database;
        private DataSekolah dataSekolah;

        public InsertData(AppDatabase database, DataSekolah dataSekolah){
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Long doInBackground(Void... voids){
            return database.dao().insertData(dataSekolah);
        }

        @Override
        protected void onPostExecute(Long aLong){
            super.onPostExecute(aLong);
            Toast.makeText(getApplicationContext(),"Success", Toast.LENGTH_SHORT).show();
        }
    }
}
