package com.example.girlslovetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mensagem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

    }


    public void btnEnviarClick(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Olha que legal o que eu encontrei! Um site com aulas gratuitas sobre programação! https://womancancode.herokuapp.com/");
        intent.setType("text/plain");
        startActivity(intent);
    }

}