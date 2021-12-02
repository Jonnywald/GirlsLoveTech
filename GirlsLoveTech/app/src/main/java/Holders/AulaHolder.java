package Holders;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.girlslovetech.R;


public class AulaHolder extends RecyclerView.ViewHolder {


    public TextView txt_nome_aula;
    public WebView webView;


    public AulaHolder(View view) {
        super(view);

        txt_nome_aula = (TextView) view.findViewById(R.id.txt_nome_aula);
        webView = (WebView) view.findViewById(R.id.webView);

    }

}
