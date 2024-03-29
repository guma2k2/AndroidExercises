package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Buoi2Activity extends AppCompatActivity {

    EditText edtTd, edtNd;
    TextView tvTd, tvNd;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buoi2);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = "Thong tin";
                msg += "\nTieu de: " + edtTd.getText();
                msg += "\nNoi dung: " + edtNd.getText();
                Toast.makeText(Buoi2Activity.this, msg, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Buoi2Activity.this, Mainbai3Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("msg", "Hello");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        edtTd = findViewById(R.id.ed_td);
        edtNd = findViewById(R.id.ed_nd);
        tvTd = findViewById(R.id.tv_td);
        tvNd = findViewById(R.id.tv_nd);
        btnSend = findViewById(R.id.btn_send);
    }
}