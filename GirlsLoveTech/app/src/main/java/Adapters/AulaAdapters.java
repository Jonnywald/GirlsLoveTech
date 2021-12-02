package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlslovetech.R;



import java.util.ArrayList;

import Holders.AulaHolder;
import Holders.CursoHolder;
import models.Aula;

public class AulaAdapters extends RecyclerView.Adapter<AulaHolder> {

    String api_key = "AIzaSyArq6dBqpPFMBkioNVCmn6SUbNxkLqnn6Y";

    private final ArrayList<Aula> aulas;

    public AulaAdapters(ArrayList<Aula> aulas) {
        this.aulas = aulas;
    }


    @NonNull
    @Override
    public AulaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AulaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_aula,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AulaHolder holder, int position) {
        holder.txt_nome_aula.setText(aulas.get(position).getNomeAula());
        holder.webView.setWebViewClient(new WebViewClient());
        holder.webView.getSettings().setJavaScriptEnabled(true);
        holder.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //holder.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        holder.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        holder.webView.setWebChromeClient(new WebChromeClient());
        holder.webView.loadUrl("https://youtu.be/"+aulas.get(position).getUrl());
                }

    @Override
    public int getItemCount() {
        return aulas != null ? aulas.size() : 0;
    }
}
