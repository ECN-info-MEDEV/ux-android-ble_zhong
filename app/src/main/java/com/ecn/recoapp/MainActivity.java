package com.ecn.recoapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button_mode);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, v);
                popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) MainActivity.this);
                popup.inflate(R.menu.menu_mode);
                popup.show();
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
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState");

    }

    public void launchSwipeActivity(View view) {
        Log.d(LOG_TAG, "Button clicked, redirected to SwipeActivity");
        Intent intent = new Intent(this, SwipeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "onActivityResult");
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        Button btn = (Button) findViewById(R.id.button_Recommandation);
        switch (item.getItemId()) {
            case R.id.film_mode:
                btn.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.book_mode:
                btn.setBackgroundColor(Color.RED);
                return true;
            case R.id.series_mode:
                btn.setBackgroundColor(Color.GREEN);
                return true;
            default:
                return false;
        }
    }
}