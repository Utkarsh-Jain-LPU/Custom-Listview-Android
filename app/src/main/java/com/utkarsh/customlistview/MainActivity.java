package com.utkarsh.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);

        ArrayList<Example> arrayList = new ArrayList<>();

        for(int i=0;i<10;i++) {
            arrayList.add(new Example("Title-"+(i+1),"Description-"+(i+1)));
        }

        adapter adp = new adapter(MainActivity.this,arrayList);
        listView.setAdapter(adp);
    }
}
