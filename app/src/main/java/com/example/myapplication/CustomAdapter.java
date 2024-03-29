package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter  {
    Context context;
    int resource;
    List<Product> data;

    public CustomAdapter(@NonNull Context context, int resource, List<Product> data) {
        super(context, resource,data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView imvImageItem = convertView.findViewById(R.id.imv_imageItem);
        TextView tvNameItem = convertView.findViewById(R.id.tv_nameItem);
        Product product = data.get(position);
        tvNameItem.setText(product.getName());
        if (product.getType().equals("Samsung")){
            imvImageItem.setImageResource(R.drawable.samsung);
        }
        if (product.getType().equals("Iphone")){
            imvImageItem.setImageResource(R.drawable.iphone);
        }
        if (product.getType().equals("Nokia")){
            imvImageItem.setImageResource(R.drawable.nokia);
        }
        return convertView;
    }
}
