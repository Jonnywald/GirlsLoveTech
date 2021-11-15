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

import Adapters.CursoAdapters;
import Adapters.AulaAdapters;
import models.Curso;
import models.Aula;
import services.ServiceApi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    ArrayList<Curso> listaCursos;
    RecyclerView recyclerCurso;
    CursoAdapter cursoAdapter;
    ArrayList<Aula> listaAulas;
    RecyclerView recyclerAula;
    AulaAdapter aulaAdapter;


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

    public void setupRecycleCurso(){
        //Configurando o layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCurso.setLayoutManager(layoutManager);

        // add adapter
        cursoAdapter = new CursoAdapters(listaCursos);
        recyclerCurso.setAdapter(cursoAdapters);

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
        dialog = ProgressDialog.show(MainActivity.this, "Aguarde", "Por favor aguarde...");

    }

    @Override
    protected String doInBackground(String... strings) {
        String data = ServiceApi.getService(strings[0], metodo, strings[1]);
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