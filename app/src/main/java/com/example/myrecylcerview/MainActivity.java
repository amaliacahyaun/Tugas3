package com.example.myrecylcerview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);
    }
    private ArrayList<Model> getMyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setNama("Brunei Darussalam");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.brunei);
        models.add(m);

        m = new Model();
        m.setNama("Filipina");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.filipina);
        models.add(m);

        m = new Model();
        m.setNama("Indonesia");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.indo);
        models.add(m);

        m = new Model();
        m.setNama("Kamboja");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.kamboja);
        models.add(m);

        m = new Model();
        m.setNama("Laos");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.laos);
        models.add(m);

        m = new Model();
        m.setNama("Malaysia");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.malay);

        models.add(m);
        m = new Model();
        m.setNama("Myammar");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.mymam);
        models.add(m);

        m = new Model();
        m.setNama("Singapura");
        m.setDetail("DETAIL");
        m.setImg(R.drawable.singapura);
        models.add(m);

        return models;
    }
}