package com.example.girlslovetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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