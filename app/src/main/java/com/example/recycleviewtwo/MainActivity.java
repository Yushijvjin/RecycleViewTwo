package com.example.recycleviewtwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;

    private ArrayList<String> slist=new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        initData();
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(slist, this);

        recycleView.setAdapter(myAdapter);

        itemClick();


    }

    private void itemClick() {
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                Toast.makeText(MainActivity.this,"点击了"+slist.get(position),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClickListener(View view, int position) {
                Toast.makeText(MainActivity.this,"长按了了"+slist.get(position),Toast.LENGTH_SHORT).show();


            }
        });



    }

    private void initData() {

        for (int i = 0; i <20 ; i++) {
            slist.add("面朝大海，春暖花开"+i);
        }

    }
}
