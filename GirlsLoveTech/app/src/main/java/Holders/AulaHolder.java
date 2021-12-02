package Holders;

import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.girlslovetech.R;
import com.google.android.youtube.player.YouTubePlayerView;

public class AulaHolder extends RecyclerView.ViewHolder {


    public TextView txt_nome_aula;
    public YouTubePlayerView ytPlayer;


    public AulaHolder(View view) {
        super(view);

        txt_nome_aula = (TextView) view.findViewById(R.id.txt_nome_aula);
        ytPlayer = (YouTubePlayerView) view.findViewById(R.id.ytPlayer);

    }

}
