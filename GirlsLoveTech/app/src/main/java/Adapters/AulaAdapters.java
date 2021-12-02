package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlslovetech.R;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


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
        holder.ytPlayer.initialize(api_key,
                new YouTubePlayer.OnInitializedListener() {
                    // Implement two methods by clicking on red
                    // error bulb inside onInitializationSuccess
                    // method add the video link or the playlist
                    // link that you want to play In here we
                    // also handle the play and pause
                    // functionality
                    @Override
                    public void onInitializationSuccess(
                            YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b)
                    {
                        youTubePlayer.loadVideo(aulas.get(position).getUrl());
                        youTubePlayer.play();
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                           // Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();

                    }
                });
                }

    @Override
    public int getItemCount() {
        return aulas != null ? aulas.size() : 0;
    }
}
