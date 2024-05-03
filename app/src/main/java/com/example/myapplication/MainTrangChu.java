package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
// Bai 6
public class MainTrangChu extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    public List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trang_chu);
        setControl();
        setEvent();
    }

    private void setEvent() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.mnDanhSach){
                    Fragment fragmentDanhSach = new FragmentDanhSach();
                    getSupportFragmentManager().beginTransaction().replace(R.id.flContent,fragmentDanhSach).commit();
                    drawerLayout.close();
                }
                if(item.getItemId() == R.id.mnCart){
                    Fragment fragment = new FragmentGioHang(products);
                    getSupportFragmentManager().beginTransaction().replace(R.id.flContent,fragment).commit();
                    drawerLayout.close();
                }
                if(item.getItemId() == R.id.mnLogout){
                    Toast.makeText(MainTrangChu.this, "Danh sach", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setControl() {
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if(item.getItemId() == R.id.mnDanhSach){
            Toast.makeText(MainTrangChu.this, "Danh sach", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.mnCart){
            Toast.makeText(MainTrangChu.this, "Danh sach", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId() == R.id.mnLogout){
            Toast.makeText(MainTrangChu.this, "Danh sach", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}