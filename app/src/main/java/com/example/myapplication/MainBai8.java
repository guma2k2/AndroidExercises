package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainBai8 extends AppCompatActivity {
    private SearchView sv_danhsach;
    private ListView lv_danhsach;

    private List<User> data = new ArrayList<>();

    private List<User> data_all = new ArrayList<>();
    CustomAdapterUser customAdapterUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai8);
        setControl();
        setEvent();
    }

    private void setEvent() {
        getData2();
        customAdapterUser = new CustomAdapterUser(this, R.layout.layout_item_user, data);
        lv_danhsach.setAdapter(customAdapterUser);
        sv_danhsach.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                data.clear();
                if (newText.equals("")) {
                    data.addAll(data_all);

                } else {
                    for (User user : data_all) {
                        if (user.getLogin().contains(newText)) {
                            data.add(user);
                        }
                    }
                }
                customAdapterUser.notifyDataSetChanged();
                return false;
            }
        });
    }
    private void getData2() {
        data.clear();
        String url = "http://api.github.com/search/users?q=vntalking";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest request =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String total = response.getString("total_count");
                    JSONArray jsonArray =  response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject object = jsonArray.getJSONObject(i);
                            User user = new User();
                            user.setLogin(object.getString("login"));
                            user.setUrl(object.getString("url"));
                            user.setAvatar_url(object.getString("avatar_url"));
                            data.add(user);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    customAdapterUser.notifyDataSetChanged();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("abc", error.getMessage());
                    }
                });
        requestQueue.add(request);
    }
    private void getData() {
        data.clear();
        data_all.clear();
        String url = "https://android-kotlin-fun-mars-server.appspot.com/photos";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject object = jsonArray.getJSONObject(i);
                                User user = new User();
                                user.setLogin(object.getString("id"));
                                user.setUrl(object.getString("img_src"));
                                user.setAvatar_url(object.getString("img_src"));
                                data.add(user);
                                data_all.add(user);
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        customAdapterUser.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(request);
    }

    void setControl() {
        sv_danhsach = findViewById(R.id.sv_danhsach);
        lv_danhsach = findViewById(R.id.lv_danhsach);
    }
}