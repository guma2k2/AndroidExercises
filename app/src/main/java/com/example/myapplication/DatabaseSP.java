package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSP extends SQLiteOpenHelper {
    public DatabaseSP(@Nullable Context context) {
        super(context, "dbSanPham", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE dbSanPham (masp TEXT, tensp TEXT, giasp TEXT, loaisp TEXT)";
        db.execSQL(sql);
    }
    public void themDl(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Insert into tbSanPham values(?, ?, ?, ?)";
        db.execSQL(sql, new String[]{product.getId(), product.getName(), product.getPrice(), product.getType()});
    }
    public List<Product> docDL () {
      try {
          SQLiteDatabase db = getReadableDatabase();
          String sql = "Select * from tbSanPham";
          List<Product> data = new ArrayList<>();
          Cursor cursor = db.rawQuery(sql, null);
          if (cursor != null && cursor.moveToFirst()) {
              do {
                  Product product = new Product();
                  product.setId(cursor.getString(0));
                  product.setName(cursor.getString(1));
                  product.setPrice(cursor.getString(2));
                  product.setType(cursor.getString(3));
                  data.add(product);
              } while (cursor.moveToNext());
          }
          return data;
      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }
    }

    public void updateDl(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Update tbSanPham set tensp=?, giasp=?, loaisp=? where masp=?";
        db.execSQL(sql, new String[]{product.getName(), product.getPrice(), product.getType(), product.getId() });
    }

    public void deleteDl(Product product) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "Delete from  tbSanPham where masp = ?";
        db.execSQL(sql, new String[]{product.getId()});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
