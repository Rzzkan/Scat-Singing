package com.rzzkan.scatsinging.activity;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.rzzkan.scatsinging.R;
import com.rzzkan.scatsinging.adapter.TheoryAdapter;
import com.rzzkan.scatsinging.fragment.theoryDefinition;
import com.rzzkan.scatsinging.model.Theory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EvaluationActivity extends AppCompatActivity {

    @BindView(R.id.theoryFrame)
    FrameLayout theoryFrame;

    private View parent_view;
    private RecyclerView recyclerView;
    private TheoryAdapter mAdapter;
    private ArrayList<Theory> theoryList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);
        ButterKnife.bind(this);
        parent_view = findViewById(android.R.id.content);
        getData();
        getSupportActionBar().setTitle("Evaluasi");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewTheory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mAdapter = new TheoryAdapter(this, theoryList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new TheoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Theory obj, int position) {
                intent = new Intent(EvaluationActivity.this, PlayerMusicAlbumSimple.class);
                Bundle b = new Bundle();
                switch(position) {
                    case 0:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 1); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 1:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 2); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 2:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 3); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 3:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 4); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 4:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 5); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 5:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 6); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 6:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 7); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    case 7:
                        b.putString("tag","evaluasi_");
                        b.putString("menu","Evaluasi");
                        b.putInt("file", 8); //Your id
                        intent.putExtras(b); //Put your id to your next Intent
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
        Glide.with(this).load(R.drawable.ornamen).fitCenter().into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    theoryFrame.setBackground(resource);
                }
            }
        });
    }

    private  void  getData(){
        theoryList = new ArrayList<>();
        for (int i = 1; i<9; i++){
           theoryList.add(new Theory(R.drawable.ic_launcher_background,"Scat "+i));
        }

    }


    public void changeFragment(Fragment replaceFragment, String tag) {
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.theoryFrame, replaceFragment);
        ft.commit();
    }

    public void onBackPressed(){
        finish();
    }
}
