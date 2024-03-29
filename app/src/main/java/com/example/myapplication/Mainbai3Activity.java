package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Mainbai3Activity extends AppCompatActivity {
    EditText tied_tk, tied_mk, tied_sdt, tied_email;
    Button btn_dangki, btn_nhaplai;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainbai3);
        setControl();
        setEvent();

    }

    private void setEvent() {

        btn_dangki.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String txtTaiKhoan = tied_tk.getText().toString().trim();
                String txtMatKhau = tied_mk.getText().toString().trim();
                String txtSdt = tied_sdt.getText().toString().trim();
                String txtEmail = tied_email.getText().toString().trim();
                String msg = "Thông tin";
                if (txtTaiKhoan.equals("")) {
                    Toast.makeText(Mainbai3Activity.this, "Bạn nhập tài khoản", Toast.LENGTH_SHORT).show();
                    tied_tk.setError("Nhập tài khoản");
                    tied_tk.requestFocus();
                    return;
                }

                if (txtMatKhau.equals("")) {
                    Toast.makeText(Mainbai3Activity.this, "Bạn nhập mật khẩu", Toast.LENGTH_SHORT).show();
                    tied_mk.setError("Nhập mật khẩu");
                    tied_mk.requestFocus();
                    return;
                }


                msg += "\nTài khoản: " + txtTaiKhoan;
                msg += "\nMật khẩu: " + txtMatKhau;
                msg += "\nSố điện thoại: " + txtSdt;
                msg += "\nEmail: " + txtEmail;

                tv_result.setText(msg);
                tv_result.setTextSize(25);
                tv_result.setBackgroundColor(Color.GREEN);

            }
        });

        btn_nhaplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tied_tk.setText("");
                tied_mk.setText("");
                tied_sdt.setText("");
                tied_email.setText("");
                tv_result.setText("");
                tv_result.setBackgroundColor(Color.WHITE);
                tied_tk.requestFocus();
            }
        });
    }

    private void setControl() {
        tied_tk = findViewById(R.id.tied_tk);
        tied_mk = findViewById(R.id.tied_mk);
        tied_sdt = findViewById(R.id.tied_sdt);
        tied_email = findViewById(R.id.tied_email);
        btn_dangki = findViewById(R.id.btn_dangki);
        btn_nhaplai = findViewById(R.id.btn_nhaplai);
        tv_result = findViewById(R.id.tv_result);
    }
}