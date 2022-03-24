package com.ecn.recoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class SwipeActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    ArrayList<String> s;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        s=new ArrayList<String>();
        s.add("Harry Potter");
        s.add("Le seigneur des anneaux");
        s.add("Fin des recommandations");
        ArrayList<Integer> pic = new ArrayList<>();
        pic.add(R.drawable.harry);
        pic.add(R.drawable.seigneur);
        pic.add(R.drawable.empty);
        SwipeFlingAdapterView swipeFlingAdapterView=(SwipeFlingAdapterView) findViewById(R.id.card);
        findViewById(R.id.backcard).setBackgroundResource(pic.get(0));
        arrayAdapter= new ArrayAdapter<String>(this, R.layout.details,R.id.nomFilm,s);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener(){

            @Override
            public void removeFirstObjectInAdapter(){
                s.remove(0);
                pic.remove(0);

                if (pic.size()!=0) {
                    findViewById(R.id.backcard).setBackgroundResource(pic.get(0));
                    arrayAdapter.notifyDataSetChanged();
                }
                else {
                    findViewById(R.id.backcard).setVisibility(View.INVISIBLE);
                    findViewById(R.id.infos).setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void launchMainActivity(View view) {
        Log.d(LOG_TAG, "Button clicked, redirected to MainActivity");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void launchInfos(View view) {
        Toast.makeText(this, "Informations non disponnibles", Toast.LENGTH_SHORT).show();
    }
}