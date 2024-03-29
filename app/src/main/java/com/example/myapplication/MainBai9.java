package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainBai9 extends AppCompatActivity {

    private EditText ed_bai9_thongbao, ed_bai9_tensp, ed_bai9_giasp;
    private Button btn_bai9_thongbao, btn_bai9_them;
    private ListView lvDanhSach;
    private List<Product> data = new ArrayList<>();

    private CustomAdapterDS adapterSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai9);
        setControl();
        setEvent();
    }

    private void setEvent() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        DatabaseReference sanPhams = database.getReference("savPhams");
        btn_bai9_thongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue(ed_bai9_thongbao.getText().toString());
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ed_bai9_thongbao.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        adapterSp = new CustomAdapterDS(this, R.layout.layout_item_sp, data);
        lvDanhSach.setAdapter(adapterSp);
        btn_bai9_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product sanPham = new Product();
                sanPham.setId(sanPhams.push().getKey());
                sanPham.setName(ed_bai9_tensp.getText().toString());
                sanPham.setPrice(ed_bai9_giasp.getText().toString());
                sanPham.setType("Samsung");
                sanPhams.child(sanPham.getId()).setValue(sanPham);

            }
        });

        sanPhams.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();
                for (DataSnapshot item: snapshot.getChildren()
                     ) {
                    Product product = item.getValue(Product.class);
                    data.add(product);
                }
                adapterSp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void setControl() {
        ed_bai9_thongbao = findViewById(R.id.ed_bai9_thongbao);
        btn_bai9_thongbao = findViewById(R.id.btn_bai9_thongbao);
        ed_bai9_tensp = findViewById(R.id.ed_bai9_tensp);
        ed_bai9_giasp = findViewById(R.id.ed_bai9_giasp);
        btn_bai9_them = findViewById(R.id.btn_bai9_them);
        lvDanhSach = findViewById(R.id.lv_bai9_danhsach);
    }
}