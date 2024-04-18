package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentDanhSach extends Fragment {

    GridView gvDanhSach;
    CustomAdapter adapterSp;
    List<Product> data = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach, container, false);
        setControl(view);
      /*  initData();*/
        setEvent();
        return view;
    }

    private void setEvent() {
        DatabaseSP databaseSP = new DatabaseSP(getActivity());
        data.clear();
        data.addAll(databaseSP.docDL());
        adapterSp = new CustomAdapter(getContext(), R.layout.layout_item_sp2, data);
        gvDanhSach.setAdapter(adapterSp);
        gvDanhSach.setNumColumns(2);
    }

    private void setControl(View view) {
        gvDanhSach = view.findViewById(R.id.gv_trangtru_DanhSach);
    }
    private void initData() {
        DatabaseSP databaseSP = new DatabaseSP(getActivity());
        Product product1 = new Product();
        product1.setId("1");
        product1.setName("asa");
        product1.setType("Samsung");
        product1.setPrice("1000000");
        Product product2 = new Product();
        product2.setId("1");
        product2.setName("asa");
        product2.setType("Iphone");
        product2.setPrice("1000000");
        Product product3 = new Product();
        product3.setId("1");
        product3.setName("asa");
        product3.setType("Nokia");
        product3.setPrice("1000000");
        databaseSP.themDl(product1);
        databaseSP.themDl(product2);
        databaseSP.themDl(product3);
    }
}