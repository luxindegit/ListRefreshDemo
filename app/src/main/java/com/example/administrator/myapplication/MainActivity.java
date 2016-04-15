package com.example.administrator.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.TimeUtils;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeRefreshFragmentFragment SwipeRefreshFragment = new SwipeRefreshFragmentFragment();
        FragmentManager FragmentManager = getSupportFragmentManager();
        FragmentManager.beginTransaction().replace(R.id.fragment, SwipeRefreshFragment).commit();
    }
}
