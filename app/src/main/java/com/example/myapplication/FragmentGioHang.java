package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentGioHang extends Fragment {

    private List<Product> products = new ArrayList<>();
    ListView lv_bai6_giohang;
    CustomCartAdapter customCartAdapter;

    public FragmentGioHang(List<Product> products) {
        this.products = products;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gio_hang, container, false);
        setControl(view);
        customCartAdapter = new CustomCartAdapter(getContext(), R.layout.layout_item_giohang2, products);
        lv_bai6_giohang.setAdapter(customCartAdapter);
        return view;
    }

    private void setControl(View view) {
        lv_bai6_giohang = view.findViewById(R.id.lv_bai6_giohang);
    }

}