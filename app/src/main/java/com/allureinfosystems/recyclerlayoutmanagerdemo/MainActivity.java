package com.allureinfosystems.recyclerlayoutmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView list_item;
   // ArrayList<HashMap<String,String>> mydisplaydata = new ArrayList<>();
   ArrayList<Object> mydisplaydata = new ArrayList<>();
    myAdapter adapter;
    TextData textData ;
    Imagedata imagedata;

   // HashMap<String, String> hmap ;
    RecyclerView myRecycler;
    RecyclerView.LayoutManager layoutManager;


    String[] birds = {"Dove Bird","Macaw","Peacock"};

    String [] birds_image = {"bird","cow","how"};

    int [] adImage = {R.drawable.disneyland,R.drawable.disneyland,R.drawable.disneyland};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecycler = findViewById(R.id.myrecyclerview);

        for (int i = 0 ; i <birds.length;i++)
        {
            mydisplaydata.add(new TextData(birds[i],birds_image[i]));
            mydisplaydata.add(new Imagedata(adImage[i]));

        }




//        for (int i = 0 ; i <birds.length;i++)
//        {
//            hmap = new HashMap<String, String>();
//            hmap.put("bird",birds[i]);
//            hmap.put("image",birds_image[i]);
//            mydisplaydata.add(hmap);
//
//        }

        layoutManager = new LinearLayoutManager(this);
        adapter = new myAdapter(this,mydisplaydata);
        myRecycler.setLayoutManager(layoutManager);
        myRecycler.setAdapter(adapter);



    }


}
