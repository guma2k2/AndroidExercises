package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainBai5 extends AppCompatActivity {

    EditText edtHoTen, edtCCCD;
    RadioButton rd_daihoc, rd_caodang, rd_trungcap;
    TextView tv_result_bai5;

    CheckBox cb_choigame, cb_docsach, cb_docbao;
    Button btn_dangky, btn_nhaplai, btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai5);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Thong tin";
                msg+="\n Ho ten:" + edtHoTen.getText().toString();
                msg+="\n CCCD:" + edtCCCD.getText().toString();
                if (rd_daihoc.isChecked()) {
                    msg+="\n Bang cap:" + rd_daihoc.getText().toString();
                }
                if (rd_caodang.isChecked()) {
                    msg+="\n Bang cap:" + rd_caodang.getText().toString();
                }

                if (rd_trungcap.isChecked()) {
                    msg+="\n Bang cap:" + rd_trungcap.getText().toString();
                }

                msg += "\n So thich: ";
                if (cb_choigame.isChecked()) {
                    msg += cb_choigame.getText().toString() + " ";
                }

                if (cb_docbao.isChecked()) {
                    msg += cb_docbao.getText().toString()+ " ";
                }

                if (cb_docsach.isChecked()) {
                    msg += cb_docsach.getText().toString()+ " ";
                }
                tv_result_bai5.setText(tv_result_bai5.getText().toString() + "\n" +msg + "\n");
                tv_result_bai5.setTextSize(25);
                tv_result_bai5.setBackgroundColor(Color.GREEN);

            }
        });

        btn_nhaplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHoTen.setText("");
                edtCCCD.setText("");
                rd_daihoc.setChecked(true);
                rd_caodang.setChecked(false);
                rd_trungcap.setChecked(false);
                cb_choigame.setChecked(false);
                cb_docbao.setChecked(false);
                cb_docsach.setChecked(false);
                tv_result_bai5.setText("");
                tv_result_bai5.setBackgroundColor(Color.WHITE);
                edtHoTen.requestFocus();
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setControl() {
        edtHoTen = findViewById(R.id.ed_hoten);
        edtCCCD = findViewById(R.id.ed_cccd);
        rd_daihoc = findViewById(R.id.rd_daihoc);
        rd_caodang = findViewById(R.id.rd_caodang);
        rd_trungcap = findViewById(R.id.rd_trungcap);
        cb_choigame = findViewById(R.id.cb_choigame);
        cb_docsach = findViewById(R.id.cb_docsach);
        cb_docbao = findViewById(R.id.cb_docbao);
        btn_dangky = findViewById(R.id.btn_dangky);
        btn_nhaplai = findViewById(R.id.btn_nhaplai1);
        btn_thoat = findViewById(R.id.btn_thoat);
        tv_result_bai5 =  findViewById(R.id.tv_result_bai5);

    }
}