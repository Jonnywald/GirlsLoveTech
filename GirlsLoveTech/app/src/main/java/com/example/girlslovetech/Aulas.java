package com.example.girlslovetech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import java.util.ArrayList;

import Adapters.AulaAdapters;
import models.Aula;
import services.ServiceAPI;

public class Aulas extends AppCompatActivity {
    ProgressDialog dialog;
    int idCurso;
    ArrayList<Aula> listaAulas;
    RecyclerView recyclerAula;
    AulaAdapters aulaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aulas);
        recyclerAula = findViewById(R.id.recyclerAula);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent().hasExtra("id")) {
            idCurso = getIntent().getIntExtra("id",0);
            new Aulas.AulaAPI("GET").execute("lesson", "");

        }
    }

    public void setupRecycleAula(){
        //Configurando o layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerAula.setLayoutManager(layoutManager);

        // add adapter
        aulaAdapter = new AulaAdapters(listaAulas);
        recyclerAula.setAdapter(aulaAdapter);

        //divisor entre linhas
        recyclerAula.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }



    public class AulaAPI extends AsyncTask<String, String, String> {

        private String metodo;

        public AulaAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(Aulas.this, "Aguarde", "Por favor aguarde...");

        }

        @Override
        protected String doInBackground(String... strings) {
            String data = ServiceAPI.getService(strings[0], metodo, strings[1]);
            return data;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listaAulas = Aula.parseObject1(s, idCurso);
            setupRecycleAula();
            dialog.dismiss();
        }
    }
}