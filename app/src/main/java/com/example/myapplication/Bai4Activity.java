package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai4Activity extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    Button btnCong, btnTru, btnNhan, btnChia;
    TextView tvKq;
    String msg = "Thông tin" + "\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4);
        setControl();
    }

    public void PhepTinh (View view) {
        int a = Integer.parseInt(edt1.getText().toString());
        int b = Integer.parseInt(edt2.getText().toString());
        int c = Integer.parseInt(edt3.getText().toString());


        if (view.getId() == R.id.btn_cong){
            Toast.makeText(this, "Phep cong", Toast.LENGTH_SHORT).show();
            if (a + b == c) {
                msg+= "\n" + a + " + " + b +"= " + c + ": Dung"   ;
            } else {
                msg+= "\n" + a + " + " + b +"= " + c + ": Sai"   ;
            }
        }
        if (view.getId() == R.id.btn_tru){

            Toast.makeText(this, "Phep tru", Toast.LENGTH_SHORT).show();
            if (a - b == c) {
                msg+= "\n" + a + " - " + b +"= " + c + ": Dung"   ;
            } else {
                msg+= "\n" + a + " - " + b +"= " + c + ": Sai"   ;
            }

        }
        if (view.getId() == R.id.btn_nhan){
            Toast.makeText(this, "Phep nhan", Toast.LENGTH_SHORT).show();
            if (a * b == c) {
                msg+= "\n" + a + " * " + b +"= " + c + ": Dung"   ;
            } else {
                msg+= "\n" + a + " * " + b +"= " + c + ": Sai"   ;
            }
        }
        if (view.getId() == R.id.btn_chia){
            Toast.makeText(this, "Phep chia", Toast.LENGTH_SHORT).show();
            if (a / b == c) {
                msg+= "\n" + a + " / " + b +"= " + c + ": Dung"   ;
            } else {
                msg+= "\n" + a + " / " + b +"= " + c + ": Sai"   ;
            }
        }
        tvKq.setText(msg);
        tvKq.setTextSize(25);
        tvKq.setBackgroundColor(Color.GREEN);
    }
    private void setControl() {
        edt1 = findViewById(R.id.edt_first);
        edt2 = findViewById(R.id.edt_second);
        edt3 =findViewById(R.id.edt_result);
        btnCong  = findViewById(R.id.btn_cong);
        btnTru  = findViewById(R.id.btn_tru);
        btnNhan  = findViewById(R.id.btn_nhan);
        btnChia  = findViewById(R.id.btn_chia);
        tvKq = findViewById(R.id.tv_result_bai4);
    }
}