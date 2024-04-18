package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomCartAdapter extends ArrayAdapter  {
    Context context;
    int resource;
    List<Product> data;

    public CustomCartAdapter(@NonNull Context context, int resource, List<Product> data) {
        super(context, resource,data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        TextView tvNameItem = convertView.findViewById(R.id.tv_bai6_cart);
        Product product = data.get(position);
        tvNameItem.setText(product.toString());
        return convertView;
    }
}
