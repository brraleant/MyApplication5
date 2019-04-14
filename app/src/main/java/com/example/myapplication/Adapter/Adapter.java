package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Entity.DataSekolah;
import com.example.myapplication.R;
import com.example.myapplication.View.Edit_data;
import com.example.myapplication.View.MainContact;
import com.example.myapplication.View.RecylerVieww;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    List<DataSekolah> list;
    RecylerVieww view;
    public Adapter(Context context, List<DataSekolah> list, RecylerVieww view){
        this.view = view;
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.output, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DataSekolah data = list.get(i);
        viewHolder.tv1.setText(data.getJml_siswa());
        viewHolder.tv2.setText(data.getJml_guru());
        viewHolder.tv3.setText(data.getNama_sekolah());
        viewHolder.tv4.setText(data.getAlamat());
        viewHolder.btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.deleteData(data);
                // return true;
            }
        });
        viewHolder.btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(context, Edit_data.class);
                x.putExtra("jml_siswa", data.getJml_siswa());
                x.putExtra("jml_guru", data.getJml_guru());
                x.putExtra("nama", data.getNama_sekolah());
                x.putExtra("alamat", data.getAlamat());
                x.putExtra("id", data.getId());
                x.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(x);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3, tv4;
        Button btn_1, btn_2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.viewnamasekolah);
            tv2 = itemView.findViewById(R.id.viewalamatsekolah);
            tv3 = itemView.findViewById(R.id.viewjumlahsiswa);
            tv4 = itemView.findViewById(R.id.viewjumlahguru);
            btn_1 = itemView.findViewById(R.id.btn_hapus);
            btn_2 = itemView.findViewById(R.id.btn_edit);
        }
    }
}
