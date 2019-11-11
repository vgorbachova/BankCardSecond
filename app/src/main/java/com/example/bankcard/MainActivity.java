package com.example.bankcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainFragment.IMainFragment {

    LinearLayout rootView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = findViewById(R.id.root);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, MainFragment.newInstance().setListener(this))
                .commit();
    }

    @Override
    public void inItemClick(int position) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, DetailCardFragment.newInstance(position))
                .addToBackStack (null)
                .commit();
    }
}
