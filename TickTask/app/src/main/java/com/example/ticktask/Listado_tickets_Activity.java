package com.example.ticktask;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ticktask.databinding.ActivityListadoTicketsBinding;

public class Listado_tickets_Activity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityListadoTicketsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tickets);
    }
}