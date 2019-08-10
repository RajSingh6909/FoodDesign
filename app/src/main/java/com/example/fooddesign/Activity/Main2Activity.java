package com.example.fooddesign.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.fooddesign.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main2Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        recyclerView=findViewById(R.id.recycler);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        Call<Sector> sectorCall=ApiClient.getPostService().getSector(1);
//        sectorCall.enqueue(new Callback<Sector>() {
//            @Override
//            public void onResponse(Call<Sector> call, Response<Sector> response) {
//                //recyclerView.setAdapter(new SectorAdapter(Main2Activity.this,response.body().getSector()));
//            }
//            @Override
//            public void onFailure(Call<Sector> call, Throwable t) {
//            }
//        });
    }
}
