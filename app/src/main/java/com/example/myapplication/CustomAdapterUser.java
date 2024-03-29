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

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapterUser extends ArrayAdapter  {
    Context context;
    int resource;
    List<User> data;

    public CustomAdapterUser(@NonNull Context context, int resource, List<User> data) {
        super(context, resource,data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView iv_user = convertView.findViewById(R.id.iv_user);
        TextView tv_login = convertView.findViewById(R.id.tv_login);
        TextView tv_url = convertView.findViewById(R.id.tv_url);
        User user = data.get(position);
        tv_login.setText(user.getLogin());
        tv_url.setText(user.getUrl());
        Picasso.get().load(user.getAvatar_url()).into(iv_user);
        Glide.with(context).load(user.getAvatar_url()).into(iv_user);
        return convertView;
    }
}
