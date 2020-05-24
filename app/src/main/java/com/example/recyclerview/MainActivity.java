package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: started");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG,"initImageBitmaps: started");
        mImageUrls.add("https://lp-cms-production.imgix.net/2019-06/b4fbc706dab2a70a96588309ed268a1a-sri-lanka.jpeg");
        mNames.add("Seegiriya");
        mImageUrls.add("https://lp-cms-production.imgix.net/2019-06/b4fbc706dab2a70a96588309ed268a1a-sri-lanka.jpeg");
        mNames.add("Ella");
        mImageUrls.add("https://lp-cms-production.imgix.net/2019-06/b4fbc706dab2a70a96588309ed268a1a-sri-lanka.jpeg");
        mNames.add("Kalutara");
        mImageUrls.add("https://lp-cms-production.imgix.net/2019-06/b4fbc706dab2a70a96588309ed268a1a-sri-lanka.jpeg");
        mNames.add("Colombo");
        mImageUrls.add("https://lp-cms-production.imgix.net/2019-06/b4fbc706dab2a70a96588309ed268a1a-sri-lanka.jpeg");
        mNames.add("Kandy");
        mImageUrls.add("https://lp-cms-production.imgix.net/2019-06/b4fbc706dab2a70a96588309ed268a1a-sri-lanka.jpeg");
        mNames.add("Jaffna");
        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG,"initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ArrayAdapter adapter = new ArrayAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
