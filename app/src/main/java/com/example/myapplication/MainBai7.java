package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainBai7 extends AppCompatActivity {

    EditText edt_masp, edt_tensp, edt_giasp;
    Button btn_add, btn_edit, btn_delete, btn_exist;
    Spinner type;
    ImageView imageView;
    ListView lvDanhSach;
    List<String> data_loaiSP = new ArrayList<>();
    ArrayAdapter  adapterLoaiSP;
    List<Product> data_products = new ArrayList<>();
    CustomAdapter adapter_sp;
    DatabaseSP data;

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai7);
        setControl();
        setEvent();
    }

    private void setEvent() {
        data = new DatabaseSP(this);
        Init();
        adapterLoaiSP = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_loaiSP);
        type.setAdapter(adapterLoaiSP);
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (type.getSelectedItem().toString() == "Samsung") {
                    imageView.setImageResource(R.drawable.samsung);
                } else if (type.getSelectedItem().toString() == "Iphone") {
                    imageView.setImageResource(R.drawable.iphone);
                } else {
                    imageView.setImageResource(R.drawable.nokia);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter_sp = new CustomAdapter(this,R.layout.layout_item_sp, data_products);
        lvDanhSach.setAdapter(adapter_sp);
        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = data_products.get(position);
                edt_masp.setText(product.getId());
                edt_tensp.setText(product.getName());
                edt_giasp.setText(product.getPrice());
                if(product.getType().equals("Samsung")) {
                    type.setSelection(0);
                } else if (product.getType().equals("Samsung")) {
                    type.setSelection(1);
                } else {
                    type.setSelection(2);
                }
                index = position;
            }
        });

    }
    public void Action (View view) {
        String id = edt_masp.getText().toString();
        String name = edt_tensp.getText().toString();
        String price = edt_giasp.getText().toString();
        if (view.getId() == R.id.btn_add){
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setType(type.getSelectedItem().toString());
            product.setPrice(price);
//            data_products.add(product);
//            adapter_sp.notifyDataSetChanged();
            data.themDl(product);
            DocDl();
        }
        if (view.getId() == R.id.btn_edit){
           Product product = data_products.get(index);
            product.setId(id);
            product.setName(name);
            product.setType(type.getSelectedItem().toString());
            product.setPrice(price);
            data.updateDl(product);
            DocDl();
        }
        if (view.getId() == R.id.btn_delete){
            /*data_products.remove(index);
            adapter_sp.notifyDataSetChanged();*/
            Product product = data_products.get(index);
            data.deleteDl(product);
            DocDl();
        }
        if (view.getId() == R.id.btn_exist){
            finish();
        }
    }

    private void Init() {
        data_loaiSP.add("Samsung");
        data_loaiSP.add("Iphone");
        data_loaiSP.add("Nokia");
    }

    @Override
    protected void onResume() {
        super.onResume();
        DocDl();
    }
    public void DocDl () {
        try {
            data_products.clear();
            data_products.addAll(data.docDL());
            adapter_sp.notifyDataSetChanged();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setControl() {
        type = findViewById(R.id.spinner_loaisp);
        edt_masp = findViewById(R.id.edt_masp);
        edt_tensp = findViewById(R.id.edt_tensp);
        edt_giasp = findViewById(R.id.edt_giasp);
        btn_add = findViewById(R.id.btn_add);
        btn_edit = findViewById(R.id.btn_edit);
        btn_delete = findViewById(R.id.btn_delete);
        btn_exist = findViewById(R.id.btn_exist);
        imageView = findViewById(R.id.imv_item);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}