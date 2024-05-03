package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainBai10 extends AppCompatActivity {


    EditText edt_bai10_tk, edt_bai10_mk;
    Button btn_bai10_dangnhap , btn_bai10_bieudo ;
    CheckBox cb_bai10_GhiMatKhau;
    PieChart piechart_bai10;

    int dung = 5;
    int tong = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai10);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btn_bai10_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tong+=1;
                String tk = edt_bai10_tk.getText().toString();
                String mk = edt_bai10_mk.getText().toString();
                if (tk.equals(mk)) {
                    dung+=1;
                    Toast.makeText(MainBai10.this, "Đăng nhập thành công", Toast.LENGTH_SHORT ).show();
                    if(cb_bai10_GhiMatKhau.isChecked()) {
                        ghiNhoMatKhau();
                    } else {
                        khongGhiMatKhau();
                    }
                }else {
                    Toast.makeText(MainBai10.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT ).show();
                }
            }
        });
        btn_bai10_bieudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hienThiBieuDo();
            }
        });
    }

    private void hienThiBieuDo() {
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        ArrayList<String> trangThai = new ArrayList<>();
        trangThai.add("Thành công");
        trangThai.add("Thất bại");
        pieEntries.add(new PieEntry(dung));
        pieEntries.add(new PieEntry(tong - dung));

        ArrayList<Integer> data_color = new ArrayList<>();
        data_color.add(Color.BLUE);
        data_color.add(Color.RED);
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "Dang nhap");
        pieDataSet.setColors(data_color);
        PieData pieData = new PieData(pieDataSet);
        piechart_bai10.setData(pieData);
        piechart_bai10.invalidate();
    }

    private void khongGhiMatKhau() {
        SharedPreferences sharedPreferences = getSharedPreferences("LuuTK", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    private void ghiNhoMatKhau() {
        SharedPreferences sharedPreferences = getSharedPreferences("LuuTK", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tk", edt_bai10_tk.getText().toString()     );
        editor.putString("mk", edt_bai10_mk.getText().toString()     );
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("LuuTK", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("tk", "");
        String password = sharedPreferences.getString("mk", "");
        edt_bai10_tk.setText(username);
        edt_bai10_mk.setText(password);
    }

    private void setControl() {
        btn_bai10_bieudo = findViewById(R.id.btn_bai10_bieudo);
        piechart_bai10 = findViewById(R.id.piechart_bai10);
        cb_bai10_GhiMatKhau = findViewById(R.id.cb_bai10_GhiMatKhau);
        edt_bai10_tk = findViewById(R.id.edt_bai10_tk);
        edt_bai10_mk = findViewById(R.id.edt_bai10_mk);
        btn_bai10_dangnhap = findViewById(R.id.btn_bai10_dangnhap);
    }
}