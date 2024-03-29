package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainBai6 extends AppCompatActivity {

    Switch sw_bongden;

    ImageView image_bongden;
    ToggleButton tgb_bongden;
    LinearLayout ln_bongden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai6);
        setControl();
        setEvent();
    }

    private void setEvent() {
        sw_bongden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw_bongden.isChecked()){
                    ln_bongden.setVisibility(View.VISIBLE);
                    image_bongden.setImageResource(R.drawable.dentat);
                    tgb_bongden.setChecked(true);
                } else {
                    ln_bongden.setVisibility(View.GONE);
                    image_bongden.setImageResource(R.drawable.denmo);
                    tgb_bongden.setChecked(false);
                }
            }
        });

        tgb_bongden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgb_bongden.isChecked()){
                    image_bongden.setImageResource(R.drawable.dentat);
                } else {
                    image_bongden.setImageResource(R.drawable.denmo);
                }

            }
        });
    }

    private void setControl() {
        sw_bongden = findViewById(R.id.sw_bongden);
        image_bongden = findViewById(R.id.image_bongden);
        tgb_bongden = findViewById(R.id.tgb_bongden);
        ln_bongden = findViewById(R.id.ln_bongden);
    }
}