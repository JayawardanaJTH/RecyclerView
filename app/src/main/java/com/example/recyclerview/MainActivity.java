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
        mImageUrls.add("https://img.traveltriangle.com/blog/wp-content/tr:w-700,h-400/uploads/2015/06/Demodara-Nine-Arch-Bridge.jpg");
        mNames.add("Ella");
        mImageUrls.add("https://lh3.googleusercontent.com/proxy/HxAlAgbXR7a_nmUdDNmICxaRJ0gwTjlkoXbRnFpOM2JpsgyOrgaumvkqkfwGLO1apQL363UXpz_XXR0I7PAI8PtfPhwxhZx1bS4WznJnhfxG2F1O13USAuXgYERjvHNqVMgJvG4armWjNccDV-A6dvz90Ug9KloU1pf_83bHPcNsL6tAD39VoGOKLEwWSgXD0kT9eRu0fG7v_BIdd_r2vmjoskk");
        mNames.add("Kalutara");
        mImageUrls.add("https://traveltriangle.com/blog/wp-content/uploads/2017/08/1010.jpg");
        mNames.add("Colombo");
        mImageUrls.add("https://img.traveltriangle.com/blog/wp-content/tr:w-700,h-400/uploads/2019/12/Sri-Dalada-Maligawa_3rd-Dec.jpg");
        mNames.add("Kandy");
        mImageUrls.add("https://s27922.pcdn.co/wp-content/uploads/2016/07/srilankaeastcoast-6.jpg.optimal.jpg");
        mNames.add("Arugambe");
        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG,"initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        //ArrayAdapter is the class defined by manually, which is create recycler layout
        ArrayAdapter adapter = new ArrayAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
