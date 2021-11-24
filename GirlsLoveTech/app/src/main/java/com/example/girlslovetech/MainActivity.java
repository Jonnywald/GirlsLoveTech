package com.example.girlslovetech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Adapters.CursoAdapters;
import Adapters.AulaAdapters;
import models.Curso;
import models.Aula;
import services.ServiceAPI;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnLoginClick(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void btnCadastroClick(View view){
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }

    public void btnIndiqueClick(View view){
        Intent intent = new Intent(this, Mensagem.class);
        startActivity(intent);
    }



}