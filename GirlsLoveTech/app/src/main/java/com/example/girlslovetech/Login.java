package com.example.girlslovetech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import services.ServiceAPI;

public class Login extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnLogin(View view) {
        Intent intent = new Intent(this, Cursos.class);
        startActivity(intent);
    }

    //@Override
   // protected void onResume() {
    //    super.onResume();
     //   new LoginAPI("GET").execute("user", "");

     //   SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
     //   SharedPreferences.Editor myEdit = sharedPreferences.edit();
     //   myEdit.putString("token", getText().toString());

      //  myEdit.commit();

      //  SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_APPEND);

      //  String s1 = sh.getString("token", "");
      //  token.setText(s1);

   // }


    public class LoginAPI extends AsyncTask<String, String, String> {

        private String metodo;

        public LoginAPI(String metodo) {
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(Login.this, "Aguarde", "Por favor aguarde...");

        }

        @Override
        protected String doInBackground(String... strings) {
            String data = ServiceAPI.getService(strings[0], metodo, strings[1]);
            return data;

        }

    }
}
