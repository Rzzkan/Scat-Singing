package com.rzzkan.scatsinging.activity;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import com.rzzkan.scatsinging.R;
import com.rzzkan.scatsinging.adapter.GlossaryAdapter;
import com.rzzkan.scatsinging.model.Term;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GlossaryActivity extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;
    private GlossaryAdapter mAdapter;
    private ArrayList<Term> glossaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
        parent_view = findViewById(android.R.id.content);
        getData();
        getSupportActionBar().setTitle("Glosarium");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mAdapter = new GlossaryAdapter(this, glossaryList);
        recyclerView.setAdapter(mAdapter);
    }

//    private void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_menu);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Sectioned");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Tools.setSystemBarColor(this);
//    }

    private  void  getData(){
        glossaryList = new ArrayList<>();
        glossaryList.add(new Term("A","",true));
        glossaryList.add(new Term("Akord","kumpulan tiga nada atau lebih yang bila dimainkan secara bersamaan akan\n" +
                "terdengar harmonis",false));
        glossaryList.add(new Term("Artikulasi","sesuatu personal yang dirasakan dan dilakukan oleh seorang\n" +
                "musisi/penyanyi untuk melakukan sebuah improvisasi",false));

        glossaryList.add(new Term("C","",true));
        glossaryList.add(new Term("Crooning","Teknik bernyanyi ringan seperti berbicara",false));

        glossaryList.add(new Term("I","",true));
        glossaryList.add(new Term("Improvisasi","Proses oenggubahan lagu atau sajak dalam bernyanyi, bermain drama,\n" +
                "dan sebagainya tanpa persiapan (spontan)",false));

        glossaryList.add(new Term("J","",true));
        glossaryList.add(new Term("Jazz","Aliran musik yang berasal dari Amerika Serikat pada awal abad 20",false));

        glossaryList.add(new Term("S","",true));
        glossaryList.add(new Term("Swinging Feel","sesuatu personal yang dirasakan dan dilakukan oleh seorang\n" +
                "musisi/penyanyi untuk melakukan sebuah improvisasi",false));

        glossaryList.add(new Term("T","",true));
        glossaryList.add(new Term("Teknik Vokal","Cara memproduksi suara yang baik dan benar, sehingga suara yang\n" +
                "keluar terdengar jelas, indah, merdu, dan nyaring.",false));


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_setting, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
