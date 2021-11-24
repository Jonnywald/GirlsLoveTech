package com.example.girlslovetech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import Adapters.CursoAdapters;
import models.Curso;
import services.ServiceAPI;

public class Cursos extends AppCompatActivity {
    ProgressDialog dialog;
    ArrayList<Curso> listaCursos;
    RecyclerView recyclerCurso;
    CursoAdapters cursoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        recyclerCurso = findViewById(R.id.recyclerCurso);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new CursoAPI("GET").execute("course","");
    }

    public void btnAulas(View view) {
        Intent intent = new Intent(this, Aulas.class);
        startActivity(intent);
    }


    public void setupRecycleCurso(){
        //Configurando o layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCurso.setLayoutManager(layoutManager);

        // add adapter
        cursoAdapter = new CursoAdapters(listaCursos);
        recyclerCurso.setAdapter(cursoAdapter);

        //divisor entre linhas
        recyclerCurso.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    public class CursoAPI extends AsyncTask<String, String, String> {

        private String metodo;

        public CursoAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(Cursos.this, "Aguarde", "Por favor aguarde...");

        }

        @Override
        protected String doInBackground(String... strings) {
            String data = ServiceAPI.getService(strings[0], metodo, strings[1]);
            return data;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listaCursos = Curso.parseObject(s);
            setupRecycleCurso();
            dialog.dismiss();
        }

    }
}