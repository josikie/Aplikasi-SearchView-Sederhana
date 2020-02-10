package com.example.android.searchviewsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity  {

    private ArrayAdapter<String> stringArrayAdapter;
    private ArrayList<String> arrayList;
    private  ListView listView;
    private SearchView searchView;

    /**
     * variabel listName dengan tipe data array String
     */
    String[] listName = {"Josikie", "Yosia", "Shawn Mendez", "Ayudha", "Justin Bieber", "Alessia Cara", "Halsey", "Ariana Grande", "Dua Lipa", "Khalid", "Marshmellow", "Allan Walker", "BlackPink" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);

        arrayList = new ArrayList<>();

        for (int i = 0; i <listName.length; i++){
            arrayList.add(listName[i]);
        }
        /**
         * @variabel stringArrayAdapter untuk adapter yang akan mengatur tata letak ListView sederhana ini
         */
        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        // Menemukan listView menggunakan nama id
        listView = findViewById(R.id.listView);
        // setAdapter untuk listView
        listView.setAdapter(stringArrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                    stringArrayAdapter.getFilter().filter(s);
                return true;            }
        });

    }

}
